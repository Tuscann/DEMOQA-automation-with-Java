package com.pages.demo.pages.elements;

import org.openqa.selenium.By;

public class WebTablesPage extends ElementsPage {

    private final By registrationAgeField = By.id("age");
    private final By registrationFirstNameField = By.id("firstName");
    private final By registrationLastNameField = By.id("lastName");
    private final By submitButton = By.id("submit");

    public void clickEdit(String email) {
        By edit = By.xpath("//div[text()='" + email + "']//following::span[@title='Edit']");
        click(edit);
    }

    public void setAge(String age) {
        set(registrationAgeField, age);
    }

    public void setFirstName(String name) {
        set(registrationFirstNameField, name);
    }

    public void setLastName(String name) {
        set(registrationLastNameField, name);
    }

    public void clickSubmitButton() {
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
}
