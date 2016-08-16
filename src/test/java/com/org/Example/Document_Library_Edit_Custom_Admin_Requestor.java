package com.org.Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class Document_Library_Edit_Custom_Admin_Requestor {
	WebDriver driver;
	String baseUrl;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("CustomerAdminRequestorUsername");
	String password1 = guitils.getPassword("CustomerAdminRequestorPassword");
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

		//  List<WebElement> Docs = driver.findElements(By.xpath("//table[@class='slds-table slds-table--bordered']/tbody/tr"));
		//	if(Docs.size()>0){
			//	Docs.get(0).click();
			//driver.findElement(By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div[5]/div/div[2]/div/div[3]/div/div/table/tbody/tr[1]/th/a")).click();

			driver.findElement(By.xpath("//table[@class='forceRecordLayout uiVirtualDataGrid--default uiVirtualDataGrid forceVirtualGrid']/tbody/tr/th/a"))
				.click();
			
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Edited");
			driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
			driver.findElement(By.id("editDialogSaveButton")).click();
			System.out.println("Success:Document Edit Permissions");
			
		//	}
	//	else{
			System.out.println("Error:There is No Documents to Edit");
		//}	
	}
}
