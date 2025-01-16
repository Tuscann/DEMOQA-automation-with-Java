package demoqa.web.test.interactions;

import demoqa.web.BaseTest;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

public class DraggablePageTests extends BaseTest {
    @Test(enabled = true)
    public void VerifyAllTextOnPage() {
        navigateToUrl("dragabble");

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

    @Test(enabled = true)
    public void DragMeSimpleTab() {
        navigateToUrl("dragabble");

        int xOffset = 150;
        int yOffset = 50;

        Point initialLocation = draggablePage.getInitLocation();

        draggablePage.dragAndDropByOnPositionDragMe(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocation();

        softAssert.assertEquals(initialLocation.x + xOffset, endPosition.x, "\nWrong initial location X.\n");
        softAssert.assertEquals(initialLocation.y + yOffset, endPosition.y, "\nWrong initial location Y.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void DragOnlyXInAxisRestrictedTab() {
        navigateToUrl("dragabble");

        int xOffset = 150;
        int yOffset = 50;

        draggablePage.clickAxisRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationOnlyX();

        draggablePage.dragAndDropByOnPositionOnlyX(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationOnlyX();

        softAssert.assertEquals(initialLocation.x + xOffset, endPosition.x, "\nWrong initial location X.\n");
        softAssert.assertEquals(initialLocation.y, endPosition.y, "\nWrong initial location Y.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void DragOnlyYInAxisRestrictedTab() {
        navigateToUrl("dragabble");

        int xOffset = 150;
        int yOffset = 50;

        draggablePage.clickAxisRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationOnlyY();

        draggablePage.dragAndDropByOnPositionOnlyY(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationOnlyY();

        softAssert.assertEquals(initialLocation.x, endPosition.x, "\nWrong initial location X.\n");
        softAssert.assertEquals(initialLocation.y + yOffset, endPosition.y, "\nWrong initial location Y.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void ContainedInBoxAxisRestrictedTabWithSizeInsideBox() {
        navigateToUrl("dragabble");

        int xOffset = 150;
        int yOffset = 50;

        draggablePage.clickContainerRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationContainedInBox();
        draggablePage.dragAndDropByOnPositionContainedBox(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationContainedInBox();

        softAssert.assertEquals(initialLocation.x + xOffset, endPosition.x, "\nWrong initial location X.\n");
        softAssert.assertEquals(initialLocation.y + yOffset, endPosition.y, "\nWrong initial location Y.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void ContainedInBoxAxisRestrictedTabWithSizeOutSideBox() {
        navigateToUrl("dragabble");

        int xOffset = 500;
        int yOffset = 107;  //Magic number -1 become bigger TODO HELP

        draggablePage.clickContainerRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationContainedInBox();

        draggablePage.dragAndDropByOnPositionContainedBox(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationContainedInBox();

        softAssert.assertEquals(initialLocation.x + xOffset, endPosition.x, "\nWrong point location X axis.\n");
        softAssert.assertEquals(initialLocation.y + yOffset - 1, endPosition.y, "\nWrong point location on y axis.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void ContainedInParentAxisRestrictedTabWithSizeInsideBox() {
        navigateToUrl("dragabble");

        int xOffset = 15;
        int yOffset = 60;

        draggablePage.clickContainerRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationContainedInParent();

        draggablePage.dragAndDropByOnPositionContainedParent(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationContainedInParent();

        softAssert.assertEquals(initialLocation.x + xOffset, endPosition.x, "\nWrong initial location X.\n");
        softAssert.assertEquals(initialLocation.y + yOffset, endPosition.y, "\nWrong initial location Y.\n");

        softAssert.assertAll();
    }

    @Test(enabled = false)
    public void MoveFirstTextCursorStyle() {
        navigateToUrl("dragabble");

        int xOffset = 0;
        int yOffset = 100;

        draggablePage.clickCursorStyleTab();

        Point initialLocation = draggablePage.getInitLocationFirstText();

        draggablePage.dragAndDropInCursorStyleFirstText(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationFirstText();

        softAssert.assertEquals(initialLocation.x + xOffset, endPosition.x, "\nWrong initial location X.\n");
        softAssert.assertEquals(initialLocation.y + yOffset, endPosition.y, "\nWrong initial location Y.\n");

        softAssert.assertAll();
    }

    @Test(enabled = false)
    public void MoveSecondTextCursorStyle() {
        navigateToUrl("dragabble");

        int xOffset = 250;
        int yOffset = 100;

        draggablePage.clickCursorStyleTab();

        Point initialLocation = draggablePage.getInitLocationSecondText();

        draggablePage.dragAndDropInCursorStyleSecondText(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationSecondText();

        softAssert.assertEquals(initialLocation.x + xOffset, endPosition.x, "\nWrong initial location X.\n");
        softAssert.assertEquals(initialLocation.y + yOffset, endPosition.y, "\nWrong initial location Y.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void MoveThirdTextCursorStyle() {
        navigateToUrl("dragabble");

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