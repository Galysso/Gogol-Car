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
	
	/** Parser de lecture dans le fichier des données */
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
		
		System.out.println("size places : " + _places.size());
		System.out.println("size rues : " + _rues.size());
	}
	
	
	@Override
	public String toString() {
		String res = new String("");
		int nbPlace = _places.size();
		int nbRue = _rues.size();
		
		for (int i = 0; i < nbPlace; ++i) {
			res += _places.get(i).toString() + "\n";
		}
		
		for (int i = 0; i < nbRue; ++i) {
			res += _rues.get(i).toString() + "\n";
		}
		
		return res;
	}
	
	/** Renvoie la ième place de la ville */
	public Place getPlace(int i) {
		return _places.get(i);
	}
	
	/** Renvoie la ième rue de la ville */
	public Rue getRue(int i) {
		return _rues.get(i);
	}


	public ArrayList<Place> getPlaces() {
		return _places;
	}
	
	public ArrayList<Rue> getRues(){
		return _rues;
	}
}
