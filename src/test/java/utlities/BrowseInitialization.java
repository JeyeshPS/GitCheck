package utlities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowseInitialization 
{
	private  ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public  WebDriver browser()
	{
		if (driver.get() == null) {
			if (ConfigReader.browser().equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver.set(new EdgeDriver());
				driver.get().get(ConfigReader.URL());
				//driver.set(ConfigReader.URL());
			} 
		}
		return driver.get();
	}
	
	public static WebDriverWait Wait(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait;
	}
}
