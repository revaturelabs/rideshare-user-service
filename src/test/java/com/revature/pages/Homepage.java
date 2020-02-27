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
	@FindBy(xpath = "//a[contains(.,'Login')]")
	public WebElement loginBtn;
	
	//sign up button on homepage
	@FindBy(xpath = "//a[contains(.,'Sign up')]")
	public WebElement signupBtn;

	
	// Login dialog box
	
	//login username
	@FindBy(id = "formGroupExampleInput")
	public WebElement loginUserNameTextbox;
	
	//login password
	@FindBy(id = "formGroupExampleInput2")
	public WebElement loginPasswordTextbox;
	
	//submits login
	@FindBy(id = "sign-in-btn")
	public WebElement loginSubmitBtn;
	
	
	// Sign up (register) dialog box
	
	//first name input box
	@FindBy(id = "firstname")
	public WebElement firstNameInputBox;
	
	//last name input box
	@FindBy(id = "lastname")
	public WebElement lastNameInputBox;
	
	//email input box
	@FindBy(id = "email")
	public WebElement emailInputBox;
	
	//phone # input box
	@FindBy(id = "phoneNumber")
	public WebElement phoneNumberInputBox;

	//username input box
	@FindBy(id = "userName")
	public WebElement userNameInputBox;

	//batch dropdown
	@FindBy(xpath = "/html/body/modal-container/div/div/div[2]/select[1]")
	public WebElement batchDropdown;

	//address input box
	@FindBy(id = "hAddress")
	public WebElement addressInputBox;

	//city input box
	@FindBy(id = "hCity")
	public WebElement cityInputBox;

	//state dropdown
	@FindBy(id = "hState")
	public WebElement stateDropdown;

	//state input box
	//** Mayyy work?
	@FindBy(css = "#option[value='WV']")
	public WebElement WVSelection;

	//zipcode input box
	@FindBy(xpath = "//input[contains(.,'Zip Code')]")
	public WebElement zipcodeInputBox;

	//driver button
	@FindBy(id = "driver")
	public WebElement driverButton;

	//rider button
	@FindBy(id = "rider")
	public WebElement riderButton;

	//submit button
	@FindBy(css = "#button[type='submit']")
	public WebElement submitButton;

	
	// These are the elements that are found on the Landing Page
	
	
	//search button on landing page
	@FindBy(className = "register")
	public WebElement searchBtn;
	
	//search bar on landing page
	@FindBy(id = "formGroupExampleInput2")
	public WebElement landSearchBar;
	
	//the id for the anchor that wraps around the full name and profile pic
	@FindBy(id = "navbarDropdown")
	public WebElement dropdownBtn;
	
	@FindBy(css = "#navbarSupportedContent")
	public WebElement toggleIcon;
	
	@FindBy(xpath = "/html/body/app-root/app-navbar/nav/button")
	public WebElement hamburgerIcon;
// the element
	
	
	
	
}
