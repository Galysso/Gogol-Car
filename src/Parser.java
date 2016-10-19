import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * <b> Classe permettant de lire un fichier et de construire la liste des rues et des places. </b>
 * @author SOURIOT Lydia, CAILLOUX Jocelin.
 * @since 19/10/2016
 */
public class Parser {
	/** Fichier des données à lire */
	private File _fichier;
	private FileReader _lecteur;
	
	/** Instancie le parser et prend connaissance du fichier, renvoie une erreur si le fichier n'est pas valide */
	public Parser(String fichier) {
		_fichier = new File(fichier);
		
		if (!_fichier.exists()) {
			System.err.println("Le fichier " + fichier + " n'existe pas.");
		} else if (!_fichier.isFile()) {
			System.err.println(fichier + " n'est pas un fichier");
		}
	}
	
	/** Lit le fichier pour construire l'arobrescence de la ville */
	public void instancierVille(ArrayList<Place> places, ArrayList<Rue> rues) {
		//TODO
	}
}
