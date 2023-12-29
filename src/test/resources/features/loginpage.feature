Feature: Change Password Functionality

  As a user of the orangehrm website
  I want to be able to log in with my account
  So that I can change my account  password

  Background:
    Given the user is on the login page of the application

  Scenario: User changes password successfully
    When the user logs in with the username "Admin" and password "admin123"
    And the user clicks on the login button
    Then the user is on the Home page
 		When the user clicks on the test user avatar dropdown at the top right corner
    And selects the option to change password
    And enters the current password as "admin123"
    And enters a new password as "demo123"
    And confirms the new password as "demo123"
    When the user clicks on the save button
    Then a change password success popup should appear on the left corner of the page
    