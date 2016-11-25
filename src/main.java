
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
		
		
	}
}