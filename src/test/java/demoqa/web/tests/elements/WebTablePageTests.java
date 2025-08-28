package demoqa.web.tests.elements;

import demoqa.pages.elements.WebTablesPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
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

    private static final String expectedFirstRowData =
            """                
                    Alden
                    Cantrell
                    45
                    alden@example.com
                    12000
                    Compliance""";

    private static final String expectedSecondRowData =
            """                
                    Cierra
                    Vega
                    39
                    cierra@example.com
                    10000
                    Insurance""";

    private static final String expectedThirdRowData =
            """                
                    Kierra
                    Gentry
                    29
                    kierra@example.com
                    2000
                    Legal""";

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
    private static final String FIRST_NAME = "Zhivko";
    private static final String LAST_NAME = "Petrov";
    private static final String TEST_NEW_EMAIL = "karma@abv.bg";
    private static final String AGE = "37";
    private static final String SALARY = "3600";
    private static final String DEPARTMENT = "Home";
    private static final String TEST_EMAIL_KIERRA = "kierra@example.com";
    private static final String TEST_EMAIL_ALDEN = "alden@example.com";
    private static final String ZHIVKO_EMAIL = "Zhivko@example.com";

    // Test Data Constants - Expected Values for Search Tests
    private static final String EXPECTED_FIRST_NAME_CIERRA = "Cierra";
    private static final String EXPECTED_FIRST_NAME_ALDEN = "Alden";
    private static final String EXPECTED_FIRST_NAME_KIERRA = "Kierra";
    private static final String EXPECTED_LAST_NAME_VEGA = "Vega";
    private static final String EXPECTED_LAST_NAME_CANTRELL = "Cantrell";
    private static final String EXPECTED_LAST_NAME_GENTRY = "Gentry";
    private static final String EXPECTED_AGE_29 = "29";
    private static final String EXPECTED_AGE_39 = "39";
    private static final String EXPECTED_AGE_45 = "45";
    private static final String EXPECTED_SALARY_10000 = "10000";
    private static final String EXPECTED_SALARY_12000 = "12000";
    private static final String EXPECTED_SALARY_2000 = "2000";
    private static final String EXPECTED_DEPARTMENT_COMPLIANCE = "Compliance";
    private static final String EXPECTED_DEPARTMENT_LEGAL = "Legal";

    // Test Data Constants - Search Test Data
    private static final String SEARCH_NON_EXISTENT_CATEGORY = "karma";
    private static final String SEARCH_EXISTING_FIRST_NAME = "ALDEN";
    private static final String SEARCH_EXISTING_LAST_NAME = "Gentry";
    private static final String SEARCH_EXISTING_AGE = "45";
    private static final String SEARCH_EXISTING_EMAIL_ALDEN = "alden@example.com";
    private static final String SEARCH_EXISTING_SALARY_12000 = "12000";
    private static final String SEARCH_EXISTING_DEPARTMENT_INSURANCE = "Insurance";

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
    private static final String AGE_MISMATCH = "Age mismatch";
    private static final String NO_ROWS_MESSAGE_MISMATCH = "No rows found message missing";
    private static final String WRONG_FIRST_NAME = "Wrong first name";
    private static final String WRONG_LAST_NAME = "Wrong last name";
    private static final String WRONG_AGE = "Wrong age";
    private static final String WRONG_EMAIL = "Wrong email";
    private static final String WRONG_SALARY = "Wrong salary";
    private static final String WRONG_DEPARTMENT = "Wrong department";

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
        String actualFirstNameLabel = webTablesPage.getRegistrationFirstNameLabel();
        String actualFirstNamePlaceholder = webTablesPage.getPlaceholderFirstName();
        String actualLastNameLabel = webTablesPage.getRegistrationLastNameLabel();
        String actualLastNamePlaceholder = webTablesPage.getPlaceholderLastName();
        String actualEmailLabel = webTablesPage.getRegistrationEmailLabel();
        String actualEmailPlaceholder = webTablesPage.getPlaceholderUserEmail();
        String actualAgeLabel = webTablesPage.getRegistrationAgeLabel();
        String actualAgePlaceholder = webTablesPage.getAgePlaceholder();
        String actualSalaryLabel = webTablesPage.getRegistrationSalaryLabel();
        String actualSalaryPlaceholder = webTablesPage.getSalaryPlaceholder();
        String actualDepartmentLabel = webTablesPage.getDepartmentLabel();
        String actualDepartmentPlaceholder = webTablesPage.getDepartmentPlaceholder();
        String actualSubmitButtonText = webTablesPage.getSubmitButtonText();

        // Assert
        softAssert.assertEquals(webTablesPage.getRegistrationFormText(), EXPECTED_REGISTRATION_FORM_TEXT, REGISTRATION_FORM_TEXT_MISMATCH);
        softAssert.assertEquals(actualFirstNameLabel, EXPECTED_FIRST_NAME_LABEL, FIRST_NAME_LABEL_MISMATCH);
        softAssert.assertEquals(actualLastNameLabel, EXPECTED_LAST_NAME_LABEL, LAST_NAME_LABEL_MISMATCH);
        softAssert.assertEquals(actualEmailLabel, EXPECTED_EMAIL_LABEL, EMAIL_LABEL_MISMATCH);
        softAssert.assertEquals(actualAgeLabel, EXPECTED_AGE_LABEL, AGE_LABEL_MISMATCH);
        softAssert.assertEquals(actualSalaryLabel, EXPECTED_SALARY_LABEL, SALARY_LABEL_MISMATCH);
        softAssert.assertEquals(actualDepartmentLabel, EXPECTED_DEPARTMENT_LABEL, DEPARTMENT_LABEL_MISMATCH);
        softAssert.assertEquals(actualFirstNamePlaceholder, EXPECTED_FIRST_NAME_PLACEHOLDER, FIRST_NAME_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(actualLastNamePlaceholder, EXPECTED_LAST_NAME_PLACEHOLDER, LAST_NAME_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(actualEmailPlaceholder, EXPECTED_EMAIL_PLACEHOLDER, EMAIL_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(actualAgePlaceholder, EXPECTED_AGE_PLACEHOLDER, AGE_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(actualSalaryPlaceholder, EXPECTED_SALARY_PLACEHOLDER, SALARY_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(actualDepartmentPlaceholder, EXPECTED_DEPARTMENT_PLACEHOLDER, DEPARTMENT_PLACEHOLDER_MISMATCH);
        softAssert.assertEquals(actualSubmitButtonText, EXPECTED_SUBMIT_BUTTON_TEXT, SUBMIT_BUTTON_TEXT_MISMATCH);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Update first name on first user")
    public void updateFirstUserFirstName() {
        // Arrange & Act
        webTablesPage.clickEdit(TEST_EMAIL_CIERRA);
        webTablesPage.setFirstName(FIRST_NAME);
        webTablesPage.clickSubmitButton();

        // Assert
        softAssert.assertEquals(webTablesPage.getTableFirstName(TEST_EMAIL_CIERRA), FIRST_NAME, GENERIC_FIRST_NAME_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Update last name on first user")
    public void updateFirstUserLastName() {
        // Arrange & Act
        webTablesPage.clickEdit(TEST_EMAIL_CIERRA);
        webTablesPage.setLastName(LAST_NAME);
        webTablesPage.clickSubmitButton();

        // Assert
        softAssert.assertEquals(webTablesPage.getTableLastName(TEST_EMAIL_CIERRA), LAST_NAME, GENERIC_LAST_NAME_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Update age on first user")
    public void updateFirstUserAge() {
        // Arrange & Act
        webTablesPage.clickEdit(TEST_EMAIL_CIERRA);
        webTablesPage.setAge(AGE);
        webTablesPage.clickSubmitButton();

        // Assert
        softAssert.assertEquals(webTablesPage.getTableAge(TEST_EMAIL_CIERRA), AGE, AGE_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Update email on first user")
    public void updateFirstUserEmail() {
        // Arrange & Act
        webTablesPage.clickEdit(TEST_EMAIL_CIERRA);
        webTablesPage.setEmail(TEST_NEW_EMAIL);
        webTablesPage.clickSubmitButton();

        // Assert
        softAssert.assertEquals(webTablesPage.getTableEmail(TEST_NEW_EMAIL), TEST_NEW_EMAIL, GENERIC_EMAIL_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Update salary on first user")
    public void updateFirstUserSalary() {
        // Arrange
        webTablesPage.clickEdit(TEST_EMAIL_CIERRA);
        webTablesPage.setSalary(SALARY);
        webTablesPage.clickSubmitButton();

        // Assert
        softAssert.assertEquals(webTablesPage.getTableSalary(TEST_EMAIL_CIERRA), SALARY, GENERIC_SALARY_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Update department on first user")
    public void updateFirstUserDepartment() {
        // Arrange & Act
        webTablesPage.clickEdit(TEST_EMAIL_CIERRA);
        webTablesPage.setDepartment(DEPARTMENT);
        webTablesPage.clickSubmitButton();

        // Assert
        softAssert.assertEquals(webTablesPage.getTableDepartment(TEST_EMAIL_CIERRA), DEPARTMENT, GENERIC_DEPARTMENT_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Delete default three rows")
    public void deleteDefaultThreeRows() {
        // Arrange & Act
        webTablesPage.clickDeleteByEmail(TEST_EMAIL_CIERRA);
        webTablesPage.clickDeleteByEmail(TEST_EMAIL_KIERRA);
        webTablesPage.clickDeleteByEmail(TEST_EMAIL_ALDEN);

        // Assert
        softAssert.assertEquals(webTablesPage.getNoRowsFound(), EXPECTED_NO_ROWS_FOUND, NO_ROWS_MESSAGE_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Delete default three rows")
    public void deleteDefaultThreeRowsAndNewUser() {
        // Arrange & Act
        webTablesPage.clickDeleteByEmail(TEST_EMAIL_CIERRA);
        webTablesPage.clickDeleteByEmail(TEST_EMAIL_KIERRA);
        webTablesPage.clickDeleteByEmail(TEST_EMAIL_ALDEN);

        webTablesPage.clickAddButton();
        webTablesPage.setFirstName(FIRST_NAME);
        webTablesPage.setLastName(LAST_NAME);
        webTablesPage.setEmail(ZHIVKO_EMAIL);
        webTablesPage.setAge(AGE);
        webTablesPage.setSalary(SALARY);
        webTablesPage.setDepartment(DEPARTMENT);
        webTablesPage.clickSubmitButton();

        // Assert
        softAssert.assertEquals(webTablesPage.getFirstRowFirstName(), FIRST_NAME, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getFirstRowLastName(), LAST_NAME, GENERIC_WRONG_LAST_NAME);
        softAssert.assertEquals(webTablesPage.getFirstRowAge(), AGE, GENERIC_WRONG_AGE);
        softAssert.assertEquals(webTablesPage.getFirstRowEmail(), ZHIVKO_EMAIL, GENERIC_WRONG_EMAIL);
        softAssert.assertEquals(webTablesPage.getFirstRowSalary(), SALARY, GENERIC_WRONG_SALARY);
        softAssert.assertEquals(webTablesPage.getFirstRowDepartment(), EXPECTED_DEPARTMENT_LEGAL, GENERIC_WRONG_DEPARTMENT);

    }

    @Test(enabled = true, description = "Add 17 new users and verify rows count")
    public void addSeventeenNewUsersAndVerifyData() {
        // Arrange & Act
        for (int i = 0; i < 17; i++) {
            webTablesPage.clickAddButton();
            webTablesPage.setFirstName(FIRST_NAME + i);
            webTablesPage.setLastName(LAST_NAME + i);
            webTablesPage.setEmail(ZHIVKO_EMAIL);
            webTablesPage.setAge(EXPECTED_AGE_45 + i + "");
            webTablesPage.setSalary(SALARY);
            webTablesPage.setDepartment(DEPARTMENT);
            webTablesPage.clickSubmitButton();
        }
        webTablesPage.clickRowPerPage(ROWS_20);

        // Assert
        softAssert.assertEquals(webTablesPage.getCountOfLines(), 20);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Add eight new users and verify rows count")
    public void addEightNewUsersAndClickNextAndVerifyData() {
        // Arrange & Act
        String firstName = "Zhivko7";
        String lastName = "Petrov7";
        String age = "52";
        String email = "Zhivko@example.com";
        String salary = "3600";
        String department = "Home7";

        for (int i = 0; i < 8; i++) {
            webTablesPage.clickAddButton();
            webTablesPage.setFirstName(FIRST_NAME + i);
            webTablesPage.setLastName(LAST_NAME + i);
            webTablesPage.setEmail(ZHIVKO_EMAIL);
            webTablesPage.setAge(45 + i + "");
            webTablesPage.setSalary(SALARY);
            webTablesPage.setDepartment(DEPARTMENT + i);
            webTablesPage.clickSubmitButton();
        }

        webTablesPage.clickNextButton();

        softAssert.assertEquals(webTablesPage.getFirstRowFirstName(), firstName, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getFirstRowLastName(), lastName, GENERIC_WRONG_LAST_NAME);
        softAssert.assertEquals(webTablesPage.getFirstRowAge(), age, GENERIC_WRONG_AGE);
        softAssert.assertEquals(webTablesPage.getFirstRowEmail(), email, GENERIC_WRONG_EMAIL);
        softAssert.assertEquals(webTablesPage.getFirstRowSalary(), salary, GENERIC_WRONG_SALARY);
        softAssert.assertEquals(webTablesPage.getFirstRowDepartment(), department, GENERIC_WRONG_DEPARTMENT);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Add new user and verify data")
    public void addNewUserAndVerifyData() {
        // Arrange & Act
        webTablesPage.clickAddButton();
        webTablesPage.setFirstName(FIRST_NAME);
        webTablesPage.setLastName(LAST_NAME);
        webTablesPage.setEmail(ZHIVKO_EMAIL);
        webTablesPage.setAge(AGE);
        webTablesPage.setSalary(SALARY);
        webTablesPage.setDepartment(DEPARTMENT);
        webTablesPage.clickSubmitButton();

        softAssert.assertEquals(webTablesPage.getTableFirstName(ZHIVKO_EMAIL), FIRST_NAME, WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getTableLastName(ZHIVKO_EMAIL), LAST_NAME, WRONG_LAST_NAME);
        softAssert.assertEquals(webTablesPage.getTableAge(ZHIVKO_EMAIL), AGE, WRONG_AGE);
        softAssert.assertEquals(webTablesPage.getTableEmail(ZHIVKO_EMAIL), ZHIVKO_EMAIL, WRONG_EMAIL);
        softAssert.assertEquals(webTablesPage.getTableSalary(ZHIVKO_EMAIL), SALARY, WRONG_SALARY);
        softAssert.assertEquals(webTablesPage.getTableDepartment(ZHIVKO_EMAIL), DEPARTMENT, WRONG_DEPARTMENT);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Search with no existing category and check results")
    public void searchWithNoExistingCategoryAndCheckResults() {
        // Arrange & Act
        webTablesPage.searchWithWord(SEARCH_NON_EXISTENT_CATEGORY);

        // Assert
        softAssert.assertEquals(webTablesPage.getNoRowsFound(), EXPECTED_NO_ROWS_FOUND, GENERIC_NO_ROWS_MESSAGE);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Search with existing first name and check results")
    public void searchWithExistingFirstNameAndCheckResults() {
        // Arrange & Act
        webTablesPage.searchWithWord(SEARCH_EXISTING_FIRST_NAME);

        // Assert
        softAssert.assertEquals(webTablesPage.getFirstRowFirstName(), EXPECTED_FIRST_NAME_ALDEN, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getFirstRowLastName(), EXPECTED_LAST_NAME_CANTRELL, GENERIC_WRONG_LAST_NAME);
        softAssert.assertEquals(webTablesPage.getFirstRowAge(), EXPECTED_AGE_45, GENERIC_WRONG_AGE);
        softAssert.assertEquals(webTablesPage.getFirstRowEmail(), TEST_EMAIL_ALDEN, GENERIC_WRONG_EMAIL);
        softAssert.assertEquals(webTablesPage.getFirstRowSalary(), EXPECTED_SALARY_12000, GENERIC_WRONG_SALARY);
        softAssert.assertEquals(webTablesPage.getFirstRowDepartment(), EXPECTED_DEPARTMENT_COMPLIANCE, GENERIC_WRONG_DEPARTMENT);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Search with existing age and check results")
    public void searchWithExistingLastNameAndCheckResults() {
        // Arrange & Act
        webTablesPage.searchWithWord(SEARCH_EXISTING_LAST_NAME);

        softAssert.assertEquals(webTablesPage.getFirstRowFirstName(), EXPECTED_FIRST_NAME_KIERRA, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getFirstRowLastName(), EXPECTED_LAST_NAME_GENTRY, GENERIC_WRONG_LAST_NAME);
        softAssert.assertEquals(webTablesPage.getFirstRowAge(), EXPECTED_AGE_29, GENERIC_WRONG_AGE);
        softAssert.assertEquals(webTablesPage.getFirstRowEmail(), TEST_EMAIL_KIERRA, GENERIC_WRONG_EMAIL);
        softAssert.assertEquals(webTablesPage.getFirstRowSalary(), EXPECTED_SALARY_2000, GENERIC_WRONG_SALARY);
        softAssert.assertEquals(webTablesPage.getFirstRowDepartment(), EXPECTED_DEPARTMENT_LEGAL, GENERIC_WRONG_DEPARTMENT);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Search with existing age and check results")
    public void searchWithExistingAgeAndCheckResults() {
        // Arrange & Act
        webTablesPage.searchWithWord(SEARCH_EXISTING_AGE);

        softAssert.assertEquals(webTablesPage.getFirstRowFirstName(), EXPECTED_FIRST_NAME_ALDEN, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getFirstRowLastName(), EXPECTED_LAST_NAME_CANTRELL, GENERIC_WRONG_LAST_NAME);
        softAssert.assertEquals(webTablesPage.getFirstRowAge(), EXPECTED_AGE_45, GENERIC_WRONG_AGE);
        softAssert.assertEquals(webTablesPage.getFirstRowEmail(), TEST_EMAIL_ALDEN, GENERIC_WRONG_EMAIL);
        softAssert.assertEquals(webTablesPage.getFirstRowSalary(), EXPECTED_SALARY_12000, GENERIC_WRONG_SALARY);
        softAssert.assertEquals(webTablesPage.getFirstRowDepartment(), EXPECTED_DEPARTMENT_COMPLIANCE, GENERIC_WRONG_DEPARTMENT);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Search with existing email and check results")
    public void searchWithExistingEmailAndCheckResults() {
        // Arrange & Act
        webTablesPage.searchWithWord(SEARCH_EXISTING_EMAIL_ALDEN);

        softAssert.assertEquals(webTablesPage.getFirstRowFirstName(), EXPECTED_FIRST_NAME_ALDEN, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getFirstRowLastName(), EXPECTED_LAST_NAME_CANTRELL, GENERIC_WRONG_LAST_NAME);
        softAssert.assertEquals(webTablesPage.getFirstRowAge(), EXPECTED_AGE_45, GENERIC_WRONG_AGE);
        softAssert.assertEquals(webTablesPage.getFirstRowEmail(), TEST_EMAIL_ALDEN, GENERIC_WRONG_EMAIL);
        softAssert.assertEquals(webTablesPage.getFirstRowSalary(), EXPECTED_SALARY_12000, GENERIC_WRONG_SALARY);
        softAssert.assertEquals(webTablesPage.getFirstRowDepartment(), EXPECTED_DEPARTMENT_COMPLIANCE, GENERIC_WRONG_DEPARTMENT);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Search with existing salary and check results")
    public void searchWithExistingSalaryAndCheckResults() {
        // Arrange & Act
        webTablesPage.searchWithWord(SEARCH_EXISTING_SALARY_12000);

        softAssert.assertEquals(webTablesPage.getFirstRowFirstName(), EXPECTED_FIRST_NAME_ALDEN, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getFirstRowLastName(), EXPECTED_LAST_NAME_CANTRELL, GENERIC_WRONG_LAST_NAME);
        softAssert.assertEquals(webTablesPage.getFirstRowAge(), EXPECTED_AGE_45, GENERIC_WRONG_AGE);
        softAssert.assertEquals(webTablesPage.getFirstRowEmail(), TEST_EMAIL_ALDEN, GENERIC_WRONG_EMAIL);
        softAssert.assertEquals(webTablesPage.getFirstRowSalary(), EXPECTED_SALARY_12000, GENERIC_WRONG_SALARY);
        softAssert.assertEquals(webTablesPage.getFirstRowDepartment(), EXPECTED_DEPARTMENT_COMPLIANCE, GENERIC_WRONG_DEPARTMENT);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Search with existing department and check results")
    public void searchWithExistingDepartmentAndCheckResults() {
        // Arrange & Act
        webTablesPage.searchWithWord(SEARCH_EXISTING_DEPARTMENT_INSURANCE);

        softAssert.assertEquals(webTablesPage.getTableFirstName(TEST_EMAIL_CIERRA), EXPECTED_FIRST_NAME_CIERRA, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getTableLastName(TEST_EMAIL_CIERRA), EXPECTED_LAST_NAME_VEGA, GENERIC_WRONG_LAST_NAME);
        softAssert.assertEquals(webTablesPage.getTableAge(TEST_EMAIL_CIERRA), EXPECTED_AGE_39, GENERIC_WRONG_AGE);
        softAssert.assertEquals(webTablesPage.getTableEmail(TEST_EMAIL_CIERRA), TEST_EMAIL_CIERRA, GENERIC_WRONG_EMAIL);
        softAssert.assertEquals(webTablesPage.getTableSalary(TEST_EMAIL_CIERRA), EXPECTED_SALARY_10000, GENERIC_WRONG_SALARY);
        softAssert.assertEquals(webTablesPage.getTableDepartment(TEST_EMAIL_CIERRA), SEARCH_EXISTING_DEPARTMENT_INSURANCE, GENERIC_WRONG_DEPARTMENT);

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

    @Test(enabled = true, description = "Verify border color change from red to green after add")
    public void verifyColorsChangeFromRedToGreenAfterAdd() {
        // Arrange & Act
        webTablesPage.clickAddButton();
        webTablesPage.clickSubmitButton();

        // Assert
        String actualFirstNameBorderColorBefore = webTablesPage.getFirstNameBorderColor();
        softAssert.assertEquals(actualFirstNameBorderColorBefore, EXPECTED_RED_COLOR, GENERIC_WRONG_COLOR_RED);
        webTablesPage.setFirstName(FIRST_NAME);
        softAssert.assertTrue(webTablesPage.isFirstNameBorderColorGreen(EXPECTED_GREEN_COLOR), GENERIC_WRONG_COLOR_GREEN);

        String actualLastNameBorderColorBefore = webTablesPage.getLastNameBorderColor();
        softAssert.assertEquals(actualLastNameBorderColorBefore, EXPECTED_RED_COLOR, GENERIC_WRONG_COLOR_RED);
        webTablesPage.setLastName(LAST_NAME);
        softAssert.assertTrue(webTablesPage.isLastNameBorderColorGreen(EXPECTED_GREEN_COLOR));

        String actualEmailColorBefore = webTablesPage.getEmailBorderColor();
        softAssert.assertEquals(actualEmailColorBefore, EXPECTED_RED_COLOR, GENERIC_WRONG_COLOR_RED);
        webTablesPage.setEmail(ZHIVKO_EMAIL);
        softAssert.assertTrue(webTablesPage.isEmailBorderColorGreen(EXPECTED_GREEN_COLOR));

        String actualAgeColorBefore = webTablesPage.getAgeBorderColor();
        softAssert.assertEquals(actualAgeColorBefore, EXPECTED_RED_COLOR, GENERIC_WRONG_COLOR_RED);
        webTablesPage.setAge(AGE);
        softAssert.assertTrue(webTablesPage.isAgeBorderColorGreen(EXPECTED_GREEN_COLOR));

        String actualSalaryColorBefore = webTablesPage.getSalaryBorderColor();
        softAssert.assertEquals(actualSalaryColorBefore, EXPECTED_RED_COLOR, GENERIC_WRONG_COLOR_RED);
        webTablesPage.setSalary(SALARY);
        softAssert.assertTrue(webTablesPage.isSalaryBorderColorGreen(EXPECTED_GREEN_COLOR));

        String actualDepartmentColorBefore = webTablesPage.getDepartmentBorderColor();
        softAssert.assertEquals(actualDepartmentColorBefore, EXPECTED_RED_COLOR, GENERIC_WRONG_COLOR_RED);
        webTablesPage.setDepartment(DEPARTMENT);
        softAssert.assertTrue(webTablesPage.isDepartmentBorderColorGreen(EXPECTED_GREEN_COLOR));

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Order users by first name ascending and descending")
    public void orderTableByFirstNameHeaderAscendingAndDescending() {
        // Arrange & Act
        webTablesPage.clickFirstNameHeader();

        // Assert
        softAssert.assertEquals(webTablesPage.getFirstRow(), expectedFirstRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getSecondRow(), expectedSecondRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getThirdRow(), expectedThirdRowData, GENERIC_WRONG_FIRST_NAME);

        webTablesPage.clickFirstNameHeader();

        // Assert
        softAssert.assertEquals(webTablesPage.getThirdRow(), expectedFirstRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getSecondRow(), expectedSecondRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getFirstRow(), expectedThirdRowData, GENERIC_WRONG_FIRST_NAME);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Order users by last name")
    public void orderTableByLastNameAscendingAndDescending() {
        // Arrange & Act
        webTablesPage.clickLastNameHeader();

        // Assert
        softAssert.assertEquals(webTablesPage.getFirstRow(), expectedFirstRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getSecondRow(), expectedThirdRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getThirdRow(), expectedSecondRowData, GENERIC_WRONG_FIRST_NAME);

        webTablesPage.clickLastNameHeader();
        softAssert.assertEquals(webTablesPage.getThirdRow(), expectedFirstRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getSecondRow(), expectedThirdRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getFirstRow(), expectedSecondRowData, GENERIC_WRONG_FIRST_NAME);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Order users by age")
    public void orderTableByAgeAscendingAndDescending() {
        // Arrange & Act
        webTablesPage.clickAgeHeader();

        // Assert
        softAssert.assertEquals(webTablesPage.getFirstRow(), expectedThirdRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getSecondRow(), expectedSecondRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getThirdRow(), expectedFirstRowData, GENERIC_WRONG_FIRST_NAME);

        webTablesPage.clickAgeHeader();
        softAssert.assertEquals(webTablesPage.getFirstRow(), expectedFirstRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getSecondRow(), expectedSecondRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getThirdRow(), expectedThirdRowData, GENERIC_WRONG_FIRST_NAME);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Order users by email")
    public void orderTableByEmailAscendingAndDescending() {
        // Arrange & Act
        webTablesPage.clickEmailHeader();

        // Assert
        softAssert.assertEquals(webTablesPage.getFirstRow(), expectedFirstRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getSecondRow(), expectedSecondRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getThirdRow(), expectedThirdRowData, GENERIC_WRONG_FIRST_NAME);

        webTablesPage.clickEmailHeader();
        softAssert.assertEquals(webTablesPage.getFirstRow(), expectedThirdRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getSecondRow(), expectedSecondRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getThirdRow(), expectedFirstRowData, GENERIC_WRONG_FIRST_NAME);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Order users by salary")
    public void orderTableBySalaryAscendingAndDescending() {
        // Arrange & Act
        webTablesPage.clickSalaryHeader();

        // Assert
        softAssert.assertEquals(webTablesPage.getFirstRow(), expectedThirdRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getSecondRow(), expectedSecondRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getThirdRow(), expectedFirstRowData, GENERIC_WRONG_FIRST_NAME);

        webTablesPage.clickSalaryHeader();

        softAssert.assertEquals(webTablesPage.getFirstRow(), expectedFirstRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getSecondRow(), expectedSecondRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getThirdRow(), expectedThirdRowData, GENERIC_WRONG_FIRST_NAME);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Order users by department")
    public void orderTableByDepartmentAscendingAndDescending() {
        // Arrange & Act
        webTablesPage.clickDepartmentHeader();

        // Assert
        softAssert.assertEquals(webTablesPage.getFirstRow(), expectedFirstRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getSecondRow(), expectedSecondRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getThirdRow(), expectedThirdRowData, GENERIC_WRONG_FIRST_NAME);

        webTablesPage.clickDepartmentHeader();

        softAssert.assertEquals(webTablesPage.getFirstRow(), expectedThirdRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getSecondRow(), expectedSecondRowData, GENERIC_WRONG_FIRST_NAME);
        softAssert.assertEquals(webTablesPage.getThirdRow(), expectedFirstRowData, GENERIC_WRONG_FIRST_NAME);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select all rows per page")
    public void selectAllRowsPerPage() {
        // Arrange & Act
        webTablesPage.clickRowPerPage(ROWS_5);
        softAssert.assertEquals(webTablesPage.getCountOfLines(), 5, GENERIC_EXPECTED_ROWS_5);

        webTablesPage.clickRowPerPage(ROWS_10);
        softAssert.assertEquals(webTablesPage.getCountOfLines(), 10, GENERIC_EXPECTED_ROWS_10);

        webTablesPage.clickRowPerPage(ROWS_20);
        softAssert.assertEquals(webTablesPage.getCountOfLines(), 20, GENERIC_EXPECTED_ROWS_20);

        webTablesPage.clickRowPerPage(ROWS_25);
        softAssert.assertEquals(webTablesPage.getCountOfLines(), 25, GENERIC_EXPECTED_ROWS_25);

        webTablesPage.clickRowPerPage(ROWS_50);
        softAssert.assertEquals(webTablesPage.getCountOfLines(), 50, GENERIC_EXPECTED_ROWS_50);

        webTablesPage.clickRowPerPage(ROWS_100);
        softAssert.assertEquals(webTablesPage.getCountOfLines(), 100, GENERIC_EXPECTED_ROWS_100);

        // Assert
        softAssert.assertAll();
    }
}
