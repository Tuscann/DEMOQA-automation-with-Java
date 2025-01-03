package demoqa.web.test.interactions;

import demoqa.web.BaseTest;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DroppablePageTests extends BaseTest {

    @Test
    public void VerifyAllTextOnPage() {
        navigateToUrl("droppable");

        String expectedHeaderText = "Droppable";
        String simpleTabText = "Simple";
        String expectedDragMeSimple = "Drag me";
        String expectedDropped = "Drop here";
        String acceptTabText = "Accept";
        String acceptable = "Acceptable";
        String notAcceptable = "Not Acceptable";
        String acceptableDropHereText = "Drop here";
        String preventPropagationTabText = "Prevent Propogation";
        String preventPropagationDragMeText = "Drag Me";
        String outerDroppable1 = "Outer droppable";
        String innerDroppableNotGreedy = "Inner droppable (not greedy)";
        String outerDroppable2 = "Outer droppable";
        String innerDroppableGreedy = "Inner droppable (greedy)";
        String revertDraggableTabText = "Revert Draggable";
        String expectedWillRevertText = "Will Revert";
        String notRevertText = "Not Revert";
        String revertDraggableDropHere = "Drop here";

        String actualHeader = droppablePage.getExpectedHeader();
        String actualSimpleTab = droppablePage.getExpectedSimpleTab();
        String actualDragMeSimple = droppablePage.getSimpleTabDragMe();
        String actualDropped = droppablePage.getDroppedContainer();

        droppablePage.clickAcceptTab();
        String actualAcceptTabText = droppablePage.getDroppableAcceptTab();
        String actualAcceptable = droppablePage.getAcceptTabAcceptable();
        String actualNotAcceptable = droppablePage.getAcceptTabNotAcceptable();
        String actualDropHereAcceptable = droppablePage.getAcceptableDropHere();

        droppablePage.clickPreventPropagationTab();
        String actualPreventPropagationTabText = droppablePage.getDroppablePreventPropagationTab();
        String actualDragMePreventPropagation = droppablePage.getDragMePreventPropagation();
        String actualOuterDroppable1 = droppablePage.getOuterDroppable1Text();
        String actualInnerDroppableNotGreedy = droppablePage.getInnerDroppableNotGreedyText();
        String actualOuterDroppable2 = droppablePage.getOuterDroppable2();
        String actualInnerDroppableGreedy = droppablePage.getInnerDroppableGreedy();

        droppablePage.clickRevertDraggableTab();
        String actualRevertDraggableTab = droppablePage.getRevertDraggableTab();
        String actualWillRevert = droppablePage.getWillRevert();
        String actualNotRevert = droppablePage.getNotRevert();
        String actualDropHereRevertDraggable = droppablePage.getDropHereRevertDraggable();

        Assert.assertEquals(actualHeader, expectedHeaderText, "Wrong header");
        Assert.assertEquals(actualSimpleTab, simpleTabText, "Wrong simple tab");
        Assert.assertEquals(actualDragMeSimple, expectedDragMeSimple, "Wrong drag me");
        Assert.assertEquals(actualDropped, expectedDropped, "Wrong dropped");
        Assert.assertEquals(actualAcceptTabText, acceptTabText, "Wrong accept tab");
        Assert.assertEquals(actualPreventPropagationTabText, preventPropagationTabText, "Wrong droppable prevent propagation");
        Assert.assertEquals(actualRevertDraggableTab, revertDraggableTabText, "Wrong droppable revert draggable");
        Assert.assertEquals(actualAcceptable, acceptable, "Wrong acceptable");
        Assert.assertEquals(actualNotAcceptable, notAcceptable, "Wrong not acceptable");
        Assert.assertEquals(actualDropHereAcceptable, acceptableDropHereText, "Wrong drop her acceptable");
        Assert.assertEquals(actualDragMePreventPropagation, preventPropagationDragMeText, "Wrong drag me prevent propagation");
        Assert.assertEquals(actualOuterDroppable1, outerDroppable1, "Wrong outer droppable 1");
        Assert.assertEquals(actualInnerDroppableNotGreedy, innerDroppableNotGreedy, "Wrong not greedy");
        Assert.assertEquals(actualOuterDroppable2, outerDroppable2, "Wrong outer droppable 2");
        Assert.assertEquals(actualInnerDroppableGreedy, innerDroppableGreedy, "Wrong greedy");
        Assert.assertEquals(actualWillRevert, expectedWillRevertText, "Wrong will revert");
        Assert.assertEquals(actualNotRevert, notRevertText, "Wrong will not revert");
        Assert.assertEquals(actualDropHereRevertDraggable, revertDraggableDropHere, "Wrong drop her revert draggable");
    }

    @Test
    public void SimpleDragAndDrop() {
        navigateToUrl("droppable");

        String expectedDroppedText = "Dropped!";
        String newColor = "rgba(70, 130, 180, 1)";

        droppablePage.dragAndDrop();

        String actualDroppedText = droppablePage.getRevertDraggableTabText();
        String actualColor = droppablePage.getNewBackgroundColor();

        Assert.assertEquals(actualColor, newColor, "Wrong color");
        Assert.assertEquals(actualDroppedText, expectedDroppedText, "Wrong dropped text");
    }

    @Test(enabled = true)
    public void AcceptTabDragAndDropAcceptable() {
        navigateToUrl("droppable");
        droppablePage.clickAcceptTab();
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
        droppablePage.clickAcceptTab();
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
        droppablePage.clickPreventPropagationTab();

        String expectedOuterNotGreedyColorBefore = "rgba(0, 0, 0, 0)";
        String expectedInnerNotGreedyColorBefore = "rgba(0, 0, 0, 0)";

        String actualInnerNotGreedyColor = droppablePage.getInnerDroppableNotGreedyColor();
        String actualOuterNotGreedyColor = droppablePage.getOuterDroppableNotGreedyColor();

        Assert.assertEquals(actualInnerNotGreedyColor, expectedOuterNotGreedyColorBefore, "Wrong inner color");
        Assert.assertEquals(actualOuterNotGreedyColor, expectedInnerNotGreedyColorBefore, "Wrong outer color");

        droppablePage.dragAndDropPropagationOuterDroppableNotGreedy();

        String expectedOuterNotGreedyColorAfter = "rgba(70, 130, 180, 1)";
        String expectedInnerNotGreedyColorAfter = "rgba(70, 130, 180, 1)";
        String expectedDroppedText2 = "Dropped!\nDropped!";

        actualInnerNotGreedyColor = droppablePage.getInnerDroppableNotGreedyColor();
        actualOuterNotGreedyColor = droppablePage.getOuterDroppableNotGreedyColor();
        String actualOuterDroppableNotGreedyText = droppablePage.getOuterDroppableNotGreedyText();

        Assert.assertEquals(actualInnerNotGreedyColor, expectedInnerNotGreedyColorAfter, "Wrong inner color");
        Assert.assertEquals(actualOuterNotGreedyColor, expectedOuterNotGreedyColorAfter, "Wrong outer color");
        Assert.assertEquals(actualOuterDroppableNotGreedyText, expectedDroppedText2, "Wrong dropped text");
    }

    @Test(enabled = true)
    public void PreventPropagationInnerDroppableGreedy() {
        navigateToUrl("droppable");
        droppablePage.clickPreventPropagationTab();
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
        droppablePage.clickPreventPropagationTab();
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

    @Test(enabled = false)
    public void RevertDraggableWillRevert() {
        navigateToUrl("droppable");
        droppablePage.clickRevertDraggableTab();
        String expectedDroppedHereText = "Drop here";

        Point initialLocation = droppablePage.getInitLocation();
        String actualDroppedHereText = droppablePage.getInitText();
        Assert.assertEquals(actualDroppedHereText, expectedDroppedHereText, "Wrong inner color");

        droppablePage.dragAndDropWillRevert();

        expectedDroppedHereText = "Dropped!";
        actualDroppedHereText = droppablePage.getInitText();
        Assert.assertEquals(actualDroppedHereText, expectedDroppedHereText, "Dropped text missing ");

        Point afterLocation = droppablePage.getAfterLocation();

        Assert.assertEquals(initialLocation, afterLocation, "Wrong position");
    }

    @Test(enabled = true)
    public void RevertDraggableWillNotRevert() {
        navigateToUrl("droppable");
        droppablePage.clickRevertDraggableTab();
        String expectedDroppedHereText = "Drop here";

        Point initialLocation = droppablePage.getInitLocation();
        String actualDroppedHereText = droppablePage.getInitText();
        Assert.assertEquals(actualDroppedHereText, expectedDroppedHereText, "Wrong inner color");

        droppablePage.dragAndDropWillNotRevert();

        expectedDroppedHereText = "Dropped!";
        actualDroppedHereText = droppablePage.getInitText();
        Assert.assertEquals(actualDroppedHereText, expectedDroppedHereText, "Dropped text missing ");

        Point afterLocation = droppablePage.getAfterLocationNot();

        Assert.assertNotEquals(initialLocation, afterLocation, "Wrong position");
    }
}
