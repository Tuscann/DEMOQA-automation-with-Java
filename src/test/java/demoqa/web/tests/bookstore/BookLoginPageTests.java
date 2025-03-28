package demoqa.web.tests.bookstore;

import demoqa.pages.bookstore.BooksLoginPage;
import demoqa.pages.bookstore.BooksPage;
import demoqa.pages.bookstore.BooksProfilePage;
import demoqa.web.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookLoginPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        navigateToUrl("login");

        BooksLoginPage booksLoginPage = new BooksLoginPage(driver);

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

        softAssert.assertEquals(actualLoginHeaderText, loginHeaderText, "\nWrong login header text.\n");
        softAssert.assertEquals(actualWelcomeText, welcomeText, "\nWrong welcome text.\n");
        softAssert.assertEquals(actualLoginInBookStoreText, loginInBookStoreText, "\nWrong login in book store.\n");
        softAssert.assertEquals(actualUsername, username, "\nWrong username.\n");
        softAssert.assertEquals(actualUsernamePlaceholder, usernamePlaceholder, "\nWrong username placeholder.\n");
        softAssert.assertEquals(actualPassword, password, "\nWrong password.\n");
        softAssert.assertEquals(actualPasswordPlaceholder, passwordPlaceholder, "\nWrong password placeholder.\n");
        softAssert.assertEquals(actualLoginButtonText, loginButtonText, "\nWrong login button text.\n");
        softAssert.assertEquals(actualNewUserButtonText, newUserButtonText, "\nWrong new user button text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Login with valid username and valid password")
    public void LoginWithValidUsernameAndValidPassword() {
        navigateToUrl("login");
        BooksLoginPage booksLoginPage = new BooksLoginPage(driver);

        String expectedUsername = "fbinnzhivko";
        String password = "Karma1987!@";

        booksLoginPage.setUsername(expectedUsername);
        booksLoginPage.clickPassword();
        booksLoginPage.setPassword(password);
        booksLoginPage.clickLoginButton();

        String actualProfile = booksLoginPage.getProfile();
        Assert.assertEquals(actualProfile, expectedUsername, "\nNot same username.\n");
    }

    @Test(enabled = true, testName = "Try to login with wrong username")
    public void TryToLoginWithWrongUsername() {
        navigateToUrl("login");
        BooksLoginPage booksLoginPage = new BooksLoginPage(driver);

        String expectedUsername = "username";
        String password = "h&vfCVj0k9BHofzP";

        booksLoginPage.clickUsername();
        booksLoginPage.setUsername(expectedUsername);
        booksLoginPage.clickPassword();
        booksLoginPage.setPassword(password);
        booksLoginPage.clickLoginButton();

        String actualMessage = booksLoginPage.getErrorMessage();
        String expectedMessage = "Invalid username or password!";

        Assert.assertEquals(actualMessage, expectedMessage, "\nWrong username or password.\n");
    }

    @Test(enabled = true, testName = "Try to login with wrong username and wrong password")
    public void TryToLoginWithWrongUsernameAndWrongPassword() {
        navigateToUrl("login");
        BooksLoginPage booksLoginPage = new BooksLoginPage(driver);

        String expectedUsername = "karma";
        String password = "karma";

        booksLoginPage.clickUsername();
        booksLoginPage.setUsername(expectedUsername);
        booksLoginPage.clickPassword();
        booksLoginPage.setPassword(password);
        booksLoginPage.clickLoginButton();

        String actualMessage = booksLoginPage.getErrorMessage();
        String expectedMessage = "Invalid username or password!";

        Assert.assertEquals(actualMessage, expectedMessage, "\nWrong username or password.\n");
    }

    @Test(enabled = true, testName = "Try to login with wrong password")
    public void TryToLoginWithWrongPassword() {
        navigateToUrl("login");
        BooksLoginPage booksLoginPage = new BooksLoginPage(driver);

        String expectedUsername = "fbinnnzhivko";
        String password = "password";

        booksLoginPage.clickUsername();
        booksLoginPage.setUsername(expectedUsername);
        booksLoginPage.clickPassword();
        booksLoginPage.setPassword(password);
        booksLoginPage.clickLoginButton();

        String actualErrorMessage = booksLoginPage.getErrorMessage();
        String expectedErrorMessage = "Invalid username or password!";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "\nWrong password message.\n");
    }

    @Test(enabled = true, testName = "Click logout after login")
    public void ClickLogoutAfterLogin() {
        navigateToUrl("login");
        BooksLoginPage booksLoginPage = new BooksLoginPage(driver);

        String expectedUsername = "fbinnzhivko";
        String password = "Karma1987!@";

        booksLoginPage.setUsername(expectedUsername);
        booksLoginPage.clickPassword();
        booksLoginPage.setPassword(password);
        booksLoginPage.clickLoginButton();

        String actualProfile = booksLoginPage.getProfile();
        softAssert.assertEquals(actualProfile, expectedUsername, "\nNot same username.\n");

        booksLoginPage.clickLogoutButton();

        String expectedLoginText = "Login in Book Store";
        String actualLoginText = booksLoginPage.getLoginText();
        softAssert.assertEquals(actualLoginText, expectedLoginText, "\nNot same login text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on button gotobookstore")
    public void ClickOnButtonGotoBookStore() {
        navigateToUrl("login");
        BooksLoginPage booksLoginPage = new BooksLoginPage(driver);
        BooksProfilePage booksProfilePage = new BooksProfilePage(driver);
        BooksPage booksPage = new BooksPage(driver);

        String expectedUsername = "fbinnzhivko";
        String password = "Karma1987!@";

        booksLoginPage.setUsername(expectedUsername);
        booksLoginPage.setPassword(password);
        booksLoginPage.clickLoginButton();
        booksProfilePage.clickGoToBookStoreButton();

        String expectedUrl = "https://demoqa.com/books";
        String actualUrl = booksPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nNot same books url.\n");
    }

    @Test(enabled = true, testName = "Verify login page after login")
    public void VerifyLoginPageAfterLogin() {
        navigateToUrl("login");
        BooksLoginPage booksLoginPage = new BooksLoginPage(driver);
        BooksProfilePage booksProfilePage = new BooksProfilePage(driver);

        String expectedUsername = "fbinnzhivko";
        String password = "Karma1987!@";

        booksLoginPage.setUsername(expectedUsername);
        booksLoginPage.clickPassword();
        booksLoginPage.setPassword(password);
        booksLoginPage.clickLoginButton();
        booksProfilePage.clickGoToBookStoreButton();
        booksProfilePage.clickLeftLoginLink2();

        String expectedText = "You are already logged in. View your profile.";
        String actualLabel = booksLoginPage.getLoadingLabel();

        Assert.assertEquals(actualLabel, expectedText, "\nNot same label.\n");
    }
}
