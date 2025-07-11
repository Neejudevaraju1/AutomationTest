package BaseClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation.LoginPage;

public class LoginTest extends Base {
  @Test(dataProvider = "credentials")
  public void enterUsernameAndPassword(String username,String password) {
	  LoginPage loginpage= new LoginPage(driver);
	 // loginpage.clickUser();
	  loginpage.usernameAndPassword(username, password);
	  loginpage.loginButton();
	System.out.println(driver.getTitle());
  }
  @DataProvider(name= "credentials")
	  public Object[][] dataprovider(){
	  Object[][]data= {{"jdcpc-mah@gov.in","pass"},{"tests","pass"},{"neeju@kran.co.in","test"},{"tests","test"}};
	  return data;
  }
  
}
