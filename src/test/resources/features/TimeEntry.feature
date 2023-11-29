@Smoke
Feature: As a potential client i want to interact with the mobile application

Background:
  Given The app is loaded correctly


  @EntryHours
  Scenario: Add entry data
    When The logged-in user is in the time entry section
    And click button add an entry
    And enter the hours worked: "16":"30"
    And click button save
    Then redirect to the time entry section
    And the created entry appears


  @EntryDate
  Scenario: Add date data
    When The logged-in user is in the time entry section
    And click button add an entry
    And click in time range
    And select the day "24"-"12"-"2024"
    And enter a start time: "9":"30"
    And end time: "17":"00"
    And save the date and hours
    Then redirect to the time entry section
    And the created entry appears


  @EntryCancelled
  Scenario: 4. Generate a data entry, and cancel save
    When The logged-in user is in the time entry section
    And click button add an entry
    And enter the hours worked: "22":"30"
    And cancel the entry and return
    Then redirect to the time entry section

