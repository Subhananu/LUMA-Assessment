package com.qa.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.luma.utils.ElementUtil;

public class CheckoutPage {
	private WebDriver driver;
	private ElementUtil eleutil;
	
	//1. Private by locators:
	
	private By newAddressButton = By.xpath("//span[text()='New Address']");
	private By cartPageNextButton = By.xpath("//span[text()='Next']");
	private By tableRateRadioButton = By.xpath("//input[@name='ko_unique_1']");
	private By fixedRadioButton = By.xpath("//input[@name='ko_unique_2']");
	
	//Shipping address elements
	
	private By firstName = By.xpath("//input[@name=\"firstname\"]");
	private By lastName = By.xpath("//input[@name=\"lastname\"]");
	private By company = By.xpath("//input[@name=\"company\"]");
	private By StreetAddress1 = By.xpath("street[0]");
	private By StreetAddress2 = By.xpath("street[1]");
	private By StreetAddress3 = By.xpath("street[2]");
	private By city = By.xpath("city");
	private By stateProvinceDropdown = By.xpath("//select[@name=\"region_id\"]");
	private By postalCode = By.xpath("//input[@name=\"postcode\"]");
	private By countryDropdown = By.xpath("//select[@name=\"country_id\"]");
	private By telephoneNumber = By.xpath("//input[@name=\"telephone\"]");
	private By placeOrderButton = By.xpath("//span[text()='Place Order']");
	private By orderConfirmationMessage = By.xpath("//span[text()='Thank you for your purchase!']");
	private By orderNumber = By.xpath("//a[@class=\"order-number\"]/strong");
	private By continueShoppingButton = By.xpath("//span[text()='Continue Shopping']");
	
	
	//2. public page constructor
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}
	
	
	//3. public page actions:
	
	public void addShippingAddress() {
		
//		driver.findElement(By.xpath("//input[@name=\\\"firstname\\\"]")).sendKeys("banu");
		
		eleutil.doSendKeys(firstName, "banu");
		eleutil.doSendKeys(lastName, "as");
		eleutil.doSendKeys(company, "itc");
		eleutil.doSendKeys(StreetAddress1, "204-morocco");
		eleutil.doSendKeys(StreetAddress2, "casablanca");
		eleutil.doSendKeys(StreetAddress2, "47627-Europe");
		eleutil.doSendKeys(city, "helsenki");
		eleutil.doSelectByVisibleText(stateProvinceDropdown, "Colorado");
		eleutil.doSendKeys(postalCode, "4365709");
		eleutil.doSelectByVisibleText(countryDropdown, "United States");
		eleutil.doSendKeys(telephoneNumber, "9876545678");
		eleutil.doClick(tableRateRadioButton);
		eleutil.doClick(cartPageNextButton);
		eleutil.doClick(placeOrderButton);
	}
	
	public String orderConfirmationMessage() {
		String OCM = eleutil.doElementGetText(orderConfirmationMessage);
		return OCM;
		
	}
	

}
