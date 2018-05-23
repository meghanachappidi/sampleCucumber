package selenium;

import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.SnippetType;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;

import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/resources/cucumber",glue= "selenium",plugin= {"pretty","json:target/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests {
	@AfterSuite()
	public void teardown() throws Exception {
		CucumberDetailedResults results=new CucumberDetailedResults();
		results.setOutputDirectory("target/");
		results.setOutputName("cucumber");
		results.setSourceFile("target/cucumber.json");
		results.executeDetailedResultsReport(false);
	}
}