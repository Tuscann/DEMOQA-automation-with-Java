package demoqa.api.tests;

import demoqa.api.models.ErrorResponse;
import demoqa.api.models.Token;
import demoqa.api.models.User;
import demoqa.api.spec.TodoClient;
import org.testng.annotations.BeforeMethod;
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
    private static final String EXPECTED_USER_NOT_FOUND_RESPONSE = """
            {"code":"1207","message":"User not found!"}""";
    private static final String EXPECTED_SUCCESS_STATUS = "Success";
    private static final String EXPECTED_SUCCESS_RESULT = "User authorized successfully.";
    private static final String EXPECTED_ERROR_CODE_USER_EXISTS = "1204";
    private static final String EXPECTED_ERROR_CODE_UNAUTHORIZED = "1200";
    private static final String EXPECTED_UNAUTHORIZED_MESSAGE = "User not authorized!";

    // Error Message Constants
    private static final String AUTHORIZATION_ERROR = "Wrong authorization request";
    private static final String API_RESPONSE_ERROR = "Wrong response from API";
    private static final String TOKEN_FIELD_NULL_ERROR = "Token field should not be null";
    private static final String EXPIRES_FIELD_NULL_ERROR = "Expires field should not be null";
    private static final String TOKEN_STATUS_ERROR = "Token status should be 'Success'";
    private static final String TOKEN_RESULT_ERROR = "Token result should indicate successful authorization";
    private static final String USER_ID_NULL_ERROR = "UserId should not be null";
    private static final String USERNAME_MISMATCH_ERROR = "Username in response should match the one sent";
    private static final String BOOKS_ARRAY_EMPTY_ERROR = "Books array should be empty for new user";
    private static final String API_RESPONSE_NULL_ERROR = "API response should not be null";
    private static final String ERROR_RESPONSE_TYPE_ERROR = "Response should be an error for existing user";
    private static final String ERROR_CODE_MISMATCH_ERROR = "Error code should be 1204 for user exists";
    private static final String USER_EXISTS_MESSAGE_ERROR = "Error message should indicate user exists";
    private static final String UNAUTHORIZED_ERROR_CODE_ERROR = "Error code should be 1200 for unauthorized user";
    private static final String UNAUTHORIZED_MESSAGE_ERROR = "Error message should indicate user not authorized";
    User testUser = new User();
    // Client instance
    private TodoClient todoClient;

    @BeforeMethod
    public void setUpClient() {
        todoClient = new TodoClient();
    }

    @Test(description = "Authorized user with POST", suiteName = "api", enabled = true)
    void authorizeUserWithValidUserAndValidPassword() throws IOException, InterruptedException {
        // Arrange & Act
        String isUserFound = todoClient.authorizeUser(VALID_USERNAME, VALID_PASSWORD);

        // Assert
        softAssert.assertEquals(isUserFound, EXPECTED_AUTHORIZED_RESPONSE, AUTHORIZATION_ERROR);
        softAssert.assertAll();
    }

    @Test(description = "Try to authorized non existing user with POST", suiteName = "api", enabled = true)
    void tryToAuthorizeInvalidUserAndValidPassword() throws IOException, InterruptedException {
        // Arrange & Act
        String response = todoClient.authorizeUser(INVALID_USERNAME, VALID_PASSWORD);

        // Assert
        softAssert.assertEquals(response, EXPECTED_USER_NOT_FOUND_RESPONSE, API_RESPONSE_ERROR);
        softAssert.assertAll();
    }

    @Test(description = "Generate Token with POST", suiteName = "api", enabled = true)
    void generateTokenWithValidUsernameAndValidPassword() throws IOException, InterruptedException {
        // Arrange & Act
        Token token = todoClient.generateToken(VALID_USERNAME, VALID_PASSWORD);

        // Assert
        softAssert.assertNotNull(token.getToken(), TOKEN_FIELD_NULL_ERROR);
        softAssert.assertNotNull(token.getExpires(), EXPIRES_FIELD_NULL_ERROR);
        softAssert.assertEquals(token.getStatus(), EXPECTED_SUCCESS_STATUS, TOKEN_STATUS_ERROR);
        softAssert.assertEquals(token.getResult(), EXPECTED_SUCCESS_RESULT, TOKEN_RESULT_ERROR);

        softAssert.assertAll();
    }

    @Test(description = "Generate new valid user with POST", suiteName = "api", enabled = false)
    void createNewUser() throws IOException, InterruptedException {
        // Arrange & Act
        String username = VALID_USERNAME + 100 + (int) (Math.random() * 899);
        Object response = todoClient.createNewUser(username, VALID_PASSWORD);

        User user = (User) response;
        softAssert.assertNotNull(user.getUserId(), USER_ID_NULL_ERROR);
        softAssert.assertEquals(user.getUsername(), username, USERNAME_MISMATCH_ERROR);
        softAssert.assertTrue(user.getBooks().isEmpty(), BOOKS_ARRAY_EMPTY_ERROR);

        softAssert.assertAll();
    }

    @Test(description = "Try to generate new user with existing user with POST", suiteName = "api", enabled = true)
    void generateNewUserWithExistingUser() throws IOException, InterruptedException {
        // Arrange & Act
        Object response = todoClient.createNewUser(VALID_USERNAME, VALID_PASSWORD);

        // Assert
        softAssert.assertNotNull(response, API_RESPONSE_NULL_ERROR);
        softAssert.assertTrue(response instanceof ErrorResponse, ERROR_RESPONSE_TYPE_ERROR);

        ErrorResponse errorResponse = (ErrorResponse) response;
        softAssert.assertEquals(errorResponse.getCode(), EXPECTED_ERROR_CODE_USER_EXISTS, ERROR_CODE_MISMATCH_ERROR);
        softAssert.assertTrue(errorResponse.getMessage().contains("User exists"), USER_EXISTS_MESSAGE_ERROR);

        softAssert.assertAll();
    }

    @Test(description = "Try to delete user with not authorized user with DELETE", suiteName = "api", enabled = true)
    void tryToDeleteUserWithoutAuthorization() throws IOException, InterruptedException {
        // Arrange & Act
        Object response = todoClient.deleteUser(USER_ID);

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
        Object response = todoClient.getUserByUserId(USER_ID);

        // Assert
        softAssert.assertNotNull(response, API_RESPONSE_NULL_ERROR);
        softAssert.assertTrue(response instanceof ErrorResponse, ERROR_RESPONSE_TYPE_ERROR);

        ErrorResponse errorResponse = (ErrorResponse) response;
        softAssert.assertEquals(errorResponse.getCode(), EXPECTED_ERROR_CODE_UNAUTHORIZED, UNAUTHORIZED_ERROR_CODE_ERROR);
        softAssert.assertTrue(errorResponse.getMessage().contains(EXPECTED_UNAUTHORIZED_MESSAGE), UNAUTHORIZED_MESSAGE_ERROR);

        softAssert.assertAll();
    }

    @Test(description = "Try to2", suiteName = "api", enabled = true)
    void getUserInformation() throws IOException, InterruptedException {
        // Arrange
        String isUserFound = todoClient.authorizeUser(VALID_USERNAME, VALID_PASSWORD);
        softAssert.assertEquals(isUserFound, EXPECTED_AUTHORIZED_RESPONSE, AUTHORIZATION_ERROR);
        Object response = todoClient.getUserByUserId(USER_ID_2);

        // Assert
        softAssert.assertNotNull(response, API_RESPONSE_NULL_ERROR);
        softAssert.assertTrue(response instanceof ErrorResponse, ERROR_RESPONSE_TYPE_ERROR);

        ErrorResponse errorResponse = (ErrorResponse) response;
        softAssert.assertEquals(errorResponse.getCode(), EXPECTED_ERROR_CODE_UNAUTHORIZED, UNAUTHORIZED_ERROR_CODE_ERROR);
        softAssert.assertTrue(errorResponse.getMessage().contains(EXPECTED_UNAUTHORIZED_MESSAGE), UNAUTHORIZED_MESSAGE_ERROR);

        softAssert.assertAll();
    }
}
