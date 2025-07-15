package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="(//a[@href='#'])[2]")WebElement adminLink;
@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'])[1]")WebElement logoutLink;

public void clickAdminLink() {
	adminLink.click();
}
public void clickLogoutLink() {
	logoutLink.click();
}
}
