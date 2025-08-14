package pagestestscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import pages.ModuleListPage;
import pageutilities.ExcelUtility;

public class ModuleListPageTest extends Base {
	ModuleListPage modulelist;
	ExcelUtility utility = new ExcelUtility();

	@Test
	public void verifyThatTheUserIsAbleToClickOnUnitManagementModule() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = utility.readStringData(2, 0, "login_page");
		String pass = utility.readStringData(2, 1, "login_page");
		login.clickOnPublicUser().loginAsPublicUser(userName, pass);
		modulelist = login.clickOnLoginButton();
		modulelist.clickUnitManagementModule();
		boolean actual = modulelist.isServicesTabDisplayed();
		Assert.assertTrue(actual, Constant.ERROR_MESSAGE_FOR_MODULE_OPENING);
	}
}
