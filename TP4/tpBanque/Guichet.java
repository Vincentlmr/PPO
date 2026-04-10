import java.util.Scanner;

public class Guichet {
 static Scanner in = new Scanner(System.in);
 // creation d'une banque :
 static Banque bank = new Banque();

 public static void main (String[] args) {
  int choix=0;
  do {
   menu();
   System.out.print("votre choix? ");
   choix = in.nextInt();
   switch (choix) {
   case 1 : // etat des comptes
 	bank.etat();
	break;
   case 2 : // creer un nouveau compte
	menuNouveauCompte();
	break;
	case 3 : // creer un nouveau compte epargne
	menuNouveauCompteEpargne();
	break;
   case 4: // crediter un compte
	menuCrediter();
	break;
   case 5: // debiter un compte
	menuDebiter();
	break;
   case 6: // effectuer un virement
	menuVirement();
	break;
	case 7: // afficher interet
	menuInterets();
	break;
	case 8: // faire une echeance
	menuEcheance();
	break;
   case 0: // quitter
   }
  } while (choix!=0);
 System.out.println("au revoir");
 }

 static void menu() {
  System.out.println("\n1: etat des comptes\n2: creer un nouveau compte\n3: creer un nouveau compte epargne\n4: crediter un compte\n5: debiter un compte\n7: afficher les interets\n8: faire une echeance\n6: effectuer un virement\n0: quitter");
 }

 static void menuNouveauCompte() {
  int num;
  num=bank.ouvrirCompte();
  System.out.println("numero= "+num);
 }
 
 static void menuNouveauCompteEpargne() {
  int num;
  num=bank.ouvrirCompteEpargne();
  System.out.println("numero= "+num);
 }

 static void menuCrediter() {
  int num;
  System.out.print("\nnumero du compte? ");
  num=in.nextInt();
  System.out.print("somme? ");
  bank.crediter(num, in.nextDouble());
 }

 static void menuDebiter() {
  int num;
  System.out.print("\nnumero du compte? ");
  num=in.nextInt();
  System.out.print("somme? ");
  bank.debiter(num, in.nextDouble());
 }
 
 static void menuInterets() {
  int num;
  System.out.print("\nnumero du compte? ");
  num=in.nextInt();
  System.out.print(bank.interets(num));
 }
 
 static void menuEcheance() {
  int num;
  System.out.print("\nnumero du compte? ");
  num=in.nextInt();
  bank.echeance(num);
 }

 static void menuVirement() {
  int from, to;
  System.out.print("\ncompte a debiter? ");
  from=in.nextInt();
  System.out.print("compte a crediter? ");
  to=in.nextInt();
  System.out.print("somme? ");
  bank.virement(from, to, in.nextDouble());
 }
}
