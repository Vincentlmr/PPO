import java.util.Scanner;

class TestRectangle{
    
        static Rectangle creerRectangle() {
                Scanner scan = new Scanner(System.in);
                System.out.println("Donne moi la coordonnée des abcisses du premier point ?");
                        double myOrigineX = scan.nextDouble();

                System.out.println("Donne moi Donne moi la coordonnée des ordonnées du premier point ?");
                        double myOrigineY = scan.nextDouble();
                System.out.println("Donne moi la coordonnée des abcisses du second point ?");
                        double myCornerX = scan.nextDouble();

                System.out.println("Donne moi Donne moi la coordonnée des ordonnées du second point ?");
                        double myCornerY = scan.nextDouble();
                Rectangle r= new Rectangle(myOrigineX,myOrigineY,myCornerX,myCornerY);
                return r;
        }
        static Rectangle max(Rectangle[] t){
                int indsurfmax =0;
                Rectangle r;
                for(int i=1; i<t.length;i++){
                        if(t[i].surface()>t[i-1].surface()){
                                indsurfmax=i;
                        }
                }
                return t[indsurfmax];
        }
    
    
        public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                //Instanciation
                //Rectangle r = new Rectangle(10.0,10.0,40.0,50.0);
                
                /*Rectangle r =creerRectangle();
                System.out.println("Largeur : " + r.largeur());
                System.out.println("Longeur : " + r.longeur());
                System.out.println("Surface : " + r.surface());
                System.out.println("Perimetre : " + r.perimetre());
                System.out.println(r.toString());*/
                
                /*System.out.println("Combien de rectangle veux tu créer ?");
                        int nbrec = scan.nextInt();*/
                
                
                
                
                //Declaration
                Rectangle[] tableauRectangle;
                
                // Allocation
                tableauRectangle = new Rectangle[nbrec];
                
                for(int i=0; i<nbrec;i++){
                        Rectangle r= creerRectangle();
                        
                        tableauRectangle[i] = r;
                }
                
                for(int i=0; i<nbrec;i++){
                        System.out.println("Rectangle " + i +" :");
                        System.out.println(tableauRectangle[i].toString());
                }
                
                System.out.println("Le rectangle "+ max(tableauRectangle).toString() + "à la surface la plus grande");
        
        }
    
        
   
}
