Feature: TOOLS QA Homepage
  As a user, I want to navigate to TOOLS QA homepage by url

  Background: User stays at Tools QA Homepage
    Given I stay at Tools QA Homepage

  @Demo_001
  Scenario: Validate total category cards in homepage
    Then I verify total category cards is "6" in homepage

  @Demo_002
  Scenario: Validate total category cards in homepage
    Then I verify total category cards is "5" in homepage