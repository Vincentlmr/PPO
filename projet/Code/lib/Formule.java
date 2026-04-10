package lib;
import exceptions.*;
import java.io.*;


public abstract class Formule implements Serializable{
    
    //Variables
    protected Case gauche;
    protected Case droite;
    protected String operateur;
    
    
    //Constructeur
    public Formule(Case gauche,Case droite, String operateur){
        this.gauche = gauche;
        this.droite = droite;
        this.operateur = operateur;
    }
    
    //Accesseur en lecture et écriture
    public Case getGauche() {
        return gauche;
    }

    public Case getDroite() {
        return droite;
    }
    
    public String getOperateur(){
        return operateur;
    }
    
    
    // Methode
    
    //Affiche l'opéreation de la formule sous la forme A1+B2
    public String toString(){
        return this.gauche.colonne + this.gauche.ligne  +" "+ this.operateur + " " + this.droite.colonne + this.droite.ligne;
    }
    
    //Exception dans le cas d'une division par 0
    abstract Double eval()throws DivisionParZeroException;
    
    //Pour une formule, fonction récursive qui retourne Vrai si la case c fait partie de la formule ou de sa formule développée
    public boolean dependDe(Case c) {
        return this.gauche == c || this.droite == c ||
               (this.gauche.estFormule() && this.gauche.formule.dependDe(c)) ||
               (this.droite.estFormule() && this.droite.formule.dependDe(c));
    }
}
    
