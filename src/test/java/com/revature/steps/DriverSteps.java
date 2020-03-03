package com.revature.steps;

import org.openqa.selenium.WebDriver;

import com.revature.pages.Homepage;
import com.revature.runners.Runner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DriverSteps {
	public static WebDriver driver = Runner.driver;
	public static Homepage homepage = Runner.homepage;

	@Given("The user is on the homepage")
	public void the_user_is_on_the_homepage() {
		driver.get("http://rideshare.com.s3-website.us-east-2.amazonaws.com/");
	}

	@When("The user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The user types in the username")
	public void the_user_types_in_the_username() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The user types in the password")
	public void the_user_types_in_the_password() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("The user clicks log in")
	public void the_user_clicks_log_in() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("The user should be on the landing page")
	public void the_user_should_be_on_the_landing_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
