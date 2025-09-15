package com.example.steps;

import com.example.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        // Aqui você pode adicionar uma verificação para confirmar que o login foi bem-sucedido
        // Por exemplo, verificar se um elemento específico da página pós-login está presente
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));
    }

    @Then("I close the browser")
    public void i_close_the_browser() {
        if (driver != null) {
            driver.quit();
        }
    }
}