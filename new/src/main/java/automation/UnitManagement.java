package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UnitManagement extends Base {
	
	public void unitManagement() {
		WebElement module=driver.findElement(By.xpath("//a[@href='/seepz/goToModule/UM']"));
		module.click();
		System.out.println(driver.getTitle());
	}

	public static void main(String[] args) throws InterruptedException {
		UnitManagement unit=new UnitManagement();
		unit.browser();
		unit.locator();
		unit.unitManagement();

	}

}
