package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_Agenda_Details {
	WebDriver driver;

	public Add_Agenda_Details(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Agenda Approval']")
	WebElement agenda_approval;
	@FindBy(xpath = "//table[@id='tableData']/tbody/tr/td[3]")
	List<WebElement> unitName;
	@FindBy(xpath = "//table[@id='tableData']/tbody/tr/td[6]//a[@class='btn btn-datatable btn-icon btn-action-primary']")
	List<WebElement> viewIcon;

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
}
