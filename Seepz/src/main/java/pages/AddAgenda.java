package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAgenda {
WebDriver driver;
public AddAgenda(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[contains (@class,'badge badge-status  bg-primary-soft')]")WebElement createAgenda;
@FindBy(xpath="//select[@id='agendaId']")WebElement agendaTitle;
@FindBy(xpath="//select[@id='unitTypeId']") WebElement sezName;
@FindBy(xpath="//input[@id='refernceNo']")WebElement sequenceNumber;
}
