Feature: The user switches to the Drivers page
	Background: Logged in
		Given the user is logged in
		
	Scenario:
		When The user clicks on the drivers button
		When The user clicks on the view button
		When The user clicks on the close button
		Then The user should be on the drivers page