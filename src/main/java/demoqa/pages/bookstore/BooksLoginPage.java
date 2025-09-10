package demoqa.pages.bookstore;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.JavaScriptUtility;

import java.time.Duration;

public class BooksLoginPage extends BasePage {

    private final JavaScriptUtility javaScriptUtility;
    @FindBy(xpath = "//button[contains(.,'Log out')]")
    WebElement logoutButton;
    @FindBy(xpath = "//button[@id='gotoStore']")
    WebElement goToBookStoreButton;
    @FindBy(xpath = "//button[@type='button'][contains(.,'Delete Account')]")
    WebElement deleteAccountButton;
    @FindBy(xpath = "(//button[@type='button'][contains(.,'Delete All Books')])[1]")
    WebElement deleteAllBooksButton;
    @FindBy(id = "loading-label")
    WebElement loadingLabel;
    @FindBy(id = "userName-label")
    WebElement usernameLabel;
    @FindBy(id = "password-label")
    WebElement passwordLabel;
    @FindBy(xpath = "//h5[contains(.,'Login in Book Store')]")
    WebElement loginText;
    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Login')]")
    WebElement header;
    @FindBy(xpath = "//h2[contains(.,'Welcome,')]")
    WebElement welcomeText;
    @FindBy(xpath = "//h5[contains(.,'Login in Book Store')]")
    WebElement loginInBookStore;
    @FindBy(id = "userName")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login")
    WebElement loginButton;
    @FindBy(id = "newUser")
    WebElement newUserButton;
    @FindBy(id = "name")
    WebElement errorMessage;
    @FindBy(id = "userName-value")
    WebElement profile;

    public BooksLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public String getLoadingLabel() {
        return loadingLabel.getText();
    }

    public String getUsernamePlaceholder() {
        return username.getDomAttribute("placeholder");
    }

    public String getPasswordPlaceholder() {
        return password.getDomAttribute("placeholder");
    }

    public String getPasswordLabel() {
        return passwordLabel.getText();
    }

    public String getUsernameLabel() {
        return usernameLabel.getText();
    }

    public String getLoginHeaderText() {
        return header.getText();
    }

    public String getWelcomeText() {
        return welcomeText.getText();
    }

    public String getLoginInBookStoreText() {
        return loginInBookStore.getText();
    }

    public String getLoginButtonText() {
        return loginButton.getText();
    }

    public String getNewUserButtonText() {
        return newUserButton.getText();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.elementToBeClickable(errorMessage));
        return errorMessage.getText();
    }

    public void clickLoginButton() {
        javaScriptUtility.scrollToElementJS(loginButton);
        loginButton.click();
    }

    public String getLoginText() {
        return loginText.getText();
    }

    public void setUsername(String username2) {
        javaScriptUtility.scrollToElementJS(username);
        set(username, username2);
    }

    public void setPassword(String password2) {
        set(password, password2);
    }

    public String getLoginButtonBackgroundColor() {
        return loginButton.getCssValue("background-color");
    }

    public String getNewUserButtonBackgroundColor() {
        return newUserButton.getCssValue("background-color");
    }
}
