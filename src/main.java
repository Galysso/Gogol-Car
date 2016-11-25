
public class main {
	private Ville v;
	
	public static void main(String[] args) {

		//Ville v = new Ville("datas/test.dat");
		Ville v = new Ville("datas/test.dat");
		//System.out.println(v.toString());
		GogolS g = new GogolS(v);
		
		g.AlgoS(v.getPlace(0));
		
		/*GogolL g2 = new GogolL(v);
		g2.AlgoL(v.getPlace(0));*/
		
		
		GogolXL g3 = new GogolXL(v);
		g3.listOddVertices();
		g3.pairingOddVertices();
		g3.floydWarshall();
		g3.setPairingWeights();
		g3.heuristicMinimumWeightPairs();
	}
}