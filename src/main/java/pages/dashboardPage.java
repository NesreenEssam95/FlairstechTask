package pages;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dashboardPage {
	
	WebDriver browserobject;
	WebDriverWait wait;
	
	By admin_acc = By.xpath("(//ul[@class='oxd-main-menu']//li)[1]");
	By recordsCount = By.xpath("//span[@class='oxd-text oxd-text--span']");//div[@class='oxd-table-body oxd-card-table-body']/div
	By add_btn = By.xpath("//div[@class='orangehrm-header-container']//button");
		
	public dashboardPage(WebDriver browserobject,WebDriverWait wait)
	{
		this.browserobject=browserobject;
		this.wait = wait;
		
	}
	
	public dashboardPage clickOnAdminAccordion()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(admin_acc));
		browserobject.findElement(admin_acc).click();
		return this;
	}
	
	public dashboardPage getNumberOfRecords()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(recordsCount));
		WebElement TxtBoxContent = browserobject.findElement(recordsCount);
		String recordsNum = TxtBoxContent.getAttribute("innerHTML");
		System.out.println("Printing " + recordsNum);
		return this;
	}
	
	public dashboardPage clickOnAddButton()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(add_btn));
		browserobject.findElement(add_btn).click();
		return this;
	}

}
