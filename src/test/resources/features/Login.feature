Feature: Digital Bank Login


  Scenario:  As a user, I want to successfully login with valid credetials
    Given User navigates to Digital Bank login page
    When User logs in with following credentials
      | username              | password  |
      | JohnDoe@testemail.com | Password1 |
    Then User should successfully be logged in to home page


