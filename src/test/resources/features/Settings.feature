@Smoke
Feature: As a potential client i want to interact with the mobile application

Background:
  Given The app is loaded correctly
  When The logged-in user is in the time entry section


  @SetDarkMode
  Scenario: Change settings - dark mode
    When click on menu button
    And click on settings option
    And choose enable dark mode
    Then the app changes its color


  @SetNotificatios
  Scenario: Change settings - set notifications
    When click on menu button
    And click on settings option
    And choose enable notifications
    Then verify notifications are enabled or not