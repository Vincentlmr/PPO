/**
 * La classe ExempleScanner propose un exemple d'utilisation de la bibliothèque Scanner de java.util.
 */

// Importation de la bibliothèque Scanner
import java.util.Scanner;

public class ExempleScanner {
    public static void main(String[] args) {
        // Initialisation d'un objet Scanner : scan
        Scanner scan = new Scanner(System.in);

        System.out.println("Donne moi un entier A (int) ?");
		int myInt = scan.nextInt();

        System.out.println("Donne moi un double B (double) ?");
		double myDouble = scan.nextDouble();

        System.out.println("Donne moi un mot C (String) ?");
        scan.nextLine();    // nextDouble() précédent ne consomme pas le '\n', donc l'appel suivant permet de prendre la fin de l'entrée précédente qui est vide pour pouvoir attendre tranquillement le nextLine() suivant.
        String myString = scan.nextLine();

        System.out.println("Voila ce que tu m'as donné :");
        System.out.println("\t A := " + myInt);
        System.out.println("\t B := " + myDouble);
        System.out.println("\t C := " + myString);
    }
}
