package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class InventoryPage {
    private WebDriver driver;
    private Utils utils;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartLink;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
        PageFactory.initElements(driver, this);
    }

    public void addItemToCart(String itemName) {
        String xpath = String.format("//div[text()='%s']/ancestor::div[@class='inventory_item']//button", itemName);
        WebElement addToCartButton = driver.findElement(By.xpath(xpath));
        utils.click(addToCartButton);
    }

    public void goToCart() {
        utils.click(cartLink);
    }
}