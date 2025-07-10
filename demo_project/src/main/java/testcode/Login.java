package testcode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;
	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//input[@id='loginform-username']")WebElement username;
@FindBy(xpath="//input[@id='loginform-password']")WebElement password;
@FindBy(xpath="//button[@type='submit']")WebElement loginButton;

public void usernameAndPassword(String usernamefield , String passwordfield) {
	username.sendKeys(usernamefield);
	password.sendKeys(passwordfield);
}

public void clickLoginButton() {
	loginButton.click();
}
}
