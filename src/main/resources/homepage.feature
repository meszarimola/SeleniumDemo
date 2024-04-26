Feature: Home page loads

  Scenario: The Tesco home page loads
    Given I am on the home page
    When I check the page title
    Then I see the Tesco home page
