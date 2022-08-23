package com.metlife.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/feature"}
        ,glue = {"com.metlife.steps"}
        ,publish = true
        ,plugin = {"html:target/cucumber-report.html"}
        //,dryRun = true
        ,tags = "@login"
//        ,tags = "not @addemployee and (@valid and @high)"
)

public class RunnerTest extends AbstractTestNGCucumberTests {

}//will start at 2:
