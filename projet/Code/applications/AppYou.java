package applications;
import lib.*;
import exceptions.*;
import java.io.*;
import java.util.*;

//Affichage des cases selon l'ordre croissant des valeurs (valeurs null mises à la fin)
public class AppYou{

    public static void main(String argv[]) {
        Grille gril = new Grille(); // on crée une grille
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
         
        //affichage graphique        
        System.out.println("AppYou");
        System.out.println();
        System.out.println("|--------------------------------------------------------------------------------------------------|");
        System.out.println("|  Liste des cases de la grille du fichier " + argv[0] +" triées de manière croissante selon leur valeur  |");
        System.out.println("|--------------------------------------------------------------------------------------------------|");
        System.out.println();
       
         
        //Affichage des cases
        cas=gril.getCasesOrdreCroissant(); // on récupère la liste des cases dans l'ordre croissant
        int i=0;
        
        //on sépare les case à valeur null et le reste
        System.out.println("---------------------------------------------------------------------------------------");
        while(i<cas.size() && cas.get(i).getValeur()!=null){
            System.out.println(cas.get(i).toString()); // on affiche pour chaques case son "nom" et sa valeur
            i=i+1;
        }
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Les cases à valeur null:");
        while(i<cas.size()){
            System.out.println(cas.get(i).toString()); // on affiche pour chaques case son "nom" et sa valeur
            i=i+1;
        }
        System.out.println("---------------------------------------------------------------------------------------");
    }
}

