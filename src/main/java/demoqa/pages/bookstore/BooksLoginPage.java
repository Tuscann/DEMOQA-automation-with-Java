package demoqa.pages.bookstore;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class BooksLoginPage extends BasePage {

    private final By header = By.xpath("//h1[@class='text-center'][contains(.,'Login')]");
    private final By welcomeText = By.xpath("//h2[contains(.,'Welcome,')]");
    private final By loginInBookStore = By.xpath("//h5[contains(.,'Login in Book Store')]");
    private final By username = By.id("userName");
    private final By password = By.id("password");
    private final By loginButton = By.id("login");
    private final By newUserButton = By.id("newUser");
    private final By errorMessage = By.id("name");
    private final By profile = By.id("userName-value");
    private final By logoutButton = By.xpath("//button[contains(.,'Log out')]");
    private final By goToBookStoreButton = By.xpath("//button[@id='gotoStore']");
    private final By deleteAccountButton = By.xpath("//button[@type='button'][contains(.,'Delete Account')]");
    private final By deleteAllBooksButton = By.xpath("(//button[@type='button'][contains(.,'Delete All Books')])[1]");
    private final By loadingLabel = By.id("loading-label");
    private final By usernameLabel = By.id("userName-label");
    private final By passwordLabel = By.id("password-label");

    private final By loginText = By.xpath("//h5[contains(.,'Login in Book Store')]");

    public BooksLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getLoadingLabel() {
        return find(loadingLabel).getText();
    }

    public String getLoginText() {
        return find(loginText).getText();
    }

    public String getUsernamePlaceholder() {
        return find(username).getDomAttribute("placeholder");
    }

    public String getPasswordPlaceholder() {
        return find(password).getDomAttribute("placeholder");
    }

    public String getPasswordLabel() {
        return find(passwordLabel).getText();
    }

    public String getUsernameLabel() {
        return find(usernameLabel).getText();
    }

    public String getLoginHeaderText() {
        return find(header).getText();
    }

    public String getWelcomeText() {
        return find(welcomeText).getText();
    }

    public String getLoginInBookStoreText() {
        return find(loginInBookStore).getText();
    }

    public String getLoginButtonText() {
        return find(loginButton).getText();
    }

    public String getNewUserButtonText() {
        return find(newUserButton).getText();
    }

    public void clickGoToBookStoreButton() {
        find(goToBookStoreButton).click();
    }

    public void clickDeleteAccountButton() {
        find(deleteAccountButton).click();
    }

    public void clickDeleteAllBooksButton() {
        find(deleteAllBooksButton).click();
    }

    public void clickLogoutButton() {
        find(logoutButton).click();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.elementToBeClickable(errorMessage));
        return find(errorMessage).getText();
    }

    public void clickUsername() {
        scrollToElementJS(username);
        click(username);
    }

    public void clickPassword() {
        click(password);
    }

    public void clickLoginButton() {
        scrollToElementJS(loginButton);
        find(loginButton).click();
    }

    public String getProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/profile"));
        wait.until(ExpectedConditions.elementToBeClickable(profile));
        return find(profile).getText();
    }

    public void clickNewUserButton() {
        scrollToElementJS(newUserButton);
        click(newUserButton);
    }

    public void setUsername(String username2) {
        set(username, username2);
    }

    public void setPassword(String password2) {
        set(password, password2);
    }


}
