package testrunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class TestTunnerFailedScenarios 
{
	@CucumberOptions(
			features = "@target/failed_Scenarios.txt", 
			glue = {"stepDefinition","utlities"},
			plugin = {"pretty",
					   "html:target/htmlreporter.html",
					   "json:target/jsonreporter.json",
					   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
					   },
			monochrome = true
			)
	public class TestNgRunner extends AbstractTestNGCucumberTests
	{
		
		@Override
		@DataProvider(parallel=true)
		public Object [][] scenarios()
		{
			return super.scenarios();
		}
	}
}
