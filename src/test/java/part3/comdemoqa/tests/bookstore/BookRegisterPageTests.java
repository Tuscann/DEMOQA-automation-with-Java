package part3.comdemoqa.tests.bookstore;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class BookRegisterPageTests extends BaseTest {

    @Test(enabled = false)
    public void RegisterToBookStoreTest() {
        navigateToUrl("register");

        String expectedFirstName = "Zhivko";
        String expectedLastName = "Petrov";
        String expectedUsername = "fbi" + Math.random();
        String expectedPassword = "12345Aa!" + Math.random();

        booksRegisterPage.setFirstName(expectedFirstName);
        booksRegisterPage.setLastName(expectedLastName);
        booksRegisterPage.setUsername(expectedUsername);
        booksRegisterPage.setPassword(expectedPassword);
        booksRegisterPage.clickIamRobotButton();
        booksRegisterPage.clickRegisterButton();

        var x = 12;

        //TODO Check pop window
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
