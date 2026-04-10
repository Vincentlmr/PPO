import java.awt.geom.*;

class Rectangle {
	Point2D.Double origine, corner;

	Rectangle(double xo, double yo, double xc, double yc) {
		this.origine = new Point2D.Double(xo, yo);
		this.corner = new Point2D.Double(xc, yc);
	}

	double largeur() {
		return corner.getX() - origine.getX();
	}

	// ...
}
	