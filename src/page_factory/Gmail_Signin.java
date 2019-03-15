package page_factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserFactory;

public class Gmail_Signin {
	
	WebDriver driver;
	
	public Gmail_Signin(WebDriver driver){
		this.driver = driver;
		
	}
	
	@FindBy(how=How.ID, using="Email")
	WebElement gmail_email;
	
	@FindBy(how=How.ID, using="next")
	WebElement next_button;
	
	@FindBy(how=How.ID, using="Passwd")
	WebElement gmail_password;
	
	@FindBy(how=How.ID, using="signIn")
	WebElement signin_button;
	
	@FindBy(how=How.XPATH, using="/html/body/div[1]/div[3]/div/div/div/div/div[1]/div[3]/div[1]")
	WebElement done_button;
	
	
	public void openGmail(){
		driver.get(BrowserFactory.getGmailUrl());
	}
	
	public void gmailLoginLocator(){
		BrowserFactory.wdw = new WebDriverWait(driver, BrowserFactory.timeInSeconds);
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(gmail_email));
	}
	
	public void enterGmailEmail(String em){
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(gmail_email));
		gmail_email.sendKeys(em);
		
	}
	
	public void clickNextButton(){
		next_button.click();
	}
	
	public void enterGmailPassword(String pw){
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(gmail_password));
		gmail_password.sendKeys(pw);
		
	}
	
	public void clickSignInButton(){
		signin_button.click();
	}
	
	
	public void checkOtherPageBeforeSignin(){
		if(driver.getTitle().equals("Recovery Options"))
			done_button.click();
		
		/*
		else if(driver.getTitle().equals("Some new features for your Google Account"))
			
			//add scroll down page script here
			driver.findElement(By.xpath("/html/body/form/div/content/div/div[3]/div/div/content/span")).click();
		*/
		
		else
			driver.get(BrowserFactory.gmail_url);
	}
	
	
	
	
	
	
	
}
