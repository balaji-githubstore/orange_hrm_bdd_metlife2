package com.metlife.steps;

import com.metlife.base.AutomationHooks;
import com.metlife.base.DataTransfer;
import com.metlife.pages.LoginPage;
import com.metlife.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {

    private final AutomationHooks hooks;
    private final DataTransfer transfer;
    private LoginPage loginPage;
    private MainPage mainPage;

    public LoginSteps(AutomationHooks hooks, DataTransfer trasfer) {
        this.hooks = hooks;
        this.transfer = trasfer;
    }

    public void initPageObject() {
        loginPage = new LoginPage(hooks.driver);
        mainPage = new MainPage(hooks.driver);
    }

    @Given("I have browser with orange HRM application")
    public void i_have_browser_with_orange_hrm_application() {

        WebDriverManager.edgedriver().setup();

        hooks.driver = new EdgeDriver();
        hooks.driver.manage().window().maximize();
        hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        hooks.driver.get("https://opensource-demo.orangehrmlive.com/");

        initPageObject();
    }

    @When("I enter username as {string}")
    public void i_enter_username_as(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter password as {string}")
    public void i_enter_password_as(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click on login")
    public void i_click_on_login() {
        loginPage.clickOnLogin();
    }

    @Then("I should not get access to portal with error message {string}")
    public void i_should_not_get_access_to_portal_with_error_message(String expectedError) {

        String actualError = loginPage.getInvalidErrorMessage();
        Assert.assertEquals(actualError, expectedError);
    }

    @Then("I should get access to the portal with menu as {string}")
    public void i_should_get_access_to_the_portal_with_menu_as(String expectedValue) {

        String actualValue = mainPage.getMyInfoMenuText();
        Assert.assertEquals(actualValue, expectedValue);
    }


}
