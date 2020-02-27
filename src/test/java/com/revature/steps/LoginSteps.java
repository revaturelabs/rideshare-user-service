package com.revature.steps;

import org.openqa.selenium.WebDriver;

import com.revature.pages.Homepage;
import com.revature.runners.Runner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	public static WebDriver driver= Runner.driver;
	public static Homepage homepage = Runner.homepage;
			

	@Given("^The user is on the Rideshare homepage$")
	public void the_user_is_on_the_Rideshare_homepage() throws Throwable {
		driver.get("localhost:4200");
	}

	@When("^The user clicks on Login$")
	public void the_user_clicks_on_Login() throws Throwable {
		homepage.loginBtn.click();
	}

	@When("^The user types in username$")
	public void the_user_types_in_username() throws Throwable {
		homepage.userNameInputBox.sendKeys("Speed");
	}

	@When("^The user types in password$")
	public void the_user_types_in_password() throws Throwable {
		homepage.loginPasswordTextbox.sendKeys("Racer");
	}

	@When("^The user clicks on Login Button$")
	public void the_user_clicks_on_Login_Button() throws Throwable {
		homepage.loginSubmitBtn.click();
	}

	@Then("^The user should be on the Landing page$")
	public void the_user_should_be_on_the_Landing_page() throws Throwable {
		assert(driver.getCurrentUrl() == "localhost:4200/landingPage");
	}
}