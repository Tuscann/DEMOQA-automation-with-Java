package demoqa.web.test.bookstore;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookRegisterPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on Page")
    public void VerifyAllTextOnPage() {
        navigateToUrl("register");

        String expectedTitle = "Register";
        String expectedFirstText = "Register to Book Store";
        String expectedFirstNameLabel = "First Name :";
        String expectedFirstNamePlaceholder = "First Name";
        String expectedLastNameLabel = "Last Name :";
        String expectedLastNamePlaceholder = "Last Name";
        String expectedUserNameLabel = "UserName :";
        String expectedUserNamePlaceholder = "UserName";
        String expectedPasswordLabel = "Password :";
        String expectedPasswordPlaceholder = "Password";
        String expectedRegisterButtonName = "Register";
        String expectedBackToLoginButtonName = "Back to Login";

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

        softAssert.assertEquals(actualFirstNamePlaceholder, expectedFirstNamePlaceholder, "\nWrong first name placeholder.\n");
        softAssert.assertEquals(actualLastNamePlaceholder, expectedLastNamePlaceholder, "\nWrong last name placeholder.\n");
        softAssert.assertEquals(actualUserNamePlaceholder, expectedUserNamePlaceholder, "\nWrong username placeholder.\n");
        softAssert.assertEquals(actualPasswordPlaceholder, expectedPasswordPlaceholder, "\nWrong password placeholder.\n");
        softAssert.assertEquals(actualTitleText, expectedTitle, "\nWrong title placeholder.\n");
        softAssert.assertEquals(actualFirstText, expectedFirstText, "\nWrong first text placeholder.\n");
        softAssert.assertEquals(actualFirstNameLabel, expectedFirstNameLabel, "\nWrong first name label placeholder.\n");
        softAssert.assertEquals(actualLastNameLabel, expectedLastNameLabel, "\nWrong last name label placeholder.\n");
        softAssert.assertEquals(actualUserNameLabel, expectedUserNameLabel, "\nWrong username label placeholder.\n");
        softAssert.assertEquals(actualPasswordLabel, expectedPasswordLabel, "\nWrong password label placeholder.\n");

        softAssert.assertEquals(actualRegisterButtonText, expectedRegisterButtonName, "\nMissing register button.\n");
        softAssert.assertEquals(actualBackToLoginButtonText, expectedBackToLoginButtonName, "\nMissing backtologin button.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Try to login without recaptcha")
    public void TryToLoginWithoutReCaptcha() {
        navigateToUrl("register");

        String expectedFirstName = "Zhivko";
        String expectedLastName = "Petrov";
        String expectedUsername = "fbi";
        String expectedPassword = "1234Aa!";
        String expectedErrorMessage = "Please verify reCaptcha to register!";

        booksRegisterPage.setFirstName(expectedFirstName);
        booksRegisterPage.setLastName(expectedLastName);
        booksRegisterPage.setUsername(expectedUsername);
        booksRegisterPage.setPassword(expectedPassword);
        booksRegisterPage.clickIamRobotButton();
        booksRegisterPage.clickRegisterButton();
        String actualErrorMessage = booksRegisterPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "\nWrong error message.\n");
    }
}
