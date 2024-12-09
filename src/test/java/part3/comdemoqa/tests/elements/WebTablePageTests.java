package part3.comdemoqa.tests.elements;

import com.pages.demo.pages.elements.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

@Test
public class WebTablePageTests extends BaseTest {

    public void UpdateAge() {
        String email = "kierra@example.com";
        String expectedAge = "34";

        WebTablesPage webTablePage = homePage.goToElements().clickWebTables();

        webTablePage.clickEdit(email);
        webTablePage.setAge("34");
        webTablePage.clickSubmitButton();
        String actualAge = webTablePage.getTableAge(email);
        Assert.assertEquals(actualAge, expectedAge,
                "\n Actual & Expected Ages Do Not Match \n");
    }

    public void UpdateFirstNameAndLastName() {
        String email = "cierra@example.com";
        String expectedFirstName = "Zhivko";
        String expectedLastName = "Petrov";

        WebTablesPage webTablePage = homePage.goToElements().clickWebTables();
        webTablePage.clickEdit(email);
        webTablePage.setFirstName(expectedFirstName);
        webTablePage.setLastName(expectedLastName);
        webTablePage.clickSubmitButton();
        String actualFirstName = webTablePage.getTableFirstName(email);
        String actualLastName = webTablePage.getTableLastName(email);
        Assert.assertEquals(actualFirstName, expectedFirstName,
                "\n Actual & Expected FirstName Do Not Match \n");
        Assert.assertEquals(actualLastName, expectedLastName,
                "\n Actual & Expected LastName Do Not Match \n");
    }

    public void UpdateEmail() {
        String email = "cierra@example.com";

        WebTablesPage webTablePage = homePage.goToElements().clickWebTables();
        webTablePage.clickEdit(email);

        String expectedEmail = "da@abv.bg";
        webTablePage.setEmail(expectedEmail);

        webTablePage.clickSubmitButton();
        String actualEmail = webTablePage.getTableEmail(expectedEmail);

        Assert.assertEquals(actualEmail, expectedEmail, "\n Actual & Expected Email Do Not Match \n");
    }

    public void DeleteDefaultThreeRows() {
        String email1 = "cierra@example.com";
        String email2 = "kierra@example.com";
        String email3 = "alden@example.com";

        WebTablesPage webTablePage = homePage.goToElements().clickWebTables();
        webTablePage.clickDeleteByEmail(email1);
        webTablePage.clickDeleteByEmail(email2);
        webTablePage.clickDeleteByEmail(email3);

        String expectedResult = webTablePage.getNoRowsFound();

        Assert.assertEquals(expectedResult, "No rows found", "Missing message");
    }

    public void AddNewRow() {
        String expectedEmail = "Zhivko@example.com";
        String expectedFirstName = "Zhivko";
        String expectedLastName = "Petrov";
        String expectedAge = "37";
        String expectedSalary = "2000";
        String expectedDepartment = "Home";

        WebTablesPage webTablePage = homePage.goToElements().clickWebTables();

        webTablePage.clickAddNewRecordButton();

        webTablePage.setAge(expectedAge);
        webTablePage.setFirstName(expectedFirstName);
        webTablePage.setLastName(expectedLastName);
        webTablePage.setEmail(expectedEmail);
        webTablePage.setSalary(expectedSalary);
        webTablePage.setDepartment(expectedDepartment);
        webTablePage.clickSubmitButton();

        String actualFirstName = webTablePage.getTableFirstName(expectedEmail);
        String actualLastName = webTablePage.getTableLastName(expectedEmail);
        String actualEmail = webTablePage.getTableEmail(expectedEmail);
        String actualAge = webTablePage.getTableAge(expectedEmail);
        String actualSalary = webTablePage.getTableSalary(expectedEmail);
        String actualDepartment = webTablePage.getTableDepartment(expectedEmail);

        Assert.assertEquals(actualFirstName, expectedFirstName, "Wrong first name");
        Assert.assertEquals(actualLastName, expectedLastName, "Wrong last name");
        Assert.assertEquals(actualAge, expectedAge, "Wrong age");
        Assert.assertEquals(actualEmail, expectedEmail, "Wrong email");
        Assert.assertEquals(actualSalary, expectedSalary, "Wrong salary");
        Assert.assertEquals(actualDepartment, expectedDepartment, "Wrong department");
    }

    public void CheckNextButtonActive() {
        String expectedFirstName = "Zhivko";
        String lastName = "Kamenov";
        String email = "Zhivko@example.com";
        String age = "37";
        String salary = "2500";
        String department = "QA";

        WebTablesPage webTablePage = homePage.goToElements().clickWebTables();

        for (int i = 0; i < 8; i++) {
            webTablePage.clickAddNewRecordButton();
            webTablePage.setFirstName(expectedFirstName + i);
            webTablePage.setLastName(lastName);
            webTablePage.setEmail(email);
            webTablePage.setAge(age);
            webTablePage.setSalary(salary);
            webTablePage.setDepartment(department);
            webTablePage.clickSubmitButton();
        }
        Assert.assertTrue(webTablePage.checkNextButtonIsActive(), "Not active Next button");
    }

    public void CheckPreviousAndNextButtonAreNotActive() {
        WebTablesPage webTablePage = homePage.goToElements().clickWebTables();

        Assert.assertFalse(webTablePage.checkPreviousButtonIsActive(), "Not active Previous button");
        Assert.assertFalse(webTablePage.checkNextButtonIsActive(), "Not active Next button");
    }
}
