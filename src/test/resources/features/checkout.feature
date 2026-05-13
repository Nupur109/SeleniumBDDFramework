Feature: Verify checkout:your information page functionalities of saucedemo application.

  Background: User is logged in to the application
    Given User is on the login page
    When User enters  valid username and password
    And User clicks on login button
    Then User should be navigated to the products page
    And User adds a product to the cart
    And User clicks on the shopping cart link
    And User clicks on Checkout button
    Then User should be navigated to the Checkout:Your Information page

  Scenario: Verify the title on the checkout page
    Then User should see the title "Checkout: Your Information" on the checkout page


  Scenario Outline: Verify the Continue button functionality with valid information
    When User enters the "<FirstName>", "<LastName>" and "<ZipCode>"
    And User clicks on Continue button
    Then User should be navigated to Checkout: Overview page
    
     Examples:
      | FirstName | LastName | ZipCode |
      | testFirst | testLast | 112233  |

  
  
  Scenario Outline: Verify the Continue button functionality with empty fields
    When User enters the "<FirstName>", "<LastName>" and "<ZipCode>"
    And User clicks on Continue button
    Then Verify the "<Error_messages>" displayed as below

    Examples:
      | FirstName | LastName | ZipCode   | Error_messages                 |
      |           | testLast | 112233  	 | Error: First Name is required  |
      | testFirst |          | 112233    | Error: Last Name is required   |
      | testFirst | testLast |           | Error: Postal Code is required |

  Scenario: Verify the Cancel button functionality
    When User clicks on Cancel button
    Then User should be navigated to the cart page
