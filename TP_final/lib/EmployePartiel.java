import exception.*;

public class EmployePartiel extends Employe{
    
    EmployePartiel(String newNom, int newNHTT, int newNum)throws PasAssezdeHTTPException{
        super(newNom,newNHTT,newNum);
    }
    
    final double getNbHTT() throws PasAssezdeHTTPException{
        return super.getNbHTT()-2;
        
    }
}
