package applications;
import lib.*;
import exceptions.*;
import java.io.*;
import java.util.*;

//Affichage des cases selon le niveau topologique
public class AppTopo{

    public static void main(String argv[]) {
        Grille gril = new Grille();// on crée une grille
        List<Case> cas= new ArrayList<Case>();// et une liste de cases
        
        //chargement de la grille sérialisée
        try {
             gril.load("bob.bin");
        } catch(IOException ie) {
            System.out.println(ie.getMessage());
            ie.printStackTrace();
        }
        catch(ClassNotFoundException cl) {
            System.out.println(cl.getMessage());
            cl.printStackTrace();
        }
         
        cas=gril.getCasesOrdreTopo();// on récupère la liste des cases das l'ordre topologique
        int niv=0; //niveau topologique en cours
        int i=0; // case en cours
            
        //affichage graphique
        System.out.println("AppTopo");
        System.out.println();
        System.out.println("|---------------------------------------------------------------------------------|");
        System.out.println("|  Liste des cases de la grille du fichier " + argv[0] +" triées de manière topologique  |");
        System.out.println("|---------------------------------------------------------------------------------|");
        System.out.println();
        
         
        while(i<cas.size()){ // pour chaque niveau
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("Niveau "+niv+ ":");
            while(  i<cas.size() && cas.get(i).calculNiveauTopo()==niv+1){// pour chaque cases du niveau
                System.out.println("       "+cas.get(i).toStringContenu()); //affiche le contenu
                if(niv>1){
                    System.out.println("       Contenu Développé : "+cas.get(i).toStringContenuDeveloppe()); //affiche le contenu développé
                }
                i=i+1;
            }
            niv=niv+1;
        }
        System.out.println("---------------------------------------------------------------------------------------");
    }
}
