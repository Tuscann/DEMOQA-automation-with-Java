package demoqa.web.tests.elements;

import demoqa.pages.elements.WebTablesPage;
import demoqa.web.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WebTablePageTests extends BaseTest {
    // URL Constants
    private static final String WEB_TABLES_URL = "webtables";
    
    // Text Constants
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
    
    // Test Data Constants
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
        // Arrange
        String email = "cierra@example.com";
        String expectedFirstName = "Zhivko";

        webTablesPage.clickEdit(email);
        webTablesPage.setFirstName(expectedFirstName);
        webTablesPage.clickSubmitButton();

        String actualFirstName = webTablesPage.getTableFirstName(email);

        Assert.assertEquals(actualFirstName, expectedFirstName, "\n Actual & Expected FirstName Do Not Match.\n");
    }

    @Test(enabled = true, description = "Update last name on first user")
    public void updateLastNameOnFirstUser() {
        // Arrange
        String email = "cierra@example.com";
        String expectedLastName = "Petrov";

        webTablesPage.clickEdit(email);
        webTablesPage.setLastName(expectedLastName);
        webTablesPage.clickSubmitButton();

        String actualLastName = webTablesPage.getTableLastName(email);

        Assert.assertEquals(actualLastName, expectedLastName, "\n Actual & Expected LastName Do Not Match.\n");
    }

    @Test(enabled = true, description = "Update email on first user")
    public void updateEmailOnFirstUser() {
        // Arrange
        String oldEmail = "cierra@example.com";
        String newEmail = "da@abv.bg";

        webTablesPage.clickEdit(oldEmail);
        webTablesPage.setEmail(newEmail);
        webTablesPage.clickSubmitButton();
        String actualEmail = webTablesPage.getTableEmail(newEmail);

        Assert.assertEquals(actualEmail, newEmail, "\n Actual & Expected Email Do Not Match \n");
    }

    @Test(enabled = true, description = "Update age on first user")
    public void updateAgeOnFirstUser() {
        // Arrange
        String oldEmail = "cierra@example.com";
        String newEmail = "da@abv.bg";

        webTablesPage.clickEdit(oldEmail);
        webTablesPage.setEmail(newEmail);
        webTablesPage.clickSubmitButton();
        String actualEmail = webTablesPage.getTableEmail(newEmail);

        Assert.assertEquals(actualEmail, newEmail, "\n Actual & Expected Email Do Not Match \n");
    }

    @Test(enabled = true, description = "Update salary on first user")
    public void updateSalaryOnFirstUser() {
        // Arrange
        String email = "cierra@example.com";
        String expectedSalary = "2000";

        webTablesPage.clickEdit(email);
        webTablesPage.setSalary(expectedSalary);
        webTablesPage.clickSubmitButton();
        String actualSalary = webTablesPage.getTableSalary(email);

        Assert.assertEquals(actualSalary, expectedSalary, "\n Actual & Expected Salary Do Not Match.\n");
    }

    @Test(enabled = true, description = "Update department on first user")
    public void updateDepartmentOnFirstUser() {
        // Arrange
        String email = "cierra@example.com";
        String expectedDepartment = "Home";

        webTablesPage.clickEdit(email);
        webTablesPage.setDepartment(expectedDepartment);
        webTablesPage.clickSubmitButton();
        String actualDepartment = webTablesPage.getTableDepartment(email);

        Assert.assertEquals(actualDepartment, expectedDepartment, "\n Actual & Expected Department Do Not Match \n");
    }

    @Test(enabled = true, description = "Delete default three rows")
    public void deleteDefaultThreeRows() {
        // Arrange
        String email1 = "cierra@example.com";
        String email2 = "kierra@example.com";
        String email3 = "alden@example.com";

        webTablesPage.clickDeleteByEmail(email1);
        webTablesPage.clickDeleteByEmail(email2);
        webTablesPage.clickDeleteByEmail(email3);

        String actualResult = webTablesPage.getNoRowsFound();

        Assert.assertEquals(actualResult, EXPECTED_NO_ROWS_FOUND, NO_ROWS_MESSAGE_MISMATCH);
    }

    @Test(enabled = true, description = "Add new user and verify data")
    public void addNewUserAndVerifyData() {
        // Arrange
        String expectedFirstName = "Zhivko";
        String expectedLastName = "Petrov";
        String expectedEmail = "Zhivko@example.com";
        String expectedAge = "37";
        String expectedSalary = "2000";
        String expectedDepartment = "Home";

        webTablesPage.clickAddButton();
        webTablesPage.setFirstName(expectedFirstName);
        webTablesPage.setLastName(expectedLastName);
        webTablesPage.setEmail(expectedEmail);
        webTablesPage.setAge(expectedAge);
        webTablesPage.setSalary(expectedSalary);
        webTablesPage.setDepartment(expectedDepartment);
        webTablesPage.clickSubmitButton();

        String actualFirstName = webTablesPage.getTableFirstName(expectedEmail);
        String actualLastName = webTablesPage.getTableLastName(expectedEmail);
        String actualAge = webTablesPage.getTableAge(expectedEmail);
        String actualEmail = webTablesPage.getTableEmail(expectedEmail);
        String actualSalary = webTablesPage.getTableSalary(expectedEmail);
        String actualDepartment = webTablesPage.getTableDepartment(expectedEmail);

        softAssert.assertEquals(actualFirstName, expectedFirstName, WRONG_FIRST_NAME);
        softAssert.assertEquals(actualLastName, expectedLastName, WRONG_LAST_NAME);
        softAssert.assertEquals(actualAge, expectedAge, WRONG_AGE);
        softAssert.assertEquals(actualEmail, expectedEmail, WRONG_EMAIL);
        softAssert.assertEquals(actualSalary, expectedSalary, WRONG_SALARY);
        softAssert.assertEquals(actualDepartment, expectedDepartment, WRONG_DEPARTMENT);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Search with no existing category and check results")
    public void searchWithNoExistingCategoryAndCheckResults() {
        // Arrange
        String expectedResult = "No rows found";
        String searchedWord = "karma";
        webTablesPage.searchWithWord(searchedWord);
        String actualResult = webTablesPage.getNoRowsFound();

        Assert.assertEquals(actualResult, expectedResult, "\nMissing message.\n");
    }

    @Test(enabled = true, description = "Search with existing category and check results")
    public void searchWithExistingCategoryAndCheckResults() {
        // Arrange
        String searchedWord = "Insurance";
        String expectedFirstName = "Cierra";
        String expectedLastName = "Vega";
        String expectedAge = "39";
        String expectedEmail = "cierra@example.com";
        String expectedSalary = "10000";

        webTablesPage.searchWithWord(searchedWord);

        String actualFirstName = webTablesPage.getTableFirstName(expectedEmail);
        String actualLastName = webTablesPage.getTableLastName(expectedEmail);
        String actualAge = webTablesPage.getTableAge(expectedEmail);
        String actualEmail = webTablesPage.getTableEmail(expectedEmail);
        String actualSalary = webTablesPage.getTableSalary(expectedEmail);
        String actualDepartment = webTablesPage.getTableDepartment(expectedEmail);

        softAssert.assertEquals(actualFirstName, expectedFirstName, "\nWrong first name.\n");
        softAssert.assertEquals(actualLastName, expectedLastName, "\nWrong last name.\n");
        softAssert.assertEquals(actualAge, expectedAge, "\nWrong age.\n");
        softAssert.assertEquals(actualEmail, expectedEmail, "\nWrong email.\n");
        softAssert.assertEquals(actualSalary, expectedSalary, "\nWrong salary.\n");
        softAssert.assertEquals(actualDepartment, searchedWord, "\nWrong department.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Submit empty form and verify all red lines")
    public void submitEmptyFormAndVerifyAllRedLines() {
        // Arrange
        String redColor = "1px solid rgb(220, 53, 69)";

        webTablesPage.clickAddButton();
        webTablesPage.clickSubmitButton();

        boolean isAllBordersRed = webTablesPage.isAllBordersRed(redColor);

        Assert.assertTrue(isAllBordersRed);
    }

    @Test(enabled = true, description = "Select all rows per page")
    public void selectAllRowsPerPage() {
        // Arrange
        String expected5rows = "5 rows";
        String expected10rows = "10 rows";
        String expected20rows = "20 rows";
        String expected25rows = "25 rows";
        String expected50rows = "50 rows";
        String expected100rows = "100 rows";

        webTablesPage.clickRowPerPage(expected5rows);
        int countOfLines = webTablesPage.getCountOfLines();
        softAssert.assertEquals(countOfLines, 5, "\nExpected 5 rows.\n");

        webTablesPage.clickRowPerPage(expected10rows);
        countOfLines = webTablesPage.getCountOfLines();
        softAssert.assertEquals(countOfLines, 10, "\nExpected 10 rows.\n");

        webTablesPage.clickRowPerPage(expected20rows);
        countOfLines = webTablesPage.getCountOfLines();
        softAssert.assertEquals(countOfLines, 20, "\nExpected 20 rows.\n");

        webTablesPage.clickRowPerPage(expected25rows);
        countOfLines = webTablesPage.getCountOfLines();
        softAssert.assertEquals(countOfLines, 25, "\nExpected 25 rows.\n");

        webTablesPage.clickRowPerPage(expected50rows);
        countOfLines = webTablesPage.getCountOfLines();
        softAssert.assertEquals(countOfLines, 50, "\nExpected 50 rows.\n");

        webTablesPage.clickRowPerPage(expected100rows);
        countOfLines = webTablesPage.getCountOfLines();
        softAssert.assertEquals(countOfLines, 100, "\nExpected 100 rows.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify border color change from red to green after add")
    public void verifyColorsChangeFromRedToGreenAfterAdd() {
        // Arrange
        webTablesPage.clickAddButton();
        webTablesPage.clickSubmitButton();

        String expectedFirstName = "Zhivko";
        String expectedLastName = "Petrov";
        String expectedEmail = "Zhivko@example.com";
        String expectedAge = "37";
        String expectedSalary = "2000";
        String expectedDepartment = "Home";

        String expectedRedColor = "1px solid rgb(220, 53, 69)";
        String expectedGreenColor = "1px solid rgb(40, 167, 69)";

        String actualFirstNameBorderColorBefore = webTablesPage.getFirstNameBorderColor();
        softAssert.assertEquals(actualFirstNameBorderColorBefore, expectedRedColor, "\nWrong color expected red.\n");
        webTablesPage.setFirstName(expectedFirstName);
        softAssert.assertTrue(webTablesPage.isFirstNameBorderColorGreen(expectedGreenColor));

        String actualLastNameBorderColorBefore = webTablesPage.getLastNameBorderColor();
        softAssert.assertEquals(actualLastNameBorderColorBefore, expectedRedColor, "\nWrong color expected red.\n");
        webTablesPage.setLastName(expectedLastName);
        softAssert.assertTrue(webTablesPage.isLastNameBorderColorGreen(expectedGreenColor));

        String actualEmailColorBefore = webTablesPage.getEmailBorderColor();
        softAssert.assertEquals(actualEmailColorBefore, expectedRedColor, "\nWrong color expected red.\n");
        webTablesPage.setEmail(expectedEmail);
        softAssert.assertTrue(webTablesPage.isEmailBorderColorGreen(expectedGreenColor));

        String actualAgeColorBefore = webTablesPage.getAgeBorderColor();
        softAssert.assertEquals(actualAgeColorBefore, expectedRedColor, "\nWrong color expected red.\n");
        webTablesPage.setAge(expectedAge);
        softAssert.assertTrue(webTablesPage.isAgeBorderColorGreen(expectedGreenColor));

        String actualSalaryColorBefore = webTablesPage.getSalaryBorderColor();
        softAssert.assertEquals(actualSalaryColorBefore, expectedRedColor, "\nWrong color expected red.\n");
        webTablesPage.setSalary(expectedSalary);
        softAssert.assertTrue(webTablesPage.isSalaryBorderColorGreen(expectedGreenColor));

        String actualDepartmentColorBefore = webTablesPage.getDepartmentBorderColor();
        softAssert.assertEquals(actualDepartmentColorBefore, expectedRedColor, "\n Wrong color expected red.\n");
        webTablesPage.setDepartment(expectedDepartment);
        softAssert.assertTrue(webTablesPage.isDepartmentBorderColorGreen(expectedGreenColor));

        webTablesPage.clickSubmitButton();

        softAssert.assertAll();
    }

    // New Data-Driven Test for Rows Per Page
    @Test(dataProvider = "rowsPerPageData", enabled = true, description = "Test rows per page functionality with data provider")
    public void testRowsPerPageWithDataProvider(String rowsOption, int expectedCount, String testDescription) {
        // Arrange & Act
        webTablesPage.clickRowPerPage(rowsOption);
        int actualCountOfLines = webTablesPage.getCountOfLines();

        // Assert
        Assert.assertEquals(actualCountOfLines, expectedCount, 
            String.format("Expected %d rows for %s, but found %d", expectedCount, rowsOption, actualCountOfLines));
    }
}
