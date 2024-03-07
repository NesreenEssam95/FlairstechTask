package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utiles.ReadingCustomerDeatails;

public class addUserPage {
	
	private static final By By = null;
	WebDriver browserobject;
	WebDriverWait wait;
	
	By userRoleDropDown = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
	By userAdminRole = By.xpath("//div[@class='oxd-select-text-input' and contains(.,'Admin')] ");
	By statusDropDown = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
	By employeeName_txt = By.xpath("//input[@placeholder='Type for hints...']");
	By userName_txt = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By password_txt = By.xpath("(//input[@type='password'])[1]");
	By confirmedPassword_txt = By.xpath("(//input[@type='password'])[2]");
	By submit_btn = By.xpath("//button[@type='submit']");
	
	
	
	public addUserPage(WebDriver browserobject,WebDriverWait wait)
	{
		this.browserobject=browserobject;
		this.wait = wait;
		
	}
	
	public addUserPage addSystemUser() throws IOException, InterruptedException
	{
		
       String employeeName = ReadingCustomerDeatails.ReadingData(3,1);
       String employeeUserName = ReadingCustomerDeatails.ReadingData(4,1);
       String employeePassword = ReadingCustomerDeatails.ReadingData(5,1);
       String employeeConfirmedPassword = ReadingCustomerDeatails.ReadingData(6,1);
		
       wait.until(ExpectedConditions.visibilityOfElementLocated(userRoleDropDown));
       browserobject.findElement(userRoleDropDown).click();
       Actions keyDownRole = new Actions(browserobject); 
       keyDownRole.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform(); 
       
       wait.until(ExpectedConditions.visibilityOfElementLocated(employeeName_txt));
	   WebElement empName = browserobject.findElement(employeeName_txt);      
	   empName.sendKeys(employeeName);
	   Thread.sleep(2000);
	   Actions keyDownName = new Actions(browserobject); 
	   keyDownName.sendKeys(Keys.chord(Keys.DOWN,Keys.DOWN, Keys.ENTER)).perform();
       
  
	   wait.until(ExpectedConditions.visibilityOfElementLocated(statusDropDown));
       browserobject.findElement(statusDropDown).click();
       Actions keyDownStatus = new Actions(browserobject); 
       keyDownStatus.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
       
		wait.until(ExpectedConditions.visibilityOfElementLocated(userName_txt));
		WebElement empUserName = browserobject.findElement(userName_txt);      
		empUserName.sendKeys(employeeUserName);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(password_txt));
		WebElement empPassword = browserobject.findElement(password_txt);      
		empPassword.sendKeys(employeePassword);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmedPassword_txt));
		WebElement empConfirmedPassword = browserobject.findElement(confirmedPassword_txt);      
		empConfirmedPassword.sendKeys(employeeConfirmedPassword);
   
	    wait.until(ExpectedConditions.visibilityOfElementLocated(submit_btn));
		browserobject.findElement(submit_btn).click();
		
		return this;
	
     }
}
