package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountPage extends Utility {
    protected static final Logger log = LogManager.getLogger(DeleteAccountPage.class);
    @CacheLookup
    @FindBy(tagName = "b")
    WebElement accountDeleted;

    @CacheLookup
    @FindBy(linkText = "Continue")
    WebElement continueBtn;

    public String getTextAccountDeleted() {
        log.info("Verify Text Account Deleted " + accountDeleted.toString());
        return getTextFromElement(accountDeleted);
    }

    public void clickOnContinue() {
        clickOnElement(continueBtn);
        log.info("Click On Continue Button" + continueBtn.toString());

    }
}
