@Smoke
Feature: SignUp: The guest user can create a new valid account
  Background:
    Given The user clicks on Register

  Scenario: Valid Sign Up: The user create a valid account
    When User selects gender
    And User enters first name, last name, and selects date of birth
    And User enters a valid email
    And User enters company name
    And User selects newsletter
    And User enters password and confirms it
    And User clicks the register button
    Then New account is created