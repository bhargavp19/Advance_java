
public class singleton {

	final static singleton sing = new singleton();
	
	String s = "xya";
	 
	private singleton(){
		
	}
	
}

class c2{
	
	public static void main(String args[]){
		
		System.out.println(singleton.sing.s);
		
	}
}
