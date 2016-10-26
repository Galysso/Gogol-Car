import java.util.ArrayList;

/**
 * <b> Classe représentant une place (un sommet du graphe).</b>
 * @author SOURIOT Lydia, CAILLOUX Jocelin.
 * @since 19/10/2016
 */
public class Place {
	/** Nom de la place */
	private String _nom;
	/** Nombre de rues reliées à la ville */
	private int _nbRue;
	/** Liste des rues reliées à la place */
	private ArrayList<Rue> _rues;
	
	
	
	/** Constructeur de la place */
	public Place(ArrayList<Rue> rues, String nom) {
		_nom = nom;
		_nbRue = rues.size();
		_rues = rues;
	}
	
	
	
	
	@Override
	public String toString() {
		String res = new String(_nom + " : (");
		
		for (int i = 0; i < _nbRue; ++i) {
			res += _rues.get(i).getNom() + " - ";
		}
		res += ")";
		
		return res;
	}
	
	public String getNom() {
		return _nom;
	}
	
	public ArrayList<Rue> getRues() {
		return _rues;
	}
	
	public Rue getRue(int i) {
		return _rues.get(i);
	}
}
