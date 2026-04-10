package tracking;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
/**
 * "Tracker" de fichiers
 * 
 * @author Bernard.Carre -at- polytech-lille.fr
 */

import java.util.List;

public class Tracker {

	protected List<Fichier> fichiers;

	public List<String> filesDescriptions;
	
	public Tracker(List<String> filesDescriptions){
		this.filesDescriptions = filesDescriptions;
		this.fichiers= filesDescriptions.stream()
            .map(Fichier::new)  
            .collect(Collectors.toList());
    }
    
    public void printFichiers(){
		fichiers.stream()
			.forEach(System.out::println);
	}
	
	public void printOldFiles(int date){
		fichiers.stream()
			.filter(fichiers -> fichiers.getDate() < date)  
			.forEach(System.out::println);
	}
	
	public int nbOldFiles(int date){
		return (int)(fichiers.stream()
			.filter(fichiers -> fichiers.getDate() < date)  
			.count());
	}
}
