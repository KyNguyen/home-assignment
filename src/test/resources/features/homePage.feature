Feature: Search weather in your city
  As a user, I want to search the weather in your city

  @TestCase_01
  Scenario: Validate the weather displayed in Ha Noi City
    Given I navigate to url "https://openweathermap.org/"
    When I search the weather of "Ha Noi" city
    And I click on the link in result list
    Then I verify the current date is displayed correct
    And I verify the city name is displayed correct
    And I verify the temperature of weather is displayed correct