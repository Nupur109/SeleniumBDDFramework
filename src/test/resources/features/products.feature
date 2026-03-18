Feature: Products page functionalities of Sauce Demo application

  Background: User is logged in to the application
    Given User is on the login page
    When User enters  valid username and password
    And User clicks on login button
    Then User should be navigated to the product page

  Scenario: Verify Products title on the products page
    Then User should see "Products" as the page title

  Scenario: Verify the products are displayed on the products page
    Then User should see the products on the page


  Scenario: Verify product information is displayed
    Then Each product should display the product name
    And Each product should display the product image
    And Each product should display the product decription
    And Each product should display the product price
    And Each product should display Add to Cart button

  Scenario: Verify the sort dropdown displayed with all options
    Given User should see sort dropdown
    When User clicks on the dropdown
    Then User should see sort dropdown with following options
      | Name (A to Z)       |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |

  Scenario: Verify Sort products by price low to high
    When User selects the sort option "Price (low to high)"
    Then Products should be sorted as low price to high price
    
    
  Scenario: Verify Add to Cart button
  When User clicks on the Add to Cart button
  Then Cart count should show "1"
  
  
  Scenario Outline: Verify the cart badge count after adding multiple items
    When User adds <count> products to the cart
    Then Cart badge should display <count> 
     Examples:
    |	count	|
	|	  2		|
	|	  4		|
	|	  6		|
  
  @testonly
    Scenario: Remove product from cart
    When User clicks on the Add to Cart button
	And User clicks on the remove button
    Then Cart count should not be displayed

    Scenario: Verify the Shopping cart link
    When User clicks on the shopping cart link
    Then User should be navigated to the cart page