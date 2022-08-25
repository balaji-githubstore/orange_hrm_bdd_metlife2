package com.metlife.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private By adminLocator=By.xpath("//span[text()='Admin']");
    private By myInfoLocator=By.xpath("//*[text()='My Info']");
    private By pimLocator=By.linkText("PIM");

    private WebDriver driver;

    public MainPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickOnAdminMenu()
    {
               driver.findElement(adminLocator).click();

    }

    public void clickOnPIMMenu()
    {
        driver.findElement(pimLocator).click();

    }

    public String getAdminMenuText()
    {
        return driver.findElement(adminLocator).getText();
    }

    public String getMyInfoMenuText()
    {
        return driver.findElement(myInfoLocator).getText();
    }
}
