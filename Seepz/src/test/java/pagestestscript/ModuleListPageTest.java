package pagestestscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import pages.ModuleListPage;

public class ModuleListPageTest extends Base {
	ModuleListPage modulelist;

	@Test
	public void verifyThatTheUserIsAbleToClickOnUnitManagementModule() {
		LoginPage login = new LoginPage(driver);
		login.clickOnPublicUser().loginAsPublicUser("dennis.vazhappily@portescap.com", "pass");
		modulelist = login.clickOnLoginButton();
		modulelist.clickUnitManagementModule();
		boolean actual = modulelist.isServicesTabDisplayed();
		Assert.assertTrue(actual, Constant.ERROR_MESSAGE_FOR_MODULE_OPENING);
	}
}
