package demoqa.web.tests.bookstore;

import com.github.javafaker.Faker;
import demoqa.pages.bookstore.BooksRegisterPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookRegisterPageTests extends BaseTest {
    // URL
    private static final String REGISTER_URL = "register";

    // Page Content
    public static final String PAGE_TITLE = "Register";
    public static final String HEADER_TEXT = "Register to Book Store";
    public static final String FIRST_NAME_LABEL = "First Name :";
    public static final String FIRST_NAME_PLACEHOLDER = "First Name";
    public static final String LAST_NAME_LABEL = "Last Name :";
    public static final String LAST_NAME_PLACEHOLDER = "Last Name";
    public static final String USERNAME_LABEL = "UserName :";
    public static final String USERNAME_PLACEHOLDER = "UserName";
    public static final String PASSWORD_LABEL = "Password :";
    public static final String PASSWORD_PLACEHOLDER = "Password";
    public static final String REGISTER_BUTTON_TEXT = "Register";
    public static final String BACK_TO_LOGIN_BUTTON_TEXT = "Back to Login";

    // Messages
    public static final String RECAPTCHA_ERROR_MESSAGE = "Please verify reCaptcha to register!";

    private BooksRegisterPage booksRegisterPage;
    private Faker faker;

    @BeforeMethod
    public void goToRegisterPage() {
        navigateToUrl(REGISTER_URL);
        booksRegisterPage = new BooksRegisterPage(driver);
        faker = new Faker();
    }

    @Test(enabled = true, testName = "Verify all text on Page")
    public void verifyAllTextOnPage() {
        // Arrange
        // Act
        String actualTitleText = booksRegisterPage.getTitle();
        String actualFirstText = booksRegisterPage.getFirstText();
        String actualFirstNameLabel = booksRegisterPage.getFirstNameLabel();
        String actualLastNameLabel = booksRegisterPage.getLastNameLabel();
        String actualUserNameLabel = booksRegisterPage.getUsernameLabel();
        String actualPasswordLabel = booksRegisterPage.getPasswordLabel();

        String actualFirstNamePlaceholder = booksRegisterPage.getFirstNamePlaceholderText();
        String actualLastNamePlaceholder = booksRegisterPage.getLastNamePlaceholderText();
        String actualUserNamePlaceholder = booksRegisterPage.getUsernamePlaceholderText();
        String actualPasswordPlaceholder = booksRegisterPage.getPasswordPlaceholderText();
        String actualRegisterButtonText = booksRegisterPage.getTextOfRegisterButton();
        String actualBackToLoginButtonText = booksRegisterPage.getTextOfBackToLoginButton();

        // Assert
        softAssert.assertEquals(actualFirstNamePlaceholder, FIRST_NAME_PLACEHOLDER, "\nWrong first name placeholder.\n");
        softAssert.assertEquals(actualLastNamePlaceholder, LAST_NAME_PLACEHOLDER, "\nWrong last name placeholder.\n");
        softAssert.assertEquals(actualUserNamePlaceholder, USERNAME_PLACEHOLDER, "\nWrong username placeholder.\n");
        softAssert.assertEquals(actualPasswordPlaceholder, PASSWORD_PLACEHOLDER, "\nWrong password placeholder.\n");
        softAssert.assertEquals(actualTitleText, PAGE_TITLE, "\nWrong title placeholder.\n");
        softAssert.assertEquals(actualFirstText, HEADER_TEXT, "\nWrong first text placeholder.\n");
        softAssert.assertEquals(actualFirstNameLabel, FIRST_NAME_LABEL, "\nWrong first name label placeholder.\n");
        softAssert.assertEquals(actualLastNameLabel, LAST_NAME_LABEL, "\nWrong last name label placeholder.\n");
        softAssert.assertEquals(actualUserNameLabel, USERNAME_LABEL, "\nWrong username label placeholder.\n");
        softAssert.assertEquals(actualPasswordLabel, PASSWORD_LABEL, "\nWrong password label placeholder.\n");
        softAssert.assertEquals(actualRegisterButtonText, REGISTER_BUTTON_TEXT, "\nMissing register button.\n");
        softAssert.assertEquals(actualBackToLoginButtonText, BACK_TO_LOGIN_BUTTON_TEXT, "\nMissing backtologin button.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Try to login without recaptcha")
    public void tryToLoginWithoutReCaptcha() {
        // Arrange: Generate dynamic user data
        String expectedFirstName = faker.name().firstName();
        String expectedLastName = faker.name().lastName();
        String expectedUsername = faker.name().username();
        // Generate a password that meets complexity requirements
        String expectedPassword = faker.internet().password(8, 16, true, false, true) + "A1!";

        // Act
        booksRegisterPage.setFirstName(expectedFirstName);
        booksRegisterPage.setLastName(expectedLastName);
        booksRegisterPage.setUsername(expectedUsername);
        booksRegisterPage.setPassword(expectedPassword);
        booksRegisterPage.clickIamRobotButton();
        booksRegisterPage.clickRegisterButton();
        String actualErrorMessage = booksRegisterPage.getErrorMessage();

        // Assert
        softAssert.assertEquals(actualErrorMessage, RECAPTCHA_ERROR_MESSAGE, "\nWrong error message.\n");
        softAssert.assertAll();
    }
}
