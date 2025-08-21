package demoqa.web.tests.interactions;

import demoqa.pages.interactions.DroppablePage;
import demoqa.web.base.BaseTest;
import org.openqa.selenium.Point;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DroppablePageTests extends BaseTest {
    // Text Constants
    private static final String PAGE_HEADER_TEXT = "Droppable";
    private static final String SIMPLE_TAB_TEXT = "Simple";
    private static final String DRAG_ME_TEXT = "Drag me";
    private static final String DROP_HERE_TEXT = "Drop here";
    private static final String ACCEPT_TAB_TEXT = "Accept";
    private static final String ACCEPTABLE_TEXT = "Acceptable";
    private static final String NOT_ACCEPTABLE_TEXT = "Not Acceptable";
    private static final String PREVENT_PROPAGATION_TAB_TEXT = "Prevent Propogation";
    private static final String DRAG_ME_PREVENT_PROPAGATION_TEXT = "Drag Me";
    private static final String OUTER_DROPPABLE_TEXT = "Outer droppable";
    private static final String INNER_DROPPABLE_NOT_GREEDY_TEXT = "Inner droppable (not greedy)";
    private static final String INNER_DROPPABLE_GREEDY_TEXT = "Inner droppable (greedy)";
    private static final String REVERT_DRAGGABLE_TAB_TEXT = "Revert Draggable";
    private static final String WILL_REVERT_TEXT = "Will Revert";
    private static final String NOT_REVERT_TEXT = "Not Revert";
    private static final String DROPPED_TEXT = "Dropped!";
    private static final String DROPPED_TEXT_DOUBLE = "Dropped!\nDropped!";
    private static final String OUTER_DROPPABLE_DROPPED_TEXT = "Outer droppable\nDropped!";
    private static final String OUTER_DROPPABLE_INNER_DROPPABLE_TEXT = "Dropped!\nInner droppable (greedy)";

    // Color Constants
    private static final String NEW_BACKGROUND_COLOR = "rgba(70, 130, 180, 1)";
    private static final String TRANSPARENT_COLOR = "rgba(0, 0, 0, 0)";

    // Error Message Constants
    private static final String HEADER_ERROR = "Header text mismatch";
    private static final String SIMPLE_TAB_ERROR = "Simple tab text mismatch";
    private static final String DRAG_ME_ERROR = "Drag me text mismatch";
    private static final String DROPPED_ERROR = "Dropped text mismatch";
    private static final String ACCEPT_TAB_ERROR = "Accept tab text mismatch";
    private static final String PREVENT_PROPAGATION_TAB_ERROR = "Prevent propagation tab text mismatch";
    private static final String REVERT_DRAGGABLE_TAB_ERROR = "Revert draggable tab text mismatch";
    private static final String ACCEPTABLE_ERROR = "Acceptable text mismatch";
    private static final String NOT_ACCEPTABLE_ERROR = "Not acceptable text mismatch";
    private static final String DROP_HERE_ACCEPTABLE_ERROR = "Drop here acceptable text mismatch";
    private static final String DRAG_ME_PREVENT_PROPAGATION_ERROR = "Drag me prevent propagation text mismatch";
    private static final String OUTER_DROPPABLE_1_ERROR = "Outer droppable 1 text mismatch";
    private static final String INNER_DROPPABLE_NOT_GREEDY_ERROR = "Inner droppable not greedy text mismatch";
    private static final String OUTER_DROPPABLE_2_ERROR = "Outer droppable 2 text mismatch";
    private static final String INNER_DROPPABLE_GREEDY_ERROR = "Inner droppable greedy text mismatch";
    private static final String WILL_REVERT_ERROR = "Will revert text mismatch";
    private static final String NOT_REVERT_ERROR = "Not revert text mismatch";
    private static final String DROP_HERE_REVERT_DRAGGABLE_ERROR = "Drop here revert draggable text mismatch";
    private static final String COLOR_ERROR = "Color mismatch";
    private static final String DROPPED_TEXT_ERROR = "Dropped text mismatch";
    private static final String INNER_COLOR_ERROR = "Inner color mismatch";
    private static final String OUTER_COLOR_ERROR = "Outer color mismatch";
    private static final String DROPPED_TEXT_DOUBLE_ERROR = "Dropped text double mismatch";
    private static final String OUTER_DROPPABLE_NOT_GREEDY_TEXT_ERROR = "Outer droppable not greedy text mismatch";
    private static final String OUTER_DROPPABLE_GREEDY_TEXT_ERROR = "Outer droppable greedy text mismatch";
    private static final String DROP_HERE_TEXT_ERROR = "Drop here text mismatch";
    private static final String DROPPED_TEXT_MISSING_ERROR = "Dropped text missing";
    private static final String POSITION_ERROR = "Position mismatch";

    public static final String DROPPABLE_URL = "droppable";
    private DroppablePage droppablePage;

    @BeforeMethod
    public void goToDroppablePage() {
        navigateToUrl(DROPPABLE_URL);
        droppablePage = new DroppablePage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange & Act
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

        // Assert
        softAssert.assertEquals(actualHeader, PAGE_HEADER_TEXT, HEADER_ERROR);
        softAssert.assertEquals(actualSimpleTab, SIMPLE_TAB_TEXT, SIMPLE_TAB_ERROR);
        softAssert.assertEquals(actualDragMeSimple, DRAG_ME_TEXT, DRAG_ME_ERROR);
        softAssert.assertEquals(actualDropped, DROP_HERE_TEXT, DROPPED_ERROR);
        softAssert.assertEquals(actualAcceptTabText, ACCEPT_TAB_TEXT, ACCEPT_TAB_ERROR);
        softAssert.assertEquals(actualPreventPropagationTabText, PREVENT_PROPAGATION_TAB_TEXT, PREVENT_PROPAGATION_TAB_ERROR);
        softAssert.assertEquals(actualRevertDraggableTab, REVERT_DRAGGABLE_TAB_TEXT, REVERT_DRAGGABLE_TAB_ERROR);
        softAssert.assertEquals(actualAcceptable, ACCEPTABLE_TEXT, ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualNotAcceptable, NOT_ACCEPTABLE_TEXT, NOT_ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualDropHereAcceptable, DROP_HERE_TEXT, DROP_HERE_ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualDragMePreventPropagation, DRAG_ME_PREVENT_PROPAGATION_TEXT, DRAG_ME_PREVENT_PROPAGATION_ERROR);
        softAssert.assertEquals(actualOuterDroppable1, OUTER_DROPPABLE_TEXT, OUTER_DROPPABLE_1_ERROR);
        softAssert.assertEquals(actualInnerDroppableNotGreedy, INNER_DROPPABLE_NOT_GREEDY_TEXT, INNER_DROPPABLE_NOT_GREEDY_ERROR);
        softAssert.assertEquals(actualOuterDroppable2, OUTER_DROPPABLE_TEXT, OUTER_DROPPABLE_2_ERROR);
        softAssert.assertEquals(actualInnerDroppableGreedy, INNER_DROPPABLE_GREEDY_TEXT, INNER_DROPPABLE_GREEDY_ERROR);
        softAssert.assertEquals(actualWillRevert, WILL_REVERT_TEXT, WILL_REVERT_ERROR);
        softAssert.assertEquals(actualNotRevert, NOT_REVERT_TEXT, NOT_REVERT_ERROR);
        softAssert.assertEquals(actualDropHereRevertDraggable, DROP_HERE_TEXT, DROP_HERE_REVERT_DRAGGABLE_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Simple drag and drop")
    public void simpleDragAndDrop() {
        // Arrange & Act
        droppablePage.dragAndDrop();

        String actualDroppedText = droppablePage.getRevertDraggableTabText();
        String actualColor = droppablePage.getNewBackgroundColor();

        softAssert.assertEquals(actualColor, NEW_BACKGROUND_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualDroppedText, DROPPED_TEXT, DROPPED_TEXT_ERROR);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Accept tab drag and drop acceptable")
    public void acceptTabDragAndDropAcceptable() {
        // Arrange & Act
        droppablePage.clickAcceptTab();
        droppablePage.dragAndDropAcceptable();

        String actualDroppedText = droppablePage.getDragAndDropAcceptableText();
        String actualColor = droppablePage.getColorAcceptable();

        // Assert
        softAssert.assertEquals(actualDroppedText, DROPPED_TEXT, DROPPED_TEXT_ERROR);
        softAssert.assertEquals(actualColor, NEW_BACKGROUND_COLOR, COLOR_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Accept tab drag and drop not acceptable")
    public void acceptTabDragAndDropNotAcceptable() {
        // Arrange & Act
        droppablePage.clickAcceptTab();
        droppablePage.dragAndDropNotAcceptable();

        String actualDroppedText = droppablePage.getDragAndDropAcceptableText();
        String actualColor = droppablePage.getColorNotAcceptable();

        // Assert
        softAssert.assertEquals(actualDroppedText, DROP_HERE_TEXT, DROP_HERE_TEXT_ERROR);
        softAssert.assertEquals(actualColor, TRANSPARENT_COLOR, COLOR_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Prevent propagation outer droppable not greedy")
    public void preventPropagationInnerDroppableNotGreedy() {
        // Arrange & Act
        droppablePage.clickPreventPropagationTab();

        String actualInnerNotGreedyColor = droppablePage.getInnerDroppableNotGreedyColor();
        String actualOuterNotGreedyColor = droppablePage.getOuterDroppableNotGreedyColor();

        softAssert.assertEquals(actualInnerNotGreedyColor, TRANSPARENT_COLOR, INNER_COLOR_ERROR);
        softAssert.assertEquals(actualOuterNotGreedyColor, TRANSPARENT_COLOR, OUTER_COLOR_ERROR);

        droppablePage.dragAndDropPropagationOuterDroppableNotGreedy();

        actualInnerNotGreedyColor = droppablePage.getInnerDroppableNotGreedyColor();
        actualOuterNotGreedyColor = droppablePage.getOuterDroppableNotGreedyColor();
        String actualOuterDroppableNotGreedyText = droppablePage.getOuterDroppableNotGreedyText();

        // Assert
        softAssert.assertEquals(actualInnerNotGreedyColor, NEW_BACKGROUND_COLOR, INNER_COLOR_ERROR);
        softAssert.assertEquals(actualOuterNotGreedyColor, NEW_BACKGROUND_COLOR, OUTER_COLOR_ERROR);
        softAssert.assertEquals(actualOuterDroppableNotGreedyText, DROPPED_TEXT_DOUBLE, DROPPED_TEXT_DOUBLE_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Prevent propagation inner droppable greedy")
    public void preventPropagationInnerDroppableGreedy() {
        // Arrange & Act
        droppablePage.clickPreventPropagationTab();
        droppablePage.dragAndDropPropagationInnerDroppableGreedy();

        String actualInnerGreedyColor = droppablePage.getInnerDroppableGreedyColor();
        String actualOuterDroppableGreedyColor = droppablePage.getOuterDroppableGreedyColor();
        String actualOuterDroppableNotGreedyText = droppablePage.getOuterDroppableGreedyText();

        // Assert
        softAssert.assertEquals(actualInnerGreedyColor, NEW_BACKGROUND_COLOR, INNER_COLOR_ERROR);
        softAssert.assertEquals(actualOuterDroppableGreedyColor, TRANSPARENT_COLOR, OUTER_COLOR_ERROR);
        softAssert.assertEquals(actualOuterDroppableNotGreedyText, OUTER_DROPPABLE_DROPPED_TEXT, OUTER_DROPPABLE_NOT_GREEDY_TEXT_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Prevent propagation outer droppable greedy")
    public void preventPropagationOuterDroppableGreedy() {
        // Arrange & Act
        droppablePage.clickPreventPropagationTab();
        droppablePage.dragAndDropPropagationOuterDroppableGreedy();

        String actualInnerGreedyColor = droppablePage.getInnerDroppableGreedyColor();
        String actualOuterDroppableGreedyColor = droppablePage.getOuterDroppableGreedyColor();
        String actualOuterDroppableNotGreedyText = droppablePage.getOuterDroppableGreedyText();

        // Assert
        softAssert.assertEquals(actualInnerGreedyColor, TRANSPARENT_COLOR, INNER_COLOR_ERROR);
        softAssert.assertEquals(actualOuterDroppableGreedyColor, NEW_BACKGROUND_COLOR, OUTER_COLOR_ERROR);
        softAssert.assertEquals(actualOuterDroppableNotGreedyText, OUTER_DROPPABLE_INNER_DROPPABLE_TEXT, OUTER_DROPPABLE_GREEDY_TEXT_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Revert draggable will revert")
    public void revertDraggableWillRevert() {
        // Arrange & Act
        droppablePage.clickRevertDraggableTab();

        Point initialLocation = droppablePage.getInitLocation();
        String actualDroppedHereText = droppablePage.getInitText();
        softAssert.assertEquals(actualDroppedHereText, DROP_HERE_TEXT, DROP_HERE_TEXT_ERROR);

        droppablePage.dragAndDropWillRevert();

        actualDroppedHereText = droppablePage.getInitText();
        softAssert.assertEquals(actualDroppedHereText, DROPPED_TEXT, DROPPED_TEXT_MISSING_ERROR);

        Point afterLocation = droppablePage.getEndLocation(initialLocation.x, initialLocation.y);

        // Assert
        softAssert.assertEquals(initialLocation, afterLocation, POSITION_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Revert draggable will not revert")
    public void revertDraggableWillNotRevert() {
        // Arrange & Act
        droppablePage.clickRevertDraggableTab();

        Point initialLocation = droppablePage.getInitLocation();
        String actualDroppedHereText = droppablePage.getInitText();
        softAssert.assertEquals(actualDroppedHereText, DROP_HERE_TEXT, DROP_HERE_TEXT_ERROR);

        droppablePage.dragAndDropWillNotRevert();

        actualDroppedHereText = droppablePage.getInitText();
        softAssert.assertEquals(actualDroppedHereText, DROPPED_TEXT, DROPPED_TEXT_MISSING_ERROR);

        Point afterLocation = droppablePage.getAfterLocationNot();

        softAssert.assertNotEquals(initialLocation, afterLocation, POSITION_ERROR);
        softAssert.assertAll();
    }
}
