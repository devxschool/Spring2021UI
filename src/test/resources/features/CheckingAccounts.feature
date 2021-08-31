@regression
Feature: As a Customer, I want to add/edit/manage Bank Account Payment Profile


  Background:
    Given User navigates to Digital Bank login page
    And User logs in with following credentials
      | username     | password  |
      | aa@gmail.com | Password1 |
    When User should successfully be logged in to home page

  @smoke
  Scenario: As a user, I want to be able to view all details of my account home page
    Then Verify that "Welcome Test1" welcoming message is displayed
    Then Verify that home page panel with account info is displayed


  Scenario: As a user, I want to have an ability to create a new Checking account
    Then Verify that "Checking" dropdown has following options
      | View Checking |
      | New Checking  |


  Scenario: Create a checking account with valid data
    Given User clicks on new "Checking" account
    When User creates Checking account with the following info
      | accountType | accountOwnership | accountName | initialDeposit |
      | standard    | individual       | ABC         | 25             |
    Then verify newly created account information contains
      | accountType | accountOwnership | accountName | initialDeposit | OnOrOff | interestRate |
      | standard    | individual       | ABC         | 25             | on      | 0            |










