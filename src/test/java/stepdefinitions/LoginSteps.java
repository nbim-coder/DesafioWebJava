package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pageobject.LoginPage;
import hooks.Hooks;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps(Hooks hooks) {
        this.driver = hooks.getDriver();
        this.loginPage = new LoginPage(driver);
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        loginPage.enterUsername(username);
    }

    @And("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        loginPage.submitLogin();
    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        assert loginPage.isLoggedIn() : "Login failed";
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        assert loginPage.isErrorMessageDisplayed() : "Error message not displayed";
    }
}