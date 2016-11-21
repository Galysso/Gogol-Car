import java.util.ArrayList;

/**
 * To find a minimum Chinese postman route we must walk
 * along each edge at least once and in addition we must also
 * walk along the least pairings of odd vertices on one extra
 * occasion.
 * An algorithm for finding an optimal Chinese postman
 * route is:
 * 
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
	private ArrayList <Rue> _ruesChemin;
	private ArrayList <Place> _placesChemin;
	
	/** Constructeurs */
	public GogolXL(Ville ville){
		_ville = ville;
		_ruesChemin = new ArrayList<Rue>();
		_placesChemin = new ArrayList<Place>();
	}
}
