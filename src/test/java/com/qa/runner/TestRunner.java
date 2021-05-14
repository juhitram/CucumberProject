package com.qa.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/qa/features/valuesPage.feature",
		glue = {"com/qa/stepDefinitions"},
		monochrome = true,
		strict = true,
		dryRun = false,
		/*
						 * plugin = {"pretty", "json:target/MyReports/report.json",
						 * "junit:target/MyReports/Cucumber.xml"}
						 */
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
				
		tags = {"@smoketest","@regressiontest"}
		)

public class TestRunner {

}
