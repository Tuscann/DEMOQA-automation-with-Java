package part3_4.comdemoqa.tests.part3.javascript.bookstore;

import com.pages.demo.pages.bookStoreApplication.LoginPage;
import com.pages.demo.pages.bookStoreApplication.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class BooksStoreTest extends BaseTest {

    @Test
    public void LoginTest() throws InterruptedException {
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
