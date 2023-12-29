package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// Locators
	private By userName = By.name("username");
	private By password = By.name("password");
	private By loginBtn = By.xpath("//button[normalize-space()='Login']");

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Methods
	public void enterUserName(String un) {
		eleUtil.doSendKeys(userName, un);
	}

	public void enterPassword(String pwd) {
		eleUtil.doSendKeys(password, pwd);
	}

	public HomePage doClickLoginButton() {
		eleUtil.doClick(loginBtn);
		return new HomePage(driver);
	}

}
