package com.revature.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.revature.pages.Homepage;
import com.revature.runners.Runner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DriverRegisterSteps {
	public static WebDriver driver= Runner.driver;
	public static Homepage homepage = Runner.homepage;
			

@When("^The user clicks on Sign up$")
public void the_user_clicks_on_Sign_up() throws Throwable {
   homepage.signupBtn.click();
}


@When("^The user types in firstname$")
public void the_user_types_in_firstname() throws Throwable {
  driver.findElement(By.id("firstname")).sendKeys("oof");
}

@When("^The user types in lastname$")
public void the_user_types_in_lastname() throws Throwable {
	  driver.findElement(By.id("lastname")).sendKeys("oofoof");
}

@When("^The user types in email$")
public void the_user_types_in_email() throws Throwable {
	  driver.findElement(By.id("email")).sendKeys("oofoof@gmail.com");
}

@When("^The user types in phone$")
public void the_user_types_in_phone() throws Throwable {
	  driver.findElement(By.id("phoneNumber")).sendKeys("0004444444");
}

@When("^The user click on batch$")
public void the_user_click_on_batch() throws Throwable {
   driver.findElement(By.xpath("/html/body/modal-container/div/div/div[2]/select[1]"));
}

// I dont think we need this one until we get ids 
@When("^The user click on Morgantown$")
public void the_user_click_on_Morgantown() throws Throwable {
  
}

@When("^The user types in Adress$")
public void the_user_types_in_Adress() throws Throwable {
 driver.findElement(By.id("hAddress")).sendKeys("500 Koehler Dr");
}

@When("^The user types in City$")
public void the_user_types_in_City() throws Throwable {
	 driver.findElement(By.id("hAddress")).sendKeys("Morgantown");
}

@When("^The user clicks on State$")
public void the_user_clicks_on_State() throws Throwable {
driver.findElement(By.cssSelector("#option[value='WV']"));
}

// wont need this until we have more ids 
@When("^The user clicks on wv$")
public void the_user_clicks_on_wv() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^The user types in ZipCode$")
public void the_user_types_in_ZipCode() throws Throwable {
 driver.findElement(By.xpath("//input[contains(.,'Zip Code')]")).sendKeys("26508");
}

@When("^The user clicks on Rider$")
public void the_user_clicks_on_Rider() throws Throwable {
driver.findElement(By.id("driver")).click();
}

@When("^The user clicks on Submit$")
public void the_user_clicks_on_Submit() throws Throwable {
driver.findElement(By.cssSelector("#button[type='submit']"));
}

@Then("^The user should be on the Rideshare homepage$")
public void the_user_should_be_on_the_Rideshare_homepage() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

	
}
