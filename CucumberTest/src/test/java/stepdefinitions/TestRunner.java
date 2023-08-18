package stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/", 
glue= {"stepdefinitions"},
dryRun = false,
monochrome = true,
//tags= {"@SmokeTest or @DataDriven"},
//strict = true,
plugin = {"pretty", "html:target/HtmlReports/report.html"})
public class TestRunner {
	
	
}