Feature: The user edits their location
	Background: On profile page
		Given The user is on the profile page
		
	Scenario: 
		When the user clicks on Location
		When the user types in address
		When the user types in address2
		When the user types in city
		When the user types in state
		When the user types in zipcode
		When the user clicks save
		Then the page should say updated successfully