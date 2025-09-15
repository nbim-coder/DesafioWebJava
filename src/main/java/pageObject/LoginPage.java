package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath =//input[@id="user-name"])
    private WebElement inputLoginName;

    @FindBy(xpath =//input[@id="password"])
    private WebElement inputLoginPassword;

    @FindBy(xpath =//h3[@data-test="error"])
    private WebElement ErrorUser;

    @FindBy(xpath = //input[@id="login-button"])
    private WebElement buttonlogin;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        inputLoginName.sendKeys(username);
    }

    public void enterPassword(String password) {
        inputLoginPassword.sendKeys(password);
    }

    public void clickbuttonlogin() {
        buttonlogin.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickbuttonlogin();
    }
}