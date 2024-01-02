package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends Utility {
    protected static final Logger log = LogManager.getLogger(SearchPage.class);
    List<String> productNameList = new ArrayList<>();
    @CacheLookup
    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    List<WebElement> searchedProductNameList;

    @CacheLookup
    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    List<WebElement> searchedRelatedProduct;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    WebElement continueBtn;

    public boolean getTextSearchedProductName(String productName) {
        boolean result = true;
        for (WebElement element : searchedProductNameList) {
            if (!element.getText().contains(productName)) {
                log.info("Product is not in the list" + searchedProductNameList.toString());
                result = false;
            }
        }
        return result;
    }

    public List<String> clickOnRelatedAddToCartBtn() {
        for (WebElement p : searchedRelatedProduct) {
            productNameList.add(p.getText());
            findElementRelativeTo(p, By.xpath("//a[@class='btn btn-default add-to-cart']"), "below").click();
            clickOnElement(continueBtn);
            log.info("Click On continue button" + continueBtn.toString());

        }
        return productNameList;
    }

    public boolean checkProductInCart(List<String> pList) {
        boolean res = true;
        ViewCartPage vcp = new ViewCartPage();
        for (String pName : pList) {
            if (vcp.getTextProductDisplayed(pName).isEmpty()) {
                res = false;
            }
        }
        return res;
    }
}
