package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BrowserFactory {
	
	 static WebDriver driver;
	 static ExtentTest et;

	 public static WebDriverWait wdw;
	 public static final long timeInSeconds = 30;
	 
	 public static final String base_url = "http://gigmeonline.ripecustomdesign.com/";
	 public static final String gmail_url = "https://www.gmail.com";
	 public static final String log_report = "D:\\NINZO\\RC_automation_tests2\\GigMeOnline_PageFactory\\gigme_reports.html";
	 
	 
	 public static WebDriver startBrowser(String browserName){
		 
		 
		 if(browserName.equalsIgnoreCase("chrome")){
			 // System.setProperty("webdriver.chrome.driver", "D:/NINZO/Selenium__Webdriver/chromedriver_win32/2.20/chromedriver.exe");
			    System.setProperty("webdriver.chrome.driver", "D:/NINZO/Selenium__Webdriver/chromedriver.exe");

			  driver = new ChromeDriver();

			  
		 }
		 
		 else if(browserName.equalsIgnoreCase("firefox")){
			 driver = new FirefoxDriver();

			 
			
		 }
		 
		 driver.manage().window().maximize();

		 
		 return driver;
		 
		 
	 }
	 
	 public static String getAppUrl(){
		 return base_url;
	 }
	 
	 public static String getGmailUrl(){
		 return gmail_url;
	 }
	 
	 
	 public static String getLogReport(){
		 return log_report;
	 }
	 
	 
	 
	 
}
