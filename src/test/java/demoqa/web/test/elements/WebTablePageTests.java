package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTablePageTests extends BaseTest {

    @Test
    public void CheckAllLabelAndPlaceHoldersOnRegistrationForm() {
        navigateToUrl("webtables");

        String expectedRegistrationFormText = "Registration Form";
        String expectedFirstNameLabel = "First Name";
        String expectedPlaceholderFirstName = "First Name";
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
        String actualFirstNameLabel = webTablesPage.getFirstNamLabel();
        String actualPlaceholderFirstName = webTablesPage.getPlaceholderFirstName();
        String actualLastNameLabel = webTablesPage.getLastNameLabel();
        String actualPlaceholderLastName = webTablesPage.getPlaceholderLastName();
        String actualEmailLabel = webTablesPage.getEmailLabel();
        String actualPlaceholderEmail = webTablesPage.getPlaceholderUserEmail();
        String actualAgeLabel = webTablesPage.getAgeLabel();
        String actualPlaceholderAge = webTablesPage.getAgePlaceholder();
        String actualSalaryLabel = webTablesPage.getSalaryLabel();
        String actualPlaceholderSalary = webTablesPage.getSalaryPlaceholder();
        String actualDepartmentLabel = webTablesPage.getDepartmentLabel();
        String actualPlaceholderDepartment = webTablesPage.getDepartmentPlaceholder();
        String actualSubmitButtonText = webTablesPage.getSubmitButtonText();

        Assert.assertEquals(actualRegistrationText, expectedRegistrationFormText, "\nWrong registration name text");
        Assert.assertEquals(actualFirstNameLabel, expectedFirstNameLabel, "\nNot first name label");
        Assert.assertEquals(actualLastNameLabel, expectedLastNameLabel, "Not second name label");
        Assert.assertEquals(actualEmailLabel, expectedEmailLabel, "Not email label");
        Assert.assertEquals(actualAgeLabel, expectedAgeLabel, "Not age label");
        Assert.assertEquals(actualSalaryLabel, expectedSalaryLabel, "Not salary label");
        Assert.assertEquals(actualDepartmentLabel, expectedDepartmentLabel, "Not department label");
        Assert.assertEquals(actualPlaceholderFirstName, expectedPlaceholderFirstName, "Not first name label");
        Assert.assertEquals(actualPlaceholderLastName, expectedPlaceholderLastName, "Not second name label");
        Assert.assertEquals(actualPlaceholderEmail, expectedPlaceholderEmail, "Not email label");
        Assert.assertEquals(actualPlaceholderAge, expectedPlaceholderAge, "Not age label");
        Assert.assertEquals(actualPlaceholderSalary, expectedPlaceholderSalary, "Not salary label");
        Assert.assertEquals(actualPlaceholderDepartment, expectedPlaceholderDepartment, "Not department label");
        Assert.assertEquals(actualSubmitButtonText, expectedSubmitButtonText, "Not submit button text");
    }

    @Test
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

    @Test
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

    @Test
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

    @Test
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

    @Test
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

    @Test
    public void VerifyPreviousAndNextButtonsActive() {
        navigateToUrl("webtables");

        String expectedFirstName = "Zhivko";
        String lastName = "Kamenov";
        String email = "Zhivko@example.com";
        String age = "37";
        String salary = "2500";
        String department = "QA";

        Assert.assertFalse(webTablesPage.checkNextButtonIsActive(), "Active Next button");

        for (int i = 0; i < 8; i++) {
            webTablesPage.clickAddButton();
            webTablesPage.setFirstName(expectedFirstName);
            webTablesPage.setLastName(lastName);
            webTablesPage.setEmail(email);
            webTablesPage.setAge(age);
            webTablesPage.setSalary(salary);
            webTablesPage.setDepartment(department);
            webTablesPage.clickSubmitButton();
        }
        Assert.assertTrue(webTablesPage.checkNextButtonIsActive(), "Not active Next button");
        webTablesPage.clickNexButton();
        Assert.assertTrue(webTablesPage.checkPreviousButtonIsActive(), "\nNot active Previous button\n");
    }

    @Test
    public void VerifyPreviousAndNextButtonAreNotActiveAfterLoadPage() {
        navigateToUrl("webtables");

        Assert.assertFalse(webTablesPage.checkPreviousButtonIsActive(), "\nNot active Previous button.\n");
        Assert.assertFalse(webTablesPage.checkNextButtonIsActive(), "\nNot active Next button.\n");
    }

    @Test
    public void SearchWithNoExistingCategoryAndCheckResults() {
        navigateToUrl("webtables");

        String searchedWord = "karma";
        webTablesPage.searchWithWord(searchedWord);
        String expectedResult = webTablesPage.getNoRowsFound();

        Assert.assertEquals(expectedResult, "No rows found", "\nMissing message\n");
    }

    @Test
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

    @Test
    public void SubmitEmptyFormAndVerifyRedLine() {
        navigateToUrl("webtables");
        webTablesPage.clickAddButton();
        webTablesPage.clickSubmitButton();

        String redColor = "d rgb(220, 53, 69)";
        boolean isAllBordersRed = webTablesPage.isAllBordersRed(redColor);

        Assert.assertTrue(isAllBordersRed);
    }
}
