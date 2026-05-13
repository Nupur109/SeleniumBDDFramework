package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Checkout_completePageObj;

public class Checkout_completeStepDef {
	
	Checkout_completePageObj confirmationPage = new Checkout_completePageObj();
	
	@Then("User should see the title {string} on the confirmation page")
	public void user_should_see_the_title_on_the_confirmation_page(String string) {
	   String actualConfirmationTitle = confirmationPage.getconfirmationPageTitle();
	   String expectedTitle = "Checkout: Complete!";
	   Assert.assertEquals(actualConfirmationTitle, expectedTitle);
	}

	@Then("User should see the confirmation header on the page")
	public void user_should_see_the_confirmation_header_on_the_page() {
		String actualConfirmationHeader = confirmationPage.getConfirmationHeader();
		   String expectedConfirmationHeader = "Thank you for your order!";
		   Assert.assertEquals(actualConfirmationHeader, expectedConfirmationHeader);
	   
	}
	@Then("User should see the confirmation text below")
	public void user_should_see_the_confirmation_text_below() {
		String actualConfirmationText = confirmationPage.getConfirmationText();
		   String expectedConfirmationText = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		   Assert.assertEquals(actualConfirmationText, expectedConfirmationText);	
	}

	@When("User clicks on the Back Home button")
	public void user_clicks_on_the_back_home_button() {
		confirmationPage.clickBackHomeButton();
	}


}
