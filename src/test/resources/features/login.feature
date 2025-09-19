Feature: Login Functionality

  Scenario: Verify site title and login
    Given I am on the login page
    When I should see the site title "Swag Labs"
    And I enter valid username "standard_user" and password "secret_sauce"