package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import pageutilities.PageUtilities;
import pageutilities.WaitUtility;

public class ManageCategory {

	WebDriver driver;
	PageUtilities utilities;
	WaitUtility utility=new WaitUtility();
	public ManageCategory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		utilities=new PageUtilities(driver);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newCategoryButton;
	@FindBy(xpath="//input[@id='category']")WebElement category;
	@FindBy(id="134-selectable")WebElement selectGroup;
	@FindBy(xpath="//input[@id='main_img']")WebElement chooseFile;
	@FindBy(xpath="//button[@type='submit']")WebElement saveButton;
	
	public ManageCategory clickNewCategoryButton() {
		
		newCategoryButton.click();
		return this;
	}
	public ManageCategory enterNewCategory(String categoryname) {
		
		category.sendKeys(categoryname);
		return this;
		
	}
	public ManageCategory selectGroups() {
		utility.waitForElementToBeVisible(driver, selectGroup);
		selectGroup.click();
		return this;
	}
	public ManageCategory chooseFile() {
		String file=Constant.TEST_PIC;
		chooseFile.sendKeys(file);
		return this;
		
	}
	public ManageCategory clickOnSaveButton() {
		utilities.scrollDownByPixels(2000);
		utility.waitForElementToBeClicked(driver, saveButton);
		utilities.clickElementByJS(saveButton);
		return this;
	}
}
