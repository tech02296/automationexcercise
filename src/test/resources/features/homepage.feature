@regression
Feature: In order to explore and interact with the features on the Home Page,
  As a user, I want to perform various actions (verify Test case page, subscription,  and verify corresponding outcomes.
  User can verify Test case page
  User can Verify subscription
  User can verify scroll Up using 'Arrow' button and Scroll Down functionality

  Background:
    Given I am on Home Page.
@author_Mehul @smoke @sanity
  Scenario: User can Fill Contact US Form
    When I click on top menu "Contact us"
    And Verify text "Get In Touch" is visible
    And Enter Name: "Prime", Email: "prime+1@gmail.com", Subject: "cloths" and Message: "I want to buy cloths for women"
    And Upload file
    And I Click "Submit" button
    And I Click "OK" button
    And Verify text "Success! Your details have been submitted successfully." is visible
    Then I Click "Home" button
    And verify that landed to home page successfully.

  @author_Mehul @smoke
  Scenario: User should verify Test cases Page
    When I click on top menu "Test Cases"
    Then Verify text "Test Cases" is visible
  @author_Mehul
  Scenario:  User should added product in cart from Recommended items
    When Scroll down page to "RECOMMENDED ITEMS"
    And Verify that "RECOMMENDED ITEMS" is visible
    And Click Add to Cart on "Stylish Dress" in "Recommended product"
    And Click on "View Cart" button
    Then  Verify that "Stylish Dress" in cart page

  @author_Mehul
  Scenario: User should verify Subscription in on Home page
    And Scroll down page to "SUBSCRIPTION"
    And Verify that "SUBSCRIPTION" is visible
    And  Enter email "prime123@gmail.com" in input and click arrow button
    Then Verify that "You have been successfully subscribed!" is visible
  @author_Mehul
  Scenario: User should verify scroll Up using 'Arrow' button and Scroll Down functionality.
    And Scroll down page to "SUBSCRIPTION"
    And Verify that "SUBSCRIPTION" is visible
    And Click on arrow at bottom right side to move upward
    And Verify that page is scrolled up and "Full-Fledged practice website for Automation Engineers" text is visible on screen
  @author_Mehul
  Scenario: User should verify Scroll Up without 'Arrow' button and Scroll Down functionality
    And Scroll down page to "SUBSCRIPTION"
    And Verify that "SUBSCRIPTION" is visible
    And Scroll up page to top
    Then Verify that page is scrolled up and "Full-Fledged practice website for Automation Engineers" text is visible on screen
