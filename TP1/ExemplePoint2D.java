/**
 * La classe ExemplePoint2D propose un exemple d'utilisation de la bibliothèque Point2D de java.awt.geom.
 */

// Importation de la bibliothèque Point2D
import java.awt.geom.Point2D;

public class ExemplePoint2D {
    public static void main(String[] args) {
        Point2D.Double p1 = new Point2D.Double(2.3,3.4);
        Point2D.Double p2 = new Point2D.Double(5.6,10);
        System.out.println("p1 : " + p1);
        System.out.println("p2 : " + p2);
        System.out.println("Distance entre p1 et p2 : " + p1.distance(p2));
    }
}
