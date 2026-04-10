package applications;
import lib.*;
import multimedias.*;
import java.io.*;
import gen.*;

public class TestGen {
    public static void main(String[] argv) {

        LibrairieSpe<CD> bib = new LibrairieSpe<CD>();

        // bib.add("I345",new Ouvrage("Java","Eckel"));
        // bib.add("R03",new Revue("CC","De",12));
        bib.add("C35",new CD("Disp","PP"));
        bib.add("C34",new CD("Pop","OO"));
        bib.add("C25",new CD("Abba","PP"));
        bib.listing();
        System.out.println(bib.getOuvragesByTitre());

    }
}
