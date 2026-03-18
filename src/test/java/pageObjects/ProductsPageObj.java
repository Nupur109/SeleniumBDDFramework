package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class ProductsPageObj {

	// locators
	@FindBy(xpath = "//span[@class='title']")
	WebElement title;

	@FindBy(className = "inventory_item")
	List<WebElement> products;

	@FindBy(className = "inventory_item_img")
	List<WebElement> productImages;

	@FindBy(className = "inventory_item_name")
	List<WebElement> productNames;
	
	@FindBy(className="inventory_item_desc")
	List<WebElement>productDescription;

	@FindBy(xpath = "//button[text()='Add to cart']")
	List<WebElement> addToCartButtons;

	@FindBy(className = "inventory_item_price")
	List<WebElement> productPrices;

	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement sortDropdown;

	@FindBy(xpath = "//button[text()='Remove']")
	WebElement removeButton;
	
	@FindBy(className="shopping_cart_link")
	WebElement cartLink;

	By cartBadge=By.className("shopping_cart_badge");
	
	By addToCartBtn = By.xpath("//button[text()='Add to cart']");

	
	//initialization

	public ProductsPageObj() {
		PageFactory.initElements(BaseClass.driver, this);

	}

	//methods

	public String getPageTitle() {
		return title.getText();
	}

	public boolean isProductsDisplayed() {
		System.out.print("Number of products displayed : " + products.size());
		return products.size() > 0;

	}

	public boolean isProductImagesDisplayed() {
		for (WebElement image : productImages) {
			if (!image.isDisplayed())
				return false;
		}
		return true;
	}

	public boolean isProductNamesDisplayed() {
		for (WebElement name : productNames) {
			if (!name.isDisplayed())
				return false;
		}
		return true;
	}
	
	public boolean isProductDescDisplayed() {
		for (WebElement desc : productDescription) {
			if (!desc.isDisplayed())
				return false;
		}
		return true;
	}

	public boolean isProductPricesDisplayed() {
		for (WebElement price : productPrices) {
			if (!price.isDisplayed())
				return false;
		}
		return true;
	}

	public boolean isProductAddToCartButtonDisplayed() {
		for (WebElement addToCart : addToCartButtons) {
			if (addToCart.isDisplayed())
				return true;
		}
		return false;
	}

	public boolean isSortDropdownDisplayed() {
		return sortDropdown.isDisplayed();
	}

	public void clickSortDropdown(){
		sortDropdown.click();
	}

	public List<String> getFilterOptions() {
		Select dropdown = new Select(sortDropdown);
		List<String> options = new ArrayList<>();
		for (WebElement option : dropdown.getOptions()) {
			options.add(option.getText());

		}
		return options;
	}

	public void selectSortOption(String option) {
		Select dropdown = new Select(sortDropdown);
		dropdown.selectByVisibleText(option);
	}

	public boolean comparePrices() {
		for(int i =0; i<productPrices.size()-1;i++) {
			if(Double.parseDouble(productPrices.get(i).getText().replace("$", "")) 
					> Double.parseDouble(productPrices.get(i+1).getText().replace("$", "")) ) {
				return false;
			}
		}
		return true;
	}

	public void clickAddToCartButton() {
		addToCartButtons.get(0).click();
	}
	
	public String getFirstProductName() {
		return productNames.get(0).getText();
	}
	
	public String getFirstProductPrice() {
		return productPrices.get(0).getText();
	}
	
	public String getFirstProductDescription() {
		return productDescription.get(0).getText();
	}
	
	public void addMultipleItemstoCart(int count) throws InterruptedException {
		for(int i=0;i<count;i++) {
			BaseClass.driver.findElements(addToCartBtn).get(0).click();
					}
	}

	public int getCartBadgeValue() {
		return Integer.parseInt(BaseClass.driver.findElement(cartBadge).getText());
	} 


	public void clickRemove() {
		removeButton.click();
	}
	public boolean isCartBadgeRemoved() {
		return BaseClass.driver.findElements(cartBadge).size() == 0;
		
	}
	
	public void clickCartLink() {
		cartLink.click();
	}
	
	}