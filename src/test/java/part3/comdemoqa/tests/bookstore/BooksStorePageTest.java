package part3.comdemoqa.tests.bookstore;

import com.pages.demo.pages.bookStoreApplication.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class BooksStorePageTest extends BaseTest {

    @Test(enabled = false)
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

    @Test(enabled = false)
    public void tryToLoginWithWrongUsername() {
        navigateToUrl("login");
        String expectedUsername = "username";
        String password = "h&vfCVj0k9BHofzP";
        String expectedErrorMessage = "Invalid username or password!";

        loginPage.clickUsername();
        loginPage.setUsername(expectedUsername);
        loginPage.clickPassword();
        loginPage.setPassword(password);
        loginPage.clickLoginButton();

        String actualErrorMessage = loginPage.GetErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Wrong username message");
    }

    @Test(enabled = false)
    public void tryToLoginWithWrongUsername2() throws InterruptedException {
        navigateToUrl("login");
        String expectedUsername = "fbinnnzhivko";
        String password = "h&vfCVj0k9BHofzP";

        loginPage.clickUsername();
        loginPage.setUsername(expectedUsername);
        loginPage.clickPassword();
        loginPage.setPassword(password);
        loginPage.clickLoginButton();

        Thread.sleep(1000); //TODO

        String actualUsername = new ProfilePage().getUsername();
        Assert.assertEquals(actualUsername, expectedUsername, "Not same username");
    }
}
