package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import pageutilities.ExcelUtility;

public class ManageNewPageTest extends Base {
	HomePage homepage;
	ManageNewsPage managenews;
  @Test
  public void verifyThatTheUserCanSaveNews() throws IOException {
	  LoginPage loginpage=new LoginPage(driver);
	  String userName=ExcelUtility.readStringData(1, 0, "Login_Page");
	  String password=ExcelUtility.readStringData(1, 1, "Login_Page");
	  loginpage.enterUsernameAndPassword(userName, password);
	  homepage=loginpage.clickSiginButton();
	  managenews=homepage.clickMoreInfoOfNews();
	  String news=ExcelUtility.readStringData(1, 0, "News");
	  managenews.clickNewButton().enterNewsToTheField(news).clickSaveButton();
	  boolean isAlertDisplayed= managenews.isAlertIsDiplayedAfterSaving();
	  Assert.assertTrue(isAlertDisplayed,Constant.ERROR_MESSAGE_UNABLE_TO_SAVE_NEWS );
  }
}
