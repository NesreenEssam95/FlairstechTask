package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utiles.ReadingCustomerDeatails;

public class loginPage {
	
	WebDriver browserobject;
	WebDriverWait wait;
	
	By userName_txt = By.name("username");
	By password_txt = By.name("password");
	By login_btn = By.xpath("//button[@type='submit']");
	
	
	
	public loginPage(WebDriver browserobject,WebDriverWait wait)
	{
		this.browserobject=browserobject;
		this.wait = wait;
		
	}
	
	public loginPage navigateTositeurl() throws IOException
	{
		String SiteUrl = ReadingCustomerDeatails.ReadingData(0,1);
		 browserobject.navigate().to(SiteUrl);
		 return this;
		 
	}
	
	public loginPage loginSuccessfully() throws InterruptedException, IOException
	{
		
		String userName = ReadingCustomerDeatails.ReadingData(1, 1);
		String password = ReadingCustomerDeatails.ReadingData(2, 1) ;

		wait.until(ExpectedConditions.visibilityOfElementLocated(userName_txt));
		WebElement userNaame =browserobject.findElement(userName_txt);      
		userNaame.sendKeys(userName); 
	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(password_txt));
		WebElement paasword =browserobject.findElement(password_txt); 
		paasword.sendKeys(password);
		
		browserobject.findElement(login_btn).click();
		
		return this;
		
	}
	
	

}
