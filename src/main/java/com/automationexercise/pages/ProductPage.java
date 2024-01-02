package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ProductPage extends Utility {
    protected static final Logger log = LogManager.getLogger(ProductPage.class);
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Brands']")
    WebElement brands;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-stacked']//li/a")
    List<WebElement> selectBrand;

    @CacheLookup
    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement brandProductPage;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='All Products']")
    WebElement allProductsText;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Searched Products']")
    WebElement searchedProductsText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    List<WebElement> allProductsList;

    @CacheLookup
    @FindBy(id = "search_product")
    WebElement searchProductName;

    @CacheLookup
    @FindBy(id = "submit_search")
    WebElement searchBtn;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Category']")
    WebElement category;

    @CacheLookup
    @FindBy(xpath = "//div[@class='panel-group category-products']//h4//a")
    List<WebElement> categoryList;
    @CacheLookup
    @FindBy (xpath = "//div[@class = 'panel-body']//ul//li//a")
    List<WebElement> womenSubMenuList;

    public String getTextBrands(String text) {
        String result = null;
        if (text.equalsIgnoreCase("BRANDS")) {
            result = getTextFromElement(brands);
            log.info("get brands text" + brands.toString());
        } else if (text.equalsIgnoreCase("CATEGORY")) {
            result = getTextFromElement(category);
            log.info("get category text" + category.toString());
        }
        return result;
    }

    public void clickOnBrand(String option) {
        try {
            for (WebElement element : selectBrand) {
                if (element.getText().contains(option)) {
                    log.info("click on brand" + element.toString());
                    element.click();
                    break;
                }
            }
        } catch (StaleElementReferenceException e) {
            log.info(e.getMessage());
        }
    }

    public Map<String, String> getBrandTitleAndURL() {
        waitUntilVisibilityOfElementLocated(By.xpath("//h2[@class='title text-center']"), 5);
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("actualText", getTextFromElement(brandProductPage));
        log.info("Product Page title" + brandProductPage.toString());
        hashMap.put("currentURL", getCurrentURL());
        log.info("current url" + getCurrentURL());
        return hashMap;
    }

    public String getTextAllProducts(String text) {
        String result = null;
        if (text.equalsIgnoreCase("All Products")) {
            result = getTextFromElement(allProductsText);
            log.info("get Title all products" + allProductsText.toString());
        } else {
            result = getTextFromElement(searchedProductsText);
            log.info("get search product title" + searchedProductsText.toString());
        }
        return result;
    }

    public void clickOnRecommendedProductAddToCart(String productName, String childField, String hoverProduct) {
        for (WebElement recommendedProduct : Objects.requireNonNull(allProductsList)) {
            if (recommendedProduct.getText().equalsIgnoreCase(productName)) {
                if (childField.equalsIgnoreCase("Add to cart")) {
                    if (hoverProduct.equals("Hover")) {
                        mouseHoverToElement(allProductsText);
                        log.info("mouse hover" + allProductsText.toString());
                    }
                    findElementRelativeTo(recommendedProduct, By.xpath("//a[@class='btn btn-default add-to-cart']"), "below").click();
                } else if (childField.equalsIgnoreCase("viewProductBtn") || childField.equalsIgnoreCase("View Product")) {
                    findElementRelativeTo(recommendedProduct, By.xpath("(//a[contains(text(),'View Product')])"), "below").click();
                }
                break;
            }
        }
    }

    public Integer getListCount() {
        log.info("get list count" + allProductsList.toString());
        return (int) allProductsList.stream().count();
    }

    public void enterProductName(String text) {
        sendTextToElement(searchProductName, text);
        log.info("Enter text on search field" + searchProductName.toString());
    }

    public void clickOnBtn(String buttonName) {
        if (buttonName.equals("search")) {
            clickOnElement(searchBtn);
            log.info("Click on search button" + searchBtn.toString());
        }
    }
    public void clickOnCategoryList(String mainCategory){
       for (WebElement category : categoryList){
            if (category.getText().equalsIgnoreCase(mainCategory)){
                log.info("Click on category" + category.toString());
                clickOnElement(category);
                break;
            }
        }
    }
    public void clickOnSubCategory(String categoryLink){
        for (WebElement linkText: womenSubMenuList){
            System.out.println(linkText.getText());
            if (linkText.getText().equalsIgnoreCase(categoryLink)){
                log.info("Click on submenu" + linkText.toString());
                clickOnElement(linkText);
                break;
            }
        }
    }
}
