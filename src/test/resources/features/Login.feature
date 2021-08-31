@regression
Feature: Digital Bank Login

  Background:
    Given User navigates to Digital Bank login page

  @smoke
  Scenario:  As a user, I want to successfully login with valid credetials
    When User logs in with following credentials
      | username     | password  |
      | aa@gmail.com | Password1 |
    Then User should successfully be logged in to home page


  Scenario:  As a user, I want to see a specific error message when logging in with invalid credentials
    When User logs in with following credentials
      | username              | password  |
      | JohnDoe@testemail.com | Password1 |
    #when writing scenarios I usually try to make them dynamic by using parameters
    Then User should be displayed with the error message "Error Invalid credentials or access not granted due to user account status or an existing user session."


