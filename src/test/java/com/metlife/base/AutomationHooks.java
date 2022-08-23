package com.metlife.base;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class AutomationHooks {
    public static WebDriver driver;


    @After
    public void endScenario()
    {
        if(AutomationHooks.driver != null)
        {
            AutomationHooks.driver.quit();
        }
    }


}
