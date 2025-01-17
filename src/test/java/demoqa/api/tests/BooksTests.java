package demoqa.api.tests;

import demoqa.api.BaseTestApi;
import demoqa.api.models.Book;
import demoqa.api.spec.TodoClient;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class BooksTests extends BaseTestApi {

    @Test(testName = "Count all books", suiteName = "api", enabled = true)
    void GetAllBooks() throws IOException, InterruptedException {
        TodoClient todoClient = new TodoClient();
        List<Book> books = todoClient.FindAllBooks();

        int expectedBookCount = 8;

        Assert.assertEquals(books.size(), expectedBookCount);
    }

    @Test(testName = "Get All Books and verify first book properties.", suiteName = "api", enabled = true)
    void VerifyFirstBookFromBooks() throws IOException, InterruptedException {
        TodoClient client = new TodoClient();
        List<Book> books = client.FindAllBooks();

        String actualIsbn = books.get(0).isbn();
        String actualTitle = books.get(0).title();
        String actualSubTitle = books.get(0).subTitle();
        String actualAuthor = books.get(0).author();
        String actualPublish_date = books.get(0).publish_date();
        String actualPublisher = books.get(0).publisher();
        String actualPages = books.get(0).pages();
        String actualDescription = books.get(0).description();
        String actualWebsite = books.get(0).website();

        String expectedIsbn = "9781449325862";
        String expectedTitle = "Git Pocket Guide";
        String expectedSubTitle = "A Working Introduction";
        String expectedAuthor = "Richard E. Silverman";
        String expectedPublish_date = "2020-06-04T08:48:39.000Z";
        String expectedPublisher = "O'Reilly Media";
        String expectedPages = "234";
        String expectedDescription = "This pocket guide is the perfect on-the-job companion to Git, the distributed version control system. It provides a compact, readable introduction to Git for new users, as well as a reference to common commands and procedures for those of you with Git exp";
        String expectedWebsite = "http://chimera.labs.oreilly.com/books/1230000000561/index.html";

        Assert.assertEquals(actualIsbn, expectedIsbn, "\n Wrong ISBN.\n");
        Assert.assertEquals(actualTitle, expectedTitle, "\nWrong Title.\n");
        Assert.assertEquals(actualSubTitle, expectedSubTitle, "\nWrong Subtitle.\n");
        Assert.assertEquals(actualAuthor, expectedAuthor, "\nWrong Author.\n");
        Assert.assertEquals(actualPublish_date, expectedPublish_date, "\nWrong Publish Date.\n");
        Assert.assertEquals(actualPublisher, expectedPublisher, "\nWrong Publisher.\n");
        Assert.assertEquals(actualPages, expectedPages, "\nWrong Pages.\n");
        Assert.assertEquals(actualDescription, expectedDescription, "\nWrong Description.\n");
        Assert.assertEquals(actualWebsite, expectedWebsite, "\nWrong Website.\n");
    }

    @Test(testName = "Get Book By ISBN", suiteName = "api", enabled = true)
    void GetBookByISBN() throws IOException, InterruptedException {
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

        Assert.assertEquals(actualIsbn, expectedIsbn, "\n Wrong ISBN.\n");
        Assert.assertEquals(actualTitle, expectedTitle, "\nWrong Title.\n");
        Assert.assertEquals(actualSubTitle, expectedSubTitle, "\nWrong Subtitle.\n");
        Assert.assertEquals(actualAuthor, expectedAuthor, "\nWrong Author.\n");
        Assert.assertEquals(actualPublish_date, expectedPublish_date, "\nWrong Publish Date.\n");
        Assert.assertEquals(actualPublisher, expectedPublisher, "\nWrong Publisher.\n");
        Assert.assertEquals(actualPages, expectedPages, "\nWrong Pages.\n");
        Assert.assertEquals(actualDescription, expectedDescription, "\nWrong Description.\n");
        Assert.assertEquals(actualWebsite, expectedWebsite, "\nWrong Website.\n");
    }
}
