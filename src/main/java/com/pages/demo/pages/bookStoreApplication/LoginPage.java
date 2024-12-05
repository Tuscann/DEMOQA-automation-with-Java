package com.pages.demo.pages.bookStoreApplication;

import org.openqa.selenium.By;

public class LoginPage extends BooksPage {
    private final By username = By.id("userName");
    private final By password = By.id("password");
    private final By loginButton = By.id("login");
    private final By newUser = By.id("newUser");

    public void clickUsername() {
        click(username);
    }

    public void clickPassword() {
        click(password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void setUsername(String username2) {
        set(username, username2);
    }

    public void setPassword(String password2) {
        set(password, password2);
    }
}
