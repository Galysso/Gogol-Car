import java.util.ArrayList;

/**
 * To find a minimum Chinese postman route we must walk
 * along each edge at least once and in addition we must also
 * walk along the least pairings of odd vertices on one extra
 * occasion.
 * An algorithm for finding an optimal Chinese postman
 * route is:
 *//*
 * Step 1 :
 * List all odd vertices.
 *
 * Step 2 :
 * List all possible pairings of odd vertices.*/
 /**
 * Step 3 :
 * For each pairing find the edges that connect the
 * vertices with the minimum weight.
 * 
 * Step 4 :
 * Find the pairings such that the sum of the weights
 * is minimised.
 * 
 * Step 5 :
 * On the original graph add the edges that have been
 * found in Step 4.
 * 
 * Step 6 :
 * The length of an optimal Chinese postman route is
 * the sum of all the edges added to the total found
 * in Step 4.
 * 
 * Step 7 :
 * A route corresponding to this minimum weight
 * can then be easily found
 **/
public class GogolXL {
	private Ville _ville;
	private ArrayList <Place> _oddVertices;
	private ArrayList <Paire> _pairings;
	private ArrayList<ArrayList<Integer>> _distancier;
	private class Paire {
		public Paire(Place p1, Place p2) {this.p1=p1;this.p2=p2;}
		public Place p1;
		public Place p2;
	}
	
	/** Constructeurs */
	public GogolXL(Ville ville){
		int nbPlace = ville.getNbPlace();
		_ville = ville;
		_oddVertices = new ArrayList<Place>();
		_pairings = new ArrayList<Paire>(nbPlace*(nbPlace-1)/2);
		_distancier = new ArrayList<ArrayList<Integer>>(nbPlace);
		for (int i = 0; i < nbPlace; ++i) {
			_distancier.add(i, new ArrayList<Integer>(nbPlace));
		}
	}
	
	
	public void listOddVertices() {
		ArrayList<Place> places = _ville.getPlaces();
		int nbPlace = places.size();
		
		for (int i = 0; i < nbPlace; ++i) {
			if ((places.get(i).getNbRue() % 2) == 1) {
				_oddVertices.add(places.get(i));
				//System.out.println("Impair : " + places.get(i).toString());
			}
		}
	}
	
	public void pairingOddVertices() {
		int nbPlace = _oddVertices.size();
		Paire paire;
		
		for (int i = 0; i < nbPlace; ++i) {
			for (int j = i+1; j < nbPlace; ++j) {
				paire = new Paire(_oddVertices.get(i), _oddVertices.get(j));
				//System.out.println(paire.p1 + "\t" + paire.p2);
				_pairings.add(paire);
			}
		}
	}
	
	public void floydWarshall() {
		ArrayList<Place> places = _ville.getPlaces();
		ArrayList<Rue> rues = _ville.getRues();
		int nbPlace = places.size();
		
		// Initialisation du distancier
		for (int i = 0; i < nbPlace; ++i) {
			//_distancier.add(i, new ArrayList<Integer>(nbPlace));
			for (int j = i; j < nbPlace; ++j) {
				//System.out.println("i="+i+"\tj="+j);
				if (places.get(i).isConnectedTo(places.get(j))) {
					_distancier.get(i).add(j, 1);
					_distancier.get(j).add(i, 1);
				} else {
					//System.out.println("i="+i+"\tj="+j);
					_distancier.get(i).add(j, 0);
					_distancier.get(j).add(i, 0);
				}
			}
		}
		for (int i = 0; i < nbPlace; ++i) {
			System.out.print("\t" + places.get(i).getNom());
		}
		System.out.println();
		for (int i = 0; i < nbPlace; ++i) {
			System.out.print(places.get(i).getNom());
			for (int j = 0; j < nbPlace; ++j) {
				System.out.print("\t" + _distancier.get(i).get(j));
			}
			System.out.println();
		}
	}
}















