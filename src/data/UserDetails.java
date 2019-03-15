package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utility.BrowserFactory;

public class UserDetails {
	private String username;
	private String email;
	private String password;
	
	private String gig_title;
	private String budget;
	private String skills;
	private String category;
	private String description;
	
		
	ArrayList<String> username_list = new ArrayList<>();
	ArrayList<String> email_list = new ArrayList<>();
	ArrayList<String> password_list = new ArrayList<>();
	
	ArrayList<String> gigTitle_list = new ArrayList<>();
	ArrayList<String> budget_list = new ArrayList<>();
	ArrayList<String> skills_list = new ArrayList<>();
	ArrayList<String> category_list = new ArrayList<>();
	ArrayList<String> description_list = new ArrayList<>();


  	
	public String getUsername() throws Exception{
		
	
		username_list.add("gigmeonline207");
		
		/*
		username_list.add("gigmeonline107");
		username_list.add("gigmeonline108");
		username_list.add("gigmeonline109");
		username_list.add("gigmeonline110");
        */

		 Random rand = new Random();
		 username =  username_list.get(rand.nextInt(username_list.size()));
		 
		 
		 
		return username;
	}
	
	public String getEmail(){
		
		
		email_list.add("gigmeonline207@gmail.com");
		
	    /*
		email_list.add("gigmeonline107@gmail.com");
		email_list.add("gigmeonline108@gmail.com");
		email_list.add("gigmeonline109@gmail.com");
		email_list.add("gigmeonline110@gmail.com");
	   */
     
		 Random rand = new Random();
		 email =  email_list.get(rand.nextInt(email_list.size()));
		 
		
		return email;
	}
	
	
	public String getPassword(){
		 password_list.add("%gigmeonline%");
		 password_list.add("gigme1234");
		 password_list.add("qwerty123456");
		 password_list.add("%gigme_1234%");
		 password_list.add("testpass");
		 password_list.add("1234qwer");
		 password_list.add("gigme615");
		 password_list.add("$mypassWoRdZZ23$");
		 password_list.add("i_am_me123$$$");
		 password_list.add("#this_PASSWORD_321#");


				
		 Random rand = new Random();
		 password = password_list.get(rand.nextInt(password_list.size()));
		 
		return password;
	}
	
	
	public String getNewResetPassword(){
		String user_new_password = "new.vrox.test";
		return user_new_password;
	}
	
	
	public String getGigTitle(){
		gigTitle_list.add("Looking for Android Testers");
		gigTitle_list.add("Urgent: Scala Play Framework Web Developers");
		gigTitle_list.add("Front-end AngularJS Developers");
		gigTitle_list.add("Database Tesers");
		gigTitle_list.add("Test Automation Testers with Selenium Experience");



		 Random rand = new Random();
		 gig_title =  gigTitle_list.get(rand.nextInt(gigTitle_list.size()));
		
		
		return gig_title;
	}
	
	public String getBudget(){
		budget_list.add("250");
		budget_list.add("150");
		budget_list.add("120");


		 Random rand = new Random();
		 budget =  budget_list.get(rand.nextInt(budget_list.size()));
		
		
		return budget;
	}
	
	
	public String getSkills(){
		skills_list.add("Appium Automation");
		skills_list.add("Selenium Test Automation");
		skills_list.add("Web Development using Laravel");
		skills_list.add("JIRA Agile");
		skills_list.add("MySQL");
		skills_list.add("AngularJS");
		skills_list.add("Data Structures");
		skills_list.add("JMeter Load Testing");
		skills_list.add("Android Development");
		skills_list.add("UML Diagramming");

		
		 Random rand = new Random();
		 skills =  skills_list.get(rand.nextInt(skills_list.size()));
		
		
		return skills;
	}
	
	
	public String getCategory(){
		category_list.add("Computer & IT");
		category_list.add("Website QA");
		category_list.add("Website Project Management");


		 Random rand = new Random();
		 category =  category_list.get(rand.nextInt(category_list.size()));
		
		
		return category;
	}
	
	
	public String getDescription(){
		description_list.add("I am proficient with the above skills mentioned");
		description_list.add("I am eager to work as soon as possible");
		description_list.add("I can work as soon as possible");

		 Random rand = new Random();
		 description =  description_list.get(rand.nextInt(description_list.size()));
		
		
		return description;
	}
	
	
	
	

	
}
