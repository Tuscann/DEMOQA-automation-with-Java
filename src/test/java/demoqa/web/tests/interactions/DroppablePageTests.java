package demoqa.web.tests.interactions;

import demoqa.pages.interactions.DroppablePage;
import demoqa.web.base.BaseTest;
import org.openqa.selenium.Point;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DroppablePageTests extends BaseTest {
    public static final String DROPPABLE_URL = "droppable";
    // Text Constants
    private static final String PAGE_HEADER_TEXT = "Droppable";
    private static final String SIMPLE_TAB_TEXT = "Simple";
    private static final String DRAG_ME_TEXT = "Drag me";
    private static final String DRAG_ME_TEXT2 = "Drag Me";
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
    private static final String OUTER_DROPPABLE_BEFORE_TEXT = "Outer droppable\n" +
            "Inner droppable (not greedy)";
    private static final String OUTER_DROPPABLE_AFTER_TEXT = "Dropped!\n" +
            "Inner droppable (not greedy)";
    private static final String OUTER_DROPPABLE_GREEDY_TEXT_BEFORE = "Outer droppable\n" +
            "Inner droppable (greedy)";
    private static final String OUTER_DROPPABLE_GREEDY_DROPPED_TEXT = "Outer droppable\nDropped!";
    private static final String OUTER_DROPPABLE_INNER_DROPPABLE_TEXT = "Dropped!\nInner droppable (greedy)";
    // Color Constants
    private static final String NEW_BACKGROUND_BLUE_COLOR = "rgba(70, 130, 180, 1)";
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
    private static final String DROPPED_BEFORE_TEXT_ERROR = "Dropped text before mismatch";
    private static final String DROPPED_AFTER_TEXT_ERROR = "Dropped text after mismatch";
    private static final String INNER_COLOR_ERROR = "Inner color mismatch";
    private static final String OUTER_COLOR_ERROR = "Outer color mismatch";
    private static final String DROPPED_TEXT_DOUBLE_ERROR = "Dropped text double mismatch";
    private static final String OUTER_DROPPABLE_NOT_GREEDY_TEXT_ERROR = "Outer droppable not greedy text mismatch";
    private static final String OUTER_DROPPABLE_GREEDY_TEXT_ERROR = "Outer droppable greedy text mismatch";
    private static final String DROP_HERE_TEXT_ERROR = "Drop here text mismatch";
    private static final String DROPPED_TEXT_MISSING_ERROR = "Dropped text missing";
    private static final String DROPPABLE_BACKGROUND_COLOR_BEFORE = "Droppable background color before mismatch";
    private static final String DROPPABLE_BACKGROUND_COLOR_AFTER = "Droppable background color after mismatch";
    private static final String POSITION_ERROR = "Position mismatch";
    private DroppablePage droppablePage;

    @BeforeMethod
    public void goToDroppablePage() {
        navigateToUrl(DROPPABLE_URL);
        droppablePage = new DroppablePage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange & Act
        String actualHeaderText = droppablePage.getExpectedHeaderText();

        String actualSimpleTabText = droppablePage.getSimpleTabText();
        String actualSimpleTabDragMeButtonText = droppablePage.getSimpleTabDragMeButtonText();
        String actualSimpleDroppableText = droppablePage.getSimpleTabDroppableText();

        droppablePage.clickAcceptTab();
        String actualAcceptTabText = droppablePage.getDroppableAcceptTabText();
        String actualAcceptableButtonText = droppablePage.getAcceptTabAcceptableButtonText();
        String actualNotAcceptableButtonText = droppablePage.getAcceptTabNotAcceptableButtonText();
        String actualAcceptTabDroppableText = droppablePage.getAcceptableDroppableText();

        droppablePage.clickPreventPropagationTab();
        String actualPreventPropagationTabText = droppablePage.getPreventPropagationTabText();
        String actualButtonDragMePreventPropagationText = droppablePage.getDragMePreventPropagationText();
        String actualOuterDroppableNotGreedyText = droppablePage.getOuterDroppableNotGreedyText();
        String actualInnerDroppableNotGreedyText = droppablePage.getInnerDroppableNotGreedyText();
        String actualOuterDroppableGreedyText = droppablePage.getOuterDroppableGreedyText();
        String actualInnerDroppableGreedyText = droppablePage.getInnerDroppableGreedyText();

        droppablePage.clickRevertDraggableTab();
        String actualRevertDraggableTabText = droppablePage.getRevertDraggableTabText();
        String actualWillRevertText = droppablePage.getWillRevertText();
        String actualNotRevertText = droppablePage.getNotRevertText();
        String actualRevertDraggableDroppableText = droppablePage.getRevertDraggableDroppableText();

        // Assert
        softAssert.assertEquals(actualHeaderText, PAGE_HEADER_TEXT, HEADER_ERROR);
        softAssert.assertEquals(actualSimpleTabText, SIMPLE_TAB_TEXT, SIMPLE_TAB_ERROR);
        softAssert.assertEquals(actualSimpleTabDragMeButtonText, DRAG_ME_TEXT, DRAG_ME_ERROR);
        softAssert.assertEquals(actualSimpleDroppableText, DROP_HERE_TEXT, DROPPED_ERROR);
        softAssert.assertEquals(actualAcceptTabText, ACCEPT_TAB_TEXT, ACCEPT_TAB_ERROR);
        softAssert.assertEquals(actualPreventPropagationTabText, PREVENT_PROPAGATION_TAB_TEXT, PREVENT_PROPAGATION_TAB_ERROR);
        softAssert.assertEquals(actualRevertDraggableTabText, REVERT_DRAGGABLE_TAB_TEXT, REVERT_DRAGGABLE_TAB_ERROR);
        softAssert.assertEquals(actualAcceptableButtonText, ACCEPTABLE_TEXT, ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualNotAcceptableButtonText, NOT_ACCEPTABLE_TEXT, NOT_ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualAcceptTabDroppableText, DROP_HERE_TEXT, DROP_HERE_ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualButtonDragMePreventPropagationText, DRAG_ME_PREVENT_PROPAGATION_TEXT, DRAG_ME_PREVENT_PROPAGATION_ERROR);
        softAssert.assertEquals(actualOuterDroppableNotGreedyText, OUTER_DROPPABLE_TEXT, OUTER_DROPPABLE_1_ERROR);
        softAssert.assertEquals(actualInnerDroppableNotGreedyText, INNER_DROPPABLE_NOT_GREEDY_TEXT, INNER_DROPPABLE_NOT_GREEDY_ERROR);
        softAssert.assertEquals(actualOuterDroppableGreedyText, OUTER_DROPPABLE_TEXT, OUTER_DROPPABLE_2_ERROR);
        softAssert.assertEquals(actualInnerDroppableGreedyText, INNER_DROPPABLE_GREEDY_TEXT, INNER_DROPPABLE_GREEDY_ERROR);
        softAssert.assertEquals(actualWillRevertText, WILL_REVERT_TEXT, WILL_REVERT_ERROR);
        softAssert.assertEquals(actualNotRevertText, NOT_REVERT_TEXT, NOT_REVERT_ERROR);
        softAssert.assertEquals(actualRevertDraggableDroppableText, DROP_HERE_TEXT, DROP_HERE_REVERT_DRAGGABLE_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Simple drag and drop")
    public void simpleTabDragAndDrop() {
        // Arrange & Act
        String actualSimpleTabDragMeButtonBeforeText = droppablePage.getSimpleTabDragMeButtonText();
        String actualSimpleTabDroppableBeforeText = droppablePage.getSimpleTabDroppableText();
        String actualSimpleTabDroppableBackgroundColorBefore = droppablePage.getDroppableBackgroundColor();
        String actualSimpleTabDraggableBackgroundColorBefore = droppablePage.getDraggableBackgroundColor();
        droppablePage.dragAndDropSimpleTab();
        String actualSimpleTabDragMeButtonAfterText = droppablePage.getSimpleTabDragMeButtonText();
        String actualSimpleTabDroppableAfterText = droppablePage.getSimpleTabDroppableText();
        String actualSimpleTabDroppableBackgroundColorAfter = droppablePage.getDroppableBackgroundColor();
        String actualSimpleTabDraggableBackgroundColorAfter = droppablePage.getDraggableBackgroundColor();

        softAssert.assertEquals(actualSimpleTabDragMeButtonBeforeText, DRAG_ME_TEXT, DROPPED_BEFORE_TEXT_ERROR);
        softAssert.assertEquals(actualSimpleTabDroppableBeforeText, DROP_HERE_TEXT, DROPPED_BEFORE_TEXT_ERROR);
        softAssert.assertEquals(actualSimpleTabDroppableBackgroundColorBefore, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualSimpleTabDraggableBackgroundColorBefore, TRANSPARENT_COLOR, COLOR_ERROR);

        softAssert.assertEquals(actualSimpleTabDragMeButtonAfterText, DRAG_ME_TEXT, DROPPED_BEFORE_TEXT_ERROR);
        softAssert.assertEquals(actualSimpleTabDroppableAfterText, DROPPED_TEXT, DROPPED_AFTER_TEXT_ERROR);
        softAssert.assertEquals(actualSimpleTabDroppableBackgroundColorAfter, NEW_BACKGROUND_BLUE_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualSimpleTabDraggableBackgroundColorAfter, NEW_BACKGROUND_BLUE_COLOR, COLOR_ERROR);
        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Accept tab drag and drop acceptable")
    public void acceptTabDragAndDropAcceptable() {
        // Arrange & Act
        droppablePage.clickAcceptTab();
        String actualAcceptableButtonText = droppablePage.getAcceptTabAcceptableButtonText();
        String actualAcceptableButtonBackgroundColorBefore = droppablePage.getAcceptableButtonBackgroundColor();
        String actualNotAcceptableButtonText = droppablePage.getAcceptTabNotAcceptableButtonText();
        String actualNotAcceptableButtonBackgroundColorBefore = droppablePage.getNotAcceptableButtonBackgroundColor();
        String actualAcceptTabDroppableText = droppablePage.getAcceptableDroppableText();
        String actualDroppableBackgroundColorBefore = droppablePage.getDroppableAcceptTabBackgroundColor();
        droppablePage.dragAndDropAcceptableTab();
        String actualAcceptableButtonTextAfter = droppablePage.getAcceptTabAcceptableButtonText();
        String actualAcceptableButtonBackgroundColorAfter = droppablePage.getAcceptableButtonBackgroundColor();
        String actualNotAcceptableButtonTextAfter = droppablePage.getAcceptTabNotAcceptableButtonText();
        String actualNotAcceptableButtonBackgroundColorAfter = droppablePage.getNotAcceptableButtonBackgroundColor();
        String actualAcceptTabDroppableTextAfter = droppablePage.getAcceptableDroppableText();
        String actualDroppableBackgroundColorAfter = droppablePage.getDroppableAcceptTabBackgroundColor();

        // Assert
        softAssert.assertEquals(actualAcceptableButtonText, ACCEPTABLE_TEXT, ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualAcceptableButtonBackgroundColorBefore, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualNotAcceptableButtonText, NOT_ACCEPTABLE_TEXT, NOT_ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualNotAcceptableButtonBackgroundColorBefore, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualAcceptTabDroppableText, DROP_HERE_TEXT, DROP_HERE_ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualDroppableBackgroundColorBefore, TRANSPARENT_COLOR, COLOR_ERROR);

        softAssert.assertEquals(actualAcceptableButtonTextAfter, ACCEPTABLE_TEXT, ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualAcceptableButtonBackgroundColorAfter, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualNotAcceptableButtonTextAfter, NOT_ACCEPTABLE_TEXT, NOT_ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualNotAcceptableButtonBackgroundColorAfter, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualAcceptTabDroppableTextAfter, DROPPED_TEXT, DROP_HERE_ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualDroppableBackgroundColorAfter, NEW_BACKGROUND_BLUE_COLOR, COLOR_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Accept tab drag and drop not acceptable")
    public void acceptTabDragAndDropNotAcceptable() {
        // Arrange & Act
        droppablePage.clickAcceptTab();

        String actualAcceptableButtonText = droppablePage.getAcceptTabAcceptableButtonText();
        String actualAcceptableButtonBackgroundColorBefore = droppablePage.getAcceptableButtonBackgroundColor();
        String actualNotAcceptableButtonText = droppablePage.getAcceptTabNotAcceptableButtonText();
        String actualNotAcceptableButtonBackgroundColorBefore = droppablePage.getNotAcceptableButtonBackgroundColor();
        String actualAcceptTabDroppableText = droppablePage.getAcceptableDroppableText();
        String actualDroppableBackgroundColorBefore = droppablePage.getDroppableAcceptTabBackgroundColor();

        droppablePage.dragAndDropNotAcceptable();

        String actualAcceptableButtonTextAfter = droppablePage.getAcceptTabAcceptableButtonText();
        String actualAcceptableButtonBackgroundColorAfter = droppablePage.getAcceptableButtonBackgroundColor();
        String actualNotAcceptableButtonTextAfter = droppablePage.getAcceptTabNotAcceptableButtonText();
        String actualNotAcceptableButtonBackgroundColorAfter = droppablePage.getNotAcceptableButtonBackgroundColor();
        String actualAcceptTabDroppableTextAfter = droppablePage.getAcceptableDroppableText();
        String actualDroppableBackgroundColorAfter = droppablePage.getDroppableAcceptTabBackgroundColor();

        // Assert
        softAssert.assertEquals(actualAcceptableButtonText, ACCEPTABLE_TEXT, ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualAcceptableButtonBackgroundColorBefore, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualNotAcceptableButtonText, NOT_ACCEPTABLE_TEXT, NOT_ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualNotAcceptableButtonBackgroundColorBefore, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualAcceptTabDroppableText, DROP_HERE_TEXT, DROP_HERE_ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualDroppableBackgroundColorBefore, TRANSPARENT_COLOR, COLOR_ERROR);

        softAssert.assertEquals(actualAcceptableButtonTextAfter, ACCEPTABLE_TEXT, ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualAcceptableButtonBackgroundColorAfter, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualNotAcceptableButtonTextAfter, NOT_ACCEPTABLE_TEXT, NOT_ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualNotAcceptableButtonBackgroundColorAfter, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualAcceptTabDroppableTextAfter, DROP_HERE_TEXT, DROP_HERE_ACCEPTABLE_ERROR);
        softAssert.assertEquals(actualDroppableBackgroundColorAfter, TRANSPARENT_COLOR, COLOR_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Prevent propagation outer droppable not greedy")
    public void preventPropagationOuterDroppableNotGreedy() {
        // Arrange & Act
        droppablePage.clickPreventPropagationTab();

        String actualButtonDragMePreventPropagationText = droppablePage.getDragMePreventPropagationText();
        String actualButtonDragMePreventPropagationBackgroundColor = droppablePage.getDragMePreventPropagationBackGroundColor();
        String actualOuterDroppableNotGreedyText = droppablePage.getOuterDroppableNotGreedyText();
        String actualOuterDroppableNotGreedyBackgroundColor = droppablePage.getOuterDroppableNotGreedyBackGroundColor();
        String actualInnerDroppableNotGreedyText = droppablePage.getInnerDroppableNotGreedyText();
        String actualInnerDroppableNotGreedyBackgroundColor = droppablePage.getInnerDroppableNotGreedyBackGroundColor();
        droppablePage.dragAndDropPropagationOuterDroppableNotGreedy();
        String actualButtonDragMePreventPropagationTextAfter = droppablePage.getDragMePreventPropagationText();
        String actualButtonDragMePreventPropagationBackgroundColorAfter = droppablePage.getDragMePreventPropagationBackGroundColor();
        String actualOuterDroppableNotGreedyTextAfter = droppablePage.getOuterDroppableNotGreedyText();
        String actualOuterDroppableNotGreedyBackgroundColorAfter = droppablePage.getOuterDroppableNotGreedyBackGroundColor();
        String actualInnerDroppableNotGreedyTextAfter = droppablePage.getInnerDroppableNotGreedyText();
        String actualInnerDroppableNotGreedyBackgroundColorAfter = droppablePage.getInnerDroppableNotGreedyBackGroundColor();

        // Assert
        softAssert.assertEquals(actualButtonDragMePreventPropagationText, DRAG_ME_TEXT2, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualButtonDragMePreventPropagationBackgroundColor, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualOuterDroppableNotGreedyText, OUTER_DROPPABLE_TEXT, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualOuterDroppableNotGreedyBackgroundColor, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualInnerDroppableNotGreedyText, INNER_DROPPABLE_NOT_GREEDY_TEXT, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualInnerDroppableNotGreedyBackgroundColor, TRANSPARENT_COLOR, COLOR_ERROR);

        softAssert.assertEquals(actualButtonDragMePreventPropagationTextAfter, DRAG_ME_TEXT2, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualButtonDragMePreventPropagationBackgroundColorAfter, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualOuterDroppableNotGreedyTextAfter, OUTER_DROPPABLE_TEXT, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualOuterDroppableNotGreedyBackgroundColorAfter, NEW_BACKGROUND_BLUE_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualInnerDroppableNotGreedyTextAfter, INNER_DROPPABLE_NOT_GREEDY_TEXT, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualInnerDroppableNotGreedyBackgroundColorAfter, TRANSPARENT_COLOR, COLOR_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Prevent propagation inner droppable not greedy")
    public void preventPropagationInnerDroppableNotGreedy() {
        // Arrange & Act
        droppablePage.clickPreventPropagationTab();

        String actualButtonDragMePreventPropagationText = droppablePage.getDragMePreventPropagationText();
        String actualButtonDragMePreventPropagationBackgroundColor = droppablePage.getDragMePreventPropagationBackGroundColor();
        String actualOuterDroppableNotGreedyText = droppablePage.getOuterDroppableNotGreedyText();
        String actualOuterDroppableNotGreedyBackgroundColor = droppablePage.getOuterDroppableNotGreedyBackGroundColor();
        String actualInnerDroppableNotGreedyText = droppablePage.getInnerDroppableNotGreedyText();
        String actualInnerDroppableNotGreedyBackgroundColor = droppablePage.getInnerDroppableNotGreedyBackGroundColor();

        droppablePage.dragAndDropPropagationInnerDroppableNotGreedy();

        String actualButtonDragMePreventPropagationTextAfter = droppablePage.getDragMePreventPropagationText();
        String actualButtonDragMePreventPropagationBackgroundColorAfter = droppablePage.getDragMePreventPropagationBackGroundColor();
        String actualOuterDroppableNotGreedyBackgroundColorAfter = droppablePage.getOuterDroppableNotGreedyBackGroundColor();
        String actualInnerDroppableNotGreedyBackgroundColorAfter = droppablePage.getInnerDroppableNotGreedyBackGroundColor();

        String notGreedyText = droppablePage.getPreventPropagationNotGreedyText();
        // Assert
        softAssert.assertEquals(actualButtonDragMePreventPropagationText, DRAG_ME_TEXT2, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualButtonDragMePreventPropagationBackgroundColor, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualOuterDroppableNotGreedyText, OUTER_DROPPABLE_TEXT, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualOuterDroppableNotGreedyBackgroundColor, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualInnerDroppableNotGreedyText, INNER_DROPPABLE_NOT_GREEDY_TEXT, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualInnerDroppableNotGreedyBackgroundColor, TRANSPARENT_COLOR, COLOR_ERROR);

        softAssert.assertEquals(actualButtonDragMePreventPropagationTextAfter, DRAG_ME_TEXT2, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualButtonDragMePreventPropagationBackgroundColorAfter, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualOuterDroppableNotGreedyBackgroundColorAfter, NEW_BACKGROUND_BLUE_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualInnerDroppableNotGreedyBackgroundColorAfter, NEW_BACKGROUND_BLUE_COLOR, COLOR_ERROR);

        softAssert.assertEquals(notGreedyText, DROPPED_TEXT_DOUBLE, DROPPED_TEXT_DOUBLE_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Prevent propagation outer droppable greedy")
    public void preventPropagationOuterDroppableGreedy() {
        // Arrange & Act
        droppablePage.clickPreventPropagationTab();

        String actualButtonDragMePreventPropagationText = droppablePage.getDragMePreventPropagationText();
        String actualButtonDragMePreventPropagationBackgroundColor = droppablePage.getDragMePreventPropagationBackGroundColor();
        String actualOuterDroppableNotGreedyText = droppablePage.getOuterDroppableNotGreedyText();
        String actualOuterDroppableNotGreedyBackgroundColor = droppablePage.getOuterDroppableNotGreedyBackGroundColor();
        String actualInnerDroppableNotGreedyText = droppablePage.getInnerDroppableNotGreedyText();
        String actualInnerDroppableNotGreedyBackgroundColor = droppablePage.getInnerDroppableNotGreedyBackGroundColor();

        droppablePage.dragAndDropPropagationOuterDroppableGreedy();

        String actualButtonDragMePreventPropagationTextAfter = droppablePage.getDragMePreventPropagationText();
        String actualButtonDragMePreventPropagationBackgroundColorAfter = droppablePage.getDragMePreventPropagationBackGroundColor();
        String actualOuterDroppableGreedyTextAfter = droppablePage.getOuterDroppableGreedyText();
        String actualOuterDroppableGreedyBackgroundColorAfter = droppablePage.getOuterDroppableGreedyBackGroundColor();
        String actualInnerDroppableGreedyTextAfter = droppablePage.getInnerDroppableGreedyText();
        String actualInnerDroppableGreedyBackgroundColorAfter = droppablePage.getInnerDroppableGreedyBackGroundColor();

        // Assert
        softAssert.assertEquals(actualButtonDragMePreventPropagationText, DRAG_ME_TEXT2, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualButtonDragMePreventPropagationBackgroundColor, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualOuterDroppableNotGreedyText, OUTER_DROPPABLE_TEXT, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualOuterDroppableNotGreedyBackgroundColor, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualInnerDroppableNotGreedyText, INNER_DROPPABLE_NOT_GREEDY_TEXT, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualInnerDroppableNotGreedyBackgroundColor, TRANSPARENT_COLOR, COLOR_ERROR);

        softAssert.assertEquals(actualButtonDragMePreventPropagationTextAfter, DRAG_ME_TEXT2, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualButtonDragMePreventPropagationBackgroundColorAfter, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualOuterDroppableGreedyTextAfter, OUTER_DROPPABLE_INNER_DROPPABLE_TEXT, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualOuterDroppableGreedyBackgroundColorAfter, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualInnerDroppableGreedyTextAfter, INNER_DROPPABLE_GREEDY_TEXT, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualInnerDroppableGreedyBackgroundColorAfter, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Prevent propagation inner droppable greedy")
    public void preventPropagationInnerDroppableGreedy() {
        // Arrange & Act
        droppablePage.clickPreventPropagationTab();

        String actualButtonDragMePreventPropagationText = droppablePage.getDragMePreventPropagationText();
        String actualButtonDragMePreventPropagationBackgroundColor = droppablePage.getDragMePreventPropagationBackGroundColor();
        String actualOuterDroppableNotGreedyText = droppablePage.getOuterDroppableNotGreedyText();
        String actualOuterDroppableNotGreedyBackgroundColor = droppablePage.getOuterDroppableNotGreedyBackGroundColor();
        String actualInnerDroppableNotGreedyText = droppablePage.getInnerDroppableNotGreedyText();
        String actualInnerDroppableNotGreedyBackgroundColor = droppablePage.getInnerDroppableNotGreedyBackGroundColor();

        droppablePage.dragAndDropPropagationInnerDroppableGreedy();

        String actualButtonDragMePreventPropagationTextAfter = droppablePage.getDragMePreventPropagationText();
        String actualButtonDragMePreventPropagationBackgroundColorAfter = droppablePage.getDragMePreventPropagationBackGroundColor();
        String actualOuterDroppableGreedyTextAfter = droppablePage.getOuterDroppableGreedyText();
        String actualOuterDroppableGreedyBackgroundColorAfter = droppablePage.getOuterDroppableGreedyBackGroundColor();
        String actualInnerDroppableGreedyBackgroundColorAfter = droppablePage.getInnerDroppableGreedyBackGroundColor();

        // Assert
        softAssert.assertEquals(actualButtonDragMePreventPropagationText, DRAG_ME_TEXT2, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualButtonDragMePreventPropagationBackgroundColor, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualOuterDroppableNotGreedyText, OUTER_DROPPABLE_TEXT, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualOuterDroppableNotGreedyBackgroundColor, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualInnerDroppableNotGreedyText, INNER_DROPPABLE_NOT_GREEDY_TEXT, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualInnerDroppableNotGreedyBackgroundColor, TRANSPARENT_COLOR, COLOR_ERROR);

        softAssert.assertEquals(actualButtonDragMePreventPropagationTextAfter, DRAG_ME_TEXT2, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualButtonDragMePreventPropagationBackgroundColorAfter, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualOuterDroppableGreedyTextAfter, OUTER_DROPPABLE_GREEDY_DROPPED_TEXT, DROPPED_TEXT_DOUBLE_ERROR);
        softAssert.assertEquals(actualOuterDroppableGreedyBackgroundColorAfter, TRANSPARENT_COLOR, COLOR_ERROR);
        softAssert.assertEquals(actualInnerDroppableGreedyBackgroundColorAfter, NEW_BACKGROUND_BLUE_COLOR, COLOR_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Revert draggable will revert")
    public void revertDraggableWillRevert() {
        // Arrange & Act
        droppablePage.clickRevertDraggableTab();

        Point initialLocation = droppablePage.getInitLocation();

        String actualWillRevertText = droppablePage.getWillRevertText();
        String actualWillRevertBackGroundColor = droppablePage.getWillRevertBackGroundColor();
        String actualNotRevertText = droppablePage.getNotRevertText();
        String actualWillNotRevertBackGroundColor = droppablePage.getWillNotRevertBackGroundColor();
        String droppableRevertDraggableText = droppablePage.getDroppableRevertDraggableText();
        String droppableRevertDraggableBackGroundColor = droppablePage.getDroppableRevertDraggableBackGroundColor();

        droppablePage.dragAndDropWillRevert();

        String actualWillRevertTextAfter = droppablePage.getWillRevertText();
        String actualWillRevertBackGroundColorAfter = droppablePage.getWillRevertBackGroundColor();
        String actualNotRevertTextAfter = droppablePage.getNotRevertText();
        String actualWillNotRevertBackGroundColorAfter = droppablePage.getWillNotRevertBackGroundColor();
        String droppableRevertDraggableTextAfter = droppablePage.getDroppableRevertDraggableText();
        String droppableRevertDraggableBackGroundColorAfter = droppablePage.getDroppableRevertDraggableBackGroundColor();

        Point afterLocation = droppablePage.getEndLocation();

        // Assert
        softAssert.assertEquals(actualWillRevertText, WILL_REVERT_TEXT, DROP_HERE_TEXT_ERROR);
        softAssert.assertEquals(actualWillRevertBackGroundColor, TRANSPARENT_COLOR, DROPPABLE_BACKGROUND_COLOR_BEFORE);
        softAssert.assertEquals(actualNotRevertText, NOT_REVERT_TEXT, DROP_HERE_TEXT_ERROR);
        softAssert.assertEquals(actualWillNotRevertBackGroundColor, TRANSPARENT_COLOR, DROPPABLE_BACKGROUND_COLOR_BEFORE);
        softAssert.assertEquals(droppableRevertDraggableText, DROP_HERE_TEXT, DROP_HERE_TEXT_ERROR);
        softAssert.assertEquals(droppableRevertDraggableBackGroundColor, TRANSPARENT_COLOR, DROPPABLE_BACKGROUND_COLOR_BEFORE);

        softAssert.assertEquals(actualWillRevertTextAfter, WILL_REVERT_TEXT, DROP_HERE_TEXT_ERROR);
        softAssert.assertEquals(actualWillRevertBackGroundColorAfter, TRANSPARENT_COLOR, DROPPABLE_BACKGROUND_COLOR_BEFORE);
        softAssert.assertEquals(actualNotRevertTextAfter, NOT_REVERT_TEXT, DROP_HERE_TEXT_ERROR);
        softAssert.assertEquals(actualWillNotRevertBackGroundColorAfter, TRANSPARENT_COLOR, DROPPABLE_BACKGROUND_COLOR_BEFORE);
        softAssert.assertEquals(droppableRevertDraggableTextAfter, DROPPED_TEXT, DROP_HERE_TEXT_ERROR);
        softAssert.assertEquals(droppableRevertDraggableBackGroundColorAfter, TRANSPARENT_COLOR, DROPPABLE_BACKGROUND_COLOR_BEFORE);

        softAssert.assertEquals(initialLocation, afterLocation, POSITION_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Revert draggable will not revert")
    public void revertDraggableWillNotRevert() {
        // Arrange & Act
        droppablePage.clickRevertDraggableTab();

        Point initialLocation = droppablePage.getInitLocation();

        String actualWillRevertText = droppablePage.getWillRevertText();
        String actualWillRevertBackGroundColor = droppablePage.getWillRevertBackGroundColor();
        String actualNotRevertText = droppablePage.getNotRevertText();
        String actualWillNotRevertBackGroundColor = droppablePage.getWillNotRevertBackGroundColor();
        String droppableRevertDraggableText = droppablePage.getDroppableRevertDraggableText();
        String droppableRevertDraggableBackGroundColor = droppablePage.getDroppableRevertDraggableBackGroundColor();

        droppablePage.dragAndDropWillNotRevert();

        String actualWillRevertTextAfter = droppablePage.getWillRevertText();
        String actualWillRevertBackGroundColorAfter = droppablePage.getWillRevertBackGroundColor();
        String actualNotRevertTextAfter = droppablePage.getNotRevertText();
        String actualWillNotRevertBackGroundColorAfter = droppablePage.getWillNotRevertBackGroundColor();
        String droppableRevertDraggableTextAfter = droppablePage.getDroppableRevertDraggableText();
        String droppableRevertDraggableBackGroundColorAfter = droppablePage.getDroppableRevertDraggableBackGroundColor();

        Point afterLocation = droppablePage.getAfterLocationNot();

        // Assert
        softAssert.assertEquals(actualWillRevertText, WILL_REVERT_TEXT, DROP_HERE_TEXT_ERROR);
        softAssert.assertEquals(actualWillRevertBackGroundColor, TRANSPARENT_COLOR, DROPPABLE_BACKGROUND_COLOR_BEFORE);
        softAssert.assertEquals(actualNotRevertText, NOT_REVERT_TEXT, DROP_HERE_TEXT_ERROR);
        softAssert.assertEquals(actualWillNotRevertBackGroundColor, TRANSPARENT_COLOR, DROPPABLE_BACKGROUND_COLOR_BEFORE);
        softAssert.assertEquals(droppableRevertDraggableText, DROP_HERE_TEXT, DROP_HERE_TEXT_ERROR);
        softAssert.assertEquals(droppableRevertDraggableBackGroundColor, TRANSPARENT_COLOR, DROPPABLE_BACKGROUND_COLOR_BEFORE);

        softAssert.assertEquals(actualWillRevertTextAfter, WILL_REVERT_TEXT, DROP_HERE_TEXT_ERROR);
        softAssert.assertEquals(actualWillRevertBackGroundColorAfter, TRANSPARENT_COLOR, DROPPABLE_BACKGROUND_COLOR_BEFORE);
        softAssert.assertEquals(actualNotRevertTextAfter, NOT_REVERT_TEXT, DROP_HERE_TEXT_ERROR);
        softAssert.assertEquals(actualWillNotRevertBackGroundColorAfter, TRANSPARENT_COLOR, DROPPABLE_BACKGROUND_COLOR_BEFORE);
        softAssert.assertEquals(droppableRevertDraggableTextAfter, DROPPED_TEXT, DROP_HERE_TEXT_ERROR);
        softAssert.assertEquals(droppableRevertDraggableBackGroundColorAfter, TRANSPARENT_COLOR, DROPPABLE_BACKGROUND_COLOR_BEFORE);

        softAssert.assertNotEquals(initialLocation, afterLocation, POSITION_ERROR);
        softAssert.assertAll();
    }
}
