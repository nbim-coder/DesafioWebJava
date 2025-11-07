package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pageobject.*;
import hooks.Hooks;

public class CheckoutSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    public CheckoutSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
        this.loginPage = new LoginPage(driver);
        this.inventoryPage = new InventoryPage(driver);
        this.cartPage = new CartPage(driver);
        this.checkoutPage = new CheckoutPage(driver);
    }

    @Given("I am logged in as a standard user")
    public void i_am_logged_in_as_a_standard_user() {
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.submitLogin();
    }

    @And("I have added items to the cart")
    public void i_have_added_items_to_the_cart() {
        inventoryPage.addItemToCart("Sauce Labs Backpack");
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        inventoryPage.goToCart();
        cartPage.proceedToCheckout();
    }

    @And("I enter the following checkout information:")
    public void i_enter_the_following_checkout_information(io.cucumber.datatable.DataTable dataTable) {
        java.util.List<java.util.Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (java.util.Map<String, String> row : rows) {
            String firstName = row.get("First Name");
            String lastName = row.get("Last Name");
            String postalCode = row.get("Postal Code");
            checkoutPage.enterCheckoutInfo(firstName, lastName, postalCode);
        }
    }

    @And("I click the Continue button")
    public void i_click_the_continue_button() {
        checkoutPage.clickContinue();
    }

    @And("I click the Finish button")
    public void i_click_the_finish_button() {
        checkoutPage.clickFinish();
    }

    @Then("I should see the order confirmation")
    public void i_should_see_the_order_confirmation() {
        assert checkoutPage.isOrderConfirmed() : "Order confirmation not displayed";
    }
}