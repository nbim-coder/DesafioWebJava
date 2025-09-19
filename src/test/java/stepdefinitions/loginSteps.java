package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pageobject.LoginPage;
import hooks.Hooks;
import org.junit.Assert;

public class loginSteps {
    private LoginPage loginPage;

    public loginSteps() {
        loginPage = new LoginPage(Hooks.getDriver());
        }
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Assert.assertTrue("Not on login page", loginPage.isLoginPageDisplayed());
    }

    @Then("I should see the site title {string}")
    public void i_should_see_the_site_title(String expectedTitle) {
        Assert.assertEquals(expectedTitle, loginPage.getTitleSiteNameElement());
    }

    @When("I enter valid username {string} and password {string}")
    public void i_enter_valid_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @And("I should see the products page title")
    public void i_should_see_the_products_page_title() {
        loginPage.validTitle();
    }

}