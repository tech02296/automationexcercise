package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends Utility {
    protected static final Logger log = LogManager.getLogger(ContactUsPage.class);
    @CacheLookup
    @FindBy(xpath = "//div[@class='contact-form']/h2")
    WebElement getInTouch;
    @CacheLookup
    @FindBy(name = "name")
    WebElement name;

    @CacheLookup
    @FindBy(name = "email")
    WebElement email;

    @CacheLookup
    @FindBy(name = "subject")
    WebElement subject;

    @CacheLookup
    @FindBy(id = "message")
    WebElement message;

    @CacheLookup
    @FindBy(name = "upload_file")
    WebElement file;

    @CacheLookup
    @FindBy(name = "submit")
    WebElement submitBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement successMsgAfterSubmitForContactUs;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-success']")
    WebElement homeBtn;

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Test Cases']")
    WebElement testCasesTitle;

    public String verifyText(String text) {
        String result = null;
        if (text.equalsIgnoreCase("Get In Touch")) {
            result = getTextFromElement(getInTouch);
            log.info("Verify Text Get In Touch" + getInTouch.toString());
        } else if (text.equals("Success! Your details have been submitted successfully.")) {
            result = getTextFromElement(successMsgAfterSubmitForContactUs);
            log.info("Verify Text Success Msg After Submit on contact Us" + successMsgAfterSubmitForContactUs.toString());
        } else if (text.equalsIgnoreCase("Test Cases")) {
            result = getTextFromElement(testCasesTitle);
            log.info("Verify Text Test case Title" + testCasesTitle.toString());
        }
        return result;
    }

    public void enterContactUsDetails(String uName, String uEmail, String uSubject, String uMessage) {
        sendTextToElement(name, uName);
        log.info("Enter Name" + name.toString());
        sendTextToElement(email, uEmail);
        log.info("Enter Email" + email.toString());
        sendTextToElement(subject, uSubject);
        log.info("Enter Subject" + subject.toString());
        sendTextToElement(message, uMessage);
        log.info("Enter Message" + message.toString());
    }

    public void uploadFile() {
        sendTextToElement(file, "C:/Users/thumm/IdeaProjects/gitdemo/a.txt");
        log.info("Upload File" + file.toString());
    }

    public void clickOnSubmitBtn() {
        clickOnElement(submitBtn);
        log.info("Click On Submit Button" + submitBtn.toString());
    }

    public void clickOnAlertOkBtn() {
        switchToAlert();
        log.info("Click on SSwitch to Alert");
        acceptAlert();
        log.info("Click on accept alert");
    }

    public void clickOnHomeBtn() {
        clickOnElement(homeBtn);
        log.info("Click On Home Button" + homeBtn.toString());
    }
}
