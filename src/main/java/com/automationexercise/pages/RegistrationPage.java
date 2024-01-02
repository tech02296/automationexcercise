package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegistrationPage extends Utility {
    protected static final Logger log = LogManager.getLogger(RegistrationPage.class);
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New User Signup!']")
    WebElement verifyNewUserSignup;
    @CacheLookup
    @FindBy(name = "name")
    WebElement name;

    @CacheLookup
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement emailAddress;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Signup']")
    WebElement signUpBtn;

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
    WebElement enterAccountInformation;

    @CacheLookup
    @FindBy(xpath = "//input[@type='radio']")
    List<WebElement> title;

    @CacheLookup
    @FindBy(id = "password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "days")
    WebElement day;

    @CacheLookup
    @FindBy(id = "months")
    WebElement month;

    @CacheLookup
    @FindBy(id = "years")
    WebElement year;

    @CacheLookup
    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;

    @CacheLookup
    @FindBy(id = "optin")
    WebElement specialOfferCheckbox;

    @CacheLookup
    @FindBy(id = "first_name")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "last_name")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "company")
    WebElement company;

    @CacheLookup
    @FindBy(id = "address1")
    WebElement address;

    @CacheLookup
    @FindBy(id = "country")
    WebElement country;

    @CacheLookup
    @FindBy(id = "state")
    WebElement state;

    @CacheLookup
    @FindBy(id = "city")
    WebElement city;

    @CacheLookup
    @FindBy(id = "zipcode")
    WebElement zipcode;

    @CacheLookup
    @FindBy(id = "mobile_number")
    WebElement mobileNumber;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    WebElement createAccount;

    @CacheLookup
    @FindBy(tagName = "b")
    WebElement accountCreated;

    @CacheLookup
    @FindBy(linkText = "Continue")
    WebElement continueBtn;

    @CacheLookup
    @FindBy(xpath = "//p[normalize-space()='Email Address already exist!']")
    WebElement emailAlreadyExist;

    @CacheLookup
    @FindBy(xpath = "//p[normalize-space()='Your email or password is incorrect!']")
    WebElement errMsgForInvalidLoginDetails;

    public void enterNameAndEmail(String userName, String email) {
        if (email.isEmpty()) {
            email = "prime" + getRandomString(4) + "@gmail.com";
            System.out.println(email);
        }
        sendTextToElement(name, userName);
        sendTextToElement(emailAddress, email);
        log.info("Enter Name:  " + name.toString() + " and Email: " + emailAddress.toString());
    }

    public void clickOnRegistrationPageBtn(String btnName) {
        if (btnName.equals("Signup")) {
            clickOnElement(signUpBtn);
            log.info("Click On SignUp Button" + signUpBtn.toString());
        } else if (btnName.equals("Create Account")) {
            clickOnElement(createAccount);
            log.info("Click On Create Account Button" + createAccount.toString());
        } else if (btnName.equals("Continue")) {
            clickOnElement(continueBtn);
            log.info("Click On Continue Button" + continueBtn.toString());
        }
    }

    public void enterAccountDetails(String selectTitle, String userPassword, String dateOfBirth, String userFirstName, String userLastName, String userCompany, String userAddress, String userCountry, String userState, String userCity, String userZipcode, String userMobileNumber) {
        String[] splitDateOfBirth = dateOfBirth.split("/");
        selectByContainsByAttributeFromDropDown(title, selectTitle, "value");
        log.info("Click on Radio Button" + title.toString());
        sendTextToElement(password, userPassword);
        log.info("Enter Password" + password.toString());
        selectByVisibleTextFromDropDown(day, splitDateOfBirth[0]);
        log.info("Select Day" + day.toString());
        selectByVisibleTextFromDropDown(month, splitDateOfBirth[1]);
        log.info("Select Month" + month.toString());
        selectByVisibleTextFromDropDown(year, splitDateOfBirth[2]);
        log.info("Select Year" + year.toString());
        sendTextToElement(firstName, userFirstName);
        log.info("Enter FirstName" + firstName.toString());
        sendTextToElement(lastName, userLastName);
        log.info("Enter LastName" + lastName.toString());
        sendTextToElement(company, userCompany);
        log.info("Enter Company" + company.toString());
        sendTextToElement(address, userAddress);
        log.info("Enter Address" + address.toString());
        selectByVisibleTextFromDropDown(country, userCountry);
        log.info("Enter Country" + country.toString());
        sendTextToElement(state, userState);
        log.info("Enter State" + state.toString());
        sendTextToElement(city, userCity);
        log.info("Enter City" + city.toString());
        sendTextToElement(zipcode, userZipcode);
        log.info("Enter Zipcode" + zipcode.toString());
        sendTextToElement(mobileNumber, userMobileNumber);
        log.info("Enter Mobile Number" + mobileNumber.toString());
    }

    public void clickOncheckbox(String text) {
        if (text.equals("Sign up for our newsletter!")) {
            clickOnElement(newsletterCheckbox);
            log.info("click On Newsletter Checkbox" + newsletterCheckbox.toString());
        } else if (text.equals("Receive special offers from our partners!")) {
            clickOnElement(specialOfferCheckbox);
            log.info("click On special Offer Checkbox" + specialOfferCheckbox.toString());
        }
    }

    public String verifyText(String text) {
        String result = null;
        if (text.equals("New User Signup!")) {
            result = getTextFromElement(verifyNewUserSignup);
            log.info("Verify text New User Signup!" + verifyNewUserSignup.toString());
        } else if (text.equals("ENTER ACCOUNT INFORMATION")) {
            result = getTextFromElement(enterAccountInformation);
            log.info("Verify Text ENTER ACCOUNT INFORMATION" + enterAccountInformation.toString());
        } else if (text.equals("ACCOUNT CREATED!")) {
            result = getTextFromElement(accountCreated);
            log.info("Verify text ACCOUNT CREATED!" + accountCreated.toString());
        } else if (text.equals("Email Address already exist!")) {
            result = getTextFromElement(emailAlreadyExist);
            log.info("Email Address already exist!" + emailAlreadyExist.toString());
        } else if (text.equals("Your email or password is incorrect!")) {
            result = getTextFromElement(errMsgForInvalidLoginDetails);
            log.info("Email Address already exist!" + errMsgForInvalidLoginDetails.toString());
        }
        return result;
    }
}
