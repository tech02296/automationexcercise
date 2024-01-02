package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {
    protected static final Logger log = LogManager.getLogger(LoginPage.class);
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Login to your account']")
    WebElement loginToYourAccount;

    @CacheLookup
    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement emailField;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginBtn;

    public String getTextLoginToYourAccount(){
        log.info("Verify Login To Your Account" + loginToYourAccount.toString());
        return getTextFromElement(loginToYourAccount);
    }

    public void enterEmailAndPassword(String userName, String password){
        sendTextToElement(emailField, userName);
        log.info("Enter email" + emailField.toString());
        sendTextToElement(passwordField,password);
        log.info("Enter Password" + passwordField.toString());
    }

    public void clickOnLoginBtn(){
        clickOnElement(loginBtn);
        log.info("Click on Login Button" + loginBtn.toString());
    }
}
