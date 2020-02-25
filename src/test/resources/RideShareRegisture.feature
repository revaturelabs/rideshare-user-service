	Feature: Ride share user login
	Background: On homepage
		Given The user is on the Rideshare homepage
	
	Scenario: User Sign up as Rider
		When The user types in username
		When The user types in firstname
		When The user types in lastname
		When The user types in email
		When The user types in phone
		When The user types in location
		When The user types in batch
		
		When The user clicks on SignUpRider
		Then The user should be on the something page
		
	Scenario: User Sign up as Driver
		When The user types in username
		When The user types in firstname
		When The user types in lastname
		When The user types in email
		When The user types in phone
		When The user types in location
		When The user types in batch
		
		When The user clicks on SignUpDriver
		Then The user should be on the something page
		