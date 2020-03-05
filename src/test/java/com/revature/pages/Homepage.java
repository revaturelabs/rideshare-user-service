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
	@FindBy(id = "login")
	public WebElement loginBtn;
	
	//sign up button on homepage
	@FindBy(id = "register")
	public WebElement signupBtn;

	//username input
	@FindBy(id="username")
	public WebElement usernameInput;

	//password input
	@FindBy(id="password")
	public WebElement passwordInput;

	//sumbit button for login
	@FindBy(id="submit")
	public WebElement submitBtn;
	
	
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
	
	//office input box
	@FindBy(id="office")
	public WebElement registerOfficeInput;
	
	//driver checkbox
	@FindBy(id="isDriver")
	public WebElement registerDriverCheckBox;
	
	//register submit button
	@FindBy(id = "submit")
	public WebElement registerSubmitBtn;
	

//Employee page/Profile page	
	
	//contact button
	@FindBy(id="showContact")
	public WebElement contactEditBtn;
	
	//location edit button
	@FindBy(id="showLocation")
	public WebElement locationEditBtn;
	
	//car edit button
	@FindBy(id="showCar")
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
	
	//address input
	@FindBy(id="addressInput")
	public WebElement contactAddressInput;
	
	//driver checkbox
	@FindBy(id="driverCheck")
	public WebElement driverCheckBox;
	
	//active checkbox
	@FindBy(id="activeCheck")
	public WebElement activeCheckBox;
	
	//update contact
	@FindBy(id="updateButton")
	public WebElement contactUpdateBtn;
	
	//location page elements
	
	//select for city
	@FindBy(id="citySelect")
	public WebElement locationCitySelect;

	//NEED ID ON OPTION UNDER THE CITY SELECT FOR THIS
	@FindBy(id = "")
	public WebElement locationCityOption;
	
	//select for office
	@FindBy(id = "officeSelect")
	public WebElement locationOfficeSelect;
	
	//NEED AN ID FOR THIS
	//option for office
	@FindBy(id = "")
	public WebElement locationOfficeOption;
	
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
