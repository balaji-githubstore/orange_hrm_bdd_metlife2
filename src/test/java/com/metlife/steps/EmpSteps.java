package com.metlife.steps;

import com.metlife.base.AutomationHooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class EmpSteps {
    private static DataTable dt;
    @When("I click PIM")
    public void i_click_pim() {

        AutomationHooks.driver.findElement(By.linkText("PIM")).click();
    }

    @When("I click on Add Employee")
    public void i_click_on_add_employee() {
        AutomationHooks.driver.findElement(By.linkText("Add Employee")).click();
    }

    @When("I fill the add employee details")
    public void i_fill_the_add_employee_details(DataTable dataTable) {

        dt=dataTable;
        List<Map<String, String>> ls = dataTable.asMaps();

        String firstName = ls.get(0).get("firstname");
        String middleName = ls.get(0).get("middlename");
        String lastname = ls.get(0).get("lastname");
        String empId = ls.get(0).get("employee_id");
        String toggleCreateLogin = ls.get(0).get("toggle_create_login");
        String userName = ls.get(0).get("username");
        String password = ls.get(0).get("password");
        String confirmPassword = ls.get(0).get("confirm_password");
        String status = ls.get(0).get("status");

        AutomationHooks.driver.findElement(By.name("firstName")).sendKeys(firstName);
        AutomationHooks.driver.findElement(By.name("middleName")).sendKeys(middleName);
        AutomationHooks.driver.findElement(By.name("lastName")).sendKeys(lastname);


//        WebElement ele= AutomationHooks.driver.findElement(By.xpath("//label[text()='Employee Id']/following::input"));
//        JavascriptExecutor js = (JavascriptExecutor) AutomationHooks.driver;
//        js.executeScript("arguments[0].value='" + empId + "'",ele);

//        AutomationHooks.driver.findElement(By.xpath("//label[text()='Employee Id']/following::input")).clear();
//        AutomationHooks.driver.findElement(By.xpath("//label[text()='Employee Id']/following::input")).sendKeys(empId);

        if (toggleCreateLogin.equalsIgnoreCase("yes")) {
            AutomationHooks.driver.findElement(By.xpath("//*[text()='Create Login Details']/following::span")).click();
        }

        //username
        AutomationHooks.driver.findElement(By.xpath("//label[text()='Username']/following::input")).sendKeys(userName);
        // password
        AutomationHooks.driver.findElement(By.xpath("//label[text()='Password']/following::input")).sendKeys(password);
        // confirm password
        AutomationHooks.driver.findElement(By.xpath("//label[text()='Confirm Password']/following::input")).sendKeys(confirmPassword);

        //click on status
        if (status.equalsIgnoreCase("disabled")) {
            AutomationHooks.driver.findElement(By.xpath("//label[text()='Disabled']")).click();
        }
        AutomationHooks.driver.findElement(By.xpath("//label[text()='Employee Id']/following::input")).clear();
        AutomationHooks.driver.findElement(By.xpath("//label[text()='Employee Id']/following::input")).sendKeys(empId);
    }

    @When("I click on save employee")
    public void i_click_on_save_employee() {
        AutomationHooks.driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
    }

    @Then("I should get the employee firstname as {string}")
    public void i_should_get_the_employee_firstname_as(String expectedFirstName) {

      String actualFirstName=  AutomationHooks.driver.findElement(By.name("firstName")).getAttribute("value");
        Assert.assertEquals(actualFirstName,expectedFirstName);
    }

    @Then("I should get the added employee details")
    public void i_should_get_the_employee_id_as() {
        List<Map<String, String>> ls = dt.asMaps();

        String firstName = ls.get(0).get("firstname");
        String middleName = ls.get(0).get("middlename");
        String lastname = ls.get(0).get("lastname");
        String empId = ls.get(0).get("employee_id");
        String toggleCreateLogin = ls.get(0).get("toggle_create_login");
        String userName = ls.get(0).get("username");
        String password = ls.get(0).get("password");
        String confirmPassword = ls.get(0).get("confirm_password");
        String status = ls.get(0).get("status");

        String actualFirstName=  AutomationHooks.driver.findElement(By.name("firstName")).getAttribute("value");
        Assert.assertEquals(actualFirstName,firstName);
    }
}
