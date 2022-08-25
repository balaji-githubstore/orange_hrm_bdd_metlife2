package com.metlife.pages;

import com.metlife.base.AutomationKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AutomationKeywords {
    private By adminLocator=By.xpath("//span[text()='Admin']");
    private By myInfoLocator=By.xpath("//*[text()='My Info']");
    private By pimLocator=By.linkText("PIM");

    private WebDriver driver;

    public MainPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
    }

    public void clickOnAdminMenu()
    {
         clickUsingLocator(adminLocator);

    }

    public void clickOnPIMMenu()
    {
        clickUsingLocator(pimLocator);
    }

    public String getAdminMenuText()
    {

        return getTextUsingLocator(adminLocator);
    }

    public String getMyInfoMenuText()
    {
        return getTextUsingLocator(myInfoLocator);
    }
}
