package demoqa.api.tests;

import demoqa.api.models.Book;
import demoqa.api.spec.TodoClient;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class BooksStoreTests extends BaseTestApi {

    // Test Data Constants
    private static final int EXPECTED_BOOK_COUNT = 8;

    // Test Data Constants
    private static final String VALID_USERNAME = "fbinnzhivko";
    private static final String VALID_PASSWORD = "Karma1987!@";
    private static final String VALID_USER_ID = "e90df422-7f2b-4f51-be1b-c92541eb370f";
    private static final String VALID_ISBN = "9781449331818";
    private static final String INVALID_USER_ID = "";
    private static final String INVALID_ISBN = "9781449331811";

    // Book Properties Constants
    private static final String EXPECTED_ISBN = "9781449325862";
    private static final String EXPECTED_TITLE = "Git Pocket Guide";
    private static final String EXPECTED_SUBTITLE = "A Working Introduction";
    private static final String EXPECTED_AUTHOR = "Richard E. Silverman";
    private static final String EXPECTED_PUBLISH_DATE = "2020-06-04T08:48:39.000Z";
    private static final String EXPECTED_PUBLISHER = "O'Reilly Media";
    private static final String EXPECTED_PAGES = "234";
    private static final String EXPECTED_DESCRIPTION = "This pocket guide is the perfect on-the-job companion to Git, the distributed version control system. It provides a compact, readable introduction to Git for new users, as well as a reference to common commands and procedures for those of you with Git exp";
    private static final String EXPECTED_WEBSITE = "http://chimera.labs.oreilly.com/books/1230000000561/index.html";

    // Error Message Constants
    private static final String BOOK_COUNT_ERROR = "Expected book count mismatch";
    private static final String ISBN_ERROR = "Wrong ISBN";
    private static final String TITLE_ERROR = "Wrong Title";
    private static final String SUBTITLE_ERROR = "Wrong Subtitle";
    private static final String AUTHOR_ERROR = "Wrong Author";
    private static final String PUBLISH_DATE_ERROR = "Wrong Publish Date";
    private static final String PUBLISHER_ERROR = "Wrong Publisher";
    private static final String PAGES_ERROR = "Wrong Pages";
    private static final String DESCRIPTION_ERROR = "Wrong Description";
    private static final String WEBSITE_ERROR = "Wrong Website";
    private static final String DELETE_RESPONSE_MISMATCH = "Delete operation not finished.";
    private static final String BOOK_NOT_CREATED_MISMATCH = "Book not created";

    private TodoClient todoClient;

    @BeforeMethod
    public void setUpClient() {
        todoClient = new TodoClient();
    }

    @Test(enabled = true, description = "Get count of All Books and verify first book properties.", suiteName = "api")
    void verifyFirstBookFromBooks() throws IOException, InterruptedException {
        // Arrange & Act
        List<Book> booksList = todoClient.getAllBooks();

        String actualBookIsbn = booksList.getFirst().isbn();
        String actualBookTitle = booksList.getFirst().title();
        String actualBookSubTitle = booksList.getFirst().subTitle();
        String actualBookAuthor = booksList.getFirst().author();
        String actualBookPublishDate = booksList.getFirst().publish_date();
        String actualBookPublisher = booksList.getFirst().publisher();
        String actualBookPages = booksList.getFirst().pages();
        String actualBookDescription = booksList.getFirst().description();
        String actualBookWebsite = booksList.getFirst().website();

        // Assert
        softAssert.assertEquals(actualBookIsbn, EXPECTED_ISBN, ISBN_ERROR);
        softAssert.assertEquals(actualBookTitle, EXPECTED_TITLE, TITLE_ERROR);
        softAssert.assertEquals(actualBookSubTitle, EXPECTED_SUBTITLE, SUBTITLE_ERROR);
        softAssert.assertEquals(actualBookAuthor, EXPECTED_AUTHOR, AUTHOR_ERROR);
        softAssert.assertEquals(actualBookPublishDate, EXPECTED_PUBLISH_DATE, PUBLISH_DATE_ERROR);
        softAssert.assertEquals(actualBookPublisher, EXPECTED_PUBLISHER, PUBLISHER_ERROR);
        softAssert.assertEquals(actualBookPages, EXPECTED_PAGES, PAGES_ERROR);
        softAssert.assertEquals(actualBookDescription, EXPECTED_DESCRIPTION, DESCRIPTION_ERROR);
        softAssert.assertEquals(actualBookWebsite, EXPECTED_WEBSITE, WEBSITE_ERROR);
        softAssert.assertEquals(booksList.size(), EXPECTED_BOOK_COUNT, BOOK_COUNT_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Add book in user collection", suiteName = "api")
    void createBook() throws IOException, InterruptedException {
        // Arrange & Act
        String currentCreatBookResponse = todoClient.createBook(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID, VALID_ISBN);
        String expectedResponse = """
                {"books":[{"isbn":"9781449331818"}]}""";

        // Assert
        softAssert.assertEquals(currentCreatBookResponse, expectedResponse, BOOK_NOT_CREATED_MISMATCH);

        // Delete book created in this test
        String deleteBooksResponse = todoClient.deleteAllBooksForUser(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID);
        softAssert.assertEquals(deleteBooksResponse, "", DELETE_RESPONSE_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Try to add book in user collection with wrong ISBN", suiteName = "api")
    void tryToCreateBookWithInvalidIsbn() throws IOException, InterruptedException {
        // Arrange & Act
        String currentCreatBookResponse = todoClient.createBook(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID, INVALID_ISBN);

        String expectedResponse = """
                {"code":"1205","message":"ISBN supplied is not available in Books Collection!"}""";

        // Assert
        softAssert.assertEquals(currentCreatBookResponse, expectedResponse, BOOK_NOT_CREATED_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Try to Add book with wrong user id", suiteName = "api")
    void tryToAddBookWithInvalidUserId() throws IOException, InterruptedException {
        // Arrange & Act
        String currentCreatBookResponse = todoClient.createBook(VALID_USERNAME, VALID_PASSWORD, INVALID_USER_ID, VALID_ISBN);

        String expectedResponse2 = """
                {"code":"1207","message":"User Id not correct!"}""";
        // Assert
        softAssert.assertEquals(currentCreatBookResponse, expectedResponse2, BOOK_NOT_CREATED_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Try to add book in user collection which exist", suiteName = "api")
    void tryAddBookToUserCollectionWhichExist() throws IOException, InterruptedException {
        // Arrange
        String currentCreatBookResponse = todoClient.createBook(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID, VALID_ISBN);

        String expectedResponse = """
                {"books":[{"isbn":"9781449331818"}]}""";

        softAssert.assertEquals(currentCreatBookResponse, expectedResponse, BOOK_NOT_CREATED_MISMATCH);

        // Act
        String currentCreatBookResponse2 = todoClient.createBook(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID, VALID_ISBN);

        expectedResponse = """
                {"code":"1210","message":"ISBN already present in the User's Collection!"}""";

        softAssert.assertEquals(currentCreatBookResponse2, expectedResponse, BOOK_NOT_CREATED_MISMATCH);

        // Clear created book
        String currentDeleteBooksResponse = todoClient.deleteAllBooksForUser(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID);

        softAssert.assertEquals(currentDeleteBooksResponse, "", DELETE_RESPONSE_MISMATCH);
        softAssert.assertAll();
    }

    @Test(description = "Delete All Books For User", suiteName = "api", enabled = true)
    void deleteAllBooksForUser() throws IOException, InterruptedException {
        // Arrange & Act
        String currentDeleteBooksResponse = todoClient.deleteAllBooksForUser(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID);

        // Assert
        softAssert.assertEquals(currentDeleteBooksResponse, "", DELETE_RESPONSE_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Try to Delete All Books with wrong user id", suiteName = "api")
    void tryToDeleteAllBooksForUserWithWrongUserId() throws IOException, InterruptedException {
        // Arrange & Act
        String currentDeleteBooksResponse = todoClient.deleteAllBooksForUser(VALID_USERNAME, VALID_PASSWORD, INVALID_USER_ID);

        String expectedResponse = """
                {"code":"1207","message":"User Id not correct!"}""";

        // Assert
        softAssert.assertEquals(currentDeleteBooksResponse, expectedResponse, DELETE_RESPONSE_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Get Book By ISBN", suiteName = "api")
    void getBookByIsbn() throws IOException, InterruptedException {
        // Arrange & Act
        Book books = todoClient.getBookWithValidIsbn(EXPECTED_ISBN);

        String actualBookIsbn = books.isbn();
        String actualBookTitle = books.title();
        String actualBookSubTitle = books.subTitle();
        String actualBookAuthor = books.author();
        String actualBookPublishDate = books.publish_date();
        String actualBookPublisher = books.publisher();
        String actualBookPages = books.pages();
        String actualBookDescription = books.description();
        String actualBookWebsite = books.website();

        // Assert
        softAssert.assertEquals(actualBookIsbn, EXPECTED_ISBN, ISBN_ERROR);
        softAssert.assertEquals(actualBookTitle, EXPECTED_TITLE, TITLE_ERROR);
        softAssert.assertEquals(actualBookSubTitle, EXPECTED_SUBTITLE, SUBTITLE_ERROR);
        softAssert.assertEquals(actualBookAuthor, EXPECTED_AUTHOR, AUTHOR_ERROR);
        softAssert.assertEquals(actualBookPublishDate, EXPECTED_PUBLISH_DATE, PUBLISH_DATE_ERROR);
        softAssert.assertEquals(actualBookPublisher, EXPECTED_PUBLISHER, PUBLISHER_ERROR);
        softAssert.assertEquals(actualBookPages, EXPECTED_PAGES, PAGES_ERROR);
        softAssert.assertEquals(actualBookDescription, EXPECTED_DESCRIPTION, DESCRIPTION_ERROR);
        softAssert.assertEquals(actualBookWebsite, EXPECTED_WEBSITE, WEBSITE_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Try to get book with invalid isbn", suiteName = "api")
    void tryToGetBookWithInvalidIsbn() throws IOException, InterruptedException {
        // Arrange & Act
        String response = todoClient.getBookWithInvalidIsbn(INVALID_ISBN);
        String expectedResponse = """
                {"code":"1205","message":"ISBN supplied is not available in Books Collection!"}""";

        // Assert
        softAssert.assertEquals(response, expectedResponse, "Get operation not finished.");
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Delete all books for user by Isbn", suiteName = "api")
    void deleteBookForUserByIsbn() throws IOException, InterruptedException {
        // Arrange & Act
        String currentCreatBookResponse = todoClient.createBook(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID, VALID_ISBN);
        String expectedResponse = """
                {"books":[{"isbn":"9781449331818"}]}""";

        // Assert
        softAssert.assertEquals(currentCreatBookResponse, expectedResponse, BOOK_NOT_CREATED_MISMATCH);

        String currentDeleteBooksResponse = todoClient.deleteBookByUserIsbn(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID, VALID_ISBN);

        softAssert.assertEquals(currentDeleteBooksResponse, "", DELETE_RESPONSE_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Try to delete all books for invalid user", suiteName = "api")
    void tryToDeleteBookForUserByIsbnWithInvalidUserId() throws IOException, InterruptedException {
        // Arrange & Act
        String currentCreatBookResponse = todoClient.createBook(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID, VALID_ISBN);
        String expectedResponse = """
                {"books":[{"isbn":"9781449331818"}]}""";

        softAssert.assertEquals(currentCreatBookResponse, expectedResponse, "Book not created");

        String currentDeleteBooksResponse = todoClient.deleteBookByUserIsbn(VALID_USERNAME, VALID_PASSWORD, INVALID_USER_ID, VALID_ISBN);

        String expectedResponse2 = """
                {"code":"1207","message":"User Id not correct!"}""";
        // Assert
        softAssert.assertEquals(currentDeleteBooksResponse, expectedResponse2, "Book not deleted");

        // Clear created book
        String response3 = todoClient.deleteAllBooksForUser(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID);
        softAssert.assertEquals(response3, "", DELETE_RESPONSE_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Try to delete book for user by invalid Isbn", suiteName = "api")
    void tryToDeleteBookForUserByIsbnWithInvalidIsbn() throws IOException, InterruptedException {
        // Arrange & Act
        String currentCreatBookResponse = todoClient.createBook(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID, VALID_ISBN);

        String expectedResponse = """
                {"books":[{"isbn":"9781449331818"}]}""";

        softAssert.assertEquals(currentCreatBookResponse, expectedResponse, BOOK_NOT_CREATED_MISMATCH);

        String expectedResponse2 = """
                {"code":"1206","message":"ISBN supplied is not available in User's Collection!"}""";

        String statusCode2 = todoClient.deleteBookByUserIsbn(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID, INVALID_ISBN);

        // Assert
        softAssert.assertEquals(statusCode2, expectedResponse2, DELETE_RESPONSE_MISMATCH);

        // Delete book from this test
        String statusCode3 = todoClient.deleteBookByUserIsbn(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID, VALID_ISBN);
        softAssert.assertEquals(statusCode3, "", DELETE_RESPONSE_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Try to put book in user collection", suiteName = "api")
    void tryToPutBookToUserCollection() throws IOException, InterruptedException {
        // Arrange & Act
        String currentCreatBookResponse = todoClient.createBook(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID, VALID_ISBN);

        String expectedResponse = """
                {"books":[{"isbn":"9781449331818"}]}""";

        softAssert.assertEquals(currentCreatBookResponse, expectedResponse, BOOK_NOT_CREATED_MISMATCH);

        // Clear created book
        String response2 = todoClient.putBookToUserCollection(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID, INVALID_ISBN);

        String expectedResponse2 = """
                {"code":"1205","message":"ISBN supplied is not available in Books Collection!"}""";

        softAssert.assertEquals(response2, expectedResponse2, DELETE_RESPONSE_MISMATCH);

        // Delete book from this test
        String response3 = todoClient.deleteAllBooksForUser(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID);

        // Assert
        softAssert.assertEquals(response3, "", DELETE_RESPONSE_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Put book in user collection", suiteName = "api")
    void putBookToUserCollection() throws IOException, InterruptedException {
        // Arrange & Act
        String response2 = todoClient.putBookToUserCollection(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID, VALID_ISBN);
        String expectedResponse2 = """
                {"code":"1206","message":"ISBN supplied is not available in User's Collection!"}""";

        softAssert.assertEquals(response2, expectedResponse2, DELETE_RESPONSE_MISMATCH);

        String response3 = todoClient.deleteAllBooksForUser(VALID_USERNAME, VALID_PASSWORD, VALID_USER_ID);

        // Assert
        softAssert.assertEquals(response3, "", DELETE_RESPONSE_MISMATCH);
        softAssert.assertAll();
    }
}
