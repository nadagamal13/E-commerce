@smoke
Feature: F03_Check out as guest: The Guest can check out the products and make a payment
  Background:
    Given The guest add product to the shopping cart
    And The guest user navigate to the shopping cart

  Scenario: The Guest check out the products and make a card payment
    When The guest user agrees to the terms and conditions and click on the Check out button
    And The guest user add his details:First Name,Last Name and Email
    And The guest user select the country and state
    And The guest user add city and address details
    And The user adds Phone number and Fax
    And The user clicks on Continue
    And The user selects the shipping method and clicks on Continue
    And The user selects card payment method and clicks on Continue
    And The user add the payment method details "5555555555554444"
    And The guest user clicks on Confirm
    Then The order is confirmed and the user can navigate to order details

  Scenario: The Guest check out the products and make a check payment
    When The guest user agrees to the terms and conditions and click on the Check out button
    And The guest user add his details:First Name,Last Name and Email
    And The guest user select the country and state
    And The guest user add city and address details
    And The user adds Phone number and Fax
    And The user clicks on Continue
    And The user selects the shipping method and clicks on Continue
    And The user selects the check payment method and clicks on Continue
    And The guest user clicks on Confirm
    Then The order is confirmed and the user can navigate to order details








