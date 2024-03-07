package Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import pages.dashboardPage;
import pages.loginPage;

public class BaseClass {
	WebDriver browserobject;
	WebDriverWait wait;
	
	
	@BeforeMethod
	  public void setup() throws IOException, InterruptedException, EncryptedDocumentException
	 {
		 System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\Driver\\geckodriver.exe");
        browserobject = new FirefoxDriver(new GeckoDriverService.Builder().build()); 
        wait =new WebDriverWait(browserobject,10);
		browserobject.manage().window().maximize();

		 new loginPage(browserobject,wait).navigateTositeurl().loginSuccessfully();
		 new dashboardPage(browserobject,wait).clickOnAdminAccordion();
	
		  
	  }
	
	
	
	 @AfterClass
	  public void tearDown()
	 {
		 browserobject.close();
	 }

}
