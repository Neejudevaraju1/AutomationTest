package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;

 public LoginPage( WebDriver driver) {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
@FindBy(xpath="//label[text()='Public User']")WebElement user;
@FindBy(id="username")WebElement username;
@FindBy(id="password")WebElement password;
@FindBy(xpath="//button[@type='submit']")WebElement loginButton;
@FindBy(xpath="//input[@id='captcha-customField']")WebElement captcha;
public void clickUser() {
	user.click();
}
public void usernameAndPassword(String usernamefield,String passwordfield) {
	username.sendKeys(usernamefield);
	password.sendKeys(passwordfield);
	
}
public void loginButton() {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='captcha-customField']")));
	wait.until(driver->!captcha.getAttribute("value").trim().isEmpty());
    loginButton.click();
}

/*public void locator() throws InterruptedException {
	WebElement user=driver.findElement(By.xpath("//label[text()='Public User']"));
	user.click();
	WebElement username=driver.findElement(By.id("username"));
	username.sendKeys("neeju@kran.co.in");
	WebElement password=driver.findElement(By.id("password"));
	password.sendKeys("pass");
	Thread.sleep(5000);
	WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
	login.click();
	WebElement alert=driver.findElement(By.xpath("//button[text()='Skip']"));
	alert.click();
	//driver.switchTo().alert().dismiss();
	
}*/

	
	

}
