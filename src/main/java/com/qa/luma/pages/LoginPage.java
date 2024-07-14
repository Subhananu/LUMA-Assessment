package com.qa.luma.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.luma.utils.ElementUtil;
//import com.qa.opencart.pages.InventoryPage;




public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleutil;
	public String emailName;
	//1. Private by locators:
	
	private By emailId = By.id("email");
	private By password = By.id("pass");
	private By signinBtn = By.id("send2");
	private By forgotpwd = By.xpath("//a[@class=\"action remind\"]//span[contains(text(),'Forgot Your Password?')]");
	
	// User account creation parameters
	
		private By createFirstName = By.xpath("//input[@id=\"firstname\"]");
		private By createLasttName = By.xpath("//input[@id=\"lastname\"]");
		private By createEmailName = By.xpath("//input[@id=\"email_address\"]");
		private By createPassword = By.xpath("//input[@id=\"password\"]");
		private By createPasswordConfirmation = By.xpath("//input[@id=\"password-confirmation\"]");
		private By createAnAccount = By.xpath("//button[@title=\"Create an Account\"]");
	
	
	
	//2. public page constructor
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
		
	}
	
	//3. public page actions:
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String getLoginPageUrl() {
//		eleutil.waitForUrl(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_FRACTION_URL);
		return driver.getCurrentUrl();
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotpwd).isDisplayed();
		
	}
	
	public MenTopsPage doLogin(String un, String pwd) {
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		
		driver.findElement(signinBtn).click();
		return new MenTopsPage(driver);
	}
	
	public void randomEmailCreation() {
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000); 
	 emailName =  "username"+ randomInt +"@gmail.com";
		eleutil.doSendKeys(createEmailName, emailName);
	}
	
	public void accountCreation() {
		eleutil.doSendKeys(createFirstName, "Test");
		eleutil.doSendKeys(createLasttName, "130724");
		randomEmailCreation();
		eleutil.doSendKeys(createPassword, "Test@123");
		eleutil.doSendKeys(createPasswordConfirmation, "Test@123");
		eleutil.doClick(createAnAccount);
	}
}
