package part3_4.comdemoqa.tests.part3.javascript.elements;

import com.pages.demo.pages.elements.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class WebTablePageTests extends BaseTest {

    @Test
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

    @Test
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

    @Test
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

    @Test
    public void DeleteThreeRows() {
        String email1 = "cierra@example.com";
        String email2 = "kierra@example.com";
        String email3 = "alden@example.com";

        WebTablesPage webTablePage = homePage.goToElements().clickWebTables();
        webTablePage.clickDelete(email1);
        webTablePage.clickDelete(email2);
        webTablePage.clickDelete(email3);
        
        //TODO
    }

    @Test
    public void AddNewRow() {
        String firstName = "Zhivko";
        String lastName = "Kamenov";
        String email = "Zhivko@example.com";
        String age = "37";
        String salary = "2500";
        String department = "QA";

        WebTablesPage webTablePage = homePage.goToElements().clickWebTables();
        webTablePage.clickAddNewRecordButton();
        webTablePage.setFirstName(firstName);
        webTablePage.setLastName(lastName);
        webTablePage.setEmail(email);
        webTablePage.setAge(age);
        webTablePage.setSalary(salary);
        webTablePage.setDepartment(department);
        webTablePage.clickSubmitButton();

        String actualFirstName = webTablePage.getTableFirstName(email);
        String actualLastName = webTablePage.getTableLastName(email);
        String actualEmail = webTablePage.getTableEmail(email);
        String actualAge = webTablePage.getTableAge(email);
        String actualSalary = webTablePage.getTableSalary(email);
        String actualDepartment = webTablePage.getTableDepartment(email);

        Assert.assertEquals(actualFirstName, firstName, "Wrong first name");
        Assert.assertEquals(actualLastName, lastName, "Wrong last name");
        Assert.assertEquals(actualEmail, email, "Wrong email");
        Assert.assertEquals(actualAge, age, "Wrong age");
        Assert.assertEquals(actualSalary, salary, "Wrong salary");
        Assert.assertEquals(actualDepartment, department, "Wrong department");
    }
}
