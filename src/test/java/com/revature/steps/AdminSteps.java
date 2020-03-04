package com.revature.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.revature.pages.Homepage;
import com.revature.runners.Runner;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminSteps {
	
	public static WebDriver driver = Runner.driver;
	public static Homepage homepage = Runner.homepage;
	
	

@Given("^The user is on the home page$")
public void the_user_is_on_the_home_page() throws Throwable {
	
}

@When("^The user clicks on the login button$")
public void the_user_clicks_on_the_login_button() throws Throwable {
	homepage.loginBtn.click();
}

@When("^The user types in the username$")
public void the_user_types_in_the_username() throws Throwable {
	homepage.usernameInput.sendKeys("oof");
}

@When("^The user types in the password$")
public void the_user_types_in_the_password() throws Throwable {
	 homepage.passwordInput.sendKeys("oofoof");
}


@When("^The user clicks on the submit button$")
public void the_user_clicks_on_the_submit_button() throws Throwable {
	homepage.submitBtn.click();
}

@Then("^The user will be on the Admin Page$")
public void the_user_will_be_on_the_Admin_Page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^The user clicks on the contact button$")
public void the_user_clicks_on_the_contact_button() throws Throwable {
	homepage.contactEditBtn.click();
}

@When("^The user types in phone number$")
public void the_user_types_in_phone_number() throws Throwable {
	homepage.contactPhoneInput.sendKeys("555-555-5555");
}

@When("^The user clicks on save$")
public void the_user_clicks_on_save() throws Throwable {
	homepage.contactUpdateBtn.click();
}

@Then("^The user should still be on the Profile Page$")
public void the_user_should_still_be_on_the_Profile_Page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^The user clicks on the Delete button$")
public void the_user_clicks_on_the_Delete_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^The user is on the Edit employee page$")
public void the_user_is_on_the_Edit_employee_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^The user clicks on the Promote button$")
public void the_user_clicks_on_the_Promote_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

	
	

}
