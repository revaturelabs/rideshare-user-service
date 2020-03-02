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

	
	
}
