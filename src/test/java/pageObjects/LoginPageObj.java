package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class LoginPageObj {


	//webElements
	@FindBy(id = "user-name")
	WebElement username;

	@FindBy(id="password")
	WebElement password;

	@FindBy(id="login-button")
	WebElement loginButton;

	@FindBy(xpath="//h3[@data-test='error']")
	WebElement errorMessage;

	//initialize elements
	public LoginPageObj() {
		PageFactory.initElements(BaseClass.driver, this);
	}


	//actionable methods

	public void enterUsername(String uname) {
		username.clear();
		username.sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}

	public void clickLoginbutton() {
		loginButton.click();
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}

}
