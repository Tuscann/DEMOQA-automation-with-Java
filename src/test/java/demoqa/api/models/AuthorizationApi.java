package demoqa.api.models;

import static demoqa.api.data.ResponseSpecs.responseSpec;
import static demoqa.api.spec.RequestSpecs.jsonRequestSpec;
import static io.restassured.RestAssured.given;

public class AuthorizationApi {

    public User createUser(Credentials credentials) {
        return given(jsonRequestSpec)
                .body(credentials)
                .when()
                .post("/Account/v1/User")
                .then()
                .spec(responseSpec)
                .statusCode(201)
                .extract().as(User.class);
    }
//
//    public Token getToken(Credentials credentials) {
//        return given(jsonRequestSpec)
//                .body(credentials)
//                .when()
//                .post("/Account/v1/GenerateToken")
//                .then()
//                .spec(responseSpec)
//                .statusCode(200)
//                .extract().as(Token.class);
//    }
//
//    public Cookie login(Credentials credentials) {
//        return given(jsonRequestSpec)
//                .body(credentials)
//                .when()
//                .post("/Account/v1/Login")
//                .then()
//                .spec(responseSpec)
//                .statusCode(200)
//                .extract().as(Cookie.class);
//    }
//
//    public void deleteUser(UserNew user, Token token) {
//        given(requestSpec)
//                .header("Authorization", "Bearer " + token.getToken())
//                .when()
//                .delete("/Account/v1/User/" + user.getUserID())
//                .then()
//                .spec(responseSpec)
//                .statusCode(204)
//                .body(is(emptyOrNullString()));
//    }
}
