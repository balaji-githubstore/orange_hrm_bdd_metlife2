package com.metlife.base;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class AutomationHooks {
    public WebDriver driver;


    @After
    public void endScenario()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }

}
