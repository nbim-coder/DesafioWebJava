# File: /DesafioWebJava/src/test/resources/features/checkout.feature
Feature: Checkout Functionality

  Scenario: Successful checkout
    Given I am logged in as a standard user
    And I have added items to the cart
    When I proceed to checkout
    And I enter the following checkout information:
      | First Name | Last Name | Postal Code |
      | John       | Doe       | 12345       |
    And I click the Continue button
    And I click the Finish button
    Then I should see the order confirmation