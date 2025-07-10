package testscript;

import org.testng.annotations.Test;

import testcode.Login;

public class LoginPageTest extends Base{
  @Test
  public void loginWithValidCredentials() {
	  Login login =new Login(driver);
	  login.usernameAndPassword("carol", "1q2w3e4r");
	  login.clickLoginButton();
	  
  }
  @Test
  public void loginWithValidUsernameAndInvalidPassword() {
	  Login login = new Login(driver);
	  login.usernameAndPassword("carlo", "pass");
	  login.clickLoginButton();
  }
  @Test
  public void loginWithInvalidUsernameAndValidPassword() {
	  Login login = new Login(driver);
	  login.usernameAndPassword("test", "1q2w3e4r");
	  login.clickLoginButton();
  }
  @Test
  public void loginWithInvalidCredentials() {
	  Login login= new Login(driver);
	  login.usernameAndPassword("test", "pass");
	  login.clickLoginButton();
  }
}
