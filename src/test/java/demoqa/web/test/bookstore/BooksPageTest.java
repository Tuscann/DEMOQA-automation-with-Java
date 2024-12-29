package demoqa.web.test.bookstore;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BooksPageTest extends BaseTest {

    @Test
    public void CheckAllFourPagesLinks() {
        navigateToUrl("books");

        String expectedUrl = "https://demoqa.com/login";
        booksPage.clickLoginLink();
        String actualUrl = booksPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/books";
        booksPage.clickBookStoreLink();
        actualUrl = booksPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/profile";
        booksPage.clickProfileLink();
        actualUrl = booksPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/swagger/";
        booksPage.clickBookStoreAPILink();
        actualUrl = booksPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void GetFirstRowOfTable() {
        navigateToUrl("books");

        String expectedTopRow = """
                Image
                Title
                Author
                Publisher""";

        String actualTopRow = booksPage.getTopRowTable();

        Assert.assertEquals(actualTopRow, expectedTopRow);
    }

    @Test
    public void CheckCountOfDefaultBooks() {
        navigateToUrl("books");

        int expectedBooksCount = 8;

        int actualBooksCount = booksPage.getCountFoundBooks();

        Assert.assertEquals(actualBooksCount, expectedBooksCount);
    }

    @Test
    public void ClickLoginButton() {
        navigateToUrl("books");

        booksPage.clickLoginButton();

        String expectedUrl = "https://demoqa.com/login";
        String actualUrl = booksPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void SearchAndFindOneBook() {
        navigateToUrl("books");

        String searchedBook = "Understanding ECMAScript 6";

        booksPage.searchBooksWithWord(searchedBook);
        String expectedBooksCount = """
                Understanding ECMAScript 6
                Nicholas C. Zakas
                No Starch Press""";
        String actualFindBooks = booksPage.getAllFoundBooks();

        Assert.assertEquals(actualFindBooks, expectedBooksCount);
    }

    @Test
    public void SearchAndFindNoBook() {
        navigateToUrl("books");

        String searchedBook = "Zhivko";

        booksPage.searchBooksWithWord(searchedBook);
        String expectedMessage = "No rows found";
        String actualMessage = booksPage.noRowsFound();

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void ClickNextAndPreviousButtons() {
        navigateToUrl("books");

        String booksPerPage = "5 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        boolean isActivePreviousButton = booksPage.checkPreviousButtonIsActive();
        boolean isActiveNextButton = booksPage.checkNextButtonIsActive();

        Assert.assertFalse(isActivePreviousButton);
        Assert.assertTrue(isActiveNextButton);

        booksPage.clickNextButton();

        int expectedBooksCount = 3;
        int actualBooksCount = booksPage.getCountFoundBooks();
        Assert.assertEquals(actualBooksCount, expectedBooksCount);

        isActivePreviousButton = booksPage.checkPreviousButtonIsActive();
        isActiveNextButton = booksPage.checkNextButtonIsActive();

        Assert.assertTrue(isActivePreviousButton);
        Assert.assertFalse(isActiveNextButton);

        booksPage.clickPreviousButton();

        expectedBooksCount = 5;
        actualBooksCount = booksPage.getCountFoundBooks();
        Assert.assertEquals(actualBooksCount, expectedBooksCount);

        Assert.assertTrue(isActivePreviousButton);
        Assert.assertFalse(isActiveNextButton);
    }

    @Test
    public void ClickAllRowsPerPage() {
        navigateToUrl("books");

        String booksPerPage = "5 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        int expectedBooksCount = 5;
        int actualBooksCount = booksPage.getCountFoundBooks();
        Assert.assertEquals(actualBooksCount, expectedBooksCount);

        boolean isActivePreviousButton = booksPage.checkPreviousButtonIsActive();
        boolean isActiveNextButton = booksPage.checkNextButtonIsActive();
        Assert.assertFalse(isActivePreviousButton);
        Assert.assertTrue(isActiveNextButton);

        booksPerPage = "10 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        expectedBooksCount = 10;
        actualBooksCount = booksPage.getCountOfAllRows();
        Assert.assertEquals(actualBooksCount, expectedBooksCount);

        isActivePreviousButton = booksPage.checkPreviousButtonIsActive();
        isActiveNextButton = booksPage.checkNextButtonIsActive();
        Assert.assertFalse(isActivePreviousButton);
        Assert.assertFalse(isActiveNextButton);

        booksPerPage = "20 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        expectedBooksCount = 20;
        actualBooksCount = booksPage.getCountOfAllRows();
        Assert.assertEquals(actualBooksCount, expectedBooksCount);

        booksPerPage = "25 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        expectedBooksCount = 25;
        actualBooksCount = booksPage.getCountOfAllRows();
        Assert.assertEquals(actualBooksCount, expectedBooksCount);

        booksPerPage = "50 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        expectedBooksCount = 50;
        actualBooksCount = booksPage.getCountOfAllRows();
        Assert.assertEquals(actualBooksCount, expectedBooksCount);

        booksPerPage = "100 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        expectedBooksCount = 100;
        actualBooksCount = booksPage.getCountOfAllRows();
        Assert.assertEquals(actualBooksCount, expectedBooksCount);
    }

    @Test
    public void OrderBooksByTitleByAuthorByPublisherDescending() {
        navigateToUrl("books");

        booksPage.clickTitle();
        booksPage.clickTitle();

        String expectedBooksCount = """
                Understanding ECMAScript 6
                Nicholas C. Zakas
                No Starch Press
                Eloquent JavaScript, Second Edition
                Marijn Haverbeke
                No Starch Press
                Programming JavaScript Applications
                Eric Elliott
                O'Reilly Media
                You Don't Know JS
                Kyle Simpson
                O'Reilly Media
                Speaking JavaScript
                Axel Rauschmayer
                O'Reilly Media
                Designing Evolvable Web APIs with ASP.NET
                Glenn Block et al.
                O'Reilly Media
                Learning JavaScript Design Patterns
                Addy Osmani
                O'Reilly Media
                Git Pocket Guide
                Richard E. Silverman
                O'Reilly Media
                """;
        String actualFindBooks = booksPage.getFoundBooks();

        Assert.assertEquals(actualFindBooks, expectedBooksCount);

        booksPage.clickAuthor();
        booksPage.clickAuthor();

        expectedBooksCount = """
                Git Pocket Guide
                Richard E. Silverman
                O'Reilly Media
                Understanding ECMAScript 6
                Nicholas C. Zakas
                No Starch Press
                Eloquent JavaScript, Second Edition
                Marijn Haverbeke
                No Starch Press
                You Don't Know JS
                Kyle Simpson
                O'Reilly Media
                Designing Evolvable Web APIs with ASP.NET
                Glenn Block et al.
                O'Reilly Media
                Programming JavaScript Applications
                Eric Elliott
                O'Reilly Media
                Speaking JavaScript
                Axel Rauschmayer
                O'Reilly Media
                Learning JavaScript Design Patterns
                Addy Osmani
                O'Reilly Media
                """;
        actualFindBooks = booksPage.getFoundBooks();

        Assert.assertEquals(actualFindBooks, expectedBooksCount);

        booksPage.clickPublisher();
        booksPage.clickPublisher();

        expectedBooksCount = """
                Programming JavaScript Applications
                Eric Elliott
                O'Reilly Media
                You Don't Know JS
                Kyle Simpson
                O'Reilly Media
                Speaking JavaScript
                Axel Rauschmayer
                O'Reilly Media
                Designing Evolvable Web APIs with ASP.NET
                Glenn Block et al.
                O'Reilly Media
                Learning JavaScript Design Patterns
                Addy Osmani
                O'Reilly Media
                Git Pocket Guide
                Richard E. Silverman
                O'Reilly Media
                Understanding ECMAScript 6
                Nicholas C. Zakas
                No Starch Press
                Eloquent JavaScript, Second Edition
                Marijn Haverbeke
                No Starch Press
                """;
        actualFindBooks = booksPage.getFoundBooks();

        Assert.assertEquals(actualFindBooks, expectedBooksCount);
    }

    @Test
    public void OrderBooksByTitleByAuthorByPublisherAscending() {
        navigateToUrl("books");

        booksPage.clickTitle();

        String expectedBooksCount = """
                Git Pocket Guide
                Richard E. Silverman
                O'Reilly Media
                Learning JavaScript Design Patterns
                Addy Osmani
                O'Reilly Media
                Designing Evolvable Web APIs with ASP.NET
                Glenn Block et al.
                O'Reilly Media
                Speaking JavaScript
                Axel Rauschmayer
                O'Reilly Media
                You Don't Know JS
                Kyle Simpson
                O'Reilly Media
                Programming JavaScript Applications
                Eric Elliott
                O'Reilly Media
                Eloquent JavaScript, Second Edition
                Marijn Haverbeke
                No Starch Press
                Understanding ECMAScript 6
                Nicholas C. Zakas
                No Starch Press
                """;
        String actualFindBooks = booksPage.getFoundBooks();

        Assert.assertEquals(actualFindBooks, expectedBooksCount);

        booksPage.clickAuthor();

        expectedBooksCount = """
                Learning JavaScript Design Patterns
                Addy Osmani
                O'Reilly Media
                Speaking JavaScript
                Axel Rauschmayer
                O'Reilly Media
                Programming JavaScript Applications
                Eric Elliott
                O'Reilly Media
                Designing Evolvable Web APIs with ASP.NET
                Glenn Block et al.
                O'Reilly Media
                You Don't Know JS
                Kyle Simpson
                O'Reilly Media
                Eloquent JavaScript, Second Edition
                Marijn Haverbeke
                No Starch Press
                Understanding ECMAScript 6
                Nicholas C. Zakas
                No Starch Press
                Git Pocket Guide
                Richard E. Silverman
                O'Reilly Media
                """;
        actualFindBooks = booksPage.getFoundBooks();

        Assert.assertEquals(actualFindBooks, expectedBooksCount);


        booksPage.clickPublisher();

        expectedBooksCount = """
                Eloquent JavaScript, Second Edition
                Marijn Haverbeke
                No Starch Press
                Understanding ECMAScript 6
                Nicholas C. Zakas
                No Starch Press
                Git Pocket Guide
                Richard E. Silverman
                O'Reilly Media
                Learning JavaScript Design Patterns
                Addy Osmani
                O'Reilly Media
                Designing Evolvable Web APIs with ASP.NET
                Glenn Block et al.
                O'Reilly Media
                Speaking JavaScript
                Axel Rauschmayer
                O'Reilly Media
                You Don't Know JS
                Kyle Simpson
                O'Reilly Media
                Programming JavaScript Applications
                Eric Elliott
                O'Reilly Media
                """;
        actualFindBooks = booksPage.getFoundBooks();

        Assert.assertEquals(actualFindBooks, expectedBooksCount);
    }

    @Test
    public void SearchAndOrderResultAscendingBooks() {
        navigateToUrl("books");

        String searchedBook = "javascript";

        booksPage.searchBooksWithWord(searchedBook);
        String expectedBooksCount = """
                Learning JavaScript Design Patterns
                Addy Osmani
                O'Reilly Media
                Speaking JavaScript
                Axel Rauschmayer
                O'Reilly Media
                Programming JavaScript Applications
                Eric Elliott
                O'Reilly Media
                Eloquent JavaScript, Second Edition
                Marijn Haverbeke
                No Starch Press
                """;
        String actualFindBooks = booksPage.getFoundBooks();

        Assert.assertEquals(actualFindBooks, expectedBooksCount);

        booksPage.clickTitle();

        expectedBooksCount = """
                Learning JavaScript Design Patterns
                Addy Osmani
                O'Reilly Media
                Speaking JavaScript
                Axel Rauschmayer
                O'Reilly Media
                Programming JavaScript Applications
                Eric Elliott
                O'Reilly Media
                Eloquent JavaScript, Second Edition
                Marijn Haverbeke
                No Starch Press
                """;
        actualFindBooks = booksPage.getFoundBooks();

        Assert.assertEquals(actualFindBooks, expectedBooksCount);

        booksPage.clickAuthor();

        expectedBooksCount = """
                Learning JavaScript Design Patterns
                Addy Osmani
                O'Reilly Media
                Speaking JavaScript
                Axel Rauschmayer
                O'Reilly Media
                Programming JavaScript Applications
                Eric Elliott
                O'Reilly Media
                Eloquent JavaScript, Second Edition
                Marijn Haverbeke
                No Starch Press
                """;
        actualFindBooks = booksPage.getFoundBooks();

        Assert.assertEquals(actualFindBooks, expectedBooksCount);

        booksPage.clickPublisher();

        expectedBooksCount = """
                Eloquent JavaScript, Second Edition
                Marijn Haverbeke
                No Starch Press
                Learning JavaScript Design Patterns
                Addy Osmani
                O'Reilly Media
                Speaking JavaScript
                Axel Rauschmayer
                O'Reilly Media
                Programming JavaScript Applications
                Eric Elliott
                O'Reilly Media
                """;
        actualFindBooks = booksPage.getFoundBooks();

        Assert.assertEquals(actualFindBooks, expectedBooksCount);
    }

    @Test
    public void SearchForBookAndOrderResultDescendingBooks() {
        navigateToUrl("books");

        String searchedBook = "javascript";

        booksPage.searchBooksWithWord(searchedBook);
        String expectedBooksCount = """
                Learning JavaScript Design Patterns
                Addy Osmani
                O'Reilly Media
                Speaking JavaScript
                Axel Rauschmayer
                O'Reilly Media
                Programming JavaScript Applications
                Eric Elliott
                O'Reilly Media
                Eloquent JavaScript, Second Edition
                Marijn Haverbeke
                No Starch Press
                """;
        String actualFindBooks = booksPage.getFoundBooks();

        Assert.assertEquals(actualFindBooks, expectedBooksCount);

        booksPage.clickTitle();
        booksPage.clickTitle();

        expectedBooksCount = """
                Eloquent JavaScript, Second Edition
                Marijn Haverbeke
                No Starch Press
                Programming JavaScript Applications
                Eric Elliott
                O'Reilly Media
                Speaking JavaScript
                Axel Rauschmayer
                O'Reilly Media
                Learning JavaScript Design Patterns
                Addy Osmani
                O'Reilly Media
                """;
        actualFindBooks = booksPage.getFoundBooks();

        Assert.assertEquals(actualFindBooks, expectedBooksCount);

        booksPage.clickAuthor();
        booksPage.clickAuthor();

        expectedBooksCount = """
                Eloquent JavaScript, Second Edition
                Marijn Haverbeke
                No Starch Press
                Programming JavaScript Applications
                Eric Elliott
                O'Reilly Media
                Speaking JavaScript
                Axel Rauschmayer
                O'Reilly Media
                Learning JavaScript Design Patterns
                Addy Osmani
                O'Reilly Media
                """;
        actualFindBooks = booksPage.getFoundBooks();

        Assert.assertEquals(actualFindBooks, expectedBooksCount);

        booksPage.clickPublisher();
        booksPage.clickPublisher();

        expectedBooksCount = """
                Programming JavaScript Applications
                Eric Elliott
                O'Reilly Media
                Speaking JavaScript
                Axel Rauschmayer
                O'Reilly Media
                Learning JavaScript Design Patterns
                Addy Osmani
                O'Reilly Media
                Eloquent JavaScript, Second Edition
                Marijn Haverbeke
                No Starch Press
                """;
        actualFindBooks = booksPage.getFoundBooks();

        Assert.assertEquals(actualFindBooks, expectedBooksCount);
    }
}
