@login
Feature: Login
  In order to maintain the employee records
  As an admin
  I want to login to the portal

  @invalid    @low
  Scenario Outline: Invalid Credential
    Given I have browser with orange HRM application
    When I enter username as '<username>'
    And I enter password as '<password>'
    And I click on login
    Then I should not get access to portal with error message 'Invalid credentials'
    Examples:
      | username | password |
      | John     | John123  |
      | Peter    | Peter123 |

  @valid   @high
  Scenario: Valid Credential
    Given I have browser with orange HRM application
    When I enter username as 'Admin'
    And I enter password as 'admin123'
    And I click on login
    Then I should get access to the portal with menu as 'My Info123'
