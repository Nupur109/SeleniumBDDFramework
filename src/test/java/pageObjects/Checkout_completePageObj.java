package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Checkout_completePageObj {
	
	@FindBy(className="title")
	WebElement confirmationPageTitle;
	
	@FindBy(className="complete-header")
	WebElement confirmationHeader;
	
	@FindBy(className="complete-text")
	WebElement confirmationTextMessage;
	
	@FindBy(id="back-to-products")
	WebElement backHomeButton;
	
	//instantiate or initialize elements
	
	public Checkout_completePageObj() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	//methods
	
	public String getconfirmationPageTitle() {
		return confirmationPageTitle.getText();
	}
	
	public String getConfirmationHeader() {
		return confirmationHeader.getText();
	}
	
	public String getConfirmationText() {
		return confirmationTextMessage.getText();
	}
	
	public void clickBackHomeButton() {
		backHomeButton.click();
	}
	

}
