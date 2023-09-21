@smoke
Feature: F02_Login | users could use login functionality to use their accounts
  Background:
    Given user go to login page

    Scenario: User could login with valid email and password
      When User enters valid email and password
      And User clicks on Login
      Then User login to the system successfully

  Scenario: User could not login with invalid email and password
    When User enters invalid email
    And User enters random password
    And User clicks on Login
    Then User could not login to the system
    