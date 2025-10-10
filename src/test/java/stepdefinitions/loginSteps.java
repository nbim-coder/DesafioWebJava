package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pageobject.LoginPage;
import pageobject.InventoryPage;
import hooks.Hooks;
import org.openqa.selenium.WebDriver;

public class loginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    public loginSteps() {
        this.driver = Hooks.getDriver();
        this.loginPage = new LoginPage(driver);
        this.inventoryPage = new InventoryPage(driver);
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        System.out.println("Checking if user is logged in");
        boolean isLoggedIn = inventoryPage.isPageLoaded();
        System.out.println("Is user logged in: " + isLoggedIn);
        Assert.assertTrue("User is not logged in", isLoggedIn);
    }
    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        Assert.assertTrue("Error message is not displayed", loginPage.isErrorMessageDisplayed());
    }
}