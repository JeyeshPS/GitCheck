package utlities;

import org.openqa.selenium.WebDriver;

public class ObjectCreation 
{
	//public WebDriver driver;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static String homepagetxt;
	public String offertxt;
	
	public ObjectCreation()
	{		
		if(driver.get()==null)
		{
			BrowseInitialization bri = new BrowseInitialization();
			//driver = bri.browser();
			driver.set(bri.browser());
		}		
	}
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}
		
}
