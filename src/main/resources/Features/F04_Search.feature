@smoke
  Feature: F04_Search

    Scenario Outline:
    When user could search using product "<name>"
      Examples:
      |name|
      |book|
      |laptop|
      |nike|

    Scenario Outline:
    When user could search for product using "<sku>"
      Examples:
      |sku|
      |SCI_FAITH|
      |APPLE_CAM|
      |SF_PRO_11|
