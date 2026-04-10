import java.util.Scanner;


class TestArithmetique{

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Premier terme? ");
            double premTerm = scan.nextDouble();
            
        
        
        System.out.println("raison? ");
            double raison = scan.nextDouble();
        
        
        
        ProgressionArithmetique Ari1 = new ProgressionArithmetique(premTerm,raison);
        
        int boucle = 1;
        
        while(boucle == 1){
         
            System.out.println(" next (y/n) ? ");
                String next = scan.next();
                
            if(next.equals("y")){
                Ari1.next(1);
                System.out.println(Ari1.getTerme());
            }else{
                boucle = 0;
                
                System.out.println("nb termes supplementaires? ");
                    int termeSup = scan.nextInt();
                
                
                Ari1.next(termeSup);
                
                System.out.println("progression: " +Ari1.toString());
            }
        }
    }
}
