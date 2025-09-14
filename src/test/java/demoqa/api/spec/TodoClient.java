package demoqa.api.spec;

import demoqa.api.models.Book;
import demoqa.api.models.ErrorResponse;
import demoqa.api.models.Token;
import demoqa.api.models.User;
import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import static demoqa.web.base.BaseTest.DEMO_QA_URL;

public class TodoClient {

    HttpClient client;
    ObjectMapper objectMapper;

    public TodoClient() {
        client = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
    }

    public List<Book> getAllBooks() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DEMO_QA_URL + "BookStore/v1/Books"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String prettyJson = objectMapper.readTree(response.body()).get("books").toPrettyString();

        return objectMapper.readValue(prettyJson, new TypeReference<>() {
        });
    }

    public Book getBookWithValidIsbn(String isbn) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DEMO_QA_URL + "BookStore/v1/Book?ISBN=" + isbn))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String prettyJson = objectMapper.readTree(response.body()).toPrettyString();

        return objectMapper.readValue(prettyJson, new TypeReference<>() {
        });
    }

    public String authorizeUser(String username, String password) throws IOException, InterruptedException {

        String requestBody = String.format("userName=%s&password=%s",
                URLEncoder.encode(username, StandardCharsets.UTF_8),
                URLEncoder.encode(password, StandardCharsets.UTF_8));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DEMO_QA_URL + "Account/v1/Authorized"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public Token generateToken(String username, String password) throws IOException, InterruptedException {
        String requestBody = String.format("userName=%s&password=%s",
                URLEncoder.encode(username, StandardCharsets.UTF_8),
                URLEncoder.encode(password, StandardCharsets.UTF_8));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DEMO_QA_URL + "Account/v1/GenerateToken"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), Token.class);
    }

    public Object createNewUser(String username, String password) throws IOException, InterruptedException {
        String requestBody = String.format("userName=%s&password=%s",
                URLEncoder.encode(username, StandardCharsets.UTF_8),
                URLEncoder.encode(password, StandardCharsets.UTF_8));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DEMO_QA_URL + "Account/v1/User"))
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

    public Object deleteUser(String userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DEMO_QA_URL + "Account/v1/User/" + userId))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .DELETE()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        try {
            return objectMapper.readValue(response.body(), User.class);
        } catch (Exception e) {
            return objectMapper.readValue(response.body(), ErrorResponse.class);
        }
    }

    public String createBook(String username, String password, String userId, String isbn) throws IOException, InterruptedException {

        String basicAuth = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        String jsonBody = """
                {
                  "userId": "%s",
                  "collectionOfIsbns": [
                    {
                      "isbn": "%s"
                    }
                  ]
                }
                """.formatted(userId, isbn);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DEMO_QA_URL + "BookStore/v1/Books"))
                .header("accept", "application/json")
                .header("authorization", "Basic " + basicAuth)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String deleteAllBooksForUser(String username, String password, String userId) throws IOException, InterruptedException {

        String basicAuth = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DEMO_QA_URL + "BookStore/v1/Books?UserId=" + userId))
                .header("accept", "application/json")
                .header("authorization", "Basic " + basicAuth)
                .DELETE()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public Object getUserByUserId(String userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DEMO_QA_URL + "Account/v1/User/" + userId))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        try {
            return objectMapper.readValue(response.body(), User.class);
        } catch (Exception e) {
            return objectMapper.readValue(response.body(), ErrorResponse.class);
        }
    }

    public String deleteBookByUserIsbn(String validUsername, String validPassword, String userId, String isbn) throws IOException, InterruptedException {

        String basicAuth = Base64.getEncoder().encodeToString((validUsername + ":" + validPassword).getBytes());

        HttpClient client = HttpClient.newHttpClient();

        String jsonBody = """
                {
                  "isbn": "%s",
                  "userId": "%s"
                }
                """.formatted(isbn, userId);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DEMO_QA_URL + "BookStore/v1/Book"))
                .header("accept", "application/json")
                .header("authorization", "Basic " + basicAuth)
                .header("Content-Type", "application/json")
                .method("DELETE", HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String putBookToUserCollection(String validUsername, String validPassword, String userId, String isbn) throws IOException, InterruptedException {

        String basicAuth = Base64.getEncoder().encodeToString((validUsername + ":" + validPassword).getBytes());

        HttpClient client = HttpClient.newHttpClient();

        String jsonBody = """
                {
                  "userId": "%s",
                  "isbn": "%s"
                }
                """.formatted(userId, isbn);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DEMO_QA_URL + "BookStore/v1/Books/" + isbn))
                .header("accept", "application/json")
                .header("authorization", "Basic " + basicAuth)
                .header("Content-Type", "application/json")
                .method("PUT", HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getBookWithInvalidIsbn(String isbn) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(DEMO_QA_URL + "BookStore/v1/Book?ISBN=" + isbn))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
