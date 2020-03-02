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

	//close button for signup
	@FindBy(xpath = "/html/body/modal-container/div/div/div[1]/button")
	public WebElement closeSignUpBtn;
	
	//close button for logIn
	@FindBy(xpath = "//*[@id=\"login-form\"]/div[1]/button")
	public WebElement closeLoginBtn;
	
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

	//the element for the toggle icon/humburger icon
	@FindBy(xpath = "/html/body/app-root/app-navbar/nav/button")
	public WebElement hamburgerIcon;

	// the element for the Search word
	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[1]/a")
	public WebElement searchNavAnchor;
	
	//element for the Drivers word
	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")
	public WebElement driversNavAnchor;
	
	//Revature logo
	@FindBy(className = "logoRev")
	public WebElement revatureLogo;
	
	//Profile anchor when you click the fullname/profile pic
	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[3]/div/a[1]")
	public WebElement profileAnchor;
	
	//Logout anchor
	@FindBy(id = "logout-btn")
	public WebElement logOutAnchor;
	
	
	//The elements on the Profile page
	
	
	//Contact Information button
	@FindBy(xpath = "/html/body/app-root/app-profile/div/div/div[1]/button[1]")
	public WebElement contactInfoBtn;
	
	//location button
	@FindBy(xpath = "/html/body/app-root/app-profile/div/div/div[1]/button[2]")
	public WebElement locationBtn;
	
	//membership button
	@FindBy(xpath = "/html/body/app-root/app-profile/div/div/div[1]/button[3]")
	public WebElement membershipBtn;
	
	//car information button
	@FindBy(xpath = "/html/body/app-root/app-profile/div/div/div[1]/button[4]")
	public WebElement carInfoBtn;
	
	
	
	//contact information area:
	
	//firstName input box 
	@FindBy(id = "f_name")
	public WebElement firstNameContactInput;
	
	//last name input box
	@FindBy(id = "l_name")
	public WebElement lastNameContactInput;
	
	//email input box
	@FindBy(id = "user_email")
	public WebElement emailContactInput;
	
	//phone input box
	@FindBy(id = "phone")
	public WebElement phoneContactInput;
	
	//Save button
	@FindBy(xpath = "/html/body/app-root/app-profile/div/div/div[2]/app-profile-contact/div/button")
	public WebElement saveContactBtn;
	
	
	
	//location area:
	
	//address input box
	@FindBy(id = "address")
	public WebElement addressLocationInputBox;
	
	//address2 input box
	@FindBy(id = "address2")
	public WebElement address2LocationInputBox;
	
	//city input box
	@FindBy(id = "city")
	public WebElement cityLocationInputBox;
	
	//state selector
	@FindBy(id = "state")
	public WebElement stateLocationSelector;
	
	//option for Hawaii
	@FindBy(css = "#button[value='HI']")
	public WebElement hawaiiOption;
	
	//zipcode inputBox
	@FindBy(id = "zipcode")
	public WebElement zipCode;
	
	//save button for location
	@FindBy(xpath = "/html/body/app-root/app-profile/div/div/div[2]/app-profile-location/div/button")
	public WebElement saveLocationBtn;
	
	
	
	//Membership area:
	
	//rider select box
	@FindBy(id = "rider")
	public WebElement riderSelectBox;
	
	//driver option
	@FindBy(xpath = "//*[@id=\"rider\"]/option[1]")
	public WebElement driverOption;
	
	//rider option
	@FindBy(xpath = "//*[@id=\"rider\"]/option[2]")
	public WebElement riderOption;
	
	//selecter for active/disabled
	@FindBy(id = "active")
	public WebElement statusSelect;
	
	//option for choosing active
	@FindBy(xpath = "//*[@id=\"active\"]/option[1]")
	public WebElement activeStatus;
	
	//optoin for choosing disabled
	@FindBy(xpath = "//*[@id=\"active\"]/option[2]")
	public WebElement disabledStatus;
	
	//save button for membership
	@FindBy(xpath = "/html/body/app-root/app-profile/div/div/div[2]/app-profile-membership/div/div/div[2]/div/button")
	public WebElement membershipSaveBtn;
	
	
	
	//Car Information section:
	
	//make inputbox
	@FindBy(id = "make")
	public WebElement makeInputBox;
	
	//model inputBox
	@FindBy(id = "model")
	public WebElement modelInputBox;
	
	//Number of seats select
	@FindBy(id = "Nrseats")
	public WebElement seatSelect;
	
	//option for 1 seat
	@FindBy(css = "#option[value = '1'")
	public WebElement oneSeat;
	
	//Save button for car info
	@FindBy(xpath = "/html/body/app-root/app-profile/div/div/div[2]/app-profile-car/div/button")
	public WebElement carInfoSaveBtn;
	
	
	
	
	//Drivers page elements
	
	//table row/anchor for first driver
	@FindBy(id = "")
	public WebElement firstDriver;
	
	//close button for the box that pops up with the driver's info
	@FindBy(id = "")
	public WebElement closeDriverBox;
	
}
