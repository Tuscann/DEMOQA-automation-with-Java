package part3_4.comdemoqa.tests.part3.javascript.elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class WebTableTest extends BaseTest {

    @Test
    public void UpdateAge() {
        String email = "kierra@example.com";
        String expectedAge = "34";

        var webTablePage = homePage.goToElements().clickWebTables();

        webTablePage.clickEdit(email);
        webTablePage.setAge("34");
        webTablePage.clickSubmitButton();
        String actualAge = webTablePage.getTableAge(email);
        Assert.assertEquals(actualAge, expectedAge,
                "\n Actual & Expected Ages Do Not Match \n");
    }

    @Test
    public void UpdateFirstNameAndLastName() {
        String email = "cierra@example.com";
        String expectedFirstName = "Zhivko";
        String expectedLastName = "Petrov";

        var webTablePage = homePage.goToElements().clickWebTables();
        webTablePage.clickEdit(email);
        webTablePage.setFirstName(expectedFirstName);
        webTablePage.setLastName(expectedLastName);
        webTablePage.clickSubmitButton();
        String actualFirstName = webTablePage.getTableFirstName(email);
        String actualLastName = webTablePage.getTableLastName(email);
        Assert.assertEquals(actualFirstName, expectedFirstName,
                "\n Actual & Expected FirstName Do Not Match \n");
        Assert.assertEquals(actualLastName, expectedLastName,
                "\n Actual & Expected LastName Do Not Match \n");
    }
}
