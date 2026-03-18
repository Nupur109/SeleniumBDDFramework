package stepDefinitions;
import java.time.Duration;
import java.util.List;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProductsPageObj;
import utils.Utility;

public class ProductsStepDef {

	ProductsPageObj products = new ProductsPageObj();


	@Then("User should see {string} as the page title")
	public void user_should_see_the_as_the_page_title(String string) {
		
		Assert.assertEquals(products.getPageTitle(), string);
		BaseClass.test.info("User verifies the page title : "+products.getPageTitle());

	}

	@Then("User should see the products on the page")
	public void user_should_see_the_products_on_the_page() {

		Assert.assertTrue(products.isProductsDisplayed(),"The products are not displayed");
		BaseClass.test.info("User see the products on the landing page");

	}

	@Then("Each product should display the product image")
	public void each_product_should_display_image() {
		products.isProductImagesDisplayed();
		Assert.assertTrue(products.isProductImagesDisplayed(),"The product images are not displayed");
		BaseClass.test.info("User see image for each product");
	}

	@Then("Each product should display the product name")
	public void each_product_should_display_the_product_name() {
		products.isProductNamesDisplayed();
		Assert.assertTrue(products.isProductNamesDisplayed(),"The product names are not displayed");

		BaseClass.test.info("User see name for each product");

	}
	
	@Then("Each product should display the product decription")
	public void each_product_should_display_description() {
		products.isProductDescDisplayed();
		Assert.assertTrue(products.isProductDescDisplayed(),"The product description are not displayed");

		BaseClass.test.info("User see description for each product");

	}


	@Then("Each product should display the product price")
	public void each_product_should_display_price() {
		products.isProductPricesDisplayed();
		Assert.assertTrue(products.isProductPricesDisplayed(),"The product prices are not displayed");

		BaseClass.test.info("User see price for each product");

		
	}

	@Then("Each product should display Add to Cart button")
	public void each_product_should_display_add_to_cart_button() {
		products.isProductAddToCartButtonDisplayed();
		Assert.assertTrue(products.isProductAddToCartButtonDisplayed(),"The product Add To Cart buttons are not displayed");

		BaseClass.test.info("User see Add to Cart button for each product");

	}

	@Given("User should see sort dropdown")
	public void user_should_see_sort_dropdown() {
		products.isSortDropdownDisplayed();
		Assert.assertTrue(products.isSortDropdownDisplayed(),"The sort dropdown is not displayed");

		BaseClass.test.info("User see sort dropdown on the page");

	}

	@When("User clicks on the dropdown")
	public void user_clicks_on_the_dropdown() {
		products.clickSortDropdown();
		BaseClass.test.info("User clicks on the dropdown");

	}

	@Then("User should see sort dropdown with following options")
	public void user_should_see_sort_dropdown_with_following_options(DataTable dataTable) {
		List<String> expectedOptions = dataTable.asList();
		System.out.println("Options are : "+expectedOptions);
		List<String> actualOptions=products.getFilterOptions();
		Assert.assertEquals(actualOptions, expectedOptions);
		
		BaseClass.test.info("User see sort dropdown with following options : "+expectedOptions);

	}

	@When("User clicks on the Add to Cart button")
	public void user_clicks_on_the_add_to_cart_button() throws InterruptedException {

		products.clickAddToCartButton();
		BaseClass.test.info("User clicks on the Add to Cart button");

	}

	@Then("Cart count should show {int}")
	public void cart_count_should_show(int expectedCount) {
		int actualCount=products.getCartBadgeValue();
		Assert.assertEquals(actualCount, expectedCount);
		BaseClass.test.info("Cart count shows : "+expectedCount);

	}
	
	@When("User adds {int} products to the cart")
	public void user_adds_products_to_the_cart(Integer count) throws InterruptedException {
		products.addMultipleItemstoCart(count);
		BaseClass.test.info("User adds "+count+" products to the cart");

	}
	
	@Then("Cart badge should display {int}")
	public void cart_badge_should_display(Integer value) {
		int cartBadgeValue=products.getCartBadgeValue();
		Assert.assertEquals(cartBadgeValue, value);
		BaseClass.test.info("Cart badge displays " + value);

	}


	@When("User clicks on the remove button")
	public void user_clicks_on_the_remove_button() throws InterruptedException {
		//Thread.sleep(Duration.ofSeconds(3));

		products.clickRemove();
		BaseClass.test.info("Product is removed from cart");

	}

	@Then("Cart count should not be displayed")
	public void cart_count_should_not_be_displayed() {
		Assert.assertTrue(products.isCartBadgeRemoved(),"Cart count still visible");
		BaseClass.test.info("Cart badge is removed");

	}

	@When("User selects the sort option {string}")
	public void user_selects_the_sort_option(String string) {
		products.selectSortOption(string);
		
		BaseClass.test.info("User selects the sort option : "+string);

	}

	@Then("Products should be sorted as low price to high price")
	public void Products_should_be_sorted_as_low_price_to_high_price() {
		Assert.assertTrue(products.comparePrices(),"The products are not sorted as Price (low to high) ");
		BaseClass.test.info("Products are sorted as low price to high price");

	}

	@When("User clicks on the shopping cart link")
	public void user_clicks_on_the_shopping_cart_link() {
		products.clickCartLink();
		BaseClass.test.info("Shopping cart link is clicked");

		
	}
	
	@Then("User should be navigated to the cart page")
	public void user_should_be_navigated_to_the_cart_page() {
		Assert.assertEquals(Utility.getPageURL(), "https://www.saucedemo.com/cart.html");
		BaseClass.test.info("User is navigated to the cart page");

	}
	
	
}