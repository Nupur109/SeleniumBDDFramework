package stepDefinitions;

import java.time.Duration;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPageObj;
import utils.Utility;

public class CheckoutStepDef {

	CheckoutPageObj checkout = new CheckoutPageObj();
	@Then("User should see the title {string} on the checkout page")
	public void user_should_see_the_title_on_the_checkout_page(String expectedPageTitle) {
		String actualPageTitle = checkout.getPageTitle();
		Assert.assertEquals(expectedPageTitle, actualPageTitle);

		BaseClass.test.info("The title on the checkout page is : " + expectedPageTitle);
	}
	
	@Then("User enters the firstname, lastname and zipcode")
	public void when_user_enters_the_firstname_lastname_and_zipcode() {
		String firstName=BaseClass.prop.getProperty("firstName");
		String lastName=BaseClass.prop.getProperty("lastName");
		String zipcode=BaseClass.prop.getProperty("zipcode");
		checkout.enterFirstName(firstName);
		checkout.enterLastName(lastName);
		checkout.enterPostalCode(zipcode);
		BaseClass.test.info("User enters the firstname, lastname and zipcode");

	}
	
	@When("User enters the {string}, {string} and {string}")
	public void user_enters_valid_first_name_last_name_and_zip_code(String fname,String lname,String zcode) {
		checkout.enterFirstName(fname);
		checkout.enterLastName(lname);
		checkout.enterPostalCode(zcode);

	}
	
	@Then("User should be navigated to Checkout: Overview page")
    public void user_should_be_navigated_to_Checkout_Overview_page() {
    	String expectedUrl="https://www.saucedemo.com/checkout-step-two.html";
    	Assert.assertEquals(expectedUrl,Utility.getPageURL());
    }


	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		checkout.clickContinueButton();
	}

	@Then("Verify the {string} displayed as below")
	public void verify_the_errormessage_as_below(String expectedErrorMessage ) throws InterruptedException {
//	Thread.sleep(Duration.ofSeconds(2));
	String actualErrorMessage = checkout.getErrorMessage();
	Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}

	@When("User clicks on Cancel button")
	public void user_clicks_on_cancel_button() {
		checkout.clickCancelButton();
	}

		}
