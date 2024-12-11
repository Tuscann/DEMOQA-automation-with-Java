package part3.comdemoqa.tests.bookstore;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class ProfilePageTest extends BaseTest {

    @Test(enabled = true)
    public void checkMessage() {
        navigateToUrl("profile");

        String expectedErrorMessage = "Currently you are not logged into the Book Store application, please visit the login page to enter or register page to register yourself.";

        String actualMessage = profilePage.getNotLogginWrapper();


        Assert.assertEquals(actualMessage, expectedErrorMessage, "Wrong password message");
    }

    @Test(enabled = true)
    public void checkLoginLink() {
        navigateToUrl("profile");

        String expectedLoginUrl = "https://demoqa.com/login";
        profilePage.clickLoginLink();

        String actualUrl = profilePage.getLoginLink();

        Assert.assertEquals(actualUrl, expectedLoginUrl, "Wrong password message");
    }

    @Test(enabled = true)
    public void checkRegisterLink() {
        navigateToUrl("profile");

        String expectedLoginUrl = "https://demoqa.com/register";

        profilePage.clickRegisterLink();
        String actualUrl = profilePage.getLoginLink();

        Assert.assertEquals(actualUrl, expectedLoginUrl, "Wrong password message");
    }

}
