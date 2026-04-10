import exception.*;

public class Gestionnaire extends Employe{
    public int nbHTTPSup;
    
    Gestionnaire(String newNom, int newNHTT,int newNum, int newNbHTTPSup)throws PasAssezdeHTTPException{
        super(newNom,newNHTT, newNum);
        this.nbHTTPSup=newNbHTTPSup;
    }
    
    public double getNbHTT() throws PasAssezdeHTTPException{
        
        return super.getNbHTT()+this.nbHTTPSup;
        
        
    }
    
}
