package pageutilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtilities {
WebDriver driver;
public JavaScriptUtilities(WebDriver driver) {
	this.driver=driver;
}


// Scroll into view
public void scrollIntoView(WebElement element) {
	JavascriptExecutor executor= (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].scrollIntoView(true);", element);
}

//Click using JavaScript
public void clickElementByJS(WebElement element) {
	JavascriptExecutor executor= (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", element);
}

//Set value into input
public void setInputValue(WebElement element, String value) {
	JavascriptExecutor executor= (JavascriptExecutor) driver;
  executor.executeScript("arguments[0].value='" + value + "';", element);
}

//Highlight an element
public void highlightElement(WebElement element) {
	JavascriptExecutor executor= (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].style.border='3px solid red'", element);
}

}