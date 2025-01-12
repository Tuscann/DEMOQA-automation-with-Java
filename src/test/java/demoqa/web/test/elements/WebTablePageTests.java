package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTablePageTests extends BaseTest {

    @Test(enabled = true)
    public void VerifyAllTextOnPage() {
        navigateToUrl("webtables");

        String expectedHeader = "Web Tables";
        String expectedButtonAddText = "Add";
        String buttonNextText = "Next";
        String buttonPreviousText = "Previous";
        String pageJump = "1";
        String expectedPageInfo = "Page of 1";
        String expected10rows = "10 rows";
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
        int countOfLines = webTablesPage.getCountOfLines();
        String actualTableData = webTablesPage.getTableData();
        String actualSearchBoxPlaceholder = webTablesPage.getSearchBoxPlaceholder();

        Assert.assertEquals(header, expectedHeader, "\nWrong header value.\n");
        Assert.assertEquals(buttonAddText, expectedButtonAddText, "\nExpected add button.\n");
        Assert.assertEquals(actualButtonNextText, buttonNextText, "\nExpected next button.\n");
        Assert.assertEquals(actualButtonPreviousText, buttonPreviousText, "\nExpected previous button.\n");
        Assert.assertEquals(actualPageJump, pageJump, "\nPage jump do not match.\n");
        Assert.assertEquals(actualPageInfo, expectedPageInfo, "\nPage info do not match.\n");
        Assert.assertEquals(countOfLines, 10, "\nExpected 10 rows.\n");
        Assert.assertEquals(actualTableHeader, tableHeader, "\nActual table header do not match.\n");
        Assert.assertEquals(actualTableData, expectedTableHeader, "Actual table data do not match.\n");
        Assert.assertEquals(actualSearchBoxPlaceholder, searchBoxText, "Actual table data do not match.\n");
    }

    @Test(enabled = true)
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

        Assert.assertEquals(actualRegistrationText, expectedRegistrationFormText, "\nWrong registration name text.\n");
        Assert.assertEquals(actualFirstNameLabel, expectedFirstNameLabel, "\nNot first name label.\n");
        Assert.assertEquals(actualLastNameLabel, expectedLastNameLabel, "Not second name label.\n");
        Assert.assertEquals(actualEmailLabel, expectedEmailLabel, "\nNot email label.\n");
        Assert.assertEquals(actualAgeLabel, expectedAgeLabel, "\nNot age label.\n");
        Assert.assertEquals(actualSalaryLabel, expectedSalaryLabel, "\nNot salary label.\n");
        Assert.assertEquals(actualDepartmentLabel, expectedDepartmentLabel, "\nNot department label.\n");
        Assert.assertEquals(actualPlaceholderFirstName, expectedFirstNamePlaceholder, "\nNot first name label.\n");
        Assert.assertEquals(actualPlaceholderLastName, expectedPlaceholderLastName, "\nNot second name label.\n");
        Assert.assertEquals(actualPlaceholderEmail, expectedPlaceholderEmail, "\nNot email label.\n");
        Assert.assertEquals(actualPlaceholderAge, expectedPlaceholderAge, "\nNot age label.\n");
        Assert.assertEquals(actualPlaceholderSalary, expectedPlaceholderSalary, "\nNot salary label.\n");
        Assert.assertEquals(actualPlaceholderDepartment, expectedPlaceholderDepartment, "\nNot department label.\n");
        Assert.assertEquals(actualSubmitButtonText, expectedSubmitButtonText, "\nNot submit button text.\n");
    }

    @Test(enabled = true)
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

    @Test(enabled = true)
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

    @Test(enabled = true)
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

    @Test(enabled = true)
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

    @Test(enabled = true)
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

    @Test(enabled = true)
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

    @Test(enabled = true)
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

    @Test(enabled = true)
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

        Assert.assertEquals(actualFirstName, expectedFirstName, "\nWrong first name.\n");
        Assert.assertEquals(actualLastName, expectedLastName, "\nWrong last name.\n");
        Assert.assertEquals(actualAge, expectedAge, "\nWrong age.\n");
        Assert.assertEquals(actualEmail, expectedEmail, "\nWrong email.\n");
        Assert.assertEquals(actualSalary, expectedSalary, "\nWrong salary.\n");
        Assert.assertEquals(actualDepartment, expectedDepartment, "\nWrong department.\n");
    }

    @Test(enabled = true)
    public void VerifyPreviousAndNextButtonsActive() {
        navigateToUrl("webtables");

        String expectedFirstName = "Zhivko";
        String lastName = "Kamenov";
        String email = "Zhivko@example.com";
        String age = "37";
        String salary = "2500";
        String department = "QA";

        Assert.assertFalse(webTablesPage.checkNextButtonIsActive(), "\nActive Next button.\n");

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
        Assert.assertEquals(actualPageJump, pageJump, "\nPage jump do not match.\n");

        String pageInfo = "Page of 2";
        String actualPageInfo = webTablesPage.getPageInfo();
        Assert.assertEquals(actualPageInfo, pageInfo, "\nPage info do not match.\n");

        Assert.assertTrue(webTablesPage.checkNextButtonIsActive(), "\nNot active Next button.\n");
        webTablesPage.clickNexButton();
        Assert.assertTrue(webTablesPage.checkPreviousButtonIsActive(), "\nNot active Previous button.\n");

        pageJump = "2";
        actualPageJump = webTablesPage.getPageJump();
        Assert.assertEquals(actualPageJump, pageJump, "\nPage jump do not match.\n");
    }

    @Test(enabled = true)
    public void VerifyPreviousAndNextButtonAreNotActiveAfterLoadPage() {
        navigateToUrl("webtables");

        Assert.assertFalse(webTablesPage.checkPreviousButtonIsActive(), "\nNot active Previous button.\n");
        Assert.assertFalse(webTablesPage.checkNextButtonIsActive(), "\nNot active Next button.\n");
    }

    @Test(enabled = true)
    public void SearchWithNoExistingCategoryAndCheckResults() {
        navigateToUrl("webtables");

        String expectedResult = "No rows found";
        String searchedWord = "karma";
        webTablesPage.searchWithWord(searchedWord);
        String actualResult = webTablesPage.getNoRowsFound();

        Assert.assertEquals(actualResult, expectedResult, "\nMissing message.\n");
    }

    @Test(enabled = true)
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

        Assert.assertEquals(actualFirstName, expectedFirstName, "\nWrong first name.\n");
        Assert.assertEquals(actualLastName, expectedLastName, "\nWrong last name.\n");
        Assert.assertEquals(actualAge, expectedAge, "\nWrong age.\n");
        Assert.assertEquals(actualEmail, expectedEmail, "\nWrong email.\n");
        Assert.assertEquals(actualSalary, expectedSalary, "\nWrong salary.\n");
        Assert.assertEquals(actualDepartment, searchedWord, "\nWrong department.\n");
    }

    @Test(enabled = true)
    public void SubmitEmptyFormAndVerifyAllRedLines() {
        navigateToUrl("webtables");
        String redColor = "1px solid rgb(220, 53, 69)";

        webTablesPage.clickAddButton();
        webTablesPage.clickSubmitButton();

        boolean isAllBordersRed = webTablesPage.isAllBordersRed(redColor);

        Assert.assertTrue(isAllBordersRed);
    }

    @Test(enabled = true)
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
        Assert.assertEquals(countOfLines, 5, "\nExpected 5 rows.\n");

        webTablesPage.clickRowPerPage(expected10rows);
        countOfLines = webTablesPage.getCountOfLines();
        Assert.assertEquals(countOfLines, 10, "\nExpected 10 rows.\n");

        webTablesPage.clickRowPerPage(expected20rows);
        countOfLines = webTablesPage.getCountOfLines();
        Assert.assertEquals(countOfLines, 20, "\nExpected 20 rows.\n");

        webTablesPage.clickRowPerPage(expected25rows);
        countOfLines = webTablesPage.getCountOfLines();
        Assert.assertEquals(countOfLines, 25, "\nExpected 25 rows.\n");

        webTablesPage.clickRowPerPage(expected50rows);
        countOfLines = webTablesPage.getCountOfLines();
        Assert.assertEquals(countOfLines, 50, "\nExpected 50 rows.\n");

        webTablesPage.clickRowPerPage(expected100rows);
        countOfLines = webTablesPage.getCountOfLines();
        Assert.assertEquals(countOfLines, 100, "\nExpected 100 rows.\n");
    }

    @Test(enabled = true)
    public void VerifyColorsChangeFromRedToGreen() {
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
        Assert.assertEquals(actualFirstNameBorderColorBefore, expectedRedColor, "\nWrong color expected red.\n");
        webTablesPage.setFirstName(expectedFirstName);
        Assert.assertTrue(webTablesPage.isFirstNameBorderColorGreen(expectedGreenColor));

        String actualLastNameBorderColorBefore = webTablesPage.getLastNameBorderColor();
        Assert.assertEquals(actualLastNameBorderColorBefore, expectedRedColor, "\nWrong color expected red.\n");
        webTablesPage.setLastName(expectedLastName);
        Assert.assertTrue(webTablesPage.isLastNameBorderColorGreen(expectedGreenColor));

        String actualEmailColorBefore = webTablesPage.getEmailBorderColor();
        Assert.assertEquals(actualEmailColorBefore, expectedRedColor, "\nWrong color expected red.\n");
        webTablesPage.setEmail(expectedEmail);
        Assert.assertTrue(webTablesPage.isEmailBorderColorGreen(expectedGreenColor));

        String actualAgeColorBefore = webTablesPage.getAgeBorderColor();
        Assert.assertEquals(actualAgeColorBefore, expectedRedColor, "\nWrong color expected red.\n");
        webTablesPage.setAge(expectedAge);
        Assert.assertTrue(webTablesPage.isAgeBorderColorGreen(expectedGreenColor));

        String actualSalaryColorBefore = webTablesPage.getSalaryBorderColor();
        Assert.assertEquals(actualSalaryColorBefore, expectedRedColor, "\nWrong color expected red.\n");
        webTablesPage.setSalary(expectedSalary);
        Assert.assertTrue(webTablesPage.isSalaryBorderColorGreen(expectedGreenColor));

        String actualDepartmentColorBefore = webTablesPage.getDepartmentBorderColor();
        Assert.assertEquals(actualDepartmentColorBefore, expectedRedColor, "\n Wrong color expected red\n");
        webTablesPage.setDepartment(expectedDepartment);
        Assert.assertTrue(webTablesPage.isDepartmentBorderColorGreen(expectedGreenColor));

        webTablesPage.clickSubmitButton();
    }
}
