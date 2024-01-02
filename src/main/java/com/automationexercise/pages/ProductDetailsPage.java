package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends Utility {
    protected static final Logger log = LogManager.getLogger(ProductDetailsPage.class);
    @CacheLookup
    @FindBy(xpath = "//div[@class='product-information']//h2")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-information']//p[1]")
    WebElement productCategory;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-information']//span/span")
    WebElement productPrice;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-information']//p[2]")
    WebElement productAvailability;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-information']//p[3]")
    WebElement productCondition;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-information']//p[4]")
    WebElement productBrandType;

    @CacheLookup
    @FindBy(id = "quantity")
    WebElement productQuantity;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Write Your Review']")
    WebElement writeYourReviewText;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(id = "name")
    WebElement reviewNameField;

    @CacheLookup
    @FindBy(id = "email")
    WebElement reviewEmailField;

    @CacheLookup
    @FindBy(id = "review")
    WebElement reviewTextField;

    @CacheLookup
    @FindBy(id = "button-review")
    WebElement submitBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@class='col-md-12 form-group']//div[@class='alert-success alert']")
    WebElement successReviewMsg;

    public String getProductName() {
        log.info("get product name" + productName.toString());
        return getTextFromElement(productName);
    }

    public String getProductCategory() {
        log.info("get product category" + productCategory.toString());
        return getTextFromElement(productCategory);
    }

    public String getProductPrice() {
        log.info("get product pricr" + productPrice.toString());
        return getTextFromElement(productPrice);
    }

    public String getProductAvailability() {
        log.info("get product availability" + productAvailability.toString());
        return getTextFromElement(productAvailability);
    }

    public String getProductCondition() {
        log.info("get product condition" + productCondition.toString());
        return getTextFromElement(productCondition);
    }

    public String getProductBrand() {
        log.info("get product brand type" + productBrandType.toString());
        return getTextFromElement(productBrandType);
    }

    public void changeProductQuantity(String quantity) {
        productQuantity.clear();
        sendTextToElement(productQuantity, quantity);
        log.info("enter product auantity" + productQuantity.toString());
    }

    public void clickOnButton(String btnName) {
        if (btnName.equalsIgnoreCase("Add to cart")) {
            clickOnElement(addToCartButton);
            log.info("Click on add to cart button" + addToCartButton.toString());
        } else if (btnName.equalsIgnoreCase("Submit")) {
            clickOnElement(submitBtn);
            log.info("Click on submit button" + submitBtn.toString());
        }
    }

    public String getWriteYourReviewText(String text) {
        String result = null;
        if (text.equalsIgnoreCase("WRITE YOUR REVIEW")) {
            result = getTextFromElement(writeYourReviewText);
            log.info("get write review text" + writeYourReviewText.toString());
        } else if (text.equalsIgnoreCase("Thank you for your review.")) {
            result = getTextFromElement(successReviewMsg);
            log.info("get message for successfully submit message" + successReviewMsg.toString());
        }
        return result;
    }

    public void enterReviewDetails(String name, String email, String reviewText) {
        sendTextToElement(reviewNameField, name);
        log.info("Enter reviewer name" + reviewNameField.toString());
        sendTextToElement(reviewEmailField, email);
        log.info("Enter reviewer email" + reviewEmailField.toString());
        sendTextToElement(reviewTextField, reviewText);
        log.info("Enter review text" + reviewTextField.toString());
    }
}
