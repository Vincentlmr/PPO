package lib;
import exceptions.*;
import java.util.*;
import java.io.*;



public class Grille{
    
    // Variables
    protected Map<String, Case> grille= new TreeMap<String, Case>();
    final int MAX_LIGNES = 26;
    
    // Methode
    
    
    //Serialisation
    
    //Permet de sauvegarder la sérialisation d'une grille
    public void save(String backupName) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(backupName));
        out.writeObject(grille);
        out.close();
    }
    
    //permet de charger la sérialisation d'une grille
    @SuppressWarnings("unchecked")
    public void load(String backupName) throws IOException,ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(backupName));
        grille = (Map<String,Case>)in.readObject();
        in.close();
    }
    
    
    //Ajout sur la grille
    
    //Ajoute une case à la grille
    public void add(String code, Case c) {
        grille.put(code,c);
    }
    
    //appelle la méthode add pour ajouter une case à la grille
    //permet de modifier la case pour dire qu'elle a été ajoutée à la grille
    public void ajouterCase(String nom, Case c)throws CaseOutOfGrille{
        if(c.getLigne()>MAX_LIGNES){ // on vérifie que la case rentre dans la grille
            throw new CaseOutOfGrille();
        }else{
            this.add(nom,c);
            c.add=1;
        }
    }
    
    //ajoute une valeur à une case de la grille ou la modifie
    //met à jour la grille afin que les formules soient calculées avec la nouvelle valeur
    public void ajouterValeur(Case cas, Double nb) throws CaseInconnueException, DivisionParZeroException, OperateurInconnuException,CycleException{
        cas.fixerValeur(nb);
        this.miseAJour();
    }
    
    //ajoute une formule à une case de la grille
    //met à jour la grille afin que les formules soient calculées avec la nouvelle valeur
    public void ajouterFormule(Case cas,Case c1, Case c2, String op)throws CaseInconnueException,DivisionParZeroException,OperateurInconnuException,CycleException{
        cas.setFormule(c1,c2,op);
        this.miseAJour();
        
    }
    
    
    
    
    //met à jour la grille
    public void miseAJour() throws CaseInconnueException, DivisionParZeroException, OperateurInconnuException,CycleException {
        List<Case> cas = new ArrayList<>(this.grille.values());
        boolean valeurModifiee;
        
        //si aucune valeur n'est modifiée, sort de la boucle
        //sinon, on recommence pour vérifier si d'autres cases ont besoin d'une mise à jour
        do {
            valeurModifiee = false;
            for (int i = 0; i < cas.size(); i++) {
                if (cas.get(i).estFormule()) {
                    Double ancienneVal = cas.get(i).getValeur();
                    cas.get(i).setFormule(cas.get(i).formule.gauche, cas.get(i).formule.droite, cas.get(i).formule.operateur);
                    Double nouvelleVal = cas.get(i).getValeur();
                    //si une seule des deux valeurs est nulles, il y a alors eu un changement
                    if (ancienneVal==null ^ nouvelleVal==null){
                        valeurModifiee = true;
                    }
                    else{
                        //pas de changement si l'ancienne et la nouvelle valeur sont nulles
                        if(ancienneVal==null && nouvelleVal==null){
                        }
                        else{
                            //si une valeur a changé suite au recalcul de la valeur de la case, on modifie valeurModifiee pour recommencer la boucle
                            if(!ancienneVal.equals(nouvelleVal)) {
                                valeurModifiee = true;
                            }
                        }
                    }
                }
            }

        } while (valeurModifiee);
    }
    
    
    //Tri des cases
    
    //renvoie la liste des cases classée selon l'ordre de lecture française,(d'abord selon l'ordre des lignes , puis des colonnes)
    //utilisé pour AppTri
    public List<Case> getCases() {
        List<Case> liOut = new ArrayList<Case>(this.grille.values());
        Collections.sort(liOut, (o1,o2) -> {return o1.getLigne() - o2.getLigne();});
        return liOut;
    }
    
    //retourne la liste des cases rangées par ordre croissant de leur valeur
    //les cases ayant comme valeur null sont mises à la fin de la liste
    //utilisé pour AppYou
    public List<Case> getCasesOrdreCroissant() {
        List<Case> liOut = new ArrayList<Case>();
        //traite les cases avec une valeur non nulle
        for (Case c : this.grille.values()) {
            if (c.getValeur()!=null) {
                liOut.add((Case) c);
            }
        }
        Collections.sort(liOut, (o1,o2) -> {return o1.getValeur().compareTo(o2.getValeur());});
        //traite les cases avec une valeur nulle
        for (Case c : this.grille.values()) {
            if (c.getValeur()==null) {
                liOut.add((Case) c);
            }
        }
        return liOut;
    }
    
    //retourne la liste des cases triées selon l'ordre croissant de leur niveau topologique
    //utilisé pour AppTopo
    public List<Case> getCasesOrdreTopo() {
        List<Case> liOut = new ArrayList<Case>(this.grille.values());
        Collections.sort(liOut, (o1,o2) -> {return o1.calculNiveauTopo() - o2.calculNiveauTopo();});
        return liOut;
    }
        
}
