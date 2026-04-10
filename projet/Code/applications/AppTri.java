package applications;
import lib.*;
import exceptions.*;
import java.io.*;
import java.util.*;

//Affichage des cases selon la lecture française
public class AppTri{

    public static void main(String argv[]) {
        Grille gril = new Grille();// on crée une grille
        List<Case> cas= new ArrayList<Case>();// et une liste de cases
        
        //chargement de la grille sérialisée
        try {
             gril.load(argv[0]);
        } catch(IOException ie) {
            System.out.println(ie.getMessage());
            ie.printStackTrace();
        }
        catch(ClassNotFoundException cl) {
            System.out.println(cl.getMessage());
            cl.printStackTrace();
        }
         
        
         
        //affichage graphique
        System.out.println("AppTri");
        System.out.println();
        System.out.println("|--------------------------------------------------------------------------------------------------|");
        System.out.println("|  Liste des cases de la grille du fichier " + argv[0] +" triées de manière du sens de lecture française  |");
        System.out.println("|--------------------------------------------------------------------------------------------------|");
        System.out.println();
         
        //Affichage des cases
        System.out.println("---------------------------------------------------------------------------------------");
        cas=gril.getCases();// on récupère la liste des cases das l'ordre de lecture fr
        for(int i=0; i<cas.size();i++){
            System.out.println(cas.get(i).toString());// on affiche pour chaques case son "nom" et sa valeur
        }
        System.out.println("---------------------------------------------------------------------------------------");
    }
}


