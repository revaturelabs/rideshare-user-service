package com.revature.steps;

import org.openqa.selenium.WebDriver;

import com.revature.pages.Homepage;
import com.revature.runners.Runner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserLogout {
	public static WebDriver driver= Runner.driver;
	public static Homepage homepage = Runner.homepage;
	
	@Given("^the user is logged in$")
	public void the_user_is_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the user clicks on their profile pic$")
	public void the_user_clicks_on_their_profile_pic() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the user clicks Log Out from drop down$")
	public void the_user_clicks_Log_Out_from_drop_down() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the user will be logged out$")
	public void the_user_will_be_logged_out() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}
