package part3_4.comdemoqa.tests.part3.bookstore;

import com.pages.demo.pages.bookStoreApplication.LoginPage;
import com.pages.demo.pages.bookStoreApplication.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class BooksStoreTest extends BaseTest {

    @Test
    public void tryToLoginWithWrongPassword() throws InterruptedException {
        LoginPage loginPage = homePage.goToBooks().clickLoginLink();
        String expectedUsername = "fbinnnzhivko";
        String password = "password";
        String expectedErrorMessage = "Invalid username or password!";

        loginPage.clickUsername();
        loginPage.setUsername(expectedUsername);
        loginPage.clickPassword();
        loginPage.setPassword(password);
        loginPage.clickLoginButton();

        String actualErrorMessage = loginPage.GetErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Wrong password message");
    }

    @Test
    public void tryToLoginWithWrongUsername() throws InterruptedException {
        LoginPage loginPage = homePage.goToBooks().clickLoginLink();
        String expectedUsername = "username";
        String password = "h&vfCVj0k9BHofzP";
        String expectedErrorMessage = "Invalid username or password!";

        loginPage.clickUsername();
        loginPage.setUsername(expectedUsername);
        loginPage.clickPassword();
        loginPage.setPassword(password);
        loginPage.clickLoginButton();

        String actualErrorMessage = loginPage.GetErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Wrong username message");
    }

    @Test
    public void tryToLoginWithWrongUsername2() throws InterruptedException {
        LoginPage loginPage = homePage.goToBooks().clickLoginLink();
        String expectedUsername = "fbinnnzhivko";
        String password = "h&vfCVj0k9BHofzP";

        loginPage.clickUsername();
        loginPage.setUsername(expectedUsername);
        loginPage.clickPassword();
        loginPage.setPassword(password);
        loginPage.clickLoginButton();

        Thread.sleep(3000); //TODO

        String actualUsername = new ProfilePage().getUsername();
        Assert.assertEquals(expectedUsername, actualUsername, "Not same username");
    }
}
