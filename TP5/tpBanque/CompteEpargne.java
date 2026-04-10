
class CompteEpargne extends Compte {
    
    // Paramètre
    double taux;
    
    
    // Constructeur
    
    CompteEpargne(double newCredit, double newTaux) {
        super(newCredit);
        this.taux = newTaux;
    }
    
    
    // Methodes
    
    double interets(){
        return this.taux * solde();
    }
    
    void echeance(){
        this.credit = this.credit + interets();
    }
    
    void debiter(double x){
        if(solde()>0){
            this.debit = super.debit + x;
        }
    }
    
    public String toString(){
        return "< " + this.credit + " , " + this.debit + " , " + interets() + " >";
    }
    
    void virerVers(double x, Compte dest){
        if(solde()>x){
            super.virerVers(x,dest);
        }else{
            System.out.println("operation invalide: manque d'argent sur le compte, compte épargne");
        }
        
    }

}
