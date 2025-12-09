Feature: Login Functionality

  @UI
  Scenario: Valid login
    Given I open the login page
    When I enter username "tomsmith"
    And I enter password "SuperSecretPassword!"
    And I click login
    Then Login should be successful
