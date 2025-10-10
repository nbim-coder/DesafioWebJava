package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pageobject.*;
import hooks.Hooks;
import org.openqa.selenium.WebDriver;

public class checkoutSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    public checkoutSteps() {
        this.driver = Hooks.getDriver();
        this.loginPage = new LoginPage(driver);
        this.inventoryPage = new InventoryPage(driver);
        this.cartPage = new CartPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
    }

    @Given("I am logged in as {string}")
    public void i_am_logged_in_as(String username) {
        System.out.println("Logging in as: " + username);
        driver.get("https://www.saucedemo.com/");
        loginPage.login(username, "secret_sauce");
        boolean isLoggedIn = inventoryPage.isPageLoaded();
        System.out.println("Is user logged in: " + isLoggedIn);
        Assert.assertTrue("User is not logged in", isLoggedIn);
    }

    @And("I have added an item to the cart")
    public void i_have_added_an_item_to_the_cart() {
        inventoryPage.addItemToCart();
    }

    @When("I go to the cart page")
    public void i_go_to_the_cart_page() {
        inventoryPage.goToCart();
    }

    @And("I click on the checkout button")
    public void i_click_on_the_checkout_button() {
        cartPage.clickCheckoutButton();
    }

    @And("I enter my personal information")
    public void i_enter_my_personal_information() {
        checkoutPage.enterPersonalInformation("John", "Doe", "12345");
    }

    @And("I click on the continue button")
    public void i_click_on_the_continue_button() {
        checkoutPage.clickContinueButton();
    }

    @And("I confirm the order")
    public void i_confirm_the_order() {
        System.out.println("Attempting to confirm the order");
        System.out.println("Current URL before clicking finish: " + driver.getCurrentUrl());
        checkoutPage.clickFinishButton();
    }

    @Then("I should see a confirmation message")
    public void i_should_see_a_confirmation_message() {
        System.out.println("Checking for confirmation message");
        System.out.println("Current URL after clicking finish: " + driver.getCurrentUrl());
    }

    @And("I leave the personal information fields empty")
    public void i_leave_the_personal_information_fields_empty() {
        // Fields are left empty, so no action needed
    }

    @Then("I should see an error message for missing information")
    public void i_should_see_an_error_message_for_missing_information() {
        String errorMessage = checkoutPage.getErrorMessage();
        Assert.assertTrue("Error message for missing information not displayed",
                errorMessage.contains("Error: First Name is required"));
    }
}