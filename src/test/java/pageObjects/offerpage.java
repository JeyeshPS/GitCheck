package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class offerpage 
{
	public static WebElement offerpagelink(WebDriver driver)
	{
		return driver.findElement(By.linkText("Top Deals"));
	}
	
	public static WebElement offerpagesearch(WebDriver driver)
	{
		return driver.findElement(By.xpath("//div[@class='col-xs-4']/descendant::input"));
	}
	
	public static WebElement offerpagetext(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//table[@class='table table-bordered']/tbody/tr/td)[1]"));
	}
}
