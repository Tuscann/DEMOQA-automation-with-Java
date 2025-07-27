package demoqa.web.tests.bookstore;

import demoqa.pages.bookstore.BooksProfilePage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.Test;

public class BooksProfilePageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify message text")
    public void VerifyMessageText() {
        // Arrange
        navigateToUrl("profile");
        BooksProfilePage booksProfilePage = new BooksProfilePage(driver);
        String expectedErrorMessage = "Currently you are not logged into the Book Store application, please visit the login page to enter or register page to register yourself.";

        // Act
        String actualMessage = booksProfilePage.getLoggingWrapper();

        // Assert
        softAssert.assertEquals(actualMessage, expectedErrorMessage, "\nWrong error message.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify login link")
    public void VerifyLoginLink() {
        // Arrange
        navigateToUrl("profile");
        BooksProfilePage booksProfilePage = new BooksProfilePage(driver);
        String expectedLoginUrl = "https://demoqa.com/login";

        // Act
        booksProfilePage.clickLoginLink();
        String actualUrl = booksProfilePage.getLoginLink();

        // Assert
        softAssert.assertEquals(actualUrl, expectedLoginUrl, "\nWrong url.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify register link")
    public void VerifyRegisterLink() {
        // Arrange
        navigateToUrl("profile");
        BooksProfilePage booksProfilePage = new BooksProfilePage(driver);
        String expectedLoginUrl = "https://demoqa.com/register";

        // Act
        booksProfilePage.clickRegisterLink();
        String actualUrl = booksProfilePage.getLoginLink();

        // Assert
        softAssert.assertEquals(actualUrl, expectedLoginUrl, "\nWrong password message.\n");
        softAssert.assertAll();
    }
}