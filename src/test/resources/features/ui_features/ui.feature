@ui
Feature: ui_testing

  Scenario Outline: TC_01
    Given user goes to the "https://demoqa.com/text-box" homepage
    And enter "<fullName>"
    And enter the "<email>"
    And write the "<current address>"
    And enter your "<permanent address>"
    And click on Submit button
    Then verify the result contains the "<data>"
    And close the application
    Examples:
      | fullName   | email                     | current address                  | permanent address             | data                      |
      | test user  | test@blabla.com           | C. Dobla, 5, 28054 Madrid, Spain | Street X, 28013 Madrid, Spain | test@blabla.com           |
      | John Smith | john.smith@mailinator.com | Street Smith 3, London, UK       | Street Smith 6, London, UK    | john.smith@mailinator.com |