package stepDefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPageObj;
import pageObjects.Checkout_overviewPageObj;
import utils.Utility;

public class Checkout_overviewStepDef {

Checkout_overviewPageObj checkout_overview=new Checkout_overviewPageObj();
CartPageObj cart=new CartPageObj();
	
	@Then("User should see the title {string} on the overview page")
	public void user_should_see_the_title_on_the_overview_page(String string) {
		String expectedTitle=checkout_overview.getTitle();
		String actualTitle="Checkout: Overview";
		Assert.assertEquals(actualTitle, expectedTitle);
		BaseClass.test.info("User see the title on the overview page: "+expectedTitle);
	}

	@Then("The product name in overview should match the cart")
	public void the_product_name_in_overview_should_match_the_cart() {
		Assert.assertEquals(checkout_overview.getProductName(), cart.getProductName());
		BaseClass.test.info("The product name in overview matches the cart");

	}
	
	@Then("The product description in overview should match the cart")
	public void the_product_description_in_overview_should_match_the_cart() {
		Assert.assertEquals(checkout_overview.getProductDescription(), cart.getProductDescription());
		BaseClass.test.info("The product description in overview matches the cart");

	}

	@Then("The product price in overview should match the cart")
	public void the_product_price_in_overview_should_match_the_cart() {
		Assert.assertEquals(checkout_overview.getProductPrice(), cart.getProductPrice());
		BaseClass.test.info("The product price in overview matches the cart");

	}

	@Then("The total price should match item price plus tax")
	public void the_total_price_should_match_item_price_plus_tax() {
		double expectedTotalPrice = Double.parseDouble(checkout_overview.getTotalPrice().replace("Total: $", "").trim());
		double itemTotalPrice = Double.parseDouble(checkout_overview.getItemTotal().replace("Item total: $", "").trim());

		double taxPrice = Double.parseDouble(checkout_overview.getTotalPrice().replace("Tax: $", "").trim());
				
		System.out.println(expectedTotalPrice + expectedTotalPrice + expectedTotalPrice);
		double actualTotalPrice = taxPrice + itemTotalPrice;
		System.out.println(actualTotalPrice);
		Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
		
		BaseClass.test.info("User see the total price on the overview page: "+expectedTotalPrice);
	
	}

	@When("User clicks on Finish button")
	public void user_clicks_on_finish_button() {
		checkout_overview.clickFinishButton();
	}
	
	@Then("User should be navigated to the checkout confirmation page")
	public void user_should_be_navigated_to_the_checkout_confirmation_page() {
		String expectedConfirmationPageUrl=Utility.getPageURL();
		String actualConfirmationPageUrl="https://www.saucedemo.com/checkout-complete.html";
		
		Assert.assertEquals(actualConfirmationPageUrl, expectedConfirmationPageUrl);
		
		BaseClass.test.info("User is navigated to the checkout confirmation page");

	
	}


}
