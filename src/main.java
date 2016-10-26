
public class main {
	private Ville v;
	
	public static void main(String[] args) {
		System.out.println("Hello world");
		Ville v = new Ville("datas/test.dat");
		//System.out.println(v.toString());
		GogolS g = new GogolS(v);System.out.println(v.getPlace(0));
		g.AlgoS(v.getPlace(0));
		g.toString();
	}
}