package testScript;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


public class BaseTest {
	
	public WebDriver driver;
	protected String SMAVA_URL ="https://www.smava.de";
	
 
	public static void fnSelectDropDownvalue(WebDriver driver,Collection<WebElement> aDropdownValues, String aValueRequired)
	{
		//Collection<WebElement> dropDownValue =  aDropdownItems; 
	    Iterator<WebElement> dropDownValueitr = aDropdownValues.iterator();
	    while(dropDownValueitr.hasNext())
	    {
	    	WebElement currentValue = dropDownValueitr.next();
	    	if(currentValue.getText().contains(aValueRequired))
	    	{
	    		currentValue.click();
	    	}
	    	else
	    	{
	    		
	    	}
	    }
	}

  @BeforeClass
	public void fnpreCondition() 
	{
		//driver = new FirefoxDriver();
	  	System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
		  ChromeOptions chromeOptions = new ChromeOptions();
		  chromeOptions.addArguments("--start-maximized");
		  driver = new ChromeDriver(chromeOptions);
		  driver.get(SMAVA_URL);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}	
  @AfterClass
	public void fnpostCondition( )
	{
		//driver.close();
	}
	
}
