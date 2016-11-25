import java.util.ArrayList;

/**
 * <b> Classe de l'algorithme GogolS.</b>
 * @author SOURIOT Lydia, CAILLOUX Jocelin.
 * @since 19/10/2016
 */

public class GogolL {
	private Ville _ville;
	private ArrayList <Rue> _ruesChemin;
	private ArrayList <Place> _placesChemin;
	private ArrayList <String> _couleurSommets;
	private ArrayList <String> _couleurAretes;
	private ArrayList <String> _arborescence;
	
	/** Constructeurs */
	public GogolL(Ville ville){
		_ville = ville;
		_ruesChemin = new ArrayList<Rue>();
		_placesChemin = new ArrayList<Place>();
		_couleurAretes = new ArrayList <String> ();
		_couleurSommets = new ArrayList<String>();
		_arborescence = new ArrayList<String>();
		for(int i = 0; i < ville.getRues().size(); i++){
			_couleurAretes.add("Blanc");
			_arborescence.add("0");
		}
		for(int i = 0;i<ville.getPlaces().size();i++){
			_couleurSommets.add("Blanc");
		}
		
	}
	
	public void AlgoL(Place p){
		ArrayList<Place> placesImpaires = new ArrayList<Place>();
		for(int i = 0; i <_ville.getPlaces().size();i++){
			if(_ville.getPlace(i).getRues().size()%2 != 0){
				placesImpaires.add(_ville.getPlace(i));
			}
		}
		if(placesImpaires.size()>2){
			System.out.println("Error : graphe non eulérien");
            System.exit (0);
		}
		if((placesImpaires.size()>0) && (p.getRues().size()%2 != 1)){
			System.out.println("Graphe eulérien avec sommets impaires et place non valide. Au lieu de "+ p.getNom() +" Prenez les places : ");
			for(int i = 0; i<placesImpaires.size();i++){
				System.out.println(placesImpaires.get(i).getNom());
			}
            System.exit (0);
		}
		Arborescence(p);
		RechercheL(p);
		System.out.println(toString());
	}

	
	/** Fonctions */
	public void Arborescence(Place p){ //on construit l'arborescence (ici = anti arborescence)
		int i,j,r,rue;
		_placesChemin.add(p);
		/** On cherche l'indice de notre place dans la ville */
		for(i=0;i<_ville.getPlaces().size();i++){
			if(_ville.getPlace(i).getNom()==p.getNom()){
				break;
			}
		}
		/** on la met en cours de traitement*/
		_couleurSommets.set(i, "Gris");
		
		/** pour toutes les rues qui partent de la place */
		for(r = 0;r < p.getRues().size();r++){
			/** on cherche l'indice de la rue */
			for(rue=0;rue<_ville.getRues().size();rue++){
				if(_ville.getRue(rue).getNom()==p.getRue(r).getNom()){
					break;
				}
			}
			/** on cherche l'indice de la place voisine par la rue considérée */ 
			for(j=0;j<_ville.getPlaces().size();j++){
				if(((_ville.getPlace(j).getNom()==p.getRue(r).getP1().getNom())||(_ville.getPlace(j).getNom()==p.getRue(r).getP2().getNom()))&&(i != j)){
					break;
				}
			}
			/** si elle n'est pas encore traitée */
			if(_couleurSommets.get(j)=="Blanc"){
				_arborescence.set(rue, "1");
				/** on la met dans l'arborescence -> et on descend dessus */
				if (_ville.getPlace(j).getNom()==p.getRue(r).getP1().getNom()){
					Arborescence(p.getRue(r).getP1());
				}
				else{
					Arborescence(p.getRue(r).getP2());
				}
			}
			
		}
		//System.out.println(p.getNom());
		/** Fin du traitement */
		_couleurSommets.set(i, "Noir");
	}
	
	public void RechercheL(Place p){
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
				if(
				(_ville.getPlace(j).getNom()!=p.getNom())&& // si c'est pas la premiere place
				((_ville.getPlace(j).getNom()==_ville.getRue(r).getP1().getNom())
				||(_ville.getPlace(j).getNom()==_ville.getRue(r).getP2().getNom())))
				{
					break;
				}
			}
			
			/** On applique le parcours */
			if((_couleurAretes.get(r)=="Blanc")&&(_arborescence.get(r)=="0")){ /** Priorite sur ceux qui sont pas dans l'arborescence */
				_couleurAretes.set(r,"Gris"); /**Rue en cours de traitement*/
				_ruesChemin.add(_ville.getRue(r));
				
				if(_ville.getRue(r).getP1().getNom()==p.getNom()){
					//System.out.println("1 " + _ville.getRue(r).getP2());
					RechercheL(_ville.getRue(r).getP2());
				}
				
				else{
					//System.out.println("1 " + _ville.getRue(r).getP1());
					RechercheL(_ville.getRue(r).getP1());
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
			if((_couleurAretes.get(r)=="Blanc")){
				//System.out.println("tadaaaaaaaaaa\n");
				_couleurAretes.set(r,"Gris"); /**Rue en cours de traitement*/
				_ruesChemin.add(_ville.getRue(r));
				
				if(_ville.getRue(r).getP1().getNom()==p.getNom()){
					//System.out.println(_ville.getRue(r).getP2());
					RechercheL(_ville.getRue(r).getP2());
				}
				else{
					//System.out.println(_ville.getRue(r).getP1());
					RechercheL(_ville.getRue(r).getP1());
				}
				
				_couleurAretes.set(r,"Noir");
			}
		}
	}
	
	/** Affichage */
	@Override
	public String toString() {
		int i;
		String res = new String("\nChemin : (");
		
		
		for (i = 0;i < _ruesChemin.size()-1;i++){
			res += _ruesChemin.get(i).getNom()+" -> ";
			if((i+1)%4==0&&i>0)
				res +="\n\t";
		}
		res += _ruesChemin.get(_ruesChemin.size()-1).getNom() + ")";
		
		return res;
	}
}
