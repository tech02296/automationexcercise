@regression
Feature: Login Feature
  User have to perform Successfully Login
  User can Login with incorrect email and password
  User can  Place Order: Login before Checkout

  Background:
    Given I am on Home Page.
    When I click on top menu "Signup / Login"
    And Verify "Login to your account" is visible
  @author_Mehul @smoke @sanity
  Scenario: User should Login Successfully
    And I enter email: "primeIRir@gmail.com" and password: "Prime@123"
    And I click "login" button
    And Verify that "Logged in as Prime" visible.
    And I click on top menu "Delete Account"
    Then Verify that "ACCOUNT DELETED!" is visible and click "Continue" button
  @author_Mehul @smoke
  Scenario: User should Login with incorrect email and password
    And I enter email: "primeUx842@gmail.com" and password: "Prime@123"
    And I click "login" button
    Then Verify that "Your email or password is incorrect!" visible.
  @author_Mehul
  Scenario: User should Logout Successfully
    And I enter email: "primeUx84@gmail.com" and password: "Prime@123"
    And I click "login" button
    And Verify that "Logged in as Prime" visible.
    And I click on top menu "Logout"
    Then Verify "Login to your account" is visible
    And Verify that user is navigated to login page
