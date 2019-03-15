package dataStruc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Maps {
    
	static String name = "";
	static double salary = 0;
	static Scanner sc = new Scanner(System.in);
	
	static Map<String, Double> m = new HashMap<String, Double>();


	
	public static void main(String[] args) {
	   
		Maps ms = new Maps();



	    int count = 1;
	    
	    while(count <= 3){
	    	System.out.println("Enter employee " + count);
	    	name = sc.next();
	    	
	    	System.out.println("Enter salary for " + name);
	    	salary = sc.nextDouble();
	    	
	    	m.put(name, salary);
	    	
	    	count += 1;
	    	
	    	
	    }
	    
	    ms.displayMap();
	    
	
	}
	
	public void displayMap(){
		System.out.println("=========================");
		
		


		
	}
	


}
