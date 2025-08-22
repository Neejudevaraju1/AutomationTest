package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageutilities.PageUtility;
import pageutilities.WaitUtility;

public class MeetingPage {
	WebDriver driver;
	WaitUtility utility;
	PageUtility pageutility = new PageUtility();

	public MeetingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utility = new WaitUtility();
	}

	@FindBy(id = "meetingtab")
	WebElement meetingTab;
	@FindBy(xpath = "//div[@id='addToggleText']")
	WebElement initiateMeetingButton;
	@FindBy(xpath = "//textarea[@id='title']")
	WebElement title;
	@FindBy(xpath = "//input[@id='scheduleDate']")
	WebElement dateField;
	@FindBy(xpath = "//table[@class=' table-condensed']/tbody/tr/td[@class='day' and text()='23']")
	WebElement pickdate; // changing xpath
	@FindBy(xpath = "//select[@id='fromTime']")
	WebElement fromTime;
	@FindBy(xpath = "//select[@id='toTime']")
	WebElement toTime;
	@FindBy(xpath = "//input[@id='venue']")
	WebElement venue;
	@FindBy(xpath = "//button[@id='saveButton']")
	WebElement scheduleButton;
	@FindBy(xpath = "//div[@id='alertMain']//li[contains (text() ,'Please Enter Date')]")
	WebElement noDateAlert;
	@FindBy(xpath = "//div[@id='alertMain']//li[contains (text() ,'Please Enter From Time')]")
	WebElement noFromTimeALert;
	@FindBy(xpath = "//div[@id='alertMain']//li")
	WebElement alertMessage;

	public MeetingPage clickOnMeetingTab() {
		meetingTab.click();
		return this;
	}

	public MeetingPage clickOnInitiateMeetingButton() {
		initiateMeetingButton.click();
		return this;
	}

	public MeetingPage enterTilteOfTheMeeting(String data) {
		title.sendKeys(data);
		return this;
	}

	public MeetingPage selectDateOfTheMeeting() {
		dateField.click();
		utility.WaitForElementToBeClicked(driver, pickdate);
		pickdate.click();
		return this;
	}

	public MeetingPage selectFromTimeOfMeeting(int index) {
		pageutility.selectFromDropDown_ByIndex(fromTime, index);
		return this;
	}

	public MeetingPage selectToTimeForTheMeeting(int index) {
		pageutility.selectFromDropDown_ByIndex(toTime, index);
		return this;
	}

	public MeetingPage enterTheVenueForTheMeeting(String data) {
		venue.sendKeys(data);
		return this;
	}

	public MeetingPage clickOnScheduleButton() {
		scheduleButton.click();
		return this;
	}

	// assertion for no date
	public boolean isNoDateAlertIsDisplayed() {

		return noDateAlert.isDisplayed();
	}

	// assertion for no from time
	public boolean isNoFromTimeAlertDisplayed() {
		return noFromTimeALert.isDisplayed();
	}

	public String isalertdisplayed() {
		String alert = alertMessage.getText();
		return alert;
	}
}
