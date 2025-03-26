package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart 
{
	static WebElement ele;
	static WebElement expected;
	private static By Quantity = By.className("quantity");
	private static By price = By.xpath("(//p[@class='amount'])[1]");
	private static By btn_apply = By.xpath("(//div[@class='promoWrapper']/descendant::*)[2]");
	private static By btn_placeorder = By.xpath("//button[starts-with(text(),'Place')]");
	
	//product-name
	public static WebElement tbl_productname(WebDriver driver, String productname)
	{
		
		System.out.println("product: "+productname);
		ele = driver.findElement(By.xpath("//p[contains(text(),'"+productname+"')]"));
		return ele;
	}
	
	//quantity
	public static WebElement tbl_quantity(WebDriver driver)
	{
		return driver.findElement(Quantity);
	}
	
	//price
	public static WebElement tbl_price(WebDriver driver)
	{
		return driver.findElement(price);
	}
	
	//apply
	public static WebElement btn_apply(WebDriver driver)
	{
		return driver.findElement(btn_apply);
	}
	
	//placeorder
	public static WebElement btn_placeorder(WebDriver driver)
	{
		return driver.findElement(btn_placeorder);
	}
	
	
	//total
	public static WebElement tbl_totalprice(WebDriver driver, String productname)
	{
		
		WebElement table = driver.findElement(By.id("productCartTables"));
		WebElement tableheader = table.findElement(By.tagName("thead"));
		List<WebElement> theader = tableheader.findElements(By.tagName("tr"));
		WebElement row = theader.get(0);
		List<WebElement> headercolumn = row.findElements(By.tagName("td"));
		
		System.out.println("Header count: "+headercolumn.size());
		System.out.println("prod: "+productname);
		int columnindex=0;
		
		for(int i=0; i<headercolumn.size();i++)
		{
			System.out.println(headercolumn.get(i).getText());
			if(headercolumn.get(i).getText().equals("Total"))
			{
				columnindex=i;
				System.out.println("columnindex: "+columnindex);
			}
		}
		
		WebElement tablebody = table.findElement(By.tagName("tbody"));
		List<WebElement> trow = tablebody.findElements(By.tagName("tr"));
		
		for(int i=0; i<trow.size(); i++)
		{
			System.out.println("row size"+trow.size());
			WebElement row1 = trow.get(i);
			List<WebElement> column = row1.findElements(By.tagName("td"));
			for(int j =1; j< column.size();j++)
			{
				
				System.out.println("column size"+column.size());
				try {
					if(column.get(j).getText().contains(productname))
					{
						expected = column.get(columnindex);
						break;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("break chk:"+i);
			
		}	
		
		return expected;
		
	}
}
