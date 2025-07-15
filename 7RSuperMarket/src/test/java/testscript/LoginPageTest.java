package testscript;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginPageTest extends Base{
  @Test
  public void verifyUserCanLoginWithValidCredentials() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin", "admin");
	  loginpage.clickSiginButton();
  }
  @Test
  public void verifyUserCanLoginWithValidUsernameAndInvalidPassword() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin", "test");
	  loginpage.clickSiginButton();
  }
  @Test
  public void VerifyUserCanLoginWithInvalidUsernameAndValidPassword() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("test", "admin");
	  loginpage.clickSiginButton();
  }
  @Test
  public void verifyUserCanLoginWithInvalidCredentials() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("test","pass");
	  loginpage.clickSiginButton();
  }
}
