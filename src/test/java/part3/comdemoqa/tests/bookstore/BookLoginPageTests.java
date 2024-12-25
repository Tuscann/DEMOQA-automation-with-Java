package part3.comdemoqa.tests.bookstore;

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

    @Test(enabled = true)
    public void TryToLoginWithWrongUsername() {
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
    public void TryToLoginWithWrongUsernameAndWrongPassword() {
        navigateToUrl("login");
        String expectedUsername = "karma";
        String password = "karma";

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
    public void TryToLoginWithWrongPassword() {
        navigateToUrl("login");

        String expectedUsername = "fbinnnzhivko";
        String password = "password";

        booksLoginPage.clickUsername();
        booksLoginPage.setUsername(expectedUsername);
        booksLoginPage.clickPassword();
        booksLoginPage.setPassword(password);
        booksLoginPage.clickLoginButton();

        String actualErrorMessage = booksLoginPage.getErrorMessage();
        String expectedErrorMessage = "Invalid username or password!";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Wrong password message");
    }

    @Test(enabled = true)
    public void ClickLogoutAfterLogin() {
        navigateToUrl("login");

        String expectedUsername = "fbinnzhivko";
        String password = "Karma1987!@";

        booksLoginPage.setUsername(expectedUsername);
        booksLoginPage.clickPassword();
        booksLoginPage.setPassword(password);
        booksLoginPage.clickLoginButton();

        String actualProfile = booksLoginPage.getProfile();
        Assert.assertEquals(actualProfile, expectedUsername, "Not same username");

        booksLoginPage.clickLogoutButton();

        String expectedLoginText = "Login in Book Store";
        String actualLoginText = booksLoginPage.getLoginText();
        Assert.assertEquals(actualLoginText, expectedLoginText, "Not same login text");
    }

    @Test(enabled = true)
    public void ClickButtonGotoBookStore() {
        navigateToUrl("login");

        String expectedUsername = "fbinnzhivko";
        String password = "Karma1987!@";

        booksLoginPage.setUsername(expectedUsername);
        booksLoginPage.setPassword(password);
        booksLoginPage.clickLoginButton();
        booksProfilePage.clickGoToBookStoreButton();

        String expectedUrl = "https://demoqa.com/books";
        String actualUrl = booksPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Not same books url");
    }

    @Test(enabled = true)
    public void VerifyLoginPageAfterLogin() {
        navigateToUrl("login");

        String expectedUsername = "fbinnzhivko";
        String password = "Karma1987!@";

        booksLoginPage.setUsername(expectedUsername);
        booksLoginPage.clickPassword();
        booksLoginPage.setPassword(password);
        booksLoginPage.clickLoginButton();
        booksProfilePage.clickGoToBookStoreButton();
        booksProfilePage.clickLoginLink2();
        
        String expectedUrl = "You are already logged in. View your profile.";
        String actualLabel = booksLoginPage.getLoadingLabel();

        Assert.assertEquals(actualLabel, expectedUrl, "Not same label");
    }
}
