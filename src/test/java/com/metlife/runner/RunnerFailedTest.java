package com.metlife.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"@target/rerun.txt"}
        ,glue = {"com.metlife.steps","com.metlife.base"}
        ,publish = true
        ,plugin = {"html:target/cucumber-report.html","rerun:target/rerun.txt"}
        ,tags = "@login"
//        ,dryRun = true
//        ,tags = "not @addemployee and (@valid and @high)"
)
public class RunnerFailedTest extends AbstractTestNGCucumberTests {
}
