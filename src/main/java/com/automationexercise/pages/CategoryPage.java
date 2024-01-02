package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends Utility {
    protected static final Logger log = LogManager.getLogger(CategoryPage.class);
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Women - Dress Products']")
    WebElement womenDressProductText;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Men - Tshirts Products']")
    WebElement menDressProductText;

    public String getTitleManWomenProduct(String text){
        String res = null;
        if(text.equalsIgnoreCase("MEN - TSHIRTS PRODUCTS")){
            res = getTextFromElement(menDressProductText);
            log.info("SubProduct Title of Men category" + menDressProductText.toString());
        }else{
            res = getTextFromElement(womenDressProductText);
            log.info("SubProduct Title of Women category" + womenDressProductText.toString());
        }
        return res;
    }
}
