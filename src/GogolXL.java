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
 * List all possible pairings of odd vertices.
 *
 * Step 3 :
 * For each pairing find the edges that connect the
 * vertices with the minimum weight.
 *
 * Step 4 :
 * Find the pairings such that the sum of the weights
 * is minimised.
 * 
 *//** 
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
	private ArrayList<ArrayList<Integer>> _predecesseurs;
	private ArrayList<Paire> _pairesPoidsMin;
	private class Paire {
		public Paire(Place p1, Place p2) {this.p1=p1;this.p2=p2;}
		public Place p1;
		public Place p2;
		public int i1;
		public int i2;
		public int weight;
	}
	
	/** Constructeurs */
	public GogolXL(Ville ville){
		int nbPlace = ville.getNbPlace();
		_ville = ville;
		_oddVertices = new ArrayList<Place>();
		_pairings = new ArrayList<Paire>(nbPlace*(nbPlace-1)/2);
		_distancier = new ArrayList<ArrayList<Integer>>(nbPlace);
		_predecesseurs = new ArrayList<ArrayList<Integer>>(nbPlace);
		for (int i = 0; i < nbPlace; ++i) {
			_distancier.add(i, new ArrayList<Integer>(nbPlace));
			_predecesseurs.add(i, new ArrayList<Integer>(nbPlace));
		}
		_pairesPoidsMin = new ArrayList<Paire>();
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
				paire.i1 = _ville.getPlaces().indexOf(paire.p1);
				paire.i2 = _ville.getPlaces().indexOf(paire.p2);
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
				if (i==j) {
					_distancier.get(i).add(j, 0);
					_predecesseurs.get(i).add(j, j);
				} else if (places.get(i).isConnectedTo(places.get(j))) {
					_distancier.get(i).add(j, 1);
					_distancier.get(j).add(i, 1);
					_predecesseurs.get(i).add(j,i);
					_predecesseurs.get(j).add(i,j);
				} else {
					//System.out.println("i="+i+"\tj="+j);
					_distancier.get(i).add(j, -1);
					_distancier.get(j).add(i, -1);
					_predecesseurs.get(i).add(j,-1);
					_predecesseurs.get(j).add(i,-1);
				}
			}
		}
		
		// Initialisation validée et testée
		
		int Dij, Dik, Dkj;
		for (int k = 0; k < nbPlace; ++k) {
			for (int i = 0; i < nbPlace; ++i) {
				for (int j = 0; j < nbPlace; ++j) {
					Dij = _distancier.get(i).get(j);
					Dik = _distancier.get(i).get(k);
					Dkj = _distancier.get(k).get(j);
					if (((Dik!=-1)&&(Dkj!=-1))&&((Dij==-1)||(Dij>Dik+Dkj))) {
						_distancier.get(i).set(j, Dik+Dkj);
						_predecesseurs.get(i).set(j,k);
					}
				}
			}
		}
		
		/*for (int i = 0; i < nbPlace; ++i) {
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
		System.out.println();*/
		/*for (int i = 0; i < nbPlace; ++i) {
			System.out.print(places.get(i).getNom());
			for (int j = 0; j < nbPlace; ++j) {
				System.out.print("\t" + _predecesseurs.get(i).get(j));
			}
			System.out.println();
		}*/
	}
	
	public void setPairingWeights() {
		int nbOdd = _pairings.size();
		Paire p;
		for (int i = 0; i < nbOdd; ++i) {
			p = _pairings.get(i);
			p.weight = _distancier.get(p.i1).get(p.i2);
			//System.out.println(p.weight);
		}
	}
	
	public void heuristicMinimumWeightPairs() {
		boolean estTrie = true;
		int nbOdd = _pairings.size();
		Paire p, p1, p2;
		
		do {
			estTrie = true;
			p1 = _pairings.get(0);
			for (int i = 1; i < nbOdd; ++i) {
				p2 = _pairings.get(i);
				if (/*(p1.i1 == p2.i1) &&*/ (p2.weight < p1.weight)) {
					_pairings.set(i-1,p2);
					_pairings.set(i,p1);
					estTrie = false;
				} else {
					p1 = p2;
				}
			}
		} while (!estTrie);
		
		// L'instance ne permet pas de bien tester la fonction de tri
		for (int i = 0; i < nbOdd; ++i) {
			p1 = _pairings.get(i);
			System.out.println(p1.i1+","+p1.i2+": "+p1.weight);
		}
		
		ArrayList<Integer> indicesCouples = new ArrayList<Integer>();
		
		for (int i = 0; i < nbOdd; ++i) {
			p = _pairings.get(i);
			if ((indicesCouples.indexOf(p.i1) == -1) && (indicesCouples.indexOf(p.i2) == -1)) {
				indicesCouples.add(p.i1);
				indicesCouples.add(p.i2);
				_pairesPoidsMin.add(p);
				System.out.println(p.i1+","+p.i2);
			}
		}
	}
}















