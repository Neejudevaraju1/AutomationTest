package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UnitManagement extends Base {
	
	public void unitManagement() {
		WebElement module=driver.findElement(By.xpath("//a[@href='/seepz/goToModule/UM']"));
		module.click();
		System.out.println(driver.getTitle());
	}
	public void permissionNOC() {
		driver.navigate().to("https://rise-testing.kran.co.in/unitmanagement/permission/gotoUnitPermission");
		WebElement unitselect=driver.findElement(By.xpath("//select[@id='unitSetupListId']"));
		Select unit= new Select(unitselect);
		unit.selectByIndex(1);
		WebElement serviceName=driver.findElement(By.xpath("//select[@id='serviceListId']"));
		Select service=new Select(serviceName);
		service.selectByIndex(1);
		WebElement approve=driver.findElement(By.xpath("//button[@id='saveButton']"));
		approve.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement permissionFor=driver.findElement(By.id("select2-serviceId-container"));
		permissionFor.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("select2-selection__arrow")));
		
		//Select permission=new Select(permissionFor);
	   //permission.selectByIndex(4);
	}

	public static void main(String[] args) throws InterruptedException {
		UnitManagement unit=new UnitManagement();
		unit.browser();
		unit.locator();
		unit.unitManagement();
		unit.permissionNOC();

	}

}
