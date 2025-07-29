package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pageutilities.ExcelUtility;

public class HomePageTest extends Base {
	@Test
	public void verifyThatTheAdminLinkIsClickable() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		String userName = ExcelUtility.readStringData(1, 0, "Login_Page");
		String password = ExcelUtility.readStringData(1, 1, "Login_Page");
		loginpage.enterUsernameAndPassword(userName, password);
		loginpage.clickSiginButton();
		homepage.clickAdminLink();
		homepage.clickLogoutLink();
		String expected = "Dashboard | 7rmart supermarket";
		String actual = "Dashboard | 7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.ERROR_MESSAGE_UNABLE_TO_LOGOUT);
	}
}
