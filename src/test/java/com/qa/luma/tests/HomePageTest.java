package com.qa.luma.tests;

import org.testng.annotations.Test;

import com.qa.luma.base.BaseTest;

public class HomePageTest extends BaseTest{
	
	@Test
	public void doSignInTest() {
		homePage.signIn();
	}
	

}
