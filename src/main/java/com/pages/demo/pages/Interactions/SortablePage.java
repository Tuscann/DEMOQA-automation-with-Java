package com.pages.demo.pages.Interactions;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

    private final By listOrder = By.id("demo-tabpane-list");
    private final By gridOrder = By.id("demo-tabpane-grid");

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

    public String getListOrder() {
        return find(listOrder).getText();
    }

    public String getGridOrder() {
        return find(gridOrder).getText();
    }

    public void moveOverGrid(String gridOne, String gridSix) {

        WebElement draggable = null;
        WebElement droppable = null;

        draggable = switch (gridOne) {
            case "One" -> driver.findElement(this.gridOne);
            case "Two" -> driver.findElement(this.gridTwo);
            case "Three" -> driver.findElement(this.gridThree);
            case "Four" -> driver.findElement(this.gridFour);
            case "Five" -> driver.findElement(this.gridFive);
            case "Six" -> driver.findElement(this.gridSix);
            case "Seven" -> driver.findElement(this.gridSeven);
            case "Eight" -> driver.findElement(this.gridEight);
            case "Nine" -> driver.findElement(this.gridNine);
            default -> draggable;
        };

        droppable = switch (gridSix) {
            case "One" -> driver.findElement(this.gridOne);
            case "Two" -> driver.findElement(this.gridTwo);
            case "Three" -> driver.findElement(this.gridThree);
            case "Four" -> driver.findElement(this.gridFour);
            case "Five" -> driver.findElement(this.gridFive);
            case "Six" -> driver.findElement(this.gridSix);
            case "Seven" -> driver.findElement(this.gridSeven);
            case "Eight" -> driver.findElement(this.gridEight);
            case "Nine" -> driver.findElement(this.gridNine);
            default -> droppable;
        };

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();
    }

    public void moveOverList(String listOne, String listSix) {

        WebElement draggable = null;
        WebElement droppable = null;

        draggable = switch (listOne) {
            case "One" -> driver.findElement(this.listOne);
            case "Two" -> driver.findElement(this.listTwo);
            case "Three" -> driver.findElement(this.listThree);
            case "Four" -> driver.findElement(this.listFour);
            case "Five" -> driver.findElement(this.listFive);
            case "Six" -> driver.findElement(this.listSix);
            default -> draggable;
        };

        droppable = switch (listSix) {
            case "One" -> driver.findElement(this.listOne);
            case "Two" -> driver.findElement(this.listTwo);
            case "Three" -> driver.findElement(this.listThree);
            case "Four" -> driver.findElement(this.listFour);
            case "Five" -> driver.findElement(this.listFive);
            case "Six" -> driver.findElement(this.listSix);
            default -> droppable;
        };

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();
    }
}
