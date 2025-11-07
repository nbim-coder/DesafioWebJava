package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Utils {
    private WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void sendKeys(WebElement element, String text) {
        waitForElementToBeVisible(element, 10);
        element.clear();
        element.sendKeys(text);
    }

    public void click(WebElement element) {
        waitForElementToBeClickable(element, 10);
        element.click();
    }

    public void takeScreenshot(String name) {
        // Implement screenshot logic here
    }
}