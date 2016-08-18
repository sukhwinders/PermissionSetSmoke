package com.org.Example;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TP_Relationship_Create_Customer_admin_Responder {
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("CustomerAdminResponderUsername");
	String password1 = guitils.getPassword("CustomerAdminResponderPassword");
	//String Responder = guitils.getDATA("TPResponder");
	//String userName2 = guitils.getUserName("ResponderUsername");
	//String password2 = guitils.getPassword("ResponderPassword");
	String comment = guitils.getPassword("Comments");

	Date d = new Date(System.currentTimeMillis());
	String Reqname = "AutoTest" + d;

	String firstwindow;
	String secondwindow;
	WebElement tblAccounts;
	List<WebElement> RowsOfTable;
	WebElement ColOfTable;
	WebDriver driver;
	String baseUrl;
	String AccountName1 = "rajashekarbres02";
	//String AccountName2 = "Nagarjunaresorg2";

	@BeforeClass
	public void beforeClass() {
		/*baseUrl = "https://login.salesforce.com";
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();     
		//driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);*/
		driver = guitils.openBrowser(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TP_Relationship_On_Customer_admin_Requestor() throws Exception {
		guitils.loginToPortal(userName1, password1, driver);
		guitils.LightiningView(driver);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]"))
		.click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("ICIX")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(.,'Accounts')]")).click();
		Thread.sleep(1000);
		
// Create New TP Relationship			
		guitils.CreateRelationship(driver,AccountName1);
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
	}
}