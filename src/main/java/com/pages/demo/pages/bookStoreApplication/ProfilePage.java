package com.pages.demo.pages.bookStoreApplication;

import org.openqa.selenium.By;

public class ProfilePage extends BooksPage {
    private final By username = By.id("userName-value");

    public void clickUsername() {
        click(username);
    }

    public String getUsername() {
        return find(username).getText();
    }
}
