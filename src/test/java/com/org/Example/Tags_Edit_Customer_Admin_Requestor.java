package com.org.Example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class Tags_Edit_Customer_Admin_Requestor {
	@BeforeClass
	public void beforeClass() {
		baseUrl = "https://login.salesforce.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
	WebDriver driver;
	String baseUrl;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("CustomerAdminRequestorUsername");
	String password1 = guitils.getPassword("CustomerAdminRequestorPassword");
	String Icixid = guitils.getDATA("icixid");

	@Test
	public void Customer_Admin_Requestor_On_Tags() throws Exception {
		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]"))
		.click();
		Thread.sleep(3000);	
		driver.findElement(By.linkText("Other Items")).click();
		driver.findElement(
				By.xpath("//a[contains(text(),'Attributes')]"))
				.click();
		Thread.sleep(3000);	
		driver.findElement(By.cssSelector("div.triggerLinkTextAndIconWrapper")).click();	
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".slds-dropdown__item.has-icon--left.forceListViewPickerAutocompleteOption > a")).click();
		Thread.sleep(2000);
		
		List<WebElement> listInputs =  driver.findElements(By.cssSelector("th a.outputLookupLink.forceOutputLookup"));
		
		
		if(listInputs.size()>0)
		 {
			listInputs.get(0).click();
			// Edit Attribute 		
			driver.findElement(By.xpath("//div[contains(@title,'Edit')]")).click();
			driver.findElement(By.xpath("html/body/div[5]/div[3]/div[2]/div[2]/div/div[2]/form/section/div/div/section[1]/div[1]/div/div/input"))
				.sendKeys(".Edited");
			Thread.sleep(5000);
			//driver.findElement(By.xpath("//button[@title='Save']")).click();
			//driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
			driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']"))
				.click();
			
			Thread.sleep(5000);
			System.out.println("Success: Edit permissions");
			
		 }
		 else
		 {
			 Assert.assertEquals(0, 1);
		 }
 }
}