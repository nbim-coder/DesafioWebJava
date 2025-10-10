Feature: Checkout Functionality

  Background:
    Given I am logged in as "standard_user"
    And I have added an item to the cart

  Scenario: Successful checkout
    When I go to the cart page
    And I click on the checkout button
    And I enter my personal information
    And I click on the continue button
    And I confirm the order
    Then I should see a confirmation message