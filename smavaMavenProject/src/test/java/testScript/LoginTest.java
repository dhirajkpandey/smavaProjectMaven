package testScript;

import org.testng.annotations.Test;

import smavaMavenProject.LoginPOM;

public class LoginTest  extends BaseTest {
	
  @Test
  public void LoginTest() throws InterruptedException {
	  
	  LoginPOM loginPOMObj = new LoginPOM(driver);
	  loginPOMObj.fnVerifyLogin(driver);
	  
  }
}
