package part3.comdemoqa.tests.bookstore;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class BooksProfilePageTest extends BaseTest {

    @Test(enabled = true)
    public void VerifyMessageText() {
        navigateToUrl("profile");

        String expectedErrorMessage = "Currently you are not logged into the Book Store application, please visit the login page to enter or register page to register yourself.";

        String actualMessage = booksProfilePage.getLoggingWrapper();

        Assert.assertEquals(actualMessage, expectedErrorMessage, "Wrong password message");
    }

    @Test(enabled = true)
    public void VerifyLoginLink() {
        navigateToUrl("profile");

        String expectedLoginUrl = "https://demoqa.com/login";
        booksProfilePage.clickLoginLink();

        String actualUrl = booksProfilePage.getLoginLink();

        Assert.assertEquals(actualUrl, expectedLoginUrl, "Wrong password message");
    }

    @Test(enabled = true)
    public void VerifyRegisterLink() {
        navigateToUrl("profile");

        String expectedLoginUrl = "https://demoqa.com/register";

        booksProfilePage.clickRegisterLink();
        String actualUrl = booksProfilePage.getLoginLink();

        Assert.assertEquals(actualUrl, expectedLoginUrl, "Wrong password message");
    }
}