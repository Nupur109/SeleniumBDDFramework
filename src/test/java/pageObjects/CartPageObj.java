package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class CartPageObj {
	@FindBy(className="title")
	WebElement cartPageTitle;
	
	@FindBy(className="shopping_cart_badge")
	WebElement cartBadge;
	
	@FindBy(id="checkout")
	WebElement checkout;

	@FindBy(id="continue-shopping")
	WebElement continueShopping;
	
	@FindBy(className="cart_item") 
	List<WebElement> cartItem;
	
	@FindBy(className = "inventory_item_name")
	WebElement cart_productName;
	
	@FindBy(className="inventory_item_desc")
	WebElement cart_productDescription;

	@FindBy(className = "inventory_item_price")
	WebElement cart_productPrice;
	
	@FindBy(xpath = "//button[text()='Remove']")
	WebElement removeButton;


	//element initialization
	public CartPageObj() {
		PageFactory.initElements(BaseClass.driver, this);

	}

	//methods

	public String getCartPageTitle() {
		return cartPageTitle.getText();
	}

	public void clickCheckoutButton() {
		checkout.click();	}
	
	public void clickContinueShopping() {
		continueShopping.click();
		
	}
	
	public boolean isCartItemRemoved() {
		return cartItem.size()==0;
		
	}
	
	public int cartItemsCount() {
		return cartItem.size();
	}

	public String getProductName() {
		return cart_productName.getText();
	}
	
	public String getProductPrice() {
		return cart_productPrice.getText();
	}
	
	public String getProductDescription() {
		return cart_productDescription.getText();
	}
	
}