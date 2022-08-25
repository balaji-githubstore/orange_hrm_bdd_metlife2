package com.metlife.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class AutomationKeywords {
    private WebDriver driver;

    public AutomationKeywords(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickUsingLocator(By locator)
    {
        driver.findElement(locator).click();
    }

    public void typeUsingLocator(By locator,String text)
    {
        driver.findElement(locator).sendKeys(text);
    }

    public String getTextUsingLocator(By locator)
    {
        return driver.findElement(locator).getText();
    }

    public void switchToWindowWithTitle(String title)
    {
        ArrayList<String> windows=new ArrayList<>(driver.getWindowHandles());

        for(String window : windows)
        {
            driver.switchTo().window(window);
            if(driver.getTitle().equals(title))
            {
                break;
            }
        }
    }

    public void switchToWindowWithUrl(String url)
    {
        ArrayList<String> windows=new ArrayList<>(driver.getWindowHandles());

        for(String window : windows)
        {
            driver.switchTo().window(window);
            if(driver.getCurrentUrl().equals(url))
            {
                break;
            }
        }
    }

}
