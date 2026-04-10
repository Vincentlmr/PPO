
class CompteEpargne extends Compte {
    
    // Paramètre
    double taux;
    
    // Constructeur
    
    Compte(double newCredit, double newTaux) {
        this.credit = newCredit;
        this.credit = newTaux;
    }
    
    
    // Methodes
    
    double interets(){
        return this.taux * solde();
    }
    
    double echeance(){
        this.credit = this.credit + interets();
    }
    
    double debiter(double x){
        if(solde()>0){
            this.debit = super.debit + x;
    }
    
    String toString(){
        return "< " + this.credit + " , " + this.debit + " , " + interets() + " >";
    }

}
