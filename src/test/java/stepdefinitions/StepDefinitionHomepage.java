package stepdefinitions;


import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.homepage;
import utlities.ConfigReader;
import utlities.Datashare;


public class StepDefinitionHomepage 
{	
		 
	private final Datashare dss;
	public StepDefinitionHomepage (Datashare ds)
	{
		this.dss=ds;
	}
	
	/*
	private final Datasharesetterandgetter dsg;
	public StepDefinitionHomepage (Datasharesetterandgetter ds)
	{
		this.dsg=ds;
	}
	*/
	
	@Given("User is in greencart page")
	public void user_is_in_greencart_page() 
	{
		WebDriverManager.edgedriver().setup();
		
		/*
		dsg.setDriver(new EdgeDriver());
		dsg.getDriver().get(ConfigReader.URL());
		*/
		
		dss.driver = new EdgeDriver();
		dss.driver.get(ConfigReader.URL());
	    
	}
	@When("user search with smart search with three letter {string} of product and extracted product")
	public void user_search_with_smart_search_with_three_letter_of_product_and_extracted_product(String name) throws InterruptedException 
	{
		
		homepage.homepagesearch(dss.driver).sendKeys(name);		
		Thread.sleep(2000);
		dss.homepagetxt = homepage.homepagetext(dss.driver);		
		System.out.println("homepage: "+dss.homepagetxt);
		
		/*
		homepage.homepagesearch(dsg.getDriver()).sendKeys(name);
		Thread.sleep(2000);
		dsg.setHomepagetxt( homepage.homepagetext(dsg.getDriver())); 
		System.out.println("homepage: "+dsg.getHomepagetxt());
		*/
	   
	}

}
