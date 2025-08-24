package demoqa.pages.bookstore;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import utilities.JavaScriptUtility;

public class BooksProfilePage extends BasePage {
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

    private final JavaScriptUtility javaScriptUtility;

    public BooksProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public String getUsername() {
        return username.getText();
    }

    public String getLoginLink() {
        return driver.getCurrentUrl();
    }

    public String getLoggingWrapper() {
        return notLoggingWrapper.getText();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void clickLeftLoginLink2() {
        loginLink2.click();
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
}
