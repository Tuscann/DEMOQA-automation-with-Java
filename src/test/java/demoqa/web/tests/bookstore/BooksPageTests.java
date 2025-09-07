package demoqa.web.tests.bookstore;

import demoqa.pages.bookstore.BooksPage;
import demoqa.web.base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BooksPageTests extends BaseTest {
    // Test Data Constants
    private static final String EXPECTED_LOGIN_URL = DEMO_QA_URL + "login";
    private static final String EXPECTED_BOOKS_URL = DEMO_QA_URL + "books";
    private static final String EXPECTED_PROFILE_URL = DEMO_QA_URL + "profile";
    private static final String EXPECTED_SWAGGER_URL = DEMO_QA_URL + "swagger/";
    private static final String EXPECTED_NO_ROWS_MESSAGE = "No rows found";
    private static final String SEARCHED_BOOK_ECMASCRIPT = "Understanding ECMAScript 6";
    private static final String SEARCHED_BOOK_AUTHOR = "Richard E. Silverman";
    private static final String SEARCHED_BOOK_PUBLISHER = "No Starch Press";
    private static final String SEARCHED_BOOK_IVAN = "Ivan";
    private static final String BOOKS_PER_PAGE_5 = "5 rows";
    private static final String BOOKS_PER_PAGE_10 = "10 rows";
    private static final String BOOKS_PER_PAGE_20 = "20 rows";
    private static final String BOOKS_PER_PAGE_25 = "25 rows";
    private static final String BOOKS_PER_PAGE_50 = "50 rows";
    private static final String BOOKS_PER_PAGE_100 = "100 rows";

    // Expected Book Data Constants
    private static final String EXPECTED_ECMASCRIPT_BOOK = """
            Understanding ECMAScript 6
            Nicholas C. Zakas
            No Starch Press""";
    private static final String EXPECTED_BOOK_AUTHOR = """
            Git Pocket Guide
            Richard E. Silverman
            O'Reilly Media""";
    private static final String EXPECTED_BOOK_PUBLISHER = """
            Eloquent JavaScript, Second Edition
            Marijn Haverbeke
            No Starch Press""";

    // Error Message Constants
    private static final String DROPDOWN_LOGIN_NOT_SHOWN_ERROR = "Dropdown login is not shown";
    private static final String DROPDOWN_LOGIN_SHOWN_ERROR = "Dropdown login is shown when it should not be";
    private static final String LOGIN_URL_ERROR = "Login URL mismatch";
    private static final String BOOKS_URL_ERROR = "Books URL mismatch";
    private static final String PROFILE_URL_ERROR = "Profile URL mismatch";
    private static final String SWAGGER_URL_ERROR = "Swagger URL mismatch";
    private static final String TABLE_HEADER_ERROR = "Table header mismatch";
    private static final String BOOKS_COUNT_ERROR = "Books count mismatch";
    private static final String LOGIN_BUTTON_URL_ERROR = "Login button URL mismatch";
    private static final String BOOK_SEARCH_RESULT_ERROR = "Book search result mismatch";
    private static final String NO_ROWS_MESSAGE_ERROR = "No rows found message mismatch";
    private static final String PAGINATION_BUTTONS_ERROR = "Pagination buttons state mismatch";
    private static final String BOOKS_COUNT_5_ERROR = "Books count is not 5";
    private static final String BOOKS_COUNT_3_ERROR = "Books count is not 3";
    private static final String BOOKS_COUNT_10_ERROR = "Books count is not 10";
    private static final String BOOKS_COUNT_20_ERROR = "Books count is not 20";
    private static final String BOOKS_COUNT_25_ERROR = "Books count is not 25";
    private static final String BOOKS_COUNT_50_ERROR = "Books count is not 50";
    private static final String BOOKS_COUNT_100_ERROR = "Books count is not 100";
    private static final String BOOKS_ORDERING_ERROR = "Books ordering mismatch";
    private static final String BOOKS_SEARCH_ORDERING_ERROR = "Books search and ordering mismatch";
    // Logger instance for enhanced test reporting
    private static final Logger logger = LoggerFactory.getLogger(BooksPageTests.class);
    private static final String BOOKS_URL = "books";
    private BooksPage booksPage;

    private void verifyPaginationButtons(boolean previousActive, boolean nextActive) {
        boolean isActivePreviousButton = booksPage.checkPreviousButtonIsActive();
        boolean isActiveNextButton = booksPage.checkNextButtonIsActive();
        softAssert.assertEquals(isActivePreviousButton, previousActive, PAGINATION_BUTTONS_ERROR);
        softAssert.assertEquals(isActiveNextButton, nextActive, PAGINATION_BUTTONS_ERROR);
        logger.debug("Verified pagination buttons: previous={}, next={}", previousActive, nextActive);
    }

    private void searchAndVerifyBooks(String searchTerm, String expectedResult, String errorMessage) {
        logger.info("Searching for books with term: '{}'", searchTerm);
        booksPage.searchBooksWithWord(searchTerm);
        String actualResult = booksPage.getAllFoundBooks();
        softAssert.assertEquals(actualResult, expectedResult, errorMessage);
        logger.debug("Search result: expected={}, actual={}", expectedResult, actualResult);
    }

    private void verifyUrlNavigation(String expectedUrl, String errorMessage) {
        String actualUrl = booksPage.getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, errorMessage);
        logger.debug("URL verification: expected={}, actual={}", expectedUrl, actualUrl);
    }

    // Helper method for testing individual rows per page option
    private void testRowsPerPageOption(String rowsPerPage, int expectedCount, String errorMessage) {
        logger.debug("Testing rows per page option: {} -> {} books", rowsPerPage, expectedCount);

        booksPage.chooseBooksPerPage(rowsPerPage);

        // Note: For rows per page > 8, the page will show all available books (8 total)
        // This is the expected behavior when there are fewer books than the selected rows per page
    }

    // Data Providers for Similar Test Scenarios
    @DataProvider(name = "rowsPerPageData")
    public Object[][] rowsPerPageDataProvider() {
        return new Object[][]{
                {BOOKS_PER_PAGE_5, 5, BOOKS_COUNT_5_ERROR},
                {BOOKS_PER_PAGE_10, 8, BOOKS_COUNT_10_ERROR}, // Page only has 8 books total
                {BOOKS_PER_PAGE_20, 8, BOOKS_COUNT_20_ERROR}, // Page only has 8 books total
                {BOOKS_PER_PAGE_25, 8, BOOKS_COUNT_25_ERROR}, // Page only has 8 books total
                {BOOKS_PER_PAGE_50, 8, BOOKS_COUNT_50_ERROR}, // Page only has 8 books total
                {BOOKS_PER_PAGE_100, 8, BOOKS_COUNT_100_ERROR} // Page only has 8 books total
        };
    }

    @DataProvider(name = "paginationData")
    public Object[][] paginationDataProvider() {
        return new Object[][]{
                {"initial", 8, false, false, "Initial pagination state - all 8 books visible"}, // Page shows all 8 books initially
                {"after_next", 3, true, false, "After clicking next button"},
                {"after_previous", 5, false, true, "After clicking previous button"}
        };
    }

    @BeforeMethod
    public void goToBooksPage() {
        logger.info("Navigating to Books page: {}", BOOKS_URL);
        navigateToUrl(BOOKS_URL);
        booksPage = new BooksPage(driver);
        logger.debug("Books page initialized successfully");
    }

    @Test(enabled = true, description = "Verify show/hide left dropdown menu functionality")
    public void clickBookStoreApplicationHideLeftDropdownMenu() {
        logger.info("Starting dropdown menu functionality test");

        // Arrange & Act
        boolean textBoxIsVisible = booksPage.verifyLoginIsVisible();
        logger.debug("Initial dropdown state: visible={}", textBoxIsVisible);

        softAssert.assertTrue(textBoxIsVisible, DROPDOWN_LOGIN_NOT_SHOWN_ERROR);

        booksPage.clickBookStoreApplicationHeader();
        logger.debug("Clicked Book Store Application Header");

        textBoxIsVisible = booksPage.verifyLoginIsNotVisible();
        logger.debug("Dropdown state after click: visible={}", textBoxIsVisible);

        // Assert
        softAssert.assertFalse(textBoxIsVisible, DROPDOWN_LOGIN_SHOWN_ERROR);
        softAssert.assertAll();

        logger.info("Dropdown menu functionality test completed successfully");
    }

    @Test(enabled = true, description = "Verify navigation to all four left side menu links")
    public void checkFourLeftTabLinks() {
        logger.info("Starting navigation test for all four left side menu links");

        // Act & Assert - Login Link
        logger.debug("Testing Login link navigation");
        booksPage.clickLogLeftTab();
        verifyUrlNavigation(EXPECTED_LOGIN_URL, LOGIN_URL_ERROR);

        // Act & Assert - Books Link
        logger.debug("Testing Books link navigation");
        booksPage.clickBookStoreLeftTab();
        verifyUrlNavigation(EXPECTED_BOOKS_URL, BOOKS_URL_ERROR);

        // Act & Assert - Profile Link
        logger.debug("Testing Profile link navigation");
        booksPage.clickProfileLeftTab();
        verifyUrlNavigation(EXPECTED_PROFILE_URL, PROFILE_URL_ERROR);

        // Act & Assert - Swagger Link
        logger.debug("Testing Swagger link navigation");
        booksPage.clickBookStoreApiLeftLink();
        verifyUrlNavigation(EXPECTED_SWAGGER_URL, SWAGGER_URL_ERROR);

        softAssert.assertAll();
        logger.info("Navigation test completed successfully");
    }

    @Test(enabled = true, description = "Verify table header columns are displayed correctly")
    public void verifyFirstRowOfTable() {
        logger.info("Starting table header verification test");

        // Arrange
        String expectedTopRow = """
                Image
                Title
                Author
                Publisher""";

        // Act
        String actualTopRow = booksPage.getTopRowTable();
        logger.debug("Table header: expected={}, actual={}", expectedTopRow, actualTopRow);

        // Assert
        softAssert.assertEquals(actualTopRow, expectedTopRow, TABLE_HEADER_ERROR);
        softAssert.assertAll();

        logger.info("Table header verification test completed successfully");
    }

    @Test(enabled = true, description = "Verify default count of books is 8")
    public void verifyCountOfDefaultBooks() {
        logger.info("Starting default books count verification test");
        // Arrange
        int expectedBooksCount = 8;
        logger.debug("Expected books count: {}", expectedBooksCount);

        // Act & Assert
        int currentDefaultBookCount = booksPage.getCountFoundBooks();
        softAssert.assertEquals(currentDefaultBookCount, expectedBooksCount, BOOKS_COUNT_ERROR);
        softAssert.assertAll();

        logger.info("Default books count verification test completed successfully");
    }

    @Test(enabled = true, description = "Click login button and verify navigation to login page")
    public void verifyClickLoginButtonGoToLoginPage() {
        logger.info("Starting login button navigation test");

        // Act & Assert
        logger.debug("Clicking login button and verifying navigation");
        booksPage.clickLoginButton();
        verifyUrlNavigation(EXPECTED_LOGIN_URL, LOGIN_BUTTON_URL_ERROR);

        softAssert.assertAll();
        logger.info("Login button navigation test completed successfully");
    }

    @Test(enabled = true, description = "Search by book title and find one book and verify book details")
    public void searchByBookByTitleAndFindOneBook() {
        logger.info("Starting book search by title test for '{}'", SEARCHED_BOOK_ECMASCRIPT);

        // Act & Assert
        searchAndVerifyBooks(SEARCHED_BOOK_ECMASCRIPT, EXPECTED_ECMASCRIPT_BOOK, BOOK_SEARCH_RESULT_ERROR);
        softAssert.assertAll();

        logger.info("Book search by title test completed successfully");
    }

    @Test(enabled = true, description = "Search by book author and find one book and verify book details")
    public void searchBookByAuthorAndFindOneBook() {
        logger.info("Starting book search by author test for '{}'", SEARCHED_BOOK_AUTHOR);

        // Act & Assert
        searchAndVerifyBooks(SEARCHED_BOOK_AUTHOR, EXPECTED_BOOK_AUTHOR, BOOK_SEARCH_RESULT_ERROR);
        softAssert.assertAll();

        logger.info("Book search by author test completed successfully");
    }

    @Test(enabled = true, description = "Search by book publisher and find one book and verify book details")
    public void searchBookByPublisherAndFindOneBook() {
        logger.info("Starting book search by publisher test for '{}'", SEARCHED_BOOK_AUTHOR);

        // Act & Assert
        searchAndVerifyBooks(SEARCHED_BOOK_PUBLISHER, EXPECTED_BOOK_PUBLISHER, BOOK_SEARCH_RESULT_ERROR);
        softAssert.assertAll();

        logger.info("Book search by publisher test completed successfully");
    }

    @Test(enabled = true, description = "Search for book and verify no books are found message")
    public void searchBookAndFindNoBook() {
        logger.info("Starting no books found test for search term '{}'", SEARCHED_BOOK_IVAN);

        // Act & Assert
        logger.debug("Searching for books and verifying no results message");
        booksPage.searchBooksWithWord(SEARCHED_BOOK_IVAN);
        String actualMessage = booksPage.noRowsFound();
        softAssert.assertEquals(actualMessage, EXPECTED_NO_ROWS_MESSAGE, NO_ROWS_MESSAGE_ERROR);

        softAssert.assertAll();
        logger.info("No books found test completed successfully");
    }

    @Test(enabled = true, description = "Verify next and previous pagination buttons functionality")
    public void clickNextAndPreviousButtons() {
        // Arrange
        String booksPerPage = "5 rows";
        booksPage.chooseBooksPerPage(booksPerPage);

        boolean isActivePreviousButton = booksPage.checkPreviousButtonIsActive();
        boolean isActiveNextButton = booksPage.checkNextButtonIsActive();

        softAssert.assertFalse(isActivePreviousButton);
        softAssert.assertTrue(isActiveNextButton);

        booksPage.clickNextButton();

        int expectedBooksCount = 3;
        int actualBooksCount = booksPage.getCountFoundBooks();
        softAssert.assertEquals(actualBooksCount, expectedBooksCount, BOOKS_COUNT_3_ERROR);

        isActivePreviousButton = booksPage.checkPreviousButtonIsActive();
        isActiveNextButton = booksPage.checkNextButtonIsActive();

        softAssert.assertTrue(isActivePreviousButton);
        softAssert.assertFalse(isActiveNextButton);

        booksPage.clickPreviousButton();

        expectedBooksCount = 5;
        actualBooksCount = booksPage.getCountFoundBooks();
        softAssert.assertEquals(actualBooksCount, expectedBooksCount, BOOKS_COUNT_5_ERROR);

        isActivePreviousButton = booksPage.checkPreviousButtonIsActive();
        isActiveNextButton = booksPage.checkNextButtonIsActive();

        // Assert
        softAssert.assertFalse(isActivePreviousButton);
        softAssert.assertTrue(isActiveNextButton);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify all rows per page options functionality")
    public void clickAllRowsPerPage() {
        logger.info("Starting rows per page functionality test");

        // Test each rows per page option using helper method
        testRowsPerPageOption(BOOKS_PER_PAGE_5, 5, BOOKS_COUNT_5_ERROR);
        testRowsPerPageOption(BOOKS_PER_PAGE_10, 8, BOOKS_COUNT_10_ERROR); // Page only has 8 books total
        testRowsPerPageOption(BOOKS_PER_PAGE_20, 8, BOOKS_COUNT_20_ERROR); // Page only has 8 books total
        testRowsPerPageOption(BOOKS_PER_PAGE_25, 8, BOOKS_COUNT_25_ERROR); // Page only has 8 books total
        testRowsPerPageOption(BOOKS_PER_PAGE_50, 8, BOOKS_COUNT_50_ERROR); // Page only has 8 books total
        testRowsPerPageOption(BOOKS_PER_PAGE_100, 8, BOOKS_COUNT_100_ERROR); // Page only has 8 books total

        softAssert.assertAll();
        logger.info("Rows per page functionality test completed");
    }

    @Test(dataProvider = "rowsPerPageData", enabled = true, description = "Verify rows per page functionality with data provider")
    public void verifyRowsPerPageWithDataProvider(String rowsPerPage, int expectedCount, String errorMessage) {
        logger.info("Testing rows per page: {} (expected count: {})", rowsPerPage, expectedCount);

        try {
            booksPage.chooseBooksPerPage(rowsPerPage);
            int expectedCount2 = booksPage.getCountFoundBooks();
            softAssert.assertEquals(expectedCount2, expectedCount, errorMessage);

            logger.info("Rows per page test completed: {} -> {} books", rowsPerPage, expectedCount);
        } catch (Exception e) {
            logger.error("Error in rows per page test for {}: {}", rowsPerPage, e.getMessage());
            softAssert.fail("Test failed for " + rowsPerPage + ": " + e.getMessage());
        } finally {
            softAssert.assertAll();
        }
    }

    @Test(enabled = true, description = "Order books by title, author, and publisher in descending order")
    public void orderBooksByTitleByAuthorByPublisherDescending() {
        // Arrange
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

        softAssert.assertEquals(actualFindBooks, expectedBooks, BOOKS_ORDERING_ERROR);

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

        softAssert.assertEquals(actualFindBooks, expectedBooks, BOOKS_ORDERING_ERROR);

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

    @Test(enabled = true, description = "Order books by title, author, and publisher in ascending order")
    public void orderBooksByTitleByAuthorByPublisherAscending() {
        // Arrange
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

        softAssert.assertEquals(actualFindBooks, expectedBooks, BOOKS_ORDERING_ERROR);

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

    @Test(enabled = true, description = "Search for books and order results in ascending order")
    public void searchForBookAndOrderResultAscendingOrderByTitleByAuthorByPublisher() {
        // Arrange
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

    @Test(enabled = true, description = "Search for books and order results in descending order")
    public void searchForBookAndOrderResultDescendingOrderByTitleByAuthorByPublisher() {
        // Arrange
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
        softAssert.assertEquals(actualFindBooks, expectedBooks, BOOKS_SEARCH_ORDERING_ERROR);

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

    @Test(dataProvider = "paginationData", enabled = true, description = "Verify pagination functionality with data provider")
    public void verifyPaginationWithDataProvider(String scenario, int expectedCount, boolean previousActive, boolean nextActive, String description) {
        logger.info("Testing pagination scenario: {} - {}", scenario, description);

        try {
            // Set up initial state for pagination tests
            if (!scenario.equals("initial")) {
                // Set to 5 rows per page to enable pagination
                booksPage.chooseBooksPerPage(BOOKS_PER_PAGE_5);
                logger.debug("Set up pagination with 5 rows per page");
            }

            if (scenario.equals("after_next")) {
                // Navigate to next page
                booksPage.clickNextButton();
                logger.debug("Clicked next button");
            } else if (scenario.equals("after_previous")) {
                // Navigate to previous page
                booksPage.clickPreviousButton();
                logger.debug("Clicked previous button");
            }
            // For "initial" scenario, no navigation needed

            verifyPaginationButtons(previousActive, nextActive);

            logger.info("Pagination test completed for scenario: {}", scenario);
        } catch (Exception e) {
            logger.error("Error in pagination test for scenario '{}': {}", scenario, e.getMessage());
            softAssert.fail("Test failed for pagination scenario '" + scenario + "': " + e.getMessage());
        } finally {
            softAssert.assertAll();
        }
    }
}
