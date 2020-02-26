Feature: User updates Membership
	Background: On Landing Page
		Given The user is on the Landing Page
	
	Scenario: User Edits Profile
		When The user clicks on the Profile Picture
		When The user clicks on Profile
		When The user clicks on Membership
		When The user clicks on status input box
		When The user clicks on driver
		When The user clicks on activity input box
		When The user clicks on active
		When The user clicks on save
		When The user clicks on status input box
		When The user clicks on rider
		When The user clicks on activity input box
		When The user clicks on disabled
		When The user clicks on save
		Then The user should be on the Profile page