package page_factory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.BrowserFactory;

public class Gmail_Home {
	
	public WebDriver driver;
	
	public Gmail_Home(WebDriver driver){
		this.driver = driver;
	}

	@FindBy(how=How.XPATH, using="/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div[1]/div/div")
    WebElement compose_button;
	
	@FindBy(how=How.ID, using=":3h")
    WebElement password_recovery_email;
	
	@FindBy(how=How.XPATH, using="/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/table/tr/td[1]/div[2]/div[1]/div[2]/div[1]/h2")
	WebElement email_title;
	
	@FindBy(how=How.CLASS_NAME, using="ajT")
	WebElement more_button;
	
	@FindBy(how=How.LINK_TEXT, using="Activate Link")
	WebElement activate_link;
	
	
	
	
	public void gmailHomeLocator(){
		BrowserFactory.wdw = new WebDriverWait(driver, BrowserFactory.timeInSeconds);
		BrowserFactory.wdw.until(ExpectedConditions.elementToBeClickable(compose_button));
		System.out.println(compose_button.getText() + " is clickable");
	}
	
	public void clickEmailReceived(){
		password_recovery_email.click();
		
	}
	
	public void locateEmailTitle(){
		
		try{
			BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(email_title));

			String title = email_title.getText();		
			Assert.assertEquals(title, "[Gig Me] Password Reset");
		}
		catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		}
	
	}
	
	public void clickMoreButton(){
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(more_button));
		more_button.click();
	}
	
	public void clickActivateLink(){
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(activate_link));
		activate_link.click();
		

		
	

	}
}
