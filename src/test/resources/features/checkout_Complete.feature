Feature: Verify checkout:complete page functionalities of saucedemo application.

  Background: User is navigated to the checkout complete page of the application
    Given User is on the login page
    When User enters  valid username and password
    And User clicks on login button
    Then User should be navigated to the products page
    And User adds a product to the cart
    And User clicks on the shopping cart link
    And User clicks on Checkout button
    Then User should be navigated to the Checkout:Your Information page
    And User enters the firstname, lastname and zipcode
    And User clicks on Continue button
    And User clicks on Finish button

  Scenario: Verify the title on the checkout complete page
    Given User should be navigated to the checkout confirmation page
    Then User should see the title "Checkout: Complete!" on the confirmation page

  Scenario: Verify that the confirmation message on the page
    Then User should see the confirmation header on the page
    And User should see the confirmation text below

  Scenario: Verify the back Home button on the page
    When User clicks on the Back Home button
    Then User should be navigated to the products page
