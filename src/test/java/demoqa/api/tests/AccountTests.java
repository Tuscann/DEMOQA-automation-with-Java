package demoqa.api.tests;

import demoqa.api.BaseTestApi;
import demoqa.api.models.AuthorizationApi;
import demoqa.api.models.Credentials;
import demoqa.api.models.RegistrationData;
import demoqa.api.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTests extends BaseTestApi {

    private final AuthorizationApi authorizationApi = new AuthorizationApi();
    private final Credentials credentials = new Credentials();
    private final RegistrationData data = new RegistrationData();

    @Test(testName = "New user creation with success", suiteName = "api", enabled = true)
    void createNewUserTest() {

        credentials.setUserName(data.firstName + data.lastName);
        credentials.setPassword("karma");

        User newUser = authorizationApi.createUser(credentials);

        Assert.assertTrue(newUser.getUserId().isEmpty());
        Assert.assertEquals(credentials.getUserName(), newUser.getUsername());
        Assert.assertTrue(newUser.getBooks().isEmpty());
    }
}
