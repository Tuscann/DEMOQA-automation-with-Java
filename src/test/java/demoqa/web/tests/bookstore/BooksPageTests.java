package demoqa.web.tests.bookstore;

import demoqa.pages.bookstore.BooksPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.Test;

public class BooksPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify show/hide left dropdown menu")
    public void ClickLeftDropdownMenu() {
        // Arrange
        navigateToUrl("books");
        BooksPage booksPage = new BooksPage(driver);

        // Act
        boolean TextBoxIsVisible = booksPage.verifyLoginIsVisible();
        booksPage.clickBookStoreApplicationLink();
        boolean TextBoxIsVisible2 = booksPage.verifyLoginIsNotVisible();

        // Assert
        softAssert.assertTrue(TextBoxIsVisible, "\nDropDown Login in not shown.\n");
        softAssert.assertFalse(TextBoxIsVisible2, "\nDropDown Login in shown.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on 4 links on left side")
    public void CheckAllFourPagesLinks() {
        // Arrange
        navigateToUrl("books");
        BooksPage booksPage = new BooksPage(driver);

        String expectedLoginUrl = "https://demoqa.com/login";
        String expectedBooksUrl = "https://demoqa.com/books";
        String expectedProfileUrl = "https://demoqa.com/profile";
        String expectedSwaggerUrl = "https://demoqa.com/swagger/";

        // Act
        booksPage.clickLoginLink();
        String actualLoginUrl = booksPage.checkUrl();

        booksPage.clickBookStoreLink();
        String actualBooksUrl = booksPage.checkUrl();

        booksPage.clickProfileLink();
        String actualProfileUrl = booksPage.checkUrl();

        booksPage.clickBookStoreAPILink();
        String actualSwaggerUrl = booksPage.checkUrl();

        // Assert
        softAssert.assertEquals(actualLoginUrl, expectedLoginUrl, "\nExpected login url.\n");
        softAssert.assertEquals(actualBooksUrl, expectedBooksUrl, "\nExpected book store link.\n");
        softAssert.assertEquals(actualProfileUrl, expectedProfileUrl, "\nExpected profile link.\n");
        softAssert.assertEquals(actualSwaggerUrl, expectedSwaggerUrl, "\nExpected book store API link.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify table header columns")
    public void GetFirstRowOfTable() {
        // Arrange
        navigateToUrl("books");
        BooksPage booksPage = new BooksPage(driver);
        String expectedTopRow = """
                Image
                Title
                Author
                Publisher""";

        // Act
        String actualTopRow = booksPage.getTopRowTable();

        // Assert
        softAssert.assertEquals(actualTopRow, expectedTopRow, "\nExpected table header.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify default count of books 8")
    public void VerifyCountOfDefaultBooks() {
        // Arrange
        navigateToUrl("books");
        BooksPage booksPage = new BooksPage(driver);
        int expectedBooksCount = 8;

        // Act
        int actualBooksCount = booksPage.getCountFoundBooks();

        // Assert
        softAssert.assertEquals(actualBooksCount, expectedBooksCount, "\nExpected books count.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click login button and verify link")
    public void ClickLoginButton() {
        // Arrange
        navigateToUrl("books");
        BooksPage booksPage = new BooksPage(driver);
        String expectedUrl = "https://demoqa.com/login";

        // Act
        booksPage.clickLoginButton();
        String actualUrl = booksPage.checkUrl();

        // Assert
        softAssert.assertEquals(actualUrl, expectedUrl, "\n Expected url to be login \n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Search for book and verify found book")
    public void SearchAndFindOneBook() {
        // Arrange
        navigateToUrl("books");
        BooksPage booksPage = new BooksPage(driver);
        String searchedBook = "Understanding ECMAScript 6";
        String expectedBooks = """
                Understanding ECMAScript 6
                Nicholas C. Zakas
                No Starch Press""";

        // Act
        booksPage.searchBooksWithWord(searchedBook);
        String actualFindBooks = booksPage.getAllFoundBooks();

        // Assert
        softAssert.assertEquals(actualFindBooks, expectedBooks, "\nExpected not books found.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Search for book and verify no books are found")
    public void SearchAndFindNoBook() {
        // Arrange
        navigateToUrl("books");
        BooksPage booksPage = new BooksPage(driver);
        String searchedBook = "Zhivko";
        String expectedMessage = "No rows found";

        // Act
        booksPage.searchBooksWithWord(searchedBook);
        String actualMessage = booksPage.noRowsFound();

        // Assert
        softAssert.assertEquals(actualMessage, expectedMessage, "\nExpected message not found.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify next and previous buttons can clickable")
    public void ClickNextAndPreviousButtons() {
        // Arrange
        navigateToUrl("books");
        BooksPage booksPage = new BooksPage(driver);

        String booksPerPage = "5 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        boolean isActivePreviousButton = booksPage.checkPreviousButtonIsActive();
        boolean isActiveNextButton = booksPage.checkNextButtonIsActive();

        softAssert.assertFalse(isActivePreviousButton);
        softAssert.assertTrue(isActiveNextButton);

        booksPage.clickNextButton();

        int expectedBooksCount = 3;
        int actualBooksCount = booksPage.getCountFoundBooks();
        softAssert.assertEquals(actualBooksCount, expectedBooksCount, "\nFound not 3 books.\n");

        isActivePreviousButton = booksPage.checkPreviousButtonIsActive();
        isActiveNextButton = booksPage.checkNextButtonIsActive();

        softAssert.assertTrue(isActivePreviousButton);
        softAssert.assertFalse(isActiveNextButton);

        booksPage.clickPreviousButton();

        expectedBooksCount = 5;
        actualBooksCount = booksPage.getCountFoundBooks();
        softAssert.assertEquals(actualBooksCount, expectedBooksCount, "\nFound not 5 books.\n");

        isActivePreviousButton = booksPage.checkPreviousButtonIsActive();
        isActiveNextButton = booksPage.checkNextButtonIsActive();

        // Assert
        softAssert.assertFalse(isActivePreviousButton);
        softAssert.assertTrue(isActiveNextButton);
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click all rows per page")
    public void ClickAllRowsPerPage() {
        // Arrange
        navigateToUrl("books");
        BooksPage booksPage = new BooksPage(driver);

        String booksPerPage = "5 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        int expectedBooksCount = 5;
        int actualBooksCount = booksPage.getCountFoundBooks();
        softAssert.assertEquals(actualBooksCount, expectedBooksCount, "\nCount is not 5 times.\n");

        boolean isActivePreviousButton = booksPage.checkPreviousButtonIsActive();
        boolean isActiveNextButton = booksPage.checkNextButtonIsActive();
        softAssert.assertFalse(isActivePreviousButton);
        softAssert.assertTrue(isActiveNextButton);

        booksPerPage = "10 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        expectedBooksCount = 10;
        actualBooksCount = booksPage.getCountOfAllRows();
        softAssert.assertEquals(actualBooksCount, expectedBooksCount, "\nCount is not 10 times.\n");

        isActivePreviousButton = booksPage.checkPreviousButtonIsActive();
        isActiveNextButton = booksPage.checkNextButtonIsActive();
        softAssert.assertFalse(isActivePreviousButton);
        softAssert.assertFalse(isActiveNextButton);

        booksPerPage = "20 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        expectedBooksCount = 20;
        actualBooksCount = booksPage.getCountOfAllRows();
        softAssert.assertEquals(actualBooksCount, expectedBooksCount, "\nCount is not 20 times.\n");

        booksPerPage = "25 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        expectedBooksCount = 25;
        actualBooksCount = booksPage.getCountOfAllRows();
        softAssert.assertEquals(actualBooksCount, expectedBooksCount, "\nCount is not 25 times.\n");

        booksPerPage = "50 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        expectedBooksCount = 50;
        actualBooksCount = booksPage.getCountOfAllRows();
        softAssert.assertEquals(actualBooksCount, expectedBooksCount, "\nCount is not 50 times.\n");

        booksPerPage = "100 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        expectedBooksCount = 100;
        actualBooksCount = booksPage.getCountOfAllRows();

        // Assert
        softAssert.assertEquals(actualBooksCount, expectedBooksCount, "\nCount is not 100 times.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Order books by title,author,publisher in descending order")
    public void OrderBooksByTitleByAuthorByPublisherDescending() {
        // Arrange
        navigateToUrl("books");
        BooksPage booksPage = new BooksPage(driver);

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

        booksPage.clickTitle();
        booksPage.clickTitle();

        String actualFindBooks = booksPage.getFoundBooks();

        softAssert.assertEquals(actualFindBooks, expectedBooks, "\nExpected books.\n");

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

        softAssert.assertEquals(actualFindBooks, expectedBooks, "\nExpected books.\n");

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

        // Assert
        softAssert.assertEquals(actualFindBooks, expectedBooks, "\nExpected books.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Order books by title,author,publisher in ascending order")
    public void OrderBooksByTitleByAuthorByPublisherAscending() {
        // Arrange
        navigateToUrl("books");
        BooksPage booksPage = new BooksPage(driver);

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

        softAssert.assertEquals(actualFindBooks, expectedBooks, "\nExpected books.\n");

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

        softAssert.assertEquals(actualFindBooks, expectedBooks, "\nExpected books.\n");

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

        // Assert
        softAssert.assertEquals(actualFindBooks, expectedBooks, "\nExpected books.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Search and order result in ascending order books")
    public void SearchAndOrderResultAscendingBooks() {
        // Arrange
        navigateToUrl("books");
        BooksPage booksPage = new BooksPage(driver);

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

        softAssert.assertEquals(actualFindBooks, expectedBooks, "\nWrong found books.\n");

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

        softAssert.assertEquals(actualFindBooks, expectedBooks, "\nWrong found books.\n");

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

        softAssert.assertEquals(actualFindBooks, expectedBooks, "\nWrong found books.\n");

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

        // Assert
        softAssert.assertEquals(actualFindBooks, expectedBooks, "\nWrong found books.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Search for book and order result in descending books")
    public void SearchForBookAndOrderResultDescendingBooks() {
        // Arrange
        navigateToUrl("books");
        BooksPage booksPage = new BooksPage(driver);

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
        softAssert.assertEquals(actualFindBooks, expectedBooks, "\nWrong found books.\n");

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
        softAssert.assertEquals(actualFindBooks, expectedBooks, "\nWrong found books.\n");

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
        softAssert.assertEquals(actualFindBooks, expectedBooks, "\nWrong found books.\n");

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

        // Assert
        softAssert.assertEquals(actualFindBooks, expectedBooks, "\nWrong found books.\n");
        softAssert.assertAll();
    }
}
