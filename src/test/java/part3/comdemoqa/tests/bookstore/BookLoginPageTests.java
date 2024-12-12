package part3.comdemoqa.tests.bookstore;

import com.pages.demo.pages.bookStoreApplication.BooksProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class BookLoginPageTests extends BaseTest {
    @Test(enabled = true)
    public void LoginWithValidUsernameAndValidPassword() {
        navigateToUrl("login");

        String expectedUsername = "fbinnzhivko";
        String password = "Karma1987!@";

        booksLoginPage.setUsername(expectedUsername);
        booksLoginPage.clickPassword();
        booksLoginPage.setPassword(password);
        booksLoginPage.clickLoginButton();

        String actualProfile = booksLoginPage.getProfile();

        Assert.assertEquals(actualProfile, expectedUsername, "Not same username");
    }

    @Test(enabled = false)
    public void tryToLoginWithWrongUsername() throws InterruptedException {
        navigateToUrl("login");
        String expectedUsername = "username";
        String password = "h&vfCVj0k9BHofzP";

        booksLoginPage.clickUsername();
        booksLoginPage.setUsername(expectedUsername);
        booksLoginPage.clickPassword();
        booksLoginPage.setPassword(password);
        booksLoginPage.clickLoginButton();


        String actualMessage = booksLoginPage.getErrorMessage();
        String expectedMessage = "Invalid username or password!";

        Assert.assertEquals(actualMessage, expectedMessage, "Wrong username or password");
    }

    @Test(enabled = true)
    public void tryToLoginWithWrongUsername2() throws InterruptedException {
        navigateToUrl("login");
        String expectedUsername = "fbinnnzhivko";
        String password = "h&vfCVj0k9BHofzP";

        booksLoginPage.clickUsername();
        booksLoginPage.setUsername(expectedUsername);
        booksLoginPage.clickPassword();
        booksLoginPage.setPassword(password);
        booksLoginPage.clickLoginButton();

        Thread.sleep(1000); //TODO

        String actualUsername = new BooksProfilePage().getUsername();
        Assert.assertEquals(actualUsername, expectedUsername, "Not same username");
    }

    @Test(enabled = true)
    public void TryToLoginWithWrongPassword() {
        navigateToUrl("login");

        String expectedUsername = "fbinnnzhivko";
        String password = "password";
        String expectedErrorMessage = "Invalid username or password!";

        booksLoginPage.clickNewUserButton();
        booksLoginPage.setUsername(expectedUsername);
        booksLoginPage.clickPassword();
        booksLoginPage.setPassword(password);
        booksLoginPage.clickLoginButton();

        String actualErrorMessage = booksLoginPage.GetErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Wrong password message");
    }
}
