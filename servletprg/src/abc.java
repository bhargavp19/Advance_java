class a{
	//private static a obj = new a(); //eager initialization
	private static a obj;
	private a() {
		// TODO Auto-generated constructor stub
	}
	
	public static a obcreation(){
		if(obj==null){
			obj = new a();   // lazy initialization
		}
		return obj;
	}
}
public class abc {
	public static void main(String args[]){
			a a1 =a.obcreation();
			
			a a2 = a.obcreation();
			
			System.out.println(a1.hashCode());
			System.out.println(a2.hashCode());
			
		}
}
