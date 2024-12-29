package demoqa.api.models;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String userId,
            username;

    private List<Book> books;
}
