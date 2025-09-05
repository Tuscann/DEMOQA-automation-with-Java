package demoqa.pages.interactions;

import demoqa.base.BasePage;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DroppablePage extends BasePage {

    @FindBy(xpath = "//h1")
    private WebElement droppableHeader;

    @FindBy(xpath = " //*[@id='droppableExample-tab-simple']")
    private WebElement simpleTab;

    @FindBy(xpath = " //*[@id='draggable']")
    private WebElement simpleTabDragMe;

    @FindBy(xpath = "(//*[@id=\"droppable\"])[1]")
    private WebElement droppableSimpleTab;

    @FindBy(xpath = "(//*[@id=\"droppable\"]/p)[1]")
    private WebElement droppableSimpleTabText;

    @FindBy(xpath = "(//*[@id=\"droppable\"])[2]")
    private WebElement droppableAcceptTab;

    @FindBy(xpath = "(//*[@id=\"droppable\"]/p)[2]")
    private WebElement acceptableDroppableText;

    @FindBy(xpath = "(//*[@id=\"droppable\"])[3]")
    private WebElement droppableRevertDraggableTab;

    @FindBy(xpath = "(//*[@id=\"droppable\"]/p)[3]")
    private WebElement droppableRevertDraggableTabText;

    @FindBy(id = "droppableExample-tab-accept")
    private WebElement acceptTab;

    @FindBy(id = "acceptable")
    private WebElement acceptableButton;

    @FindBy(id = "notAcceptable")
    private WebElement notAcceptableButton;

    @FindBy(id = "droppableExample-tab-preventPropogation")
    private WebElement preventPropagationTab;

    @FindBy(id = "dragBox")
    private WebElement preventPropagationDragMeButton;

    @FindBy(id = "notGreedyDropBox")
    private WebElement preventPropagationNotGreedyDropBox;

    @FindBy(id = "greedyDropBoxInner")
    private WebElement preventPropagationGreedyDropBox;

    @FindBy(id = "greedyDropBox")
    private WebElement greedyDropBox;

    @FindBy(id = "notGreedyInnerDropBox")
    private WebElement notGreedyInnerDropBox;

    @FindBy(xpath = "(//p[contains(.,'Outer droppable')])[1]")
    private WebElement outerDroppableNotGreedyText;

    @FindBy(xpath = "//p[contains(.,'Inner droppable (not greedy)')]")
    private WebElement innerDroppableNotGreedyText;

    @FindBy(xpath = "(//p[contains(.,'Outer droppable')])[2]")
    private WebElement outerDroppableGreedyText;

    @FindBy(xpath = "//p[contains(.,'Inner droppable (greedy)')]")
    private WebElement innerDroppableGreedyText;

    @FindBy(id = "droppableExample-tab-revertable")
    private WebElement revertDraggableTab;

    @FindBy(id = "revertable")
    private WebElement willRevert;

    @FindBy(id = "notRevertable")
    private WebElement notWillRevert;

    @FindBy(xpath = "(//div[@id='droppable'])[3]")
    private WebElement dropHereRevertDraggable;

    public DroppablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickRevertDraggableTab() {
        revertDraggableTab.click();
    }

    public void clickAcceptTab() {
        acceptTab.click();
    }

    public void clickPreventPropagationTab() {
        preventPropagationTab.click();
    }

    public String getPreventPropagationTabText() {
        return preventPropagationTab.getText();
    }

    public String getExpectedHeaderText() {
        return droppableHeader.getText();
    }

    public String getSimpleTabText() {
        return simpleTab.getText();
    }

    public String getSimpleTabDragMeButtonText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(simpleTabDragMe));
        return simpleTabDragMe.getText();
    }

    public String getSimpleTabDroppableText() {
        return droppableSimpleTabText.getText();
    }

    public String getDroppableAcceptTabText() {
        return acceptTab.getText();
    }

    public String getAcceptTabAcceptableButtonText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(acceptableButton));
        return acceptableButton.getText();
    }

    public String getAcceptTabNotAcceptableButtonText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(notAcceptableButton));
        return notAcceptableButton.getText();
    }

    public String getAcceptableDroppableText() {
        return acceptableDroppableText.getText();
    }

    public String getDragMePreventPropagationText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(preventPropagationDragMeButton));
        return preventPropagationDragMeButton.getText();
    }

    public String getOuterDroppableNotGreedyText() {
        return outerDroppableNotGreedyText.getText();
    }

    public String getInnerDroppableNotGreedyText() {
        return innerDroppableNotGreedyText.getText();
    }

    public String getInnerDroppableGreedyText() {
        return innerDroppableGreedyText.getText();
    }

    public String getWillRevertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(willRevert));
        return willRevert.getText();
    }

    public String getNotRevertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(notWillRevert));
        return notWillRevert.getText();
    }

    public String getRevertDraggableDroppableText() {
        return droppableRevertDraggableTabText.getText();
    }

    public String getRevertDraggableTabText() {
        return revertDraggableTab.getText();
    }

    public String getDraggableBackgroundColor() {

        return droppableSimpleTab.getCssValue("background-color");
    }

    public void dragAndDropSimpleTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(droppableSimpleTab));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(simpleTabDragMe, droppableSimpleTab).perform();

        wait.until(ExpectedConditions.textToBePresentInElement(droppableSimpleTabText, "Dropped!"));
    }

    public void dragAndDropAcceptableTab() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(acceptableButton, acceptableDroppableText).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.textToBePresentInElement(acceptableDroppableText, "Dropped!"));
    }

    public void dragAndDropNotAcceptable() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(notAcceptableButton, acceptableDroppableText).perform();
    }

    public String getColorAcceptable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.textToBePresentInElement(acceptableDroppableText, "Dropped!"));
        return acceptableDroppableText.getCssValue("background-color");
    }

    public void dragAndDropPropagationOuterDroppableNotGreedy() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(preventPropagationDragMeButton, outerDroppableNotGreedyText).perform();
    }

    public void dragAndDropPropagationInnerDroppableGreedy() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(preventPropagationDragMeButton, preventPropagationGreedyDropBox).perform();
    }

    public String getInnerDroppableGreedyColor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(preventPropagationGreedyDropBox));
        return preventPropagationGreedyDropBox.getCssValue("background-color");
    }

    public String getOuterDroppableGreedyText() {
        return greedyDropBox.getText();
    }

    public void dragAndDropPropagationOuterDroppableGreedy() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(preventPropagationDragMeButton, outerDroppableGreedyText).perform();
    }

    public Point getInitLocation() {
        return willRevert.getLocation();
    }

    public void dragAndDropWillRevert() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(willRevert, dropHereRevertDraggable).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeToBe(dropHereRevertDraggable, "background-color", "rgba(70, 130, 180, 1)"));
    }

    public void dragAndDropWillNotRevert() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(notWillRevert, dropHereRevertDraggable).perform();
    }

    public Point getAfterLocationNot() {
        return notWillRevert.getLocation();
    }

    public Point getEndLocation() {
        delay(1000); //TODO
        return willRevert.getLocation();
    }

    public void dragAndDropPropagationInnerDroppableNotGreedy() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(preventPropagationDragMeButton, notGreedyInnerDropBox).perform();
    }

    public String getDroppableBackGroundColor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(droppableSimpleTab));
        return droppableSimpleTab.getCssValue("background-color");
    }

    public String getWillNotRevertBackGroundColor() {
        return notWillRevert.getCssValue("background-color");
    }

    public String getWillRevertBackGroundColor() {
        return willRevert.getCssValue("background-color");
    }


    public String getDroppableBackgroundColor() {
        return droppableSimpleTab.getCssValue("background-color");
    }

    public String getAcceptableButtonBackgroundColor() {
        return acceptableButton.getCssValue("background-color");
    }

    public String getNotAcceptableButtonBackgroundColor() {
        return notAcceptableButton.getCssValue("background-color");
    }

    public String getDroppableAcceptTabBackgroundColor() {
        return droppableAcceptTab.getCssValue("background-color");
    }

    public String getDragMePreventPropagationBackGroundColor() {
        return preventPropagationDragMeButton.getCssValue("background-color");
    }

    public String getOuterDroppableNotGreedyBackGroundColor() {
        return preventPropagationNotGreedyDropBox.getCssValue("background-color");
    }

    public String getInnerDroppableNotGreedyBackGroundColor() {
        return notGreedyInnerDropBox.getCssValue("background-color");
    }

    public String getPreventPropagationNotGreedyText() {
        return preventPropagationNotGreedyDropBox.getText();
    }

    public String getOuterDroppableGreedyBackGroundColor() {
        return droppableRevertDraggableTab.getCssValue("background-color");
    }

    public String getInnerDroppableGreedyBackGroundColor() {
        return preventPropagationGreedyDropBox.getCssValue("background-color");
    }

    public String getDroppableRevertDraggableText() {
        return droppableRevertDraggableTabText.getText();
    }

    public String getDroppableRevertDraggableBackGroundColor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(droppableRevertDraggableTab));
        return droppableSimpleTab.getCssValue("background-color");
    }
}