package com.metlife.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/feature/Login.feature"}
        ,glue = {"com.metlife.steps"}
        ,publish = true
        ,plugin = {"html:target/cucumber-report.html"}
)

public class RunnerTest extends AbstractTestNGCucumberTests {

}
