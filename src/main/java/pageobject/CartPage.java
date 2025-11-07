package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class CartPage {
    private WebDriver driver;
    private Utils utils;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
        PageFactory.initElements(driver, this);
    }

    public void proceedToCheckout() {
        utils.click(checkoutButton);
    }
}