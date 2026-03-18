Feature: Verify the functionalitties of cart page of SauceDemo Application

  Background: User is logged in to the application
    Given User is on the login page
    When User enters  valid username and password
    And User clicks on login button
    Then User should be navigated to the product page

  Scenario: Verify the title on the Cart page
    When User clicks on the shopping cart link
    Then User should be navigated to the cart page
    And User should see the title "Your Cart" on the page

  Scenario: Verify the product details added to the cart page
    When User clicks on the Add to Cart button
    And User clicks on the shopping cart link
    Then The product name in cart should match the products page
    And The product price in cart should match the products page
    And The product description in cart should match the products page

  Scenario: Verify the Remove button functionality of the cart
    When User clicks on the Add to Cart button
    And User clicks on the shopping cart link
    And User clicks on the remove button
    Then The product should be removed from the cart

  Scenario: Verify the Continue Shopping button functionality
    When User clicks on the shopping cart link
    And User clicks on Continue Shopping button
    Then User should be navigated to the product page

  Scenario: Verify the Checkout button functionality
    When User clicks on the Add to Cart button
    And User clicks on the shopping cart link
    And User clicks on Checkout button
    Then User should be navigated to the Checkout:Your Information page

  Scenario Outline: Verify the cart page after adding multiple items
    When User adds <count> products to the cart
    And User clicks on the shopping cart link
    Then Cart page should display <count> items
    And Cart badge should display <count>

    Examples:
      | count |
      | 1     |
      | 3     |
      | 6     |
