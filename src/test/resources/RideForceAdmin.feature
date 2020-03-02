Feature: Admin pages and things he can do 
Background: On login page 
Given The user is on the Login page

Scenario: Admin Login
When  The user types in the username
When  The user types in the password
When  The user clicks on the login button
Then  The user will be on the Admin Page

Scenario: Admin Changes their Contact
When  The user clicks on the contact button 
When The user types in phone number 
When The user clicks on save
Then The user should still be on the Profile Page 

#Scenario: Admin Changes their location 
#When The user clicks on the location button
#Then The user is on the loaction page

#Scenario: Admin Changes their Car


Scenario: Admin Fires and Promotes a Employee
When The user clicks on the Delete button
When The user clicks on the Promote button
Then The user is on the Edit employee page 

Scenario: Admin Fires and Promotes a Employee
When The user clicks on the Delete button
When The user clicks on the Promote button
Then The user is on the Edit employee page 
