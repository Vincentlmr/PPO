public class Revue extends Ouvrage {
    int date;

    Revue(String tit, String aut, int date) {
        super(tit,aut);
        this.date = date;
    }

    public String toString() {
		return super.toString()+ ", date : " + date;
	}

    @Override
    public void emprunter() throws NonDisponibleException {
        if (date+7 >= Bibliotheque.TODAY) {
            throw new NonDisponibleException();
        } else {
            super.emprunter();
        }
    }

    public int getDate() {
        return this.date;
    }

}
