package lib;
import exceptions.*;
public class Multiplication extends Formule{
    
    //Constructeur
    public Multiplication(Case gauche,Case droite){
        super(gauche,droite,"x");// on reprend le constructeur de formule en ajoutant l'oprateur
        
    }
    
    // Methode
    @Override
   
    public Double eval() {
        Double gaucheValue = super.getGauche().getValeur();
        Double droiteValue = super.getDroite().getValeur();
        return gaucheValue * droiteValue;// on effectue l'operation
    }
}
