package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.LoginPage;

public class AdminUserPageTest extends Base{
  @Test
  public void verifyThatTheUserCanSaveAdminUserInformations() {
	  LoginPage loginpage=new LoginPage(driver);
	  AdminUserPage adminuser=new AdminUserPage(driver);
	  loginpage.enterUsernameAndPassword("admin","admin");
	  loginpage.clickSiginButton();
	  adminuser.clickMoreInfo();
	  adminuser.clickNewButton();
	  adminuser.enterUserNameAndPassword("jobin", "Jobi12@");
	  adminuser.selectUserType("admin");
	  adminuser.clickSaveButton();
	  boolean isAlertDisplayed= adminuser.isAlertIsDisplayed();
	  Assert.assertTrue(isAlertDisplayed, "Unable to save the admin information");
  }
}
