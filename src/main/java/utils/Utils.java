package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import hooks.Hooks;

import static org.assertj.core.api.Assertions.assertThat;

public class Utils {

    public static void textShouldBe(WebElement element, String expectedText) {
        String actualText = element.getText();
        assertThat(actualText).as("The text does not match the expected value").isEqualTo(expectedText);
    }

    public static boolean validateElementText(WebElement element, String expectedText) {
        try {
            WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), 10); // 10 segundos de timeout
            wait.until(ExpectedConditions.visibilityOf(element));
            String actualText = element.getText();
            return actualText.equals(expectedText);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}