Feature: Validating Home Page functionality

Scenario: enterSearchFlightDetails1

Given user is on home page

When user enters from city "London" and selects "Gatwick"

And user enter to city "Mumbai" and selects "Navi Mumbai"

And user selects departure date 

And user clicks on Search button 

Then user should be able to see the search results

