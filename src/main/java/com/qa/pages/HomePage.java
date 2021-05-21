package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(id = "menu_leave_viewLeaveModule")
	WebElement leaveMenu;

	@FindBy(id = "menu_time_viewTimeModule")
	WebElement timeMenu;

	@FindBy(id = "menu_pim_viewMyDetails")
	WebElement myInfoMenu;

	@FindBy(id = "menu__Performance")
	WebElement performanceMenu;

	@FindBy(id = "menu_pim_viewPimModule")
	WebElement pimMenu;

	@FindBy(id = "welcome")
	WebElement userNameLabel;
	
	@FindBy(id= "menu_pim_addEmployee")
	WebElement addEmployee;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validatePageTitle() {

		return driver.getTitle();
	}

	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}

	public LeaveMenuPage clickOnLeaveMenu() {
		leaveMenu.click();
		return new LeaveMenuPage();
	}

	public TimeMenuPage clickOnTimeMenu() {
		timeMenu.click();
		return new TimeMenuPage();
	}

	public PIMPage clickOnPIMMenu() {
		Actions action = new Actions(driver);
		action.moveToElement(pimMenu).build().perform();
		addEmployee.click();
		return new PIMPage();
	}

}
