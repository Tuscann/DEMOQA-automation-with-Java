package demoqa.web.test.interactions;

import demoqa.web.BaseTest;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DroppablePageTests extends BaseTest {

    @Test(enabled = true)
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

        Assert.assertEquals(actualHeader, expectedHeaderText, "\nWrong header.\n");
        Assert.assertEquals(actualSimpleTab, simpleTabText, "\nWrong simple tab.\n");
        Assert.assertEquals(actualDragMeSimple, expectedDragMeSimple, "\nWrong drag me.\n");
        Assert.assertEquals(actualDropped, expectedDropped, "\nWrong dropped.\n");
        Assert.assertEquals(actualAcceptTabText, acceptTabText, "\nWrong accept tab.\n");
        Assert.assertEquals(actualPreventPropagationTabText, preventPropagationTabText, "\nWrong droppable prevent propagation.\n");
        Assert.assertEquals(actualRevertDraggableTab, revertDraggableTabText, "\nWrong droppable revert draggable.\n");
        Assert.assertEquals(actualAcceptable, acceptable, "\nWrong acceptable.\n");
        Assert.assertEquals(actualNotAcceptable, notAcceptable, "\nWrong not acceptable.\n");
        Assert.assertEquals(actualDropHereAcceptable, acceptableDropHereText, "\nWrong drop her acceptable.\n");
        Assert.assertEquals(actualDragMePreventPropagation, preventPropagationDragMeText, "\nWrong drag me prevent propagation.\n");
        Assert.assertEquals(actualOuterDroppable1, outerDroppable1, "\nWrong outer droppable 1.\n");
        Assert.assertEquals(actualInnerDroppableNotGreedy, innerDroppableNotGreedy, "\nWrong not greedy.\n");
        Assert.assertEquals(actualOuterDroppable2, outerDroppable2, "\nWrong outer droppable 2.\n");
        Assert.assertEquals(actualInnerDroppableGreedy, innerDroppableGreedy, "\nWrong greedy.\n");
        Assert.assertEquals(actualWillRevert, expectedWillRevertText, "\nWrong will revert.\n");
        Assert.assertEquals(actualNotRevert, notRevertText, "\nWrong will not revert.\n");
        Assert.assertEquals(actualDropHereRevertDraggable, revertDraggableDropHere, "\nWrong drop her revert draggable.\n");
    }

    @Test(enabled = true)
    public void SimpleDragAndDrop() {
        navigateToUrl("droppable");

        String expectedDroppedText = "Dropped!";
        String newColor = "rgba(70, 130, 180, 1)";

        droppablePage.dragAndDrop();

        String actualDroppedText = droppablePage.getRevertDraggableTabText();
        String actualColor = droppablePage.getNewBackgroundColor();

        Assert.assertEquals(actualColor, newColor, "\nWrong color.\n");
        Assert.assertEquals(actualDroppedText, expectedDroppedText, "\nWrong dropped text.\n");
    }

    @Test(enabled = true)
    public void AcceptTabDragAndDropAcceptable() {
        navigateToUrl("droppable");
        droppablePage.clickAcceptTab();
        droppablePage.dragAndDropAcceptable();

        String actualDroppedText = droppablePage.getDragAndDropAcceptableText();

        String newColor = "rgba(70, 130, 180, 1)";
        String expectedDroppedText = "Dropped!";
        String actualColor = droppablePage.getColorAcceptable();

        Assert.assertEquals(actualDroppedText, expectedDroppedText, "\nWrong dropped text.\n");
        Assert.assertEquals(actualColor, newColor, "\nWrong color.\n");
    }

    @Test(enabled = true)
    public void AcceptTabDragAndDropNotAcceptable() {
        navigateToUrl("droppable");
        droppablePage.clickAcceptTab();
        droppablePage.dragAndDropNotAcceptable();

        String actualDroppedText = droppablePage.getDragAndDropAcceptableText();

        String newColor = "rgba(0, 0, 0, 0)";
        String expectedDroppedText = "Drop here";
        String actualColor = droppablePage.getColorNotAcceptable();

        Assert.assertEquals(actualDroppedText, expectedDroppedText, "\nWrong dropped text.\n");
        Assert.assertEquals(actualColor, newColor, "\nNot white color.\n");
    }

    @Test(enabled = true)
    public void PreventPropagationInnerDroppableNotGreedy() {
        navigateToUrl("droppable");
        droppablePage.clickPreventPropagationTab();

        String expectedOuterNotGreedyColorBefore = "rgba(0, 0, 0, 0)";
        String expectedInnerNotGreedyColorBefore = "rgba(0, 0, 0, 0)";

        String actualInnerNotGreedyColor = droppablePage.getInnerDroppableNotGreedyColor();
        String actualOuterNotGreedyColor = droppablePage.getOuterDroppableNotGreedyColor();

        Assert.assertEquals(actualInnerNotGreedyColor, expectedOuterNotGreedyColorBefore, "\nWrong inner color.\n");
        Assert.assertEquals(actualOuterNotGreedyColor, expectedInnerNotGreedyColorBefore, "\nWrong outer color.\n");

        droppablePage.dragAndDropPropagationOuterDroppableNotGreedy();

        String expectedOuterNotGreedyColorAfter = "rgba(70, 130, 180, 1)";
        String expectedInnerNotGreedyColorAfter = "rgba(70, 130, 180, 1)";
        String expectedDroppedText2 = "Dropped!\nDropped!";

        actualInnerNotGreedyColor = droppablePage.getInnerDroppableNotGreedyColor();
        actualOuterNotGreedyColor = droppablePage.getOuterDroppableNotGreedyColor();
        String actualOuterDroppableNotGreedyText = droppablePage.getOuterDroppableNotGreedyText();

        Assert.assertEquals(actualInnerNotGreedyColor, expectedInnerNotGreedyColorAfter, "\nWrong inner color.\n");
        Assert.assertEquals(actualOuterNotGreedyColor, expectedOuterNotGreedyColorAfter, "\nWrong outer color.\n");
        Assert.assertEquals(actualOuterDroppableNotGreedyText, expectedDroppedText2, "\nWrong dropped text.\n");
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

        Assert.assertEquals(actualInnerGreedyColor, expectedInnerGreedyColor, "\nWrong inner color.\n");
        Assert.assertEquals(actualOuterDroppableGreedyColor, expectedOuterGreedyColor, "\nWrong outer color.\n");
        Assert.assertEquals(actualOuterDroppableNotGreedyText, expectedOuterDroppableNotGreedyText, "\nWrong dropped text.\n");
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

        Assert.assertEquals(actualInnerGreedyColor, expectedInnerGreedyColor, "\nWrong inner color.\n");
        Assert.assertEquals(actualOuterDroppableGreedyColor, expectedOuterGreedyColor, "\nWrong outer color.\n");
        Assert.assertEquals(actualOuterDroppableNotGreedyText, expectedOuterDroppableNotGreedyText, "\nWrong dropped text.\n");
    }

    @Test(enabled = true)
    public void RevertDraggableWillRevert() {
        navigateToUrl("droppable");
        droppablePage.clickRevertDraggableTab();
        String expectedDroppedHereText = "Drop here";

        Point initialLocation = droppablePage.getInitLocation();
        String actualDroppedHereText = droppablePage.getInitText();
        Assert.assertEquals(actualDroppedHereText, expectedDroppedHereText, "\nWrong inner color.\n");

        droppablePage.dragAndDropWillRevert();

        expectedDroppedHereText = "Dropped!";
        actualDroppedHereText = droppablePage.getInitText();
        Assert.assertEquals(actualDroppedHereText, expectedDroppedHereText, "\nDropped text missing.\n");

        Point afterLocation = droppablePage.getEndLocation(initialLocation.x, initialLocation.y);

        Assert.assertEquals(initialLocation, afterLocation, "\nWrong position.\n");
    }

    @Test(enabled = true)
    public void RevertDraggableWillNotRevert() {
        navigateToUrl("droppable");
        droppablePage.clickRevertDraggableTab();
        String expectedDroppedHereText = "Drop here";

        Point initialLocation = droppablePage.getInitLocation();
        String actualDroppedHereText = droppablePage.getInitText();
        Assert.assertEquals(actualDroppedHereText, expectedDroppedHereText, "\nWrong inner color.\n");

        droppablePage.dragAndDropWillNotRevert();

        expectedDroppedHereText = "Dropped!";
        actualDroppedHereText = droppablePage.getInitText();
        Assert.assertEquals(actualDroppedHereText, expectedDroppedHereText, "\nDropped text missing.\n");

        Point afterLocation = droppablePage.getAfterLocationNot();

        Assert.assertNotEquals(initialLocation, afterLocation, "\nWrong position.\n");
    }
}
