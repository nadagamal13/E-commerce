@smoke
Feature: F01_Register | users could register with new accounts
  Background:
    Given user go to register page

  Scenario: guest user could register with valid data successfully
    When user select gender type
    And User enters first name, last name, and selects date of birth
    And User enters a valid email
    And User enters company name
    And User selects newsletter
    And User enters password and confirms it
    And User clicks on register button
    Then success message is displayed