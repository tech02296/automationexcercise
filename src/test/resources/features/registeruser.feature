@regression
Feature: Register Feature
  User have to perform Successfully Register
  User can register with existing email
  User can Place Order: Register before Checkout

  Background:
    Given I am on Home Page.
    When I click on top menu "Signup / Login"
  @author_Mehul @smoke @sanity
  Scenario: User can Register successfully.
    And Verify that "New User Signup!" visible.
    And I Enter "Prime" and email address.
    And I Click on "Signup" button.
    And Verify that "ENTER ACCOUNT INFORMATION" visible.
    And Fill Details: Title: "Mrs",Name,Email,Password: "Prime@123",Date of Birth: "15/November/2000", FirstName: "Prime", LastName: "Test",Company: "Prime",Address: "Alexendra Road",Country: "India", State: "Rajasthan", City: "Jaypur", Zipcode: "382350",Mobile Number: "9123453254"
    And Select checkbox "Sign up for our newsletter!"
    And Select checkbox "Receive special offers from our partners!"
    And I Click on "Create Account" button.
    And Verify that "ACCOUNT CREATED!" visible.
    And I Click on "Continue" button.
    And Verify that "Logged in as Prime" visible.
    And I click on top menu "Delete Account"
    Then Verify that "ACCOUNT DELETED!" is visible and click "Continue" button
  @author_Mehul @smoke
  Scenario: User should register with existing email
    And Verify that "New User Signup!" visible.
    And I Enter "Prime" and email: "primeUx84@gmail.com"
    And I Click on "Signup" button.
    Then Verify that "Email Address already exist!" visible.
  @author_Mehul
  Scenario: User should verify address details in checkout page
    And I Enter "Prime" and email address.
    And I Click on "Signup" button.
    And Verify that "ENTER ACCOUNT INFORMATION" visible.
    And Fill Details: Title: "Mr",Name,Email,Password: "Prime@123",Date of Birth: "15/November/2009", FirstName: "Prime", LastName: "Test",Company: "Prime",Address: "Alexendra Road",Country: "Uk", State: "Middlesex", City: "London", Zipcode: "Ha2 9uh",Mobile Number: "123453254"
    And Select checkbox "Sign up for our newsletter!"
    And Select checkbox "Receive special offers from our partners!"
    And I Click on "Create Account" button.
    And Verify that "ACCOUNT CREATED!" visible.
    And I Click on "Continue" button.
    And Verify that "Logged in as Prime" visible.
    And Click Add to Cart on "Blue Top" in "FEATURES ITEMS"
    And I click on top menu "Cart"
    And Verify that "Shopping Cart" page is displayed
    And I Click on "Proceed To Checkout"
    And Verify that the "DELIVERY" address Title: "Mr",FirstName: "Prime", LastName: "Test",Address: "Alexendra Road",Country: "Uk", State: "Middlesex", City: "London", Zipcode: "Ha2 9uh",Mobile Number: "123453254" is same filled at the time registration of account
    And Verify that the "BILLING" address Title: "Mr",FirstName: "Prime", LastName: "Test",Address: "Alexendra Road",Country: "Uk", State: "Middlesex", City: "London", Zipcode: "Ha2 9uh",Mobile Number: "123453254" is same filled at the time registration of account
    And I click on top menu "Delete Account"
    Then Verify that "ACCOUNT DELETED!" is visible and click "Continue" button