package utlities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Handles 
{
	public static void Windowhandles(WebDriver driver)
	{
		 Set<String> handles = driver.getWindowHandles();
		    Iterator<String> i1 = handles.iterator();
		    String parentwindow = i1.next();
		    String childwindow = i1.next();
		    
		    driver.switchTo().window(childwindow);
		    //return new String[] {parentwindow, childwindow};
	}
}
