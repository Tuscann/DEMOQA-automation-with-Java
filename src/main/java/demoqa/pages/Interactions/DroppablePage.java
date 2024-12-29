package demoqa.pages.Interactions;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DroppablePage extends BasePage {

    private final By droppableHeader = By.xpath("//h1[@class='text-center'][contains(.,'Droppable')]");
    private final By simpleTab = By.id("droppableExample-tab-simple");
    private final By simpleTabDragMe = By.id("draggable");
    private final By simpleTabDroppedContainer = By.id("droppable");
    private final By simpleTabDropHere = By.xpath("(//*[@id=\"droppable\"])[2]");

    private final By acceptTab = By.id("droppableExample-tab-accept");
    private final By acceptDropContainer = By.id("acceptDropContainer");
    private final By acceptTabAcceptable = By.id("acceptable");
    private final By acceptTabNotAcceptable = By.id("notAcceptable");
    private final By dropHereAcceptable = By.xpath("(//*[@id=\"droppable\"]/p)[2]");

    private final By preventPropagationTab = By.id("droppableExample-tab-preventPropogation");
    private final By preventPropagationDragMe = By.id("dragBox");
    private final By preventPropagationNotGreedyDropBox = By.id("notGreedyDropBox");
    private final By preventPropagationGreedyDropBox = By.id("greedyDropBoxInner");
    private final By greedyDropBox = By.id("greedyDropBox");
    private final By notGreedyInnerDropBox = By.id("notGreedyInnerDropBox");

    private final By outerDroppableNotGreedyText = By.xpath("(//p[contains(.,'Outer droppable')])[1]");
    private final By innerDroppableNotGreedyText = By.xpath("//p[contains(.,'Inner droppable (not greedy)')]");
    private final By outerDroppableGreedyText = By.xpath("(//p[contains(.,'Outer droppable')])[2]");
    private final By innerDroppableGreedyText = By.xpath("//p[contains(.,'Inner droppable (greedy)')]");

    private final By revertDraggableTab = By.id("droppableExample-tab-revertable");
    private final By willRevert = By.id("revertable");
    private final By notWillRevert = By.id("notRevertable");
    private final By dropHereRevertDraggableText = By.xpath("(//*[@id=\"droppable\"]/p)[3]");
    private final By dropHereRevertDraggable = By.xpath("(//*[@id=\"droppable\"])[3]");

    public void clickRevertDraggableTab() {
        click(revertDraggableTab);
    }

    public void clickDroppableAcceptTab() {
        click(acceptTab);
    }

    public void clickDroppablePreventPropagationTab() {
        click(preventPropagationTab);
    }

    public String getDroppablePreventPropagationTab() {
        return find(preventPropagationTab).getText();
    }

    public String getRevertDraggableTab() {
        return find(revertDraggableTab).getText();
    }

    public String getExpectedHeader() {
        return find(droppableHeader).getText();
    }

    public String getExpectedSimpleTab() {
        return find(simpleTab).getText();
    }

    public String getSimpleTabDragMe() {
        return find(simpleTabDragMe).getText();
    }

    public String getDroppedContainer() {
        return find(simpleTabDroppedContainer).getText();
    }

    public String getDroppableAcceptTab() {
        return find(acceptTab).getText();
    }

    public String getAcceptTabAcceptable() {
        return find(acceptTabAcceptable).getText();
    }

    public String getAcceptTabNotAcceptable() {
        return find(acceptTabNotAcceptable).getText();
    }

    public String getDropHereAcceptable() {
        return find(dropHereAcceptable).getText();
    }

    public String getDragMePreventPropagation() {
        return find(preventPropagationDragMe).getText();
    }

    public String getOuterDroppable1Text() {
        return find(outerDroppableNotGreedyText).getText();
    }

    public String getInnerDroppableNotGreedyText() {
        return find(innerDroppableNotGreedyText).getText();
    }

    public String getOuterDroppable2() {
        return find(outerDroppableGreedyText).getText();
    }

    public String getInnerDroppableGreedy() {
        return find(innerDroppableGreedyText).getText();
    }

    public String getWillRevert() {
        delay(100); //TODO
        return find(willRevert).getText();
    }

    public String getNotRevert() {
        return find(notWillRevert).getText();
    }

    public String getDropHereRevertDraggable() {
        return find(dropHereRevertDraggableText).getText();
    }

    public String getRevertDraggableTabText() {
        return driver.findElement(simpleTabDroppedContainer).getText();
    }

    public String getDragAndDropAcceptable() {
        return driver.findElement(dropHereAcceptable).getText();
    }

    public String getNewColor() {
        return driver.findElement(simpleTabDroppedContainer).getCssValue("background-color");
    }

    public void dragAndDrop() {
        WebElement draggable = driver.findElement(simpleTabDragMe);
        WebElement droppable = driver.findElement(simpleTabDroppedContainer);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.textToBePresentInElement(droppable, "Dropped!"));
    }

    public void dragAndDropAcceptable() {
        WebElement draggable = driver.findElement(acceptTabAcceptable);
        WebElement droppable = driver.findElement(dropHereAcceptable);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.textToBePresentInElement(droppable, "Dropped!"));
    }

    public void dragAndDropNotAcceptable() {
        WebElement draggable = driver.findElement(acceptTabNotAcceptable);
        WebElement droppable = driver.findElement(dropHereAcceptable);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();
    }

    public String getColorAcceptable() {
        WebElement droppable = driver.findElement(dropHereAcceptable);
        WebElement droppable2 = driver.findElement(simpleTabDropHere);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.textToBePresentInElement(droppable, "Dropped!"));
        return droppable2.getCssValue("background-color");
    }

    public String getColorNotAcceptable() {
        return driver.findElement(simpleTabDropHere).getCssValue("background-color");
    }

    public void dragAndDropPropagationOuterDroppableNotGreedy() {
        WebElement draggable = driver.findElement(preventPropagationDragMe);
        WebElement droppable = driver.findElement(preventPropagationNotGreedyDropBox);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();
    }

    public String getOuterDroppableNotGreedyColor() {
        WebElement droppable2 = driver.findElement(preventPropagationNotGreedyDropBox);

        return droppable2.getCssValue("background-color");
    }

    public String getInnerDroppableNotGreedyColor() {
        WebElement droppable = driver.findElement(notGreedyInnerDropBox);

        return droppable.getCssValue("background-color");
    }

    public String getOuterDroppableNotGreedyText() {
        WebElement droppable2 = driver.findElement(preventPropagationNotGreedyDropBox);

        return droppable2.getText();
    }

    public void dragAndDropPropagationInnerDroppableGreedy() {
        WebElement draggable = driver.findElement(preventPropagationDragMe);
        WebElement droppable = driver.findElement(preventPropagationGreedyDropBox);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();
    }

    public String getInnerDroppableGreedyColor() {
        WebElement droppable = driver.findElement(preventPropagationGreedyDropBox);
        delay(400); //TODO
        return droppable.getCssValue("background-color");
    }

    public String getOuterDroppableGreedyText() {
        WebElement droppable2 = driver.findElement(greedyDropBox);

        return droppable2.getText();
    }

    public String getOuterDroppableGreedyColor() {
        WebElement droppable = driver.findElement(greedyDropBox);
        delay(400); //TODO

        return droppable.getCssValue("background-color");
    }


    public void dragAndDropPropagationOuterDroppableGreedy() {
        WebElement draggable = driver.findElement(preventPropagationDragMe);
        WebElement droppable = driver.findElement(outerDroppableGreedyText);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();
    }

    public org.openqa.selenium.Point getInitLocation() {
        return driver.findElement(willRevert).getLocation();
    }

    public void dragAndDropWillRevert() {
        WebElement draggable = driver.findElement(willRevert);
        WebElement droppable = driver.findElement(dropHereRevertDraggable);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();
    }

    public String getInitText() {
        return find(dropHereRevertDraggableText).getText();
    }

    public Point getAfterLocation() {
        delay(500); //TODO
        WebElement draggable = driver.findElement(willRevert);

        return draggable.getLocation();
    }

    public void dragAndDropWillNotRevert() {
        WebElement draggable = driver.findElement(notWillRevert);
        WebElement droppable = driver.findElement(dropHereRevertDraggable);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();
    }

    public Point getAfterLocationNot() {
        delay(100); //TODO
        WebElement draggable = driver.findElement(notWillRevert);

        return draggable.getLocation();
    }
}
