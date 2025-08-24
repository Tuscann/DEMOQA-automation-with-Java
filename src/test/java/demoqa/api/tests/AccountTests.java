package demoqa.api.tests;

import demoqa.api.models.ErrorResponse;
import demoqa.api.models.Token;
import demoqa.api.models.User;
import demoqa.api.spec.TodoClient;
import org.testng.annotations.Test;

import java.io.IOException;

public class AccountTests extends BaseTestApi {

    // Test Data Constants
    private static final String VALID_USERNAME = "fbinnzhivko";
    private static final String VALID_PASSWORD = "Karma1987!@";
    private static final String INVALID_USERNAME = "fbinnzhivko6123";
    private static final String USER_ID = "9e8aef1f-7ee6-4fc5-a75e-3d4701627871";
    private static final String USER_ID_2 = "e90df422-7f2b-4f51-be1b-c92541eb370f";

    // Expected Response Constants
    private static final String EXPECTED_AUTHORIZED_RESPONSE = "true";
    private static final String EXPECTED_USER_NOT_FOUND_RESPONSE = "{\"code\":\"1207\",\"message\":\"User not found!\"}";
    private static final String EXPECTED_SUCCESS_STATUS = "Success";
    private static final String EXPECTED_SUCCESS_RESULT = "User authorized successfully.";
    private static final String EXPECTED_ERROR_CODE_USER_EXISTS = "1204";
    private static final String EXPECTED_ERROR_CODE_UNAUTHORIZED = "1200";
    private static final String EXPECTED_UNAUTHORIZED_MESSAGE = "User not authorized!";

    // Error Message Constants
    private static final String AUTHORIZATION_ERROR = "Wrong authorization request";
    private static final String API_RESPONSE_ERROR = "Wrong response from API";
    private static final String TOKEN_NULL_ERROR = "Token response should not be null";
    private static final String TOKEN_FIELD_NULL_ERROR = "Token field should not be null";
    private static final String EXPIRES_FIELD_NULL_ERROR = "Expires field should not be null";
    private static final String STATUS_FIELD_NULL_ERROR = "Status field should not be null";
    private static final String RESULT_FIELD_NULL_ERROR = "Result field should not be null";
    private static final String TOKEN_STATUS_ERROR = "Token status should be 'Success'";
    private static final String TOKEN_RESULT_ERROR = "Token result should indicate successful authorization";
    private static final String USER_CREATION_RESPONSE_NULL_ERROR = "User creation response should not be null";
    private static final String RESPONSE_TYPE_ERROR = "Response should be a User object";
    private static final String USER_ID_NULL_ERROR = "UserId should not be null";
    private static final String USERNAME_NULL_ERROR = "Username should not be null";
    private static final String BOOKS_ARRAY_NULL_ERROR = "Books array should not be null";
    private static final String USERNAME_MISMATCH_ERROR = "Username in response should match the one sent";
    private static final String BOOKS_ARRAY_EMPTY_ERROR = "Books array should be empty for new user";
    private static final String API_RESPONSE_NULL_ERROR = "API response should not be null";
    private static final String ERROR_RESPONSE_TYPE_ERROR = "Response should be an error for existing user";
    private static final String ERROR_CODE_MISMATCH_ERROR = "Error code should be 1204 for user exists";
    private static final String USER_EXISTS_MESSAGE_ERROR = "Error message should indicate user exists";
    private static final String UNAUTHORIZED_ERROR_CODE_ERROR = "Error code should be 1200 for unauthorized user";
    private static final String UNAUTHORIZED_MESSAGE_ERROR = "Error message should indicate user not authorized";

    User testUser = new User();

    @Test(description = "Authorized user with POST", suiteName = "api", enabled = true)
    void authorizeUser() throws IOException, InterruptedException {
        // Arrange & Act
        TodoClient todoClient = new TodoClient();

        String isUserFound = todoClient.AuthorizeUser(VALID_USERNAME, VALID_PASSWORD);

        // Assert
        softAssert.assertEquals(isUserFound, EXPECTED_AUTHORIZED_RESPONSE, AUTHORIZATION_ERROR);
        softAssert.assertAll();
    }

    @Test(description = "Try to authorized non existing user with POST", suiteName = "api", enabled = true)
    void authorizeWithNonExistingUser() throws IOException, InterruptedException {
        // Arrange & Act
        TodoClient todoClient = new TodoClient();

        String response = todoClient.AuthorizeUser(INVALID_USERNAME, VALID_PASSWORD);

        // Assert
        softAssert.assertEquals(response, EXPECTED_USER_NOT_FOUND_RESPONSE, API_RESPONSE_ERROR);
        softAssert.assertAll();
    }

    @Test(description = "Generate Token with POST", suiteName = "api", enabled = true)
    void generateToken() throws IOException, InterruptedException {
        // Arrange & Act
        TodoClient todoClient = new TodoClient();

        Token token = todoClient.GenerateToken(VALID_USERNAME, VALID_PASSWORD);

        // Assert
        softAssert.assertNotNull(token, TOKEN_NULL_ERROR);
        softAssert.assertNotNull(token.getToken(), TOKEN_FIELD_NULL_ERROR);
        softAssert.assertNotNull(token.getExpires(), EXPIRES_FIELD_NULL_ERROR);
        softAssert.assertNotNull(token.getStatus(), STATUS_FIELD_NULL_ERROR);
        softAssert.assertNotNull(token.getResult(), RESULT_FIELD_NULL_ERROR);

        softAssert.assertEquals(token.getStatus(), EXPECTED_SUCCESS_STATUS, TOKEN_STATUS_ERROR);
        softAssert.assertEquals(token.getResult(), EXPECTED_SUCCESS_RESULT, TOKEN_RESULT_ERROR);

        softAssert.assertAll();
    }

