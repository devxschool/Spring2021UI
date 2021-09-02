@regression
Feature: As a Customer, I want to add/edit/manage Bank Account Payment Profile


  Background:
    Given User navigates to Digital Bank login page
    And User logs in with following credentials
      | username      | password  |
      | aaaa@gmail.com | Password1 |
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


  Scenario: Checking account page validations without account name

    And User clicks on "Checking" account
    When User submits checking account without Account Name
    Then Verify field error message "Please fill out this field." is displayed


  Scenario Outline: Checking account page validations with Invalid account deposit
    And User clicks on "Checking" account
    When User submits checking account with "<deposit>" deposit
    Then Verify field error message "<errorMsg>" is displayed
    Examples:
      | deposit | errorMsg                           |
      | abc123  | Please match the requested format. |
      | @#$1q   | Please match the requested format. |
      | 200,33  | Please match the requested format. |



  Scenario Outline: Verify the Reset button clears out filled fields

    And User clicks on "<type>" account
    When User creates "<type>" account with following info and click Reset button
      | accountType   | accountOwnership   | accountName   | initialDeposit   |
      | <accountType> | <accountOwnership> | <accountName> | <initialDeposit> |
    Then Verify that fields are reset to default values
    Examples:
      | type     | accountType       | accountOwnership | accountName  | initialDeposit |
      | Savings  | Money Market      | Joint            | Test Account | 200            |
      | Checking | Interest Checking | Individual       | Test Account | 200            |

