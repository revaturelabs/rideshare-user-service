package com.revature.steps;

import org.openqa.selenium.WebDriver;

import com.revature.pages.Homepage;
import com.revature.runners.Runner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class DriverSteps {
	public static WebDriver driver = Runner.driver;
	public static Homepage homepage = Runner.homepage;

	@Given("The user is on the homepage")
	public void the_user_is_on_the_homepage() {
		driver.get("http://rideshare.com.s3-website.us-east-2.amazonaws.com/");
	}

	@When("The user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
	    homepage.loginBtn.click();
	}

	@When("The user types in the username")
	public void the_user_types_in_the_username() {
	    homepage.usernameInput.sendKeys("JKittens");
	}

	@When("The user types in the password")
	public void the_user_types_in_the_password() {
		homepage.passwordInput.sendKeys("catsahoy");
	}

	@When("The user clicks log in")
	public void the_user_clicks_log_in() {
		homepage.submitBtn.click();
	}

	//NEEDS A TITLE!!!!!
	@Then("The user should be on the Profile page")
	public void the_user_should_be_on_the_Profile_page() {
	    Assert.assertEquals("", driver.getTitle());
	}

	
	@Given("The user is on the Profile page")
	public void the_user_is_on_the_Profile_page() {
	    // was just checked
	}

	@When("The user clicks the contact button")
	public void the_user_clicks_the_contact_button() {
	    homepage.contactEditBtn.click();
	}

	@When("The user types in the first name")
	public void the_user_types_in_the_first_name() {
	    homepage.contactFNameInput.sendKeys("Yogi");
	}

	@When("The user types in the last name")
	public void the_user_types_in_the_last_name() {
	    homepage.contactLNameInput.sendKeys("Bear");
	}

	@When("The user types in the email")
	public void the_user_types_in_the_email() {
	    homepage.contactEmailInput.sendKeys("jellystone@gmail.com");
	}

	@When("The user types in the phone number")
	public void the_user_types_in_the_phone_number() {
	    homepage.contactPhoneInput.sendKeys("500-909-8483");
	}

	@When("The user types in the username")
	public void the_user_types_in_the_updated_username() {
	    homepage.contactUserInput.sendKeys("booboo");
	}

	@When("The user types in the password")
	public void the_user_types_in_the_updated_password() {
	    homepage.contactPassInput.sendKeys("isBestBoi");
	}

	@When("The user types in the address")
	public void the_user_types_in_the_address() {
	   homepage.contactAddressInput.sendKeys("112 Statepark Lane JellyStone, National Park 80000");
	}

	@When("The user clicks the driver checkbox")
	public void the_user_clicks_the_driver_checkbox() {
	    homepage.driverCheckBox.click();
	}

	@When("The user clicks the active checkbox")
	public void the_user_clicks_the_active_checkbox() {
	    homepage.activeCheckBox.click();
	}

	@When("The user clicks the update button")
	public void the_user_clicks_the_update_button() {
	    homepage.contactUpdateBtn.click();
	}


	@When("The user clicks the location button")
	public void the_user_clicks_the_location_button() {
	    homepage.locationEditBtn.click();
	}
	

	@When("The user clicks on the office dropdown button")
	public void the_user_clicks_on_the_office_dropdown_button() {
	    homepage.locationOfficeSelect.click();
	}

	///NEED ID FOR OPTION
	@When("The user clicks on an office")
	public void the_user_clicks_on_an_office() {
	    homepage.locationCityOption.click();
	}


	@When("The user clicks on the city dropdown button")
	public void the_user_clicks_on_the_city_dropdown_button() {
	    homepage.locationCitySelect.click();
	}
	
	@When("The user clicks on a city")
	public void the_user_clicks_on_a_city() {
	    homepage.locationCityOption.click();
	}

	@When("The user clicks on the car button")
	public void the_user_clicks_on_the_car_button() {
	    homepage.carEditBtn.click();
	}

	@When("The user types in the make")
	public void the_user_types_in_the_make() {
		homepage.carMakeInput.sendKeys("Ford");
	}

	@When("The user types in the model")
	public void the_user_types_in_the_model() {
	    homepage.carModelInput.sendKeys("Focus");;
	}

	@When("The user types in the year")
	public void the_user_types_in_the_year() {
	    homepage.carYearInput.sendKeys("2020");
	}

	@When("The user types in the colour")
	public void the_user_types_in_the_colour() {
	    homepage.carColourInput.sendKeys("yellow");
	}

	@When("The user clicks on the seats dropdown button")
	public void the_user_clicks_on_the_seats_dropdown_button() {
	    homepage.seatSelect.click();
	}

	@When("The user clicks on the number of seats")
	public void the_user_clicks_on_the_number_of_seats() {
	    homepage.seatOption.click();
	}

	@When("The user clicks on the update button")
	public void the_user_clicks_on_the_update_button() {
	    homepage.carUpdateBtn.click();
	}

	


}
