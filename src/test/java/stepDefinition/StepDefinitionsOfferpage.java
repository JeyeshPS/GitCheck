package stepDefinition;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import pageObjects.offerpage;
import utlities.Handles;
import utlities.ObjectCreation;

public class StepDefinitionsOfferpage 
{
	
	private final ObjectCreation occ;
	public StepDefinitionsOfferpage(ObjectCreation oc)
	{
		this.occ=oc;
	}
	
	@Then("^user search with smart search with three letter (.+) of product in offer page$")
	public void user_search_with_smart_search_with_three_letter_of_product_in_offer_page(String name)  
	{
		
		offerpage.offerpagelink(occ.getDriver()).click();
		Handles.Windowhandles(occ.getDriver());
	    
	    offerpage.offerpagesearch(occ.getDriver()).sendKeys(name);
	    occ.offertxt = offerpage.offerpagetext(occ.getDriver()).getText();
	    System.out.println("offerpage: "+occ.offertxt);  
	    
	}
	@Then("Check whether smart search letter matches with product")
	public void check_whether_smart_search_letter_matches_with_product() 
	{
		Assert.assertEquals(occ.homepagetxt, occ.offertxt);				
	}
}
