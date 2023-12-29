package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.utils.ElementUtil;

public class HomePage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// Locators
	private By dashBoardHeading = By.xpath("//h6[text()='Dashboard']");
	private By userDrpDdown = By.xpath("//li[contains(@class,'userdropdown')]//i[contains(@class,'userdropdown')]");

	private By changePwdLink = By.xpath("//a[text()='Change Password']");
	private By currentPwdInput = By
			.xpath("//label[text()='Current Password']/parent::div/following-sibling::div/input");
	private By newPwdInput = By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input");
	private By cnfNewPwdInput = By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input");
	private By saveBtn = By.xpath("//button[@type='submit']");
	private By successMsg = By.xpath("//div[@id='oxd-toaster_1']");

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public void doClickUserDropDown() {
		eleUtil.doClick(userDrpDdown);
	}

	public void selectChangePwdOption() {
		eleUtil.doClick(changePwdLink);
	}

	public void enterCurrentPwd(String password) {
		eleUtil.doSendKeys(currentPwdInput, password);
	}

	public void enterNewPwd(String password) {
		eleUtil.doSendKeys(newPwdInput, password);
	}

	public void cnfNewPwd(String password) {
		eleUtil.doSendKeys(cnfNewPwdInput, password);
	}

	public void doClickSaveBtn() {
		eleUtil.doClick(saveBtn);
	}

	public boolean isDashBoardHeadingExist() {
		WebElement dashBoard = eleUtil.waitForElementVisible(dashBoardHeading, 10);
		return dashBoard.isDisplayed();
	}

	public boolean isSuccessMsgDisplayed() {
		WebElement msg = eleUtil.waitForElementVisible(successMsg, 10);
		System.out.println("success msg: " + msg.getText());
		return msg.isDisplayed();
	}

}
