package applications;
import lib.*;
import multimedias.*;
import java.io.*;

public class Application {
    public static void main(String[] argv) {

        Bibliotheque bib = new Mediatheque();

        //Ranger des ouvrages:
        bib.add("I101",new Ouvrage("C","Kernighan"));
        bib.add("L202",new Ouvrage("Germinal","Zola"));
        bib.add("S303",new Ouvrage("Parapente","Ali Gali"));
        bib.add("I345",new Ouvrage("Java","Eckel"));
        bib.add("R01",new Revue("AA","Bc",10));
        bib.add("R02",new Revue("BB","Cd",23));
        bib.add("R03",new Revue("CC","De",12));
        bib.add("C34",new CD("CD1","OO"));
        bib.add("C35",new CD("CD2","PP"));
        // bib.listing();

        try {
            bib.emprunter("I345");
            bib.retourner("I345");
            bib.emprunter("I345");
            bib.retourner("I345");
            bib.emprunter("I345");
            bib.retourner("I345");
            bib.emprunter("I345");
            bib.retourner("I345");
            bib.emprunter("S303");
            bib.retourner("S303");
            bib.emprunter("S303");
            bib.retourner("S303");
            bib.emprunter("S303");
            bib.retourner("S303");
            bib.emprunter("I101");
            bib.retourner("I101");
            bib.emprunter("I101");
            bib.retourner("I101");
            bib.emprunter("R01");
            bib.retourner("R01");
            bib.emprunter("R03");
            bib.retourner("R03");
            bib.emprunter("R03");
            bib.retourner("R03");
            bib.emprunter("R03");
            bib.retourner("R03");
        } catch(NonDisponibleException nde) {
            System.out.println("L'ouvrage n'est pas disponible");
        } catch(OuvrageInconnuException oie) {
            System.out.println("L'ouvrage est inconnu");
        }
        try {
            bib.save("base.bin");
        } catch(IOException ie) {
            System.out.println("Probleme fichier");
        }
        bib.add("E234",new CD("CD3","QQ"));
        bib.listing();

        System.out.println(bib.getOuvrages());
        System.out.println(bib.getOuvragesByTitre());
        System.out.println(bib.getRevues());

        try {
            bib.load("base.bin");
        } catch(Exception ie) {
            System.out.println("Probleme");
        }
        bib.listing();

        System.out.println(((Mediatheque) bib).cds());
    }
}