    @Test(description = "Generate new valid user with POST", suiteName = "api", enabled = true)
    void generateNewUser() throws IOException, InterruptedException {
        // Arrange & Act
        TodoClient todoClient = new TodoClient();

        String username = VALID_USERNAME + 100 + (int) (Math.random() * 899);
        Object response = todoClient.GenerateNewUser(username, VALID_PASSWORD);

        // Assert
        softAssert.assertNotNull(response, USER_CREATION_RESPONSE_NULL_ERROR);
        softAssert.assertTrue(response instanceof User, RESPONSE_TYPE_ERROR);

        User user = (User) response;
        softAssert.assertNotNull(user.getUserId(), USER_ID_NULL_ERROR);
        softAssert.assertNotNull(user.getUsername(), USERNAME_NULL_ERROR);
        softAssert.assertNotNull(user.getBooks(), BOOKS_ARRAY_NULL_ERROR);
        softAssert.assertEquals(user.getUsername(), username, USERNAME_MISMATCH_ERROR);
        softAssert.assertTrue(user.getBooks().isEmpty(), BOOKS_ARRAY_EMPTY_ERROR);

        softAssert.assertAll();
    }

    @Test(description = "Try to generate new user with existing user with POST", suiteName = "api", enabled = true)
    void generateNewUserWithExistingUser() throws IOException, InterruptedException {
        // Arrange & Act
        TodoClient todoClient = new TodoClient();

        Object response = todoClient.GenerateNewUser(VALID_USERNAME, VALID_PASSWORD);

        // Assert
        softAssert.assertNotNull(response, API_RESPONSE_NULL_ERROR);
        softAssert.assertTrue(response instanceof ErrorResponse, ERROR_RESPONSE_TYPE_ERROR);

        ErrorResponse errorResponse = (ErrorResponse) response;
        softAssert.assertEquals(errorResponse.getCode(), EXPECTED_ERROR_CODE_USER_EXISTS, ERROR_CODE_MISMATCH_ERROR);
        softAssert.assertTrue(errorResponse.getMessage().contains("User exists"), USER_EXISTS_MESSAGE_ERROR);

        softAssert.assertAll();
    }

    @Test(description = "Try to delete user with not authorized user with DELETE", suiteName = "api", enabled = true)
    void tryToDeleteUserWithoutAutorization() throws IOException, InterruptedException {
        // Arrange & Act
        TodoClient todoClient = new TodoClient();

        Object response = todoClient.DeleteUser(USER_ID);

        // Assert
        softAssert.assertNotNull(response, API_RESPONSE_NULL_ERROR);
        softAssert.assertTrue(response instanceof ErrorResponse, ERROR_RESPONSE_TYPE_ERROR);

        ErrorResponse errorResponse = (ErrorResponse) response;
        softAssert.assertEquals(errorResponse.getCode(), EXPECTED_ERROR_CODE_UNAUTHORIZED, UNAUTHORIZED_ERROR_CODE_ERROR);
        softAssert.assertTrue(errorResponse.getMessage().contains(EXPECTED_UNAUTHORIZED_MESSAGE), UNAUTHORIZED_MESSAGE_ERROR);

        softAssert.assertAll();
    }

    @Test(description = "Try to get user information with not authorized user with GET", suiteName = "api", enabled = true)
    void getUserInformationWithNonAuthorizedUser() throws IOException, InterruptedException {
        // Arrange & Act
        TodoClient todoClient = new TodoClient();

        Object response = todoClient.GetUserByUUID(USER_ID);

        // Assert
        softAssert.assertNotNull(response, API_RESPONSE_NULL_ERROR);
        softAssert.assertTrue(response instanceof ErrorResponse, ERROR_RESPONSE_TYPE_ERROR);

        ErrorResponse errorResponse = (ErrorResponse) response;
        softAssert.assertEquals(errorResponse.getCode(), EXPECTED_ERROR_CODE_UNAUTHORIZED, UNAUTHORIZED_ERROR_CODE_ERROR);
        softAssert.assertTrue(errorResponse.getMessage().contains(EXPECTED_UNAUTHORIZED_MESSAGE), UNAUTHORIZED_MESSAGE_ERROR);

        softAssert.assertAll();
    }

    @Test(description = "Try to2", suiteName = "api", enabled = false)
    void getInformation2() throws IOException, InterruptedException {
        // Arrange & Act
        TodoClient todoClient = new TodoClient();

        Object response = todoClient.GetUserByUUID(USER_ID_2);

        // Assert
        softAssert.assertNotNull(response, API_RESPONSE_NULL_ERROR);
        softAssert.assertTrue(response instanceof ErrorResponse, ERROR_RESPONSE_TYPE_ERROR);

        ErrorResponse errorResponse = (ErrorResponse) response;
        softAssert.assertEquals(errorResponse.getCode(), EXPECTED_ERROR_CODE_UNAUTHORIZED, UNAUTHORIZED_ERROR_CODE_ERROR);
        softAssert.assertTrue(errorResponse.getMessage().contains(EXPECTED_UNAUTHORIZED_MESSAGE), UNAUTHORIZED_MESSAGE_ERROR);

        softAssert.assertAll();
    }
}
