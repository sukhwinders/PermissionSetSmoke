package com.org.Example;

import io.github.bonigarcia.wdm.ChromeDriverManager;

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

public class TPG_Compliance_View_Customer_Admin_Requestor {
	WebDriver driver;
	String baseUrl;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("CustomerAdminRequestorUsername");
	String password1 = guitils.getPassword("CustomerAdminRequestorPassword");
	String partner_name = guitils.getDATA("Partner_name");
	@BeforeClass
	public void beforeClass() {
		/*baseUrl = "https://login.salesforce.com";
		//driver = new FirefoxDriver();
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
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
	public void TPG_Compliance_View() throws Exception {
		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);
		driver.findElement(By.xpath("//a[contains(@alt,'App Launcher')]"))
		.click();
		driver.findElement(By.linkText("ICIX")).click();
		driver.findElement(
				By.xpath("//a[contains(.,'Trading Partner Group')]"))
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
			driver.findElement(By.xpath("//span[contains(.,'Related')]")).click();
			driver.findElement(By.xpath("//span[contains(.,'Trading Partner Group Requirements')]")).click();
			
			List<WebElement> Relations = driver.findElements(By.xpath("//table[@class='forceRecordLayout uiVirtualDataGrid--default uiVirtualDataGrid forceVirtualGrid']/tbody/tr"));
			if(Relations.size()>0){
			//	Relations.get(0).click();
			driver.findElement(By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div[5]/div/div[2]/div/div[3]/div/div/table/tbody/tr[1]/th/a")).click();

			//driver.findElement(By.xpath("//table[@class='forceRecordLayout uiVirtualDataGrid--default uiVirtualDataGrid forceVirtualGrid']/tbody/tr/th/a"))
			//	.click();
			System.out.println("Success: View TP Group Compliance Permissions");
			
			}
		else{
			System.out.println("Error:There is No Trading Partner Group Requirements to View");
		}

		 }
	}
}