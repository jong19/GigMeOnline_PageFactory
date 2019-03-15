package dataStruc;

import java.util.ArrayList;
import java.util.Scanner;

public class List {
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<String> names = new ArrayList<>();
	
	static int count = 1;
	static String name = "";
	static String sn = "";


	public static void main(String[] args) {
		
		List l = new List();

		
		while(count <= 5){
			
			System.out.println("Enter name "+count+ ":");
			name = sc.next();
			names.add(name);
			
			count++;
			
			
			
		
		}
		
		System.out.println("====== All Names =============");
		l.allNames();
		
		System.out.println("=====Number of names=========");
		l.namesSize();
		
		System.out.println("====== Search for: =============");

		System.out.println("Search for: ");
		String sn = sc.next();
		l.searchName(sn);
		
		
	}
	

	
	public void allNames(){
		
		for(String n: names){
			System.out.println(n);
			
		}
		
	}
	
	public void namesSize(){
		
		int size = names.size();
		System.out.println(size);
		
	}
	
	
	public ArrayList<String> searchName(String sn){
		
		
	
	
		ArrayList<String> searches = new ArrayList<>();
		
	     for(String n : names){
			if(n.contains(sn)){
				searches.add(n);
			}
		
		}
	     
	    if(searches.isEmpty()){
	    	System.out.println("No results for " + sn);
	    }
	    else{
			displaySearches(searches, sn);

	    }
		
	
		return searches;
		
		
		
		
	}
	
	public void displaySearches(ArrayList<String> searches, String sn){
				
		for(String s: searches){
			System.out.println(s);
			
		}
		
		
		
	}
	


}
