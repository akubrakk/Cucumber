Feature: As a user I want to get ability to use menu sections


  @regression
  Scenario Outline: Docs sections should contains appropriate columns
    Given the user opens Cucumber website
    When the user clicks on the "Docs" section
    And the user clicks on the "<title>" item
    Then page with title "<title>" is displayed
    Examples:
      | title           |
      | Installation    |
      | Gherkin Syntax  |