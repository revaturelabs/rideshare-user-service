Feature: User Updates Car Information
	Background: On Landing Page
		Given The user is on the Landing Page
	Scenario:
		When The user clicks on full name
		When The user clicks on Profile
		When The user clicks on Car Information
		When The user types in Make
		When The user types in Model
		When The user types in Number of seats
		When The user clicks save
		Then The user should be on the Profile Page