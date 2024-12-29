package demoqa.web.test.bookstore;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookRegisterPageTests extends BaseTest {

    @Test(enabled = true)
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

        Assert.assertEquals(actualFirstNamePlaceholder, expectedFirstNamePlaceholder);
        Assert.assertEquals(actualLastNamePlaceholder, expectedLastNamePlaceholder);
        Assert.assertEquals(actualUserNamePlaceholder, expectedUserNamePlaceholder);
        Assert.assertEquals(actualPasswordPlaceholder, expectedPasswordPlaceholder);
        Assert.assertEquals(actualTitleText, expectedTitle);
        Assert.assertEquals(actualFirstText, expectedFirstText);
        Assert.assertEquals(actualFirstNameLabel, expectedFirstNameLabel);
        Assert.assertEquals(actualLastNameLabel, expectedLastNameLabel);
        Assert.assertEquals(actualUserNameLabel, expectedUserNameLabel);
        Assert.assertEquals(actualPasswordLabel, expectedPasswordLabel);

        Assert.assertEquals(actualRegisterButtonText, expectedRegisterButtonName);
        Assert.assertEquals(actualBackToLoginButtonText, expectedBackToLoginButtonName);
    }

    @Test
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

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Wrong error message");
    }
}
