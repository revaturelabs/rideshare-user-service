Feature: Rider logs in and uses rider services
	
		Scenario: Rider registering
			Given The new rider is on the homepage
			When  The rider clicks on the register button
			And The rider types in the first name
			And The rider types in the last name
			And The rider types in the email
			And The rider types in the phone number
			And The rider types in the username
			And The rider types in the password
			And The rider types in the street
			And The rider types in the city
			And The rider types in the state
			And The rider types in the zip code
			And The rider types in the office
			And The rider clicks the submit button
			Then It should say registration successful

		Scenario: Rider logging in
			Given The registered rider is on the homepage
			When  The rider clicks on the login button
			And The rider enters in their username
			And The rider enters in their password
			And The rider clicks log in
			Then The rider should be on the Show Driver page
		
#		Scenario: Rider chooses a driver

#		Scenario: Rider edits profile