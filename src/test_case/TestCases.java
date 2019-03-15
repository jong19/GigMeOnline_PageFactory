package test_case;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import page_factory.ForgotPassword;
import page_factory.Gmail_Home;
import page_factory.Gmail_Signin;
import page_factory.MyProfile;
import page_factory.PostAGig;
import page_factory.ResetPassword;
import page_factory.SignIn;
import page_factory.SignUp;
import data.UserDetails;
import utility.BrowserFactory;
import utility.ConfigReader;
import utility.ExcelConfig;


public class TestCases {

  WebDriver driver;
  
  UserDetails ud = new UserDetails();
  ExcelConfig ec = new ExcelConfig();

  
  SignUp su;
  PostAGig pag;
  SignIn si;
  ForgotPassword fp;
  Gmail_Signin gsi;
  Gmail_Home gh;
  ResetPassword rp;
  MyProfile mp;
  
  ExtentReports er;
  ExtentTest et;
  

  
  @BeforeTest
  public void setUp(){
	

	er = new ExtentReports(BrowserFactory.getLogReport(),true);
	
	et = er.startTest("Setup Browser", "Setting up the browser ");
	et.log(LogStatus.INFO, "Browser is being setup");

	
	driver = BrowserFactory.startBrowser("chrome");
	et.log(LogStatus.PASS, "Launch Chrome browser");
    et.log(LogStatus.PASS, "Maximize the browser window");

    
    driver.get(BrowserFactory.getAppUrl());
	et.log(LogStatus.PASS, "Type " + BrowserFactory.getAppUrl() +  " in the url field");
    
	 
  }
  
  
  
  @Test (priority = 1, enabled = false)
  public void signUpAsHire() throws Exception {
	 
	  String uname = ud.getUsername();
	  String em = ud.getEmail();
	  String pass = ud.getPassword();
	  
	
	  
     try{
	  su = PageFactory.initElements(driver, SignUp.class);
	  su.signUpLocator();
	  
	  et = er.startTest("Sign Up", "User Registration module");

	  
	  su.enterUsername(uname);
	  et.log(LogStatus.PASS, "Enter " + uname + " in the Username textfield");
	  
	  su.enterEmail(em);
	  et.log(LogStatus.PASS, "Enter " + em + " in the Email Address textfield");
	  	  
	  su.enterPassword(pass);
	  et.log(LogStatus.PASS, "Enter " + pass + " in the Password textfield");

	  su.reEnterPassword(pass);
	  et.log(LogStatus.PASS, "Re-enter " + pass + " in the ReType Password textfield");
	  
	  su.clickSignUpButton();
	  et.log(LogStatus.PASS, "Click Sign Up button");

	    
	  //code below will insert username, email and password in the excel file

	 
	  ec.getSheet(0);
	  ec.getNextRow();
	 // ec.getCurrentRow();
	 // ec.getAllRowCount();
	  ec.addNewUser(uname, em, pass);
	  ec.closeFile();
	  
	  
	  
	  et.log(LogStatus.PASS, "Save " + " username " + " ( " + uname + " ) " + "\t" + " , " +
	                       "email" + " ( " + em + " ) " + "\t" + " and " +
			               "password " + " ( " + pass + " ) " +  " in the GigmeUserCredentials excel file");

	  
	  pag = new PostAGig(driver);
	  pag = PageFactory.initElements(driver, PostAGig.class);
	  
	  et.log(LogStatus.INFO, "User is redirected to Post a Gig page");
	 	  
	  si = new SignIn(driver);
	  si = PageFactory.initElements(driver, SignIn.class);
	  
	  si.assertUsernameDisplayed(uname);
	  
	  si.logOut();
	  et.log(LogStatus.PASS, " Click the dropdown arrow. Logout");
	  
	  
	 
	 
	  
     }
     catch(Exception e){
    	 System.out.println(e.getMessage());
    	 
     }
	  
	 
     
  }
  
  
  @Test (priority = 3, dataProvider = "loginCredits", enabled = false)
  public void postAGig(String uname, String pword){
	  
	  try{
		  String gig_title = ud.getGigTitle();
		  String budget = ud.getBudget();
		  String description = ud.getDescription();
		  
		  
		  si = new SignIn(driver);
		  si = PageFactory.initElements(driver, SignIn.class);
		  
		  et = er.startTest("Post A Gig", "User Posts a Gig");

		  et.log(LogStatus.INFO, "Login using the newly created username and password");

		  si.loginLinkLocator();
		  
		  
		  si.clickLoginLink();
		  et.log(LogStatus.PASS, "Click the LOGIN link");
		 
		  si.enterUsername(uname);
		  et.log(LogStatus.PASS, "Enter " + uname +  " in Username or Email textfield");
		  
		  si.enterPassword(pword);
		  et.log(LogStatus.PASS, "Enter " + pword + " in Your Password textfield");
		  
		  si.clickLoginButton();
		  et.log(LogStatus.PASS, "Click the Sign in button");
	
		
		  mp = new MyProfile(driver);
		  mp = PageFactory.initElements(driver, MyProfile.class);
		  
		  et.log(LogStatus.INFO, "User is redirected to Gigme home page");

		  
		  mp.checkUsernameLogin(uname);
		  et.log(LogStatus.PASS, "Check the login username in the dropdown");

		  
		  mp.clickDropdown();
		  et.log(LogStatus.PASS, "Click dropdown arrow");

		  
		  mp.clickYourProfileLink();
		  et.log(LogStatus.PASS, "Click Your Profile link");

		  
		  et.log(LogStatus.INFO, "User is redirected to the Profile page");

		  mp.checkMyProfileLocator();
		  et.log(LogStatus.PASS, "Locate Post a Gig link");

		  
		  mp.clickPostAGigLink();
		  et.log(LogStatus.PASS, "Click Post a Gig link");

		  
		  
		  pag = new PostAGig(driver);
		  pag = PageFactory.initElements(driver, PostAGig.class);
		  
		  et.log(LogStatus.INFO, "User is redirected to Post a Gig page");

		  
		
		  pag.locateHeader();
		  et.log(LogStatus.PASS, "Click the Select button under the Free section");
	
		  pag.enterGigTitle(gig_title);
		  et.log(LogStatus.PASS, "Enter " + gig_title + " in Gig Title textfield");
	
		  pag.enterBudget(budget);
		  et.log(LogStatus.PASS, "Enter " + budget + " in Budget textfield");
	
		  
		  et.log(LogStatus.INFO, "Five (5) skills will be entered in the Skills textfield");

		  
		  int count_skills = 1;
		  
		  while(count_skills <= 5){
			 String gt = ud.getSkills();
			 
			 pag.enterSkills(gt);
			 et.log(LogStatus.PASS, "Enter skill " + count_skills + " : " + gt);
			 count_skills++;
	
		  }
		  
		  et.log(LogStatus.INFO, "Three (3) categories will be chosen from the Category dropdown");

		  
		  int count_categ = 1;
		  while(count_categ <= 3){
			     String ct = ud.getCategory();
				 pag.enterCategory(ct);
				 et.log(LogStatus.PASS, "Select category " + count_categ + " : " +  ct);
				 count_categ++;
	
		 }
		  
		  pag.enterDescription(description);
		  et.log(LogStatus.PASS, "Enter " + description + " in Description textfield");
	
		  pag.clickSubmitButton();
		  et.log(LogStatus.PASS, "Click Submit button");
	
		  et.log(LogStatus.INFO, "User is now redirected to the Gig Title page");

		  
		  pag.assertGigCreated(gig_title);
	
		  
		  si = PageFactory.initElements(driver, SignIn.class);
		  
		  si.assertUsernameDisplayed(uname);
	
		  si.logOut();
		  et.log(LogStatus.PASS, "Click dropdown arrow. Logout");
		  
	  }
	  
	  catch(Exception e){
		  System.out.println(e.getMessage());
		  
	  }
	   
  }
  
  
 
