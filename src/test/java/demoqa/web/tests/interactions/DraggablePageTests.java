package demoqa.web.tests.interactions;

import demoqa.pages.interactions.DraggablePage;
import demoqa.web.base.BaseTest;
import org.openqa.selenium.Point;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DraggablePageTests extends BaseTest {
    // Text Constants
    private static final String PAGE_TITLE = "Dragabble";
    private static final String SIMPLE_TAB_TITLE = "Simple";
    private static final String SIMPLE_DRAG_ME = "Drag me";
    private static final String AXIS_RESTRICTED_TAB = "Axis Restricted";
    private static final String AXIS_RESTRICTED_ONLY_X = "Only X";
    private static final String AXIS_RESTRICTED_ONLY_Y = "Only Y";
    private static final String CONTAINER_RESTRICTED_TAB = "Container Restricted";
    private static final String CONTAINER_RESTRICTED_FIRST_TEXT = "I'm contained within the box";
    private static final String CONTAINER_RESTRICTED_SECOND_TEXT = "I'm contained within my parent";
    private static final String CURSOR_STYLE_TAB = "Cursor Style";
    private static final String CURSOR_STYLE_FIRST_TEXT = "I will always stick to the center";
    private static final String CURSOR_STYLE_SECOND_TEXT = "My cursor is at top left";
    private static final String CURSOR_STYLE_THIRD_TEXT = "My cursor is at bottom";

    // Error Message Constants
    private static final String PAGE_TITLE_ERROR = "Page title mismatch";
    private static final String SIMPLE_TAB_TITLE_ERROR = "Simple tab title mismatch";
    private static final String SIMPLE_DRAG_ME_ERROR = "Simple drag me text mismatch";
    private static final String AXIS_RESTRICTED_TAB_ERROR = "Axis restricted tab text mismatch";
    private static final String AXIS_RESTRICTED_ONLY_X_ERROR = "Axis restricted only X text mismatch";
    private static final String AXIS_RESTRICTED_ONLY_Y_ERROR = "Axis restricted only Y text mismatch";
    private static final String CONTAINER_RESTRICTED_TAB_ERROR = "Container restricted tab text mismatch";
    private static final String CONTAINER_RESTRICTED_FIRST_TEXT_ERROR = "Container restricted first text mismatch";
    private static final String CONTAINER_RESTRICTED_SECOND_TEXT_ERROR = "Container restricted second text mismatch";
    private static final String CURSOR_STYLE_TAB_ERROR = "Cursor style tab text mismatch";
    private static final String CURSOR_STYLE_FIRST_TEXT_ERROR = "Cursor style first text mismatch";
    private static final String CURSOR_STYLE_SECOND_TEXT_ERROR = "Cursor style second text mismatch";
    private static final String CURSOR_STYLE_THIRD_TEXT_ERROR = "Cursor style third text mismatch";
    private static final String INITIAL_LOCATION_X_ERROR = "Initial location X mismatch";
    private static final String INITIAL_LOCATION_Y_ERROR = "Initial location Y mismatch";
    private static final String POINT_LOCATION_X_ERROR = "Point location X axis mismatch";
    private static final String POINT_LOCATION_Y_ERROR = "Point location Y axis mismatch";

    public static final String DRAGGABLE_URL = "dragabble";
    private DraggablePage draggablePage;

    @BeforeMethod
    public void goToDraggablePage() {
        navigateToUrl(DRAGGABLE_URL);
        draggablePage = new DraggablePage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange & Act
        String actualPageTitle = draggablePage.getPageTitle();
        String actualSimpleTabTitle = draggablePage.getSimpleTabTitle();
        draggablePage.clickSimpleTab();
        String actualSimpleDragMe = draggablePage.getSimpleDragMe();
        String actualAxisRestrictedTab = draggablePage.getAxisRestrictedTab();
        draggablePage.clickAxisRestrictedTab();
        String actualAxisRestrictedOnlyX = draggablePage.getAxisRestrictedOnlyX();
        String actualAxisRestrictedOnlyY = draggablePage.getAxisRestrictedOnlyY();
        String actualContainerRestrictedTab = draggablePage.getContainerRestrictedTab();
        draggablePage.clickContainerRestrictedTab();
        String actualContainerRestrictedFirstText = draggablePage.getContainerRestrictedFirstText();
        String actualContainerRestrictedSecondText = draggablePage.getContainerRestrictedSecondText();
        String actualCursorStyleTab = draggablePage.getCursorStyleTab();
        draggablePage.clickCursorStyleTab();
        String actualCursorStyleFirstText = draggablePage.getCursorStyleFirstText();
        String actualCursorStyleSecondText = draggablePage.getCursorStyleSecondText();
        String actualCursorStyleThirdText = draggablePage.getCursorStyleThirdText();

        // Assert
        softAssert.assertEquals(actualPageTitle, PAGE_TITLE, PAGE_TITLE_ERROR);
        softAssert.assertEquals(actualSimpleTabTitle, SIMPLE_TAB_TITLE, SIMPLE_TAB_TITLE_ERROR);
        softAssert.assertEquals(actualSimpleDragMe, SIMPLE_DRAG_ME, SIMPLE_DRAG_ME_ERROR);
        softAssert.assertEquals(actualAxisRestrictedTab, AXIS_RESTRICTED_TAB, AXIS_RESTRICTED_TAB_ERROR);
        softAssert.assertEquals(actualAxisRestrictedOnlyX, AXIS_RESTRICTED_ONLY_X, AXIS_RESTRICTED_ONLY_X_ERROR);
        softAssert.assertEquals(actualAxisRestrictedOnlyY, AXIS_RESTRICTED_ONLY_Y, AXIS_RESTRICTED_ONLY_Y_ERROR);
        softAssert.assertEquals(actualContainerRestrictedTab, CONTAINER_RESTRICTED_TAB, CONTAINER_RESTRICTED_TAB_ERROR);
        softAssert.assertEquals(actualContainerRestrictedFirstText, CONTAINER_RESTRICTED_FIRST_TEXT, CONTAINER_RESTRICTED_FIRST_TEXT_ERROR);
        softAssert.assertEquals(actualContainerRestrictedSecondText, CONTAINER_RESTRICTED_SECOND_TEXT, CONTAINER_RESTRICTED_SECOND_TEXT_ERROR);
        softAssert.assertEquals(actualCursorStyleTab, CURSOR_STYLE_TAB, CURSOR_STYLE_TAB_ERROR);
        softAssert.assertEquals(actualCursorStyleFirstText, CURSOR_STYLE_FIRST_TEXT, CURSOR_STYLE_FIRST_TEXT_ERROR);
        softAssert.assertEquals(actualCursorStyleSecondText, CURSOR_STYLE_SECOND_TEXT, CURSOR_STYLE_SECOND_TEXT_ERROR);
        softAssert.assertEquals(actualCursorStyleThirdText, CURSOR_STYLE_THIRD_TEXT, CURSOR_STYLE_THIRD_TEXT_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Drag me simple tab")
    public void dragMeSimpleTab() {
        // Arrange & Act
        int xOffset = 150;
        int yOffset = 50;

        Point initialLocation = draggablePage.getInitLocation();
        draggablePage.dragAndDropByOnPositionDragMe(xOffset, yOffset);
        Point endPosition = draggablePage.getInitLocation();

        // Assert
        softAssert.assertEquals(initialLocation.x + xOffset, endPosition.x, INITIAL_LOCATION_X_ERROR);
        softAssert.assertEquals(initialLocation.y + yOffset, endPosition.y, INITIAL_LOCATION_Y_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Drag only x in axis restricted tab")
    public void dragOnlyXInAxisRestrictedTab() {
        // Arrange & Act
        int xOffset = 150;
        int yOffset = 50;

        draggablePage.clickAxisRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationOnlyX();

        draggablePage.dragAndDropByOnPositionOnlyX(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationOnlyX();

        // Assert
        softAssert.assertEquals(initialLocation.x + xOffset, endPosition.x, INITIAL_LOCATION_X_ERROR);
        softAssert.assertEquals(initialLocation.y, endPosition.y, INITIAL_LOCATION_Y_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Drag only y in axis restricted tab")
    public void dragOnlyYInAxisRestrictedTab() {
        // Arrange & Act
        int xOffset = 150;
        int yOffset = 50;

        draggablePage.clickAxisRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationOnlyY();

        draggablePage.dragAndDropByOnPositionOnlyY(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationOnlyY();

        // Assert
        softAssert.assertEquals(initialLocation.x, endPosition.x, INITIAL_LOCATION_X_ERROR);
        softAssert.assertEquals(initialLocation.y + yOffset, endPosition.y, INITIAL_LOCATION_Y_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Contained in box axis restricted tab with size inside box")
    public void containedInBoxAxisRestrictedTabWithSizeInsideBox() {
        // Arrange & Act
        int xOffset = 150;
        int yOffset = 50;

        draggablePage.clickContainerRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationContainedInBox();
        draggablePage.dragAndDropByOnPositionContainedBox(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationContainedInBox();

        // Assert
        softAssert.assertEquals(initialLocation.x + xOffset, endPosition.x, INITIAL_LOCATION_X_ERROR);
        softAssert.assertEquals(initialLocation.y + yOffset, endPosition.y, INITIAL_LOCATION_Y_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = false, description = "Contained in box axis restricted tab with size out side box")
    public void containedInBoxAxisRestrictedTabWithSizeOutSideBox() {
        // Arrange & Act
        int xOffset = 500;
        int yOffset = 107;  // Magic number -1 become bigger TODO HELP

        draggablePage.clickContainerRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationContainedInBox();

        draggablePage.dragAndDropByOnPositionContainedBox(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationContainedInBox();

        // Assert
        softAssert.assertEquals(initialLocation.x + xOffset - 50, endPosition.x, POINT_LOCATION_X_ERROR);
        softAssert.assertEquals(initialLocation.y + yOffset, endPosition.y, POINT_LOCATION_Y_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Contained in parent axis restricted tab with size inside box")
    public void containedInParentAxisRestrictedTabWithSizeInsideBox() {
        // Arrange
        int xOffset = 15;
        int yOffset = 60;
        // Allow for a larger margin of error (±10 pixels) in position
        int marginOfError = 4;

        // Act
        draggablePage.clickContainerRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationContainedInParent();

        draggablePage.dragAndDropByOnPositionContainedParent(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationContainedInParent();

        // Assert
        softAssert.assertTrue(Math.abs((initialLocation.x + xOffset) - endPosition.x) <= marginOfError,
                String.format("\nWrong initial location X. Expected: %d ± %d, Actual: %d\n", initialLocation.x + xOffset, marginOfError, endPosition.x));
        softAssert.assertTrue(Math.abs((initialLocation.y + yOffset) - endPosition.y) <= marginOfError,
                String.format("\nWrong initial location Y. Expected: %d ± %d, Actual: %d\n", initialLocation.y + yOffset, marginOfError, endPosition.y));
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Move first text cursor style")
    public void moveFirstTextCursorStyle() {
        // Arrange
        int xOffset = 0;
        int yOffset = 100;

        draggablePage.clickCursorStyleTab();

        Point initialLocation = draggablePage.getInitLocationFirstText();

        draggablePage.dragAndDropInCursorStyleFirstText(xOffset, yOffset);

        // Add a small wait to ensure the element has finished moving
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Point endPosition = draggablePage.getInitLocationFirstText();

        // Allow for a larger margin of error (±10 pixels) in position
        int marginOfError = 8;

        // Assert
        softAssert.assertTrue(Math.abs((initialLocation.x + xOffset) - endPosition.x) <= marginOfError,
                String.format("\nWrong initial location X. Expected: %d ± %d, Actual: %d\n", initialLocation.x + xOffset, marginOfError, endPosition.x));
        softAssert.assertTrue(Math.abs((initialLocation.y + yOffset) - endPosition.y) <= marginOfError,
                String.format("\nWrong initial location Y. Expected: %d ± %d, Actual: %d\n", initialLocation.y + yOffset, marginOfError, endPosition.y));

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Move second text cursor style")
    public void moveSecondTextCursorStyle() {
        // Arrange
        draggablePage.clickCursorStyleTab();

        // Add a wait before getting initial location
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // First drag operation
        Point initialLocation1 = draggablePage.getInitLocationSecondText();
        int xOffset = 40;
        int yOffset = 40;
        draggablePage.dragAndDropInCursorStyleSecondText(xOffset, yOffset);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Point endPosition1 = draggablePage.getInitLocationSecondText();
        int movement1X = endPosition1.x - initialLocation1.x;
        int movement1Y = endPosition1.y - initialLocation1.y;

        // Reset position
        draggablePage.dragAndDropInCursorStyleSecondText(-xOffset, -yOffset);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Second drag operation
        Point initialLocation2 = draggablePage.getInitLocationSecondText();
        draggablePage.dragAndDropInCursorStyleSecondText(xOffset, yOffset);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Point endPosition2 = draggablePage.getInitLocationSecondText();
        int movement2X = endPosition2.x - initialLocation2.x;
        int movement2Y = endPosition2.y - initialLocation2.y;

        // Verify that the movement is consistent between drags
        int marginOfError = 5;
        softAssert.assertTrue(Math.abs(movement1X - movement2X) <= marginOfError,
                String.format("\nInconsistent X movement. First: %d, Second: %d\n", movement1X, movement2X));
        softAssert.assertTrue(Math.abs(movement1Y - movement2Y) <= marginOfError,
                String.format("\nInconsistent Y movement. First: %d, Second: %d\n", movement1Y, movement2Y));

        // Verify that the movement is roughly equal in both X and Y directions
        softAssert.assertTrue(Math.abs(movement1X - movement1Y) <= marginOfError,
                String.format("\nUnequal X and Y movement. X: %d, Y: %d\n", movement1X, movement1Y));

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Move third text cursor style")
    public void moveThirdTextCursorStyle() {
        // Arrange
        int xOffset = 100;
        int yOffset = 100;  //Magic number -50 TODO HELP

        // Act
        draggablePage.clickCursorStyleTab();

        Point initialLocation = draggablePage.getInitLocationThirdText();

        draggablePage.dragAndDropInCursorStyleThirdText(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationThirdText();

        // Assert
        softAssert.assertEquals(initialLocation.x + xOffset, endPosition.x, "\nWrong initial location X.\n");
        softAssert.assertEquals(initialLocation.y + yOffset - 50, endPosition.y, "\nWrong initial location Y.\n");

        softAssert.assertAll();
    }
}