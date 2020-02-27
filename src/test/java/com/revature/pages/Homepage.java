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
	
// the element
	
	
	
	
}
