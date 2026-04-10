import java.util.Scanner;


class TestGeometrique{

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Premier terme? ");
            double premTerm = scan.nextDouble();
            
        
        
        System.out.println("raison? ");
            double raison = scan.nextDouble();
        
      
        
        ProgressionGeometrique Geo1 = new ProgressionGeometrique(premTerm,raison);
        
        int boucle = 1;
        
        while(boucle == 1){
         
            System.out.println(" next (y/n) ? ");
                String next = scan.next();
                
            if(next.equals("y")){
                Geo1.next(1);
                System.out.println(Geo1.getTerme());
            }else{
                boucle = 0;
                
                System.out.println("nb termes supplementaires? ");
                    int termeSup = scan.nextInt();
            
                
                Geo1.next(termeSup);
                
                System.out.println("progression: " +Geo1.toString());
            }
        }
    }
}
