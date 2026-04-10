class ProgressionGeometrique{
    
    // Paramètres
    
    double premTerm ;
    double raison;
    
    final static int MAX = 1000;
    
    double[] tableauTerme;
    
    int rang;
    
    // Constructeur
    
    ProgressionGeometrique( double newPremTerm, double newRaison){
        this.premTerm = newPremTerm;
        this.raison = newRaison;
        this.rang = 0;
        this.tableauTerme = new double[MAX];
        tableauTerme[0] = newPremTerm;
    }
    
    
    // Methodes
    
    public void next(){
        if(rang < MAX){
            this.rang++;
            this.tableauTerme[rang]= this.tableauTerme[rang-1]*raison;
        }
        
    }
    
    public void next(int n){
        for(int i=0; i<n; i++){
            next();
        }
    }
    
    
    public double getTerme(){
        return this.tableauTerme[this.rang];
    }
    
    public String toString(){
        String s = "";
        
        for(int i=0; i<= this.rang; i++){
            s = s + " "+this.tableauTerme[i];
        }
        
        return s;
    }
}
