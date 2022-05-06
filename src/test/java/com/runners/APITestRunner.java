package com.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        // features = {"src/test/resources/features/PostExample/CreateUserAPITest.feature"},
		features = {"src/test/resources/features/"},
        glue = {"com.stepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","pretty", "html:target/cucumber-reports",
        		  "json:target/cucumber.json"},
        tags={"@API"},
		monochrome = true
)

public class APITestRunner {

}