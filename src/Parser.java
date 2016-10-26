import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <b> Classe permettant de lire un fichier et de construire la liste des rues et des places. </b>
 * @author SOURIOT Lydia, CAILLOUX Jocelin.
 * @since 19/10/2016
 */
public class Parser {
	/** Fichier des données à lire */
	private File _fichier;
	private Scanner _lecteur;
	
	/** Instancie le parser et prend connaissance du fichier, renvoie une erreur si le fichier n'est pas valide */
	public Parser(String fichier) {
		_fichier = new File(fichier);
		
		if (!_fichier.exists()) {
			System.err.println("Le fichier " + fichier + " n'existe pas.");
		} else if (!_fichier.isFile()) {
			System.err.println(fichier + " n'est pas un fichier");
		} else {
			try {
				_lecteur = new Scanner(_fichier);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/** Lit le fichier pour construire l'arobrescence de la ville */
	public void instancierVille(ArrayList<Place> places, ArrayList<Rue> rues) {
		int nbPlace, nbRue;
		String nomRue, nomPlace1, nomPlace2;
		Place place1, place2;
		Rue rue;
		int indP1, indP2;
		
		_lecteur.useDelimiter(";|\\.");		
		nbPlace = _lecteur.nextInt();
		_lecteur.nextLine();
		nbRue = _lecteur.nextInt();
		_lecteur.nextLine();
		
		for (int i = 0; i < nbPlace; ++i) {
			places.add(new Place(_lecteur.next()));
			_lecteur.nextLine();
		}
		
		for (int i = 0; i < nbRue; ++i) {
			//_lecteur.useDelimiter(";");
			nomRue = _lecteur.next().trim();
			System.out.println("Rue : " + nomRue);
			nomPlace1 = _lecteur.next().trim();
			System.out.println("Place1 : " + nomPlace1);
			nomPlace2 = _lecteur.next().trim();
			System.out.println("Place2 : " + nomPlace2);
			_lecteur.nextLine();
			indP1 = places.indexOf(new Place(nomPlace1));
			indP2 = places.indexOf(new Place(nomPlace2));
			
			if ((indP1 != -1) && (indP2 != -1)) {
				place1 = places.get(indP1);
				place2 = places.get(indP2);
				rue = new Rue(place1, place2, nomRue);
				rues.add(new Rue(place1, place2, nomRue));
				place1.add(rue);
				place2.add(rue);
				System.out.println("");
			} else {
			/*	System.out.println("Rue : " + nomRue);
				System.out.println("Place " + nomPlace1);
				System.out.println("Place " + nomPlace2);*/
				System.out.println("indP1=" + indP1 + "\nindP2=" + indP2 + "\n");
			}
		}
		System.out.println("size places : " + places.size());
		System.out.println("size rues : " + rues.size());
	}
}
