package com.automationexercise.steps;

import com.automationexercise.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.AssertJUnit;
import static com.automationexercise.browserfactory.ManageBrowser.softAssertions;

public class RegistrationPageSteps {
    @Given("I am on Home Page.")
    public void iAmOnHomePage() {
    }

    @When("I click on top menu {string}")
    public void iClickOnTopMenuButton(String option) {
        new HomePage().selectMenu(option);
    }

    @And("Verify that {string} visible.")
    public void verifyThatVisible(String text) {
        if (text.equals("New User Signup!") || text.equals("ENTER ACCOUNT INFORMATION") || text.equals("ACCOUNT CREATED!") || text.equals("Email Address already exist!") || text.equals("Your email or password is incorrect!")) {
            AssertJUnit.assertEquals(new RegistrationPage().verifyText(text), text);
        } else {
            softAssertions.assertEquals(new HomePage().verifyFromTopMenu(text), text);
        }
    }

    @And("I Enter {string} and email address.")
    public void enterAndEmailAddress(String name) {
        new RegistrationPage().enterNameAndEmail(name, "");
    }

    @And("I Click on {string} button.")
    public void iClickOnButton(String btnName) {
        new RegistrationPage().clickOnRegistrationPageBtn(btnName);
    }

    @And("Fill Details: Title: {string},Name,Email,Password: {string},Date of Birth: {string}, FirstName: {string}, LastName: {string},Company: {string},Address: {string},Country: {string}, State: {string}, City: {string}, Zipcode: {string},Mobile Number: {string}")
    public void fillDetailsTitleNameEmailPasswordDateOfBirth(String title, String password, String dateOfBirth, String firstName, String lastName, String company, String address, String country, String state, String city, String zipcode, String mobileNumber) {
        new RegistrationPage().enterAccountDetails(title, password, dateOfBirth, firstName, lastName, company, address, country, state, city, zipcode, mobileNumber);
    }

    @And("Select checkbox {string}")
    public void selectCheckbox(String text) {
        new RegistrationPage().clickOncheckbox(text);
    }

    @Then("Verify that {string} is visible and click {string} button")
    public void verifyThatIsVisibleAndClickButton(String textAccountDeleted, String continueBtn) {
        Assert.assertEquals(new DeleteAccountPage().getTextAccountDeleted(), textAccountDeleted);
        new DeleteAccountPage().clickOnContinue();
    }

    @And("I Enter {string} and email: {string}")
    public void iEnterAndEmail(String userName, String email) {
        new RegistrationPage().enterNameAndEmail(userName, email);
    }

    @And("Verify that {string} page is displayed")
    public void verifyThatPageIsDisplayed(String expectedText) {
        Assert.assertEquals(new ViewCartPage().getTextCart(), expectedText, "Shopping cart is not Displayed");
    }

    @And("I Click on {string}")
    public void iClickOn(String buttonText) {
        new ViewCartPage().clickOnButton(buttonText);
    }
    @And("Verify that the {string} address Title: {string},FirstName: {string}, LastName: {string},Address: {string},Country: {string}, State: {string}, City: {string}, Zipcode: {string},Mobile Number: {string} is same filled at the time registration of account")
    public void verifyThatTheAddressTitleFirstNameLastNameAddressCountryStateCityZipcodeMobileNumberIsSameFilledAtTheTimeRegistrationOfAccount(String addressType, String title, String firstName, String lastName, String address, String country, String state, String city, String zipcode, String mobileNumber) {
        String expectedText = "YOUR "+addressType+" ADDRESS\n" + title + ". " + firstName + " " + lastName + "\n" + firstName + "\n" + address + "\n" + city + " " + state + " " + zipcode + "\n" + country + "\n" + mobileNumber;
        Assert.assertEquals(new CheckOutPage().getTextAddressDetails(addressType), expectedText, "Delivery Address is not Matched");
    }

}
