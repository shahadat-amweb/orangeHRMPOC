package com.qa.orangehrm.stepdefinitions;

import org.testng.Assert;

import com.qa.orangehrm.factory.DriverFactory;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage;

	@Given("the user is on the login page of the application")
	public void the_user_is_on_the_login_page_of_the_application() {
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("the user logs in with the username {string} and password {string}")
	public void the_user_logs_in_with_the_username_and_password(String userName, String password) {
		loginPage.enterUserName("Admin");
		loginPage.enterPassword("admin123");
	}

	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
		 homePage = loginPage.doClickLoginButton();
	}

	@Then("the user is on the Home page")
	public void the_user_is_on_the_home_page() {
		boolean exist = homePage.isDashBoardHeadingExist();
		Assert.assertTrue(exist);
	}

	@When("the user clicks on the test user avatar dropdown at the top right corner")
	public void the_user_clicks_on_the_test_user_avatar_dropdown_at_the_top_right_corner() {
		homePage.doClickUserDropDown();
	}

	@When("selects the option to change password")
	public void selects_the_option_to_change_password() {
		homePage.selectChangePwdOption();

	}

	@When("enters the current password as {string}")
	public void enters_the_current_password_as(String pwd) {
		homePage.enterCurrentPwd(pwd);
	}

	@When("enters a new password as {string}")
	public void enters_a_new_password(String pwd) {
		homePage.enterNewPwd(pwd);
	}

	@When("confirms the new password as {string}")
	public void confirms_the_new_password(String pwd) {
		homePage.cnfNewPwd(pwd);
	}

	@When("the user clicks on the save button")
	public void the_user_clicks_on_the_save_button() {
		homePage.doClickSaveBtn();
	}

	@Then("a change password success popup should appear on the left corner of the page")
	public void a_change_password_success_popup_should_appear_on_the_left_corner_of_the_page() {
		boolean msg = homePage.isSuccessMsgDisplayed();
		Assert.assertTrue(msg);
	}

}
