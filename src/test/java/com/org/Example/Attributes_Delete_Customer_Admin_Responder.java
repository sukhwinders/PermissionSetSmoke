package com.org.Example;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class Attributes_Delete_Customer_Admin_Responder {
	@BeforeClass
	public void beforeClass() {
	/*	baseUrl = "https://login.salesforce.com";
		//driver = new FirefoxDriver();
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);*/
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	WebDriver driver;
	String baseUrl;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("CustomerAdminResponderUsername");
	String password1 = guitils.getPassword("CustomerAdminResponderPassword");
	String Icixid = guitils.getDATA("icixid");

	@Test
	public void Customer_Admin_Responder_On_Attributes() throws Exception {
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
			String value = driver.findElement(By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div[4]/div/div[2]/div[1]/div/div[2]/div/div[3]/div/div/table/tbody/tr[1]/td[1]/span")).getText();
			if(value.equals("Attributes")){
			listInputs.get(0).click();
			}
			else{
				driver.findElement(By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div[4]/div/div[2]/div[1]/div/div[2]/div/div[3]/div/div/table/thead/tr/th[2]/div/span/span/a")).click();
				Thread.sleep(3000);
				//listInputs.get(0).click();
				driver.findElement(By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div[4]/div/div[2]/div[1]/div/div[2]/div/div[3]/div/div/table/tbody/tr[1]/th/a")).click();
			}
			// Delete Attributes
			driver.findElement(By.xpath("//div[contains(@title,'Delete')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(.,'Delete')]")).click();
			System.out.println("Success: Delete permissions");
			
		 }
		 else
		 {
			 Assert.assertEquals(0, 1);
		 }
 }
}