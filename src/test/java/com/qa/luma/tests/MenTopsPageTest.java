package com.qa.luma.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.luma.base.BaseTest;

public class MenTopsPageTest extends BaseTest {

	@BeforeClass
	public void loginPageSetup() {
		loginPage = homePage.signIn();

		mentopspage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
//		

	}

	@Test
	public void clickOnTops() throws InterruptedException {
		List<String> orderingList = new ArrayList<>();
		orderingList.add("Proteus Fitness Jackshirt");
		orderingList.add("Montana Wind Jacket");
		orderingList.add("Aether Gym Pant");
		mentopspage.selectMenTops();
		mentopspage.totalProductsList("Proteus Fitness Jackshirt", "XL", "Orange");
		mentopspage.totalProductsList("Montana Wind Jacket", "XS", "Red");
		Thread.sleep(3000);
		mentopspage.selectMenBottoms();
		mentopspage.totalProductsList("Aether Gym Pant", "33", "Green");
		Thread.sleep(3000);
		mentopspage.clickOnCartIcon();
		mentopspage.clickOnProceedToCardButton();
		Thread.sleep(20000);

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATOR_ABOUT_HEADER));
		mentopspage.addShippingAddress();
		String str = mentopspage.orderConfirmationMessage();

		Assert.assertEquals(str, "Thank you for your purchase!");
		mentopspage.clickOnOrderNumber();

	}

}
