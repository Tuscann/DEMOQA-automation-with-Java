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

public class BooksProfilePage extends BasePage {
    private final JavaScriptUtility javaScriptUtility;
    @FindBy(id = "userName-value")
    WebElement username;
    @FindBy(id = "notLoggin-label")
    WebElement notLoggingWrapper;
    @FindBy(xpath = "//a[@href='/login'][contains(.,'login')]")
    WebElement loginLink;
    @FindBy(xpath = "//span[@class='text'][contains(.,'Login')]")
    WebElement loginLink2;
    @FindBy(xpath = "//a[@href='/register']")
    WebElement registerLink;
    @FindBy(id = "gotoStore")
    WebElement goToBookStoreButton;
    @FindBy(id = "userName-value")
    WebElement profile;
    @FindBy(id = "submit")
    WebElement logOutButtonTop;
    @FindBy(xpath = "//li[contains(.,'Login')]")
    WebElement loginTab;
    @FindBy(xpath = "(//button[@type='button'][contains(.,'Delete All Books')])[1]")
    WebElement deleteAllBooksButton;
    @FindBy(id = "example-modal-sizes-title-sm")
    WebElement popTitle;
    @FindBy(xpath = "//div[@class='modal-body']")
    WebElement modalWindowQuestion;
    @FindBy(xpath = "//button[contains(@id,'closeSmallModal-ok')]")
    WebElement modalOkButton;
    @FindBy(xpath = "//button[contains(@id,'closeSmallModal-cancel')]")
    WebElement modalCancelButton;
    @FindBy(xpath = "//button[@type='button'][contains(.,'Delete Account')]")
    WebElement deleteAccountButton;

    public BooksProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public String getUsername() {
        return username.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getLoggingWrapper() {
        return notLoggingWrapper.getText();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void clickRegisterLink() {
        registerLink.click();
    }

    public void clickGoToBookStoreButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/profile"));
        wait.until(ExpectedConditions.elementToBeClickable(profile));
        javaScriptUtility.scrollToElementJS(goToBookStoreButton);
        goToBookStoreButton.click();
    }

    public String getLogOutButtonText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/profile"));
        wait.until(ExpectedConditions.elementToBeClickable(logOutButtonTop));
        return logOutButtonTop.getText();
    }

    public void clickLoginTab() {
        loginTab.click();
    }

    public void clickDeleteAllBooks() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/profile"));
        wait.until(ExpectedConditions.elementToBeClickable(deleteAllBooksButton));
        javaScriptUtility.scrollToElementJS(deleteAccountButton);
        deleteAllBooksButton.click();
    }

    public String getPopTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.elementToBeClickable(popTitle));
        return popTitle.getText();
    }

    public String getModalWindowQuestion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.elementToBeClickable(modalWindowQuestion));
        return modalWindowQuestion.getText();
    }

    public String getModalWindowOkButtonText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.elementToBeClickable(modalOkButton));
        return modalOkButton.getText();
    }

    public String getModalWindowCancelButtonText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.elementToBeClickable(modalCancelButton));
        return modalCancelButton.getText();
    }

    public void clickDeleteAccountButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.elementToBeClickable(deleteAccountButton));
        javaScriptUtility.scrollToElementJS(deleteAccountButton);
        deleteAccountButton.click();
    }
}
