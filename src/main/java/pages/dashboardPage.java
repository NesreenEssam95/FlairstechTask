package pages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utiles.ReadingCustomerDeatails;

public class dashboardPage {
	
	WebDriver browserobject;
	WebDriverWait wait;
	
	By admin_acc = By.xpath("(//ul[@class='oxd-main-menu']//li)[1]");
	By recordsCount = By.xpath("//span[@class='oxd-text oxd-text--span']");
	By add_btn = By.xpath("//div[@class='orangehrm-header-container']//button");
	By searchOptions = By.xpath("(//div[@class='--toggle'])[2]");
	By userName_txt = By.xpath("//form[@class='oxd-form']//input[@class='oxd-input oxd-input--active']");//input[starts-with(@class, 'oxd-input oxd-input--active')])[2]
	By search_btn = By.xpath("//button[@type='submit']");
		
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
	
	public dashboardPage clickOnSearchOptions()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchOptions));
		browserobject.switchTo().frame(browserobject.findElement(searchOptions));
		
		//browserobject.switchTo().defaultContent();
		//browserobject.findElement(searchOptions).click();
		
		browserobject.switchTo().defaultContent();
	    new Actions(browserobject).click().build().perform();
	
		return this;
	}
	
	public dashboardPage searchForAddedUser() throws IOException
	{
		String employeeUserName = ReadingCustomerDeatails.ReadingData(4,1);
		
		browserobject.switchTo().defaultContent();
		//browserobject.switchTo().frame(1);
		new Actions(browserobject).click().build().perform();
		
		/******* I tried alot to find a solution for locating this textbox as below but i can't for the sake of little time ******************/
		//wait.until(ExpectedConditions.visibilityOfElementLocated(userName_txt));
		//browserobject.switchTo().frame(browserobject.findElement(userName_txt));
		 //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("content"));
	    // wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("detailsDisplay"));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("content"));
		//  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("detailsDisplay"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(userName_txt));
		//browserobject.switchTo().frame(browserobject.findElement(userName_txt));
		//browserobject.switchTo().frame("mainFrame.1.child");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(userName_txt));
		//new WebDriverWait(browserobject, 20).until(ExpectedConditions.elementToBeClickable(userName_txt)).sendKeys(employeeUserName);
		//new WebDriverWait(browserobject, 20).until(ExpectedConditions.presenceOfElementLocated(userName_txt));
		//new WebDriverWait(browserobject, 60).until(ExpectedConditions.elementToBeClickable(userName_txt)).click();
		WebElement empUserName = browserobject.findElement(userName_txt);      
		empUserName.sendKeys(employeeUserName);
		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(search_btn));
	     browserobject.findElement(search_btn).click();
		return this;
	}
	
	 

}
