
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
			.forEach(line -> System.out.println(line)); 

			// II.2.2.1 Idem par reference de methode
			traceFile = new BufferedReader(new FileReader(args[0]));
			// traceFile.lines() ...

			// SUITE DU TP ...

		} catch (IOException e) {
			System.err.println("erreur d'acces au fichier " + args[0]);
			e.printStackTrace();
			System.exit(1);
		}

	}
}
