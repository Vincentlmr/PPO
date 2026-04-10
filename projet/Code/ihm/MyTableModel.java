package ihm;
import lib.*;
import exceptions.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

// Class pour etablir la connexion entre la JTable graphique et un modele de donnees.
// Pour nous le modele de donnees sera une grille du noyau de representation et de calcul
// construite et sauvegardee par serialisation comme precedemmment.
// Dans ce prototype exemple, le modele de donnees est une simple matrice de String "en dur".
// Il faudra le remplacer par une connexion a une telle grille.
class MyTableModel extends AbstractTableModel {

    // TODO
    // remplacer ce tableau en dur du prototype par la grille serialisee:
    // noyau.Grille calc;
     

    Grille gril; 
    String[][] calc;

    MyTableModel(Grille g) {
        super();
        gril=g;
        calc = new String[this.getRowCount()][this.getColumnCount()];
        for (int ligne =0; ligne < calc.length; ligne++) {
            for (int colonne=0; colonne < calc[ligne].length; colonne++) {
                calc[ligne][colonne] = "";
            }

        }
    }

    @Override
    // Standard: doit retourner le nbre de colonnes de la JTable
    public int getColumnCount() {
        // TODO: remplacer par le nbre de colonnes de la grille
        // + 1 pour la colonne 0 consacrée aux numeros de ligne)
        return 27;
    }

    @Override
    // Standard: doit retourner le nbre de lignes de la JTable
    public int getRowCount() {
        // TODO: remplacer par le nbre de lignes de la grille
        return 26;
    }

    // Standard: doit renvoyer le nom de la colonne a afficher en tete
    @Override
    public String getColumnName(int col) {
        if (col == 0) {
            return ""; // colonne consacrée aux numeros de ligne
        } else {
            return "" + (char) ((int) ('A') + col - 1);
        }
    }

    // Utilitaire interne fourni (ne rien changer)
    // Retourne le nom d'une case a partir de ses coordonnees dans la JTable.
    String getNomCase(int row, int col) {
        return this.getColumnName(col) + String.valueOf(row + 1); // row commence a 0
    }

    @Override
    // Standard: doit renvoyer le contenu a afficher de la case correspondante
    public Object getValueAt(int row, int col) {
        if (col == 0) {
            // Fourni: ne rien changer.
            // en colonne 0 : numeros de lignes
            return "" + String.valueOf(row + 1);
        } else {
            
            List<Case> cas = new ArrayList<Case>(gril.getCases());
            
            for(int i=0; i<cas.size();i++){
                int colcase=convertStringInt(cas.get(i).getColonne())+1; // on ajoute 1 pour que la colonne A corresponde à la colonne 1 dans la feuille de calcul
                //recherche si la case a une correspondance dans la grille
                if(cas.get(i).getLigne()-1==row && colcase==col){
                    calc[row][col]=cas.get(i).getContenu();
                }
            }
            return "" + calc[row][col];
        }
    }
    
    //conversion des String en int
    public static int convertStringInt(String m) {
        int i = 0;
        int k;
        for (int j = 0; j < m.length(); j += 1) {
            k = m.charAt(j) - 'A';
            if (j == m.length() -1) {
                i = i*26 + k ;
            } else {
                i = i*26 + (k+1);
            }
        }
        return i;
    }
    
    // Standard.
    // Fourni: ne rien changer.
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    // Standard: determine si une case est editable ou non.
    // Seules les cases de la 1er colonne ne le sont pas
    // (consacrees a la numerotation des lignes)
    // Modifier pour que les cases avec des formules ne soient pas editable
    @Override
    public boolean isCellEditable(int row, int col) {
        if (col < 1) {
            return false; // col 0 consacree a la numerotation des lignes (non editable)
        } 
        else {
            int bool=1;
            List<Case> cas = new ArrayList<Case>(gril.getCases());
            for(int i=0; i<cas.size();i++){
                int colcase=convertStringInt(cas.get(i).getColonne())+1;
        
                if(cas.get(i).getLigne()-1==row && colcase==col){
                    //si la case existe et n'est pas une formule, on peut donc la modifier
                    if(cas.get(i).estFormule()==false){
                        bool=0;
                    }
                }
            }
            //cas ou la case n'existe pas dans la grille, ou contient une formule 
            if(bool==1){
                return false;
            }
            //cas ou la case existe et ne contient pas de formule
            else{
                return true;
            }
        }
    }
    
    //conversion des int en String
    public static String convertIntString(int i) {
        String out = String.valueOf((char)((i % 26)  + 65));
        if (i>=26) {
            out = convertIntString(i/26) + out;
        }
        return out;
    }

    // Standard: l'utilisateur a entré une valeur dans une case,
    // mettre a jour le modèle de donnees connecte.
    // L'utilisateur a modifie une case.
    // Si c'est une valeur numerique (sinon ne rien faire)
    // - modifier la case correspondante dans la grille si cette case existe
    // - ajouter la case correspondante dans la grille
    @Override
    public void setValueAt(Object value, int row, int col){

        // TODO remplacer par le code correspondant
        if (value instanceof String) {
            List<Case> cas = new ArrayList<Case>(gril.getCases());
            calc[row][col] = (String) value;
            
            for(int i=0; i<cas.size();i++){
                String colcase=convertIntString(col-1);
                if(cas.get(i).getLigne()-1==row && cas.get(i).getColonne().equals(colcase)){
                    try{
                        gril.ajouterValeur(cas.get(i),Double.parseDouble((String) value));
                    }catch (CaseInconnueException cie){
                         System.err.println("Erreur: " + cie.getMessage());
                    }catch ( DivisionParZeroException dpze){
                         System.err.println("Erreur: " + dpze.getMessage());
                    }catch ( OperateurInconnuException oie){
                         System.err.println("Erreur: " + oie.getMessage());
                    }catch ( CycleException ce){
                         System.err.println("Erreur: " + ce.getMessage());
                    }
                    
                    
                }
            }
        }
        // Ne pas modifier :
        // mise a jour automatique de l'affichage suite a la modification
        for(int i=0; i<27;i++){
            for(int j=1; j<28; j++){
                fireTableCellUpdated(i, j);
            }
        }
    }
}
