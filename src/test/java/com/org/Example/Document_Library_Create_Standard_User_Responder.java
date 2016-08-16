package com.org.Example;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;

public class Document_Library_Create_Standard_User_Responder {
	WebDriver driver;
	String baseUrl;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("StandardUserResponderUsername");
	String password1 = guitils.getPassword("StandardUserResponderPassword");
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
		//driver.findElement(By.linkText("Document Library")).click();		
		//driver.findElement(By.xpath("//a[contains(.,'Document Library')]")).click();
		//driver.findElement(By.linkText("Document Library")).click();
		//driver.findElement(By.xpath("html/body/div[5]/div[1]/section/div[1]/div[1]/div/div/div[2]/div[2]/div[1]/ul/li[11]/a")).click();
		
		WebElement rateElement = driver.findElement(By.linkText("Document Library"));
		  ((JavascriptExecutor)driver).executeScript("arguments[0].click();",rateElement);
		
// View permissions  failed	on manual testing	
		
// Upload or Add a Document
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.findElement(By.id("btn_AddDocument")).click();
		//driver.findElement(By.xpath("//a[@id='browseLink']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(.,'browse')]")).click();
		Thread.sleep(5000);
		
		StringSelection sel = new StringSelection(
				System.getProperty("user.dir") + "\\test.txt\\");

		// Copy to file path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		System.out.println("selection" + sel);
		// Create object of Robot class
		Robot robot = new Robot();
		Thread.sleep(1000);

		// Press Enter to open
		robot.keyPress(KeyEvent.VK_ENTER);

		// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// Release CTRL+V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(3000);

		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(7000);

		driver.findElement(
				By.id("category"))
				.click();
		//driver.findElement(By.xpath("//a[contains(.,'Product Spec')]")).click();
		Select Containertypedropdown = new Select(
				driver.findElement(By.id("category")));

		Containertypedropdown.selectByVisibleText("Product Spec");
		
		driver.findElement(By.xpath("//span[@class='slds-checkbox--faux']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
		//driver.findElement(By.xpath("//button[@id='documentDialogSaveButton']")).click();
         driver.findElement(By.xpath("html/body/div[1]/div[6]/div[1]/div/div[3]/div/button[2]")).click();

		driver.findElement(By.id("uploadButton")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("btn_ShowMore1")).click();
		Thread.sleep(6000);
	}
}