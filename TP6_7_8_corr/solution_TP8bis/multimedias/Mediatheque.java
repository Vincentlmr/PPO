package multimedias;
import java.util.*;
import lib.Bibliotheque;
import lib.Ouvrage;

public class Mediatheque extends Bibliotheque {
    public List<CD> cds() {
        List<CD> out = new ArrayList<CD>();
        for (Ouvrage o: this.elements.values()) {
            if (o instanceof CD) {
                out.add((CD) o);
            }
        }
        return out;
    }
}
