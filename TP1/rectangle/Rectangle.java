import java.awt.geom.Point2D;

class Rectangle {
    //Parametre
    Point2D.Double origine;
    Point2D.Double corner;
    
    // Constucteur 
    Rectangle(double newXOrigine, double newYOrigine,double newXCorner, double newYCorner) {
        this.origine = new Point2D.Double(newXOrigine,newYOrigine);
        this.corner = new Point2D.Double(newXCorner,newYCorner);
    }
    
    
    // Methode 
    double largeur() {
        return this.corner.getY() - this.origine.getY();
    }
    
    double longeur() {
        return this.corner.getX() - this.origine.getX();
    }
    
    double surface() {
        return largeur() * longeur();
    }
    
    double perimetre() {
        return (largeur() + longeur())*2;
    }
    
    public String toString() {
        return "(<" + this.origine + "> , <" + this.corner + ">)";
    }
}
