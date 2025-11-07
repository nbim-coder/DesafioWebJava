package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class LoginPage {
    private WebDriver driver;
    private Utils utils;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        utils.sendKeys(usernameField, username);
    }

    public void enterPassword(String password) {
        utils.sendKeys(passwordField, password);
    }

    public void submitLogin() {
        utils.click(loginButton);
    }

    public boolean isLoggedIn() {
        return driver.getCurrentUrl().contains("inventory.html");
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
}