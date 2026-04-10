package lib;
import java.util.*;
import java.io.*;


public class Bibliotheque {
    // Variables d'instances
    protected Map<String,Ouvrage> ouvrages = new TreeMap<String,Ouvrage>();
    static int TODAY = 25;

    // Methodes a programmer
    // Ajoute l'Ouvrage "o" à la clé "code" dans la variable d'instance "ouvrages"
    public void add(String code, Ouvrage o) {
        ouvrages.put(code,o);
    }

    // Renvoie la somme des emprunts des Ouvrages de la Bibliotheque
    public int totalEmprunts() {
        int nbTotalEmprunts = 0;
        for (Ouvrage o : ouvrages.values()) {
            nbTotalEmprunts += o.getCompteur();
        }
        return nbTotalEmprunts;
    }

    // Affiche la liste des ouvrages de la Bibliotheque
    public void listing() {
        System.out.println("Bibliotheque :");
        for (String code : ouvrages.keySet()) {
            System.out.println(code + " : " + ouvrages.get(code));
        }
    }

    // Permet d'emprunter l'Ouvrage dont la clé est "code"
    public void emprunter(String code) throws NonDisponibleException, OuvrageInconnuException {
        try {
            ouvrages.get(code).emprunter();
        } catch(NullPointerException npe) {
            throw new OuvrageInconnuException();
        }
    }
    //provoque l'exception OuvrageInconnuException si le code d'ouvrage n'existe pas
    //provoque l'exception NonDisponibleException si l'ouvrage est deja emprunt'e

    // Permet de retourner l'Ouvrage dont la clé est "code"
    public void retourner(String code) {
        ouvrages.get(code).retourner();
    }
    //provoque l'exception OuvrageInconnuException si le code d'ouvrage n'existe pas

    public List<Ouvrage> getOuvrages() {
        List<Ouvrage> liOut = new ArrayList<Ouvrage>(this.ouvrages.values());
        Collections.sort(liOut, (o1,o2) -> {return o1.getCompteur() - o2.getCompteur();});
        return liOut;
    }

    public List<Ouvrage> getOuvragesByTitre() {
        List<Ouvrage> liOut = new ArrayList<Ouvrage>(this.ouvrages.values());
        Collections.sort(liOut, (o1,o2) -> {return o1.getTitre().compareTo(o2.getTitre());});
        return liOut;
    }

    public List<Revue> getRevues() {
        List<Revue> liOut = new ArrayList<Revue>();
        for (Ouvrage o : this.ouvrages.values()) {
            if (o instanceof Revue) {
                liOut.add((Revue) o);
            }
        }
        Collections.sort(liOut, (o1,o2) -> {return o1.getDate() - o2.getDate();});
        return liOut;
    }

    public void save(String backupName) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(backupName));
        out.writeObject(ouvrages);
        out.close();
    }

    @SuppressWarnings("unchecked")
    public void load(String backupName) throws IOException,ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(backupName));
        ouvrages = (Map<String,Ouvrage>)in.readObject();
        in.close();
    }
}
