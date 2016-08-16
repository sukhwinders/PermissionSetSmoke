package com.org.Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Data_loading;


public class TestTPGroupEditCAResponder {

	WebDriver driver;
	String baseUrl;

	Data_loading guitils = new Data_loading();
	String userName1 = guitils.getUserName("CustomerAdminResponderUsername");
	String password1 = guitils.getPassword("CustomerAdminResponderPassword");
	
	@BeforeClass
	public void beforeClass() {
		baseUrl = "https://login.salesforce.com";
		//driver = new FirefoxDriver();
		String Path = guitils.getProperties("Chrome_Driver_Path");
		System.setProperty("webdriver.chrome.driver", Path+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
	
	@Test
	public void EditTPGroup() throws Exception {
		guitils.loginToPortal(userName1, password1, driver);
		Thread.sleep(5000);
		guitils.LightiningView(driver);		
		Thread.sleep(3000);
		
		//guitils.DeleteTPGroup(driver);
		//guitils.CreateTPGroup(driver);
		//guitils.VerifyViewTPGroup(driver);
		guitils.VerifyEditTPGroup(driver);
		
	
	}
}

