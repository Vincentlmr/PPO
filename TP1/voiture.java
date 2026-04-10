
class Voiture {
    // Parametre
    double prix;
    
    //constructeur
    Voiture(double newPrix) {
        this.prix = newPrix;
    }
    
    // Methode
    void affichePrix() {
        System.out.println("Prix : " + this.prix);
    }
    
    public static void main(String[]args) {
        // Instanciation
        Voiture v1 = new
            Voiture(2000.0);
            v1.affichePrix();
        }
}
