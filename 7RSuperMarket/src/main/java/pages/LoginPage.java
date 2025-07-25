package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageutilities.WaitUtility;

public class LoginPage {
WebDriver driver;
WaitUtility utility=new WaitUtility();
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//input[@name='username']")WebElement username;
@FindBy(xpath="//input[@name='password']")WebElement password;
@FindBy(xpath="//button[@type='submit']")WebElement signinbutton;
@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alertmessage;
 
public void enterUsernameAndPassword(String usernamefield,String passwordfield) {
	username.sendKeys(usernamefield);
	password.sendKeys(passwordfield);
}
public HomePage clickSiginButton() {
	utility.waitForElementToBeClicked(driver, signinbutton);
	signinbutton.click();
	return new HomePage(driver);
}
public boolean isDashboardIsDisplayed() {
	
	return dashboard.isDisplayed();
}
public boolean isAlertMessageIsDisplayed() {
	
	return alertmessage.isDisplayed();
}
}
