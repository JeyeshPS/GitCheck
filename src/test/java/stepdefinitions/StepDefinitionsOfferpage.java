package stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.offerpage;
import utlities.Datashare;
import utlities.Handles;

public class StepDefinitionsOfferpage 
{
	
	private final Datashare dss;
	public StepDefinitionsOfferpage(Datashare ds)
	{
		this.dss=ds;
	}
	
	@Then("user search with smart search with three letter {string} of product in offer page")
	public void user_search_with_smart_search_with_three_letter_of_product_in_offer_page(String name) 
	{
		offerpage.offerpagelink(dss.driver).click();
		Handles.Windowhandles(dss.driver);
		//String[] window = Handles.Windowhandles(driver);
	    //driver.switchTo().window(window[1]);
	    
	    offerpage.offerpagesearch(dss.driver).sendKeys(name);
	    dss.offertxt = offerpage.offerpagetext(dss.driver).getText();
	    System.out.println("offerpage: "+dss.offertxt);
	    
	    Select select = new Select(offerpage.offerpagesearch(dss.driver));
	    List<WebElement> a = select.getOptions();
	    
	  for (WebElement webElement : a) 
	  {
		System.out.println(webElement.getText());
	  }
	    
	}
	@Then("Check whether smart search letter matches with product")
	public void check_whether_smart_search_letter_matches_with_product() 
	{
		Assert.assertEquals(dss.homepagetxt, dss.offertxt);		
		dss.driver.quit();
	}
}
