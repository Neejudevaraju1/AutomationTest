package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;

public class LoginPageTest extends Base{
  @Test
  public void verifyUserCanLoginWithValidCredentials() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin", "admin");
	  loginpage.clickSiginButton();
	  boolean isdashboarddisplayed=loginpage.isDashboardIsDisplayed();
	  Assert.assertTrue(isdashboarddisplayed,Constant.ERROR_MESSAGE_FOR_LOGIN_FAIL);
  }
  @Test
  public void verifyUserCanLoginWithValidUsernameAndInvalidPassword() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin", "test");
	  loginpage.clickSiginButton();
	  boolean isalertdisplayed=loginpage.isAlertMessageIsDisplayed();
	  Assert.assertTrue(isalertdisplayed, Constant.ERROR_MESSAGE_LOGIN_WITH_INVALID_CREDENTIALS);
  }
  @Test
  public void VerifyUserCanLoginWithInvalidUsernameAndValidPassword() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("test", "admin");
	  loginpage.clickSiginButton();
	  boolean isalertdisplayed=loginpage.isAlertMessageIsDisplayed();
	  Assert.assertTrue(isalertdisplayed, Constant.ERROR_MESSAGE_LOGIN_WITH_INVALID_CREDENTIALS);
  }
  @Test
  public void verifyUserCanLoginWithInvalidCredentials() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("test","pass");
	  loginpage.clickSiginButton();
	  boolean isalertdisplayed=loginpage.isAlertMessageIsDisplayed();
	  Assert.assertTrue(isalertdisplayed,Constant.ERROR_MESSAGE_LOGIN_WITH_INVALID_CREDENTIALS);
  }
}
