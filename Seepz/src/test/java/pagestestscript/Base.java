package pagestestscript;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Base {
  WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  driver=new ChromeDriver();
	  driver.get("https://rise-testing.kran.co.in/cas/login");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
