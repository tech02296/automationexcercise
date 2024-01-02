package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewCartPage extends Utility {
    protected static final Logger log = LogManager.getLogger(ViewCartPage.class);
    @CacheLookup
    @FindBy(xpath = "//tbody//tr//td[@class='cart_description']//h4//a")
    List<WebElement> productDisplayed;

    @CacheLookup
    @FindBy(className = "active")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(linkText = "Proceed To Checkout")
    WebElement proceedToCheckOutButton;

    @CacheLookup
    @FindBy(xpath = "//u[normalize-space()='Register / Login']")
    WebElement registerOrLoginButton;

    @CacheLookup
    @FindBy(xpath = "//div[@id='cart_info']//tbody//tr")
    List<WebElement> productDetails;

    @CacheLookup
    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    WebElement deleteProduct;

    @CacheLookup
    @FindBy(xpath = "//span[@id='empty_cart']")
    WebElement deletedProductText;
    public String getTextCart() {
        return getTextFromElement(shoppingCartText);
    }

    public String getTextProductDisplayed(String productName) {
        String result = null;
        for (WebElement product : productDisplayed) {
            if (product.getText().equalsIgnoreCase(productName)) {
                result = product.getText();
                break;
            }
        }
        return result;
    }

    public void clickOnButton(String buttonName) {
        if(buttonName.equals("Proceed To Checkout")){
            clickOnElement(proceedToCheckOutButton);
            log.info("Click on proceed to checkout button" + proceedToCheckOutButton.toString());

        } else if (buttonName.equals("Register / Login")) {
            clickOnElement(registerOrLoginButton);
            log.info("Click on regiter / login button" + registerOrLoginButton.toString());

        }
    }

    public void deleteProductFromCart(String pName){
        for (WebElement productDetail : productDetails){
            By byProductName = By.xpath("//div[@id='cart_info']//tbody//tr//h4");
            String productName = findElementRelativeTo(productDetail, byProductName, "near").getText();
            if(productName.equals(pName)){
                log.info("Click on cart delee button for remove product in the cart" + pName);
                By deleteBtn = By.xpath("//a[@class='cart_quantity_delete']");
                findElementRelativeTo(productDetail, deleteBtn, "near").click();
            }
        }
    }

    public Map<String, String> getTextProductDetails(String pName){
        Map<String, String> productDetailList = new HashMap<>();
        for (WebElement productDetail : productDetails){
            log.info("Product detais" + productDetails.toString());
            By byProductName = By.xpath("//div[@id='cart_info']//tbody//tr//h4");
            String productName = findElementRelativeTo(productDetail, byProductName, "near").getText();
            if(productName.equals(pName)){
                By byProductPrice = By.xpath("//div[@id='cart_info']//tbody//tr//td[@class='cart_price']");
                By byProductQuantity = By.xpath("//div[@id='cart_info']//tbody//tr//td[@class='cart_quantity']");
                By byProductTotalPrice = By.xpath("//div[@id='cart_info']//tbody//tr//td//p[@class='cart_total_price']");
                productDetailList.put("productName", productName);
                productDetailList.put("Price", findElementRelativeTo(productDetail, byProductPrice, "near").getText());
                productDetailList.put("Quantity", findElementRelativeTo(productDetail, byProductQuantity, "near").getText());
                productDetailList.put("TotalPrice", findElementRelativeTo(productDetail, byProductTotalPrice, "near").getText());
            }
        }
        return productDetailList;
    }
    public String getTextDeletedProduct(){
        log.info("get delete buton text" + deletedProductText.toString());
        return getTextFromElement(deletedProductText);
    }
}
