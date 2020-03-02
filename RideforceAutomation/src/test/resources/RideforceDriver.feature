Feature: Driver logs in and uses driver services
	Background:
		Given The user is on the homepage
		Scenario:
			When The user clicks on the login button
			When The user types in the username
			When The user types in the password
			When The user clicks log in
			Then The user should be on the landing page