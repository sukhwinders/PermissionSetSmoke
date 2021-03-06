package com.org.Example;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class Tags_Create_Customer_Admin_Requestor {
	@BeforeClass
	public void beforeClass() {
		/*baseUrl = "https://login.salesforce.com";
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
// Creating New Attribute
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("html/body/div[5]/div[3]/div[2]/div[2]/div/div[2]/form/section/div/div/section[1]/div[1]/div/div/input"))
			.sendKeys("Testing");
		
		driver.findElement(By.linkText("Attribute")).click();
		//driver.findElement(By.xpath("html/body/div[5]/div[3]/div[2]/div[2]/div/div[2]/form/section/div/div/section[1]/div[2]/div[1]/div/div/div/div/div/a")).click();
		driver.findElement(By.linkText("Tag")).click();
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		Thread.sleep(5000);
		System.out.println("Success: Create permissions");
 }
}
