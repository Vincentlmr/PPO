public class Ouvrage {
    //variables d'instance
    protected String titre, auteur;
    protected boolean emprunte;
    protected int compteur; // nombre d'emprunts

    //methodes et constructeurs
    // fournies
    public void retourner() {
        emprunte = false ; // pour simplifier
    }
    public int getCompteur() {
        return compteur;
    }
    // a programmer :
    public String toString() {
        return this.titre +", " +this.auteur ;
    }

    public void emprunter()throws NonDisponibleException{
    //provoque l'exception NonDisponibleException s'il est deja emprunt'e
        if(emprunte){
            throw new NonDisponibleException();
        }else{
            emprunte = true;
            compteur++;
        }
    }

    public Ouvrage(String tit, String aut){
        this.titre = tit;
        this.auteur = aut;
    }
}
