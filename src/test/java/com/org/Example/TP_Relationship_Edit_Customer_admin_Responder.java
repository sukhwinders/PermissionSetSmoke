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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class TP_Relationship_Edit_Customer_admin_Responder {
	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("CustomerAdminRequestorUsername");
	String password1 = guitils.getPassword("CustomerAdminRequestorPassword");
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
		
		
// Edit TP Relationship	   
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
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//div[contains(@title,'Edit')]")).click();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		Thread.sleep(3000);
		driver.findElement(By.id("txt_UURelationship_Name")).sendKeys("Edited");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#btn_UPRelationship_Save")).click();
		driver.findElement(By.xpath("//message-dialog/div[2]/div/div/div[3]/button")).click();
		
		System.out.println("Success: View permissions");
		
	 }
		 else
		 {
			 Assert.assertEquals(0, 1);
		 }
	}
}
