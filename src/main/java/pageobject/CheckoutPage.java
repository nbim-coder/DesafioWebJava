package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class CheckoutPage {
    private WebDriver driver;
    private Utils utils;

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(css = ".complete-header")
    private WebElement confirmationMessage;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterCheckoutInfo(String firstName, String lastName, String postalCode) {
        utils.sendKeys(firstNameField, firstName);
        utils.sendKeys(lastNameField, lastName);
        utils.sendKeys(postalCodeField, postalCode);
    }

    public void clickContinue() {
        utils.click(continueButton);
    }

    public void clickFinish() {
        utils.click(finishButton);
    }

    public boolean isOrderConfirmed() {
        utils.waitForElementToBeVisible(confirmationMessage, 10);
        return confirmationMessage.isDisplayed();
    }
}