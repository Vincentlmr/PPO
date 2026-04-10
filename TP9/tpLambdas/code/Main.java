
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import tracking.*;

public class Main {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("usage: manque nom de fichier trace en parametre du main");
			System.exit(1);
		}

		try {
			BufferedReader traceFile = new BufferedReader(new FileReader(args[0]));

			// II.2.1.2 afficher le fichier ligne par ligne
			traceFile.lines() // Stream<String>
			//.forEach(line -> System.out.println(line)); 
			.forEach(System.out::println);

			// II.2.2.1 Idem par reference de methode
			traceFile = new BufferedReader(new FileReader(args[0]));
			
			System.out.println("Liste directories:");
			traceFile.lines()
			.filter(line -> line.contains("[d"))
			.forEach(System.out::println);
			
			traceFile = new BufferedReader(new FileReader(args[0]));
			
			System.out.println("Nombre de directories:");
			System.out.println(
			traceFile.lines()
			.filter(line -> line.contains("[d"))
			.count());
			
			
			System.out.println("Liste fichier:");
			traceFile = new BufferedReader(new FileReader(args[0]));
			
			traceFile.readLine(); 
			traceFile.lines()
			.filter(line -> !line.contains("[d"))
			.forEach(System.out::println);
		
			traceFile = new BufferedReader(new FileReader(args[0]));
			
			System.out.println("Nombre de fichiers:");
			System.out.println(
			traceFile.lines()
			.filter(line -> !line.contains("[d"))
			.count());
			
			
			//3
			
			traceFile = new BufferedReader(new FileReader(args[0]));
			
			List<String> filesDescriptions = traceFile.lines()
                    .filter(line -> !line.contains("[d"))
                    .collect(Collectors.toList());
			
			System.out.println("Files Descriptions:");	filesDescriptions.stream().forEach(System.out::println);
			
			//4
			
			System.out.println("Question 4:");
			
			Tracker trackerFile = new Tracker(filesDescriptions);
			
			System.out.println("fichiers:");
			trackerFile.printFichiers();
			
			System.out.println("date anterieur:");
			trackerFile.printOldFiles(20230930);
			
			System.out.println("nombre date anterieur:");
			System.out.println(trackerFile.nbOldFiles(20220930));
			
			
			
			

		} catch (IOException e) {
			System.err.println("erreur d'acces au fichier " + args[0]);
			e.printStackTrace();
			System.exit(1);
		}

	}
}
