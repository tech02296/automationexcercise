package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class HomePage extends Utility {
    protected static final Logger log = LogManager.getLogger(HomePage.class);
    @CacheLookup
    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li")
    List<WebElement> topMenu;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    WebElement subscriptionText;

    @CacheLookup
    @FindBy(id = "susbscribe_email")
    WebElement subscriptionEmail;

    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
    WebElement subscriptionArrowBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert-success alert']")
    WebElement subscriptionSuccessMsg;

    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-angle-up']")
    WebElement arrowBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engin')]")
    WebElement fullFledgedText;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='recommended items']")
    WebElement recommendedItemsText;

    @CacheLookup
    @FindBy(xpath = "//div[@id='recommended-item-carousel']//div[@class='productinfo text-center']/p")
    List<WebElement> recommendedProductNameList;

    @CacheLookup
    @FindBy(xpath = "//div[@class='features_items']//div[@class='productinfo text-center']/p")
    List<WebElement> productList;

    @CacheLookup
    @FindBy(tagName = "u")
    WebElement viewCart;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    WebElement continueButton;

    public void selectMenu(String menu) {
        try {
            for (WebElement element : topMenu) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                    log.info("Selecting menu " + element.toString());
                    break;
                }
            }
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getMessage());
        }
    }

    public String verifyFromTopMenu(String text) {
        String result = null;
        for (WebElement element : topMenu) {
            if (element.getText().equalsIgnoreCase(text)) {
                result = element.getText();
                log.info("Verify Text From TopMenu" + element.toString());
            }
        }
        return result;
    }

    public void scrollDownToElement(String elementText) {
        if (elementText.equalsIgnoreCase("SUBSCRIPTION")) {
            scrollToElement(subscriptionText);
            log.info("Click on scroll button until subscription" + subscriptionText.toString());
        } else if (elementText.equalsIgnoreCase("RECOMMENDED ITEMS")) {
            scrollToElement(recommendedItemsText);
            log.info("Click on scroll button until Recommended Items" + recommendedItemsText.toString());
        }
    }

    public boolean clickOnArrowBtn() {
        clickOnElement(arrowBtn);
        log.info("Click on Arrow Button" + arrowBtn.toString());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return checkTextIsOnVisibleScreen();

    }

    public String getTextAfterScrollDown(String text) {
        String result = null;
        if (text.equalsIgnoreCase("SUBSCRIPTION")) {
            result = getTextFromElement(subscriptionText);
            log.info("Enter subscription Text" + subscriptionText.toString());
        } else if (text.equalsIgnoreCase("RECOMMENDED ITEMS")) {
            result = getTextFromElement(recommendedItemsText);
            log.info("Enter RecommendedItems Text" + recommendedItemsText.toString());
        } else {
            result = getTextFromElement(subscriptionSuccessMsg);
            log.info("Enter subscription Message" + subscriptionSuccessMsg.toString());
        }
        return result;
    }

    public void enterSubscriptionEmailAndClickOnArrowBtn(String email) {
        sendTextToElement(subscriptionEmail, email);
        log.info("Enter subscription Email" + subscriptionEmail.toString());
        clickOnElement(subscriptionArrowBtn);
        log.info("Click on Subscription Arrow Button" + subscriptionArrowBtn.toString());
    }

    public boolean checkTextIsOnVisibleScreen() {
        log.info("Verify full Fledged Text is visible" + fullFledgedText.toString());
        return isElementWithinVisibleScreen(fullFledgedText);
    }

    public String getFullFledgedText() {
        log.info("Verify full Fledged Text" + fullFledgedText.toString());
        return getTextFromElement(fullFledgedText);
    }

    public void scrollToTopOnThePage() {
        scrollToTop();
        log.info("Scroll To top");
    }

    public void clickOnRecommendedProductAddToCart(String productName, String listType) {
        List<WebElement> webElementList = null;
        if (listType.equalsIgnoreCase("Recommended product")) {
            webElementList = recommendedProductNameList;
            log.info("Get List Product name" + recommendedProductNameList.toString());
        } else {
            webElementList = productList;
            log.info("Get Product List" + productList.toString());
        }
        for (WebElement recommendedProduct : Objects.requireNonNull(webElementList)) {
            if (recommendedProduct.getText().equalsIgnoreCase(productName)) {
                findElementRelativeTo(recommendedProduct, By.xpath("//a[@class='btn btn-default add-to-cart']"), "below").click();
                break;
            }
        }
    }

    public void clickOnViewCart(String button) {
        if (button.equalsIgnoreCase("View Cart")) {
            clickOnElement(viewCart);
            log.info("Click on View Cart" + viewCart.toString());
        } else if (button.equalsIgnoreCase("Continue Shopping")) {
            clickOnElement(continueButton);
            log.info("Click on Continue Button" + continueButton.toString());
        }
    }
}
