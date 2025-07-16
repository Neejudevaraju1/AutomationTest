package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginPageTest extends Base{
  @Test
  public void verifyUserCanLoginWithValidCredentials() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin", "admin");
	  loginpage.clickSiginButton();
	  boolean isdashboarddisplayed=loginpage.isDashboardIsDisplayed();
	  Assert.assertTrue(isdashboarddisplayed, "DashBoard is not displayed");
  }
  @Test
  public void verifyUserCanLoginWithValidUsernameAndInvalidPassword() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin", "test");
	  loginpage.clickSiginButton();
	  boolean isalertdisplayed=loginpage.isAlertMessageIsDisplayed();
	  Assert.assertTrue(isalertdisplayed, "invalid authentication is allowed");
  }
  @Test
  public void VerifyUserCanLoginWithInvalidUsernameAndValidPassword() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("test", "admin");
	  loginpage.clickSiginButton();
	  boolean isalertdisplayed=loginpage.isAlertMessageIsDisplayed();
	  Assert.assertTrue(isalertdisplayed, "invalid authentication is allowed");
  }
  @Test
  public void verifyUserCanLoginWithInvalidCredentials() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("test","pass");
	  loginpage.clickSiginButton();
	  boolean isalertdisplayed=loginpage.isAlertMessageIsDisplayed();
	  Assert.assertTrue(isalertdisplayed, "invalid authentication is allowed");
  }
}
