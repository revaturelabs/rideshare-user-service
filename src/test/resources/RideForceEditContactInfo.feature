Feature: User goes to profile and edits contact info
	Background: On landing page
		Given The user is on RideShare landing page

	Scenario:
		When The user clicks on their profile pic
		When The user clicks profile from dropdown
		When The user types in first name
		When The user types in last name
		When The user clicks save
		Then The page should say updated successfully 