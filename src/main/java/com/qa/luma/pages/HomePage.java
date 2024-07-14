package com.qa.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.luma.utils.ElementUtil;






public class HomePage {

	private WebDriver driver;
	private ElementUtil eleutil;
	
	//1. Private by locators:
	
	private By signin = By.xpath("//div[@class=\"panel wrapper\"]//a[contains(text(),'Sign In')]");
	private By createAnAccount = By.xpath("(//a[text()=('Create an Account')])[1]");
	
	
	
	//2. public page constructor
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
		
	}
	
	//3. public page actions:
	
	public LoginPage signIn() {
		driver.findElement(signin).click();
		return new LoginPage(driver);
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String getLoginPageUrl() {
//		eleutil.waitForUrl(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_FRACTION_URL);
		return driver.getCurrentUrl();
	}
	
	public LoginPage clickCreateAnAccountLink()
	{
		eleutil.doClick(createAnAccount);
		return new LoginPage(driver);
	}
	
	
	
}
