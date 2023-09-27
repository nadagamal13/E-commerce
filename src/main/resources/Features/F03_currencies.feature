@smoke
  Feature: F03_currencies
    Scenario: use findElements
      When Select Euro currency from the dropdown list on the top left of home page
      Then verify Euro Symbol € is shown on the four products displayed in Home page