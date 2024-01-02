package com.automationexercise.steps;

import com.automationexercise.pages.ContactUsPage;
import io.cucumber.java.en.And;

import static com.automationexercise.browserfactory.ManageBrowser.getCurrentURL;
import static com.automationexercise.browserfactory.ManageBrowser.softAssertions;

public class ContactUsSteps {
    @And("Verify text {string} is visible")
    public void verifyTextIsVisible(String text) {
        softAssertions.assertEquals(new ContactUsPage().verifyText(text), text, "verify text is not matched");

    }

    @And("Enter Name: {string}, Email: {string}, Subject: {string} and Message: {string}")
    public void enterNameEmailSubjectAndMessage(String name, String email, String subject, String message) {
        new ContactUsPage().enterContactUsDetails(name, email, subject, message);
    }

    @And("Upload file")
    public void uploadFile() {
        new ContactUsPage().uploadFile();
    }

    @And("I Click {string} button")
    public void iClickButton(String btnText) {
        if(btnText.equals("Submit")){
            new ContactUsPage().clickOnSubmitBtn();
        } else if (btnText.equals("OK")) {
            new ContactUsPage().clickOnAlertOkBtn();
        } else if (btnText.equals("Home")) {
            new ContactUsPage().clickOnHomeBtn();
        }
    }

    @And("verify that landed to home page successfully.")
    public void verifyThatLandedToHomePageSuccessfully() {
        softAssertions.assertEquals(getCurrentURL(), "https://automationexercise.com/");
    }
}
