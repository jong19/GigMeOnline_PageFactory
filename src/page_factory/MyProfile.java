package page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.BrowserFactory;

public class MyProfile {

	WebDriver driver;
	
	public MyProfile(WebDriver driver){
		this.driver = driver;
		
	}
	
	
	@FindBy(how=How.XPATH, using="/html/body/header/div/div/div/div[3]/div/div/div/div/span[1]")
	WebElement dropdown_username;
	
	@FindBy(how=How.LINK_TEXT, using="Your Profile")
	WebElement your_profile;
	
	@FindBy(how=How.LINK_TEXT, using="Post a Gig")
	WebElement post_a_gig;
	
	
	
	public String checkUsernameLogin(String uname){
		
		BrowserFactory.wdw = new WebDriverWait(driver, BrowserFactory.timeInSeconds);
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(dropdown_username));
		Assert.assertEquals(uname, uname);
		return uname;
		
	}
	
	
	public void clickDropdown(){
		
		dropdown_username.click();
	}
	
	public void clickYourProfileLink(){
		
		your_profile.click();
	}
	
	public void checkMyProfileLocator(){
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(post_a_gig));
	
	}
	
	public void clickPostAGigLink(){
		post_a_gig.click();
		
	}
	
	
	
	
}
