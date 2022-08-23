package com.metlife.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;

    @Given("I have browser with orange HRM application")
    public void i_have_browser_with_orange_hrm_application() {

        WebDriverManager.edgedriver().setup();

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @When("I enter username as {string}")
    public void i_enter_username_as(String username) {
        driver.findElement(By.name("username")).sendKeys(username);
        
    }

    @When("I enter password as {string}")
    public void i_enter_password_as(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @When("I click on login")
    public void i_click_on_login() {
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }

    @Then("I should not get access to portal with error message {string}")
    public void i_should_not_get_access_to_portal_with_error_message(String expectedError) {

        String actualError = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(actualError, expectedError);
    }

    @Then("I should get access to the portal with menu as {string}")
    public void i_should_get_access_to_the_portal_with_menu_as(String expectedValue) {

        String actualValue = driver.findElement(By.xpath("//*[text()='My Info']")).getText();
        Assert.assertEquals(actualValue, expectedValue);
    }

}
