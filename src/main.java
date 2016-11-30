
public class main {
	private Ville v;
	
	public static void main(String[] args) {

		Ville v = new Ville("../datas/grosseVille.dat");
		//System.out.println(v.toString());
		//Ville v = new Ville("datas/test.dat");
		//System.out.println(v.toString());
		//GogolS g = new GogolS(v);
		
		//g.AlgoS(v.getPlace(0));
		
		/*GogolL g2 = new GogolL(v);
		g2.AlgoL(v.getPlace(0));*/
		
		
		GogolXL g3 = new GogolXL(v);
		g3.listOddVertices();
		g3.pairingOddVertices();
		g3.floydWarshall();
		g3.setPairingWeights();
		g3.heuristicMinimumWeightPairs();
		g3.construireCheminPaires();
		
		System.out.println(v.toString());
		
		
		GogolS GS = new GogolS(v);
		GS.AlgoS(v.getPlace(0));
		
		/*GogolL GL = new GogolL(v);
		GL.AlgoL(v.getPlace(0));*/
	}
}