package demoqa.pages.bookstore;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class BooksRegisterPage extends BasePage {
    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "userName")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "register")
    private WebElement registerButton;

    @FindBy(id = "gotologin")
    private WebElement backToLoginButton;

    @FindBy(id = "g-recaptcha")
    private WebElement iamRobotButton;

    @FindBy(id = "name")
    private WebElement errorMessage;

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='userName']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordNameField;

    @FindBy(xpath = "//h1[contains(.,'Register')]")
    private WebElement title;

    @FindBy(xpath = "//h4[contains(.,'Register to Book Store')]")
    private WebElement firstText;

    @FindBy(xpath = "//label[@id='firstname-label']")
    private WebElement firstNameLabel;

    @FindBy(xpath = "//label[@id='lastname-label']")
    private WebElement lastNameLabel;

    @FindBy(xpath = "//label[@id='userName-label']")
    private WebElement userNameLabel;

    @FindBy(xpath = "//label[@id='password-label']")
    private WebElement passwordLabel;

    public BooksRegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getFirstNamePlaceholderText() {
        return firstNameField.getDomAttribute("placeholder");
    }

    public String getLastNamePlaceholderText() {
        return lastNameField.getDomAttribute("placeholder");
    }

    public String getUsernamePlaceholderText() {
        return userNameField.getDomAttribute("placeholder");
    }

    public String getPasswordPlaceholderText() {
        return passwordNameField.getDomAttribute("placeholder");
    }

    public String getTitle() {
        return title.getText();
    }

    public String getFirstText() {
        return firstText.getText();
    }

    public String getTextOfRegisterButton() {
        return registerButton.getText();
    }

    public String getTextOfBackToLoginButton() {
        return backToLoginButton.getText();
    }

    public String getFirstNameLabel() {
        return firstNameLabel.getText();
    }

    public String getLastNameLabel() {
        return lastNameLabel.getText();
    }

    public String getUsernameLabel() {
        return userNameLabel.getText();
    }

    public String getPasswordLabel() {
        return passwordLabel.getText();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public void setFirstName(String firstNameText) {
        scrollToElementJS(firstName);
        firstName.click();
        firstName.sendKeys(firstNameText);
    }

    public void setLastName(String lastNameText) {
        scrollToElementJS(lastName);
        lastName.click();
        lastName.sendKeys(lastNameText);
    }

    public void setUsername(String usernameText) {
        scrollToElementJS(username);
        username.click();
        username.sendKeys(usernameText);
    }

    public void setPassword(String passwordText) {
        scrollToElementJS(password);
        password.click();
        password.sendKeys(passwordText);
    }

    public void clickIamRobotButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(iamRobotButton));
        iamRobotButton.click();
    }

    public void clickRegisterButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        registerButton.click();
    }

    public void clickBackToLoginButton() {
        backToLoginButton.click();
    }
}
