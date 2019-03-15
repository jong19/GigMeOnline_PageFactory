package page_factory;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.BrowserFactory;



public class PostAGig {
	WebDriver driver;
	

	
	
	
	@FindBy(how=How.XPATH, using="/html/body/section[1]/div/div/div/h2")
	WebElement postAGig_header;
	
	@FindBy(how=How.XPATH, using="/html/body/section[2]/div/div/div[1]/div[1]/div[1]/div/ul/li[1]/a")
	WebElement select_button;
	
	@FindBy(how=How.ID, using="post_title")
	WebElement gig_title;
	
	@FindBy(how=How.ID, using="et_budget")
	WebElement budget;
	
	@FindBy(how=How.ID, using="skill")
	WebElement skills;
	
	@FindBy(how=How.XPATH, using="/html/body/section[2]/div/div/div[1]/div[1]/div[2]/div/form/div[4]/div/div[2]/div/ul/li/input")
	WebElement category ;
	
	@FindBy(how=How.ID, using="post_content_ifr")
	WebElement description;
	
	@FindBy(how=How.XPATH, using="/html/body/section[2]/div/div/div[1]/div[1]/div[2]/div/form/div[7]/div/div[2]/button")
	WebElement submit_button;
	
	@FindBy(how=How.XPATH, using="/html/body/div[2]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/h1")
	WebElement assert_gig_title;

	
	

	
	public PostAGig(WebDriver driver){
		this.driver = driver;
	}
	
	

	
	
	public void locateHeader(){
		
		BrowserFactory.wdw = new WebDriverWait(driver, BrowserFactory.timeInSeconds);
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(postAGig_header));
		
		select_button.click();
	}
	
	public void enterGigTitle(String sk_gig_title){
	    
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(gig_title));
		
		gig_title.sendKeys(sk_gig_title);
		
	}
	
	public void enterBudget(String sk_budget){
		
		budget.sendKeys(sk_budget);


	}
	
	public void enterSkills(String sk_skills){
		
			skills.sendKeys(sk_skills);
			skills.sendKeys(Keys.ENTER);

	}
	
	public void enterCategory(String sk_category){

		category.click();
		category.sendKeys(sk_category);
		category.sendKeys(Keys.ENTER);

	}
	
	public void enterDescription(String sk_description){
		description.sendKeys(sk_description);

	}
	
	public void clickSubmitButton(){
		submit_button.click();
		
	}

	public void assertGigCreated(String gtitle){
		BrowserFactory.wdw.until(ExpectedConditions.visibilityOf(assert_gig_title));
		Assert.assertEquals(gtitle, gtitle);
		
	
	}

	


	
}
