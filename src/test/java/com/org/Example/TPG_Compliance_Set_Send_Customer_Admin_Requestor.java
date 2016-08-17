package com.org.Example;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;
public class TPG_Compliance_Set_Send_Customer_Admin_Requestor {
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
	public void TPG_Compliance_Set_then_Send() throws Exception {
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
				
// Set Requirement and Send TP Group Compliance
				
		driver.findElement(By.cssSelector("div[title='Set Requirements']")).click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		new Select(driver.findElement(By
				.id("RequestType0")))
				.selectByVisibleText("Incident");
		new Select(driver.findElement(By
				.id("DocType0")))
				.selectByVisibleText("Incident Report Form");
		driver.findElement(By.name("dateid")).click();
		driver.findElement(By
				.xpath("html/body/div[1]/div/div[2]/form/div[1]/div[4]/section/div/div/slds-datepicker/div/div[2]/table/tbody/tr[5]/td[4]/span"))
				.click();
		new Select(driver.findElement(By
				.id("RequirementType0")))
				.selectByVisibleText("Approval");
		driver.findElement(By.id("btnSend")).click();
		driver.findElement(By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand"))
			  .click();	
		System.out.println("Success: Set Requirements and Send TP Group Compliance");
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		 }
		else{
			
		}
	}
}
