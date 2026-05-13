package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class CheckoutPageObj {


	@FindBy(className="title")
	WebElement pageTitle;

	@FindBy(id="first-name")
	WebElement firstName;

	@FindBy(id="last-name")
	WebElement lastName;

	@FindBy(id="postal-code")
	WebElement zipCode;

	
	@FindBy(xpath="//div[@class='error-message-container error']")
	WebElement errorMessage;
	
//	@FindBy(xpath="//h3[text()='Error: First Name is required']")
//	WebElement error_firstName;
//
//	@FindBy(xpath="//h3[text()='Error: Last Name is required']")
//	WebElement error_lastName;
//
//	@FindBy(xpath="//h3[text()='Error: Postal Code is required']")
//	WebElement error_zipCode;


	@FindBy(id="continue")
	WebElement continueButton;


	@FindBy(id="cancel")
	WebElement cancelButton;



	public CheckoutPageObj() {
		PageFactory.initElements(BaseClass.driver, this);

	}

	public String getPageTitle() {
		return pageTitle.getText();

	}

	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void enterPostalCode(String pcode) {
		zipCode.sendKeys(pcode);
	}

	public String getErrorMessage() {
		return errorMessage.getText();
		}
	
//
//	public String getFirstNameErrorMsg() {
//		return error_firstName.getText();
//	}
//
//	public String getLastNameErrorMsg() {
//		return error_lastName.getText();
//	}
//
//	public String getPostalCodeErrorMsg() {
//		return error_zipCode.getText();
//	}

	public void clickContinueButton() {
		continueButton.click();

	}
	public void clickCancelButton() {
		cancelButton.click();
	}



}
