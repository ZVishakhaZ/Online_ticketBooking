@all
Feature: Validating the Login fucntionality

Background:
Given user is on login page

@smoke
Scenario: User successfully logs in to the application with Valid credentials

When user enters username "Admin"

And user enters password = "admin12"

And user clcks on Login button 

Then user should be able to see the home page

@sanity
Scenario Outline: Validate login with multiple invalid credentials

When user enters username "<username>"

And user enters password = "<password>"

And user clcks on Login button 

Then user should not be able to see the home page

Examples: 
|username|password|
|Admin|admin|
|admin123|admin123|
|||
