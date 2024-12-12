package part3.comdemoqa.tests.bookstore;

import com.pages.demo.pages.bookStoreApplication.BooksRegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class BookRegisterTest extends BaseTest {

    @Test(enabled = false)
    public void RegisterToBookStoreTest() {
        navigateToUrl("login");
        BooksRegisterPage registerBookstorePage = booksLoginPage.clickNewUserButton();

        String expectedFirstName = "Zhivko";
        String expectedLastName = "Petrov";
        String expectedUsername = "fbi" + Math.random();
        String expectedPassword = "12345Aa!" + Math.random();

        registerBookstorePage.setFirstName(expectedFirstName);
        registerBookstorePage.setLastName(expectedLastName);
        registerBookstorePage.setUsername(expectedUsername);
        registerBookstorePage.setPassword(expectedPassword);
        registerBookstorePage.clickIamRobotButton();
        registerBookstorePage.clickRegisterButton();

        var x = 12;

        //TODO Check pop window
    }

    @Test
    public void tryToLoginWithoutReCaptcha() {
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
