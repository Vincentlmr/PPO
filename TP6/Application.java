import java.util.Scanner;

public class Application {

    static Scanner in = new Scanner(System.in);
    static Bibliotheque bib = new Bibliotheque();
    public static void main(String[] argv) {

        

        //Ranger des ouvrages:
        bib.add("I101",new Ouvrage("C","Kernighan"));
        bib.add("L202",new Ouvrage("Germinal","Zola"));
        bib.add("S303",new Ouvrage("Parapente","Ali Gali"));
        bib.add("I345",new Ouvrage("Java","Eckel"));
        bib.add("V666",new Revue("La Mort", "Le Meur",21));
        bib.add("Y969",new Revue("Los huevitos", "Gaudin",10));

        int choix=0;
        do {
            bib.listing();
            System.out.println("\n");
            menu();
            System.out.print("votre choix? ");
            choix = in.nextInt();
            switch (choix) {
            case 1 : // Emprunter
                menuEmprunter();
                break;
            case 2 : // retourner
                menuRetourner();
                break;
            case 3 : //trier les ouvrages par nombre d'emprunts
                menuNbrEmprunt();
                break
            case 0: // quitter
            }
        } while (choix!=0);
            System.out.println("au revoir");
    }

        static void menu() {
            System.out.println("\n1: Emprunter un ouvrage\n2: Retourner un ouvrage\n0: quitter");
        }
        
        static void menuEmprunter() {
            String num;
            System.out.print("\ncode de l'ouvrage? ");
            num=in.next();
            try{
                bib.emprunter(num);
                System.out.println("Emprunt de l'ouvrage "+num);
            }catch (OuvrageInconnuException e){
                System.out.println("Ouvrage inconnu");
            }catch (NonDisponibleException e){
                System.out.println("Ouvrage indisponible");
            }
        }
            
         static void menuRetourner() {
            String num;
            System.out.print("\ncode de l'ouvrage? ");
            num=in.next();
            try{
                bib.retourner(num);
                System.out.println("Retour de l'ouvrage "+num);
            }catch (OuvrageInconnuException e){
                System.out.println("Ouvrage inconnu");
            }
            
        }
}

