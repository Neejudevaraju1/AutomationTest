package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageutilities.WaitUtility;

public class Add_Agenda_Details {
	WebDriver driver;
	WaitUtility utility;

	public Add_Agenda_Details(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utility = new WaitUtility();
	}

//elements of approve agenda tab till view
	@FindBy(xpath = "//a[text()='Agenda Approval']")
	WebElement agenda_approval;
	@FindBy(xpath = "//table[@id='tableData']/tbody/tr/td[3]")
	List<WebElement> unitName;
	@FindBy(xpath = "//table[@id='tableData']/tbody/tr/td[6]//a[@class='btn btn-datatable btn-icon btn-action-primary']")
	List<WebElement> viewIcon;
//elements of view agenda details screen
	@FindBy(xpath = "//span[normalize-space(text())='Edit Details']")
	WebElement editButton;
	@FindBy(xpath = "(//iframe[@class='cke_wysiwyg_frame cke_reset'])[1]")
	WebElement proposal;

	public Add_Agenda_Details click_On_AgendaApprovalTab() {
		agenda_approval.click();
		return this;
	}

	public Add_Agenda_Details unitNames() {
		for (WebElement i : unitName) {
			System.out.println(i.getText());
		}
		return this;
	}

	public Add_Agenda_Details clickOnViewIcon(String unit) {
		for (int i = 0; i < unitName.size(); i++) {
			if (unitName.get(i).getText().trim().equalsIgnoreCase(unit)) {
				viewIcon.get(i).click();
				break;
			}
		}
		return this;
	}

	public void clickEditDetails() {
		editButton.click();
	}

	public void addProposalDetails(String data) {

		utility.waitForIframeToBeAvailable(driver, proposal);

		WebElement proposalBody = driver.findElement(By.xpath("(//body[@contenteditable='true'])[1]"));

		proposalBody.click();
		proposalBody.sendKeys(data);
		driver.switchTo().defaultContent();
	}
}
