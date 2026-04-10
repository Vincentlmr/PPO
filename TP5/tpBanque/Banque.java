class Banque {
	
	final static int MAX = 1000;
    
    Compte[] tableauCompte= new Compte[MAX];
    
    int compteur;
    
    
	int ouvrirCompte()throws OperationInvalide{
		int res=0;
		if(this.compteur< MAX){
			Compte newCompte = new Compte(0);
            this.tableauCompte[this.compteur]= newCompte;
            this.compteur++;
            res = compteur-1;
            
        }else{
			throw new OperationInvalide();
		}
		return res;
	}
		
	void crediter(int num, double x)throws CompteInexistant{
		if( getCompte(num) != null){
			tableauCompte[num].crediter(x);
		}
	}
	
	public Compte getCompte(int num)throws CompteInexistant{
		Compte result;
		
		if(this.compteur<num){
			throw new CompteInexistant();

		}else{
			result=tableauCompte[num];
		}
		
		return result;
	}
	
	void debiter(int numero, double x)throws CompteInexistant{
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
			
			
	String etat(int num)throws CompteInexistant{
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
	
	int ouvrirCompteEpargne()throws OperationInvalide{
		int res=0;
		if(this.compteur< MAX){
			CompteEpargne newCompte = new CompteEpargne(0,0.01);
            this.tableauCompte[this.compteur]= newCompte;
            this.compteur++;
            res = compteur-1;
            
        }else{
			throw new OperationInvalide();
		}
		return res;
	}
	
	double interets(int num)throws OperationInvalide,CompteInexistant{
		Compte compte=getCompte(num);
		if( compte != null && compte instanceof CompteEpargne){
			return ((CompteEpargne) compte).interets();
		}else{
			throw new OperationInvalide();
		}
	}
	
	void echeance(int num)throws OperationInvalide,CompteInexistant{
		Compte compte=getCompte(num);
		if( compte != null && compte instanceof CompteEpargne){
			((CompteEpargne) compte).echeance();
		}else{
			throw new OperationInvalide();
			
		}
	}
	
	void virement(int numSrc, int numDest, double x)throws CompteInexistant, OperationInvalide{
		Compte compteD=getCompte(numSrc);
		Compte compteC=getCompte(numDest);
		if( compteD != null && compteC != null ){
			compteD.virerVers(x,compteC);
		}else{
			throw new OperationInvalide();
			
		}
		
	}
			
		
		
}
