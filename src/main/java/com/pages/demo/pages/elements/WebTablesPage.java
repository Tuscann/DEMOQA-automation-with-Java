package com.pages.demo.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class WebTablesPage extends ElementsPage {

    private final By registrationAgeField = By.id("age");
    private final By registrationFirstNameField = By.id("firstName");
    private final By registrationLastNameField = By.id("lastName");
    private final By registrationEmailField = By.id("userEmail");
    private final By registrationSalaryField = By.id("salary");
    private final By registrationDepartmentField = By.id("department");
    private final By submitButton = By.id("submit");
    private final By addNewRecordButton = By.id("addNewRecordButton");
    private final By searchBox = By.id("searchBox");
    private final By nextButton = By.xpath("//button[contains(.,'Next')]");
    private final By previousButton = By.xpath("//button[contains(.,'Previous')]");
    private final By deleteButton = By.xpath("//div[@class='rt-td'][contains(.,'alden@example.com')]");


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    public void clickEdit(String email) {
        By edit = By.xpath("//div[text()='" + email + "']//following::span[@title='Edit']");
        wait.until(ExpectedConditions.elementToBeClickable(edit));

        scrollToElementJS(edit);
        click(edit);
    }

    public void clickAddNewRecordButton() {
        click(addNewRecordButton);
    }

    public void clickDelete(String email) {
        By delete = By.xpath("//div[text()='" + email + "']//following::span[@title='Delete']");
        click(delete);
    }

    public void setAge(String age) {
        set(registrationAgeField, age);
    }

    public void setFirstName(String name) {
        set(registrationFirstNameField, name);
    }

    public void setEmail(String email) {
        set(registrationEmailField, email);
    }

    public void setSalary(String salary) {
        set(registrationSalaryField, salary);
    }

    public void setDepartment(String department) {
        set(registrationDepartmentField, department);
    }

    public void setLastName(String name) {
        set(registrationLastNameField, name);
    }

    public void clickSubmitButton() {
        delay(200); //TODO
        click(submitButton);
    }

    public String getTableAge(String email) {
        By tableAge = By.xpath("//div[text()='" + email + "']//preceding::div[1]");
        return find(tableAge).getText();
    }

    public String getTableFirstName(String email) {
        By tableFirstName = By.xpath("//div[text()='" + email + "']//preceding::div[3]");
        return find(tableFirstName).getText();
    }

    public String getTableLastName(String email) {
        By tableLastName = By.xpath("//div[text()='" + email + "']//preceding::div[2]");
        return find(tableLastName).getText();
    }

    public String getTableEmail(String email) {
        By tableEmail = By.xpath("//div[@class='rt-td'][contains(., '" + email + "')]");
        return find(tableEmail).getText();
    }

    public String getTableSalary(String email) {
        By tableSalary = By.xpath("//div[text()='" + email + "']//following-sibling::div[1]");
        return find(tableSalary).getText();
    }

    public String getTableDepartment(String email) {
        By tableDepartment = By.xpath("//div[text()='" + email + "']//following-sibling::div[2]");
        return find(tableDepartment).getText();
    }
}
