package stepDefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPageObj;

public class LoginStepDef {
	
	LoginPageObj login = new LoginPageObj();
	
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		String title = BaseClass.driver.getTitle();
		Assert.assertEquals(title, "Swag Labs");
		BaseClass.test.info("User is on the login page");
		
		
	}
				
	
	@When("User enters  valid username and password")
	public void user_enters_valid_username_and_password() {
		
		String uname=BaseClass.prop.getProperty("username");
		String pwd=BaseClass.prop.getProperty("password");
		login.enterUsername(uname);
		login.enterPassword(pwd);
		BaseClass.test.info("User enters  valid username and password");
	 }
	
	
	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
	   
		login.clickLoginbutton();
		BaseClass.test.info("User clicks on login button");
	}
	
	@Then("User should be navigated to the product page")
	public void user_should_be_navigated_to_the_product_page() {
	   
		String url=BaseClass.driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html");
		BaseClass.test.info("User is navigated to the product page");
	}

	@When("User enters invalid username and password")
	public void user_enters_invalid_username_and_password() {
		
		String uname=BaseClass.prop.getProperty("invalid_uname");
		String pwd=BaseClass.prop.getProperty("invalid_pwd");
		login.enterUsername(uname);
		login.enterPassword(pwd);
		BaseClass.test.info("User enters invalid username and password");

	}
	
	
	@Then("User should see an error message")
	public void user_should_see_an_error_message() {
	    String errorMessage=login.getErrorMessage();
	    
	    Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
	    
		BaseClass.test.info("User see an error message : " + errorMessage);

	    		}


}
