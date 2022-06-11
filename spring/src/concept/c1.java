package concept;

public class c1 {
	
	private static c1 a=new c1();
	
	private c1(){}
	
	static public c1 getInstance(){
		return a;
	}
}
