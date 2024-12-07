package com.pages.saucedemo.pages;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("#login_button_container h3");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public void setUsername(String username) {
        set(usernameField, username);
    }

    public void setPassword(String password) {
        set(passwordField, password);
    }

    public ProductsPage clickLoginButton() {
        click(loginButton);
        return new ProductsPage();
    }

    public ProductsPage loginIntoApplication(String username, String password) {
        setPassword(password);
        setUsername(username);
        return clickLoginButton();
    }

    public String getErrorMessage() {
        //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(errorMessage.toString())));
        return find(errorMessage).getText();
    }
}
