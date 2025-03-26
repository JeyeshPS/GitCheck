package stepDefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.homepage;
import utlities.ObjectCreation;


public class StepDefinitionHomepage 
{	
		 
	private final ObjectCreation occ;
	
	public StepDefinitionHomepage (ObjectCreation oc)
	{
		this.occ=oc;
	}

	
	@Given("User is in greencart page")
	public void user_is_in_greencart_page() 
	{
		System.out.println("given");
	}
	@SuppressWarnings("static-access")
	@When("^user search with smart search with three letter (.+) of product and extracted product$")
	public void user_search_with_smart_search_with_three_letter_of_product_and_extracted_product(String name) throws InterruptedException 
	{
		
		homepage.homepagesearch(occ.getDriver()).sendKeys(name);		
		Thread.sleep(2000);
		occ.homepagetxt = homepage.homepagetext(occ.getDriver());		
		System.out.println("homepage: "+occ.homepagetxt);	
	   
	}

}
