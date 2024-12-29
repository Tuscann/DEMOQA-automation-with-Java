package com.pages.demo.pages.bookStoreApplication;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BooksProfilePage extends BasePage {
    private final By username = By.id("userName-value");
    private final By notLoggingWrapper = By.id("notLoggin-label");
    private final By loginLink = By.xpath("//a[@href='/login'][contains(.,'login')]");
    private final By loginLink2 = By.xpath("//span[@class='text'][contains(.,'Login')]");
    private final By registerLink = By.xpath("//a[@href='/register']");
    private final By goToBookStoreButton = By.id("gotoStore");
    private final By profile = By.id("userName-value");
    private final By deleteAccountButton = By.xpath("(//button[@id='submit'])[2]");
    private final By deleteAllBooksButton = By.xpath("(//button[@type='button'][contains(.,'Delete All Books')])[1]");

    public String getUsername() {
        return find(username).getText();
    }

    public String getLoginLink() {
        return driver.getCurrentUrl();
    }

    public String getLoggingWrapper() {
        return find(notLoggingWrapper).getText();
    }

    public void clickLoginLink() {
        click(loginLink);
    }

    public void clickLoginLink2() {
        click(loginLink2);
    }

    public void clickRegisterLink() {
        click(registerLink);
    }

    public void clickUsername() {
        click(username);
    }


    public void clickGoToBookStoreButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/profile"));
        wait.until(ExpectedConditions.elementToBeClickable(profile));
        click(goToBookStoreButton);
    }

}
