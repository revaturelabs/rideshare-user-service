Feature: User logging out
	Background: Logged in
		Given the user is logged in
	
	Scenario:
		When the user clicks on their profile pic
		When the user clicks Log Out from drop down
		Then the user will be logged out