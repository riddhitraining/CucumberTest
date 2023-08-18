Feature: Feature to test google search functionality

	@SmokeTest
  Scenario: Validate google search is working
    Given Browser is open
    And User is on google search page
    When User enters a test in serach box
    And User hits enter
    Then User is navigated to serach results