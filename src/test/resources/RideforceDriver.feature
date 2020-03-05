Feature: Driver logs in and uses driver services
	
		Scenario: Driver logins in
			Given The user is on the homepage
			When The user clicks on the login button
			When The user types in the login username
			When The user types in the login password
			When The user clicks log in
			Then The user should be on the Profile page
		
		Scenario: Driver Edits Profile Page
			Given The user is on the Profile page
		
			When The user types in the first name
			When The user types in the last name
			When The user types in the email
			When The user types in the phone number
			When The user types in the new username
			When The user types in the new password
			When The user clicks the driver checkbox
			When The user clicks the active checkbox
			When The user clicks the save button
			Then The user should be on the Profile page
		
		Scenario: Driver Edits Location Page
			
			When The user clicks the location button
			When The user types in the street
			When The user types in the ciy
			When The user clicks on the state dropdown button
			When The user clicks on a state
			When The user types in the zipcode
			When The user clicks the address update button
			When The user clicks on the city dropdown button
			When The user clicks on the city
			When The user clicks on the office dropdown button
			When The user clicks on an office
			When The user clicks on the offices update button
			Then The user should be on the Profile page
		
		Scenario: Driver Edits Car
			
			When The user clicks on the car button
			When The user types in the make
			When The user types in the model
			When The user types in the year
			When The user types in the color
			When The user clicks on the seats dropdown button
			When The user clicks on the number of seats
			When The user clicks on the car update button
			When The user clicks on the profile picture
			When The user clicks the logout button
			Then The user should be on the Home page
			
			
			
			
			
			