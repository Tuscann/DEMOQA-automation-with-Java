package com.pages.demo.pages.bookStoreApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class LoginPage extends BooksPage {
    private final By username = By.id("userName");
    private final By password = By.id("password");
    private final By loginButton = By.id("login");
    private final By newUserButton = By.id("newUser");
    private final By errorMessage = By.id("name");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

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

    public RegisterBookStorePage clickNewUserButton() {
        scrollToElementJS(newUserButton);
        click(newUserButton);
        return new RegisterBookStorePage();
    }

    public void setUsername(String username2) {
        set(username, username2);
    }

    public void setPassword(String password2) {
        set(password, password2);
    }

    public String GetErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        return find(errorMessage).getText();
    }
}
