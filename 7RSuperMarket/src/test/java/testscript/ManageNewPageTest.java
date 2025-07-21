package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import pages.ManageNewsPage;

public class ManageNewPageTest extends Base {
  @Test
  public void verifyThatTheUserCanSaveNews() {
	  LoginPage loginpage=new LoginPage(driver);
	  ManageNewsPage managenews=new ManageNewsPage(driver);
	  loginpage.enterUsernameAndPassword("admin", "admin");
	  loginpage.clickSiginButton();
	  managenews.clickMoreInfo();
	  managenews.clickNewButton();
	  managenews.enterNewsToTheField(" Welcome to the world NEWS");
	  managenews.clickSaveButton();
	  boolean isAlertDisplayed= managenews.isAlertIsDiplayedAfterSaving();
	  Assert.assertTrue(isAlertDisplayed,Constant.ERROR_MESSAGE_UNABLE_TO_SAVE_NEWS );
  }
}
