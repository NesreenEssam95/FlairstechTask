package Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import pages.addUserPage;
import pages.dashboardPage;
import pages.loginPage;
import Tests.BaseClass;

public class AutomationDemo extends BaseClass {
	
	@Test(priority=0,enabled=true)
	public void getNumberOfRecordsFound()  {
	    new dashboardPage(browserobject,wait).getNumberOfRecords();
		
	}
	
	@Test(priority=1,enabled=false)
	public void addNewRecord() throws IOException, InterruptedException  {
		
	    new dashboardPage(browserobject,wait).clickOnAddButton();
	    new addUserPage(browserobject,wait).addSystemUser();
	    new dashboardPage(browserobject,wait).getNumberOfRecords();
		
	}
	
	@Test(priority=2,enabled=false)
	public void searchForaddedUserSuccessfully() throws IOException, InterruptedException  {
		
	    new dashboardPage(browserobject,wait).clickOnSearchOptions().searchForAddedUser();
	   
		
	}
	
	

	

	

}
