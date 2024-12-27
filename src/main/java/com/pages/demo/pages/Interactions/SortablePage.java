package com.pages.demo.pages.Interactions;

import com.pages.base.BasePage;
import org.openqa.selenium.By;

public class SortablePage extends BasePage {

    private final By pageTitle = By.xpath("//h1[@class='text-center'][contains(.,'Sortable')]");
    private final By listTab = By.id("demo-tab-list");
    private final By listOne = By.xpath("(//div[@class='list-group-item list-group-item-action'][contains(.,'One')])[1]");
    private final By listTwo = By.xpath("(//div[@class='list-group-item list-group-item-action'][contains(.,'Two')])[1]");
    private final By listThree = By.xpath("(//div[@class='list-group-item list-group-item-action'][contains(.,'Three')])[1]");
    private final By listFour = By.xpath("(//div[@class='list-group-item list-group-item-action'][contains(.,'Four')])[1]");
    private final By listFive = By.xpath("(//div[@class='list-group-item list-group-item-action'][contains(.,'Five')])[1]");
    private final By listSix = By.xpath("(//div[@class='list-group-item list-group-item-action'][contains(.,'Six')])[1]");
    private final By gridTab = By.id("demo-tab-grid");
    private final By gridOne = By.xpath("(//div[@class='list-group-item list-group-item-action'][contains(.,'One')])[2]");
    private final By gridTwo = By.xpath("(//div[@class='list-group-item list-group-item-action'][contains(.,'Two')])[2]");
    private final By gridThree = By.xpath("(//div[@class='list-group-item list-group-item-action'][contains(.,'Three')])[2]");
    private final By gridFour = By.xpath("(//div[@class='list-group-item list-group-item-action'][contains(.,'Four')])[2]");
    private final By gridFive = By.xpath("(//div[@class='list-group-item list-group-item-action'][contains(.,'Five')])[2]");
    private final By gridSix = By.xpath("(//div[@class='list-group-item list-group-item-action'][contains(.,'Six')])[2]");
    private final By gridSeven = By.xpath("(//div[@class='list-group-item list-group-item-action'][contains(.,'Seven')])");
    private final By gridEight = By.xpath("//div[@class='list-group-item list-group-item-action'][contains(.,'Eight')]");
    private final By gridNine = By.xpath("//div[@class='list-group-item list-group-item-action'][contains(.,'Nine')]");

    public void clickGridTab() {
        click(gridTab);
    }

    public String getPageTitle() {
        return find(pageTitle).getText();
    }

    public String getListTab() {
        return find(listTab).getText();
    }

    public String getListOne() {
        return find(listOne).getText();
    }

    public String getListTwo() {
        return find(listTwo).getText();
    }

    public String getListThree() {
        return find(listThree).getText();
    }

    public String getListFour() {
        return find(listFour).getText();
    }

    public String getListFive() {
        return find(listFive).getText();
    }

    public String getListSix() {
        return find(listSix).getText();
    }

    public String getGridTab() {
        return find(gridTab).getText();
    }

    public String getGridOne() {
        return find(gridOne).getText();
    }

    public String getGridTwo() {
        return find(gridTwo).getText();
    }

    public String getGridThree() {
        return find(gridThree).getText();
    }

    public String getGridFour() {
        return find(gridFour).getText();
    }

    public String getGridFive() {
        return find(gridFive).getText();
    }

    public String getGridSix() {
        return find(gridSix).getText();
    }

    public String getGridSeven() {
        return find(gridSeven).getText();
    }

    public String getGridEight() {
        return find(gridEight).getText();
    }

    public String getGridNine() {
        return find(gridNine).getText();
    }


}
