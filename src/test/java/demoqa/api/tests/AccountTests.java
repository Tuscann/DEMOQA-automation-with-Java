package demoqa.api.tests;

import demoqa.api.BaseTestApi;
import demoqa.api.models.Token;
import demoqa.api.spec.TodoClient;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AccountTests extends BaseTestApi {

    @Test(testName = "Post Authorized user", suiteName = "api", enabled = true)
    void AuthorizeUser() throws IOException, InterruptedException {
        TodoClient todoClient = new TodoClient();

        String expectedUsername = "fbinnzhivko";
        String password = "Karma1987!@";

        String isUserFound = todoClient.AuthorizeUser(expectedUsername, password);

        Assert.assertEquals(isUserFound, "true", "\nWrong request.\n");
    }

    @Test(testName = "Post Generate Token", suiteName = "api", enabled = true)
    void GenerateToken() throws IOException, InterruptedException {
        TodoClient todoClient = new TodoClient();

        String username = "fbinnzhivko";
        String password = "Karma1987!@";

        Token token = todoClient.GenerateToken(username, password);
        var x = "12";


    }
}
