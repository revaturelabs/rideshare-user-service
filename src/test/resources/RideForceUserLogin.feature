Feature: Ride share user login
	Background: On homepage
		Given The user is on the Rideshare homepage
		
		
		
		
	Scenario: User Logins 
		When The user clicks on Login
		When The user types in username
		When The user types in password
		When The user clicks on Login Button
		Then The user should be on the Landing page


			
