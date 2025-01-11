package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static demoqa.base.BasePage.delay;

public class WebTablePageTests extends BaseTest {

    @Test(enabled = true)
    public void VerifyAllTextOnPage() {
        navigateToUrl("webtables");

        String expectedHeader = "Web Tables";
        String header = webTablesPage.getHeader();
        Assert.assertEquals(header, expectedHeader, "Wrong header value");

        String expectedButtonAddText = "Add";
        String buttonAddText = webTablesPage.getButtonAddText();
        Assert.assertEquals(buttonAddText, expectedButtonAddText, "\nExpected add button\n");

        String buttonNextText = "Next";
        String actualButtonNextText = webTablesPage.getButtonNextText();
        Assert.assertEquals(actualButtonNextText, buttonNextText, "\nExpected next button\n");

        String buttonPreviousText = "Previous";
        String actualButtonPreviousText = webTablesPage.getButtonPreviousText();
        Assert.assertEquals(actualButtonPreviousText, buttonPreviousText, "\nExpected previous button\n");

        String pageJump = "1";
        String actualPageJump = webTablesPage.getPageJump();
        Assert.assertEquals(actualPageJump, pageJump, "\nPage jump do not match\n");

        String pageInfo = "Page of 1";
        String actualPageInfo = webTablesPage.getPageInfo();
        Assert.assertEquals(actualPageInfo, pageInfo, "\nPage info do not match\n");

        String expected10rows = "10 rows";
        webTablesPage.clickRowPerPage(expected10rows);
        int countOfLines = webTablesPage.getCountOfLines();
        Assert.assertEquals(countOfLines, 10, "Expected 10 rows");

        String tableHeader = """
                First Name
                Last Name
                Age
                Email
                Salary
                Department
                Action""";
        String actualTableHeader = webTablesPage.getTableHeader();
        Assert.assertEquals(actualTableHeader, tableHeader, "Actual table header do not match\n");

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
        String actualTableData = webTablesPage.getTableData();
        Assert.assertEquals(actualTableData, expectedTableHeader, "Actual table data do not match\n");

        String searchBoxText = "Type to search";
        String actualSearchBoxPlaceholder = webTablesPage.getSearchBoxPlaceholder();
        Assert.assertEquals(actualSearchBoxPlaceholder, searchBoxText, "Actual table data do not match\n");

    }

    @Test(enabled = true)
    public void CheckAllLabelAndPlaceHoldersOnRegistrationForm() {
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
        Assert.assertEquals(actualSalaryLabel, expectedSalaryLabel, "Not salary label");
        Assert.assertEquals(actualDepartmentLabel, expectedDepartmentLabel, "Not department label");
        Assert.assertEquals(actualPlaceholderFirstName, expectedFirstNamePlaceholder, "Not first name label");
        Assert.assertEquals(actualPlaceholderLastName, expectedPlaceholderLastName, "Not second name label");
        Assert.assertEquals(actualPlaceholderEmail, expectedPlaceholderEmail, "Not email label");
        Assert.assertEquals(actualPlaceholderAge, expectedPlaceholderAge, "Not age label");
        Assert.assertEquals(actualPlaceholderSalary, expectedPlaceholderSalary, "Not salary label");
        Assert.assertEquals(actualPlaceholderDepartment, expectedPlaceholderDepartment, "Not department label");
        Assert.assertEquals(actualSubmitButtonText, expectedSubmitButtonText, "Not submit button text");
    }

    @Test(enabled = true)
    public void UpdateFirstNameAndLastNameOnFirstUser() {
        navigateToUrl("webtables");
        String email = "cierra@example.com";
        String expectedFirstName = "Zhivko";
        String expectedLastName = "Petrov";

        webTablesPage.clickEdit(email);
        webTablesPage.setFirstName(expectedFirstName);
        webTablesPage.setLastName(expectedLastName);
        webTablesPage.clickSubmitButton();

        String actualFirstName = webTablesPage.getTableFirstName(email);
        String actualLastName = webTablesPage.getTableLastName(email);

        Assert.assertEquals(actualFirstName, expectedFirstName, "\n Actual & Expected FirstName Do Not Match \n");
        Assert.assertEquals(actualLastName, expectedLastName, "\n Actual & Expected LastName Do Not Match \n");
    }

    @Test(enabled = true)
    public void UpdateAgeOnFirstUser() {
        navigateToUrl("webtables");

        String expectedEmail = "kierra@example.com";
        String expectedAge = "34";

        webTablesPage.clickEdit(expectedEmail);
        webTablesPage.setAge(expectedAge);
        webTablesPage.clickSubmitButton();
        String actualAge = webTablesPage.getTableAge(expectedEmail);
        Assert.assertEquals(actualAge, expectedAge, "\n Actual & Expected Ages Do Not Match \n");
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
    public void AddNewRow() {
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

        Assert.assertEquals(actualFirstName, expectedFirstName, "\nWrong first name\n");
        Assert.assertEquals(actualLastName, expectedLastName, "\nWrong last name\n");
        Assert.assertEquals(actualAge, expectedAge, "\nWrong age");
        Assert.assertEquals(actualEmail, expectedEmail, "\nWrong email\n");
        Assert.assertEquals(actualSalary, expectedSalary, "\nWrong salary\n");
        Assert.assertEquals(actualDepartment, expectedDepartment, "\nWrong department\n");
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

        String searchedWord = "karma";
        webTablesPage.searchWithWord(searchedWord);
        String expectedResult = webTablesPage.getNoRowsFound();

        Assert.assertEquals(expectedResult, "No rows found", "\nMissing message.\n");
    }

    @Test(enabled = true)
    public void SearchWithExistingCategoryAndCheckResults() {
        navigateToUrl("webtables");

        String searchedWord = "Insurance";
        webTablesPage.searchWithWord(searchedWord);

        String expectedFirstName = "Cierra";
        String expectedLastName = "Vega";
        String expectedAge = "39";
        String expectedEmail = "cierra@example.com";
        String expectedSalary = "10000";

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
    public void SubmitEmptyFormAndVerifyRedLines() {
        navigateToUrl("webtables");
        webTablesPage.clickAddButton();
        webTablesPage.clickSubmitButton();

        String redColor = "d rgb(220, 53, 69)";
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
        delay(200); //TODO

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
