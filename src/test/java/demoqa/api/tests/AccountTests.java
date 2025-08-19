package demoqa.api.tests;

import demoqa.api.models.Token;
import demoqa.api.models.User;
import demoqa.api.models.ErrorResponse;
import demoqa.api.spec.TodoClient;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AccountTests extends BaseTestApi {

    User testUser = new User();

    @Test(description = "Authorized user with POST", suiteName = "api", enabled = true)
    void authorizeUser() throws IOException, InterruptedException {
        TodoClient todoClient = new TodoClient();

        String expectedUsername = "fbinnzhivko";
        String password = "Karma1987!@";

        String isUserFound = todoClient.AuthorizeUser(expectedUsername, password);

        Assert.assertEquals(isUserFound, "true", "\nWrong request.\n");
    }

    @Test(description = "Try to authorized non existing user with POST", suiteName = "api", enabled = true)
    void tryToAuthorizeUser() throws IOException, InterruptedException {
        TodoClient todoClient = new TodoClient();

        String expectedUsername = "fbinnzhivko6123";
        String password = "Karma1987!@";

        String response = todoClient.AuthorizeUser(expectedUsername, password);

        Assert.assertEquals(response, "{\"code\":\"1207\",\"message\":\"User not found!\"}", "\nWrong response from API.\n");
    }

    @Test(description = "Generate Token with POST", suiteName = "api", enabled = true)
    void generateToken() throws IOException, InterruptedException {
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

    @Test(description = "Generate new valid user with POST", suiteName = "api", enabled = true)
    void generateNewUser() throws IOException, InterruptedException {
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

    @Test(description = "Try to generate new user with existing user with POST", suiteName = "api", enabled = true)
    void generateNewUserWithExistingUser() throws IOException, InterruptedException {
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

    @Test(description = "Try to delete user with not authorized user with DELETE", suiteName = "api", enabled = true)
    void tryToDeleteUser() throws IOException, InterruptedException {
        TodoClient todoClient = new TodoClient();

        String userId = "9e8aef1f-7ee6-4fc5-a75e-3d4701627871";

        Object response = todoClient.DeleteUser(userId);

        softAssert.assertNotNull(response, "API response should not be null");
        softAssert.assertTrue(response instanceof ErrorResponse, "Response should be an error for existing user");

        ErrorResponse errorResponse = (ErrorResponse) response;
        softAssert.assertEquals(errorResponse.getCode(), "1200", "Error code should be 1200 for user exists");
        softAssert.assertTrue(errorResponse.getMessage().contains("User not authorized!"), "Error message should indicate user exists");

        softAssert.assertAll();
    }

    @Test(description = "Try to get user information with not authorized user with GET", suiteName = "api", enabled = true)
    void getInformation() throws IOException, InterruptedException {
        TodoClient todoClient = new TodoClient();

        String userId = "9e8aef1f-7ee6-4fc5-a75e-3d4701627871";

        Object response = todoClient.GetUserByUUID(userId);

        softAssert.assertNotNull(response, "API response should not be null");
        softAssert.assertTrue(response instanceof ErrorResponse, "Response should be an error for existing user");

        ErrorResponse errorResponse = (ErrorResponse) response;
        softAssert.assertEquals(errorResponse.getCode(), "1200", "Error code should be 1200 for user exists");
        softAssert.assertTrue(errorResponse.getMessage().contains("User not authorized!"), "Error message should indicate user exists");

        softAssert.assertAll();
    }

    @Test(description = "Try to2", suiteName = "api", enabled = false)
    void getInformation2() throws IOException, InterruptedException {
        TodoClient todoClient = new TodoClient();       

        String userId = "e90df422-7f2b-4f51-be1b-c92541eb370f";

        Object response = todoClient.GetUserByUUID(userId);

        softAssert.assertNotNull(response, "API response should not be null");
        softAssert.assertTrue(response instanceof ErrorResponse, "Response should be an error for existing user");

        ErrorResponse errorResponse = (ErrorResponse) response;
        softAssert.assertEquals(errorResponse.getCode(), "1200", "Error code should be 1200 for user exists");
        softAssert.assertTrue(errorResponse.getMessage().contains("User not authorized!"), "Error message should indicate user exists");

        softAssert.assertAll();

    }
}
