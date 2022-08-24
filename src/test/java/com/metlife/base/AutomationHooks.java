package com.metlife.base;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AutomationHooks {
    public WebDriver driver;


    @After
    public void endScenario(Scenario scenario) {

        System.out.println(scenario.getName());
        System.out.println(scenario.isFailed());

        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(bytes, "image/png", scenario.getName());
        }


        if (driver != null) {
            driver.quit();
        }
    }

}
