package com.qa.luma.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.luma.factory.DriverFactory;
import com.qa.luma.pages.CheckoutPage;
import com.qa.luma.pages.HomePage;
import com.qa.luma.pages.LoginPage;
import com.qa.luma.pages.MenTopsPage;


//import com.qa.opencart.pages.InventoryPage;


public class BaseTest {
	
	public DriverFactory df;
	public WebDriver driver;
	public LoginPage loginPage;
	public Properties prop;
	public HomePage homePage;
	public MenTopsPage mentopspage;
	public CheckoutPage checkoutpage;

	
	@BeforeTest
	public void setup() throws InterruptedException {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
//		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
