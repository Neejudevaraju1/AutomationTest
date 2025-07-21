package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageutilities.JavaScriptUtilities;
import pageutilities.PageUtilities;

public class ManageNewsPage {
WebDriver driver;
JavaScriptUtilities utilities;

public ManageNewsPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	utilities=new JavaScriptUtilities(driver);
}
@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'])[2]")WebElement moreInfo;
@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newButton;
@FindBy(xpath="//textarea[@id='news']")WebElement enterNews;
@FindBy(xpath="//button[@name='create']")WebElement saveButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertMessage;
public void clickMoreInfo() {
	utilities.scrollIntoView(moreInfo);
	moreInfo.click();
}
public void clickNewButton() {
	newButton.click();
}
public void enterNewsToTheField(String news) {
	enterNews.sendKeys(news);
}
public void clickSaveButton() {
	saveButton.click();
}
public boolean isAlertIsDiplayedAfterSaving() {
	
	return alertMessage.isDisplayed();
}
}
