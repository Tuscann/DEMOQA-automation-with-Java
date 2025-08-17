package demoqa.pages.interactions;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SelectablePage extends BasePage {
    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Selectable')]")
    private WebElement pageTitle;

    @FindBy(xpath = "(//li[@class='mt-2 list-group-item list-group-item-action'])[1]")
    private WebElement firstRowSelect;

    @FindBy(xpath = "(//li[@class='mt-2 list-group-item list-group-item-action'])[2]")
    private WebElement secondRowSelect;

    @FindBy(xpath = "(//li[@class='mt-2 list-group-item list-group-item-action'])[3]")
    private WebElement thirdRowSelect;

    @FindBy(xpath = "(//li[@class='mt-2 list-group-item list-group-item-action'])[4]")
    private WebElement fourRowSelect;

    @FindBy(xpath = "(//li[@class='mt-2 list-group-item active list-group-item-action'])[1]")
    private WebElement firstRowDeselect;

    @FindBy(xpath = "(//li[@class='mt-2 list-group-item active list-group-item-action'])[2]")
    private WebElement secondRowDeselect;

    @FindBy(xpath = "(//li[@class='mt-2 list-group-item active list-group-item-action'])[3]")
    private WebElement thirdRowDeselect;

    @FindBy(xpath = "(//li[@class='mt-2 list-group-item active list-group-item-action'])[4]")
    private WebElement fourRowDeselect;

    @FindBy(xpath = "//*[contains(@class,'mt-2')]")
    private List<WebElement> allList;

    @FindBy(id = "demo-tab-list")
    private WebElement listTabText;

    @FindBy(xpath = "//li[@class='mt-2 list-group-item list-group-item-action'][contains(.,'Cras justo odio')]")
    private WebElement listFirstText;

    @FindBy(xpath = "//li[@class='mt-2 list-group-item list-group-item-action'][contains(.,'Dapibus ac facilisis in')]")
    private WebElement listSecondText;

    @FindBy(xpath = "//li[@class='mt-2 list-group-item list-group-item-action'][contains(.,'Morbi leo risus')]")
    private WebElement listThirdText;

    @FindBy(xpath = "//li[contains(.,'Porta ac consectetur ac')]")
    private WebElement listFourText;

    @FindBy(id = "demo-tab-grid")
    private WebElement gridTabText;

    @FindBy(xpath = "//li[@class='list-group-item list-group-item-action'][contains(.,'One')]")
    private WebElement gridOne;

    @FindBy(xpath = "//li[@class='list-group-item list-group-item-action'][contains(.,'Two')]")
    private WebElement gridTwo;

    @FindBy(xpath = "//li[@class='list-group-item list-group-item-action'][contains(.,'Three')]")
    private WebElement gridThree;

    @FindBy(xpath = "//li[@class='list-group-item list-group-item-action'][contains(.,'Four')]")
    private WebElement gridFour;

    @FindBy(xpath = "//li[@class='list-group-item list-group-item-action'][contains(.,'Five')]")
    private WebElement gridFive;

    @FindBy(xpath = "//li[@class='list-group-item list-group-item-action'][contains(.,'Six')]")
    private WebElement gridSix;

    @FindBy(xpath = "//li[@class='list-group-item list-group-item-action'][contains(.,'Seven')]")
    private WebElement gridSeven;

    @FindBy(xpath = "//li[@class='list-group-item list-group-item-action'][contains(.,'Eight')]")
    private WebElement gridEight;

    @FindBy(xpath = "//li[@class='list-group-item list-group-item-action'][contains(.,'Nine')]")
    private WebElement gridNine;

    public SelectablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPageTitleText() {
        return pageTitle.getText();
    }

    public String getListTabText() {
        return listTabText.getText();
    }

    public String getListFirstText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(listFirstText));
        return listFirstText.getText();
    }

    public String getListSecondText() {
        return listSecondText.getText();
    }

    public String getListThirdText() {
        return listThirdText.getText();
    }

    public String getListFourText() {
        return listFourText.getText();
    }

    public String getGridText() {
        return gridTabText.getText();
    }

    public void clickGridTab() {
        gridTabText.click();
    }

    public void clickElement(int index) {
        if (index >= 0 && index < allList.size()) {
            allList.get(index).click();
        }
    }

//    public void selectFirstRow() {
//        firstRowSelect.click();
//    }
//
//    public void selectSecondRow() {
//        secondRowSelect.click();
//    }
//
//    public void selectThirdRow() {
//        thirdRowSelect.click();
//    }
//
//    public void selectFourRow() {
//        fourRowSelect.click();
//    }
//
//    public void deselectFirstRow() {
//        firstRowDeselect.click();
//    }
//
//    public void deselectSecondRow() {
//        secondRowDeselect.click();
//    }
//
//    public void deselectThirdRow() {
//        thirdRowDeselect.click();
//    }
//
//    public void deselectFourRow() {
//        fourRowDeselect.click();
//    }

    public boolean RowSelected(String searchedSelection) {

        WebElement listItem = driver.findElement(By.xpath("//li[contains(.,'" + searchedSelection + "')]"));

        String backgroundColor = listItem.getCssValue("background-color");

        return backgroundColor.equals("rgba(0, 123, 255, 1)");
    }

    public String getGridOneText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(gridOne));
        return gridOne.getText();
    }

    public String getGridTwoText() {
        return gridTwo.getText();
    }

    public String getGridThreeText() {
        return gridThree.getText();
    }

    public String getGridFourText() {
        return gridFour.getText();
    }

    public String getGridFive() {
        return gridFive.getText();
    }

    public String getGridSix() {
        return gridSix.getText();
    }

    public String getGridSeven() {
        return gridSeven.getText();
    }

    public String getGridEight() {
        return gridEight.getText();
    }

    public String getGridNine() {
        return gridNine.getText();
    }

    public void selectPositionFromGrid(String searched1Selection) {
        switch (searched1Selection) {
            case "One" -> gridOne.click();
            case "Two" -> gridTwo.click();
            case "Three" -> gridThree.click();
            case "Four" -> gridFour.click();
            case "Five" -> gridFive.click();
            case "Six" -> gridSix.click();
            case "Seven" -> gridSeven.click();
            case "Eight" -> gridEight.click();
            case "Nine" -> gridNine.click();
        }
    }

    public boolean isPositionFromGridSelected(String searchedSelection) {
        WebElement listItem = driver.findElement(By.xpath("//li[contains(.,'" + searchedSelection + "')]"));

        String backgroundColor = listItem.getCssValue("background-color");

        return backgroundColor.equals("rgba(0, 123, 255, 1)");
    }
}
