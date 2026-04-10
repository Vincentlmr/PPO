
class Compte {
        
    // Parametres
    double credit;
    double debit;
    
    // Constructeur
    
    Compte(double newCredit) {
        this.credit = newCredit;
    }
    
    // Methodes
    
    double crediter(double x){
        this.credit = this.credit + x;
    }
    
    double debiter(double x){
        this.debit = this.debit + x;
    }
    
    double solde(){
        return this.credit - this.debit;
    }
    
    String toString(){
        return "< " + this.credit + " , " + this.debit + " >";
    }
}
