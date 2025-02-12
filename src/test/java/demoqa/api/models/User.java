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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
