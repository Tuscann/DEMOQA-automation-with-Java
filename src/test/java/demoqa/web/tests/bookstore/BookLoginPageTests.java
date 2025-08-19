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

    // Text Constants
    private static final String LOGIN_HEADER = "Login";
    private static final String WELCOME_TEXT = "Welcome,";
    private static final String LOGIN_IN_BOOK_STORE_TEXT = "Login in Book Store";
    private static final String USERNAME_LABEL = "UserName :";
    private static final String USERNAME_PLACEHOLDER = "UserName";
    private static final String PASSWORD_LABEL = "Password :";
    private static final String PASSWORD_PLACEHOLDER = "Password";
    private static final String LOGIN_BUTTON_TEXT = "Login";
    private static final String NEW_USER_BUTTON_TEXT = "New User";

    // Expected Text Constants
    private static final String EXPECTED_LOGIN_TEXT = "Login in Book Store";
    private static final String EXPECTED_ALREADY_LOGGED_IN_TEXT = "You are already logged in. View your profile.";
    private static final String EXPECTED_BOOKS_URL = "https://demoqa.com/books";
    private static final String INVALID_USERNAME_PASSWORD_ERROR = "Invalid username or password!";

    // Error Message Constants
    private static final String LOGIN_HEADER_ERROR = "Login header text mismatch";
    private static final String WELCOME_TEXT_ERROR = "Welcome text mismatch";
    private static final String LOGIN_IN_BOOK_STORE_ERROR = "Login in book store text mismatch";
    private static final String USERNAME_LABEL_ERROR = "Username label mismatch";
    private static final String USERNAME_PLACEHOLDER_ERROR = "Username placeholder mismatch";
    private static final String PASSWORD_LABEL_ERROR = "Password label mismatch";
    private static final String PASSWORD_PLACEHOLDER_ERROR = "Password placeholder mismatch";
    private static final String LOGIN_BUTTON_ERROR = "Login button text mismatch";
    private static final String NEW_USER_BUTTON_ERROR = "New user button text mismatch";
    private static final String USERNAME_MISMATCH_ERROR = "Username does not match";
    private static final String ERROR_MESSAGE_ERROR = "Error message mismatch";
    private static final String LOGIN_TEXT_ERROR = "Login text mismatch";
    private static final String BOOKS_URL_ERROR = "Books URL mismatch";
    private static final String ALREADY_LOGGED_IN_ERROR = "Already logged in message mismatch";

    private BooksLoginPage booksLoginPage;

    @BeforeMethod
    public void goToLoginPage() {
        navigateToUrl(LOGIN_URL);
        booksLoginPage = new BooksLoginPage(driver);
    }

    @Test(enabled = true, description = "Verify all static text elements on the book login page")
    public void verifyAllTextOnPage() {
        // Arrange
        // Act
        // Assert
        softAssert.assertEquals(booksLoginPage.getLoginHeaderText(), LOGIN_HEADER, LOGIN_HEADER_ERROR);
        softAssert.assertEquals(booksLoginPage.getWelcomeText(), WELCOME_TEXT, WELCOME_TEXT_ERROR);
        softAssert.assertEquals(booksLoginPage.getLoginInBookStoreText(), LOGIN_IN_BOOK_STORE_TEXT, LOGIN_IN_BOOK_STORE_ERROR);
        softAssert.assertEquals(booksLoginPage.getUsernameLabel(), USERNAME_LABEL, USERNAME_LABEL_ERROR);
        softAssert.assertEquals(booksLoginPage.getUsernamePlaceholder(), USERNAME_PLACEHOLDER, USERNAME_PLACEHOLDER_ERROR);
        softAssert.assertEquals(booksLoginPage.getPasswordLabel(), PASSWORD_LABEL, PASSWORD_LABEL_ERROR);
        softAssert.assertEquals(booksLoginPage.getPasswordPlaceholder(), PASSWORD_PLACEHOLDER, PASSWORD_PLACEHOLDER_ERROR);
        softAssert.assertEquals(booksLoginPage.getLoginButtonText(), LOGIN_BUTTON_TEXT, LOGIN_BUTTON_ERROR);
        softAssert.assertEquals(booksLoginPage.getNewUserButtonText(), NEW_USER_BUTTON_TEXT, NEW_USER_BUTTON_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Successfully authenticate with valid username and password")
    public void loginWithValidUsernameAndValidPassword() {
        // Arrange & Act        
        booksLoginPage.setUsername(VALID_USERNAME);
        booksLoginPage.setPassword(VALID_PASSWORD);
        booksLoginPage.clickLoginButton();

        // Assert
        String actualProfile = booksLoginPage.getProfile();
        softAssert.assertEquals(actualProfile, VALID_USERNAME, USERNAME_MISMATCH_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify appropriate error message when using invalid username")
    public void tryToLoginWithWrongUsername() {
        // Arrange & Act
        booksLoginPage.setUsername(INVALID_USERNAME);
        booksLoginPage.setPassword(VALID_PASSWORD);
        booksLoginPage.clickLoginButton();
        String actualMessage = booksLoginPage.getErrorMessage();

        // Assert
        softAssert.assertEquals(actualMessage, INVALID_USERNAME_PASSWORD_ERROR, ERROR_MESSAGE_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify error message when using both invalid username and password")
    public void tryToLoginWithWrongUsernameAndWrongPassword() {
        // Arrange & Act
        booksLoginPage.setUsername(INVALID_USERNAME);
        booksLoginPage.setPassword(INVALID_PASSWORD);
        booksLoginPage.clickLoginButton();
        String actualMessage = booksLoginPage.getErrorMessage();

        // Assert
        softAssert.assertEquals(actualMessage, INVALID_USERNAME_PASSWORD_ERROR, ERROR_MESSAGE_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify error message when using invalid password with valid username")
    public void tryToLoginWithWrongPassword() {
        // Arrange & Act
        booksLoginPage.setUsername(VALID_USERNAME);
        booksLoginPage.setPassword(INVALID_PASSWORD);
        booksLoginPage.clickLoginButton();
        String actualErrorMessage = booksLoginPage.getErrorMessage();

        // Assert
        softAssert.assertEquals(actualErrorMessage, INVALID_USERNAME_PASSWORD_ERROR, ERROR_MESSAGE_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify logout functionality after successful login")
    public void clickLogoutAfterLogin() {
        // Arrange & Act
        booksLoginPage.setUsername(VALID_USERNAME);
        booksLoginPage.setPassword(VALID_PASSWORD);
        booksLoginPage.clickLoginButton();

        String actualProfile = booksLoginPage.getProfile();
        booksLoginPage.clickLogoutButton();
        String actualLoginText = booksLoginPage.getLoginText();

        // Assert
        softAssert.assertEquals(actualLoginText, EXPECTED_LOGIN_TEXT, LOGIN_TEXT_ERROR);
        softAssert.assertEquals(actualProfile, VALID_USERNAME, USERNAME_MISMATCH_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify navigation to book store after successful login")
    public void clickOnButtonGoToBookStore() {
        // Arrange
        BooksProfilePage booksProfilePage = new BooksProfilePage(driver);
        BooksPage booksPage = new BooksPage(driver);

        // Act
        booksLoginPage.setUsername(VALID_USERNAME);
        booksLoginPage.setPassword(VALID_PASSWORD);
        booksLoginPage.clickLoginButton();
        booksProfilePage.clickGoToBookStoreButton();
        String actualUrl = booksPage.checkUrl();

        // Assert
        softAssert.assertEquals(actualUrl, EXPECTED_BOOKS_URL, BOOKS_URL_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify login page state when user is already logged in")
    public void verifyLoginPageAfterLogin() {
        // Arrange
        BooksProfilePage booksProfilePage = new BooksProfilePage(driver);

        // Act
        booksLoginPage.setUsername(VALID_USERNAME);
        booksLoginPage.setPassword(VALID_PASSWORD);
        booksLoginPage.clickLoginButton();
        booksProfilePage.clickGoToBookStoreButton();
        booksProfilePage.clickLeftLoginLink2();
        String actualLabel = booksLoginPage.getLoadingLabel();

        // Assert
        softAssert.assertEquals(actualLabel, EXPECTED_ALREADY_LOGGED_IN_TEXT, ALREADY_LOGGED_IN_ERROR);
        softAssert.assertAll();
    }
}