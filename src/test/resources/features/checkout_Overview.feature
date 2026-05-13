Feature: Verify checkout:overview page functionalities of saucedemo application.

  Background: User is logged in to the application
    Given User is on the login page
    When User enters  valid username and password
    And User clicks on login button
    Then User should be navigated to the products page
    And User adds a product to the cart
    And User clicks on the shopping cart link
    And User clicks on Checkout button
    Then User should be navigated to the Checkout:Your Information page
    And  User enters the firstname, lastname and zipcode
    And User clicks on Continue button
    Then User should be navigated to Checkout: Overview page

  Scenario: Verify the title on the checkout overview page
    Then User should see the title "Checkout: Overview" on the overview page

  Scenario: Verify the product details displayed on the checkout overview page
    Then The product name in overview should match the cart
    And The product description in overview should match the cart
    And The product price in overview should match the cart

@testonly
  Scenario: Verify the price total displayed on the overview page
    Then The total price should match item price plus tax

  Scenario: Verify the Cancel button functionality
    When User clicks on Cancel button
    Then User should be navigated to the product page

  Scenario: Verify the Finish button functionality
    When User clicks on Finish button
    Then User should be navigated to the checkout confirmation page
