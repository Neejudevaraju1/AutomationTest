package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pageutilities.PageUtilities;

public class AdminUserPage {
WebDriver driver;
PageUtilities utility=new PageUtilities();

public AdminUserPage(WebDriver driver) {
	
	this.driver =driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]") WebElement admin_moreInfo;
@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newButton;
@FindBy(xpath="//input[@id='username']")WebElement username;
@FindBy(xpath="//input[@id='password']")WebElement pass;
@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
@FindBy(xpath="(//button[@type='submit'])[2]")WebElement saveButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;

public void clickMoreInfo() {
	
	admin_moreInfo.click();
}
public void clickNewButton() {
	
	newButton.click();
}
public void enterUserNameAndPassword(String user, String passwd) {
	
	username.sendKeys(user);
	pass.sendKeys(passwd);
}
public void selectUserType(String user_Type) {
	
	utility.selectFromDropDown_ByValue(usertype, user_Type);
}
public void clickSaveButton() {
	
	saveButton.click();
}
public boolean isAlertIsDisplayed() {
	return alert.isDisplayed();
}
}