package com.org.Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class Document_Library_Edit_Standard_User_Requestor {
	WebDriver driver;
	String baseUrl;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("StandardUserRequestorUsername");
	String password1 = guitils.getPassword("StandardUserRequestorPassword");
	String partner_name = guitils.getDATA("DOcumentreciver");
	@BeforeClass
	public void beforeClass() {
		baseUrl = "https://login.salesforce.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

	@Test
	public void Document_Library_Create() throws Exception {
			
		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]"))
		.click();
		Thread.sleep(3000);	
		driver.findElement(By.linkText("Other Items")).click();
		Thread.sleep(3000);
		WebElement rateElement = driver.findElement(By.linkText("Document Library"));
		  ((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);

// Search document to edit
			driver.findElement(By.id("84:2;a")).sendKeys("Test file");
			Thread.sleep(3000);
			WebElement webElement = driver.findElement(By.id("84:2;a"));
			webElement.sendKeys(Keys.TAB);
			Thread.sleep(3000);
			webElement.sendKeys(Keys.ENTER);
			Thread.sleep(3000);	
			driver.findElement(By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div[5]/div[2]/div[2]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/a"))
							.click();
			Thread.sleep(5000);
//Edit documents 		  

				driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Edited");
				driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
				driver.findElement(By.id("editDialogSaveButton")).click();
				
				System.out.println("Success: View permissions");
				
		
	}
}
