package page_factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserFactory;


public class SignUp {
	
	WebDriver driver;
	

	
	
	@FindBy(how = How.XPATH, using="/html/body/header/div/div/div/div[3]/div/div/a[2]")
	WebElement signup_locator;
	
	@FindBy(id="user_login")
	WebElement username;
	
	@FindBy(id="register_user_email")
	WebElement email;
	
	@FindBy(id="register_user_pass")
	WebElement password;
	
	@FindBy(id="repeat_pass")
	WebElement re_password;
	
	@FindBy(xpath="/html/body/div[4]/div/div/div[2]/form/button")
	WebElement signup_button;
	

	
	
	public SignUp(WebDriver driver){
		this.driver = driver;
	}
	
	
	
	public void signUpLocator(){
		BrowserFactory.wdw = new WebDriverWait(driver, BrowserFactory.timeInSeconds);

		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(signup_locator));
		signup_locator.click();
	}
	
	public void enterUsername(String uname){
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys(uname);
	}
	
	public void enterEmail(String em){
		email.sendKeys(em);
	}
	
	public void enterPassword(String pass){
		password.sendKeys(pass);
	}
	
	public void reEnterPassword(String pass){
		re_password.sendKeys(pass);

	}
	
	public void clickSignUpButton(){
		signup_button.click();
	}
	
	

	
	
}
