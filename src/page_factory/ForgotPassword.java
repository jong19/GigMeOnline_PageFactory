package page_factory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserFactory;

public class ForgotPassword {
	
    WebDriver driver;
    
	public ForgotPassword(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(how=How.LINK_TEXT, using="Forgot Password?")
	WebElement forgot_password_link;
	
	@FindBy(how=How.ID, using="user_email")
	WebElement user_email;
	
	@FindBy(how=How.XPATH, using="/html/body/div[7]/div/div/div[2]/form/button")
	WebElement send_button;
	
	@FindBy(how=How.XPATH, using="/html/body/div[1]/div")
	WebElement success_notif;
	
	
	
	
	
	
	public void forgotPasswordLocator(){
		BrowserFactory.wdw = new WebDriverWait(driver, BrowserFactory.timeInSeconds);
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(forgot_password_link));
		
	}
	
    public void clickForgotPasswordLink(){
    	forgot_password_link.click();
    }
	
	
	public void enterEmail(String em){
		
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(user_email));
		user_email.sendKeys(em);
	}
	
	public void clickSendButton(){
		send_button.click();
	}
	
	public void waitNotification(){
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(success_notif));

		
	}
	
}
