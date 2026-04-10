import java.util.*;

public class Bibliotheque {
    
    static int TODAY= 24;
    
    // Variables d'instances
    protected Map<String,Ouvrage> ouvrages = new TreeMap<String,Ouvrage>();

    // Methodes a programmer
    // Ajoute l'Ouvrage "o" à la clé "code" dans la variable d'instance "ouvrages"
    public void add(String code, Ouvrage o){
        ouvrages.put(code,o);
    }
    
    // Renvoie la somme des emprunts des Ouvrages de la Bibliotheque
    public int totalEmprunts(){
        int tot=0;
        Iterator<Ouvrage> iter= ouvrages.values().iterator();
        
        while (iter.hasNext()){
            tot=tot+iter.next().getCompteur();
        }
        return tot;
    }

    // Affiche la liste des ouvrages de la Bibliotheque
    public void listing(){
        for(String code : ouvrages.keySet()){
            System.out.println(code+": "+ouvrages.get(code));
        }
    }

    // Permet d'emprunter l'Ouvrage dont la clé est "code"
    public void emprunter(String code)throws OuvrageInconnuException, NonDisponibleException{
    //provoque l'exception OuvrageInconnuException si le code d'ouvrage n'existe pas
    //provoque l'exception NonDisponibleException si l'ouvrage est deja emprunt'e
        try{
            ouvrages.get(code).emprunter();
            }catch(NullPointerException ex) {
                throw new OuvrageInconnuException();
            }
    }

    // Permet de retourner l'Ouvrage dont la clé est "code"
    public void retourner(String code)throws OuvrageInconnuException{
    //provoque l'exception OuvrageInconnuException si le code d'ouvrage n'existe pas
        try{
            ouvrages.get(code).retourner();
        }catch(NullPointerException ex){
            throw new OuvrageInconnuException();
        }
    }
    
    public List<Ouvrage> getOuvrages(){
        List<Ouvrage> ouvrageList = new ArrayList<>(ouvrages.values());
        
        
        Collections.sort(ouvrageList, new Comparator<Ouvrage>() {
            public int compare(Ouvrage o1, Ouvrage o2) {
                return Integer.compare(o2.getCompteur(), o1.getCompteur());
            }
        });
               
        return ouvrageList;
    }
    
    public List<Ouvrage> getOuvragesbyTitre(){
        List<Ouvrage> ouvrageList = new ArrayList<>(ouvrages.values());
        
        
        Collections.sort(ouvrageList, new Comparator<Ouvrage>() {
            public int compare(Ouvrage o1, Ouvrage o2) {
                return String.compare(o2.auteur, o1.auteur);
            }
        });
               
        return ouvrageList;
    }
    
    public List<Ouvrage>  getRevues(){
        List<Ouvrage> ouvrageList = new ArrayList<>(ouvrages.values());
        
        
        Collections.sort(ouvrageList, new Comparator<Ouvrage>() {
            public int compare(Ouvrage o1, Ouvrage o2) {
            
            }
        });
               
        return ouvrageList;
    }
    
    
    
    
}
