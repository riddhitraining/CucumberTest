Feature: Login
@SanityTest1
Scenario: Successful login with valid credentials
Given User launch chrome browser
When User open URL "https://admin-demo.nopcommerce.com/login"
And User enter email "admin@yourstore.com" and password "admin"
And User click on login
Then Page title should be "Dashboard / nopCommerce administration"
When User click on Log out link
Then Page title should be "Your store. Login"
And close browser
@SanityTest2
Scenario Outline: Login Data Drivern 
Given User launch chrome browser
When User open URL "https://admin-demo.nopcommerce.com/login"
And User enter email "<email>" and password "<password>"
And User click on login
Then Page title should be "Dashboard / nopCommerce administration"
When User click on Log out link
Then Page title should be "Your store. Login"
And close browser

Examples: 

  | email                | password |
  | admin@yourstore.com  | admin    |
  | admin1@yourstore.com | admin123 |