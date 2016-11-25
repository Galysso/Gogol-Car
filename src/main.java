
public class main {
	private Ville v;
	
	public static void main(String[] args) {

		//Ville v = new Ville("datas/test.dat");
		Ville v = new Ville("datas/nonEulerien.dat");
		//System.out.println(v.toString());
		//GogolS g = new GogolS(v);
		
		// System.out.println(v.getPlace(0));
		//g.AlgoS(v.getPlace(0));
		//System.out.println(g.toString());
		
		/*GogolL g2 = new GogolL(v);
		g2.Arborescence(v.getPlace(0));*/
		
		GogolXL g3 = new GogolXL(v);
		g3.listOddVertices();
		g3.pairingOddVertices();
		g3.floydWarshall();
		g3.setPairingWeights();
		g3.heuristicMinimumWeightPairs();
	}
}