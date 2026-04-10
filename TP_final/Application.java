import lib.*;
import exception.*;
public class Application {
    int num=0;
    public static void main(String argv[]) {

        
        Employe e1 = new Employe("Le stagiaire",15,1);
        //EmployePartiel e2 = new EmployePartiel("parti",num2,14);
        Gestionnaire e3 = new Gestionnaire("parti",14,3,3);
        
        System.out.println(e1.getNBHTT());
        //System.out.println(e2.getNBHTT());
        System.out.println(e3.getNBHTT());
        
        
        
        

    


    }
}
