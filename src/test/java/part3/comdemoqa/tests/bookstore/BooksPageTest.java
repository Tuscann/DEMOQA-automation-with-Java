package part3.comdemoqa.tests.bookstore;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class BooksPageTest extends BaseTest {

    @Test(enabled = true)
    public void tryToLoginWithWrongPassword() {
        navigateToUrl("login");

        String expectedUsername = "fbinnnzhivko";
        String password = "password";
        String expectedErrorMessage = "Invalid username or password!";

        loginPage.clickNewUserButton();
        loginPage.setUsername(expectedUsername);
        loginPage.clickPassword();
        loginPage.setPassword(password);
        loginPage.clickLoginButton();

        String actualErrorMessage = loginPage.GetErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Wrong password message");
    }

    @Test(enabled = true)
    public void checkAll4Pages() {
        navigateToUrl("books");

        booksPage.clickLoginLink();
        booksPage.clickProfileLink();
        booksPage.clickLoginLink();
        booksPage.clickBookStoreAPILink();


        // String actualErrorMessage = loginPage.GetErrorMessage();
        // Assert.assertEquals(actualErrorMessage, "", "Wrong password message");
    }
}
