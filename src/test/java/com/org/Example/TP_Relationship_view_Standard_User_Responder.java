package com.org.Example;

import java.util.Date;
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

public class TP_Relationship_view_Standard_User_Responder {
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("StandardUserResponderUsername");
	String password1 = guitils.getPassword("StandardUserResponderPassword");
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
		baseUrl = "https://login.salesforce.com";
		//String Path = guitils.getProperties("Chrome_Driver_Path");
		//System.setProperty("webdriver.chrome.driver", Path+"chromedriver.exe");
		//driver = new ChromeDriver();      
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

		driver.findElement(By.cssSelector("div.triggerLinkTextAndIconWrapper")).click();	
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".slds-dropdown__item.has-icon--left.forceListViewPickerAutocompleteOption > a")).click();
		Thread.sleep(2000);
		
		List<WebElement> listInputs =  driver.findElements(By.cssSelector("th a.outputLookupLink.forceOutputLookup"));
		
		if(listInputs.size()>0)
		 {
			listInputs.get(0).click();
		 
		
// View TP Relationship	   
		driver.findElement(By.xpath("//span[contains(.,'Related')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(.,'Trading Partner Relationships')]")).click();
		Thread.sleep(3000);
		
		List<WebElement> Relations = driver.findElements(By.xpath("//table[@class='forceRecordLayout uiVirtualDataGrid--default uiVirtualDataGrid forceVirtualGrid']/tbody/tr"));
		if(Relations.size()>0){
		
		//	Relations.get(0).click();
		driver.findElement(By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div[5]/div/div[2]/div/div[3]/div/div/table/tbody/tr[1]/th/a")).click();
		
		}
	
	
		else{
			System.out.println("This User Don't have view permissions");
		}
	 }
		else
		 {
			 Assert.assertEquals(0, 1);
		 }

	}
}