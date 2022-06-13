Feature: Search weather in your city
  As a user, I want to search the weather in your city

  Background: User stays at Open Weather Map Dashboard page
    Given I stay at Open Weather Map Dashboard page

  @Test_01_Passed
  Scenario: Validate the weather in Ha Noi City displayed correct
    When I search the weather of "Ha Noi" city
    And I click on the link in result list
    Then I verify the current date is displayed correct
    And I verify the city name "Hanoi, VN" is displayed correct
    And I verify the temperature "°C" is displayed correct

  @Test_02_Failed
  Scenario: Validate the weather in Quang Ngai City displayed correct
    When I search the weather of "Quang Ngai" city
    And I click on the link in result list
    Then I verify the current date is displayed correct
    And I verify the city name "Quang Ngai, VN" is displayed correct
    And I verify the temperature "°F" is displayed correct