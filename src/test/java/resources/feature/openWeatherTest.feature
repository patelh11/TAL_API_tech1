Feature: As a user I want to validate few features of exchangeRate website

  Scenario: Get Weather at given city
    Given I am on Weather Website
    When  As a user I want to get weather of city "London"
    Then I am receiving status code 200
    And I get Weather of city
