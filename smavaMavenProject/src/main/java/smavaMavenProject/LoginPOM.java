package smavaMavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import generic.Constants;

public class LoginPOM {
		
	@FindBy(xpath="//a[contains(text(),'Anmelden')]")	
	private WebElement anmeldonButton;
	
	@FindBy(xpath="//input[@id='signonForm.email']")	
	private WebElement emailTextBox;
	
	@FindBy(xpath="//input[@id='signonForm.password']")	
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//button[@type ='submit')]")	
	private WebElement signInButton;
	
	@FindBy(xpath = "//li[contains(text(),'Ihre Angaben zum Einloggen sind ungültig.')]")	
	private WebElement invalidLogIn;
	
	
	public LoginPOM(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    }
	   
	 public void fnVerifyLogin(WebDriver driver) throws InterruptedException
	    {	       	
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	anmeldonButton.click();
	    	
	    	JavascriptExecutor logincredential = (JavascriptExecutor)driver;
	    	logincredential.executeScript("arguments[0].value='" +Constants.EMAIL+"';", emailTextBox);
	    	    	
	    	logincredential.executeScript("arguments[0].value='" +Constants.PASSWORD+"';", passwordTextBox);

	    	//emailTextBox.click();
	    	
	    	//emailTextBox.sendKeys(Constants.EMAIL);
	    	//passwordTextBox.sendKeys(Constants.PASSWORD);
	    	signInButton.click();
	    	if((invalidLogIn.getText().contains("Ihre Angaben zum Einloggen sind ungültig.")));
	    	{
	    		  Reporter.log("User has entered invalid log in credential",true);

	    	}
	    	

	    }
	   


}
