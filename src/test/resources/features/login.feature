Feature: Login functionlity of Saucedemo application

Scenario: Verify login with valid credentials
Given User is on the login page
When User enters  valid username and password
And User clicks on login button
Then User should be navigated to the product page

Scenario: Verify login with invalid credentials
Given User is on the login page
When User enters invalid username and password
And User clicks on login button
Then User should see an error message

