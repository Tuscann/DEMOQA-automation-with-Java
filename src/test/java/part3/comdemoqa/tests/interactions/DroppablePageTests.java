package part3.comdemoqa.tests.interactions;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class DroppablePageTests extends BaseTest {

    @Test
    public void CheckAllNinePagesLinks() {
        navigateToUrl("droppable");

        String expectedHeader = "Droppable";
        String simpleTab = "Simple";
        String expectedDragMeSimple = "Drag me";
        String expectedDropped = "Drop here";
        String acceptTab = "Accept";
        String acceptable = "Acceptable";
        String notAcceptable = "Not Acceptable";
        String dropHereAcceptable = "Drop here";
        String preventPropagationTab = "Prevent Propogation";
        String dragMePreventPropagation = "Drag Me";
        String outerDroppable1 = "Outer droppable";
        String innerDroppableNotGreedy = "Inner droppable (not greedy)";
        String outerDroppable2 = "Outer droppable";
        String innerDroppableGreedy = "Inner droppable (greedy)";
        String revertDraggableTab = "Revert Draggable";
        String expectedWillRevertText = "Will Revert";
        String notRevert = "Not Revert";
        String dropHereRevertDraggable = "Drop here";

        String actualHeader = droppablePage.getExpectedHeader();
        String actualSimpleTab = droppablePage.getExpectedSimpleTab();
        String actualDragMeSimple = droppablePage.getSimpleTabDragMe();
        String actualDropped = droppablePage.getDroppedContainer();
        String actualAcceptTab = droppablePage.getDroppableAcceptTab();
        droppablePage.clickDroppableAcceptTab();
        String actualAcceptable = droppablePage.getAcceptTabAcceptable();
        String actualNotAcceptable = droppablePage.getAcceptTabNotAcceptable();
        String actualDropHereAcceptable = droppablePage.getDropHereAcceptable();
        String actualDroppablePreventPropagationTab = droppablePage.getDroppablePreventPropagationTab();
        droppablePage.clickDroppablePreventPropagationTab();
        String actualDragMePreventPropagation = droppablePage.getDragMePreventPropagation();
        String actualOuterDroppable1 = droppablePage.getOuterDroppable1Text();
        String actualInnerDroppableNotGreedy = droppablePage.getInnerDroppableNotGreedyText();
        String actualOuterDroppable2 = droppablePage.getOuterDroppable2();
        String actualInnerDroppableGreedy = droppablePage.getInnerDroppableGreedy();
        String actualRevertDraggableTab = droppablePage.getRevertDraggableTab();
        droppablePage.clickRevertDraggableTab();
        String actualWillRevert = droppablePage.getWillRevert();
        String actualNotRevert = droppablePage.getNotRevert();
        String actualDropHereRevertDraggable = droppablePage.getDropHereRevertDraggable();

        Assert.assertEquals(actualHeader, expectedHeader, "Wrong header");
        Assert.assertEquals(actualSimpleTab, simpleTab, "Wrong simple tab");
        Assert.assertEquals(actualDragMeSimple, expectedDragMeSimple, "Wrong drag me");
        Assert.assertEquals(actualDropped, expectedDropped, "Wrong dropped");
        Assert.assertEquals(actualAcceptTab, acceptTab, "Wrong accept tab");
        Assert.assertEquals(actualDroppablePreventPropagationTab, preventPropagationTab, "Wrong droppable prevent propagation");
        Assert.assertEquals(actualRevertDraggableTab, revertDraggableTab, "Wrong droppable revert draggable");
        Assert.assertEquals(actualAcceptable, acceptable, "Wrong acceptable");
        Assert.assertEquals(actualNotAcceptable, notAcceptable, "Wrong not acceptable");
        Assert.assertEquals(actualDropHereAcceptable, dropHereAcceptable, "Wrong drop her acceptable");
        Assert.assertEquals(actualDragMePreventPropagation, dragMePreventPropagation, "Wrong drag me prevent propagation");
        Assert.assertEquals(actualOuterDroppable1, outerDroppable1, "Wrong outer droppable 1");
        Assert.assertEquals(actualInnerDroppableNotGreedy, innerDroppableNotGreedy, "Wrong not greedy");
        Assert.assertEquals(actualOuterDroppable2, outerDroppable2, "Wrong outer droppable 2");
        Assert.assertEquals(actualInnerDroppableGreedy, innerDroppableGreedy, "Wrong greedy");
        Assert.assertEquals(actualWillRevert, expectedWillRevertText, "Wrong will revert");
        Assert.assertEquals(actualNotRevert, notRevert, "Wrong will not revert");
        Assert.assertEquals(actualDropHereRevertDraggable, dropHereRevertDraggable, "Wrong drop her revert draggable");
    }

    @Test
    public void SimpleDragAndDrop() {
        navigateToUrl("droppable");

        String expectedDroppedText = "Dropped!";
        String newColor = "rgba(70, 130, 180, 1)";

        droppablePage.dragAndDrop();

        String actualDroppedText = droppablePage.getRevertDraggableTabText();
        String actualColor = droppablePage.getNewColor();

        Assert.assertEquals(actualColor, newColor, "Wrong color");
        Assert.assertEquals(actualDroppedText, expectedDroppedText, "Wrong dropped text");
    }

    @Test(enabled = true)
    public void AcceptTabDragAndDropAcceptable() {
        navigateToUrl("droppable");
        droppablePage.clickDroppableAcceptTab();
        droppablePage.dragAndDropAcceptable();

        String actualDroppedText = droppablePage.getDragAndDropAcceptable();

        String newColor = "rgba(70, 130, 180, 1)";
        String expectedDroppedText = "Dropped!";
        String actualColor = droppablePage.getColorAcceptable();

        Assert.assertEquals(actualDroppedText, expectedDroppedText, "Wrong dropped text");
        Assert.assertEquals(actualColor, newColor, "Wrong color");
    }

    @Test(enabled = true)
    public void AcceptTabDragAndDropNotAcceptable() {
        navigateToUrl("droppable");
        droppablePage.clickDroppableAcceptTab();
        droppablePage.dragAndDropNotAcceptable();

        String actualDroppedText = droppablePage.getDragAndDropAcceptable();

        String newColor = "rgba(0, 0, 0, 0)";
        String expectedDroppedText = "Drop here";
        String actualColor = droppablePage.getColorNotAcceptable();

        Assert.assertEquals(actualDroppedText, expectedDroppedText, "Wrong dropped text");
        Assert.assertEquals(actualColor, newColor, "Not white color");
    }

    @Test(enabled = true)
    public void PreventPropagationInnerDroppableNotGreedy() {
        navigateToUrl("droppable");
        droppablePage.clickDroppablePreventPropagationTab();
        droppablePage.dragAndDropPropagationOuterDroppableNotGreedy();

        String expectedOuterNotGreedyColor = "rgba(70, 130, 180, 1)";
        String expectedInnerNotGreedyColor = "rgba(70, 130, 180, 1)";
        String expectedDroppedText2 = "Dropped!\nDropped!";
        String actualInnerNotGreedyColor = droppablePage.getInnerDroppableNotGreedyColor();
        String actualOuterNotGreedyColor = droppablePage.getOuterDroppableNotGreedyColor();
        String actualOuterDroppableNotGreedyText = droppablePage.getOuterDroppableNotGreedyText();

        Assert.assertEquals(actualInnerNotGreedyColor, expectedInnerNotGreedyColor, "Wrong inner color");
        Assert.assertEquals(actualOuterNotGreedyColor, expectedOuterNotGreedyColor, "Wrong outer color");
        Assert.assertEquals(actualOuterDroppableNotGreedyText, expectedDroppedText2, "Wrong dropped text");
    }

    @Test(enabled = true)
    public void PreventPropagationInnerDroppableGreedy() {
        navigateToUrl("droppable");
        droppablePage.clickDroppablePreventPropagationTab();
        droppablePage.dragAndDropPropagationInnerDroppableGreedy();

        String expectedInnerGreedyColor = "rgba(70, 130, 180, 1)";
        String expectedOuterGreedyColor = "rgba(0, 0, 0, 0)";
        String expectedOuterDroppableNotGreedyText = "Outer droppable\nDropped!";

        String actualInnerGreedyColor = droppablePage.getInnerDroppableGreedyColor();
        String actualOuterDroppableGreedyColor = droppablePage.getOuterDroppableGreedyColor();
        String actualOuterDroppableNotGreedyText = droppablePage.getOuterDroppableGreedyText();

        Assert.assertEquals(actualInnerGreedyColor, expectedInnerGreedyColor, "Wrong inner color");
        Assert.assertEquals(actualOuterDroppableGreedyColor, expectedOuterGreedyColor, "Wrong outer color");
        Assert.assertEquals(actualOuterDroppableNotGreedyText, expectedOuterDroppableNotGreedyText, "Wrong dropped text");
    }

    @Test(enabled = true)
    public void PreventPropagationOuterDroppableGreedy() {
        navigateToUrl("droppable");
        droppablePage.clickDroppablePreventPropagationTab();
        droppablePage.dragAndDropPropagationOuterDroppableGreedy();

        String expectedOuterGreedyColor = "rgba(70, 130, 180, 1)";
        String expectedInnerGreedyColor = "rgba(0, 0, 0, 0)";       // Use parent color if change
        String expectedOuterDroppableNotGreedyText = "Dropped!\nInner droppable (greedy)";

        String actualInnerGreedyColor = droppablePage.getInnerDroppableGreedyColor();
        String actualOuterDroppableGreedyColor = droppablePage.getOuterDroppableGreedyColor();
        String actualOuterDroppableNotGreedyText = droppablePage.getOuterDroppableGreedyText();

        Assert.assertEquals(actualInnerGreedyColor, expectedInnerGreedyColor, "Wrong inner color");
        Assert.assertEquals(actualOuterDroppableGreedyColor, expectedOuterGreedyColor, "Wrong outer color");
        Assert.assertEquals(actualOuterDroppableNotGreedyText, expectedOuterDroppableNotGreedyText, "Wrong dropped text");
    }

    @Test(enabled = true)
    public void RevertDraggableWillRevert() {
        navigateToUrl("droppable");
        droppablePage.clickRevertDraggableTab();
        String expectedDroppedHereText = "Drop here";

        org.openqa.selenium.Point initialLocation = droppablePage.getInitLocation();
        String actualDroppedHereText = droppablePage.getInitText();
        Assert.assertEquals(actualDroppedHereText, expectedDroppedHereText, "Wrong inner color");

        droppablePage.dragAndDropWillRevert();

        expectedDroppedHereText = "Dropped!";
        actualDroppedHereText = droppablePage.getInitText();
        Assert.assertEquals(actualDroppedHereText, expectedDroppedHereText, "Dropped text missing ");

        org.openqa.selenium.Point afterLocation = droppablePage.getAfterLocation();

        Assert.assertEquals(initialLocation, afterLocation, "Wrong position");
    }

    @Test(enabled = true)
    public void RevertDraggableWillNotRevert() {
        navigateToUrl("droppable");
        droppablePage.clickRevertDraggableTab();
        String expectedDroppedHereText = "Drop here";

        org.openqa.selenium.Point initialLocation = droppablePage.getInitLocation();
        String actualDroppedHereText = droppablePage.getInitText();
        Assert.assertEquals(actualDroppedHereText, expectedDroppedHereText, "Wrong inner color");

        droppablePage.dragAndDropWillNotRevert();

        expectedDroppedHereText = "Dropped!";
        actualDroppedHereText = droppablePage.getInitText();
        Assert.assertEquals(actualDroppedHereText, expectedDroppedHereText, "Dropped text missing ");

        org.openqa.selenium.Point afterLocation = droppablePage.getAfterLocationNot();

        Assert.assertNotEquals(initialLocation, afterLocation, "Wrong position");
    }
}
