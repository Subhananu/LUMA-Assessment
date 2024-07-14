package com.qa.luma.pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.luma.utils.ElementUtil;

public class MenTopsPage {
	private WebDriver driver;
	private ElementUtil eleutil;
	public String emailName;

	// 1. Private by locators:
	private By menMenuLink = By.xpath("//span[text()='Men']");
	private By topsLink = By
			.xpath("//li[@class=\"level0 nav-3 category-item level-top parent ui-menu-item\"]//span[text()=('Tops')]");
	private By jacketsLink = By.xpath(
			"//li[@class=\"level0 nav-3 category-item level-top parent ui-menu-item\"]//span[text()=('Jackets')]");
	private By bottomsLink = By.xpath(
			"//li[@class=\"level0 nav-3 category-item level-top parent ui-menu-item\"]//span[text()=('Bottoms')]");
	private By pantsLink = By
			.xpath("//li[@class=\"level0 nav-3 category-item level-top parent ui-menu-item\"]//span[text()=('Pants')]");

	private By jacketsProductList = By.xpath("//ol[@class=\"products list items product-items\"]/li//img");
	private By jacketSizeAndColor;

	private By orderList = By.xpath("//table[@id=\"my-orders-table\"]/tbody//strong");

	private By storeLogo = By.xpath("//a[@aria-label='store logo']");
	private By cartIcon = By.xpath("//span[@class='counter-number']");
	private By proceedToCartButton = By.id("top-cart-btn-checkout");
	private By orderSummaryExpand = By.xpath("//div[@class=\"title\"]");

	private By firstName = By.xpath("//div[@name=\"shippingAddress.firstname\"]//input[@name=\"firstname\"]");
	private By lastName = By.xpath("//input[@name=\"lastname\"]");
	private By company = By.xpath("//input[@name=\"company\"]");
	private By StreetAddress1 = By.xpath("//input[@name=\"street[0]\"]");
	private By StreetAddress2 = By.xpath("//input[@name=\"street[1]\"]");
	private By StreetAddress3 = By.xpath("//input[@name=\"street[2]\"]");
	private By city = By.xpath("//input[@name=\"city\"]");
	private By stateProvinceDropdown = By.xpath("//select[@name=\"region_id\"]");
	private By postalCode = By.xpath("//input[@name=\"postcode\"]");
	private By countryDropdown = By.xpath("//select[@name=\"country_id\"]");
	private By telephoneNumber = By.xpath("//input[@name=\"telephone\"]");
	private By placeOrderButton = By.xpath("//span[text()='Place Order']");
	private By orderConfirmationMessage = By.xpath("//span[text()='Thank you for your purchase!']");
	private By orderNumber = By.xpath("//a[@class=\"order-number\"]/strong");
	private By continueShoppingButton = By.xpath("//span[text()='Continue Shopping']");
	private By cartPageNextButton = By.xpath("//span[text()='Next']");
	private By tableRateRadioButton = By.xpath("//input[@name='ko_unique_1']");
	private By orderSummaryList = By.xpath("//ol[@class=\"minicart-items\"]/li");

	// Success page elements

	// 2. public page constructor
	public MenTopsPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);

	}

	// 3. public page actions:

	

	public String orderConfirmationMessage() {
		String OCM = eleutil.doElementGetText(orderConfirmationMessage);
		return OCM;

	}

	
	public void selectMenTops() throws InterruptedException {
		eleutil.selectSubMenu(menMenuLink, topsLink, jacketsLink);

	}

	public void clickOnOrderNumber() {
		eleutil.doClick(orderNumber);
	}

	public void actualProductsList(String jacketName, String size, String color) {
		List<WebElement> TotalOrderList = driver.findElements(orderList);

		for (WebElement o : TotalOrderList) {
			String orderedProductName = o.getText();
			System.out.println(orderedProductName);
		}

	}

	public void orderSummaryList() {
		List<WebElement> OrderSummaryList = driver.findElements(orderSummaryList);
		for (WebElement o : OrderSummaryList) {
			String orderedItemtName = o.getText();
			System.out.println(orderedItemtName);
		}
	}

	public void clickOnStoreLogo() {
		driver.findElement(storeLogo).click();
	}

	public void clickOnCartIcon() {
//		driver.findElement(cartIcon).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(cartIcon));

	}

	public CheckoutPage clickOnProceedToCardButton() {
//		eleutil.doClick(proceedToCartButton);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(proceedToCartButton));

//		eleutil.doClick(orderSummaryExpand);

		return new CheckoutPage(driver);
	}

	public void selectMenBottoms() throws InterruptedException {
		clickOnStoreLogo();
		eleutil.selectSubMenu(menMenuLink, bottomsLink, pantsLink);

	}

	public void totalProductsList(String jacketName, String size, String color) {
		List<WebElement> TotalJacketsList = driver.findElements(jacketsProductList);
		System.out.println(TotalJacketsList.size());
		for (WebElement e : TotalJacketsList) {
			String ProductName = e.getAttribute("alt");
			System.out.println(ProductName);
		}
//	createJacketSizeAndColorlocator(jacketName,size).click();
		WebElement jacektSizendolor = createJacketSizeAndColorlocator(jacketName, size);
		jacektSizendolor.click();

		createJacketColorlocator(jacketName, color).click();
		createJacketAddToCartlocator(jacketName).click();
	}

	public WebElement createJacketSizeAndColorlocator(String jacketName, String size) {

		return driver.findElement(By.xpath("//img[contains(@alt,'" + jacketName
				+ "')]//ancestor::div[@class='product-item-info']//div[@aria-label='" + size + "']"));

	}

	public WebElement createJacketColorlocator(String jacketName, String color) {

		return driver.findElement(By.xpath("//img[contains(@alt,'" + jacketName
				+ "')]//ancestor::div[@class='product-item-info']//div[@aria-label='" + color + "']"));

	}

	public WebElement createJacketAddToCartlocator(String jacketName) {

		return driver.findElement(By.xpath("//img[contains(@alt,'" + jacketName
				+ "')]//ancestor::div[@class='product-item-info']//button[@title='Add to Cart']"));

	}

	public void addShippingAddress() throws InterruptedException {

//	driver.findElement(By.xpath("//input[@name=\\\"firstname\\\"]")).sendKeys("banu");

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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartPageNextButton));
		eleutil.doClick(cartPageNextButton);
		Thread.sleep(20000);

		eleutil.doClick(placeOrderButton);
		Thread.sleep(10000);
	}

}
