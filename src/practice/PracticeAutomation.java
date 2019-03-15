package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class PracticeAutomation {
	
	WebDriver driver;
	
  @BeforeTest
  public void setUp() {
	  
	  System.setProperty("webdriver.chrome.driver", "D:/NINZO/Selenium__Webdriver/chromedriver_win32/2.20/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com");

	 
	  
  }
  
  @Test
  public void beforeTest() throws InterruptedException{
	  
	  List<WebElement> links = driver.findElements(By.tagName("a"));
	  
	  for(WebElement l : links){
		  if(l.getText().contains("Gm")){
			  l.click();
			  
			  
		  }
		  //System.out.println(l.getText());
	  }
	  
	 
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
