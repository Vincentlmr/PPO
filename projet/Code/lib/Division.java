package lib;
import exceptions.*;
public class Division extends Formule{
    
    //Constructeur
    public Division(Case gauche,Case droite){
        super(gauche,droite,"/"); // on reprend le constructeur de formule en ajoutant l'oprateur
        
    }
    
    // Methode
    @Override
   
    public Double eval()throws DivisionParZeroException {
        Double gaucheValue = super.getGauche().getValeur();
        Double droiteValue = super.getDroite().getValeur();
        if(droiteValue == 0){ // On vérifie que l'on ne divise pas par 0
            throw new DivisionParZeroException();
        }else{
            return gaucheValue / droiteValue; // on effectue l'operation
        }
    }
}
