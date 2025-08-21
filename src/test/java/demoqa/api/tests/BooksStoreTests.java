package demoqa.api.tests;

import demoqa.api.models.Book;
import demoqa.api.spec.TodoClient;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class BooksStoreTests extends BaseTestApi {

    // Test Data Constants
    private static final int EXPECTED_BOOK_COUNT = 8;
    
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

    @Test(description = "Count all books with GET Books", suiteName = "api", enabled = true)
    void getAllBooks() throws IOException, InterruptedException {
        TodoClient todoClient = new TodoClient();
        List<Book> books = todoClient.FindAllBooks();

        softAssert.assertEquals(books.size(), EXPECTED_BOOK_COUNT, BOOK_COUNT_ERROR);
        softAssert.assertAll();
    }

    @Test(description = "Get All Books and verify first book properties with GET BOOKS.", suiteName = "api", enabled = true)
    void verifyFirstBookFromBooks() throws IOException, InterruptedException {
        TodoClient client = new TodoClient();
        List<Book> books = client.FindAllBooks();

        String actualIsbn = books.getFirst().isbn();
        String actualTitle = books.getFirst().title();
        String actualSubTitle = books.getFirst().subTitle();
        String actualAuthor = books.getFirst().author();
        String actualPublish_date = books.getFirst().publish_date();
        String actualPublisher = books.getFirst().publisher();
        String actualPages = books.getFirst().pages();
        String actualDescription = books.getFirst().description();
        String actualWebsite = books.getFirst().website();

        // Assert
        softAssert.assertEquals(actualIsbn, EXPECTED_ISBN, ISBN_ERROR);
        softAssert.assertEquals(actualTitle, EXPECTED_TITLE, TITLE_ERROR);
        softAssert.assertEquals(actualSubTitle, EXPECTED_SUBTITLE, SUBTITLE_ERROR);
        softAssert.assertEquals(actualAuthor, EXPECTED_AUTHOR, AUTHOR_ERROR);
        softAssert.assertEquals(actualPublish_date, EXPECTED_PUBLISH_DATE, PUBLISH_DATE_ERROR);
        softAssert.assertEquals(actualPublisher, EXPECTED_PUBLISHER, PUBLISHER_ERROR);
        softAssert.assertEquals(actualPages, EXPECTED_PAGES, PAGES_ERROR);
        softAssert.assertEquals(actualDescription, EXPECTED_DESCRIPTION, DESCRIPTION_ERROR);
        softAssert.assertEquals(actualWebsite, EXPECTED_WEBSITE, WEBSITE_ERROR);

        softAssert.assertAll();
    }

    @Test(description = "Get Book By ISBN", suiteName = "api", enabled = true)
    void getBookByISBN() throws IOException, InterruptedException {
        TodoClient client = new TodoClient();
        Book book = client.GetBookByISBN(EXPECTED_ISBN);

        String actualIsbn = book.isbn();
        String actualTitle = book.title();
        String actualSubTitle = book.subTitle();
        String actualAuthor = book.author();
        String actualPublish_date = book.publish_date();
        String actualPublisher = book.publisher();
        String actualPages = book.pages();
        String actualDescription = book.description();
        String actualWebsite = book.website();

        // Assert
        softAssert.assertEquals(actualIsbn, EXPECTED_ISBN, ISBN_ERROR);
        softAssert.assertEquals(actualTitle, EXPECTED_TITLE, TITLE_ERROR);
        softAssert.assertEquals(actualSubTitle, EXPECTED_SUBTITLE, SUBTITLE_ERROR);
        softAssert.assertEquals(actualAuthor, EXPECTED_AUTHOR, AUTHOR_ERROR);
        softAssert.assertEquals(actualPublish_date, EXPECTED_PUBLISH_DATE, PUBLISH_DATE_ERROR);
        softAssert.assertEquals(actualPublisher, EXPECTED_PUBLISHER, PUBLISHER_ERROR);
        softAssert.assertEquals(actualPages, EXPECTED_PAGES, PAGES_ERROR);
        softAssert.assertEquals(actualDescription, EXPECTED_DESCRIPTION, DESCRIPTION_ERROR);
        softAssert.assertEquals(actualWebsite, EXPECTED_WEBSITE, WEBSITE_ERROR);

        softAssert.assertAll();
    }
}
