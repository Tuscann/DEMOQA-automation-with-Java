package demoqa.api.tests;

import demoqa.api.models.Book;
import demoqa.api.spec.TodoClient;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class BooksStoreTests extends BaseTestApi {

    @Test(description = "Count all books with GET Books", suiteName = "api", enabled = true)
    void getAllBooks() throws IOException, InterruptedException {
        TodoClient todoClient = new TodoClient();
        List<Book> books = todoClient.FindAllBooks();

        int expectedBookCount = 8;

        Assert.assertEquals(books.size(), expectedBookCount);
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

        String expectedIsbn = "9781449325862";
        String expectedTitle = "Git Pocket Guide";
        String expectedSubTitle = "A Working Introduction";
        String expectedAuthor = "Richard E. Silverman";
        String expectedPublish_date = "2020-06-04T08:48:39.000Z";
        String expectedPublisher = "O'Reilly Media";
        String expectedPages = "234";
        String expectedDescription = "This pocket guide is the perfect on-the-job companion to Git, the distributed version control system. It provides a compact, readable introduction to Git for new users, as well as a reference to common commands and procedures for those of you with Git exp";
        String expectedWebsite = "http://chimera.labs.oreilly.com/books/1230000000561/index.html";

        softAssert.assertEquals(actualIsbn, expectedIsbn, "\n Wrong ISBN.\n");
        softAssert.assertEquals(actualTitle, expectedTitle, "\nWrong Title.\n");
        softAssert.assertEquals(actualSubTitle, expectedSubTitle, "\nWrong Subtitle.\n");
        softAssert.assertEquals(actualAuthor, expectedAuthor, "\nWrong Author.\n");
        softAssert.assertEquals(actualPublish_date, expectedPublish_date, "\nWrong Publish Date.\n");
        softAssert.assertEquals(actualPublisher, expectedPublisher, "\nWrong Publisher.\n");
        softAssert.assertEquals(actualPages, expectedPages, "\nWrong Pages.\n");
        softAssert.assertEquals(actualDescription, expectedDescription, "\nWrong Description.\n");
        softAssert.assertEquals(actualWebsite, expectedWebsite, "\nWrong Website.\n");

        softAssert.assertAll();
    }

    @Test(description = "Get Book By ISBN", suiteName = "api", enabled = true)
    void getBookByISBN() throws IOException, InterruptedException {
        TodoClient client = new TodoClient();

        String expectedIsbn = "9781449325862";

        Book book = client.GetBookByISBN(expectedIsbn);

        String actualIsbn = book.isbn();
        String actualTitle = book.title();
        String actualSubTitle = book.subTitle();
        String actualAuthor = book.author();
        String actualPublish_date = book.publish_date();
        String actualPublisher = book.publisher();
        String actualPages = book.pages();
        String actualDescription = book.description();
        String actualWebsite = book.website();

        String expectedTitle = "Git Pocket Guide";
        String expectedSubTitle = "A Working Introduction";
        String expectedAuthor = "Richard E. Silverman";
        String expectedPublish_date = "2020-06-04T08:48:39.000Z";
        String expectedPublisher = "O'Reilly Media";
        String expectedPages = "234";
        String expectedDescription = "This pocket guide is the perfect on-the-job companion to Git, the distributed version control system. It provides a compact, readable introduction to Git for new users, as well as a reference to common commands and procedures for those of you with Git exp";
        String expectedWebsite = "http://chimera.labs.oreilly.com/books/1230000000561/index.html";

        softAssert.assertEquals(actualIsbn, expectedIsbn, "\n Wrong ISBN.\n");
        softAssert.assertEquals(actualTitle, expectedTitle, "\nWrong Title.\n");
        softAssert.assertEquals(actualSubTitle, expectedSubTitle, "\nWrong Subtitle.\n");
        softAssert.assertEquals(actualAuthor, expectedAuthor, "\nWrong Author.\n");
        softAssert.assertEquals(actualPublish_date, expectedPublish_date, "\nWrong Publish Date.\n");
        softAssert.assertEquals(actualPublisher, expectedPublisher, "\nWrong Publisher.\n");
        softAssert.assertEquals(actualPages, expectedPages, "\nWrong Pages.\n");
        softAssert.assertEquals(actualDescription, expectedDescription, "\nWrong Description.\n");
        softAssert.assertEquals(actualWebsite, expectedWebsite, "\nWrong Website.\n");

        softAssert.assertAll();
    }
}
