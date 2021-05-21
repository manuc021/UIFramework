package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		initialization();

		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void validatePageTitle() {
		String actualTitle = loginPage.validatePageTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@Test(priority = 2)
	public void validateUserName() {
		boolean uNameLable = homePage.verifyUserName();
		Assert.assertTrue(uNameLable);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
