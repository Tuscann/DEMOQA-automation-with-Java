package com.pages.demo.pages.bookStoreApplication;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
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
