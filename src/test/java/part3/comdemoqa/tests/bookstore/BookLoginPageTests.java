package part3.comdemoqa.tests.bookstore;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class BookLoginPageTests extends BaseTest {

    @Test
    public void VerifyAllTextOnPage() {
        navigateToUrl("login");

        String loginHeaderText = "Login";
        String welcomeText = "Welcome,";
        String loginInBookStoreText = "Login in Book Store";
        String username = "UserName :";
        String usernamePlaceholder = "UserName";
        String password = "Password :";
        String passwordPlaceholder = "Password";
        String loginButtonText = "Login";
        String newUserButtonText = "New User";

        String actualLoginHeaderText = booksLoginPage.getLoginHeaderText();
        String actualWelcomeText = booksLoginPage.getWelcomeText();
        String actualLoginInBookStoreText = booksLoginPage.getLoginInBookStoreText();
        String actualUsername = booksLoginPage.getUsernameLabel();
        String actualUsernamePlaceholder = booksLoginPage.getUsernamePlaceholder();
        String actualPassword = booksLoginPage.getPasswordLabel();
        String actualPasswordPlaceholder = booksLoginPage.getPasswordPlaceholder();
        String actualLoginButtonText = booksLoginPage.getLoginButtonText();
        String actualNewUserButtonText = booksLoginPage.getNewUserButtonText();

        Assert.assertEquals(actualLoginHeaderText, loginHeaderText, "Wrong login header text");
        Assert.assertEquals(actualWelcomeText, welcomeText, "Wrong welcome text");
        Assert.assertEquals(actualLoginInBookStoreText, loginInBookStoreText, "Wrong login in book store");
        Assert.assertEquals(actualUsername, username, "Wrong username");
        Assert.assertEquals(actualUsernamePlaceholder, usernamePlaceholder, "Wrong username placeholder");
        Assert.assertEquals(actualPassword, password, "Wrong password");
        Assert.assertEquals(actualPasswordPlaceholder, passwordPlaceholder, "Wrong password placeholder");
        Assert.assertEquals(actualLoginButtonText, loginButtonText, "Wrong login button text");
        Assert.assertEquals(actualNewUserButtonText, newUserButtonText, "Wrong new user button text");
    }

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
