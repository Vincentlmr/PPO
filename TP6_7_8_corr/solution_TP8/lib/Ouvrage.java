package lib;
import java.io.*;

public class Ouvrage implements Serializable {
    //variables d'instance
    protected String titre, auteur;
    protected boolean emprunte;
    protected int compteur; // nombre d'emprunts

    //methodes et constructeurs
    // fournies
    public void retourner() {
        emprunte = false ; // pour simplifier
    }
    public int getCompteur() {
        return compteur;
    }

    public String getTitre() {
        return titre;
    }
    // a programmer :
    public String toString() {
        String emp = "";
        if (this.emprunte) {
            emp = " est emprunté !";
        }
        return "Titre : " + this.titre + ", Auteur : " + this.auteur + "("+this.compteur+")" + emp;
    }

    public void emprunter() throws NonDisponibleException {
        if (this.emprunte) {
            throw new NonDisponibleException();
        } else {
            this.emprunte = true;
            this.compteur += 1;
        }
    }
    //provoque l'exception NonDisponibleException s'il est deja emprunt'e

    public Ouvrage(String tit, String aut) {
        this.titre = tit;
        this.auteur = aut;
        this.emprunte = false;
        this.compteur = 0;
    }
}
