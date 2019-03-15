package page_factory;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserFactory;

public class ResetPassword {
	WebDriver driver;
	
	
	@FindBy(how=How.ID, using="new_password")
	WebElement new_password_field;
	
	@FindBy(how=How.ID, using="re_new_password")
	WebElement re_new_password_field;
	
	@FindBy(how=How.XPATH, using="/html/body/div[2]/div/div[1]/div/form/div[5]/div/div[2]/button")
	WebElement reset_button;
	
	@FindBy(how=How.LINK_TEXT, using="LOGIN")
	WebElement wait_login_link;
	
    
	

	
	
	public ResetPassword(WebDriver driver){
		this.driver = driver;
		
	}
	
	
	
	
	public void resetPasswordLocator(){
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		
		BrowserFactory.wdw = new WebDriverWait(driver, BrowserFactory.timeInSeconds);
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(new_password_field));
		
		
	}
	
	public String enterNewPassword(String np){		
		new_password_field.sendKeys(np);
		return np;
	}
	
	public void reEnterNewPassword(String np){
	   String newPass = new_password_field.getAttribute("value");
	   
	   re_new_password_field.sendKeys(newPass);
	}
	
	public void clickResetButton(){
		reset_button.click();
	}
	
	public void waitForNotification(){
		
		
	}
	
	
	
	
}
