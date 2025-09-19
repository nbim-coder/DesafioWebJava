// Define o pacote onde esta classe está localizada
package pageobject;

// Importa as classes necessárias do Selenium WebDriver
import io.cucumber.messages.Messages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;
import hooks.Hooks;

// Define a classe LoginPage
public class LoginPage {
    // Declara uma variável privada para armazenar a instância do WebDriver
    private WebDriver driver;

    // Usa a anotação @FindBy para localizar o elemento de input do nome site
    @FindBy(xpath = "//div[@class=\"login_logo\"]")
    private WebElement titleSiteName;

    // Usa a anotação @FindBy para localizar o elemento de input do nome de usuário
    @FindBy(xpath = "//input[@id=\"user-name\"]")
    private WebElement inputLoginName;

    // Localiza o elemento de input da senha
    @FindBy(xpath ="//input[@id=\"password\"]")
    private WebElement inputLoginPassword;

    // Localiza o elemento que exibe mensagens de erro
    @FindBy(xpath ="//h3[@data-test=\"error\"]")
    private WebElement errorMessage;

    // Localiza o botão de login
    @FindBy(xpath ="//input[@id=\"login-button\"]")
    private WebElement buttonlogin;

    //Localizar o "Produts"
    @FindBy(xpath ="////span[@class=\"title\"]")
    public WebElement titleProductSite;

    // Construtor da classe que inicializa o WebDriver e os elementos da página
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

// Método para obter o título do site
    public WebElement getTitleSiteNameElement() {
    return titleSiteName;
}

    public boolean isLoginPageDisplayed() {
        return titleSiteName.isDisplayed();
    }

    // Método para inserir o nome de usuário
    public void enterUsername(String username) {
        inputLoginName.sendKeys(username);
    }

    // Método para inserir a senha
    public void enterPassword(String password) {
        inputLoginPassword.sendKeys(password);
    }

    // Método para clicar no botão de login
    public void clickbuttonlogin() {
        buttonlogin.click();
    }

    // Método para obter o texto da mensagem de erro
    public String getErrorMessage() {
        return errorMessage.getText();
    }

    // Método que combina as ações de login (inserir usuário, senha e clicar no botão)
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickbuttonlogin();
    }

    public void validTitle() {
        Utils.validateElementText(titleProductSite,"Products");
    }

    //Método para visualização do "Products"
    public WebElement getTitleSiteProduct() {
        return titleProductSite;
    }

    public boolean isLoggedIn() {
        // Verifique se um elemento que só aparece após o login está presente
        // Por exemplo, o botão de logout ou o título da página de inventário
        return driver.findElement(By.id("inventory_container")).isDisplayed();
    }
}