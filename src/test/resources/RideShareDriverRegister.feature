	Feature: Ride share Driver register
	Background: On homepage
		Given The user is on the Rideshare homepage
		
		Scenario: User Sign up as Driver
	
		When The user clicks on Sign up
		When The user types in firstname
		When The user types in lastname
		When The user types in email
		When The user types in phone
		When The user types in username
		When The user click on batch
		When The user click on Morgantown
		When The user types in Adress
		When The user types in City
		When The user clicks on State 
		When The user clicks on wv
		When The user types in ZipCode
		When The user clicks on Driver
		Then The user should be on the Rideshare homepage
		