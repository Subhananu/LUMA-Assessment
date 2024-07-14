package com.qa.luma.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.luma.base.BaseTest;
import com.qa.luma.utils.Constants;


public class LoginPageTest extends BaseTest{
	@BeforeClass
	public void loginPageSetup() {
		loginPage = homePage.signIn();
	}

	@Test
	public void loginPageTitleTest() {
		
		String actTitle = loginPage.getLoginPageTitle();
		System.out.println("page title : "+ actTitle);
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void loginPageUrlTest() {
		String url = loginPage.getLoginPageUrl();
		System.out.println("login page url :" + url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_FRACTION_URL));
	}
	
	
	@Test
	public void doLoginTest() {
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
}
