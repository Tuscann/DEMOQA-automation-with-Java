package demoqa.api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

import java.util.List;

public class User {
    @JsonProperty("userID")
    private String userId;
    private String username;
    private List<Book> books;

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public List<Book> getBooks() {
        return books;
    }
}
