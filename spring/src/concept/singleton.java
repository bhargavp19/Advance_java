package concept;

import concept.c1;

public class singleton {
	
	public static void main(String[] args){
		
		c1 obj = c1.getInstance();
		c1 obj1 = c1.getInstance(); 
		System.out.println("ob1 hasscode"+obj.hashCode());
		System.out.println("ob2 hasscode"+obj1.hashCode());
		
	}
	
	
}

