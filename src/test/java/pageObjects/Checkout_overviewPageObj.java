package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Checkout_overviewPageObj {
	
	@FindBy(className="title")
	WebElement overviewPageTitle;
	
	@FindBy(className = "inventory_item_name")
	WebElement overview_productName;
	
	@FindBy(className="inventory_item_desc")
	WebElement overview_productDescription;

	@FindBy(className = "inventory_item_price")
	WebElement overview_productPrice;
	
	@FindBy(className = "summary_subtotal_label")
	WebElement itemTotal;
	
	@FindBy(className = "summary_tax_label")
	WebElement tax;
	
	@FindBy(className = "summary_total_label")
	WebElement totalPrice;
		
	@FindBy(id = "finish")
	WebElement finishButton;
	
	//initialize elements
	
	public Checkout_overviewPageObj() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	//methods
	
	public String getTitle() {
		return overviewPageTitle.getText();
	}
	
	public String getProductName() {
		return overview_productName.getText();
	}
	
	public String getProductDescription() {
		return overview_productDescription.getText();
	}
	
	public String getProductPrice() {
		return overview_productPrice.getText();
	}

	public String getItemTotal() {
		return itemTotal.getText();
	} 
	
	public String getTax() {
		return tax.getText();
	}
	
	public String getTotalPrice() {
		return totalPrice.getText();
	} 
	
	public void clickFinishButton() {
		finishButton.click();
	}

}

