Feature: User goes to profile and edits contact info
	Background: On landing page
		Given The user is on RideShare landing page

	Scenario:
		When the user clicks on their profile pic
		When the user clicks profile from dropdown
		When the user types in first name
		When the user types in last name
		When the user clicks save
		Then the page should say updated successfully 