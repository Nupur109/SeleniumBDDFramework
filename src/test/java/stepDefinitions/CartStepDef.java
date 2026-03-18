package stepDefinitions;

import java.time.Duration;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPageObj;
import pageObjects.ProductsPageObj;
import utils.Utility;

public class CartStepDef {

	ProductsPageObj products=new ProductsPageObj();
	CartPageObj cart= new CartPageObj();


	@When("User clicks on Continue Shopping button")
	public void user_clicks_on_continue_shopping_button() {
		cart.clickContinueShopping();
		BaseClass.test.info("User clicks on Continue Shopping button");

	}

	@Then("User should see the title {string} on the page")
	public void user_should_see_the_title_on_the_page(String string) {
		Assert.assertEquals(cart.getCartPageTitle(),string);
		BaseClass.test.info("User see the title on the page as: "+string);
	}

	@Then("The product should be removed from the cart")
	public void the_product_should_be_removed_from_the_cart() throws InterruptedException {
		Assert.assertTrue(cart.isCartItemRemoved(),"Cart item is not removed");
		BaseClass.test.info("The items added to cart are removed");

	}
			
	@Then("Cart page should display {int} items")
	public void cart_page_page_should_display_items(Integer count) {
		Assert.assertEquals(cart.cartItemsCount(), count);	
		BaseClass.test.info("Cart page displays "+count+ " items");
	
	}

	@When("User clicks on Checkout button")
	public void user_clicks_on_checkout_button() {
		cart.clickCheckoutButton();
		BaseClass.test.info("User clicks on checkout button");
	}
	@Then("User should be navigated to the Checkout:Your Information page")
	public void user_should_be_navigated_to_the_checkout_your_information_page() {
		String checkoutPageUrl="https://www.saucedemo.com/checkout-step-one.html";
		Assert.assertEquals(Utility.getPageURL(), checkoutPageUrl);
		BaseClass.test.info("User navigates to the Checkout:Your Information page");

	}

	@Then("The product name in cart should match the products page")
	public void the_product_name_in_cart_should_match_the_products_page() {
		Assert.assertEquals(products.getFirstProductName(), cart.getProductName());
		BaseClass.test.info("The product name in cart matches the products page: "+ cart.getProductName());

	}
	
	@Then("The product price in cart should match the products page")
	public void the_product_price_in_cart_should_match_the_products_page() {
		Assert.assertEquals(products.getFirstProductPrice(), cart.getProductPrice());
		BaseClass.test.info("The product price in cart matches the products page: "+ cart.getProductPrice());

	}
	@Then("The product description in cart should match the products page")
	public void the_product_description_in_cart_should_match_the_products_page() {
		Assert.assertEquals(products.getFirstProductDescription(), cart.getProductDescription());
		BaseClass.test.info("The product description in cart matches the products page: "+ cart.getProductDescription());

	}

}
