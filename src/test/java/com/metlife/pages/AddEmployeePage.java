package com.metlife.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage {

    private By firstNameLocator=By.name("firstName");
    private By lastNameLocator=By.name("lastName");
    private WebDriver driver;

    public AddEmployeePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void enterFirstName(String firstname) {

        driver.findElement(firstNameLocator).sendKeys(firstname);
    }

    public void enterLastName(String lastName) {

        driver.findElement(lastNameLocator).sendKeys(lastName);
    }
}
