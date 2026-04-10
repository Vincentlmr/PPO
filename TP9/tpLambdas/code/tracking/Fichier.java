package tracking;

/**
 * Synthetic file description object
 * 
 * @author Bernard.Carre -at- polytech-lille.fr
 */

import java.util.Scanner;

public class Fichier {
	protected String fullName;
	protected int size;
	protected int date; // AAAAMMJJ
	protected boolean executable;

	// Constructor: fills fields by scanning a file description line as offered by commands like "tree"  
	public Fichier(String description) {
		Scanner scanDescription = new Scanner(description);		
		String subString;
		// 1. type and permissions : ignore
		subString = scanDescription.next();
		// 2. size
		subString = scanDescription.next();
		this.size = Integer.parseInt(subString); 
		// 3. "date]"
		subString = scanDescription.next();
		// delete ending char ']'
		subString = subString.substring(0, subString.length()-1);
		this.date = Integer.parseInt(subString);
		// 4. "fullName"
		subString = scanDescription.next();
		this.fullName = subString;
		// 5. is executable ?
		if (subString.endsWith("*")) {
			this.executable = true;
		}		
		scanDescription.close();		
	}

	// Methods
	public String toString() {
		return "fullName=" + fullName + ", size=" + size + ", date=" + date + ", executable="
				+ executable;
	}

	public int getDate() {
		return this.date;
	}

	public boolean isExecutable() {
		return this.executable;
	}

	public int getSize() {
		return size;
	}
	
}
