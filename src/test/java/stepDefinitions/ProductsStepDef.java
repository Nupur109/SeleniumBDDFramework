package stepDefinitions;
import java.util.List;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProductsPageObj;

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

	@Then("Each product should display image")
	public void each_product_should_display_image() {
		products.isProductImagesDisplayed();
		Assert.assertTrue(products.isProductImagesDisplayed(),"The product images are not displayed");
		BaseClass.test.info("User see image for each product");
	}

	@Then("Each product should display name")
	public void each_product_should_display_name() {
		products.isProductNamesDisplayed();
		Assert.assertTrue(products.isProductNamesDisplayed(),"The product names are not displayed");

		BaseClass.test.info("User see name for each product");

	}

	@Then("Each product should display price")
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

	@Then("Cart count should show {string}")
	public void cart_count_should_show(String expectedCount) {
		String actualCount=products.getCartBadgeValue();
		Assert.assertEquals(actualCount, expectedCount);
		BaseClass.test.info("Cart count shows : "+expectedCount);

	}

	@When("User removes the product from cart")
	public void user_removes_the_product_from_cart() throws InterruptedException {
		products.clickRemove();
		BaseClass.test.info("Product is removed from cart");

	}

	@Then("Cart count should not be displayed")
	public void cart_count_should_not_be_displayed() {
		Assert.assertFalse(products.isCartBadgePresent(),"Cart count still visible");
		BaseClass.test.info("Cart badge is not displayed");

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


}