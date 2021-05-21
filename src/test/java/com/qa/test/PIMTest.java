package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.PIMPage;
import com.qa.utils.TestUtil;

public class PIMTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PIMPage pimPage;
	String sheetName = "Employee";

	public PIMTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		pimPage = new PIMPage();
	}

	@DataProvider
	public Object[][] getEmpTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getEmpTestData")
	public void addEmployee(String fName, String lName, String mName, String empId) {
		homePage.clickOnPIMMenu();
		try {
			pimPage.addEmployee(fName, mName, lName, empId);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
