Feature: Users could use login functionality to use their accounts
  Background:
    Given The user clicks on Login

    Scenario: User could login with valid email and password
      When User enters valid email "email" and password "password"
      And User clicks on Login
      Then User login function is succeed

  Scenario: User could not login with invalid email and password
    When User enters invalid email
    And User enters random password
    And User clicks on Login
    Then User login function is Failed
    