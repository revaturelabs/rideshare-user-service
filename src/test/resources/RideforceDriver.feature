Feature: Driver logs in and uses driver services
	
		Scenario:
			Given The user is on the homepage
			When The user clicks on the login button
			When The user types in the username
			When The user types in the password
			When The user clicks log in
			Then The user should be on the Profile page
		
		Scenario:
			Given The user is on the Profile page
			When The user clicks the contact button
			When The user types in the first name
			When The user types in the last name
			When The user types in the email
			When The user types in the phone number
			When The user types in the username
			When The user types in the password
			When The user types in the address
#			When The user types in the street
#			When The user types in the city
#			When The user types in the state
#			When The user types in the zip code
			When The user clicks the driver checkbox
			When The user clicks the active checkbox
			When The user clicks the update button
			Then The user should be on the Profile page
		
		Scenario:
			
			When The user clicks the location button
			When The user clicks on the office dropdown button
			When The user clicks on an office
			When The user clicks on the city dropdown button
			When The user clicks on a city 
			Then The user should be on the Profile page
		
		Scenario:
			
			When The user clicks on the car button
			When The user types in the make
			When The user types in the model
			When The user types in the year
			When The user types in the colour
			When The user clicks on the seats dropdown button
			When The user clicks on the number of seats
			When The user clicks on the update button 
			Then The user should be on the Profile page
			
			
			
			
			