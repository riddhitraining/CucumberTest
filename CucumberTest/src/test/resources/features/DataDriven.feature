Feature: Test login fuctionality

@DataDriven 
Scenario Outline: Check login successful with valid credenitial

Given user is on login page
And <username> and <password> are entered by user
When user click on login button
Then user navigate to home page 

Examples: 
   | username | password |
   | Riddhi   | testing  |
   | Nyra     | 123test  |
   | Shiv     | test@123 |
 