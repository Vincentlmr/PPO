package lib;
import java.util.*;
import java.io.*;
import gen.*;

public class Bibliotheque extends LibrairieSpe<Ouvrage> {
    // Variables d'instances
    static int TODAY = 25;

    public List<Revue> getRevues() {
        List<Revue> liOut = new ArrayList<Revue>();
        for (Ouvrage o : this.elements.values()) {
            if (o instanceof Revue) {
                liOut.add((Revue) o);
            }
        }
        Collections.sort(liOut, (o1,o2) -> {return o1.getDate() - o2.getDate();});
        return liOut;
    }
}
