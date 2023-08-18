Feature: Customers

 Background: Below are the common steps for each scenario
Given User launch chrome browser
When User open URL "https://admin-demo.nopcommerce.com/login"
And User enter email "admin@yourstore.com" and password "admin"
And User click on login
Then User can view Dashboard

Scenario: Add new Customer
When User click on Customers Menu
And click on Customers menu Item
And click on Add new button
Then User can view Add new Customer page
When User enter Cutomer info
And click on save button
And close browser

Scenario: Search Customer by EmailID
When User click on Customers Menu
And click on Customers menu Item
And Enter Customer EMail
When Click on search button
Then User should found Email in the search table
And close browser

Scenario: Search Customer by Name
When User click on Customers Menu
And click on Customers menu Item
And Enter Customer FirstName
And Enter Customer LastName
When Click on search button
Then User should found Name in the search table
And close browser