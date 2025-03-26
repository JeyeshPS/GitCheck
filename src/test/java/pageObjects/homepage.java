package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homepage 
{
	static WebElement ele;
	private static By search = By.xpath("//input[@class='search-keyword']");
	private static By text = By.cssSelector("h4.product-name");
	private static By pluxtext = By.xpath("//a[contains(text(),'+')]");
	private static By btn_addtocart = By.xpath("//button[contains(text(),'ADD TO CART')]");
	private static By btn_addedtocart = By.xpath("//button[contains(text(),'ADDED')]");
	private static By btn_cart = By.xpath("//a[@class='cart-icon']/child::img");
	private static By btn_proccedtocheckout = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	
	
	public static WebElement homepagesearch(WebDriver driver)
	{
		return driver.findElement(search);		
		
	}
	
	public static String homepagetext(WebDriver driver)
	{
		return driver.findElement(text).getText().split(" - ")[0].trim();
	}
	
	public static WebElement plus(WebDriver driver)
	{
		return driver.findElement(pluxtext);
	}
	
	public static WebElement btn_addtocart(WebDriver driver)
	{
		return driver.findElement(btn_addtocart);
	}
	
	public static WebElement btn_addedtocart(WebDriver driver)
	{
		
		ele = driver.findElement(btn_addedtocart);
		return ele;
	}
	
	public static String col_addedtocart(WebDriver driver)
	{
		String color = ele.getCssValue("background-color");	
		return color;	
	}
	
	public static WebElement btn_cart(WebDriver driver)
	{
		return driver.findElement(btn_cart);
	}
	
	public static WebElement btn_proceedtocheckout(WebDriver driver)
	{
		return driver.findElement(btn_proccedtocheckout);
	}
}
