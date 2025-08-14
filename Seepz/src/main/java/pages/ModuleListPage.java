package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageutilities.WaitUtility;

public class ModuleListPage {
	WebDriver driver;
	WaitUtility utility;

	public ModuleListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utility = new WaitUtility();
	}

	@FindBy(xpath = "//a[@href='/seepz/goToModule/UM']")
	WebElement unitManagement;
	@FindBy(xpath = "//a[@href='/unitmanagement/services/gotoUnitServices']")
	WebElement link;

	public ServicesPage clickUnitManagementModule() {
		utility.waitForElementToBeClickable(driver, "//a[@href='/seepz/goToModule/UM']");
		unitManagement.click();
		return new ServicesPage(driver);
	}

	public boolean isServicesTabDisplayed() {
		return link.isDisplayed();
	}
}
