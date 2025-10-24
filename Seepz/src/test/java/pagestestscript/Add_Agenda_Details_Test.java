package pagestestscript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AddAgenda;
import pages.Add_Agenda_Details;
import pages.LoginPage;
import pages.MeetingPage;
import pages.ModuleListPage;
import pageutilities.ExcelUtility;

public class Add_Agenda_Details_Test extends Base{
	ModuleListPage modulelist;
	MeetingPage meeting;
	AddAgenda addagenda;
	Add_Agenda_Details addDetails;
  @Test
  public void verifyThatTheUserIsAbleToAddAgendaDetails() throws IOException {
	  LoginPage login=new LoginPage(driver);
	  String username = ExcelUtility.readStringData(6, 0, "login_page");
		String pass = ExcelUtility.readStringData(6, 1, "login_page");
		login.loginAsSeepzUser(username, pass);
		modulelist = login.clickOnLoginButton();
		modulelist.clickOnModuleListLink();
		meeting = modulelist.clickOnUAC_Module();
	  addDetails=new Add_Agenda_Details(driver);
		addDetails.click_On_AgendaApprovalTab().unitNames().clickOnViewIcon("Malabar Gold");
		addDetails.clickEditDetails();
		addDetails.addProposalDetails("test");
  }
}
