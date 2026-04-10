package lib;
import exceptions.*;

public class Addition extends Formule{
    
    //Constructeur
    public Addition(Case gauche,Case droite){
        super(gauche,droite,"+");// on reprend le constructeur de formule en ajoutant l'oprateur
        
    }
    
    // Methode
    @Override
   
    public Double eval() {
        Double gaucheValue = super.getGauche().getValeur();
        Double droiteValue = super.getDroite().getValeur();
        return gaucheValue + droiteValue;// on effectue l'operation
        
    }
}
