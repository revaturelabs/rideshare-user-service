package com.revature.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.revature.pages.Homepage;
import com.revature.runners.Runner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RiderSteps {
	public static WebDriver driver = Runner.driver;
	public static Homepage homepage = Runner.homepage;

	@Given("The new rider is on the homepage")
	public void the_new_rider_is_on_the_homepage() {
		driver.get("http://localhost:4200/");
	}

	@When("The rider clicks on the register button")
	public void the_rider_clicks_on_the_register_button() {
		homepage.signupBtn.click();
	}

	@When("The rider types in the first name")
	public void the_rider_types_in_the_first_name() {
		homepage.registerFNameInput.sendKeys("Speed");
	}

	@When("The rider types in the last name")
	public void the_rider_types_in_the_last_name() {
		homepage.registerLastNameInput.sendKeys("Racer");
	}

	@When("The rider types in the email")
	public void the_rider_types_in_the_email() {
		homepage.registerEmailInput.sendKeys("sr@speed.com");
	}

	@When("The rider types in the phone number")
	public void the_rider_types_in_the_phone_number() {
		homepage.registerPhoneInput.sendKeys("5554443333");
	}

	@When("The rider types in the username")
	public void the_rider_types_in_the_username() {
		homepage.registerUsernameInput.sendKeys("SpeedRacer");
	}

	@When("The rider types in the password")
	public void the_rider_types_in_the_password() {
		homepage.registerPassInput.sendKeys("herehegoes");
	}

	@When("The rider types in the street")
	public void the_rider_types_in_the_street() {
		homepage.registerStreetInput.sendKeys("123 Jump Street");
	}

	@When("The rider types in the city")
	public void the_rider_types_in_the_city() {
		homepage.registerCityInput.sendKeys("Townsville");
	}

	@When("The rider types in the state")
	public void the_rider_types_in_the_state() {
		homepage.registerStateInput.sendKeys("WV");
	}

	@When("The rider types in the zip code")
	public void the_rider_types_in_the_zip_code() {
		homepage.registerZipInput.sendKeys("12345");
	}

	@When("The rider types in the office")
	public void the_rider_types_in_the_office() {
		// Need to modify office input to a dropdown
	}

	@When("The rider clicks the submit button")
	public void the_rider_clicks_the_submit_button() {
		homepage.registerSubmitBtn.click();
	}

	@Then("It should say registration successful")
	public void it_should_say_registration_successful() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("The registered rider is on the homepage")
	public void the_registered_rider_is_on_the_homepage() {
		driver.get("http://localhost:4200/");
	}

	@When("The rider clicks on the login button")
	public void the_rider_clicks_on_the_login_button() {
		homepage.loginBtn.click();
	}

	@When("The rider enters in their username")
	public void the_rider_enters_in_their_username() {
		homepage.usernameInput.sendKeys("SpeedRacer");
	}

	@When("The rider enters in their password")
	public void the_rider_enters_in_their_password() {
		homepage.passwordInput.sendKeys("herehegoes");
	}

	@When("The rider clicks log in")
	public void the_rider_clicks_log_in() {
		homepage.submitBtn.click();
	}

	@Then("The rider should be on the Show Driver page")
	public void the_rider_should_be_on_the_Show_Driver_page() {
		assertEquals(driver.getTitle(), "Show Driver - Rideshare");
	}
}
