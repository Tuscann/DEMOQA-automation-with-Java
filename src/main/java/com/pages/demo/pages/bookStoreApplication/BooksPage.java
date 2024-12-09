package com.pages.demo.pages.bookStoreApplication;

import com.pages.base.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class BooksPage extends BasePage {
    private final By loginLink = By.xpath("//span[@class='text'][contains(.,'Login')]");
    private final By profileLink = By.xpath("//span[@class='text'][contains(.,'Profile')]");
    private final By BookStoreAPILink = By.xpath("//span[contains(.,'Book Store API')]");

    public LoginPage clickLoginLink() {
        scrollToElementJS(loginLink);
        click(loginLink);
        return new LoginPage();
    }

    public ProfilePage clickProfileLink() {
        click(loginLink);
        return new ProfilePage();
    }

    public BookStoreAPIPage clickBookStoreAPILink() {
        click(loginLink);
        return new BookStoreAPIPage();
    }
}
