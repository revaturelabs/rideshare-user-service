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
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^The user clicks on Login$")
	public void the_user_clicks_on_Login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^The user types in username$")
	public void the_user_types_in_username() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^The user types in password$")
	public void the_user_types_in_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^The user clicks on Login Button$")
	public void the_user_clicks_on_Login_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^The user should be on the Landing page$")
	public void the_user_should_be_on_the_Landing_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
