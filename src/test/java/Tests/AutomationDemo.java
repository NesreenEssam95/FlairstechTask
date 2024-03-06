package Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import pages.dashboardPage;
import pages.loginPage;
import Tests.BaseClass;

public class AutomationDemo extends BaseClass {
	
	@Test(priority=0,enabled=true)
	public void getNumberOfRecordsFound()  {
		
	    new dashboardPage(browserobject,wait).clickOnAdminAccordion().getNumberOfRecords().clickOnAddButton();
		
	}
	
	@Test(priority=1,enabled=true)
	public void addNewRecord()  {
		
	    new dashboardPage(browserobject,wait).clickOnAddButton();
		
	}

	

	

}