  @Test (priority = 2, dataProvider = "loginCredits", enabled = false)
  public void signIn(String uname, String pword){
	
	  si = new SignIn(driver);
	  si = PageFactory.initElements(driver, SignIn.class);
	  
	  et = er.startTest("Login", "User Login");
	  
	  
	  si.loginLinkLocator();
	  
	  si.clickLoginLink();
	  et.log(LogStatus.PASS, "Login link clicked");
	  
	
	  si.enterUsername(uname);
	  et.log(LogStatus.PASS, "Enter " + uname +  " in Your User Name or Email textfield");
	  
	  si.enterPassword(pword);
	  et.log(LogStatus.PASS, "Enter " + pword + " in Your Password textfield");
	  
	  si.clickLoginButton();
	  et.log(LogStatus.PASS, "Click Sign in button");
	  
	  et.log(LogStatus.INFO, "User is redirected to Gigme home page");

	  si.assertUsernameDisplayed(uname);
	  et.log(LogStatus.PASS, "Click the dropdown arrow");

	 
	  si.logOut();
	  et.log(LogStatus.PASS, "Logout");

	  
	  
	 
  }
  
  
  @DataProvider(name = "loginCredits")
  public Object[][] loginDetails(){
	  
	  Object [][] loginData = null;
	  String uname = "";
	  String pass = "";
	 
	  try{
		  ec.getSheet(0);
		  int the_rows = ec.getAllRowCount();
		  
		  loginData  = new Object[1][2];
		  
	
		  for(int i=the_rows-1; i<the_rows; i++){
			   uname = ec.readData(i, 0);
			   pass = ec.readData(i, 2);
			  
			  loginData[i-i][0] = uname;
			  loginData[i-i][1] = pass;

		  }
		
	  }
	  catch(Exception e){
		  System.out.println(e.getMessage());
	  }
		  
	return loginData;
	  
	  
  }
  

  

 
  @Test (priority = 4, enabled = true)
  public void forgotPassword() throws Exception{ 
	  
	  String em = "";
	  String gmail_pw = "";
	  String np = ud.getPassword();
	 
	  si = new SignIn(driver);
	  si = PageFactory.initElements(driver, SignIn.class);
	  
      et = er.startTest("Forgot Password", "User sets new password");
	  
	 
	  si.loginLinkLocator();
	 
	  
	  si.clickLoginLink();
	  et.log(LogStatus.PASS, "Click Login link");

	  
	  fp = new ForgotPassword(driver);
	  fp = PageFactory.initElements(driver, ForgotPassword.class);
	  
	  fp.forgotPasswordLocator();
	
	  fp.clickForgotPasswordLink();
	  et.log(LogStatus.PASS, "Click Forgot Password? link");
	  
	  et.log(LogStatus.INFO, "Forgot Password? modal pops up");

	  
	  ec.getSheet(1);
	  System.out.println("Current Row " + ec.getCurrentRow());
	 
	  em = ec.readData(1, 1);
		 	  
	  fp.enterEmail(em);
	  et.log(LogStatus.PASS, "Enter email " + em + " in Enter your email here textfield");

	  fp.clickSendButton();
	  et.log(LogStatus.PASS, "Click Send button");

      fp.waitNotification(); 
      
      gsi = new Gmail_Signin(driver);
      gsi = PageFactory.initElements(driver, Gmail_Signin.class);
      
	  et.log(LogStatus.INFO, "User now will check the Forgot Password activation link send to their email");

      
      gsi.openGmail();
	  et.log(LogStatus.PASS, "Type: " + BrowserFactory.getGmailUrl() + " in the url address box");

      gsi.gmailLoginLocator();
	  
      gsi.enterGmailEmail(em);
	  et.log(LogStatus.PASS, "Enter email " + em + " in Gmail email textfield");

      
      gsi.clickNextButton();
	  et.log(LogStatus.PASS, "Click Next button");
	  
	  
	  gmail_pw = ec.readData(1, 5);

      gsi.enterGmailPassword(gmail_pw);
	  et.log(LogStatus.PASS, "Enter gmail password " + gmail_pw + " in Gmail password textfield");

      gsi.clickSignInButton();
	  et.log(LogStatus.PASS, "Click Sign in button");

     
      gsi.checkOtherPageBeforeSignin();

      
      gh = new Gmail_Home(driver);
      gh = PageFactory.initElements(driver, Gmail_Home.class);
      
	  et.log(LogStatus.INFO, "User is redirected to the Gmail home page.");

      
      gh.gmailHomeLocator();
	

      gh.clickEmailReceived();
	  et.log(LogStatus.PASS, "Click the topmost email sent by Gig Me");

      gh.locateEmailTitle();
      
	  et.log(LogStatus.INFO, "User is redirected to [Gig Me] Password Reset page. Most recent activation link is placed at the bottom");

	 
      gh.clickMoreButton();
	  et.log(LogStatus.PASS, "Click the ... button to expand the Activation Link section ");

	  et.log(LogStatus.INFO, "System generated message is displayed to the user");

	  
      gh.clickActivateLink();
	  et.log(LogStatus.PASS, "Click the Activate Link");

      
      rp = new ResetPassword(driver);
      rp = PageFactory.initElements(driver, ResetPassword.class);
      
	  et.log(LogStatus.INFO, "Activation link opens in new tab");

      rp.resetPasswordLocator();

      rp.enterNewPassword(np); 
	  et.log(LogStatus.PASS, "Enter new password " + np + " in New Password textfield");

      rp.reEnterNewPassword(np);
	  et.log(LogStatus.PASS, "Re-enter new password " + np + " in Retype Password textfield");

      rp.clickResetButton();
	  et.log(LogStatus.PASS, "Click Reset button");
	  
	  
      System.out.println("NP IS " + np);
	  Thread.sleep(3000);

	  
	  // will write new password in the excel file
	  ec.getCurrentRow();
	  String op = ec.readData(ec.getCurrentRow(), 3);
	  ec.addNewPassword(op, 2); // old password is being copied to cell no. 2
      ec.addNewPassword(np, 3); // new password is being copied to cell no. 3
      
      ec.closeFile();

      
	  et.log(LogStatus.INFO, "Password successfully changed. User now will login using that new password");

	  
	  si.loginLinkLocator();

	  si.clickLoginLink();
	  et.log(LogStatus.PASS, "Click LOGIN link");

	  si.enterUsername(em);
	  et.log(LogStatus.PASS, "Enter email " + em + " in the email textfield");

	  si.enterPassword(np);
	  et.log(LogStatus.PASS, "Enter new password " + np + " in the password textfield");

	  si.clickLoginButton();
	  et.log(LogStatus.PASS, "Click Login button");
	  
	  et.log(LogStatus.INFO, "User redirected in the home page");

	  
	  String uname = ec.readData(1, 0);
	  
	  si.assertUsernameDisplayed(uname);
	  
	  si.logOut();
	  et.log(LogStatus.PASS, "User logs out");

      
   
  }
  
 
  
 
  @AfterTest
  public void closeBrowser() {
		er.endTest(et);
		er.flush();
	  
	  driver.quit();
	  
  }

}
