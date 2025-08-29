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

    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Droppable')]")
    private WebElement droppableHeader;

    @FindBy(id = "droppableExample-tab-simple")
    private WebElement simpleTab;

    @FindBy(id = "draggable")
    private WebElement simpleTabDragMe;

    @FindBy(id = "droppable")
    private WebElement simpleTabDroppedContainer;

    @FindBy(xpath = "(//*[@id=\"droppable\"])[2]")
    private WebElement simpleTabDropHere;

    @FindBy(id = "droppableExample-tab-accept")
    private WebElement acceptTab;

    @FindBy(id = "acceptable")
    private WebElement acceptTabAcceptable;

    @FindBy(id = "notAcceptable")
    private WebElement acceptTabNotAcceptable;

    @FindBy(xpath = "(//*[@id=\"droppable\"]/p)[2]")
    private WebElement acceptableDropHere;

    @FindBy(id = "droppableExample-tab-preventPropogation")
    private WebElement preventPropagationTab;

    @FindBy(id = "dragBox")
    private WebElement preventPropagationDragMe;

    @FindBy(id = "notGreedyDropBox")
    private WebElement preventPropagationNotGreedyDropBox;

    @FindBy(xpath = "(//p[contains(.,'Outer droppable')])[1]")
    private WebElement outerDroppable;


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

    @FindBy(xpath = "(//*[@id=\"droppable\"]/p)[3]")
    private WebElement dropHereRevertDraggableText;

    @FindBy(xpath = "(//div[@id='droppable'])[3]")
    private WebElement dropHereRevertDraggable;

    @FindBy(id = "droppable")
    private WebElement dropHereRevertDraggable2;

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

    public String getDroppablePreventPropagationTab() {
        return preventPropagationTab.getText();
    }

    public String getRevertDraggableTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(revertDraggableTab));
        return revertDraggableTab.getText();
    }

    public String getExpectedHeader() {
        return droppableHeader.getText();
    }

    public String getExpectedSimpleTab() {
        return simpleTab.getText();
    }

    public String getSimpleTabDragMe() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(simpleTabDragMe));
        return simpleTabDragMe.getText();
    }

    public String getDroppedContainer() {
        return simpleTabDroppedContainer.getText();
    }

    public String getDroppableAcceptTab() {
        return acceptTab.getText();
    }

    public String getAcceptTabAcceptable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(acceptTabAcceptable));
        return acceptTabAcceptable.getText();
    }

    public String getAcceptTabNotAcceptable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(acceptTabNotAcceptable));
        return acceptTabNotAcceptable.getText();
    }

    public String getAcceptableDropHere() {
        return acceptableDropHere.getText();
    }

    public String getDragMePreventPropagation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(preventPropagationDragMe));
        return preventPropagationDragMe.getText();
    }

    public String getOuterDroppable1Text() {
        return outerDroppableNotGreedyText.getText();
    }

    public String getInnerDroppableNotGreedyText() {
        return innerDroppableNotGreedyText.getText();
    }

    public String getOuterDroppable2() {
        return outerDroppableGreedyText.getText();
    }

    public String getInnerDroppableGreedy() {
        return innerDroppableGreedyText.getText();
    }

    public String getWillRevert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(willRevert));
        return willRevert.getText();
    }

    public String getNotRevert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(notWillRevert));
        return notWillRevert.getText();
    }

    public String getDropHereRevertDraggable() {
        return dropHereRevertDraggableText.getText();
    }

    public String getRevertDraggableTabText() {
        return simpleTabDroppedContainer.getText();
    }

    public String getDragAndDropAcceptableText() {
        return acceptableDropHere.getText();
    }

    public String getNewBackgroundColor() {
        return simpleTabDroppedContainer.getCssValue("background-color");
    }

    public void dragAndDrop() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(simpleTabDragMe));
        wait.until(ExpectedConditions.visibilityOf(simpleTabDroppedContainer));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(simpleTabDragMe, simpleTabDroppedContainer).perform();

        wait.until(ExpectedConditions.textToBePresentInElement(simpleTabDroppedContainer, "Dropped!"));
    }

    public void dragAndDropAcceptable() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(acceptTabAcceptable, acceptableDropHere).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.textToBePresentInElement(acceptableDropHere, "Dropped!"));
    }

    public void dragAndDropNotAcceptable() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(acceptTabNotAcceptable, acceptableDropHere).perform();
    }

    public String getColorAcceptable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.textToBePresentInElement(acceptableDropHere, "Dropped!"));
        return simpleTabDropHere.getCssValue("background-color");
    }

    public String getColorNotAcceptable() {
        return simpleTabDropHere.getCssValue("background-color");
    }

    public void dragAndDropPropagationOuterDroppableNotGreedy() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(preventPropagationDragMe, outerDroppable).perform();
    }

    public String getOuterDroppableNotGreedyColor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(preventPropagationNotGreedyDropBox));
        return preventPropagationNotGreedyDropBox.getCssValue("background-color");
    }

    public String getInnerDroppableNotGreedyColor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(notGreedyInnerDropBox));
        return notGreedyInnerDropBox.getCssValue("background-color");
    }

    public String getOuterDroppableNotGreedyText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(preventPropagationNotGreedyDropBox));
        return preventPropagationNotGreedyDropBox.getText();
    }

    public void dragAndDropPropagationInnerDroppableGreedy() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(preventPropagationDragMe, preventPropagationGreedyDropBox).perform();
    }

    public String getInnerDroppableGreedyColor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(preventPropagationGreedyDropBox));
        return preventPropagationGreedyDropBox.getCssValue("background-color");
    }

    public String getOuterDroppableGreedyText() {
        return greedyDropBox.getText();
    }

    public String getOuterDroppableGreedyColor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(greedyDropBox));
        return greedyDropBox.getCssValue("background-color");
    }

    public void dragAndDropPropagationOuterDroppableGreedy() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(preventPropagationDragMe, outerDroppableGreedyText).perform();
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

    public String getInitText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(dropHereRevertDraggableText));
        return dropHereRevertDraggableText.getText();
    }

    public void dragAndDropWillNotRevert() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(notWillRevert, dropHereRevertDraggable).perform();
    }

    public Point getAfterLocationNot() {
        return notWillRevert.getLocation();
    }

    public Point getEndLocation(int initialLocationX, int initialLocationY) {
        delay(500); //TODO
        return willRevert.getLocation();
    }

    public void dragAndDropPropagationInnerDroppableNotGreedy() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(preventPropagationDragMe, notGreedyInnerDropBox).perform();
    }
}