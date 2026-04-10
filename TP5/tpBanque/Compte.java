
class Compte {
        
    // Parametres
    double credit;
    double debit;
    
    // Constructeur
    
    Compte(double newCredit) {
        this.credit = newCredit;
    }
    
    // Methodes
    
    void crediter(double x){
        this.credit = this.credit + x;
    }
    
    void debiter(double x){
        this.debit = this.debit + x;
    }
    
    double solde(){
        return this.credit - this.debit;
    }
    
    public String toString(){
        return "< " + this.credit + " , " + this.debit + " >";
    }
    
    void virerVers(double x, Compte dest){
        debiter(x);
        dest.crediter(x);
        
        
    }
}
