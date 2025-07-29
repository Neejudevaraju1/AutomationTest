package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pageutilities.ExcelUtility;

public class LoginPageTest extends Base {
	HomePage homepage;

	@Test
	public void verifyUserCanLoginWithValidCredentials() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(1, 0, "Login_Page");
		String password = ExcelUtility.readStringData(1, 1, "Login_Page");
		loginpage.enterUsernameAndPassword(userName, password);
		homepage = loginpage.clickSiginButton();
		boolean isdashboarddisplayed = loginpage.isDashboardIsDisplayed();
		Assert.assertTrue(isdashboarddisplayed, Constant.ERROR_MESSAGE_FOR_LOGIN_FAIL);
	}

	@Test
	public void verifyUserCanLoginWithValidUsernameAndInvalidPassword() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(2, 0, "Login_Page");
		String password = ExcelUtility.readStringData(2, 1, "Login_Page");
		loginpage.enterUsernameAndPassword(userName, password);
		homepage = loginpage.clickSiginButton();
		boolean isalertdisplayed = loginpage.isAlertMessageIsDisplayed();
		Assert.assertTrue(isalertdisplayed, Constant.ERROR_MESSAGE_LOGIN_WITH_INVALID_CREDENTIALS);
	}

	@Test
	public void VerifyUserCanLoginWithInvalidUsernameAndValidPassword() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(3, 0, "Login_Page");
		String password = ExcelUtility.readStringData(3, 1, "Login_Page");
		loginpage.enterUsernameAndPassword(userName, password);
		homepage = loginpage.clickSiginButton();
		boolean isalertdisplayed = loginpage.isAlertMessageIsDisplayed();
		Assert.assertTrue(isalertdisplayed, Constant.ERROR_MESSAGE_LOGIN_WITH_INVALID_CREDENTIALS);
	}

	@Test
	public void verifyUserCanLoginWithInvalidCredentials() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(3, 0, "Login_Page");
		String password = ExcelUtility.readStringData(3, 1, "Login_Page");
		loginpage.enterUsernameAndPassword(userName, password);
		homepage = loginpage.clickSiginButton();
		boolean isalertdisplayed = loginpage.isAlertMessageIsDisplayed();
		Assert.assertTrue(isalertdisplayed, Constant.ERROR_MESSAGE_LOGIN_WITH_INVALID_CREDENTIALS);
	}
}
