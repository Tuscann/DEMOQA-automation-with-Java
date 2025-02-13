package demoqa.web.tests.bookstore;

import demoqa.web.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BooksProfilePageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify message text")
    public void VerifyMessageText() {
        navigateToUrl("profile");

        String expectedErrorMessage = "Currently you are not logged into the Book Store application, please visit the login page to enter or register page to register yourself.";

        String actualMessage = booksProfilePage.getLoggingWrapper();

        Assert.assertEquals(actualMessage, expectedErrorMessage, "\nWrong error message.\n");
    }

    @Test(enabled = true, testName = "Verify login link")
    public void VerifyLoginLink() {
        navigateToUrl("profile");

        String expectedLoginUrl = "https://demoqa.com/login";
        booksProfilePage.clickLoginLink();

        String actualUrl = booksProfilePage.getLoginLink();

        Assert.assertEquals(actualUrl, expectedLoginUrl, "\nWrong url.\n");
    }

    @Test(enabled = true, testName = "Verify register link")
    public void VerifyRegisterLink() {
        navigateToUrl("profile");

        String expectedLoginUrl = "https://demoqa.com/register";

        booksProfilePage.clickRegisterLink();
        String actualUrl = booksProfilePage.getLoginLink();

        Assert.assertEquals(actualUrl, expectedLoginUrl, "\nWrong password message.\n");
    }
}