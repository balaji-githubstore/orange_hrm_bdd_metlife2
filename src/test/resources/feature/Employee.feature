@employee
Feature: Employee
  In order to maintain the employee records
  As an admin
  I want to create,edit,delete employee details

  @addemployee  @high
  Scenario Outline: Add Employee
    Given I have browser with orange HRM application
    When I enter username as 'Admin'
    And I enter password as 'admin123'
    And I click on login
    And I click PIM
    And I click on Add Employee
    And I fill the add employee details
      | firstname | middlename | lastname | employee_id | toggle_create_login | username   | password   | confirm_password | status   |
      | <fname>   | <mname>    | <lname>  | <empid>     | <toogle>            | <username> | <password> | <cpassword>      | <status> |
    And I click on save employee
    Then I should get the employee firstname as '<fname>'
    And I should get the added employee details
    Examples:
      | fname | mname | lname | empid | toogle | username      | password | cpassword | status   |
      | John  | w     | Wick  | 80111 | yes    | john_w12345w4  | Demo@123 | Demo@123  | Disabled |
      | Peter | w     | mike  | 80115 | yes    | peter_w12345e | Demo@123 | Demo@123  | Enabled  |