package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageutilities.PageUtility;
import pageutilities.WaitUtility;

public class Add_Agenda_Details {
	WebDriver driver;
	WaitUtility utility;
	PageUtility page;

	public Add_Agenda_Details(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utility = new WaitUtility();
		page = new PageUtility(driver);
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
	/*
	 * @FindBy(xpath = "(//iframe[@class='cke_wysiwyg_frame cke_reset'])[1]")
	 * WebElement proposal;
	 * 
	 * @FindBy(xpath = "(//iframe[@class='cke_wysiwyg_frame cke_reset'])[2]")
	 * WebElement detail2;
	 * 
	 * @FindBy(xpath = "(//iframe[@class='cke_wysiwyg_frame cke_reset'])[3]")
	 * WebElement detail3;
	 * 
	 * @FindBy(xpath = "(//iframe[@class='cke_wysiwyg_frame cke_reset'])[4]")
	 * WebElement detail4;
	 * 
	 * @FindBy(xpath = "(//iframe[@class='cke_wysiwyg_frame cke_reset'])[5]")
	 * WebElement detail5;
	 */
	@FindBy(xpath = "//input[@onclick='saveBasicForm()']")
	WebElement saveButton;
	@FindBy(xpath = "//button[text()='Yes']")
	WebElement accept;

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

	public Add_Agenda_Details clickEditDetails() {
		editButton.click();
		return this;
	}

	public Add_Agenda_Details addProposalDetails(String data) throws InterruptedException {
		// driver.navigate().refresh();
		/*
		 * By proposalFrame =
		 * By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[1]");
		 * utility.waitForIframeToBeAvailable(driver, proposalFrame);
		 * driver.switchTo().frame(driver.findElement(proposalFrame));
		 */
		Thread.sleep(Duration.ofSeconds(5));
		WebElement proposal = driver.findElement(By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[1]"));
		utility.waitForElementToBeLocated(driver, "(//iframe[@class='cke_wysiwyg_frame cke_reset'])[1]");

		page.setInputinCkEditor(proposal, data);
		/*
		 * WebElement proposalBody =
		 * driver.findElement(By.xpath("//body[@contenteditable='true']"));
		 * proposalBody.click(); proposalBody.clear(); proposalBody.sendKeys(data);
		 * 
		 * driver.switchTo().defaultContent();
		 */
		return this;
	}

	public Add_Agenda_Details addDetailOnSecondColoumn(String data) {
		By frame2 = By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[2]");
		utility.waitForIframeToBeAvailable(driver, frame2);
		driver.switchTo().frame(driver.findElement(frame2));

		WebElement body2 = driver.findElement(By.xpath("//body[@contenteditable='true']"));
		body2.click();
		body2.clear();
		body2.sendKeys(data);

		driver.switchTo().defaultContent();
		return this;
	}

	public Add_Agenda_Details addDetailsOnThirdColoumn(String data) {
		By frame3 = By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[3]");
		utility.waitForIframeToBeAvailable(driver, frame3);
		driver.switchTo().frame(driver.findElement(frame3));

		WebElement body3 = driver.findElement(By.xpath("//body[@contenteditable='true']"));
		body3.click();
		body3.clear();
		body3.sendKeys(data);

		driver.switchTo().defaultContent();
		return this;
	}

	public Add_Agenda_Details addDetailsToFourthColoumn(String data) {
		By frame4 = By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[4]");
		utility.waitForIframeToBeAvailable(driver, frame4);
		driver.switchTo().frame(driver.findElement(frame4));

		WebElement body4 = driver.findElement(By.xpath("//body[@contenteditable='true']"));
		page.scrollIntoView(body4);
		body4.click();
		body4.clear();
		body4.sendKeys(data);

		driver.switchTo().defaultContent();
		return this;
	}

	public Add_Agenda_Details addDetailsToFifthColumn(String data) {
		By frame5 = By.xpath("(//iframe[@class='cke_wysiwyg_frame cke_reset'])[5]");
		utility.waitForIframeToBeAvailable(driver, frame5);
		driver.switchTo().frame(driver.findElement(frame5));
		

		WebElement body5 = driver.findElement(By.xpath("//body[@contenteditable='true']"));
		page.scrollIntoView(body5);
		body5.click();
		body5.clear();
		body5.sendKeys(data);

		driver.switchTo().defaultContent();
		return this;
	}

	public void clickOnSaveButton() {
		saveButton.click();
		accept.click();
	driver.navigate().refresh();
	}
}
