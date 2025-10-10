package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class Utils {
    public static void takeScreenshot(WebDriver driver, String fileName) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//Comentários:
//- Esta classe fornece métodos utilitários para esperar elementos serem visíveis ou clicáveis
// - Pode ser expandida com outros métodos úteis conforme necessário.