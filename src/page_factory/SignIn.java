package page_factory;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.BrowserFactory;

public class SignIn {
	WebDriver driver;
	
	
	
	@FindBy(how=How.XPATH, using="/html/body/header/div/div/div/div[3]/div/div/a[1]")
	WebElement login_link;
	
	@FindBy(how=How.ID, using="login_user_login")
	WebElement login_username;
	
	@FindBy(how=How.ID, using="login_user_pass")
	WebElement login_password;
	
	@FindBy(how=How.XPATH, using="/html/body/div[5]/div/div/div[2]/form/button")
	WebElement login_button;
	
	@FindBy(how=How.XPATH, using="/html/body/header/div/div/div/div[3]/div/div/div/div/span[1]")
	WebElement assert_username;
	
	@FindBy(how=How.LINK_TEXT, using="Logout")
	WebElement logout_link;
	
	
	
	public SignIn(WebDriver driver){
		this.driver = driver;
		
	}
	
	public void loginLinkLocator(){
	    
		BrowserFactory.wdw = new WebDriverWait(driver, BrowserFactory.timeInSeconds);
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(login_link));
		
	}
	
	public void clickLoginLink(){
		login_link.click();

	}
	
	public void enterUsername(String uname){
		
        BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(login_username));
		login_username.sendKeys(uname);
	}
	
	public void enterPassword(String pword){
    
		login_password.sendKeys(pword);

	}
	
	public void clickLoginButton(){
		login_button.click();
	}
	
	public void assertUsernameDisplayed(String uname){
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(assert_username));
		Assert.assertEquals(uname, uname);
		assert_username.click();
	}
	
	public void logOut(){
		
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(logout_link));
		logout_link.click();
		
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(login_link));
		
	}
	
	
}
