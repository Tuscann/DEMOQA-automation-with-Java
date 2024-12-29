package demoqa.pages.bookstore;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class BooksRegisterPage extends BasePage {
    private final By firstName = By.id("firstname");
    private final By lastName = By.id("lastname");
    private final By username = By.id("userName");
    private final By password = By.id("password");
    private final By registerButton = By.id("register");
    private final By backToLoginButton = By.id("gotologin");
    private final By IamRobotButton = By.id("g-recaptcha");
    private final By errorMessage = By.id("name");

    private final By firstNameField = By.xpath("//input[@id='firstname']");
    private final By lastNameField = By.xpath("//input[@id='lastname']");
    private final By userNameField = By.xpath("//input[@id='userName']");
    private final By passwordNameField = By.xpath("//input[@id='password']");

    private final By title = By.xpath("//h1[contains(.,'Register')]");
    private final By firstText = By.xpath("//h4[contains(.,'Register to Book Store')]");
    private final By firstNameLabel = By.xpath("//label[@id='firstname-label']");
    private final By lastNameLabel = By.xpath("//label[@id='lastname-label']");
    private final By userNameLabel = By.xpath("//label[@id='userName-label']");
    private final By passwordLabel = By.xpath("//label[@id='password-label']");

    public String getFirstNamePlaceholderText() {
        return find(firstNameField).getDomAttribute("placeholder");
    }

    public String getLastNamePlaceholderText() {
        return find(lastNameField).getDomAttribute("placeholder");
    }

    public String getUsernamePlaceholderText() {
        return find(userNameField).getDomAttribute("placeholder");
    }

    public String getPasswordPlaceholderText() {
        return find(passwordNameField).getDomAttribute("placeholder");
    }

    public String getTitle() {
        return find(title).getText();
    }

    public String getFirstText() {
        return find(firstText).getText();
    }

    public String getTextOfRegisterButton() {
        return find(registerButton).getText();
    }

    public String getTextOfBackToLoginButton() {
        return find(backToLoginButton).getText();
    }

    public String getFirstNameLabel() {
        return find(firstNameLabel).getText();
    }

    public String getLastNameLabel() {
        return find(lastNameLabel).getText();
    }

    public String getUsernameLabel() {
        return find(userNameLabel).getText();
    }

    public String getPasswordLabel() {
        return find(passwordLabel).getText();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        return find(errorMessage).getText();
    }

    public void setFirstName(String firstName2) {
        scrollToElementJS(firstName);
        click(firstName);
        set(firstName, firstName2);
    }

    public void setLastName(String lastName2) {
        scrollToElementJS(lastName);
        click(lastName);
        set(lastName, lastName2);
    }

    public void setUsername(String username) {
        scrollToElementJS(this.username);
        click(this.username);
        set(this.username, username);
    }

    public void setPassword(String password) {
        scrollToElementJS(this.password);
        click(this.password);
        set(this.password, password);
    }

    public void clickIamRobotButton() {
        click(IamRobotButton);
    }

    public void clickRegisterButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        //TODO
        click(registerButton);
    }

    public void clickBackToLoginButton() {
        click(backToLoginButton);
    }
}
