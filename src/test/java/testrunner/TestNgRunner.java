package testrunner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utlities.RetryAnalyser;
	
	@CucumberOptions(
			features = "src/test/java/features", 
			glue = {"stepDefinition","utlities"},
			plugin = {"pretty",
					   "html:target/htmlreporter.html",
					   "json:target/jsonreporter.json",
					   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					   "rerun:target/failed_Scenarios.txt"},
			monochrome = true
			)
	//@Listeners(utlities.RetryAnalyser.class)
	public class TestNgRunner extends AbstractTestNGCucumberTests
	{
		
		@Override
		@DataProvider(parallel=true)
		public Object [][] scenarios()
		{
			return super.scenarios();
		}
		
		/*
		@Test(retryAnalyzer = RetryAnalyser.class)  // Attach RetryAnalyzer
	    public void runCucumberTests() {
	       return super.run();
	    }*/
	}
