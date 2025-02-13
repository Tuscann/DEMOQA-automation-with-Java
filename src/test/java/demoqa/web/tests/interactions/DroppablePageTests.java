package demoqa.web.tests.interactions;

import demoqa.web.base.BaseTest;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

public class DroppablePageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on page")
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

        softAssert.assertEquals(actualHeader, expectedHeaderText, "\nWrong header.\n");
        softAssert.assertEquals(actualSimpleTab, simpleTabText, "\nWrong simple tab.\n");
        softAssert.assertEquals(actualDragMeSimple, expectedDragMeSimple, "\nWrong drag me.\n");
        softAssert.assertEquals(actualDropped, expectedDropped, "\nWrong dropped.\n");
        softAssert.assertEquals(actualAcceptTabText, acceptTabText, "\nWrong accept tab.\n");
        softAssert.assertEquals(actualPreventPropagationTabText, preventPropagationTabText, "\nWrong droppable prevent propagation.\n");
        softAssert.assertEquals(actualRevertDraggableTab, revertDraggableTabText, "\nWrong droppable revert draggable.\n");
        softAssert.assertEquals(actualAcceptable, acceptable, "\nWrong acceptable.\n");
        softAssert.assertEquals(actualNotAcceptable, notAcceptable, "\nWrong not acceptable.\n");
        softAssert.assertEquals(actualDropHereAcceptable, acceptableDropHereText, "\nWrong drop her acceptable.\n");
        softAssert.assertEquals(actualDragMePreventPropagation, preventPropagationDragMeText, "\nWrong drag me prevent propagation.\n");
        softAssert.assertEquals(actualOuterDroppable1, outerDroppable1, "\nWrong outer droppable 1.\n");
        softAssert.assertEquals(actualInnerDroppableNotGreedy, innerDroppableNotGreedy, "\nWrong not greedy.\n");
        softAssert.assertEquals(actualOuterDroppable2, outerDroppable2, "\nWrong outer droppable 2.\n");
        softAssert.assertEquals(actualInnerDroppableGreedy, innerDroppableGreedy, "\nWrong greedy.\n");
        softAssert.assertEquals(actualWillRevert, expectedWillRevertText, "\nWrong will revert.\n");
        softAssert.assertEquals(actualNotRevert, notRevertText, "\nWrong will not revert.\n");
        softAssert.assertEquals(actualDropHereRevertDraggable, revertDraggableDropHere, "\nWrong drop her revert draggable.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Simple drag and drop")
    public void SimpleDragAndDrop() {
        navigateToUrl("droppable");

        String expectedDroppedText = "Dropped!";
        String newColor = "rgba(70, 130, 180, 1)";

        droppablePage.dragAndDrop();

        String actualDroppedText = droppablePage.getRevertDraggableTabText();
        String actualColor = droppablePage.getNewBackgroundColor();

        softAssert.assertEquals(actualColor, newColor, "\nWrong color.\n");
        softAssert.assertEquals(actualDroppedText, expectedDroppedText, "\nWrong dropped text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Accept tab drag and drop acceptable")
    public void AcceptTabDragAndDropAcceptable() {
        navigateToUrl("droppable");
        droppablePage.clickAcceptTab();
        droppablePage.dragAndDropAcceptable();

        String actualDroppedText = droppablePage.getDragAndDropAcceptableText();

        String newColor = "rgba(70, 130, 180, 1)";
        String expectedDroppedText = "Dropped!";
        String actualColor = droppablePage.getColorAcceptable();

        softAssert.assertEquals(actualDroppedText, expectedDroppedText, "\nWrong dropped text.\n");
        softAssert.assertEquals(actualColor, newColor, "\nWrong color.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Accept tab drag and drop not acceptable")
    public void AcceptTabDragAndDropNotAcceptable() {
        navigateToUrl("droppable");
        droppablePage.clickAcceptTab();
        droppablePage.dragAndDropNotAcceptable();

        String actualDroppedText = droppablePage.getDragAndDropAcceptableText();

        String newColor = "rgba(0, 0, 0, 0)";
        String expectedDroppedText = "Drop here";
        String actualColor = droppablePage.getColorNotAcceptable();

        softAssert.assertEquals(actualDroppedText, expectedDroppedText, "\nWrong dropped text.\n");
        softAssert.assertEquals(actualColor, newColor, "\nNot white color.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Prevent propagation outer droppable not greedy")
    public void PreventPropagationInnerDroppableNotGreedy() {
        navigateToUrl("droppable");
        droppablePage.clickPreventPropagationTab();

        String expectedOuterNotGreedyColorBefore = "rgba(0, 0, 0, 0)";
        String expectedInnerNotGreedyColorBefore = "rgba(0, 0, 0, 0)";

        String actualInnerNotGreedyColor = droppablePage.getInnerDroppableNotGreedyColor();
        String actualOuterNotGreedyColor = droppablePage.getOuterDroppableNotGreedyColor();

        softAssert.assertEquals(actualInnerNotGreedyColor, expectedOuterNotGreedyColorBefore, "\nWrong inner color.\n");
        softAssert.assertEquals(actualOuterNotGreedyColor, expectedInnerNotGreedyColorBefore, "\nWrong outer color.\n");

        droppablePage.dragAndDropPropagationOuterDroppableNotGreedy();

        String expectedOuterNotGreedyColorAfter = "rgba(70, 130, 180, 1)";
        String expectedInnerNotGreedyColorAfter = "rgba(70, 130, 180, 1)";
        String expectedDroppedText2 = "Dropped!\nDropped!";

        actualInnerNotGreedyColor = droppablePage.getInnerDroppableNotGreedyColor();
        actualOuterNotGreedyColor = droppablePage.getOuterDroppableNotGreedyColor();
        String actualOuterDroppableNotGreedyText = droppablePage.getOuterDroppableNotGreedyText();

        softAssert.assertEquals(actualInnerNotGreedyColor, expectedInnerNotGreedyColorAfter, "\nWrong inner color.\n");
        softAssert.assertEquals(actualOuterNotGreedyColor, expectedOuterNotGreedyColorAfter, "\nWrong outer color.\n");
        softAssert.assertEquals(actualOuterDroppableNotGreedyText, expectedDroppedText2, "\nWrong dropped text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Prevent propagation inner droppable greedy")
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

        softAssert.assertEquals(actualInnerGreedyColor, expectedInnerGreedyColor, "\nWrong inner color.\n");
        softAssert.assertEquals(actualOuterDroppableGreedyColor, expectedOuterGreedyColor, "\nWrong outer color.\n");
        softAssert.assertEquals(actualOuterDroppableNotGreedyText, expectedOuterDroppableNotGreedyText, "\nWrong dropped text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Prevent propagation outer droppable greedy")
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

        softAssert.assertEquals(actualInnerGreedyColor, expectedInnerGreedyColor, "\nWrong inner color.\n");
        softAssert.assertEquals(actualOuterDroppableGreedyColor, expectedOuterGreedyColor, "\nWrong outer color.\n");
        softAssert.assertEquals(actualOuterDroppableNotGreedyText, expectedOuterDroppableNotGreedyText, "\nWrong dropped text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Revert draggable will revert")
    public void RevertDraggableWillRevert() {
        navigateToUrl("droppable");
        droppablePage.clickRevertDraggableTab();
        String expectedDroppedHereText = "Drop here";

        Point initialLocation = droppablePage.getInitLocation();
        String actualDroppedHereText = droppablePage.getInitText();
        softAssert.assertEquals(actualDroppedHereText, expectedDroppedHereText, "\nWrong inner color.\n");

        droppablePage.dragAndDropWillRevert();

        expectedDroppedHereText = "Dropped!";
        actualDroppedHereText = droppablePage.getInitText();
        softAssert.assertEquals(actualDroppedHereText, expectedDroppedHereText, "\nDropped text missing.\n");

        Point afterLocation = droppablePage.getEndLocation(initialLocation.x, initialLocation.y);

        softAssert.assertEquals(initialLocation, afterLocation, "\nWrong position.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Revert draggable will not revert")
    public void RevertDraggableWillNotRevert() {
        navigateToUrl("droppable");
        droppablePage.clickRevertDraggableTab();
        String expectedDroppedHereText = "Drop here";

        Point initialLocation = droppablePage.getInitLocation();
        String actualDroppedHereText = droppablePage.getInitText();
        softAssert.assertEquals(actualDroppedHereText, expectedDroppedHereText, "\nWrong inner color.\n");

        droppablePage.dragAndDropWillNotRevert();

        expectedDroppedHereText = "Dropped!";
        actualDroppedHereText = droppablePage.getInitText();
        softAssert.assertEquals(actualDroppedHereText, expectedDroppedHereText, "\nDropped text missing.\n");

        Point afterLocation = droppablePage.getAfterLocationNot();

        softAssert.assertNotEquals(initialLocation, afterLocation, "\nWrong position.\n");

        softAssert.assertAll();
    }
}
