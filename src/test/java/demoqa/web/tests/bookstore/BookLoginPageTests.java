package demoqa.web.tests.bookstore;

import demoqa.pages.bookstore.BooksLoginPage;
import demoqa.pages.bookstore.BooksPage;
import demoqa.pages.bookstore.BooksProfilePage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookLoginPageTests extends BaseTest {

    // Page Content
    private static final String VALID_USERNAME = "fbinnzhivko";
    private static final String VALID_PASSWORD = "Karma1987!@";
    private static final String INVALID_USERNAME = "wrongUser";
    private static final String INVALID_PASSWORD = "wrongPass";

    // URL
    private static final String LOGIN_URL = "login";
    private BooksLoginPage booksLoginPage;

    @BeforeMethod
    public void goToLoginPage() {
        navigateToUrl(LOGIN_URL);
        booksLoginPage = new BooksLoginPage(driver);
    }

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        // Arrange
        // Act
        // Assert
        softAssert.assertEquals(booksLoginPage.getLoginHeaderText(), "Login", "Incorrect login header.");
        softAssert.assertEquals(booksLoginPage.getWelcomeText(), "Welcome,", "Incorrect welcome text.");
        softAssert.assertEquals(booksLoginPage.getLoginInBookStoreText(), "Login in Book Store", "Incorrect subtitle.");
        softAssert.assertEquals(booksLoginPage.getUsernameLabel(), "UserName :", "Incorrect username label.");
        softAssert.assertEquals(booksLoginPage.getUsernamePlaceholder(), "UserName", "Incorrect username placeholder.");
        softAssert.assertEquals(booksLoginPage.getPasswordLabel(), "Password :", "Incorrect password label.");
        softAssert.assertEquals(booksLoginPage.getPasswordPlaceholder(), "Password", "Incorrect password placeholder.");
        softAssert.assertEquals(booksLoginPage.getLoginButtonText(), "Login", "Incorrect login button text.");
        softAssert.assertEquals(booksLoginPage.getNewUserButtonText(), "New User", "Incorrect new user button text.");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Login with valid username and valid password")
    public void LoginWithValidUsernameAndValidPassword() {
        // Arrange
        // Act
        booksLoginPage.setUsername(VALID_USERNAME);
        booksLoginPage.setPassword(VALID_PASSWORD);
        booksLoginPage.clickLoginButton();

        // Assert
        String actualProfile = booksLoginPage.getProfile();
        softAssert.assertEquals(actualProfile, VALID_USERNAME, "\nUsername does not match.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Try to login with wrong username")
    public void TryToLoginWithWrongUsername() {
        // Arrange
        String expectedMessage = "Invalid username or password!";

        // Act
        booksLoginPage.setUsername(INVALID_USERNAME);
        booksLoginPage.setPassword(VALID_PASSWORD);
        booksLoginPage.clickLoginButton();
        String actualMessage = booksLoginPage.getErrorMessage();

        // Assert
        softAssert.assertEquals(actualMessage, expectedMessage, "\nWrong username or password.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Try to login with wrong username and wrong password")
    public void TryToLoginWithWrongUsernameAndWrongPassword() {
        // Arrange
        String expectedMessage = "Invalid username or password!";

        // Act
        booksLoginPage.setUsername(INVALID_USERNAME);
        booksLoginPage.setPassword(INVALID_PASSWORD);
        booksLoginPage.clickLoginButton();
        String actualMessage = booksLoginPage.getErrorMessage();

        // Assert
        softAssert.assertEquals(actualMessage, expectedMessage, "\nWrong username or password.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Try to login with wrong password")
    public void TryToLoginWithWrongPassword() {
        // Arrange
        String expectedErrorMessage = "Invalid username or password!";

        // Act
        booksLoginPage.setUsername(VALID_USERNAME);
        booksLoginPage.setPassword(INVALID_PASSWORD);
        booksLoginPage.clickLoginButton();
        String actualErrorMessage = booksLoginPage.getErrorMessage();

        // Assert
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "\nWrong password message.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click logout after login")
    public void ClickLogoutAfterLogin() {
        // Arrange
        String expectedLoginText = "Login in Book Store";

        // Act
        booksLoginPage.setUsername(VALID_USERNAME);
        booksLoginPage.setPassword(VALID_PASSWORD);
        booksLoginPage.clickLoginButton();

        String actualProfile = booksLoginPage.getProfile();
        booksLoginPage.clickLogoutButton();
        String actualLoginText = booksLoginPage.getLoginText();

        // Assert
        softAssert.assertEquals(actualLoginText, expectedLoginText, "\nNot same login text.\n");
        softAssert.assertEquals(actualProfile, VALID_USERNAME, "\nNot same username.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on button gotobookstore")
    public void ClickOnButtonGotoBookStore() {
        // Arrange
        BooksProfilePage booksProfilePage = new BooksProfilePage(driver);
        BooksPage booksPage = new BooksPage(driver);

        String expectedUrl = "https://demoqa.com/books";

        // Act
        booksLoginPage.setUsername(VALID_USERNAME);
        booksLoginPage.setPassword(VALID_PASSWORD);
        booksLoginPage.clickLoginButton();
        booksProfilePage.clickGoToBookStoreButton();
        String actualUrl = booksPage.checkUrl();

        // Assert
        softAssert.assertEquals(actualUrl, expectedUrl, "\nNot same books url.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify login page after login")
    public void VerifyLoginPageAfterLogin() {
        // Arrange
        BooksProfilePage booksProfilePage = new BooksProfilePage(driver);

        String expectedText = "You are already logged in. View your profile.";

        // Act
        booksLoginPage.setUsername(VALID_USERNAME);
        booksLoginPage.setPassword(VALID_PASSWORD);
        booksLoginPage.clickLoginButton();
        booksProfilePage.clickGoToBookStoreButton();
        booksProfilePage.clickLeftLoginLink2();
        String actualLabel = booksLoginPage.getLoadingLabel();

        // Assert
        softAssert.assertEquals(actualLabel, expectedText, "\nNot same label.\n");
        softAssert.assertAll();
    }
}