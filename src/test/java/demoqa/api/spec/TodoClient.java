package demoqa.api.spec;

import demoqa.api.models.Book;
import demoqa.api.models.Token;
import demoqa.api.models.User;
import demoqa.api.models.ErrorResponse;
import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class TodoClient {
    private final String BASE_URL = "https://demoqa.com";
    HttpClient client;
    ObjectMapper objectMapper;

    public TodoClient() {
        client = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
    }

    public List<Book> FindAllBooks() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/BookStore/v1/Books"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String prettyJson = objectMapper.readTree(response.body()).get("books").toPrettyString();
        List<Book> books = objectMapper.readValue(prettyJson, new TypeReference<>() {
        });

        return books;
    }

    public Book GetBookByISBN(String ISBN) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/BookStore/v1/Book?ISBN=" + ISBN))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String prettyJson = objectMapper.readTree(response.body()).toPrettyString();

        Book book = objectMapper.readValue(prettyJson, new TypeReference<>() {
        });

        return book;
    }

    public String AuthorizeUser(String username, String password) throws IOException, InterruptedException {

        String requestBody = String.format("userName=%s&password=%s",
                URLEncoder.encode(username, StandardCharsets.UTF_8),
                URLEncoder.encode(password, StandardCharsets.UTF_8));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/Account/v1/Authorized"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public Token GenerateToken(String username, String password) throws IOException, InterruptedException {
        String requestBody = String.format("userName=%s&password=%s",
                URLEncoder.encode(username, StandardCharsets.UTF_8),
                URLEncoder.encode(password, StandardCharsets.UTF_8));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/Account/v1/GenerateToken"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), Token.class);
    }

    public Object GenerateNewUser(String username, String password) throws IOException, InterruptedException {
        String requestBody = String.format("userName=%s&password=%s",
                URLEncoder.encode(username, StandardCharsets.UTF_8),
                URLEncoder.encode(password, StandardCharsets.UTF_8));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/Account/v1/User"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        try {
            return objectMapper.readValue(response.body(), User.class);
        } catch (Exception e) {
            return objectMapper.readValue(response.body(), ErrorResponse.class);
        }
    }
}
