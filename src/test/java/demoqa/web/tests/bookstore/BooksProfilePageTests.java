package demoqa.web.tests.bookstore;

import demoqa.pages.bookstore.BooksProfilePage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BooksProfilePageTests extends BaseTest {
    // URL Constants
    private static final String BOOKS_PROFILE_PAGE_URL = "profile";
    private static final String EXPECTED_LOGIN_URL = DEMO_QA_URL + "login";
    private static final String EXPECTED_REGISTER_URL = DEMO_QA_URL + "register";

    // Message Constants
    private static final String EXPECTED_ERROR_MESSAGE = "Currently you are not logged into the Book Store application, please visit the login page to enter or register page to register yourself.";

    // Error Message Constants
    private static final String ERROR_MESSAGE_MISMATCH = "Error message text mismatch";
    private static final String LOGIN_URL_MISMATCH = "Login URL mismatch after clicking login link";
    private static final String REGISTER_URL_MISMATCH = "Register URL mismatch after clicking register link";

    private BooksProfilePage booksProfilePage;

    @BeforeMethod
    public void goToBooksProfilePage() {
        navigateToUrl(BOOKS_PROFILE_PAGE_URL);
        booksProfilePage = new BooksProfilePage(driver);
    }

    @Test(enabled = true, description = "Verify error message text when accessing profile without authentication")
    public void verifyMessageText() {
        // Arrange & Act
        String actualMessage = booksProfilePage.getLoggingWrapper();

        // Assert
        softAssert.assertEquals(actualMessage, EXPECTED_ERROR_MESSAGE, ERROR_MESSAGE_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify login link navigation and URL validation")
    public void verifyLoginLink() {
        // Arrange & Act
        booksProfilePage.clickLoginLink();
        String actualUrl = booksProfilePage.getLoginLink();

        // Assert
        softAssert.assertEquals(actualUrl, EXPECTED_LOGIN_URL, LOGIN_URL_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify register link navigation and URL validation")
    public void verifyRegisterLink() {
        // Arrange & Act
        booksProfilePage.clickRegisterLink();
        String actualUrl = booksProfilePage.getLoginLink();

        // Assert
        softAssert.assertEquals(actualUrl, EXPECTED_REGISTER_URL, REGISTER_URL_MISMATCH);
        softAssert.assertAll();
    }
}