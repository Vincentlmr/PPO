package gen;

import java.util.*;
import java.io.*;
import lib.*;

public class LibrairieSpe<E extends Ouvrage> extends Librairie<E> {
    public int totalEmprunts() {
        int nbTotalEmprunts = 0;
        for (E o : elements.values()) {
            nbTotalEmprunts += o.getCompteur();
        }
        return nbTotalEmprunts;
    }

    public void emprunter(String code) throws NonDisponibleException, OuvrageInconnuException {
        try {
            this.get(code).emprunter();
        } catch(NullPointerException npe) {
            throw new OuvrageInconnuException();
        }
    }
    //provoque l'exception OuvrageInconnuException si le code d'ouvrage n'existe pas
    //provoque l'exception NonDisponibleException si l'ouvrage est deja emprunt'e

    // Permet de retourner l'Ouvrage dont la clé est "code"
    public void retourner(String code) {
        this.get(code).retourner();
    }
    //provoque l'exception OuvrageInconnuException si le code d'ouvrage n'existe pas

    public List<E> getOuvrages() {
        List<E> liOut = new ArrayList<E>(this.elements.values());
        Collections.sort(liOut, (o1,o2) -> {return o1.getCompteur() - o2.getCompteur();});
        return liOut;
    }

    public List<E> getOuvragesByTitre() {
        List<E> liOut = new ArrayList<E>(this.elements.values());
        Collections.sort(liOut, (o1,o2) -> {return o1.getTitre().compareTo(o2.getTitre());});
        return liOut;
    }



    public void save(String backupName) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(backupName));
        out.writeObject(elements);
        out.close();
    }

    @SuppressWarnings("unchecked")
    public void load(String backupName) throws IOException,ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(backupName));
        elements = (Map<String,E>)in.readObject();
        in.close();
    }
}
