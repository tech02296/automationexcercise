package com.automationexercise.steps;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailsPage;
import com.automationexercise.pages.ViewCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static com.automationexercise.browserfactory.ManageBrowser.refreshPage;
import static com.automationexercise.browserfactory.ManageBrowser.softAssertions;

public class HomePageSteps {
    @And("Verify that {string} is visible")
    public void verifyThatIsVisible(String expectedText) {
        softAssertions.assertEquals(new HomePage().getTextAfterScrollDown(expectedText), expectedText, expectedText + "is not matched");
    }

    @And("Enter email {string} in input and click arrow button")
    public void enterEmailInInputAndClickArrowButton(String email) {
        new HomePage().enterSubscriptionEmailAndClickOnArrowBtn(email);
    }

    @And("Scroll down page to {string}")
    public void scrollDownPageTo(String text) {
        new HomePage().scrollDownToElement(text);
    }

    @And("Click on arrow at bottom right side to move upward")
    public void clickOnArrowAtBottomRightSideToMoveUpward() {
        softAssertions.assertTrue(new HomePage().clickOnArrowBtn(), "scroll not working after click on up arrow button");
    }

    @And("Verify that page is scrolled up and {string} text is visible on screen")
    public void verifyThatPageIsScrolledUpAndTextIsVisibleOnScreen(String expectedText) {
        softAssertions.assertAll();
        Assert.assertEquals(new HomePage().getFullFledgedText(), expectedText);
    }

    @And("Scroll up page to top")
    public void scrollUpPageToTop() {
        new HomePage().scrollToTopOnThePage();
    }

    @And("Click on {string} button")
    public void clickOnButton(String viewCart) {
        new HomePage().clickOnViewCart(viewCart);
    }

    @Then("Verify that {string} in cart page")
    public void verifyThatInCartPage(String expectedText) {
        Assert.assertEquals(new ViewCartPage().getTextProductDisplayed(expectedText), expectedText);
    }

    @And("Click Add to Cart on {string} in {string}")
    public void clickAddToCartOnIn(String productName, String type) {
        new HomePage().clickOnRecommendedProductAddToCart(productName, type);
    }

    @And("Increase quantity to {string}")
    public void increaseQuantityTo(String quantity) {
        new ProductDetailsPage().changeProductQuantity(quantity);
    }

    @And("Click {string} button")
    public void clickButton(String buttonName) {
        new ProductDetailsPage().clickOnButton(buttonName);
    }

    @And("page refresh")
    public void pageRefresh() {
        refreshPage();
    }
}
