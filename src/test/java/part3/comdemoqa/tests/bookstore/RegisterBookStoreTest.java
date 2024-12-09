package part3.comdemoqa.tests.bookstore;

import com.pages.demo.pages.bookStoreApplication.LoginPage;
import com.pages.demo.pages.bookStoreApplication.RegisterBookStorePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class RegisterBookStoreTest extends BaseTest {

    @Test
    public void RegisterToBookStoreTest() {
        LoginPage loginPage = homePage.goToBooks().clickLoginLink();
        RegisterBookStorePage registerBookstorePage = loginPage.clickNewUserButton();

        String expectedFirstName = "Zhivko";
        String expectedLastName = "Petrov";
        String expectedUsername = "fbi";
        String expectedPassword = "12345Aa!";

        registerBookstorePage.setFirstName(expectedFirstName);
        registerBookstorePage.setLastName(expectedLastName);
        registerBookstorePage.setUsername(expectedUsername);
        registerBookstorePage.setPassword(expectedPassword);
        registerBookstorePage.clickIamRobotButton();
        registerBookstorePage.clickRegisterButton();

        //TODO Check pop window
    }

    @Test
    public void tryToLoginWithPasswordWithSevenCharacters() {
        LoginPage loginPage = homePage.goToBooks().clickLoginLink();
        RegisterBookStorePage registerBookstorePage = loginPage.clickNewUserButton();

        String expectedFirstName = "Zhivko";
        String expectedLastName = "Petrov";
        String expectedUsername = "fbi";
        String expectedPassword = "1234Aa!";
        String expectedErrorMessage = "Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.";

        registerBookstorePage.setFirstName(expectedFirstName);
        registerBookstorePage.setLastName(expectedLastName);
        registerBookstorePage.setUsername(expectedUsername);
        registerBookstorePage.setPassword(expectedPassword);
        registerBookstorePage.clickIamRobotButton();
        registerBookstorePage.clickRegisterButton();
        String actualErrorMessage = registerBookstorePage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Wrong error message");
    }
}
