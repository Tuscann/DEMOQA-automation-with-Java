package demoqa.api.tests;

import demoqa.api.tests.BaseTestApi;
import demoqa.api.models.Token;
import demoqa.api.models.User;
import demoqa.api.models.ErrorResponse;
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

    @Test(testName = "Generate Token with post", suiteName = "api", enabled = true)
    void GenerateToken() throws IOException, InterruptedException {
        TodoClient todoClient = new TodoClient();

        String username = "fbinnzhivko";
        String password = "Karma1987!@";

        Token token = todoClient.GenerateToken(username, password);

        softAssert.assertNotNull(token, "Token response should not be null");

        softAssert.assertNotNull(token.getToken(), "Token field should not be null");
        softAssert.assertNotNull(token.getExpires(), "Expires field should not be null");
        softAssert.assertNotNull(token.getStatus(), "Status field should not be null");
        softAssert.assertNotNull(token.getResult(), "Result field should not be null");

        softAssert.assertEquals(token.getStatus(), "Success", "Token status should be 'Success'");
        softAssert.assertEquals(token.getResult(), "User authorized successfully.", "Token result should indicate successful authorization");

        softAssert.assertAll();
    }

    @Test(testName = "Generate new user post", suiteName = "api", enabled = true)
    void GenerateNewUser() throws IOException, InterruptedException {
        TodoClient todoClient = new TodoClient();

        String username = "fbinnzhivko" + 100 + (int) (Math.random() * 899);
        String password = "Karma1987!@";

        Object response = todoClient.GenerateNewUser(username, password);
        softAssert.assertNotNull(response, "User creation response should not be null");
        softAssert.assertTrue(response instanceof User, "Response should be a User object");

        User user = (User) response;
        softAssert.assertNotNull(user.getUserId(), "UserId should not be null");
        softAssert.assertNotNull(user.getUsername(), "Username should not be null");
        softAssert.assertNotNull(user.getBooks(), "Books array should not be null");
        softAssert.assertEquals(user.getUsername(), username, "Username in response should match the one sent");
        softAssert.assertTrue(user.getBooks().isEmpty(), "Books array should be empty for new user");

        softAssert.assertAll();
    }

    @Test(testName = "Try to generate new user with existing user post", suiteName = "api", enabled = true)
    void GenerateNewUserWithExistingUser() throws IOException, InterruptedException {
        TodoClient todoClient = new TodoClient();

        String username = "fbinnzhivko";
        String password = "Karma1987!@";

        Object response = todoClient.GenerateNewUser(username, password);

        softAssert.assertNotNull(response, "API response should not be null");
        softAssert.assertTrue(response instanceof ErrorResponse, "Response should be an error for existing user");

        ErrorResponse errorResponse = (ErrorResponse) response;
        softAssert.assertEquals(errorResponse.getCode(), "1204", "Error code should be 1204 for user exists");
        softAssert.assertTrue(errorResponse.getMessage().contains("User exists"), "Error message should indicate user exists");

        softAssert.assertAll();
    }
}
