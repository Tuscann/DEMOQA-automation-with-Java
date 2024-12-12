package com.pages.demo.pages.bookStoreApplication;

import com.pages.base.BasePage;
import org.openqa.selenium.By;

public class BooksProfilePage extends BasePage {
    private final By username = By.id("userName-value");
    private final By notLogginWrapper = By.id("notLoggin-label");
    private final By loginLink = By.xpath("//a[@href='/login'][contains(.,'login')]");
    private final By registerLink = By.xpath("//a[@href='/register']");
    private final By goToBookStoreButton = By.id("gotoStore");
    private final By deleteAccountButton = By.id("gotoStore");
    private final By deleteAllBooksButton = By.id("gotoStore");

    public void clickUsername() {
        click(username);
    }

    public void clickLoginLink() {
        click(loginLink);
    }

    public void clickGoToBookStoreButton() {
        click(goToBookStoreButton);
    }

    public void clickRegisterLink() {
        click(registerLink);
    }

    public String getUsername() {
        return find(username).getText();
    }

    public String getLoginLink() {
        return driver.getCurrentUrl();
    }

    public String getNotLogginWrapper() {
        return find(notLogginWrapper).getText();
    }

}
