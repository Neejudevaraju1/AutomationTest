package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageutilities.PageUtilities;

public class HomePage {
WebDriver driver;
PageUtilities utility;
public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="(//a[@href='#'])[2]")WebElement adminLink;
@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'])[1]")WebElement logoutLink;
// clicking more info of Admin because the action is done from home page
@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]") WebElement admin_moreInfo; //more info of admin card
@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'])[2]")WebElement moreInfo;// more info of news card
@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[2]")WebElement moreInfoCategory;
public HomePage clickAdminLink() {
	adminLink.click();
	return this;
}
public HomePage clickLogoutLink() {
	logoutLink.click();
	return this;
}

// method of clicking the more info link of adminuser  from the home page which will redirect to admin page so the return type should be AdminUserPage class

public AdminUserPage clickMoreInfo() {
	
	admin_moreInfo.click();
	 return new AdminUserPage(driver);
}

public ManageNewsPage clickMoreInfoOfNews() {
	//utility=new PageUtilities(driver);
//	utility.scrollIntoView(moreInfo);
	moreInfo.click();
	return new ManageNewsPage(driver);
}
public ManageCategory clickMoreInfoCategory() {
	moreInfoCategory.click();
	return new ManageCategory(driver);
}
}
