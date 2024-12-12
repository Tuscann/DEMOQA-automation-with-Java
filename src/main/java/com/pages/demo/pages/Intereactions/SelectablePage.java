package com.pages.demo.pages.Intereactions;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectablePage extends BasePage {
    private final By listText = By.id("demo-tab-list");
    private final By gridText = By.id("demo-tab-grid");
    private final By firstRowSelect = By.xpath("(//li[@class='mt-2 list-group-item list-group-item-action'])[1]");
    private final By secondRowSelect = By.xpath("(//li[@class='mt-2 list-group-item list-group-item-action'])[2]");
    private final By thirdRowSelect = By.xpath("(//li[@class='mt-2 list-group-item list-group-item-action'])[3]");
    private final By fourRowSelect = By.xpath("(//li[@class='mt-2 list-group-item list-group-item-action'])[4]");

    private final By firstRowDeselect = By.xpath("(//li[@class='mt-2 list-group-item active list-group-item-action'])[1]");
    private final By secondRowDeselect = By.xpath("(//li[@class='mt-2 list-group-item active list-group-item-action'])[2]");
    private final By thirdRowDeselect = By.xpath("(//li[@class='mt-2 list-group-item active list-group-item-action'])[3]");
    private final By fourRowDeselect = By.xpath("(//li[@class='mt-2 list-group-item active list-group-item-action'])[4]");

    private final By allList = By.xpath("//*[contains(@class,\"mt-2\")]");


    public void clickElement(int index) {
        List<WebElement> inputField = driver.findElements(allList);

        for (int i = 0; i < inputField.size(); i++) {
            if (i == index) {
                inputField.get(i).click();
                break;
            }
        }
    }


    public boolean isFirstRowSelected() {
        return driver.findElement(firstRowSelect).isDisplayed();
    }

    public boolean isSecondRowSelected() {
        return driver.findElement(secondRowSelect).isDisplayed();
    }

    public void clickGrid() {
        find(gridText).click();
    }

    public String getListText() {
        return find(listText).getText();
    }

    public String getGridText() {
        return find(gridText).getText();
    }

    public void selectFirstRow() {
        find(firstRowSelect).click();
    }

    public void selectSecondRow() {
        find(secondRowSelect).click();
    }

    public void selectThirdRow() {
        find(thirdRowSelect).click();
    }

    public void selectFourRow() {
        find(fourRowSelect).click();
    }

    public void deselectFirstRow() {
        find(firstRowDeselect).click();
    }

    public void deselectSecondRow() {
        find(secondRowDeselect).click();
    }

    public void deselectThirdRow() {
        find(thirdRowDeselect).click();
    }

    public void deselectFourRow() {
        find(fourRowDeselect).click();
    }

    public boolean RowSelected(String searchedSelection) {

        WebElement listItem = driver.findElement(By.xpath("//li[contains(.,'" + searchedSelection + "')]"));

        String backgroundColor = listItem.getCssValue("background-color");

        return backgroundColor.equals("rgba(0, 123, 255, 1)");
    }
}
