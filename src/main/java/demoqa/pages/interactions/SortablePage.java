package demoqa.pages.interactions;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class SortablePage extends BasePage {

    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Sortable')]")
    private WebElement pageTitle;

    @FindBy(id = "demo-tab-list")
    private WebElement listTab;

    @FindBy(xpath = "(//div[@class='list-group-item list-group-item-action'][contains(.,'One')])[1]")
    private WebElement listOne;

    @FindBy(xpath = "(//div[@class='list-group-item list-group-item-action'][contains(.,'Two')])[1]")
    private WebElement listTwo;

    @FindBy(xpath = "(//div[@class='list-group-item list-group-item-action'][contains(.,'Three')])[1]")
    private WebElement listThree;

    @FindBy(xpath = "(//div[@class='list-group-item list-group-item-action'][contains(.,'Four')])[1]")
    private WebElement listFour;

    @FindBy(xpath = "(//div[@class='list-group-item list-group-item-action'][contains(.,'Five')])[1]")
    private WebElement listFive;

    @FindBy(xpath = "(//div[@class='list-group-item list-group-item-action'][contains(.,'Six')])[1]")
    private WebElement listSix;

    @FindBy(id = "demo-tab-grid")
    private WebElement gridTab;

    @FindBy(xpath = "(//div[@class='list-group-item list-group-item-action'][contains(.,'One')])[2]")
    private WebElement gridOne;

    @FindBy(xpath = "(//div[@class='list-group-item list-group-item-action'][contains(.,'Two')])[2]")
    private WebElement gridTwo;

    @FindBy(xpath = "(//div[@class='list-group-item list-group-item-action'][contains(.,'Three')])[2]")
    private WebElement gridThree;

    @FindBy(xpath = "(//div[@class='list-group-item list-group-item-action'][contains(.,'Four')])[2]")
    private WebElement gridFour;

    @FindBy(xpath = "(//div[@class='list-group-item list-group-item-action'][contains(.,'Five')])[2]")
    private WebElement gridFive;

    @FindBy(xpath = "(//div[@class='list-group-item list-group-item-action'][contains(.,'Six')])[2]")
    private WebElement gridSix;

    @FindBy(xpath = "(//div[@class='list-group-item list-group-item-action'][contains(.,'Seven')])")
    private WebElement gridSeven;

    @FindBy(xpath = "//div[@class='list-group-item list-group-item-action'][contains(.,'Eight')]")
    private WebElement gridEight;

    @FindBy(xpath = "//div[@class='list-group-item list-group-item-action'][contains(.,'Nine')]")
    private WebElement gridNine;

    @FindBy(id = "demo-tabpane-list")
    private WebElement listOrder;

    @FindBy(id = "demo-tabpane-grid")
    private WebElement gridOrder;

    public SortablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickGridTab() {
        gridTab.click();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getListTab() {
        return listTab.getText();
    }

    public String getListOne() {
        return listOne.getText();
    }

    public String getListTwo() {
        return listTwo.getText();
    }

    public String getListThree() {
        return listThree.getText();
    }

    public String getListFour() {
        return listFour.getText();
    }

    public String getListFive() {
        return listFive.getText();
    }

    public String getListSix() {
        return listSix.getText();
    }

    public String getGridTab() {
        return gridTab.getText();
    }

    public String getGridOne() {
        return gridOne.getText();
    }

    public String getGridTwo() {
        return gridTwo.getText();
    }

    public String getGridThree() {
        return gridThree.getText();
    }

    public String getGridFour() {
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

    public String getListOrder() {
        return listOrder.getText();
    }

    public String getGridOrder() {
        return gridOrder.getText();
    }

    public void moveOverGrid(String gridOne, String gridSix) {
        WebElement draggable = getGridElementByName(gridOne);
        WebElement droppable = getGridElementByName(gridSix);

        scrollToElementJS(draggable);

        if (draggable != null && droppable != null) {
            Actions actions = new Actions(driver);
            actions.dragAndDrop(draggable, droppable).perform();
        }
    }

    public void moveOverList(String listOne, String listSix) {
        WebElement draggable = getListElementByName(listOne);
        WebElement droppable = getListElementByName(listSix);

        scrollToElementJS(draggable);

        if (draggable != null && droppable != null) {
            Actions actions = new Actions(driver);
            actions.dragAndDrop(draggable, droppable).perform();
        }
    }

    private WebElement getGridElementByName(String name) {
        return switch (name) {
            case "One" -> gridOne;
            case "Two" -> gridTwo;
            case "Three" -> gridThree;
            case "Four" -> gridFour;
            case "Five" -> gridFive;
            case "Six" -> gridSix;
            case "Seven" -> gridSeven;
            case "Eight" -> gridEight;
            case "Nine" -> gridNine;
            default -> null;
        };
    }

    private WebElement getListElementByName(String name) {
        return switch (name) {
            case "One" -> listOne;
            case "Two" -> listTwo;
            case "Three" -> listThree;
            case "Four" -> listFour;
            case "Five" -> listFive;
            case "Six" -> listSix;
            default -> null;
        };
    }
}