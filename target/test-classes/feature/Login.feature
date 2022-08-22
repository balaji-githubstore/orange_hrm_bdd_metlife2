Feature: Login
  In order to maintain the employee records
  As an admin
  I want to login to the portal


  Scenario: Invalid Credential
    Given I have browser with orange HRMapplication
    When I enter username as 'john'
    And I enter password as 'john123'
    And I click on login
    Then I should not get access to portal with error message 'Invalid credentials'



