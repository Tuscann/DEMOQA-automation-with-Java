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

    // Client instance
    private TodoClient todoClient;

    // Test Data Constants
    private static final String VALID_USERNAME = "fbinnzhivko";
    private static final String VALID_PASSWORD = "Karma1987!@";

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

    @BeforeMethod
    public void setUpClient() {
        todoClient = new TodoClient();
    }

    @Test(description = "Count all books.", suiteName = "api", enabled = true)
    void getAllBooks() throws IOException, InterruptedException {
        List<Book> booksList = todoClient.FindAllBooks();

        softAssert.assertEquals(booksList.size(), EXPECTED_BOOK_COUNT, BOOK_COUNT_ERROR);
        softAssert.assertAll();
    }

    @Test(description = "Get All Books and verify first book properties.", suiteName = "api", enabled = true)
    void verifyFirstBookFromBooks() throws IOException, InterruptedException {
        List<Book> booksList = todoClient.FindAllBooks();

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

        softAssert.assertAll();
    }

    @Test(description = "Add book in user collection", suiteName = "api", enabled = true)
    void addBookToUserCollection() throws IOException, InterruptedException {
        String userId = "e90df422-7f2b-4f51-be1b-c92541eb370f";

        String statusCode = todoClient.CreateBook(VALID_USERNAME, VALID_PASSWORD, userId);

        String expectedResponse = """
                {"books":[{"isbn":"9781449331818"}]}""";

        softAssert.assertEquals(statusCode, expectedResponse, "Book not created");

        // Clear created book
        String response3 = todoClient.DeleteAllBooksForUser(VALID_USERNAME, VALID_PASSWORD, userId);

        softAssert.assertEquals(response3, "", "Delete operation not finished.");
        softAssert.assertAll();
    }

    @Test(description = "Try to Add book with wrong user id", suiteName = "api", enabled = true)
    void tryToAddBookWithWrongUserId() throws IOException, InterruptedException {
        String userId = "e90df422-7f2b-4f51-be1b-c92541eb370f";

        String statusCode = todoClient.CreateBook(VALID_USERNAME, VALID_PASSWORD, userId);

        String expectedResponse = """
                {"books":[{"isbn":"9781449331818"}]}""";

        softAssert.assertEquals(statusCode, expectedResponse, "Book not created");

        userId = "e9";

        String statusCode2 = todoClient.CreateBook(VALID_USERNAME, VALID_PASSWORD, userId);

        String expectedResponse2 = """
                {"code":"1207","message":"User Id not correct!"}""";

        softAssert.assertEquals(statusCode2, expectedResponse2, "Book not created");

        // Clear created book
        userId = "e90df422-7f2b-4f51-be1b-c92541eb370f";
        String response3 = todoClient.DeleteAllBooksForUser(VALID_USERNAME, VALID_PASSWORD, userId);

        softAssert.assertEquals(response3, "", "Delete operation not finished.");
        softAssert.assertAll();
    }

    @Test(description = "Try to add book in user collection which exist", suiteName = "api", enabled = true)
    void tryAddBookToUserCollectionWhichExist() throws IOException, InterruptedException {
        // Arrange
        String userId = "e90df422-7f2b-4f51-be1b-c92541eb370f";

        String statusCode = todoClient.CreateBook(VALID_USERNAME, VALID_PASSWORD, userId);

        String expectedResponse = """
                {"books":[{"isbn":"9781449331818"}]}""";

        softAssert.assertEquals(statusCode, expectedResponse, "Book not created");

        // Act
        statusCode = todoClient.CreateBook(VALID_USERNAME, VALID_PASSWORD, userId);

        expectedResponse = """
                {"code":"1210","message":"ISBN already present in the User's Collection!"}""";

        softAssert.assertEquals(statusCode, expectedResponse, "Book not created");

        // Clear created book
        userId = "e90df422-7f2b-4f51-be1b-c92541eb370f";
        String response3 = todoClient.DeleteAllBooksForUser(VALID_USERNAME, VALID_PASSWORD, userId);

        softAssert.assertEquals(response3, "", "Delete operation not finished.");
        softAssert.assertAll();
    }

    @Test(description = "Delete All Books For User", suiteName = "api", enabled = true)
    void deleteAllBooksForUser() throws IOException, InterruptedException {
        // Arrange
        String userId = "e90df422-7f2b-4f51-be1b-c92541eb370f";

        // Act
        String response = todoClient.DeleteAllBooksForUser(VALID_USERNAME, VALID_PASSWORD, userId);

        // Assert
        softAssert.assertEquals(response, "", "Delete operation not finished.");
        softAssert.assertAll();
    }

    @Test(description = "Try to Delete All Books with wrong user id", suiteName = "api", enabled = true)
    void tryToDeleteAllBooksForUserWithWrongUserId() throws IOException, InterruptedException {
        String userId = "e90";

        String response = todoClient.DeleteAllBooksForUser(VALID_USERNAME, VALID_PASSWORD, userId);

        String expectedResponse = """
                {"code":"1207","message":"User Id not correct!"}""";
        softAssert.assertEquals(response, expectedResponse, "Delete operation not finished.");
        softAssert.assertAll();
    }

    @Test(description = "Get Book By ISBN", suiteName = "api", enabled = true)
    void getBookByISBN() throws IOException, InterruptedException {
        Book books = todoClient.GetBookByISBN(EXPECTED_ISBN);

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

    @Test(description = "Delete All Books For User", suiteName = "api", enabled = true)
    void deleteBookForUserByIsbn() throws IOException, InterruptedException {
        String userId = "e90df422-7f2b-4f51-be1b-c92541eb370f";
        String isbn = "9781449331818";

        String response = todoClient.CreateBook(VALID_USERNAME, VALID_PASSWORD, userId);
        String expectedResponse = """
                {"books":[{"isbn":"9781449331818"}]}""";

        softAssert.assertEquals(response, expectedResponse, "Book not created");

        String statusCode2 = todoClient.DeleteBookForUserByIsbn(VALID_USERNAME, VALID_PASSWORD, userId, isbn);

        softAssert.assertEquals(statusCode2, "", "Book not deleted");
        softAssert.assertAll();
    }

    @Test(description = "Delete All Books For User", suiteName = "api", enabled = true)
    void tryToDeleteBookForUserByIsbnWithWrongUserId() throws IOException, InterruptedException {
        String userId = "e90df422-7f2b-4f51-be1b-c92541eb370f";
        String isbn = "9781449331818";

        String response = todoClient.CreateBook(VALID_USERNAME, VALID_PASSWORD, userId);
        String expectedResponse = """
                {"books":[{"isbn":"9781449331818"}]}""";

        softAssert.assertEquals(response, expectedResponse, "Book not created");

        userId = "2";

        String statusCode2 = todoClient.DeleteBookForUserByIsbn(VALID_USERNAME, VALID_PASSWORD, userId, isbn);

        String expectedResponse2 = """
                {"code":"1207","message":"User Id not correct!"}""";

        softAssert.assertEquals(statusCode2, expectedResponse2, "Book not deleted");

        // Clear created book
        userId = "e90df422-7f2b-4f51-be1b-c92541eb370f";
        String response3 = todoClient.DeleteAllBooksForUser(VALID_USERNAME, VALID_PASSWORD, userId);

        softAssert.assertEquals(response3, "", "Delete operation not finished.");
        softAssert.assertAll();
    }
}
