Feature: Admin pages and things he can do 



Scenario: Admin Login
Given The user is on the home page
When The user clicks on the login button 
When  The user types in the username
When  The user types in the password
When  The user clicks on the submit button
Then  The user will be on the Admin Page

Scenario: Admin Changes their Contact
When  The user clicks on the contact button 
When The user types in phone number 
When The user clicks on save
Then The user should still be on the Profile Page 




Scenario: Admin Fires Employee
When The user clicks on the Delete button
Then The user is on the Edit employee page 

Scenario: Admin Promotes a Employee
When The user clicks on the Promote button
Then The user is on the Edit employee page 


Scenario: The Admin Logout
When The user clicks on the profile button
When The user clicks on the logout button 
Then The user is on the Home Page



