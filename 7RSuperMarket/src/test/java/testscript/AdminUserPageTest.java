package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import pageutilities.ExcelUtility;

public class AdminUserPageTest extends Base {
	HomePage homepage;
	AdminUserPage adminuser;

	@Test
	public void verifyThatTheUserCanSaveAdminUserInformations() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(1, 0, "Admin_page_Test");
		String password = ExcelUtility.readStringData(1, 1, "Admin_page_Test");
		loginpage.enterUsernameAndPassword(userName, password);
		homepage = loginpage.clickSiginButton();
		adminuser = homepage.clickMoreInfo();
		String adminUserName = ExcelUtility.readStringData(1, 2, "Admin_page_Test");
		String adminPassword = ExcelUtility.readStringData(1, 3, "Admin_page_Test");
		String adminUserType = ExcelUtility.readStringData(1, 4, "Admin_page_Test");
		adminuser.clickNewButton().enterUserNameAndPassword(adminUserName, adminPassword).selectUserType(adminUserType)
				.clickSaveButton();
		// assertion if the entered data get saved
		boolean isAlertDisplayed = adminuser.isAlertIsDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constant.ERROR_MESSAGE_UNABLE_TO_SAVE_USER_INFO);

	}

	@Test
	public void verifyThatTheUserCanSaveAlreadyExistingAdminUserInfo() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(1, 0, "Admin_page_Test");
		String password = ExcelUtility.readStringData(1, 1, "Admin_page_Test");
		loginpage.enterUsernameAndPassword(userName, password);
		homepage = loginpage.clickSiginButton();
		adminuser = homepage.clickMoreInfo();
		String adminUserName = ExcelUtility.readStringData(1, 2, "Admin_page_Test");
		String adminPassword = ExcelUtility.readStringData(1, 3, "Admin_page_Test");
		String adminUserType = ExcelUtility.readStringData(1, 4, "Admin_page_Test");
		adminuser.clickNewButton().enterUserNameAndPassword(adminUserName, adminPassword).selectUserType(adminUserType)
				.clickSaveButton();
		// assertion if the entered data exist in the table
		boolean isExistAlertDisplayed = adminuser.isExitAlertIsDisplayed();
		Assert.assertTrue(isExistAlertDisplayed, Constant.ERROR_MESSAGE_SAVE_DUPLICATE_ENTRY);

	}

	@Test
	public void verifyUserCanSaveAdminInfoWithoutUserName() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(1, 0, "Admin_page_Test");
		String password = ExcelUtility.readStringData(1, 1, "Admin_page_Test");
		loginpage.enterUsernameAndPassword(userName, password);
		homepage = loginpage.clickSiginButton();
		adminuser = homepage.clickMoreInfo();
		// String adminUserName = ExcelUtility.readStringData(1, 2, "Admin_page_Test");
		String adminPassword = ExcelUtility.readStringData(2, 3, "Admin_page_Test");
		String adminUserType = ExcelUtility.readStringData(2, 4, "Admin_page_Test");
		adminuser.clickNewButton().enterUserNameAndPassword("", adminPassword).selectUserType(adminUserType)
				.clickSaveButton();
		System.out.println(adminuser.isDataValiadtionForUserNameIsDisplayed());
		// assertion for user name validation
		String actual = adminuser.isDataValiadtionForUserNameIsDisplayed();
		String expected = "Please fill in this field.";
		Assert.assertEquals(actual, expected, Constant.ERROR_MESSAGE_NO_VALIDATION_FOR_USERNAME);
	}

	@Test
	public void verifyUserCanSaveAdminInfoWithoutPassword() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(1, 0, "Admin_page_Test");
		String password = ExcelUtility.readStringData(1, 1, "Admin_page_Test");
		loginpage.enterUsernameAndPassword(userName, password);
		homepage = loginpage.clickSiginButton();
		adminuser = homepage.clickMoreInfo();
		String adminUserName = ExcelUtility.readStringData(3, 2, "Admin_page_Test");
		//String adminPassword = ExcelUtility.readStringData(3, 3, "Admin_page_Test");
		String adminUserType = ExcelUtility.readStringData(3, 4, "Admin_page_Test");
		adminuser.clickNewButton().enterUserNameAndPassword(adminUserName, "").selectUserType(adminUserType)
				.clickSaveButton();
		// assertion for password validation
		boolean actual = adminuser.isDataValidationForPasswordDisplayed();
		boolean expected = true;
		Assert.assertEquals(actual, expected,
				"there is no validation and alert message to enter password is not displayed");
	}
}
