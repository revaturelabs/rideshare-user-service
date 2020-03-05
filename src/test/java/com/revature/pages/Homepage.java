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
//User login
	
	//login button on homepage
	@FindBy(id = "loginButton")
	public WebElement loginBtn;
	
	//sign up button on homepage
	@FindBy(id = "registerButton")
	public WebElement signupBtn;

	//username input
	@FindBy(id="formGroupExampleInput")
	public WebElement usernameInput;

	//password input
	@FindBy(id="formGroupExampleInput2")
	public WebElement passwordInput;

	//sumbit button for login
	@FindBy(id="sign-in-btn")
	public WebElement submitBtn;
	
	
//Register menu:
	
	//first name input box
	@FindBy(id = "firstname")
	public WebElement registerFNameInput;
	
	//last name input box
	@FindBy(id = "lastname")
	public WebElement registerLastNameInput;
	
	//emal input box
	@FindBy(id = "email")
	public WebElement registerEmailInput;
	
	//phone input box
	@FindBy(id = "phoneNumber")
	public WebElement registerPhoneInput;
	
	//register username input box
	@FindBy(id = "userName")
	public WebElement registerUsernameInput;
	
	//register pass input box
	@FindBy(id = "password")
	public WebElement registerPassInput;
	
	//register address input box
	@FindBy(id = "hAddressInput")
	public WebElement registerAddressInput;
	
	//register city input box
	@FindBy(id = "hCityInput")
	public WebElement registerCityInput;
	
	//state input box
	@FindBy(id = "hStateSelect")
	public WebElement registerStateSelect;
	
	//state option
	@FindBy(css = "[value='LA']")
	public WebElement registerStateOption;
	
	//zip code input box
	@FindBy(id = "hZipInput")
	public WebElement registerZipInput;
	
	//driver checkbox
	@FindBy(id="driver")
	public WebElement registerDriverCheckBox;
	
	//register submit button
	@FindBy(id = "submitButton")
	public WebElement registerSubmitBtn;
	

//Employee page/Profile page	
	
	//contact button
	@FindBy(id="contactButton")
	public WebElement contactEditBtn;
	
	//location edit button
	@FindBy(id="locationButton")
	public WebElement locationEditBtn;
	
	//car edit button
	@FindBy(id="carButton")
	public WebElement carEditBtn;
	
	//contact edit page elements
	
	//first name input
	@FindBy(id="firstNameInput")
	public WebElement contactFNameInput;
	
	//last name input
	@FindBy(id="lastNameInput")
	public WebElement contactLNameInput;
	
	//email input
	@FindBy(id="emailInput")
	public WebElement contactEmailInput;
	
	//phone input
	@FindBy(id="phoneInput")
	public WebElement contactPhoneInput;
	
	//username input
	@FindBy(id="usernameInput")
	public WebElement contactUserInput;
	
	//password input
	@FindBy(id="passwordInput")
	public WebElement contactPassInput;
	
//	//address input
//	@FindBy(id="addressInput")
//	public WebElement contactAddressInput;
	
	//driver checkbox
	@FindBy(id="driverInput")
	public WebElement driverCheckBox;
	
	//active checkbox
	@FindBy(id="activeInput")
	public WebElement activeCheckBox;
	
	//save contact button
	@FindBy(id="updateButton")
	public WebElement contactSaveBtn;
	
	//location page elements
	
	
	//Street input box
	@FindBy(id = "employeeStreetInput")
	public WebElement locationStreetInput;
	
	//City input box
	@FindBy(id = "employeeCityInput")
	public WebElement locationCityInput;
	
	//State select
	@FindBy(id ="employeeStateSelect")
	public WebElement locationStateSelect;
	
	//State option 
	@FindBy(css = "[value='FL']")
	public WebElement locationStateOption;
	
	//update button
	@FindBy(id = "updateButton")
	public WebElement locationUpdateBtn;
	
	//select for city
	@FindBy(id="citySelect")
	public WebElement locationOfficeCitySelect;

	//city option
	@FindBy(css = "[value='Pittsburgh']")
	public WebElement locationOfficeCityOption;
	
	//office select
	@FindBy(id ="officeSelect")
	public WebElement locationOfficeSelect;
	
	//office option
	@FindBy(css = "[value='496 High Street, Morgantown, WV 26506']")
	public WebElement locationOfficeOption;
	
	//offices update button
	@FindBy(id = "updateButton")
	public WebElement locationOfficeUpdateBtn;
	
	
	
	//car page elements

	//make input
	@FindBy(id="makeInput")
	public WebElement carMakeInput;
	
	//model input
	@FindBy(id="modelInput")
	public WebElement carModelInput;
	
	//year input
	@FindBy(id="yearInput")
	public WebElement carYearInput;
	
	//colour input
	@FindBy(id="colourInput")
	public WebElement carColourInput;
	
	//seat selector
	@FindBy(id="infoLabel")
	public WebElement seatSelect;
	
	//seat option
	@FindBy(id="seatOption")
	public WebElement seatOption;
	
	//car update button
	@FindBy(id="updateButton")
	public WebElement carUpdateBtn;

	
	
//Admin Page

	//edit employee button
	@FindBy(id="editEmployee")
	public WebElement editEmployeeBtn;

	//edit location button
	@FindBy(id="editLocation")
	public WebElement editLocationBtn;


	
//Edit office page
	
	//location one delete button
	@FindBy(id="delete1")
	public WebElement office1DeleteBtn;
	
	//location one update button
	@FindBy(id="update1")
	public WebElement office1UpdateBtn;

	// not using
	//location 2 delete button
	@FindBy(id="delete2")
	public WebElement office2DeleteBtn;
	
	// not using
	//location 2 update button
	@FindBy(id="update2")
	public WebElement office2UpdateBtn;
	
	//add a new location button
	@FindBy(id="addLocation")
	public WebElement addLocationBtn;
	
//Edit employee elements
	
	//delete an employee button
	@FindBy(id="delete1")
	public WebElement employeeDeleteBtn;
	
	//promote an employee button
	@FindBy(id="promote1")
	public WebElement employeepromoteBtn;






	
	
	
	
	
	
	
}
