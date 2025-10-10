Feature: Login Functionality

  Scenario: Successful login
    Given I am on the login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be logged in successfully

  Scenario: Failed login
    Given I am on the login page
    When I enter username "locked_out_user" and password "secret_sauce"
    And I click the login button
    Then I should see an error message

  Scenario: Login with invalid credentials
    Given I am on the login page
    When I enter username "invalid_user" and password "invalid_password"
    And I click the login button
    Then I should see an error message

  # Este arquivo contém os cenários de teste para a funcionalidade de login.
  # Testa tanto o login bem-sucedido quanto o login com credenciais inválidas.