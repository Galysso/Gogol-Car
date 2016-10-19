import java.util.ArrayList;

/**
 * <b> Classe représentant la ville du problème (le graphe).</b>
 * @author SOURIOT Lydia, CAILLOUX Jocelin.
 * @since 19/10/2016
 */
public class Ville {
	/** Liste des places de la ville */
	private ArrayList<Place> _places;
	
	/** Liste des rues de la ville */
	private ArrayList<Rue> _rues;
	
	private Parser _parser;
	
	/**
	 * Instancie la ville avec ses rues et ses places
	 * @see Parser#instancierVille(ArrayList<Place>, ArrayList<Rue>)
	 */
	public Ville(String fichier) {
		_parser = new Parser(fichier);
		_places = new ArrayList<Place>();
		_rues = new ArrayList<Rue>();
		
		_parser.instancierVille(_places, _rues);
	}
	
	
	
	
	
	public Place getPlace(int i) {
		return _places.get(i);
	}
	
	public Rue getRue(int i) {
		return _rues.get(i);
	}
}
