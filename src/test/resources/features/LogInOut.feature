@Smoke
Feature: As a potential client i want to interact with the mobile application

  Background:
    Given The app is loaded correctly

  @Login
  Scenario Outline: The user starts the application, log in to the app.
    When The user logs in the application with: <email>, <password>
    Then Home page is displayed

    Examples:
      | email                            | password    |
      | cervantes.mariana.6017@gmail.com | MitaCerv#21 |


  @LogOut
  Scenario: The user logout of the application
    When The logged-in user is in the time entry section
    And click on menu button
    And click on the logout option
    And confirm this action to logout
    Then Login page is displayed