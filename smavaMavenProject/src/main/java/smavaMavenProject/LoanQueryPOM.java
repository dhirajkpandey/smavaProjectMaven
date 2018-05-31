package smavaMavenProject;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.DropDownHandlingWithCollection;

import generic.Constants;

public class LoanQueryPOM {
	
	@FindBy(xpath="//input[@class ='search']")	
	private WebElement loanAmountDropDown;
		
	@FindBy(xpath="//div[@id='myselect2']/div//input")	
	private WebElement loanDurationDropDown;
	
	@FindBy(xpath="//div[@id='myselect3']/div")	
	private WebElement useTypeDropDown;
	
	@FindBy(xpath="//a[@id='forwardButtonkredit2day']")	
	private WebElement weiterButton;
			
	@FindBy(xpath="//a[@id='forwardButtonkredit2day']/button")	
	private WebElement anmeldonButton;

			
	
	
    public LoanQueryPOM(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
        
    
    
	/********************************************************************* 
	 * @author Dhiraj.Pandey
	 * 
	 * @param WebDriver driver
	 * 
	 * @return void
	 *********************************************************************/
    
    
    
    public void fnVerifyLoanQuery(WebDriver driver)
    {
    	Collection<WebElement> dropdownvalue =  driver.findElements(By.xpath("//div[@id='myselect']/div/div/div[@class='item']"));
    	Collection<WebElement> dropdownvalueDuratrion =  driver.findElements(By.xpath("//div[@id='myselect2']/div/div/div[@class='item']"));
    	Collection<WebElement> dropdownvalueUseType =  driver.findElements(By.xpath("//div[@id='myselect3']/div/div/div[@class='item']"));

    	loanAmountDropDown.click();
    	DropDownHandlingWithCollection.fnSelectDropDownvalue(driver, dropdownvalue, Constants.LOAN_AMOUNT );
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	loanDurationDropDown.click();
    	DropDownHandlingWithCollection.fnSelectDropDownvalue(driver, dropdownvalueDuratrion, Constants.LOAN_DURATION );
    	useTypeDropDown.click();
    	DropDownHandlingWithCollection.fnSelectDropDownvalue(driver, dropdownvalueUseType, Constants.USE_TYPE);
    	weiterButton.click();
    	String pageTitle = driver.getTitle();
    	Assert.assertEquals(pageTitle, "smava Kreditantrag");
    }
    
     
}
