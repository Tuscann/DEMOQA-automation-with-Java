package demoqa.web.tests.bookStoreApplication;

import demoqa.pages.bookstore.BooksLoginPage;
import demoqa.pages.bookstore.BooksProfilePage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTests extends BaseTest {
    // Page Content
    private static final String VALID_USERNAME = "fbinnzhivko";
    private static final String VALID_PASSWORD = "Karma1987!@";
    private static final String DELETE_ALL_BOOKS = "Delete All Books";
    private static final String DO_WANT_DELETE_ALL_BOOKS = "Do you want to delete all books?";
    private static final String OK = "OK";
    private static final String CANCEL = "Cancel";


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
    private static final String DELETE_ALL_BOOKS_MISMATCH = "Delete All Books mismatch";
    private static final String DELETE_ACCOUNT = "Delete Account";
    private static final String DO_YOU_TO_DELETE_ACCOUNT = "Do you want to delete your account?";

    private BooksProfilePage booksProfilePage;

    @BeforeMethod
    public void goToBooksProfilePage() {
        navigateToUrl(BOOKS_PROFILE_PAGE_URL);
        booksProfilePage = new BooksProfilePage(driver);
    }

    @Test(enabled = true, description = "Verify login link navigation and URL validation")
    public void verifyLoginLink() {
        // Arrange & Act
        String actualMessage = booksProfilePage.getLoggingWrapper();
        booksProfilePage.clickLoginLink();
        String actualUrl = booksProfilePage.getCurrentUrl();

        // Assert
        softAssert.assertEquals(actualUrl, EXPECTED_LOGIN_URL, LOGIN_URL_MISMATCH);
        softAssert.assertEquals(actualMessage, EXPECTED_ERROR_MESSAGE, ERROR_MESSAGE_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify register link navigation and URL validation")
    public void verifyRegisterLink() {
        // Arrange & Act
        booksProfilePage.clickRegisterLink();
        String actualUrl = booksProfilePage.getCurrentUrl();

        // Assert
        softAssert.assertEquals(actualUrl, EXPECTED_REGISTER_URL, REGISTER_URL_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify text of pop window after click delete all books")
    public void clickOnButtonDeleteAllBooks() {
        // Arrange
        BooksLoginPage booksLoginPage = new BooksLoginPage(driver);
        booksProfilePage.clickLoginTab();

        // Act
        booksLoginPage.setUsername(VALID_USERNAME);
        booksLoginPage.setPassword(VALID_PASSWORD);
        booksLoginPage.clickLoginButton();
        booksProfilePage.clickDeleteAllBooks();

        String popTitle = booksProfilePage.getPopTitle();
        String modalQuestion = booksProfilePage.getModalWindowQuestion();
        String modalWindowOkButtonText = booksProfilePage.getModalWindowOkButtonText();
        String modalWindowCancelButtonText = booksProfilePage.getModalWindowCancelButtonText();

        // Assert
        softAssert.assertEquals(popTitle, DELETE_ALL_BOOKS, DELETE_ALL_BOOKS_MISMATCH);
        softAssert.assertEquals(modalQuestion, DO_WANT_DELETE_ALL_BOOKS, "Modal question should be the same");
        softAssert.assertEquals(modalWindowOkButtonText, OK, "Ok button should be the same");
        softAssert.assertEquals(modalWindowCancelButtonText, CANCEL, "Cancel button should be the same");
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify text on pop window after click delete account button")
    public void clickOnButtonDeleteAccount() {
        // Arrange
        BooksLoginPage booksLoginPage = new BooksLoginPage(driver);
        booksProfilePage.clickLoginTab();

        // Act
        booksLoginPage.setUsername(VALID_USERNAME);
        booksLoginPage.setPassword(VALID_PASSWORD);
        booksLoginPage.clickLoginButton();
        booksProfilePage.clickDeleteAccountButton();

        String popTitle = booksProfilePage.getPopTitle();
        String modalQuestion = booksProfilePage.getModalWindowQuestion();
        String modalWindowOkButtonText = booksProfilePage.getModalWindowOkButtonText();
        String modalWindowCancelButtonText = booksProfilePage.getModalWindowCancelButtonText();

        // Assert
        softAssert.assertEquals(popTitle, DELETE_ACCOUNT, "Title should be the same");
        softAssert.assertEquals(modalQuestion, DO_YOU_TO_DELETE_ACCOUNT, "Modal question should be the same");
        softAssert.assertEquals(modalWindowOkButtonText, OK, "Ok button should be the same");
        softAssert.assertEquals(modalWindowCancelButtonText, CANCEL, "Cancel button should be the same");
        softAssert.assertAll();
    }

}