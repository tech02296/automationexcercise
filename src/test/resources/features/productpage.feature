@regression
Feature: Product page and Product Details
  User can Search product
  User can Verify subscription in Cart page
  User can Added Products in Cart
  User can Verify Product Quantity in Cart
  User can Place Order: Register while Checkout
  User can remove products From Cart
  User can search products and verify cart after login

  Background:
    Given I am on Home Page.
  @author_Mehul @smoke @sanity
  Scenario: User should verify view and cart brand products
    When I click on top menu " Products"
    And Verify that "Brands" are visible on left side bar
    And Click on brand Name "H&M"
    And Verify that user is navigated to "https://automationexercise.com/brand_products/H&M" brand page and verify brand product "BRAND - H&M PRODUCTS" displayed
    And Click on brand Name "MADAME"
    And Verify that user is navigated to "https://automationexercise.com/brand_products/Madame" brand page and verify brand product "BRAND - MADAME PRODUCTS" displayed
  @author_Mehul @smoke
  Scenario: User should verify Product page and Product details
    When I click on top menu " Products"
    And Verify that user is navigated to "ALL PRODUCTS" page successfully
    And Verify that the products list is visible
    And I Click on "View Product" of first product "Blue Top"
    And User is landed to product detail page
    Then Verify that product detail is visible: product name: "Blue Top", category: "Category: Women > Tops", price: "Rs. 500", availability: "Availability: In Stock", condition: "Condition: New" brand: "Brand: Polo"
  @author_Mehul
  Scenario: User should search the product
    When I click on top menu " Products"
    And Verify that user is navigated to "ALL PRODUCTS" page successfully
    And Enter Product name: "Sleeveless" in search input and click "search" button
    And Verify that user is navigated to "SEARCHED PRODUCTS" page successfully
    Then Verify all the products related to search "Sleeveless" are visible
  @author_Mehul
  Scenario: User should verify Subscription in cart page
    When I click on top menu "Cart"
    And Scroll down page to "SUBSCRIPTION"
    And Verify that "SUBSCRIPTION" is visible
    And  Enter email "prime123@gmail.com" in input and click arrow button
    Then Verify that "You have been successfully subscribed!" is visible
  @author_Mehul
  Scenario: User should Added Products in Cart.
    When I click on top menu " Products"
    And Hover over first product "Blue Top" and click "Add to cart"
    And Click on "Continue Shopping" button
    And Hover over first product "Men Tshirt" and click "Add to cart"
    And Click on "View Cart" button
    Then Verify that product name: "Blue Top" prices: "Rs. 500", quantity: "1" and total price: "Rs. 500"
    And Verify that product name: "Men Tshirt" prices: "Rs. 400", quantity: "1" and total price: "Rs. 400"
  @author_Mehul
  Scenario: User Should Verify Product Quantity in Cart
    And I Click on "View Product" of first product "Madame Top For Women"
    And Verify that product detail is visible: product name: "Madame Top For Women", category: "Category: Women > Tops", price: "Rs. 1000", availability: "Availability: In Stock", condition: "Condition: New" brand: "Brand: Madame"
    And Increase quantity to "4"
    And Click "Add to cart" button
    And Click on "View Cart" button
    Then Verify that product name: "Madame Top For Women" prices: "Rs. 1000", quantity: "4" and total price: "Rs. 4000"
  @author_Mehul
  Scenario: User should Place Order: Register while Checkout
    And Click Add to Cart on "Blue Top" in "FEATURES ITEMS"
    And I click on top menu "Cart"
    And Verify that "Shopping Cart" page is displayed
    And page refresh
    And I Click on "Proceed To Checkout"
    And I Click on "Register / Login"
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
    And I click on top menu "Cart"
    And I Click on "Proceed To Checkout"
    And Verify that the "DELIVERY" address Title: "Mr",FirstName: "Prime", LastName: "Test",Address: "Alexendra Road",Country: "Uk", State: "Middlesex", City: "London", Zipcode: "Ha2 9uh",Mobile Number: "123453254" is same filled at the time registration of account
    And Verify that the "BILLING" address Title: "Mr",FirstName: "Prime", LastName: "Test",Address: "Alexendra Road",Country: "Uk", State: "Middlesex", City: "London", Zipcode: "Ha2 9uh",Mobile Number: "123453254" is same filled at the time registration of account
    And Enter description: "I have choose this product." in comment text area and click "Place Order"
    And Enter payment details: Name on Card: "Testing", Card Number: "4701322211111234", CVC:"837", Expiration date:"12/2026"
    And I Click on "Pay and Confirm Order" button
    Then Verify success message "Congratulations! Your order has been confirmed!"
    And I click on top menu "Delete Account"
    And Verify that "ACCOUNT DELETED!" is visible and click "Continue" button
  @author_Mehul
  Scenario: User should remove products From Cart
    And Click Add to Cart on "Blue Top" in "FEATURES ITEMS"
    And I click on top menu "Cart"
    And Verify that "Shopping Cart" page is displayed
    And Click "Blue Top" on X button corresponding to particular product
    Then Verify that product is removed from the cart "Cart is empty! Click here to buy products."
  @author_Mehul
  Scenario: User should view category products
    When Verify that "CATEGORY" are visible on left side bar
    And I Click on any category link "Dress" under "Women" category
    And Verify that category page is displayed and confirm text "WOMEN - DRESS PRODUCTS"
    And I Click on any category link "TSHIRTS" under "Men" category
    Then Verify that category page is displayed and confirm text "MEN - TSHIRTS PRODUCTS"
  @author_Mehul
  Scenario: User should search products and verify cart after login
    When I click on top menu " Products"
    And Verify that user is navigated to "ALL PRODUCTS" page successfully
    And Enter Product name: "Sleeveless" in search input and click "search" button.
    And Verify that user is navigated to "SEARCHED PRODUCTS" page successfully
    And Verify all the products related to search "Sleeveless" are visible
    And I Add those products to cart
    And I click on top menu "Cart"
    And Verify that products are visible in cart
    And I click on top menu "Signup / Login"
    And I enter email: "primeIRir@gmail.com" and password: "Prime@123"
    And I click "login" button
    And I click on top menu "Cart"
    Then Verify that products are visible in cart
  @author_Mehul
  Scenario: User should review on product
    When I click on top menu " Products"
    And Verify that user is navigated to "ALL PRODUCTS" page successfully
    And I Click on "View Product" of first product "Madame Top For Women"
    And Verify that the "WRITE YOUR REVIEW" is visible
    And Enter name: "Prime", email: "primeIRir@gmail.com" and review: "Test Review"
    And I Click on "Submit" button
    Then Verify that the "Thank you for your review." is visible
  @author_Mehul
  Scenario: User should download Invoice after purchase order.
    And Click Add to Cart on "Blue Top" in "FEATURES ITEMS"
    And I click on top menu "Cart"
    And Verify that "Shopping Cart" page is displayed
    And page refresh
    And I Click on "Proceed To Checkout"
    And I Click on "Register / Login"
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
    And I click on top menu "Cart"
    And I Click on "Proceed To Checkout"
    And Verify that the "DELIVERY" address Title: "Mr",FirstName: "Prime", LastName: "Test",Address: "Alexendra Road",Country: "Uk", State: "Middlsex", City: "London", Zipcode: "Ha2 9uh",Mobile Number: "123453254" is same filled at the time registration of account
    And Verify that the "BILLING" address Title: "Mr",FirstName: "Prime", LastName: "Test",Address: "Alexendra Road",Country: "Uk", State: "Middlex", City: "London", Zipcode: "Ha2 9uh",Mobile Number: "123453254" is same filled at the time registration of account
    And Enter description: "I have choose this product." in comment text area and click "Place Order"
    And Enter payment details: Name on Card: "Testing", Card Number: "4701322211111234", CVC:"837", Expiration date:"12/2026"
    And I Click on "Pay and Confirm Order" button
    Then Verify success message "Congratulations! Your order has been confirmed!"
    And Click "Download Invoice" button and verify invoice is downloaded successfully
    And I Click on "Continue" button
    And I click on top menu "Delete Account"
    And Verify that "ACCOUNT DELETED!" is visible and click "Continue" button
  @author_Mehul
  Scenario: User should  Place Order: Login before Checkout
    And I click on top menu "Signup / Login"
    And I enter email: "primeIRir@gmail.com" and password: "Prime@123"
    And I click "login" button
    And Verify that "Logged in as Prime" visible.
    And Click Add to Cart on "Blue Top" in "FEATURES ITEMS"
    And I click on top menu "Cart"
    And Verify that "Shopping Cart" page is displayed
    And I Click on "Proceed To Checkout"
    And Verify that the "DELIVERY" address Title: "Mr",FirstName: "Prime", LastName: "Test",Address: "Alexendra Road",Country: "Uk", State: "Middlesex", City: "London", Zipcode: "Ha2 9uh",Mobile Number: "123453254" is same filled at the time registration of account
    And Verify that the "BILLING" address Title: "Mr",FirstName: "Prime", LastName: "Test",Address: "Alexendra Road",Country: "Uk", State: "Middlesex", City: "London", Zipcode: "Ha2 9uh",Mobile Number: "123453254" is same filled at the time registration of account
    And Enter description: "I have choose this product." in comment text area and click "Place Order"
    And Enter payment details: Name on Card: "Testing", Card Number: "4701322211111234", CVC:"837", Expiration date:"12/2026"
    And I Click on "Pay and Confirm Order" button
    Then Verify success message "Congratulations! Your order has been confirmed!"
    And I click on top menu "Delete Account"
    And Verify that "ACCOUNT DELETED!" is visible and click "Continue" button