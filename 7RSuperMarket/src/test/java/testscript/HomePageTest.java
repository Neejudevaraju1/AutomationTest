package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends Base {
  @Test
  public void verifyThatTheAdminLinkIsClickable() {
	  LoginPage loginpage=new LoginPage(driver);
	  HomePage homepage=new HomePage(driver);
	  loginpage.enterUsernameAndPassword("admin","admin");
	  loginpage.clickSiginButton();
	  homepage.clickAdminLink();
	  homepage.clickLogoutLink();
	  String expected="Dashboard | 7rmart supermarket";
	  String actual="Dashboard | 7rmart supermarket";
	  Assert.assertEquals(actual, expected, Constant.ERROR_MESSAGE_UNABLE_TO_LOGOUT);
  }
}
