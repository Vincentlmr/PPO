package applications;
import lib.*;
import exceptions.*;
import java.io.*;

public class AppCreate{
    
    public static void main(String argv[]) {
         Grille gril = new Grille(); // on crée une grille

        try{
            //création des cases
            Case caseA1=new Case("A",1);
            Case caseB3=new Case("B",3);
            Case caseB4=new Case("B",4);
            Case caseB6=new Case("B",6);
            Case caseC1=new Case("C",1);
            Case caseC2=new Case("C",2);
            Case caseC3=new Case("C",3);
            Case caseC5=new Case("C",5);
            Case caseD3=new Case("D",3);
            
            //ajout des cases dans la grille
            gril.ajouterCase("A1",caseA1);
            gril.ajouterCase("B3",caseB3);
            gril.ajouterCase("C1",caseC1);
            gril.ajouterCase("B4",caseB4);
            gril.ajouterCase("C5",caseC5);
            gril.ajouterCase("C3",caseC3);
            gril.ajouterCase("C2",caseC2);
            gril.ajouterCase("D3",caseD3);
            gril.ajouterCase("B6",caseB6);
            
            //ajout de valeur
            gril.ajouterValeur(caseA1,10.0);
            gril.ajouterValeur(caseB3,25.0);
            
            //ajout de formule
            gril.ajouterFormule(caseC5,caseA1,caseB3,"+");
            gril.ajouterFormule(caseB4,caseA1,caseC5,"-");
            gril.ajouterFormule(caseC3,caseA1,caseB3,"+");
            gril.ajouterFormule(caseC2,caseB4,caseC5,"/");
            gril.ajouterFormule(caseD3,caseC3,caseC1,"+");
            gril.ajouterFormule(caseB6,caseB3,caseC2,"x");
            
           
            
        // Si l'on reçoit une exception on affiche le message d'erreur correspondant
        } catch(CaseOutOfBoundsException coobe){
            System.out.println("Case en dehors des limites");
        }catch(CaseInconnueException cie){
            System.out.println("Case inconnue");
        }catch(DivisionParZeroException dpze){
            System.out.println("Division par 0");
        }catch(OperateurInconnuException oie){
            System.out.println("Je ne suis pas capable de reconnaitre cet operateur...");
        }catch(CycleException ce){
            System.out.println("Attention, tu fais des cycles, Malheureux !");
        }catch(CaseOutOfGrille cog){
            System.out.println("Attention, la grille ne peut pas accueillir cette case !");
        }
        
        
        
        //sauvegarde de la grille par sérialisation
        try {
             gril.save(argv[0]);
             System.out.println("La grille a bien été sauvegardée dans le fichier "+ argv[0]);
        } catch(IOException ie) {
            System.out.println(ie.getMessage());
            ie.printStackTrace();
        }
    }
}
