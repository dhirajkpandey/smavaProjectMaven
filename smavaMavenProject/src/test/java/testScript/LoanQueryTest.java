package testScript;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import smavaMavenProject.LoanQueryPOM;

public class LoanQueryTest extends BaseTest{
	
  @Test()
  public void LoanQueryTest() throws StaleElementReferenceException {
	  	  
	  LoanQueryPOM loanQueryPOMObj = new LoanQueryPOM(driver);
	  loanQueryPOMObj.fnVerifyLoanQuery(driver);
	  Reporter.log("Loan Query page loaded successfully",true);
  }

  
}
