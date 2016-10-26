/**
 * <b> Classe représentant une rue (une arête du graphe).</b>
 * @author SOURIOT Lydia, CAILLOUX Jocelin.
 * @since 19/10/2016
 */
public class Rue {
	/** Nom de la rue */
	private String _nom;
	/** Première place reliée par la rue */
	private Place _p1;
	/** Deuxième place reliée par la rue */
	private Place _p2;
	
	public Rue(Place p1, Place p2, String nom) {
		_nom = nom;
		_p1 = p1;
		_p2 = p2;
	}
	
	
	
	@Override
	public String toString() {
		return _nom + " : " + _p1.getNom() + " <=> " + _p2.getNom();
	}
	
	public String getNom() {
		return _nom;
	}
	
	public Place getP1() {
		return _p1;
	}
	
	public Place getP2() {
		return _p2;
	}
}
