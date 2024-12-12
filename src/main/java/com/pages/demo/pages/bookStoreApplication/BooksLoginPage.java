package com.pages.demo.pages.bookStoreApplication;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class BooksLoginPage extends BasePage {
    private final By username = By.id("userName");
    private final By newUserButton = By.id("newUser");
    private final By password = By.id("password");
    private final By loginButton = By.id("login");
    private final By errorMessage = By.id("name");
    private final By profile = By.id("userName-value");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

    public String getErrorMessage() {

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
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(profile)));
        scrollToElementJS(profile);
        return find(profile).getText();
    }

    public BooksRegisterPage clickNewUserButton() {
        scrollToElementJS(newUserButton);
        click(newUserButton);
        return new BooksRegisterPage();
    }

    public void setUsername(String username2) {
        set(username, username2);
    }

    public void setPassword(String password2) {
        set(password, password2);
    }

    public String GetErrorMessage() {
        //  WebElement web = driver.findElement(errorMessage);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement textElement = driver.findElement(By.id("name"));
        String initialText = textElement.getText();

        WebElement button = driver.findElement(By.id("name"));
        button.click();

        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.id("text-element-id"), initialText))); // Wait until the text is not equal to the initial text

        // Retrieve the new text
        String newText = textElement.getText();
        return newText;
    }


}
