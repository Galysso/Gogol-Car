import java.util.ArrayList;

/**
 * <b> Classe de l'algorithme GogolS.</b>
 * @author SOURIOT Lydia, CAILLOUX Jocelin.
 * @since 19/10/2016
 */

public class GogolS {
	public Ville _ville;
	public ArrayList <Rue> _ruesChemin;
	public ArrayList <Place> _placesChemin;
	public ArrayList <String> _couleurs;
	
	/** Constructeurs */
	public GogolS(Ville ville){
		_ville = ville;
		_ruesChemin = new ArrayList<Rue>();
		_placesChemin = new ArrayList<Place>();
		_couleurs = new ArrayList<String>();
		for(int i = 0; i < ville.getRues().size(); i++){
			_couleurs.add("Blanc");
		}
	}
	
	/** Getteurs */
	/**public Rue getRue(int i){
		return _ruesChemin.get(i);
	}
	
	public Place getPlace(int i){
		return _placesChemin.get(i);
	}*/
	
	/** Fonctions */	
	public void AlgoS(Place p){
		int i,j;
		_placesChemin.add(p);
		for(i=0; i<p.getRues().size(); i++){
			/**On cherche l'indice de la rue dans la ville -> ajouter attribut couleur dans les rues*/
			for(j = 0;j<_ville.getRues().size();j++){
				if(_ville.getRue(j).getNom()==p.getRue(i).getNom()){
					break;
				}
			}
			/** On applique le parcours en prof */
			if(_couleurs.get(j)=="Blanc"){
				_couleurs.set(j,"Gris"); /**Rue en cours de traitement*/
				_ruesChemin.add(_ville.getRue(j));
				if(_ville.getRue(j).getP1().getNom()==p.getNom()){
					AlgoS(_ville.getRue(j).getP2());
				}
				else{
					AlgoS(_ville.getRue(j).getP1());
				}
				_couleurs.set(j,"Noir");
				_ruesChemin.add(_ville.getRue(j)); /** on remonte le chemin */
				_placesChemin.add(p);
			}
		}
	}
	
	/** Affichage */
	@Override
	public String toString() {
		String res = new String("Chemin : (");
		
		for (int i = 0; i < _placesChemin.size()-1; ++i) {
			res += _placesChemin.get(i).getNom()+ " -> "
			+_ruesChemin.get(i).getNom() + " \n ";
		}
		res += _placesChemin.get(_placesChemin.size()-1)+"\n";
		
		return res;
	}
}
