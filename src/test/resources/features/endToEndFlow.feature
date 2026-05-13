Feature: Verify overall end to end flow of saucedemo application.

  Scenario: Verify the e2e flow of saucedemo application
    Given User is on the login page
    When User enters  valid username and password
    And User clicks on login button
    Then User should be navigated to the products page
    And User adds a product to the cart
    Then User clicks on the shopping cart link
    And User clicks on Checkout button
    Then User should be navigated to the Checkout:Your Information page
    And User enters the firstname, lastname and zipcode
    And User clicks on Continue button
    And User clicks on Finish button
    Then User should see the title "Checkout: Complete!" on the confirmation page
    Then User should see the confirmation header on the page
    And User should see the confirmation text below

    

