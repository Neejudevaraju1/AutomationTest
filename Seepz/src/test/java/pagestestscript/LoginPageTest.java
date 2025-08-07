package pagestestscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;

public class LoginPageTest extends Base {

	@Test
	public void verifyThatTheUserIsAbleToLoginAsSeepzUser() {
		LoginPage login = new LoginPage(driver);
		login.loginAsSeepzUser("ajeet.bhati@gov.in", "pass");
		login.clickOnLoginButton();
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected = "RISe Log In Successful";
		Assert.assertEquals(actual, expected, Constant.ERROR_MESSAGE_UNABLE_TO_LOGIN_WITH_VALID_CREDENTIALS);
	}

	@Test
	public void verifyThatTheUserIsAbleToLoginAsSeepzUserWithInvalidCredentials() {
		LoginPage login = new LoginPage(driver);
		login.loginAsSeepzUser("dennis.vazhappily@portescap.com", "test");
		login.clickOnLoginButton();
		boolean actual = login.isAlertIsDisplayed();
		Assert.assertTrue(actual, Constant.ERROR_MESSAGE_FOR_LOGIN_WITH_INVALID_CREDENTIAL);
	}

	@Test
	public void verifyThatTheUserIsAbleToLoginWithInvalidUsenameAndValidPassword() {
		LoginPage login = new LoginPage(driver);
		login.loginAsSeepzUser("test", "pass");
		login.clickOnLoginButton();
		boolean actual = login.isAlertIsDisplayed();
		Assert.assertTrue(actual, Constant.ERROR_MESSAGE_FOR_LOGIN_WITH_INVALID_CREDENTIAL);
	}

	@Test
	public void verifyThatTheUserIsAbleToLoginWithValidUserNameAndInvalidPassword() {
		LoginPage login = new LoginPage(driver);
		login.loginAsSeepzUser("test", "test");
		login.clickOnLoginButton();
		boolean actual = login.isAlertIsDisplayed();
		Assert.assertTrue(actual, Constant.ERROR_MESSAGE_FOR_LOGIN_WITH_INVALID_CREDENTIAL);
	}
}
