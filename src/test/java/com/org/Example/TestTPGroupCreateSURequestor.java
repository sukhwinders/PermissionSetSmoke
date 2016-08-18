
package com.org.Example;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;


public class TestTPGroupCreateSURequestor {

	WebDriver driver;
	String baseUrl;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("StandardUserRequestorUsername");
	String password1 = guitils.getPassword("StandardUserRequestorPassword");
	
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
	public void CreateTPGroup() throws Exception {
		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);		
		Thread.sleep(3000);
		
		//guitils.DeleteTPGroup(driver);
		guitils.CreateTPGroup(driver);
		//guitils.VerifyViewTPGroup(driver);
		//guitils.VerifyEditTPGroup(driver);
		
	
	}
}

