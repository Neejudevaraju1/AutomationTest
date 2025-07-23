package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUserPage;
import pages.LoginPage;
import pageutilities.ExcelUtility;

public class AdminUserPageTest extends Base{
  @Test
  public void verifyThatTheUserCanSaveAdminUserInformations() throws IOException {
	  LoginPage loginpage=new LoginPage(driver);
	  AdminUserPage adminuser=new AdminUserPage(driver);
	  String userName=ExcelUtility.readStringData(1, 0, "Admin_page_Test");
	  String password=ExcelUtility.readStringData(1, 1, "Admin_page_Test");
	  loginpage.enterUsernameAndPassword(userName,password);
	  loginpage.clickSiginButton();
	  adminuser.clickMoreInfo();
	  adminuser.clickNewButton();
	  String adminUserName=ExcelUtility.readStringData(1, 2, "Admin_page_Test");
	  String adminPassword=ExcelUtility.readStringData(1, 3, "Admin_page_Test");
	  String adminUserType=ExcelUtility.readStringData(1, 4, "Admin_page_Test");
	  adminuser.enterUserNameAndPassword(adminUserName,adminPassword);
	  adminuser.selectUserType(adminUserType);
	  adminuser.clickSaveButton();
	  boolean isAlertDisplayed= adminuser.isAlertIsDisplayed();
	  Assert.assertTrue(isAlertDisplayed, Constant.ERROR_MESSAGE_UNABLE_TO_SAVE_USER_INFO);
	  
  }
}
