package demoqa.pages.Interactions;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectablePage extends BasePage {
    private final By pageTitle = By.xpath("//h1[@class='text-center'][contains(.,'Selectable')]");
    private final By firstRowSelect = By.xpath("(//li[@class='mt-2 list-group-item list-group-item-action'])[1]");
    private final By secondRowSelect = By.xpath("(//li[@class='mt-2 list-group-item list-group-item-action'])[2]");
    private final By thirdRowSelect = By.xpath("(//li[@class='mt-2 list-group-item list-group-item-action'])[3]");
    private final By fourRowSelect = By.xpath("(//li[@class='mt-2 list-group-item list-group-item-action'])[4]");
    private final By firstRowDeselect = By.xpath("(//li[@class='mt-2 list-group-item active list-group-item-action'])[1]");
    private final By secondRowDeselect = By.xpath("(//li[@class='mt-2 list-group-item active list-group-item-action'])[2]");
    private final By thirdRowDeselect = By.xpath("(//li[@class='mt-2 list-group-item active list-group-item-action'])[3]");
    private final By fourRowDeselect = By.xpath("(//li[@class='mt-2 list-group-item active list-group-item-action'])[4]");
    private final By allList = By.xpath("//*[contains(@class,\"mt-2\")]");

    private final By listTabText = By.id("demo-tab-list");
    private final By listFirstText = By.xpath("//li[@class='mt-2 list-group-item list-group-item-action'][contains(.,'Cras justo odio')]");
    private final By listSecondText = By.xpath("//li[@class='mt-2 list-group-item list-group-item-action'][contains(.,'Dapibus ac facilisis in')]");
    private final By listThirdText = By.xpath("//li[@class='mt-2 list-group-item list-group-item-action'][contains(.,'Morbi leo risus')]");
    private final By listFourText = By.xpath("//li[contains(.,'Porta ac consectetur ac')]");
    private final By gridTabText = By.id("demo-tab-grid");
    private final By gridOne = By.xpath("//li[@class='list-group-item list-group-item-action'][contains(.,'One')]");
    private final By gridTwo = By.xpath("//li[@class='list-group-item list-group-item-action'][contains(.,'Two')]");
    private final By gridThree = By.xpath("//li[@class='list-group-item list-group-item-action'][contains(.,'Three')]");
    private final By gridFour = By.xpath("//li[@class='list-group-item list-group-item-action'][contains(.,'Four')]");
    private final By gridFive = By.xpath("//li[@class='list-group-item list-group-item-action'][contains(.,'Five')]");
    private final By gridSix = By.xpath("//li[@class='list-group-item list-group-item-action'][contains(.,'Six')]");
    private final By gridSeven = By.xpath("//li[@class='list-group-item list-group-item-action'][contains(.,'Seven')]");
    private final By gridEight = By.xpath("//li[@class='list-group-item list-group-item-action'][contains(.,'Eight')]");
    private final By gridNine = By.xpath("//li[@class='list-group-item list-group-item-action'][contains(.,'Nine')]");

    public SelectablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPageTitleText() {
        return find(pageTitle).getText();
    }

    public String getListTabText() {
        return find(listTabText).getText();
    }

    public String getListFirstText() {
        return find(listFirstText).getText();
    }

    public String getListSecondText() {
        return find(listSecondText).getText();
    }

    public String getListThirdText() {
        return find(listThirdText).getText();
    }

    public String getListFourText() {
        return find(listFourText).getText();
    }

    public String getGridText() {
        return find(gridTabText).getText();
    }

    public void clickGridTab() {
        find(gridTabText).click();
    }

    public void clickElement(int index) {
        List<WebElement> inputField = driver.findElements(allList);

        for (int i = 0; i < inputField.size(); i++) {
            if (i == index) {
                inputField.get(i).click();
                break;
            }
        }
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

    public String getGridOneText() {
        return find(gridOne).getText();
    }

    public String getGridTwoText() {
        return find(gridTwo).getText();
    }

    public String getGridThreeText() {
        return find(gridThree).getText();
    }

    public String getGridFourText() {
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

    public void selectPositionFromGrid(String searched1Selection) {
        switch (searched1Selection) {
            case "One" -> find(gridOne).click();
            case "Two" -> find(gridTwo).click();
            case "Three" -> find(gridThree).click();
            case "Four" -> find(gridFour).click();
            case "Five" -> find(gridFive).click();
            case "Six" -> find(gridSix).click();
            case "Seven" -> find(gridSeven).click();
            case "Eight" -> find(gridEight).click();
            case "Nine" -> find(gridNine).click();
        }
    }

    public boolean isPositionFromGridSelected(String searchedSelection) {
        WebElement listItem = driver.findElement(By.xpath("//li[contains(.,'" + searchedSelection + "')]"));

        String backgroundColor = listItem.getCssValue("background-color");

        return backgroundColor.equals("rgba(0, 123, 255, 1)");
    }
}
