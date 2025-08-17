package demoqa.web.tests.bookstore;

import demoqa.pages.bookstore.BooksProfilePage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BooksProfilePageTests extends BaseTest {
    private static final String EXPECTED_ERROR_MESSAGE = "Currently you are not logged into the Book Store application, please visit the login page to enter or register page to register yourself.";
    private static final String EXPECTED_LOGIN_URL = "https://demoqa.com/login";
    private static final String EXPECTED_REGISTER_URL = "https://demoqa.com/register";

    private static final String BOOKS_PROFILE_PAGE_URL = "profile";
    private BooksProfilePage booksProfilePage;

    @BeforeMethod
    public void goToBooksProfilePage() {
        navigateToUrl(BOOKS_PROFILE_PAGE_URL);
        booksProfilePage = new BooksProfilePage(driver);
    }

    @Test(enabled = true, testName = "Verify message text")
    public void VerifyMessageText() {
        // Arrange
        // Act
        String actualMessage = booksProfilePage.getLoggingWrapper();

        // Assert
        softAssert.assertEquals(actualMessage, EXPECTED_ERROR_MESSAGE, "\nWrong error message.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify login link")
    public void VerifyLoginLink() {
        // Arrange
        // Act
        booksProfilePage.clickLoginLink();
        String actualUrl = booksProfilePage.getLoginLink();

        // Assert
        softAssert.assertEquals(actualUrl, EXPECTED_LOGIN_URL, "\nWrong url.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify register link")
    public void VerifyRegisterLink() {
        // Arrange
        // Act
        booksProfilePage.clickRegisterLink();
        String actualUrl = booksProfilePage.getLoginLink();

        // Assert
        softAssert.assertEquals(actualUrl, EXPECTED_REGISTER_URL, "\nWrong password message.\n");
        softAssert.assertAll();
    }
}