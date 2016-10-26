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
		String Place;
		int nbPlace, nbRue;
		Place p;
		
		_lecteur.useDelimiter(".");
		nbPlace = _lecteur.nextInt();
		places = new ArrayList<Place>(nbPlace);
		nbRue = _lecteur.nextInt();
		rues = new ArrayList<Rue>(nbRue);
		
		for (int i = 0; i < nbPlace; ++i) {
			//places.add(_lecteur.next());
		}
	}
}
