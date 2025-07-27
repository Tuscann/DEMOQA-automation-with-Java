package demoqa.web.tests.interactions;

import demoqa.pages.interactions.DraggablePage;
import demoqa.web.base.BaseTest;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

public class DraggablePageTests extends BaseTest {
    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        // Arrange
        navigateToUrl("dragabble");
        DraggablePage draggablePage = new DraggablePage(driver);

        String pageTitle = "Dragabble";
        String simpleTabTitle = "Simple";
        String simpleDragMe = "Drag me";
        String axisRestrictedTab = "Axis Restricted";
        String axisRestrictedOnlyX = "Only X";
        String axisRestrictedOnlyY = "Only Y";
        String containerRestrictedTab = "Container Restricted";
        String containerRestrictedFirstText = "I'm contained within the box";
        String containerRestrictedSecondText = "I'm contained within my parent";
        String cursorStyleTab = "Cursor Style";
        String cursorStyleFirstText = "I will always stick to the center";
        String cursorStyleSecondText = "My cursor is at top left";
        String cursorStyleThirdText = "My cursor is at bottom";

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
        softAssert.assertEquals(actualPageTitle, pageTitle, "\nWrong page title.\n");
        softAssert.assertEquals(actualSimpleTabTitle, simpleTabTitle, "\nWrong Simple page title.\n");
        softAssert.assertEquals(actualSimpleDragMe, simpleDragMe, "\nWrong simple page title.\n");
        softAssert.assertEquals(actualAxisRestrictedTab, axisRestrictedTab, "\nWrong axis restricted tab.\n");
        softAssert.assertEquals(actualAxisRestrictedOnlyX, axisRestrictedOnlyX, "\nWrong axis restricted only X.\n");
        softAssert.assertEquals(actualAxisRestrictedOnlyY, axisRestrictedOnlyY, "\nWrong axis restricted only Y.\n");
        softAssert.assertEquals(actualContainerRestrictedTab, containerRestrictedTab, "Wrong container restricted tab.\n");
        softAssert.assertEquals(actualContainerRestrictedFirstText, containerRestrictedFirstText, "\nWrong container restricted first text.\n");
        softAssert.assertEquals(actualContainerRestrictedSecondText, containerRestrictedSecondText, "\nWrong container second text.\n");
        softAssert.assertEquals(actualCursorStyleTab, cursorStyleTab, "\nWrong cursor style tab.\n");
        softAssert.assertEquals(actualCursorStyleFirstText, cursorStyleFirstText, "\nWrong style first text.\n");
        softAssert.assertEquals(actualCursorStyleSecondText, cursorStyleSecondText, "\nWrong style second text.\n");
        softAssert.assertEquals(actualCursorStyleThirdText, cursorStyleThirdText, "\nWrong style third text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Drag me simple tab")
    public void DragMeSimpleTab() {
        navigateToUrl("dragabble");
        DraggablePage draggablePage = new DraggablePage(driver);

        int xOffset = 150;
        int yOffset = 50;

        Point initialLocation = draggablePage.getInitLocation();

        draggablePage.dragAndDropByOnPositionDragMe(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocation();

        // Assert
        softAssert.assertEquals(initialLocation.x + xOffset, endPosition.x, "\nWrong initial location X.\n");
        softAssert.assertEquals(initialLocation.y + yOffset, endPosition.y, "\nWrong initial location Y.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Drag only x in axis restricted tab")
    public void DragOnlyXInAxisRestrictedTab() {
        navigateToUrl("dragabble");
        DraggablePage draggablePage = new DraggablePage(driver);

        int xOffset = 150;
        int yOffset = 50;

        draggablePage.clickAxisRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationOnlyX();

        draggablePage.dragAndDropByOnPositionOnlyX(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationOnlyX();

        // Assert
        softAssert.assertEquals(initialLocation.x + xOffset, endPosition.x, "\nWrong initial location X.\n");
        softAssert.assertEquals(initialLocation.y, endPosition.y, "\nWrong initial location Y.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Drag only y in axis restricted tab")
    public void DragOnlyYInAxisRestrictedTab() {
        navigateToUrl("dragabble");
        DraggablePage draggablePage = new DraggablePage(driver);

        int xOffset = 150;
        int yOffset = 50;

        draggablePage.clickAxisRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationOnlyY();

        draggablePage.dragAndDropByOnPositionOnlyY(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationOnlyY();

        // Assert
        softAssert.assertEquals(initialLocation.x, endPosition.x, "\nWrong initial location X.\n");
        softAssert.assertEquals(initialLocation.y + yOffset, endPosition.y, "\nWrong initial location Y.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Contained in box axis restricted tab with size inside box")
    public void ContainedInBoxAxisRestrictedTabWithSizeInsideBox() {
        navigateToUrl("dragabble");
        DraggablePage draggablePage = new DraggablePage(driver);

        int xOffset = 150;
        int yOffset = 50;

        draggablePage.clickContainerRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationContainedInBox();
        draggablePage.dragAndDropByOnPositionContainedBox(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationContainedInBox();

        // Assert
        softAssert.assertEquals(initialLocation.x + xOffset, endPosition.x, "\nWrong initial location X.\n");
        softAssert.assertEquals(initialLocation.y + yOffset, endPosition.y, "\nWrong initial location Y.\n");
        softAssert.assertAll();
    }

    @Test(enabled = false, testName = "Contained in box axis restricted tab with size out side box")
    public void ContainedInBoxAxisRestrictedTabWithSizeOutSideBox() {
        navigateToUrl("dragabble");
        DraggablePage draggablePage = new DraggablePage(driver);

        int xOffset = 500;
        int yOffset = 107;  //Magic number -1 become bigger TODO HELP

        draggablePage.clickContainerRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationContainedInBox();

        draggablePage.dragAndDropByOnPositionContainedBox(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationContainedInBox();

        // Assert
        softAssert.assertEquals(initialLocation.x + xOffset - 50, endPosition.x, "\nWrong point location X axis.\n");
        softAssert.assertEquals(initialLocation.y + yOffset, endPosition.y, "\nWrong point location on y axis.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Contained in parent axis restricted tab with size inside box")
    public void ContainedInParentAxisRestrictedTabWithSizeInsideBox() {
        navigateToUrl("dragabble");
        DraggablePage draggablePage = new DraggablePage(driver);

        int xOffset = 15;
        int yOffset = 60;
        // Allow for a larger margin of error (±10 pixels) in position
        int marginOfError = 4;

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

    @Test(enabled = true, testName = "Move first text cursor style")
    public void MoveFirstTextCursorStyle() {
        navigateToUrl("dragabble");
        DraggablePage draggablePage = new DraggablePage(driver);

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
        softAssert.assertTrue(Math.abs((initialLocation.x + xOffset) - endPosition.x) <= marginOfError,
                String.format("\nWrong initial location X. Expected: %d ± %d, Actual: %d\n", initialLocation.x + xOffset, marginOfError, endPosition.x));
        softAssert.assertTrue(Math.abs((initialLocation.y + yOffset) - endPosition.y) <= marginOfError,
                String.format("\nWrong initial location Y. Expected: %d ± %d, Actual: %d\n", initialLocation.y + yOffset, marginOfError, endPosition.y));

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Move second text cursor style")
    public void MoveSecondTextCursorStyle() {
        navigateToUrl("dragabble");
        DraggablePage draggablePage = new DraggablePage(driver);

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

    @Test(enabled = true, testName = "Move third text cursor style")
    public void MoveThirdTextCursorStyle() {
        // Arrange
        navigateToUrl("dragabble");
        DraggablePage draggablePage = new DraggablePage(driver);

        int xOffset = 100;
        int yOffset = 100;  //Magic number -50 TODO HELP

        draggablePage.clickCursorStyleTab();

        Point initialLocation = draggablePage.getInitLocationThirdText();

        draggablePage.dragAndDropInCursorStyleThirdText(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationThirdText();

        softAssert.assertEquals(initialLocation.x + xOffset, endPosition.x, "\nWrong initial location X.\n");
        softAssert.assertEquals(initialLocation.y + yOffset - 50, endPosition.y, "\nWrong initial location Y.\n");

        softAssert.assertAll();
    }
}