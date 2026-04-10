package lib;
import exceptions.*;
import java.io.*;
import java.util.*;

public class Case implements Serializable{
    
    // Variables
    protected String colonne;
    protected int ligne;
    protected Double valeur;
    protected Formule formule;
    protected int add; //vaut 1 si la case a été ajoutée à la grille, 0 sinon
    
    // Constructeur
    public Case(String col, int lig) throws CaseOutOfBoundsException{
        if(col.length()!=1){
            throw new CaseOutOfBoundsException();
        }
        else{
            if(lig>26 || lig<1){
                throw new CaseOutOfBoundsException();
            }
            else{
                this.colonne=col;
                this.ligne=lig;
                this.valeur=null;
                this.add=0;
            }
        }
    }
    
    // Accesseurs en lecture / écriture
    public Double getValeur(){
    
        return valeur;
    }
    
    public int getLigne(){
        return this.ligne;
    }
    
    public String getColonne(){
        return this.colonne;
    }
    
    public Formule getFormule(){
        return this.formule;
    }
    
    
    //Methodes
    
    //permet de fixer la valeur d'une case avec un double
    public void fixerValeur(Double d)throws CaseInconnueException{
        if (this.add == 0) {// on verifie que la case à été ajouté à la grille
            throw new CaseInconnueException();
        }
        else{
            this.valeur = d;
        }
    }
    
    
    
    //retourne vrai si la case posséde une formule, faux sinon
    public boolean estFormule(){
        if (this.formule==null){
            return false;
        }
        else{
            return true;
        }
    }
    
    
    //regarde si une case et sa formule crée un cycle
    //retourne Vrai si la case crée un cycle, faux sinon
    public boolean estCycle() {
        return this.formule.dependDe(this);
    }
    
    //permet d'affecter une formule à une case
    //si l'une des deux cases de la formule à comme valeur null, le résultat de l'opération sera null
    public void setFormule(Case c1, Case c2, String op) throws CaseInconnueException, DivisionParZeroException, OperateurInconnuException, CycleException {
        
        Double resultat = 0.0;
        
        // Cas d'une case non ajoutée à la grille
        if (c1.add == 0 || c2.add == 0 || this.add==0) {
            throw new CaseInconnueException();
        } 
        else {
            // Cas d'une addition
            if (op.equals("+")) {
                Addition addition = new Addition(c1, c2);
                if (c1.getValeur() == null || c2.getValeur() == null) {
                    resultat = null;
                } 
                else {
                    resultat = addition.eval();
                }
                this.formule = addition;
            } 
            else {
                //cas d'une soustraction
                if (op.equals("-")) {
                    Soustraction soustraction = new Soustraction(c1, c2);
                    if (c1.getValeur() == null || c2.getValeur() == null) {
                        resultat = null;
                    } 
                    else {
                        resultat = soustraction.eval();
                    }
                    this.formule = soustraction;
                } 
                else {
                    //cas d'une multiplication
                    if (op.equals("x")) {
                        Multiplication multiplication = new Multiplication(c1, c2);
                        if (c1.getValeur() == null || c2.getValeur() == null) {
                            resultat = null;
                        } 
                        else {
                            resultat = multiplication.eval();
                        }
                        this.formule = multiplication;
                    } 
                    else {
                        //cas d'une division
                        if (op.equals("/")) {
                            Division division = new Division(c1, c2);
                            if (c1.getValeur() == null || c2.getValeur() == null) {
                                resultat = null;
                            } 
                            else {
                                resultat = division.eval();
                            }
                            this.formule = division;
                        } 
                        // si l'on ne connait pas l'opérateur, on renvoie une erreur
                        else {
                            throw new OperateurInconnuException();
                        }
                    }
                }
            }
            //si la formule affecté crée un cycle, on renvoie une exception
            if (this.estCycle()) {
                throw new CycleException();
            } 
            else {
                this.fixerValeur(resultat);
            }
        }
    }
    
        
    //fonction récursive qui retourne le niveau topologique d'une case
    //si une case n'a pas de formule, elle est au niveau 1
    //attention : retirer 1 à la fin ->décalage
    public int calculNiveauTopo(){
        int niveauDroite=0;
        int niveauGauche=0;
        if(this.estFormule()==false){
            return 1;
        }
        else{
            //calcul du niveau topologique des cases gauches et droites
            //on garde le niveau maximum des cases gauches et droites pour avoir le niveau topologique d'une case
            niveauDroite=1+this.formule.droite.calculNiveauTopo();
            niveauGauche=1+this.formule.gauche.calculNiveauTopo();
            return Math.max(niveauDroite,niveauGauche);
        }
    }
    
    
    //getContenu()
    
    // retourne le contenu d'une case sous la forme A1+B2 = 12
    //si la case ne possède qu'une valeur et pas de formule, renvoie uniquement sa valeur
    public String getContenu(){
        if (estFormule()==true){
            return "(" + formule.toString() + ")"+ " = " + valeur;
        }
        else{
            return valeur+"";
        }
    }
    
    //fonction récursive qui retourne le contenu développé d'une formule
    //par exemple si B3=A1+B2 et B2=A3-A4, renvoie (A1+(A3-A4)
    //si la case ne possède qu'une valeur et pas de formule, renvoie uniquement sa valeur
    public String getContenuDeveloppe(){
        String d,g;
        if (this.estFormule()==true){
            if(this.formule.gauche.estFormule()){ //  on regarde si la case de gauche est un valeur ou une formule
                g =  formule.gauche.getContenuDeveloppe();
            }
            else{
                g = this.formule.gauche.colonne + this.formule.gauche.ligne;
            }
            
            if(this.formule.droite.estFormule()){//  on regarde si la case de droite est un valeur ou une formule
                d =  formule.droite.getContenuDeveloppe();
            }
            else{
                d = this.formule.droite.colonne + this.formule.droite.ligne;
            }
            
            return "("+ g + formule.getOperateur() + d + ")";
        }
        else{
            return valeur+"";
        }
    }
    
    // ToString()
    //retourne la valeur d'une case sous la forme A1 : 12
    public String toString(){
        return this.colonne + this.ligne + " : "+ getValeur();
    }
    
    //retourne les coordonnées d'une case, sa formule et sa valeur
    //résultat sous la forme B4 : (A1+B2) = 12
    public String toStringContenu(){
        return this.colonne + this.ligne + " : "+getContenu() ;
    }
    
    
    //retourne les coordonnées d'une case, sa formule développée et sa valeur
    //par exemple si B3=A1+B2 et B2=A3-A4, résultat sous la forme B3 : (A1+(A3-A4)) = 8
    public String toStringContenuDeveloppe(){
        return this.colonne + this.ligne + " : "+ getContenuDeveloppe() +" = " + this.valeur;
    }
    
    
}
    
