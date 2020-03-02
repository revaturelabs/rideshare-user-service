Feature: The Driver Logins in and accesses profile
	Background: 
		Given The user is one the homepage
		Scenario:
			When The user clicks on the login button
			When The user types in the username
			When The user types in the password
			Then The user should be on the landing page