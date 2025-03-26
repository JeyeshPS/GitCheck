package utlities;


import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks 
{
	  
	@AfterStep
	public void failurescreenshot(Scenario scenario) throws IOException
	{
		/*
		if(scenario.isFailed())
		{
			TakesScreenshot screens = (TakesScreenshot) ObjectCreation.getDriver();
			File srcfile = screens.getScreenshotAs(OutputType.FILE);
			LocalDateTime currentdate = LocalDateTime.now();
			DateTimeFormatter formatdate = DateTimeFormatter.ofPattern("d-MMM-yyyy hh-mm-ss");
			String timestamp = currentdate.format(formatdate);
			File descfile = new File("./test-output/Screenshots"+timestamp+".png");
			FileUtils.copyFile(srcfile, descfile);
		}*/
		if(scenario.isFailed())
		{
			TakesScreenshot screens = (TakesScreenshot) ObjectCreation.getDriver();
			File srcfile = screens.getScreenshotAs(OutputType.FILE);
			byte[] filet = FileUtils.readFileToByteArray(srcfile);
			scenario.attach(filet, "image/png", "image");
			
			
		}
	}
	
    @After
    public void teardown()
    {
    	ObjectCreation.getDriver().quit();
    	
    }
}
