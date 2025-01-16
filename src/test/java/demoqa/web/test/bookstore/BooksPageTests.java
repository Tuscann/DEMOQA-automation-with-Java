package demoqa.web.test.bookstore;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BooksPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify show/hide left dropdown menu.")
    public void ClickLeftDropdownMenu() {
        navigateToUrl("books");

        boolean TextBoxIsVisible = booksPage.verifyLoginIsVisible();
        Assert.assertTrue(TextBoxIsVisible, "\nDropDown login in not shown.\n");

        booksPage.clickBookStoreApplicationLink();

        TextBoxIsVisible = booksPage.verifyLoginIsNotVisible();
        Assert.assertFalse(TextBoxIsVisible, "\nDropDown Login in shown.\n");
    }

    @Test(enabled = true, testName = "Click on 4 links on left side")
    public void CheckAllFourPagesLinks() {
        navigateToUrl("books");

        String expectedUrl = "https://demoqa.com/login";
        booksPage.clickLoginLink();
        String actualUrl = booksPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected login url.\n");

        expectedUrl = "https://demoqa.com/books";
        booksPage.clickBookStoreLink();
        actualUrl = booksPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected book store link.\n");

        expectedUrl = "https://demoqa.com/profile";
        booksPage.clickProfileLink();
        actualUrl = booksPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected profile link.\n");

        expectedUrl = "https://demoqa.com/swagger/";
        booksPage.clickBookStoreAPILink();
        actualUrl = booksPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected book store API link.\n");
    }

    @Test(enabled = true, testName = "Verify table header columns.")
    public void GetFirstRowOfTable() {
        navigateToUrl("books");

        String expectedTopRow = """
                Image
                Title
                Author
                Publisher""";

        String actualTopRow = booksPage.getTopRowTable();

        Assert.assertEquals(actualTopRow, expectedTopRow, "\nExpected table header.\n");
    }

    @Test(enabled = true, testName = "Verify default count of books 8.")
    public void VerifyCountOfDefaultBooks() {
        navigateToUrl("books");

        int expectedBooksCount = 8;

        int actualBooksCount = booksPage.getCountFoundBooks();

        Assert.assertEquals(actualBooksCount, expectedBooksCount, "\nExpected books count.\n");
    }

    @Test(enabled = true, testName = "Click login button and verify link.")
    public void ClickLoginButton() {
        navigateToUrl("books");

        booksPage.clickLoginButton();

        String expectedUrl = "https://demoqa.com/login";
        String actualUrl = booksPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\n Expected url to be login \n");
    }

    @Test(enabled = true, testName = "Search for book and verify book")
    public void SearchAndFindOneBook() {
        navigateToUrl("books");

        String searchedBook = "Understanding ECMAScript 6";

        booksPage.searchBooksWithWord(searchedBook);
        String expectedBooks = """
                Understanding ECMAScript 6
                Nicholas C. Zakas
                No Starch Press""";
        String actualFindBooks = booksPage.getAllFoundBooks();

        Assert.assertEquals(actualFindBooks, expectedBooks, "\nExpected not books found.\n");
    }

    @Test(enabled = true, testName = "Search for book and verify no books are found.")
    public void SearchAndFindNoBook() {
        navigateToUrl("books");

        String searchedBook = "Zhivko";

        booksPage.searchBooksWithWord(searchedBook);
        String expectedMessage = "No rows found";
        String actualMessage = booksPage.noRowsFound();

        Assert.assertEquals(actualMessage, expectedMessage, "\nExpected message not found.\n");
    }

    @Test(enabled = true, testName = "Verify Next and Previous buttons can clickable.")
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
        Assert.assertEquals(actualBooksCount, expectedBooksCount, "\nFound not 3 books.\n");

        isActivePreviousButton = booksPage.checkPreviousButtonIsActive();
        isActiveNextButton = booksPage.checkNextButtonIsActive();

        Assert.assertTrue(isActivePreviousButton);
        Assert.assertFalse(isActiveNextButton);

        booksPage.clickPreviousButton();

        expectedBooksCount = 5;
        actualBooksCount = booksPage.getCountFoundBooks();
        Assert.assertEquals(actualBooksCount, expectedBooksCount, "\nFound not 5 books.\n");

        isActivePreviousButton = booksPage.checkPreviousButtonIsActive();
        isActiveNextButton = booksPage.checkNextButtonIsActive();

        Assert.assertFalse(isActivePreviousButton);
        Assert.assertTrue(isActiveNextButton);
    }

    @Test(enabled = true, testName = "Click all rows per page.")
    public void ClickAllRowsPerPage() {
        navigateToUrl("books");

        String booksPerPage = "5 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        int expectedBooksCount = 5;
        int actualBooksCount = booksPage.getCountFoundBooks();
        Assert.assertEquals(actualBooksCount, expectedBooksCount, "\nCount is not 5 times.\n");

        boolean isActivePreviousButton = booksPage.checkPreviousButtonIsActive();
        boolean isActiveNextButton = booksPage.checkNextButtonIsActive();
        Assert.assertFalse(isActivePreviousButton);
        Assert.assertTrue(isActiveNextButton);

        booksPerPage = "10 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        expectedBooksCount = 10;
        actualBooksCount = booksPage.getCountOfAllRows();
        Assert.assertEquals(actualBooksCount, expectedBooksCount, "\nCount is not 10 times.\n");

        isActivePreviousButton = booksPage.checkPreviousButtonIsActive();
        isActiveNextButton = booksPage.checkNextButtonIsActive();
        Assert.assertFalse(isActivePreviousButton);
        Assert.assertFalse(isActiveNextButton);

        booksPerPage = "20 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        expectedBooksCount = 20;
        actualBooksCount = booksPage.getCountOfAllRows();
        Assert.assertEquals(actualBooksCount, expectedBooksCount, "\nCount is not 20 times.\n");

        booksPerPage = "25 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        expectedBooksCount = 25;
        actualBooksCount = booksPage.getCountOfAllRows();
        Assert.assertEquals(actualBooksCount, expectedBooksCount, "\nCount is not 25 times.\n");

        booksPerPage = "50 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        expectedBooksCount = 50;
        actualBooksCount = booksPage.getCountOfAllRows();
        Assert.assertEquals(actualBooksCount, expectedBooksCount, "\nCount is not 50 times.\n");

        booksPerPage = "100 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        expectedBooksCount = 100;
        actualBooksCount = booksPage.getCountOfAllRows();
        Assert.assertEquals(actualBooksCount, expectedBooksCount, "\nCount is not 100 times.\n");
    }

    @Test(enabled = true, testName = "Order books by Title,Author,Publisher in descending order.")
    public void OrderBooksByTitleByAuthorByPublisherDescending() {
        navigateToUrl("books");

        booksPage.clickTitle();
        booksPage.clickTitle();

        String expectedBooks = """
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

        Assert.assertEquals(actualFindBooks, expectedBooks, "\nExpected books.\n");

        booksPage.clickAuthor();
        booksPage.clickAuthor();

        expectedBooks = """
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

        Assert.assertEquals(actualFindBooks, expectedBooks, "\nExpected books.\n");

        booksPage.clickPublisher();
        booksPage.clickPublisher();

        expectedBooks = """
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

        Assert.assertEquals(actualFindBooks, expectedBooks, "\nExpected books.\n");
    }

    @Test(enabled = true, testName = "Order books by Title,Author,Publisher in ascending order.")
    public void OrderBooksByTitleByAuthorByPublisherAscending() {
        navigateToUrl("books");

        booksPage.clickTitle();

        String expectedBooks = """
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

        Assert.assertEquals(actualFindBooks, expectedBooks, "\nExpected books.\n");

        booksPage.clickAuthor();

        expectedBooks = """
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

        Assert.assertEquals(actualFindBooks, expectedBooks, "\nExpected books.\n");

        booksPage.clickPublisher();

        expectedBooks = """
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

        Assert.assertEquals(actualFindBooks, expectedBooks, "\nExpected books.\n");
    }

    @Test(enabled = true)
    public void SearchAndOrderResultAscendingBooks() {
        navigateToUrl("books");

        String searchedBook = "javascript";

        booksPage.searchBooksWithWord(searchedBook);
        String expectedBooks = """
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

        Assert.assertEquals(actualFindBooks, expectedBooks, "\nWrong found books.\n");

        booksPage.clickTitle();

        expectedBooks = """
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

        Assert.assertEquals(actualFindBooks, expectedBooks, "\nWrong found books.\n");

        booksPage.clickAuthor();

        expectedBooks = """
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

        Assert.assertEquals(actualFindBooks, expectedBooks, "\nWrong found books.\n");

        booksPage.clickPublisher();

        expectedBooks = """
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

        Assert.assertEquals(actualFindBooks, expectedBooks, "\nWrong found books.\n");
    }

    @Test(enabled = true)
    public void SearchForBookAndOrderResultDescendingBooks() {
        navigateToUrl("books");

        String searchedBook = "javascript";

        booksPage.searchBooksWithWord(searchedBook);
        String expectedBooks = """
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
        Assert.assertEquals(actualFindBooks, expectedBooks, "\nWrong found books.\n");

        booksPage.clickTitle();
        booksPage.clickTitle();

        expectedBooks = """
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
        Assert.assertEquals(actualFindBooks, expectedBooks, "\nWrong found books.\n");

        booksPage.clickAuthor();
        booksPage.clickAuthor();

        expectedBooks = """
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
        Assert.assertEquals(actualFindBooks, expectedBooks, "\nWrong found books.\n");

        booksPage.clickPublisher();
        booksPage.clickPublisher();

        expectedBooks = """
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
        Assert.assertEquals(actualFindBooks, expectedBooks, "\nWrong found books.\n");
    }
}
