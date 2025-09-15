Feature: Login Test

  Scenario: Successful login
    Given I am on the login page
    When I enter valid username "standard_user" and password "secret_sauce"
    Then I should be logged in successfully