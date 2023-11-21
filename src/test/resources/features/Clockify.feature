@Demo
Feature: As a potential client i want to interact with the mobile application

  @Login
  Scenario Outline: The user starts the application, log in to the app.
    Given The app is loaded correctly
    When The user logs in the application with: <email>, <password>
    Then Home page is displayed

    Examples:
      | email                            | password    |
      | cervantes.mariana.6017@gmail.com | MitaCerv#21 |

  @EntryData
  Scenario: Add entry data
    Given The logged-in user is in the time entry section
    When click button add an entry
    And enter the hours worked: "16":"30"
    And click button save
    Then redirect to the time entry section
    And the created entry appears





