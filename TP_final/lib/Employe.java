import exception.*;

public class Employe {
    String nom;
    int nbHTT;
    public int numero;
    
    //Constante
    final static int NBHTT_MIN = 10;
    
    
    
    //Constructeur Q1)
    Employe(String newNom, int newNHTT, int newNum)throws PasAssezdeHTTPException{
       if(getNbHTT()<NBHTT_MIN){
            throw new PasAssezdeHTTPException();
        }else{
            this.nom=newNom;
            this.nbHTT=newNHTT;
            this.numero=newNum;
        }
        
        
        
        
    }
    
   
    
    // Q2)
    public String toString(){
        return "["+ this.nom +", " +this.nbHTT + "]"; 
    }
    
    public double verifieNbHTT() throws PasAssezdeHTTPException{
        if(getNbHTT()<NBHTT_MIN){
            throw new PasAssezdeHTTPException();
        }else{
            return this.nbHTT;
        }
        
    }
    
    double getNbHTT()throws PasAssezdeHTTPException{
        
        return this.nbHTT;
          
    }

}
