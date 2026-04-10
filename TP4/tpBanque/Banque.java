class Banque {
	
	final static int MAX = 1000;
    
    Compte[] tableauCompte= new Compte[MAX];
    
    int compteur;
    
    
	int ouvrirCompte(){
		int res=0;
		if(this.compteur< MAX){
			Compte newCompte = new Compte(0);
            this.tableauCompte[this.compteur]= newCompte;
            this.compteur++;
            res = compteur-1;
            
        }else{
			System.out.println("Trop de comptes créé");
		}
		return res;
	}
		
	void crediter(int num, double x){
		if( getCompte(num) != null){
			tableauCompte[num].crediter(x);
		}
	}
	
	public Compte getCompte(int num){
		Compte result;
		if(this.compteur<num){
			result=null;
			System.out.println("compte inexistant");
		}else{
			result=tableauCompte[num];
		}
		return result;
	}
	
	void debiter(int numero, double x){
		if( getCompte(numero) != null) {
			tableauCompte[numero].debiter(x);
		}
	}
	
	double totalSoldes(){
		double sum=0;
		for(int i=0; i<this.compteur;i++){
			sum=sum+tableauCompte[i].solde();
		}
		return sum;
	}
			
			
	String etat(int num){
		String res=null;
		if( getCompte(num) != null){
			res= tableauCompte[num].toString();
		}
		return res;
	}
	
	void etat(){
		for(int i=0; i<compteur; i++){
			System.out.println(tableauCompte[i].toString());
		}
	}
	
	int ouvrirCompteEpargne(){
		int res=0;
		if(this.compteur< MAX){
			CompteEpargne newCompte = new CompteEpargne(0,0.01);
            this.tableauCompte[this.compteur]= newCompte;
            this.compteur++;
            res = compteur-1;
            
        }else{
			System.out.println("Trop de comptes créé");
		}
		return res;
	}
	
	double interets(int num){
		Compte compte=getCompte(num);
		if( compte != null && compte instanceof CompteEpargne){
			return ((CompteEpargne) compte).interets();
		}else{
			System.out.println("operation invalide");
			return 0;
		}
	}
	
	void echeance(int num){
		Compte compte=getCompte(num);
		if( compte != null && compte instanceof CompteEpargne){
			((CompteEpargne) compte).echeance();
		}else{
			System.out.println("operation invalide");
			
		}
	}
	
	void virement(int numSrc, int numDest, double x){
		Compte compteD=getCompte(numSrc);
		Compte compteC=getCompte(numDest);
		compteD.virerVers(x,compteC);
		
	}
			
		
		
}
