package BaseClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Base {
  WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  driver=new ChromeDriver();
	  driver.get("https://rise-testing.kran.co.in/cas/login?service=https%3A%2F%2Frise-testing.kran.co.in%2Fseepz%2Flogin%2Fcas");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
  }

  @AfterMethod
  public void afterMethod() {
	 // driver.quit();
  }

}
