@regression
Feature: Digital Bank Transactions

  Background: Login to Digital Bank
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    When User logs in with "Elaine8772@testemail.com" and "Tester123"
    Then User successfully logged in to home page

  Scenario: Submitting deposit without account
    Given User navigates to Deposit page
    When User submits a deposit with the following info
      | account | amount |
      | null    | 112    |
    Then Verify field error message "Please select an item in the list." is displayed

  Scenario: Submitting deposit without deposit
    Given User navigates to Deposit page
    When User submits a deposit with the following info
      | account | amount |
      | ABC     | null   |
    Then Verify field error message "Please fill out this field." is displayed

  Scenario: Submitting deposit with zero deposit amount
    Given User navigates to Deposit page
    When User submits a deposit with the following info
      | account | amount |
      | ABC     | 0      |
    Then Verify alert error message "The deposit amount ($0.00) must be greater than $0.00" is displayed

  Scenario: Submitting valid deposit¬
    Given User navigates to Deposit page
    When User submits a deposit with the following info
      | account | amount |
      | ABC     | 200    |
    Then Verify that deposit amount has been applied with the following
      | account | amount |
      | ABC     | 200    |

  Scenario: Submitting withdraw without account
    Given User navigates to Withdraw page
    When User User submits a withdraw without selected account
    Then Verify field error message "Please select an item in the list." is displayed

  Scenario: Submitting withdraw without deposit
    Given User navigates to Withdraw page
    When User User submits a withdraw without amount
    Then Verify field error message "Please fill out this field." is displayed

  Scenario: Submitting withdraw with zero deposit amount
    Given User navigates to Withdraw page
    When User submits a withdraw with invalid amount
    Then Verify alert error message "The withdraw amount ($0.00) must be greater than $0.00" is displayed

  Scenario: Submitting valid withdraw
    Given User navigates to Withdraw page
    And User selects withdraw account as "Money Market"
    When User submits a withdraw with "20" amount
    Then Verify that withdraw amount has been applied`