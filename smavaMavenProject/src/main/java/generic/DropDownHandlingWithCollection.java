package generic;

import java.util.Collection;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDownHandlingWithCollection {
	
	public static void fnSelectDropDownvalue(WebDriver driver,Collection<WebElement> aDropdownValues, String aValueRequired)
	{
		//Collection<WebElement> dropDownValue =  aDropdownItems; 
	    Iterator<WebElement> dropDownValueitr = aDropdownValues.iterator();
	    while(dropDownValueitr.hasNext())
	    {
	    	WebElement currentValue = dropDownValueitr.next();
	    	if(currentValue.getText().equalsIgnoreCase(aValueRequired))
	    	{
	    		currentValue.click();
	    	}
	    	
	    }
	}
    

}
