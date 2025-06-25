package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	WebDriver driver;
public void browser() {
	 driver = new ChromeDriver();
	driver.get("https://rise-testing.kran.co.in/cas/login?service=https%3A%2F%2Frise-testing.kran.co.in%2Fseepz%2Flogin%2Fcas");
	driver.manage().window().maximize();
 
}
public void display() {
	
 String title=	driver.getTitle();
String url=	driver.getCurrentUrl();
System.out.println(title+" "+url);
}
public void locator() {
	WebElement username=driver.findElement(By.id("username"));
	username.sendKeys("neeju@kran.co.in");
	WebElement password=driver.findElement(By.id("password"));
	password.sendKeys("pass");
}

	public static void main(String[] args) {
	Base base=new Base();	
base.browser();
base.display();
base.locator();
	}

}
