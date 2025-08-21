package demoqa.web.tests.elements;

import demoqa.pages.elements.WebTablesPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WebTablePageTests extends BaseTest {
    // Page Text Constants
    private static final String EXPECTED_HEADER = "Web Tables";
    private static final String EXPECTED_BUTTON_ADD_TEXT = "Add";
    private static final String EXPECTED_BUTTON_NEXT_TEXT = "Next";
    private static final String EXPECTED_BUTTON_PREVIOUS_TEXT = "Previous";
    private static final String EXPECTED_PAGE_JUMP = "1";
    private static final String EXPECTED_PAGE_INFO = "Page of 1";
    private static final String EXPECTED_10_ROWS = "10 rows";
    private static final String EXPECTED_SEARCH_BOX_TEXT = "Type to search";
    private static final String EXPECTED_REGISTRATION_FORM_TEXT = "Registration Form";
    private static final String EXPECTED_FIRST_NAME_LABEL = "First Name";
    private static final String EXPECTED_FIRST_NAME_PLACEHOLDER = "First Name";
    private static final String EXPECTED_LAST_NAME_LABEL = "Last Name";
    private static final String EXPECTED_LAST_NAME_PLACEHOLDER = "Last Name";
    private static final String EXPECTED_EMAIL_LABEL = "Email";
    private static final String EXPECTED_EMAIL_PLACEHOLDER = "name@example.com";
    private static final String EXPECTED_AGE_LABEL = "Age";
    private static final String EXPECTED_AGE_PLACEHOLDER = "Age";
    private static final String EXPECTED_SALARY_LABEL = "Salary";
    private static final String EXPECTED_SALARY_PLACEHOLDER = "Salary";
    private static final String EXPECTED_DEPARTMENT_LABEL = "Department";
    private static final String EXPECTED_DEPARTMENT_PLACEHOLDER = "Department";
    private static final String EXPECTED_SUBMIT_BUTTON_TEXT = "Submit";
    private static final String EXPECTED_NO_ROWS_FOUND = "No rows found";

    // Table Data Constants
    private static final String EXPECTED_TABLE_HEADER = """
            First Name
            Last Name
            Age
            Email
            Salary
            Department
            Action""";
    private static final String EXPECTED_TABLE_DATA = """
            [Cierra
            Vega
            39
            cierra@example.com
            10000
            Insurance, Alden
            Cantrell
            45
            alden@example.com
            12000
            Compliance, Kierra
            Gentry
            29
            kierra@example.com
            2000
            Legal, , , , , , , ]""";

    // Test Data Constants - User Information
    private static final String TEST_EMAIL_CIERRA = "cierra@example.com";
    private static final String TEST_FIRST_NAME = "Zhivko";
    private static final String TEST_LAST_NAME = "Petrov";
    private static final String TEST_NEW_EMAIL = "da@abv.bg";
    private static final String TEST_AGE = "37";
    private static final String TEST_SALARY = "2000";
    private static final String TEST_DEPARTMENT = "Home";
    private static final String TEST_EMAIL_KIERRA = "kierra@example.com";
    private static final String TEST_EMAIL_ALDEN = "alden@example.com";
    private static final String TEST_EMAIL_ZHIVKO = "Zhivko@example.com";
    private static final String TEST_LAST_NAME_KAMENOV = "Kamenov";
    private static final String TEST_SALARY_ALT = "2500";
    private static final String TEST_DEPARTMENT_QA = "QA";

    // Test Data Constants - Expected Values for Search Tests
    private static final String EXPECTED_FIRST_NAME_CIERRA = "Cierra";
    private static final String EXPECTED_LAST_NAME_CIERRA = "Vega";
    private static final String EXPECTED_AGE_CIERRA = "39";
    private static final String EXPECTED_SALARY_CIERRA = "10000";

    // Test Data Constants - Search Test Data
    private static final String SEARCH_NON_EXISTENT_CATEGORY = "karma";
    private static final String SEARCH_EXISTING_CATEGORY = "Insurance";

    // Rows Per Page Constants
    private static final String ROWS_5 = "5 rows";
    private static final String ROWS_10 = "10 rows";
    private static final String ROWS_20 = "20 rows";
    private static final String ROWS_25 = "25 rows";
    private static final String ROWS_50 = "50 rows";
    private static final String ROWS_100 = "100 rows";

    // Color Constants
    private static final String EXPECTED_RED_COLOR = "1px solid rgb(220, 53, 69)";
    private static final String EXPECTED_GREEN_COLOR = "1px solid rgb(40, 167, 69)";

    // Error Message Constants
    private static final String HEADER_VALUE_MISMATCH = "Header value mismatch";
    private static final String ADD_BUTTON_MISMATCH = "Add button text mismatch";
    private static final String NEXT_BUTTON_MISMATCH = "Next button text mismatch";
    private static final String PREVIOUS_BUTTON_MISMATCH = "Previous button text mismatch";
    private static final String PAGE_JUMP_MISMATCH = "Page jump mismatch";
    private static final String PAGE_INFO_MISMATCH = "Page info mismatch";
    private static final String ROWS_COUNT_MISMATCH = "Rows count mismatch";
    private static final String TABLE_HEADER_MISMATCH = "Table header mismatch";
    private static final String TABLE_DATA_MISMATCH = "Table data mismatch";
    private static final String SEARCH_BOX_PLACEHOLDER_MISMATCH = "Search box placeholder mismatch";
    private static final String REGISTRATION_FORM_TEXT_MISMATCH = "Registration form text mismatch";
    private static final String FIRST_NAME_LABEL_MISMATCH = "First name label mismatch";
    private static final String LAST_NAME_LABEL_MISMATCH = "Last name label mismatch";
    private static final String EMAIL_LABEL_MISMATCH = "Email label mismatch";
    private static final String AGE_LABEL_MISMATCH = "Age label mismatch";
    private static final String SALARY_LABEL_MISMATCH = "Salary label mismatch";
    private static final String DEPARTMENT_LABEL_MISMATCH = "Department label mismatch";
    private static final String FIRST_NAME_PLACEHOLDER_MISMATCH = "First name placeholder mismatch";
    private static final String LAST_NAME_PLACEHOLDER_MISMATCH = "Last name placeholder mismatch";
    private static final String EMAIL_PLACEHOLDER_MISMATCH = "Email placeholder mismatch";
    private static final String AGE_PLACEHOLDER_MISMATCH = "Age placeholder mismatch";
    private static final String SALARY_PLACEHOLDER_MISMATCH = "Salary placeholder mismatch";
    private static final String DEPARTMENT_PLACEHOLDER_MISMATCH = "Department placeholder mismatch";
    private static final String SUBMIT_BUTTON_TEXT_MISMATCH = "Submit button text mismatch";
    private static final String FIRST_NAME_MISMATCH = "First name mismatch";
    private static final String LAST_NAME_MISMATCH = "Last name mismatch";
    private static final String EMAIL_MISMATCH = "Email mismatch";
    private static final String AGE_MISMATCH = "Age mismatch";
    private static final String SALARY_MISMATCH = "Salary mismatch";
    private static final String DEPARTMENT_MISMATCH = "Department mismatch";
    private static final String NO_ROWS_MESSAGE_MISMATCH = "No rows found message missing";
    private static final String WRONG_FIRST_NAME = "Wrong first name";
    private static final String WRONG_LAST_NAME = "Wrong last name";
    private static final String WRONG_AGE = "Wrong age";
    private static final String WRONG_EMAIL = "Wrong email";
    private static final String WRONG_SALARY = "Wrong salary";
    private static final String WRONG_DEPARTMENT = "Wrong department";
    private static final String NEXT_BUTTON_ACTIVE_ERROR = "Next button should not be active";
    private static final String RED_COLOR_MISMATCH = "Wrong color, expected red";
    private static final String GREEN_COLOR_MISMATCH = "Wrong color, expected green";

    // Error Message Constants - Generic Messages
    private static final String GENERIC_FIRST_NAME_MISMATCH = "\n Actual & Expected FirstName Do Not Match.\n";
    private static final String GENERIC_LAST_NAME_MISMATCH = "\n Actual & Expected LastName Do Not Match.\n";
    private static final String GENERIC_EMAIL_MISMATCH = "\n Actual & Expected Email Do Not Match \n";
    private static final String GENERIC_SALARY_MISMATCH = "\n Actual & Expected Salary Do Not Match.\n";
    private static final String GENERIC_DEPARTMENT_MISMATCH = "\n Actual & Expected Department Do Not Match \n";
    private static final String GENERIC_NO_ROWS_MESSAGE = "\nMissing message.\n";
    private static final String GENERIC_WRONG_FIRST_NAME = "\nWrong first name.\n";
    private static final String GENERIC_WRONG_LAST_NAME = "\nWrong last name.\n";
    private static final String GENERIC_WRONG_AGE = "\nWrong age.\n";
    private static final String GENERIC_WRONG_EMAIL = "\nWrong email.\n";
    private static final String GENERIC_WRONG_SALARY = "\nWrong salary.\n";
    private static final String GENERIC_WRONG_DEPARTMENT = "\nWrong department.\n";
    private static final String GENERIC_EXPECTED_ROWS_5 = "\nExpected 5 rows.\n";
    private static final String GENERIC_EXPECTED_ROWS_10 = "\nExpected 10 rows.\n";
    private static final String GENERIC_EXPECTED_ROWS_20 = "\nExpected 20 rows.\n";
    private static final String GENERIC_EXPECTED_ROWS_25 = "\nExpected 25 rows.\n";
    private static final String GENERIC_EXPECTED_ROWS_50 = "\nExpected 50 rows.\n";
    private static final String GENERIC_EXPECTED_ROWS_100 = "\nExpected 100 rows.\n";
    private static final String GENERIC_WRONG_COLOR_RED = "\nWrong color expected red.\n";
    private static final String GENERIC_WRONG_COLOR_GREEN = "\nWrong color expected green.\n";

    // Data Provider for Rows Per Page Testing
    @DataProvider(name = "rowsPerPageData")
    public Object[][] rowsPerPageDataProvider() {
        return new Object[][]{
                {ROWS_5, 5, "5 rows per page"},
                {ROWS_10, 10, "10 rows per page"},
                {ROWS_20, 20, "20 rows per page"},
                {ROWS_25, 25, "25 rows per page"},
                {ROWS_50, 50, "50 rows per page"},
                {ROWS_100, 100, "100 rows per page"}
        };
    }

    private WebTablesPage webTablesPage;
    private static final String WEB_TABLES_URL = "webtables";

    @BeforeMethod
    public void goToWebTablesPage() {
        navigateToUrl(WEB_TABLES_URL);
        webTablesPage = new WebTablesPage(driver);
    }

    @Test(enabled = true, description = "Verify all text elements on the web tables page")
    public void verifyAllTextOnPage() {
        // Arrange & Act
        String actualTableHeader = webTablesPage.getTableHeader();
        String header = webTablesPage.getHeader();
        String buttonAddText = webTablesPage.getButtonAddText();
        String actualButtonNextText = webTablesPage.getButtonNextText();
        String actualButtonPreviousText = webTablesPage.getButtonPreviousText();
        String actualPageJump = webTablesPage.getPageJump();
        String actualPageInfo = webTablesPage.getPageInfo();
        webTablesPage.clickRowPerPage(EXPECTED_10_ROWS);
        int actualCountOfLines = webTablesPage.getCountOfLines();
        String actualTableData = webTablesPage.getTableData();
        String actualSearchBoxPlaceholder = webTablesPage.getSearchBoxPlaceholder();

        // Assert
        softAssert.assertEquals(header, EXPECTED_HEADER, HEADER_VALUE_MISMATCH);
        softAssert.assertEquals(buttonAddText, EXPECTED_BUTTON_ADD_TEXT, ADD_BUTTON_MISMATCH);
        softAssert.assertEquals(actualButtonNextText, EXPECTED_BUTTON_NEXT_TEXT, NEXT_BUTTON_MISMATCH);
        softAssert.assertEquals(actualButtonPreviousText, EXPECTED_BUTTON_PREVIOUS_TEXT, PREVIOUS_BUTTON_MISMATCH);
        softAssert.assertEquals(actualPageJump, EXPECTED_PAGE_JUMP, PAGE_JUMP_MISMATCH);
        softAssert.assertEquals(actualPageInfo, EXPECTED_PAGE_INFO, PAGE_INFO_MISMATCH);
        softAssert.assertEquals(actualCountOfLines, 10, ROWS_COUNT_MISMATCH);
        softAssert.assertEquals(actualTableHeader, EXPECTED_TABLE_HEADER, TABLE_HEADER_MISMATCH);
        softAssert.assertEquals(actualTableData, EXPECTED_TABLE_DATA, TABLE_DATA_MISMATCH);
        softAssert.assertEquals(actualSearchBoxPlaceholder, EXPECTED_SEARCH_BOX_TEXT, SEARCH_BOX_PLACEHOLDER_MISMATCH);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify all labels and placeholders on the registration form")
    public void verifyAllLabelAndPlaceHoldersOnRegistrationForm() {
        // Arrange & Act
        webTablesPage.clickAddButton();
        String actualRegistrationText = webTablesPage.getRegistrationFormText();
        String actualFirstNameLabel = webTablesPage.getRegistrationFirstNameLabel();
        String actualPlaceholderFirstName = webTablesPage.getPlaceholderFirstName();
        String actualLastNameLabel = webTablesPage.getRegistrationLastNameLabel();
        String actualPlaceholderLastName = webTablesPage.getPlaceholderLastName();
        String actualEmailLabel = webTablesPage.getRegistrationEmailLabel();
        String actualPlaceholderEmail = webTablesPage.getPlaceholderUserEmail();
        String actualAgeLabel = webTablesPage.getRegistrationAgeLabel();
        String actualPlaceholderAge = webTablesPage.getAgePlaceholder();
        String actualSalaryLabel = webTablesPage.getRegistrationSalaryLabel();
        String actualPlaceholderSalary = webTablesPage.getSalaryPlaceholder();
        String actualDepartmentLabel = webTablesPage.getDepartmentLabel();
        String actualPlaceholderDepartment = webTablesPage.getDepartmentPlaceholder();
        String actualSubmitButtonText = webTablesPage.getSubmitButtonText();

        // Assert
        softAssert.assertEquals(actualRegistrationText, EXPECTED_REGISTRATION_FORM_TEXT, REGISTRATION_FORM_TEXT_MISMATCH);
        softAssert.assertEquals(actualFirstNameLabel, EXPECTED_FIRST_NAME_LABEL, FIRST_NAME_LABEL_MISMATCH);
        softAssert.assertEquals(actualLastNameLabel, EXPECTED_LAST_NAME_LABEL, LAST_NAME_LABEL_MISMATCH);
        softAssert.assertEquals(actualEmailLabel, EXPECTED_EMAIL_LABEL, EMAIL_LABEL_MISMATCH);
        softAssert.assertEquals(actualAgeLabel, EXPECTED_AGE_LABEL, AGE_LABEL_MISMATCH);
        softAssert.assertEquals(actualSalaryLabel, EXPECTED_SALARY_LABEL, SALARY_LABEL_MISMATCH);
        softAssert.assertEquals(actualDepartmentLabel, EXPECTED_DEPARTMENT_LABEL, DEPARTMENT_LABEL_MISMATCH);
        softAssert.assertEquals(actualPlaceholderFirstName, EXPECTED_FIRST_NAME_PLACEHOLDER, FIRST_NAME_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(actualPlaceholderLastName, EXPECTED_LAST_NAME_PLACEHOLDER, LAST_NAME_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(actualPlaceholderEmail, EXPECTED_EMAIL_PLACEHOLDER, EMAIL_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(actualPlaceholderAge, EXPECTED_AGE_PLACEHOLDER, AGE_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(actualPlaceholderSalary, EXPECTED_SALARY_PLACEHOLDER, SALARY_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(actualPlaceholderDepartment, EXPECTED_DEPARTMENT_PLACEHOLDER, DEPARTMENT_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(actualSubmitButtonText, EXPECTED_SUBMIT_BUTTON_TEXT, SUBMIT_BUTTON_TEXT_MISMATCH);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Update first name on first user")
    public void updateFirstNameOnFirstUser() {
        // Arrange & Act
        webTablesPage.clickEdit(TEST_EMAIL_CIERRA);
        webTablesPage.setFirstName(TEST_FIRST_NAME);
        webTablesPage.clickSubmitButton();

        String actualFirstName = webTablesPage.getTableFirstName(TEST_EMAIL_CIERRA);

        // Assert
        softAssert.assertEquals(actualFirstName, TEST_FIRST_NAME, GENERIC_FIRST_NAME_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Update last name on first user")
    public void updateLastNameOnFirstUser() {
        // Arrange & Act
        webTablesPage.clickEdit(TEST_EMAIL_CIERRA);
        webTablesPage.setLastName(TEST_LAST_NAME);
        webTablesPage.clickSubmitButton();

        String actualLastName = webTablesPage.getTableLastName(TEST_EMAIL_CIERRA);

        // Assert
        softAssert.assertEquals(actualLastName, TEST_LAST_NAME, GENERIC_LAST_NAME_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Update email on first user")
    public void updateEmailOnFirstUser() {
        // Arrange & Act
        webTablesPage.clickEdit(TEST_EMAIL_CIERRA);
        webTablesPage.setEmail(TEST_NEW_EMAIL);
        webTablesPage.clickSubmitButton();
        String actualEmail = webTablesPage.getTableEmail(TEST_NEW_EMAIL);

        // Assert
        softAssert.assertEquals(actualEmail, TEST_NEW_EMAIL, GENERIC_EMAIL_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Update age on first user")
    public void updateAgeOnFirstUser() {
        // Arrange & Act
        webTablesPage.clickEdit(TEST_EMAIL_CIERRA);
        webTablesPage.setAge(TEST_AGE);
        webTablesPage.clickSubmitButton();
        String actualAge = webTablesPage.getTableAge(TEST_EMAIL_CIERRA);

        // Assert
        softAssert.assertEquals(actualAge, TEST_AGE, AGE_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Update salary on first user")
    public void updateSalaryOnFirstUser() {
        // Arrange
        webTablesPage.clickEdit(TEST_EMAIL_CIERRA);
        webTablesPage.setSalary(TEST_SALARY);
        webTablesPage.clickSubmitButton();
        String actualSalary = webTablesPage.getTableSalary(TEST_EMAIL_CIERRA);

        // Assert
        softAssert.assertEquals(actualSalary, TEST_SALARY, GENERIC_SALARY_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Update department on first user")
    public void updateDepartmentOnFirstUser() {
        // Arrange & Act
        webTablesPage.clickEdit(TEST_EMAIL_CIERRA);
        webTablesPage.setDepartment(TEST_DEPARTMENT);
        webTablesPage.clickSubmitButton();
        String actualDepartment = webTablesPage.getTableDepartment(TEST_EMAIL_CIERRA);

        // Assert
        softAssert.assertEquals(actualDepartment, TEST_DEPARTMENT, GENERIC_DEPARTMENT_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Delete default three rows")
    public void deleteDefaultThreeRows() {
        // Arrange & Act
        webTablesPage.clickDeleteByEmail(TEST_EMAIL_CIERRA);
        webTablesPage.clickDeleteByEmail(TEST_EMAIL_KIERRA);
        webTablesPage.clickDeleteByEmail(TEST_EMAIL_ALDEN);

        String actualResult = webTablesPage.getNoRowsFound();

        // Assert
        softAssert.assertEquals(actualResult, EXPECTED_NO_ROWS_FOUND, NO_ROWS_MESSAGE_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Add new user and verify data")
    public void addNewUserAndVerifyData() {
        // Arrange & Act
        webTablesPage.clickAddButton();
        webTablesPage.setFirstName(TEST_FIRST_NAME);
        webTablesPage.setLastName(TEST_LAST_NAME);
        webTablesPage.setEmail(TEST_EMAIL_ZHIVKO);
        webTablesPage.setAge(TEST_AGE);
        webTablesPage.setSalary(TEST_SALARY);
        webTablesPage.setDepartment(TEST_DEPARTMENT);
        webTablesPage.clickSubmitButton();

        String actualFirstName = webTablesPage.getTableFirstName(TEST_EMAIL_ZHIVKO);
        String actualLastName = webTablesPage.getTableLastName(TEST_EMAIL_ZHIVKO);
        String actualAge = webTablesPage.getTableAge(TEST_EMAIL_ZHIVKO);
        String actualEmail = webTablesPage.getTableEmail(TEST_EMAIL_ZHIVKO);
        String actualSalary = webTablesPage.getTableSalary(TEST_EMAIL_ZHIVKO);
        String actualDepartment = webTablesPage.getTableDepartment(TEST_EMAIL_ZHIVKO);

        softAssert.assertEquals(actualFirstName, TEST_FIRST_NAME, WRONG_FIRST_NAME);
        softAssert.assertEquals(actualLastName, TEST_LAST_NAME, WRONG_LAST_NAME);
        softAssert.assertEquals(actualAge, TEST_AGE, WRONG_AGE);
        softAssert.assertEquals(actualEmail, TEST_EMAIL_ZHIVKO, WRONG_EMAIL);
        softAssert.assertEquals(actualSalary, TEST_SALARY, WRONG_SALARY);
        softAssert.assertEquals(actualDepartment, TEST_DEPARTMENT, WRONG_DEPARTMENT);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Search with no existing category and check results")
    public void searchWithNoExistingCategoryAndCheckResults() {
        // Arrange & Act
        webTablesPage.searchWithWord(SEARCH_NON_EXISTENT_CATEGORY);
        String actualResult = webTablesPage.getNoRowsFound();

        // Assert
        softAssert.assertEquals(actualResult, EXPECTED_NO_ROWS_FOUND, GENERIC_NO_ROWS_MESSAGE);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Search with existing category and check results")
    public void searchWithExistingCategoryAndCheckResults() {
        // Arrange & Act
        webTablesPage.searchWithWord(SEARCH_EXISTING_CATEGORY);

        String actualFirstName = webTablesPage.getTableFirstName(TEST_EMAIL_CIERRA);
        String actualLastName = webTablesPage.getTableLastName(TEST_EMAIL_CIERRA);
        String actualAge = webTablesPage.getTableAge(TEST_EMAIL_CIERRA);
        String actualEmail = webTablesPage.getTableEmail(TEST_EMAIL_CIERRA);
        String actualSalary = webTablesPage.getTableSalary(TEST_EMAIL_CIERRA);
        String actualDepartment = webTablesPage.getTableDepartment(TEST_EMAIL_CIERRA);

        softAssert.assertEquals(actualFirstName, EXPECTED_FIRST_NAME_CIERRA, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(actualLastName, EXPECTED_LAST_NAME_CIERRA, GENERIC_WRONG_LAST_NAME);
        softAssert.assertEquals(actualAge, EXPECTED_AGE_CIERRA, GENERIC_WRONG_AGE);
        softAssert.assertEquals(actualEmail, TEST_EMAIL_CIERRA, GENERIC_WRONG_EMAIL);
        softAssert.assertEquals(actualSalary, EXPECTED_SALARY_CIERRA, GENERIC_WRONG_SALARY);
        softAssert.assertEquals(actualDepartment, SEARCH_EXISTING_CATEGORY, GENERIC_WRONG_DEPARTMENT);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit empty form and verify all red lines")
    public void submitEmptyFormAndVerifyAllRedLines() {
        // Arrange & Act
        webTablesPage.clickAddButton();
        webTablesPage.clickSubmitButton();

        boolean isAllBordersRed = webTablesPage.isAllBordersRed(EXPECTED_RED_COLOR);

        // Assert
        softAssert.assertTrue(isAllBordersRed);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select all rows per page")
    public void selectAllRowsPerPage() {
        // Arrange & Act
        webTablesPage.clickRowPerPage(ROWS_5);
        int countOfLines = webTablesPage.getCountOfLines();
        softAssert.assertEquals(countOfLines, 5, GENERIC_EXPECTED_ROWS_5);

        webTablesPage.clickRowPerPage(ROWS_10);
        countOfLines = webTablesPage.getCountOfLines();
        softAssert.assertEquals(countOfLines, 10, GENERIC_EXPECTED_ROWS_10);

        webTablesPage.clickRowPerPage(ROWS_20);
        countOfLines = webTablesPage.getCountOfLines();
        softAssert.assertEquals(countOfLines, 20, GENERIC_EXPECTED_ROWS_20);

        webTablesPage.clickRowPerPage(ROWS_25);
        countOfLines = webTablesPage.getCountOfLines();
        softAssert.assertEquals(countOfLines, 25, GENERIC_EXPECTED_ROWS_25);

        webTablesPage.clickRowPerPage(ROWS_50);
        countOfLines = webTablesPage.getCountOfLines();
        softAssert.assertEquals(countOfLines, 50, GENERIC_EXPECTED_ROWS_50);

        webTablesPage.clickRowPerPage(ROWS_100);
        countOfLines = webTablesPage.getCountOfLines();
        softAssert.assertEquals(countOfLines, 100, GENERIC_EXPECTED_ROWS_100);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify border color change from red to green after add")
    public void verifyColorsChangeFromRedToGreenAfterAdd() {
        // Arrange & Act
        webTablesPage.clickAddButton();
        webTablesPage.clickSubmitButton();

        String actualFirstNameBorderColorBefore = webTablesPage.getFirstNameBorderColor();
        softAssert.assertEquals(actualFirstNameBorderColorBefore, EXPECTED_RED_COLOR, GENERIC_WRONG_COLOR_RED);
        webTablesPage.setFirstName(TEST_FIRST_NAME);
        softAssert.assertTrue(webTablesPage.isFirstNameBorderColorGreen(EXPECTED_GREEN_COLOR), GENERIC_WRONG_COLOR_GREEN);

        String actualLastNameBorderColorBefore = webTablesPage.getLastNameBorderColor();
        softAssert.assertEquals(actualLastNameBorderColorBefore, EXPECTED_RED_COLOR, GENERIC_WRONG_COLOR_RED);
        webTablesPage.setLastName(TEST_LAST_NAME);
        softAssert.assertTrue(webTablesPage.isLastNameBorderColorGreen(EXPECTED_GREEN_COLOR));

        String actualEmailColorBefore = webTablesPage.getEmailBorderColor();
        softAssert.assertEquals(actualEmailColorBefore, EXPECTED_RED_COLOR, GENERIC_WRONG_COLOR_RED);
        webTablesPage.setEmail(TEST_EMAIL_ZHIVKO);
        softAssert.assertTrue(webTablesPage.isEmailBorderColorGreen(EXPECTED_GREEN_COLOR));

        String actualAgeColorBefore = webTablesPage.getAgeBorderColor();
        softAssert.assertEquals(actualAgeColorBefore, EXPECTED_RED_COLOR, GENERIC_WRONG_COLOR_RED);
        webTablesPage.setAge(TEST_AGE);
        softAssert.assertTrue(webTablesPage.isAgeBorderColorGreen(EXPECTED_GREEN_COLOR));

        String actualSalaryColorBefore = webTablesPage.getSalaryBorderColor();
        softAssert.assertEquals(actualSalaryColorBefore, EXPECTED_RED_COLOR, GENERIC_WRONG_COLOR_RED);
        webTablesPage.setSalary(TEST_SALARY);
        softAssert.assertTrue(webTablesPage.isSalaryBorderColorGreen(EXPECTED_GREEN_COLOR));

        String actualDepartmentColorBefore = webTablesPage.getDepartmentBorderColor();
        softAssert.assertEquals(actualDepartmentColorBefore, EXPECTED_RED_COLOR, GENERIC_WRONG_COLOR_RED);
        webTablesPage.setDepartment(TEST_DEPARTMENT);
        softAssert.assertTrue(webTablesPage.isDepartmentBorderColorGreen(EXPECTED_GREEN_COLOR));

        softAssert.assertAll();
    }

    // New Data-Driven Test for Rows Per Page
    @Test(dataProvider = "rowsPerPageData", enabled = true, description = "Test rows per page functionality with data provider")
    public void testRowsPerPageWithDataProvider(String rowsOption, int expectedCount, String testDescription) {
        // Arrange & Act
        webTablesPage.clickRowPerPage(rowsOption);
        int actualCountOfLines = webTablesPage.getCountOfLines();

        // Assert
        softAssert.assertEquals(actualCountOfLines, expectedCount,
                String.format("Expected %d rows for %s, but found %d", expectedCount, rowsOption, actualCountOfLines));
        softAssert.assertAll();
    }
}
