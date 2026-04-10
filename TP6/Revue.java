class Revue extends Ouvrage {

    int date;
    
    Revue(String newTitre, String newAuteur ,int newDate) {
        super(newTitre,newAuteur);
        this.date = newDate;
    }
    
    public void emprunter()throws NonDisponibleException{
        if( Bibliotheque.TODAY< this.date+7){
            throw new NonDisponibleException();
        }
        super.emprunter();
    }
    
    public String toString() {
        return super.toString() + ", Date d'édition: " + date;
    }
        
}
