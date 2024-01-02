package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends Utility {
    protected static final Logger log = LogManager.getLogger(CheckOutPage.class);
    @CacheLookup
    @FindBy(id = "address_delivery")
    WebElement adeliveryAdressDetails;

    @CacheLookup
    @FindBy(id = "address_invoice")
    WebElement billingAddressDetails;

    @CacheLookup
    @FindBy(linkText = "Place Order")
    WebElement placeOrderBtn;

    @CacheLookup
    @FindBy(name = "message")
    WebElement descriptionField;

    @CacheLookup
    @FindBy(name = "name_on_card")
    WebElement nameOnCardField;

    @CacheLookup
    @FindBy(name = "card_number")
    WebElement cardNumberField;
    @CacheLookup
    @FindBy(name = "cvc")
    WebElement cvcField;

    @CacheLookup
    @FindBy(name = "expiry_month")
    WebElement expiryMonthField;

    @CacheLookup
    @FindBy(name = "expiry_year")
    WebElement expiryYearField;

    @CacheLookup
    @FindBy(id = "submit")
    WebElement payAndConfirmBtn;

    @CacheLookup
    @FindBy(xpath = "//p[normalize-space()='Congratulations! Your order has been confirmed!']")
    WebElement orderConfirmationMessage;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Download Invoice']")
    WebElement downloadInvoiceBtn;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueBtn;


    public String getTextAddressDetails(String addressType) {
        String res = null;
        if (addressType.equalsIgnoreCase("DELIVERY")) {
            res = getTextFromElement(adeliveryAdressDetails);
            log.info("Delivery time Address Details" + adeliveryAdressDetails.toString());
        } else {
            res = getTextFromElement(billingAddressDetails);
            log.info("Billing Address Details" + billingAddressDetails.toString());

        }
        return res;
    }

    public void enterDescription(String description) {
        sendTextToElement(descriptionField, description);
        log.info("Enter Description" + descriptionField.toString());
    }

    public String getConfirmationMsg() {
        log.info("Verify Order Confirmation Message" + orderConfirmationMessage.toString());
        return getTextFromElement(orderConfirmationMessage);
    }

    public void clickOnBtn(String btnName) {
        if (btnName.equalsIgnoreCase("Place Order")) {
            clickOnElement(placeOrderBtn);
            log.info("Click on Place Order Button" + placeOrderBtn.toString());
        } else if (btnName.equalsIgnoreCase("Pay and Confirm Order")) {
            clickOnElement(payAndConfirmBtn);
            log.info("Click on Pay And Confirmation Button" + payAndConfirmBtn.toString());
        } else if (btnName.equalsIgnoreCase("Download Invoice")) {
            clickOnElement(downloadInvoiceBtn);
            log.info("Click on Download Invoice Button" + downloadInvoiceBtn.toString());
        } else if (btnName.equalsIgnoreCase("Continue")) {
            clickOnElement(continueBtn);
            log.info("Click on Continue Button" + continueBtn.toString());
        }
    }

    public void enterPaymentDetails(String nameOnCard, String cardNumber, String cvc, String expDate) {
        String[] expDetails = expDate.split("/");
        log.info("Split Expire Date" + expDetails.toString());
        sendTextToElement(nameOnCardField, nameOnCard);
        log.info("Enter Name On card" + nameOnCard.toString());
        sendTextToElement(cardNumberField, cardNumber);
        log.info("Enter Card Number Field" + cardNumberField.toString());
        sendTextToElement(cvcField, cvc);
        log.info("Enter cvc field" + cvcField.toString());
        sendTextToElement(expiryMonthField, expDetails[0]);
        log.info("Enter Expiry Month" + expiryMonthField.toString());
        sendTextToElement(expiryYearField, expDetails[1]);
        log.info("Enter Expiry Year" + expiryYearField.toString());
    }

    public boolean checkFileIsDownloaded(String filePath) {
        log.info("Verify field downloaded file" + isFileDownloaded(filePath));
        return isFileDownloaded(filePath);
    }
}



