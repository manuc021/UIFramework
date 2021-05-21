package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class PIMPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"firstName\"]")
	WebElement firstNameTextField;

	@FindBy(xpath = "//*[@id=\"middleName\"]")
	WebElement middleNameTextField;

	@FindBy(xpath = "//*[@id=\"lastName\"]")
	WebElement lastNameTextField;

	@FindBy(xpath = "//*[@id=\"employeeId\"]")
	WebElement employeeIdTextField;

	@FindBy(xpath = "//*[@id=\"btnSave\"]")
	WebElement saveButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[1]/h1")
	WebElement addEmployeeLabel;

	public PIMPage() {

		PageFactory.initElements(driver, this);
	}

	
	
	public void addEmployee(String fName , String mName ,String lName,String empId) throws InterruptedException {
		Thread.sleep(2000);
		firstNameTextField.sendKeys(fName);
		middleNameTextField.sendKeys(mName);
		lastNameTextField.sendKeys(lName);
		employeeIdTextField.clear();
		employeeIdTextField.sendKeys(empId);
		saveButton.click();
	}
}
