import java.util.ArrayList;

/**
 * <b> Classe de l'algorithme GogolS.</b>
 * @author SOURIOT Lydia, CAILLOUX Jocelin.
 * @since 19/10/2016
 */

public class GogolL {
	public Ville _ville;
	public ArrayList <Rue> _ruesChemin;
	public ArrayList <Place> _placesChemin;
	public ArrayList <String> _couleurSommets;
	public ArrayList <String> _couleurAretes;
	public ArrayList <String> _arborescence;
	
	/** Constructeurs */
	public GogolL(Ville ville){
		_ville = ville;
		_ruesChemin = new ArrayList<Rue>();
		_placesChemin = new ArrayList<Place>();
		_couleurAretes = new ArrayList <String> ();
		_couleurSommets = new ArrayList<String>();
		_arborescence = new ArrayList<String>();
		for(int i = 0; i < ville.getRues().size(); i++){
			_couleurSommets.add("Blanc");
		}
		for(int i = 0;i<ville.getPlaces().size();i++){
			_couleurAretes.add("Blanc");
			_arborescence.add("0");
		}
		
	}

	
	/** Fonctions */
	public void Arborescence(Place p){
		int i,j,r;
		_placesChemin.add(p);
		/** On cherche l'indice de notre place dans la ville */
		for(i=0;i<_ville.getPlaces().size();i++){
			if(_ville.getPlace(i).getNom()==p.getNom()){
				break;
			}
		}
		/** on la met en cours de traitement*/
		_couleurSommets.set(i, "Gris");
		
		/** pour toutes les rues voisines */
		for(r = 0;r < p.getRues().size();r++){
			/** on cherche l'indice de la place voisine de notre place */ 
			for(j=0;j<_ville.getPlaces().size();j++){
				if((_ville.getPlace(j).getNom()==p.getRue(r).getP1().getNom())||(_ville.getPlace(j).getNom()==p.getRue(r).getP2().getNom())&&(i != j)){
					break;
				}
			}
			if(_couleurSommets.get(j)=="Blanc"){
				_arborescence.set(j, "1"); //on la met dans l'arborescence
				if (_ville.getPlace(j).getNom()==p.getRue(r).getP1().getNom()){
					Arborescence(p.getRue(r).getP1());
				}
				else{
					Arborescence(p.getRue(r).getP2());
				}
			}
			
		}
		
		/** Fin du traitement */
		_couleurSommets.set(i, "Noir");
	}
	
	public void AlgoL(Place p){
		int i,j,r;
		_placesChemin.add(p);
		
		/** Pour toutes les rues de la place */
		for(i=0; i<p.getRues().size(); i++){
			
			/**On cherche l'indice de la rue dans la ville*/
			for(r = 0;r<_ville.getRues().size();r++){
				if(_ville.getRue(r).getNom()==p.getRue(i).getNom()){
					break;
				}
			}
			/** On cherche l'indice de la deuxieme place associee */ 
			for(j=0;j<_ville.getPlaces().size();j++){
				if(((_ville.getPlace(j).getNom()==p.getRue(r).getP1().getNom())||(_ville.getPlace(j).getNom()==p.getRue(r).getP2().getNom()))&&(_ville.getPlace(j).getNom()!=p.getNom())){
					break;
				}
			}
			System.out.println("tadaaaaaaaaaa\n");
			/** On applique le parcours */
			if((_couleurAretes.get(r)=="Blanc")&&(_arborescence.get(j)=="0")){ /** Priorite sur ceux qui sont pas dans l'arborescence */
				_couleurAretes.set(r,"Gris"); /**Rue en cours de traitement*/
				_ruesChemin.add(_ville.getRue(r));
				System.out.println("tadaaaaaaaaaa\n");
				if(_ville.getRue(r).getP1().getNom()==p.getNom()){
					AlgoL(_ville.getRue(r).getP2());
				}
				else{
					AlgoL(_ville.getRue(r).getP1());
				}
				_couleurAretes.set(r,"Noir");
			}
		}
		for(i=0; i<p.getRues().size(); i++){
			/**On cherche l'indice de la rue dans la ville*/
			for(r = 0;r<_ville.getRues().size();r++){
				if(_ville.getRue(r).getNom()==p.getRue(i).getNom()){
					break;
				}
			}
			/** On applique le parcours */
			System.out.println("tadaaaaaaaaaa\n");
			if((_couleurAretes.get(r)=="Blanc")){
				System.out.println("tadaaaaaaaaaa\n");
				_couleurAretes.set(r,"Gris"); /**Rue en cours de traitement*/
				_ruesChemin.add(_ville.getRue(r));
				if(_ville.getRue(r).getP1().getNom()==p.getNom()){
					AlgoL(_ville.getRue(r).getP2());
				}
				else{
					AlgoL(_ville.getRue(r).getP1());
				}
				_couleurAretes.set(r,"Noir");
			}
		}
	}
	
	/** Affichage */
	@Override
	public String toString() {
		String res = new String("\nChemin : (");
		
		for (int i = 0; i < _placesChemin.size(); ++i) {
			res += _placesChemin.get(i).getNom()+ " -> ";
			//+_ruesChemin.get(i).getNom() + " \n ";
		}
		res += _placesChemin.get(_placesChemin.size()-1).getNom()+"\n";
		
		for (int i = 0;i < _ruesChemin.size();i++){
			res += "\n"+_ruesChemin.get(i).getNom()+"->";
		}
		res += _ruesChemin.size();
		
		return res;
	}
}
