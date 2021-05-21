package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	/*
	 * @FindBy(xpath = "//*[@id=\"navbarDropdown-11\"]") WebElement login;
	 * 
	 * @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul[2]/li[3]/div/a[1]")
	 * WebElement loginTextField;
	 */

	@FindBy(xpath = "//*[@id=\"txtUsername\"]")
	WebElement emailTextField;

	@FindBy(xpath = "//*[@id=\"txtPassword\"]")
	WebElement passwordTextField;

	@FindBy(xpath = "//*[@id=\"logInPanelHeading\"]")
	WebElement loginPanelText;

	@FindBy(xpath = "//*[@id=\"btnLogin\"]")
	WebElement submitButton;

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public String validatePageTitle() {

		return driver.getTitle();
	}

	public boolean validateLogo() {

		return loginPanelText.isDisplayed();
	}

	public HomePage login(String un, String pwd) {

		emailTextField.sendKeys(un);
		passwordTextField.sendKeys(pwd);
		submitButton.click();
		return new HomePage();
	}

}
