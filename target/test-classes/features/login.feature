Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And I click the login button
    Then I should be logged in

  Scenario: Failed login with invalid credentials
    Given I am on the login page
    When I enter username "invalid_user"
    And I enter password "invalid_password"
    And I click the login button
    Then I should see an error message