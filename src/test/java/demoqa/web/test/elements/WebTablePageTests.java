package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTablePageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        navigateToUrl("webtables");

        String expectedHeader = "Web Tables";
        String expectedButtonAddText = "Add";
        String buttonNextText = "Next";
        String buttonPreviousText = "Previous";
        String pageJump = "1";
        String expectedPageInfo = "Page of 1";
        String expected10rows = "10 rows";
        int expectedRows = 10;
        String tableHeader = """
                First Name
                Last Name
                Age
                Email
                Salary
                Department
                Action""";
        String expectedTableHeader = """
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
        String searchBoxText = "Type to search";

        String actualTableHeader = webTablesPage.getTableHeader();
        String header = webTablesPage.getHeader();
        String buttonAddText = webTablesPage.getButtonAddText();
        String actualButtonNextText = webTablesPage.getButtonNextText();
        String actualButtonPreviousText = webTablesPage.getButtonPreviousText();
        String actualPageJump = webTablesPage.getPageJump();
        String actualPageInfo = webTablesPage.getPageInfo();
        webTablesPage.clickRowPerPage(expected10rows);
        int actualCountOfLines = webTablesPage.getCountOfLines();
        String actualTableData = webTablesPage.getTableData();
        String actualSearchBoxPlaceholder = webTablesPage.getSearchBoxPlaceholder();

        softAssert.assertEquals(header, expectedHeader, "\nWrong header value.\n");
        softAssert.assertEquals(buttonAddText, expectedButtonAddText, "\nExpected add button.\n");
        softAssert.assertEquals(actualButtonNextText, buttonNextText, "\nExpected next button.\n");
        softAssert.assertEquals(actualButtonPreviousText, buttonPreviousText, "\nExpected previous button.\n");
        softAssert.assertEquals(actualPageJump, pageJump, "\nPage jump do not match.\n");
        softAssert.assertEquals(actualPageInfo, expectedPageInfo, "\nPage info do not match.\n");
        softAssert.assertEquals(actualCountOfLines, expectedRows, "\nExpected 10 rows.\n");
        softAssert.assertEquals(actualTableHeader, tableHeader, "\nActual table header do not match.\n");
        softAssert.assertEquals(actualTableData, expectedTableHeader, "Actual table data do not match.\n");
        softAssert.assertEquals(actualSearchBoxPlaceholder, searchBoxText, "Actual table data do not match.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify all label and place holders on registration form")
    public void VerifyAllLabelAndPlaceHoldersOnRegistrationForm() {
        navigateToUrl("webtables");

        String expectedRegistrationFormText = "Registration Form";
        String expectedFirstNameLabel = "First Name";
        String expectedFirstNamePlaceholder = "First Name";
        String expectedLastNameLabel = "Last Name";
        String expectedPlaceholderLastName = "Last Name";
        String expectedEmailLabel = "Email";
        String expectedPlaceholderEmail = "name@example.com";
        String expectedAgeLabel = "Age";
        String expectedPlaceholderAge = "Age";
        String expectedSalaryLabel = "Salary";
        String expectedPlaceholderSalary = "Salary";
        String expectedDepartmentLabel = "Department";
        String expectedPlaceholderDepartment = "Department";
        String expectedSubmitButtonText = "Submit";

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

        softAssert.assertEquals(actualRegistrationText, expectedRegistrationFormText, "\nWrong registration name text.\n");
        softAssert.assertEquals(actualFirstNameLabel, expectedFirstNameLabel, "\nNot first name label.\n");
        softAssert.assertEquals(actualLastNameLabel, expectedLastNameLabel, "Not second name label.\n");
        softAssert.assertEquals(actualEmailLabel, expectedEmailLabel, "\nNot email label.\n");
        softAssert.assertEquals(actualAgeLabel, expectedAgeLabel, "\nNot age label.\n");
        softAssert.assertEquals(actualSalaryLabel, expectedSalaryLabel, "\nNot salary label.\n");
        softAssert.assertEquals(actualDepartmentLabel, expectedDepartmentLabel, "\nNot department label.\n");
        softAssert.assertEquals(actualPlaceholderFirstName, expectedFirstNamePlaceholder, "\nNot first name label.\n");
        softAssert.assertEquals(actualPlaceholderLastName, expectedPlaceholderLastName, "\nNot second name label.\n");
        softAssert.assertEquals(actualPlaceholderEmail, expectedPlaceholderEmail, "\nNot email label.\n");
        softAssert.assertEquals(actualPlaceholderAge, expectedPlaceholderAge, "\nNot age label.\n");
        softAssert.assertEquals(actualPlaceholderSalary, expectedPlaceholderSalary, "\nNot salary label.\n");
        softAssert.assertEquals(actualPlaceholderDepartment, expectedPlaceholderDepartment, "\nNot department label.\n");
        softAssert.assertEquals(actualSubmitButtonText, expectedSubmitButtonText, "\nNot submit button text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Update first name on first user")
    public void UpdateFirstNameOnFirstUser() {
        navigateToUrl("webtables");
        String email = "cierra@example.com";
        String expectedFirstName = "Zhivko";

        webTablesPage.clickEdit(email);
        webTablesPage.setFirstName(expectedFirstName);
        webTablesPage.clickSubmitButton();

        String actualFirstName = webTablesPage.getTableFirstName(email);

        Assert.assertEquals(actualFirstName, expectedFirstName, "\n Actual & Expected FirstName Do Not Match.\n");
    }

    @Test(enabled = true, testName = "Update last name on first user")
    public void UpdateLastNameOnFirstUser() {
        navigateToUrl("webtables");
        String email = "cierra@example.com";
        String expectedLastName = "Petrov";

        webTablesPage.clickEdit(email);
        webTablesPage.setLastName(expectedLastName);
        webTablesPage.clickSubmitButton();

        String actualLastName = webTablesPage.getTableLastName(email);

        Assert.assertEquals(actualLastName, expectedLastName, "\n Actual & Expected LastName Do Not Match.\n");
    }

    @Test(enabled = true, testName = "Update email on first user")
    public void UpdateEmailOnFirstUser() {
        navigateToUrl("webtables");
        String oldEmail = "cierra@example.com";
        String newEmail = "da@abv.bg";

        webTablesPage.clickEdit(oldEmail);
        webTablesPage.setEmail(newEmail);
        webTablesPage.clickSubmitButton();
        String actualEmail = webTablesPage.getTableEmail(newEmail);

        Assert.assertEquals(actualEmail, newEmail, "\n Actual & Expected Email Do Not Match \n");
    }

    @Test(enabled = true, testName = "Update age on first user")
    public void UpdateAgeOnFirstUser() {
        navigateToUrl("webtables");
        String oldEmail = "cierra@example.com";
        String newEmail = "da@abv.bg";

        webTablesPage.clickEdit(oldEmail);
        webTablesPage.setEmail(newEmail);
        webTablesPage.clickSubmitButton();
        String actualEmail = webTablesPage.getTableEmail(newEmail);

        Assert.assertEquals(actualEmail, newEmail, "\n Actual & Expected Email Do Not Match \n");
    }

    @Test(enabled = true, testName = "Update salary on first user")
    public void UpdateSalaryOnFirstUser() {
        navigateToUrl("webtables");
        String oldEmail = "cierra@example.com";
        String expectedSalary = "2000";

        webTablesPage.clickEdit(oldEmail);
        webTablesPage.setSalary(expectedSalary);
        webTablesPage.clickSubmitButton();
        String actualSalary = webTablesPage.getTableEmail(expectedSalary);

        Assert.assertEquals(actualSalary, expectedSalary, "\n Actual & Expected Salary Do Not Match.\n");
    }

    @Test(enabled = true, testName = "Update department on first user")
    public void UpdateDepartmentOnFirstUser() {
        navigateToUrl("webtables");
        String oldEmail = "cierra@example.com";
        String expectedDepartment = "Home";

        webTablesPage.clickEdit(oldEmail);
        webTablesPage.setDepartment(expectedDepartment);
        webTablesPage.clickSubmitButton();
        String actualDepartment = webTablesPage.getTableEmail(expectedDepartment);

        Assert.assertEquals(actualDepartment, expectedDepartment, "\n Actual & Expected Department Do Not Match \n");
    }

    @Test(enabled = true, testName = "Delete default three rows")
    public void DeleteDefaultThreeRows() {
        navigateToUrl("webtables");

        String email1 = "cierra@example.com";
        String email2 = "kierra@example.com";
        String email3 = "alden@example.com";

        webTablesPage.clickDeleteByEmail(email1);
        webTablesPage.clickDeleteByEmail(email2);
        webTablesPage.clickDeleteByEmail(email3);

        String expectedResult = webTablesPage.getNoRowsFound();

        Assert.assertEquals(expectedResult, "No rows found", "\nMissing message\n");
    }

    @Test(enabled = true, testName = "Add new user")
    public void AddNewUser() {
        navigateToUrl("webtables");

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
        String actualEmail = webTablesPage.getTableEmail(expectedEmail);
        String actualAge = webTablesPage.getTableAge(expectedEmail);
        String actualSalary = webTablesPage.getTableSalary(expectedEmail);
        String actualDepartment = webTablesPage.getTableDepartment(expectedEmail);

        softAssert.assertEquals(actualFirstName, expectedFirstName, "\nWrong first name.\n");
        softAssert.assertEquals(actualLastName, expectedLastName, "\nWrong last name.\n");
        softAssert.assertEquals(actualAge, expectedAge, "\nWrong age.\n");
        softAssert.assertEquals(actualEmail, expectedEmail, "\nWrong email.\n");
        softAssert.assertEquals(actualSalary, expectedSalary, "\nWrong salary.\n");
        softAssert.assertEquals(actualDepartment, expectedDepartment, "\nWrong department.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify previous and next buttons active")
    public void VerifyPreviousAndNextButtonsActive() {
        navigateToUrl("webtables");

        String expectedFirstName = "Zhivko";
        String lastName = "Kamenov";
        String email = "Zhivko@example.com";
        String age = "37";
        String salary = "2500";
        String department = "QA";

        softAssert.assertFalse(webTablesPage.checkNextButtonIsActive(), "\nActive Next button.\n");

        String expected5rows = "5 rows";
        webTablesPage.clickRowPerPage(expected5rows);
        for (int i = 0; i < 3; i++) {
            webTablesPage.clickAddButton();
            webTablesPage.setFirstName(expectedFirstName);
            webTablesPage.setLastName(lastName);
            webTablesPage.setEmail(email);
            webTablesPage.setAge(age);
            webTablesPage.setSalary(salary);
            webTablesPage.setDepartment(department);
            webTablesPage.clickSubmitButton();
        }

        String pageJump = "1";
        String actualPageJump = webTablesPage.getPageJump();
        softAssert.assertEquals(actualPageJump, pageJump, "\nPage jump do not match.\n");

        String pageInfo = "Page of 2";
        String actualPageInfo = webTablesPage.getPageInfo();
        softAssert.assertEquals(actualPageInfo, pageInfo, "\nPage info do not match.\n");

        Assert.assertTrue(webTablesPage.checkNextButtonIsActive(), "\nNot active Next button.\n");
        webTablesPage.clickNexButton();
        softAssert.assertTrue(webTablesPage.checkPreviousButtonIsActive(), "\nNot active Previous button.\n");

        pageJump = "2";
        actualPageJump = webTablesPage.getPageJump();
        softAssert.assertEquals(actualPageJump, pageJump, "\nPage jump do not match.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify previous and next button are not active after load page")
    public void VerifyPreviousAndNextButtonAreNotActiveAfterLoadPage() {
        navigateToUrl("webtables");

        softAssert.assertFalse(webTablesPage.checkPreviousButtonIsActive(), "\nNot active Previous button.\n");
        softAssert.assertFalse(webTablesPage.checkNextButtonIsActive(), "\nNot active Next button.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Search with no existing category and check results")
    public void SearchWithNoExistingCategoryAndCheckResults() {
        navigateToUrl("webtables");

        String expectedResult = "No rows found";
        String searchedWord = "karma";
        webTablesPage.searchWithWord(searchedWord);
        String actualResult = webTablesPage.getNoRowsFound();

        Assert.assertEquals(actualResult, expectedResult, "\nMissing message.\n");
    }

    @Test(enabled = true, testName = "Search with existing category and check results")
    public void SearchWithExistingCategoryAndCheckResults() {
        navigateToUrl("webtables");

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

    @Test(enabled = true, testName = "Submit empty form and verify all red lines")
    public void SubmitEmptyFormAndVerifyAllRedLines() {
        navigateToUrl("webtables");
        String redColor = "1px solid rgb(220, 53, 69)";

        webTablesPage.clickAddButton();
        webTablesPage.clickSubmitButton();

        boolean isAllBordersRed = webTablesPage.isAllBordersRed(redColor);

        Assert.assertTrue(isAllBordersRed);
    }

    @Test(enabled = true, testName = "Select all rows per page")
    public void SelectAllRowsPerPage() {
        navigateToUrl("webtables");
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

    @Test(enabled = true, testName = "Verify border color change from red to green after add")
    public void VerifyColorsChangeFromRedToGreenAfterAdd() {
        navigateToUrl("webtables");
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
}
