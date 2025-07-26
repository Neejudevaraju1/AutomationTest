package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategory;
import pageutilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	HomePage homepage;
	ManageCategory managecategory;
  @Test
  public void verifyThatTheUserIsAbleToAddNewCategory() throws IOException{
	LoginPage login=new LoginPage(driver);	  
	String username=ExcelUtility.readStringData(1, 0, "Login_Page");
			String password=ExcelUtility.readStringData(1, 1, "Login_Page");
		  login.enterUsernameAndPassword(username, password);
		  homepage=login.clickSiginButton();
		  managecategory=homepage.clickMoreInfoCategory();
		  String categoryname=ExcelUtility.readStringData(1, 0, "Manage_Category");
		  managecategory.clickNewCategoryButton().enterNewCategory(categoryname).selectGroups().chooseFile().clickOnSaveButton();
  }
}
