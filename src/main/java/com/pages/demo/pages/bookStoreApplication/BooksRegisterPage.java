package com.pages.demo.pages.bookStoreApplication;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class BooksRegisterPage extends BasePage {
    private final By firstName = By.id("firstname");
    private final By lastName = By.id("lastname");
    private final By username = By.id("userName");
    private final By password = By.id("password");
    private final By registerButton = By.id("register");
    private final By backToLoginButton = By.id("gotologin");
    private final By IamRobotButton = By.id("g-recaptcha");
    private final By errorMessage = By.id("name");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

    public void setFirstName(String firstName2) {
        scrollToElementJS(firstName);
        click(firstName);
        set(firstName, firstName2);
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        return find(errorMessage).getText();
    }

    public void setLastName(String lastName2) {
        scrollToElementJS(lastName);
        click(lastName);
        set(lastName, lastName2);
    }

    public void setUsername(String username) {
        scrollToElementJS(this.username);
        click(this.username);
        set(this.username, username);
    }

    public void setPassword(String password) {
        scrollToElementJS(this.password);
        click(this.password);
        set(this.password, password);
    }

    public void clickIamRobotButton() {
        click(IamRobotButton);
    }

    public void clickRegisterButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        //TODO
        click(registerButton);
    }

    public void clickBackToLoginButton() {
        click(backToLoginButton);
    }
}
