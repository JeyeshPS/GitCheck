package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Cart;
import pageObjects.homepage;
import utlities.BackgroudColor;
import utlities.BrowseInitialization;
import utlities.ObjectCreation;


public class StepDefinitionCart 
{
	private final ObjectCreation oc;
	int count = 1;	
	WebDriverWait wait;
	String productname;
	String homepagetext;
	
	//private WebDriver driver = BrowseInitialization.browser();
	
	public StepDefinitionCart(ObjectCreation occ)
	{
		this.oc=occ;
	}
	
	@SuppressWarnings("static-access")
	@Given("User should able to search and select the product {string} in the homepage")
	public void user_should_able_to_search_and_select_the_product_in_the_homepage(String string) throws InterruptedException 
	{
		homepage.homepagesearch(oc.getDriver()).sendKeys(string);
		Thread.sleep(3000);
		homepagetext = homepage.homepagetext(oc.getDriver());
		System.out.println("homepage text: "+homepagetext);
	}
	
	@When("user should able to select the required quantity {int} usign plus symbol")
	public void user_should_able_to_select_the_required_quantity_usign_plus_symbol(Integer int1) 
	{			
		while(count<int1)
		{
			BrowseInitialization.Wait(oc.getDriver()).until(ExpectedConditions.visibilityOf(homepage.plus(oc.getDriver()))).click();
			count++;
		}	    
	}
	@Then("User added items to the cart using add to cart option")
	public void user_added_items_to_the_cart_using_add_to_cart_option() 
	{
		BrowseInitialization.Wait(oc.getDriver()).until(ExpectedConditions.visibilityOf(homepage.btn_addtocart(oc.getDriver()))).click();
	}
	@Then("post addition check the button is changed to orange color and button changed to added")
	public void post_addition_check_the_button_is_changed_to_orange_color_and_button_changed_to_added() 
	{
		System.out.println("text "+homepage.btn_addedtocart(oc.getDriver()).getText());
		System.out.println("color"+BackgroudColor.convertRGBAtohex(homepage.col_addedtocart(oc.getDriver())));		
		
	}	
	
	
	@Given("Click on the cart and proceed to checkout")
	public void click_on_the_cart_and_proceed_to_checkout() 
	{
		System.out.println("entered given");
		homepage.btn_cart(oc.getDriver()).click();
		BrowseInitialization.Wait(oc.getDriver()).until(ExpectedConditions.visibilityOf(homepage.btn_proceedtocheckout(oc.getDriver()))).click();
		
	}
	@When("added details should reflect in the cart")
	public void added_details_should_reflect_in_the_cart() 
	{
		homepagetext = homepage.homepagetext(oc.getDriver());
		productname= BrowseInitialization.Wait(oc.getDriver()).until(ExpectedConditions.visibilityOf(Cart.tbl_productname(oc.getDriver(), homepagetext))).getText();
		System.out.println(productname.split(" - ")[0].trim());
	}
	@Then("validate the product name {string} and quantity {int} and price and total")
	public void validate_the_product_name_and_quantity_and_price_and_total(String string, Integer init2) 
	{
		String quantity = BrowseInitialization.Wait(oc.getDriver()).until(ExpectedConditions.visibilityOf(Cart.tbl_quantity(oc.getDriver()))).getText().split(" ")[0].trim();
		System.out.println("qty:"+quantity);
		
		int qty = Integer.parseInt(quantity);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pricess = BrowseInitialization.Wait(oc.getDriver()).until(ExpectedConditions.visibilityOf(Cart.tbl_price(oc.getDriver()))).getText();
		System.out.println("price: "+pricess);
		
		int prce = Integer.parseInt(pricess);
		
		int expectedtotalprice = qty * prce;
		
		String totalprce = BrowseInitialization.Wait(oc.getDriver()).until(ExpectedConditions.visibilityOf(Cart.tbl_totalprice(oc.getDriver(),productname))).getText();
		System.out.println("Total: "+totalprce);
		
		int totalprceint = Integer.parseInt(totalprce);
		
		Assert.assertEquals(totalprceint, expectedtotalprice,"Total price is incorrect");
	}
	@Then("validate whether Apply and place order button is displayed")
	public void validate_whether_apply_and_place_order_button_is_displayed() 
	{
		Assert.assertEquals(Cart.btn_apply(oc.getDriver()).getText(), "Apply","Apply button is not displayed");
		//Assert.assertEquals(Cart.btn_placeorder(oc.getDriver()).getText(), "Place Order","place order is not displayed");
		Assert.assertTrue(Cart.btn_placeorder(oc.getDriver()).getText().contains("Plac"), "Place Order is not displayed");
		
	}
}
