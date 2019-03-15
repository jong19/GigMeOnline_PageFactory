package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigReader {
	
	Properties property;
	WebDriver driver;

	public ConfigReader(){
		
		try {
			File property_file = new File("D://NINZO//RC_automation_tests//GigMeOnline_PageFactory//configuration//Config.property");	
			FileInputStream fis = new FileInputStream(property_file);
			property = new Properties();
			property.load(fis);
			
		} catch (Exception e) {
			System.out.println("Error is " + e.getMessage());
		}
	}
	
	public String getAppUrl(){
		String app_url = property.getProperty("AppUrl");
		return app_url;
		
	}
	
	public String getChromeDriver(){
		String chrome_driver = property.getProperty("ChromeDriver");
		return chrome_driver;
		
		/* --> append code below under TestCase.java >> setUp() method when using this ConfigReader.java
		 
		 
		ConfigReader cr = new ConfigReader();
		System.setProperty("webdriver.chrome.driver", cr.getChromeDriver());
		driver = new ChromeDriver();
		driver.get(cr.getAppUrl());
		*/

	    
		
		
	}
}
