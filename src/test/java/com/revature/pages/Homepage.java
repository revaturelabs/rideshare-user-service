package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//The elements that are on the Login/SignUp Page
	
	
	//login button on homepage
	@FindBy(id = "login")
	public WebElement loginBtn;
	
	//sign up button on homepage
	@FindBy(id = "register")
	public WebElement signupBtn;

	
	
	//Register menu:
	//first name input box
	@FindBy(id = "fname")
	public WebElement registerFNameInput;
	
	//last name input box
	@FindBy(id = "lname")
	public WebElement registerLastNameInput;
	
	//emal input box
	@FindBy(id = "email")
	public WebElement registerEmailInput;
	
	//phone input box
	@FindBy(id = "phone")
	public WebElement registerPhoneInput;
	
	//register username input box
	@FindBy(id = "username")
	public WebElement registerUsernameInput;
	
	//register pass input box
	@FindBy(id = "password")
	public WebElement registerPassInput;
	
	//register street input box
	@FindBy(id = "street")
	public WebElement registerStreetInput;
	
	//register city input box
	@FindBy(id = "city")
	public WebElement registerCityInput;
	
	//state input box
	@FindBy(id = "state")
	public WebElement registerStateInput;
	
	//zip code input box
	@FindBy(id = "zip")
	public WebElement registerZipInput;
	
	//register submit button
	@FindBy(id = "submit")
	public WebElement registerSubmitBtn;
	
	


}
