package demoqa.web.tests.bookStoreApplication;

import com.github.javafaker.Faker;
import demoqa.pages.bookstore.BooksRegisterPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTests extends BaseTest {
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
    // Color Constants
    private static final String EXPECTED_BLUE_COLOR = "rgba(0, 123, 255, 1)";
    // Error Message Constants
    private static final String FIRST_NAME_PLACEHOLDER_ERROR = "First name placeholder text mismatch";
    private static final String LAST_NAME_PLACEHOLDER_ERROR = "Last name placeholder text mismatch";
    private static final String USERNAME_PLACEHOLDER_ERROR = "Username placeholder text mismatch";
    private static final String PASSWORD_PLACEHOLDER_ERROR = "Password placeholder text mismatch";
    private static final String PAGE_TITLE_ERROR = "Page title text mismatch";
    private static final String HEADER_TEXT_ERROR = "Header text mismatch";
    private static final String FIRST_NAME_LABEL_ERROR = "First name label text mismatch";
    private static final String LAST_NAME_LABEL_ERROR = "Last name label text mismatch";
    private static final String USERNAME_LABEL_ERROR = "Username label text mismatch";
    private static final String PASSWORD_LABEL_ERROR = "Password label text mismatch";
    private static final String REGISTER_BUTTON_ERROR = "Register button text mismatch";
    private static final String BACK_TO_LOGIN_BUTTON_ERROR = "Back to login button text mismatch";
    private static final String RECAPTCHA_ERROR_MESSAGE_ERROR = "ReCAPTCHA error message mismatch";
    private static final String REGISTER_URL = "register";
    private BooksRegisterPage booksRegisterPage;
    private Faker faker;

    @BeforeMethod
    public void goToRegisterPage() {
        navigateToUrl(REGISTER_URL);
        booksRegisterPage = new BooksRegisterPage(driver);
        faker = new Faker();
    }

    @Test(enabled = true, description = "Verify all static text elements on the register page")
    public void verifyAllTextOnPage() {
        // Arrange & Act        
        String actualHeaderText = booksRegisterPage.getTitle();
        String actualFirstText = booksRegisterPage.getFirstText();
        String actualFirstNameLabel = booksRegisterPage.getFirstNameLabel();
        String actualFirstNamePlaceholder = booksRegisterPage.getFirstNamePlaceholderText();
        String actualLastNameLabel = booksRegisterPage.getLastNameLabel();
        String actualLastNamePlaceholder = booksRegisterPage.getLastNamePlaceholderText();
        String actualUserNameLabel = booksRegisterPage.getUsernameLabel();
        String actualUserNamePlaceholder = booksRegisterPage.getUsernamePlaceholderText();
        String actualPasswordLabel = booksRegisterPage.getPasswordLabel();
        String actualPasswordPlaceholder = booksRegisterPage.getPasswordPlaceholderText();
        String actualRegisterButtonText = booksRegisterPage.getTextOfRegisterButton();
        String actualRegisterButtonBackgroundColor = booksRegisterPage.getRegisterButtonBackgroundColor();
        String actualBackToLoginButtonText = booksRegisterPage.getBackToLoginButtonText();
        String actualBackToLoginButtonBackgroundColor = booksRegisterPage.getBackToLoginButtonBackgroundColor();

        // Assert
        softAssert.assertEquals(actualFirstNamePlaceholder, FIRST_NAME_PLACEHOLDER, FIRST_NAME_PLACEHOLDER_ERROR);
        softAssert.assertEquals(actualLastNamePlaceholder, LAST_NAME_PLACEHOLDER, LAST_NAME_PLACEHOLDER_ERROR);
        softAssert.assertEquals(actualUserNamePlaceholder, USERNAME_PLACEHOLDER, USERNAME_PLACEHOLDER_ERROR);
        softAssert.assertEquals(actualPasswordPlaceholder, PASSWORD_PLACEHOLDER, PASSWORD_PLACEHOLDER_ERROR);
        softAssert.assertEquals(actualHeaderText, PAGE_TITLE, PAGE_TITLE_ERROR);
        softAssert.assertEquals(actualFirstText, HEADER_TEXT, HEADER_TEXT_ERROR);
        softAssert.assertEquals(actualFirstNameLabel, FIRST_NAME_LABEL, FIRST_NAME_LABEL_ERROR);
        softAssert.assertEquals(actualLastNameLabel, LAST_NAME_LABEL, LAST_NAME_LABEL_ERROR);
        softAssert.assertEquals(actualUserNameLabel, USERNAME_LABEL, USERNAME_LABEL_ERROR);
        softAssert.assertEquals(actualPasswordLabel, PASSWORD_LABEL, PASSWORD_LABEL_ERROR);
        softAssert.assertEquals(actualRegisterButtonText, REGISTER_BUTTON_TEXT, REGISTER_BUTTON_ERROR);
        softAssert.assertEquals(actualBackToLoginButtonText, BACK_TO_LOGIN_BUTTON_TEXT, BACK_TO_LOGIN_BUTTON_ERROR);
        softAssert.assertEquals(actualRegisterButtonBackgroundColor, EXPECTED_BLUE_COLOR, BACK_TO_LOGIN_BUTTON_ERROR);
        softAssert.assertEquals(actualBackToLoginButtonBackgroundColor, EXPECTED_BLUE_COLOR, BACK_TO_LOGIN_BUTTON_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify error message when attempting registration without reCAPTCHA verification")
    public void tryToLoginWithoutReCaptcha() {
        // Arrange - Generate dynamic user data
        String expectedFirstName = faker.name().firstName();
        String expectedLastName = faker.name().lastName();
        String expectedUsername = faker.name().username();
        String expectedPassword = faker.internet().password(8, 16, true, false, true);

        // Act
        booksRegisterPage.setFirstName(expectedFirstName);
        booksRegisterPage.setLastName(expectedLastName);
        booksRegisterPage.setUsername(expectedUsername);
        booksRegisterPage.setPassword(expectedPassword);
        booksRegisterPage.clickRegisterButton();
        String actualErrorMessage = booksRegisterPage.getErrorMessage();

        // Assert
        softAssert.assertEquals(actualErrorMessage, RECAPTCHA_ERROR_MESSAGE, RECAPTCHA_ERROR_MESSAGE_ERROR);
        softAssert.assertAll();
    }
}
