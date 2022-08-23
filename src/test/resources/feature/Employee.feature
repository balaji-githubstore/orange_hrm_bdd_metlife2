@employee
Feature: Employee
  In order to maintain the employee records
  As an admin
  I want to create,edit,delete employee details

  @addemployee  @high
  Scenario: Add Employee
    Given I have browser with orange HRM application
    When I enter username as 'Admin'
    And I enter password as 'admin123'
    And I click on login
    And I click PIM
    And I click on Add Employee
    And I fill the add employee details
      | fistname | middlename | lastname | employee_id | toggle_create_login | username | password | confirm_password | status   |
      | John     | w          | Wick     | 901         | yes                 | john_w   | demo123  | demo123          | Disabled |
    And I click on save employee
    Then I should get the employee firstname as 'John'
    And I should get the employee id as '901'
