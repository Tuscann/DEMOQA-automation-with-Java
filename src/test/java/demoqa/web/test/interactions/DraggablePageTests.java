package demoqa.web.test.interactions;

import demoqa.web.BaseTest;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DraggablePageTests extends BaseTest {
    @Test
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

        Assert.assertEquals(actualPageTitle, pageTitle, "Wrong page title");
        Assert.assertEquals(actualSimpleTabTitle, simpleTabTitle, "Wrong Simple page title");
        Assert.assertEquals(actualSimpleDragMe, simpleDragMe, "Wrong simple page title");
        Assert.assertEquals(actualAxisRestrictedTab, axisRestrictedTab, "Wrong axis restricted tab");
        Assert.assertEquals(actualAxisRestrictedOnlyX, axisRestrictedOnlyX, "Wrong axis restricted only x");
        Assert.assertEquals(actualAxisRestrictedOnlyY, axisRestrictedOnlyY, "Wrong axis restricted only Y");
        Assert.assertEquals(actualContainerRestrictedTab, containerRestrictedTab, "Wrong container restricted tab");
        Assert.assertEquals(actualContainerRestrictedFirstText, containerRestrictedFirstText, "Wrong container restricted first text");
        Assert.assertEquals(actualContainerRestrictedSecondText, containerRestrictedSecondText, "Wrong container second text");
        Assert.assertEquals(actualCursorStyleTab, cursorStyleTab, "Wrong cursor style tab");
        Assert.assertEquals(actualCursorStyleFirstText, cursorStyleFirstText, "Wrong style first text");
        Assert.assertEquals(actualCursorStyleSecondText, cursorStyleSecondText, "Wrong style second text");
        Assert.assertEquals(actualCursorStyleThirdText, cursorStyleThirdText, "Wrong style third text");
    }

    @Test
    public void DragMeSimpleTab() {
        navigateToUrl("dragabble");

        int xOffset = 150;
        int yOffset = 50;

        Point initialLocation = draggablePage.getInitLocation();

        draggablePage.dragAndDropByOnPositionDragMe(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocation();

        Assert.assertEquals(initialLocation.x + xOffset, endPosition.x, "Wrong initial location");
        Assert.assertEquals(initialLocation.y + yOffset, endPosition.y, "Wrong initial location");
    }

    @Test
    public void DragOnlyXInAxisRestrictedTab() {
        navigateToUrl("dragabble");

        int xOffset = 150;
        int yOffset = 50;

        draggablePage.clickAxisRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationOnlyX();

        draggablePage.dragAndDropByOnPositionOnlyX(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationOnlyX();

        Assert.assertEquals(initialLocation.x + xOffset, endPosition.x, "Wrong initial location");
        Assert.assertEquals(initialLocation.y, endPosition.y, "Wrong initial location");
    }

    @Test
    public void DragOnlyYInAxisRestrictedTab() {
        navigateToUrl("dragabble");

        int xOffset = 150;
        int yOffset = 50;

        draggablePage.clickAxisRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationOnlyY();

        draggablePage.dragAndDropByOnPositionOnlyY(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationOnlyY();

        Assert.assertEquals(initialLocation.x, endPosition.x, "Wrong initial location");
        Assert.assertEquals(initialLocation.y + yOffset, endPosition.y, "Wrong initial location");
    }

    @Test
    public void ContainedInBoxAxisRestrictedTabWithSizeInsideBox() {
        navigateToUrl("dragabble");

        int xOffset = 150;
        int yOffset = 50;

        draggablePage.clickContainerRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationContainedInBox();

        draggablePage.dragAndDropByOnPositionContainedBox(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationContainedInBox();

        Assert.assertEquals(initialLocation.x + xOffset, endPosition.x, "Wrong initial location");
        Assert.assertEquals(initialLocation.y + yOffset, endPosition.y, "Wrong initial location");
    }

    @Test(enabled = false)
    public void ContainedInBoxAxisRestrictedTabWithSizeOutSideBox() {
        navigateToUrl("dragabble");

        int xOffset = 400;
        int yOffset = 600;

        draggablePage.clickContainerRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationContainedInBox();

        draggablePage.dragAndDropByOnPositionContainedBox(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationContainedInBox();

        Assert.assertEquals(initialLocation.x + xOffset, endPosition.x, "Wrong initial location");
        Assert.assertEquals(initialLocation.y + yOffset, endPosition.y, "Wrong initial location");
    }

    @Test
    public void ContainedInParentAxisRestrictedTabWithSizeInsideBox() {
        navigateToUrl("dragabble");

        int xOffset = 15;
        int yOffset = 60;

        draggablePage.clickContainerRestrictedTab();

        Point initialLocation = draggablePage.getInitLocationContainedInParent();

        draggablePage.dragAndDropByOnPositionContainedParent(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationContainedInParent();

        Assert.assertEquals(initialLocation.x + xOffset, endPosition.x, "Wrong initial location");
        Assert.assertEquals(initialLocation.y + yOffset, endPosition.y, "Wrong initial location");
    }

    @Test(enabled = false)
    public void MoveFirstTextCursorStyle() {
        navigateToUrl("dragabble");

        int xOffset = 250;
        int yOffset = 100;

        draggablePage.clickCursorStyleTab();

        Point initialLocation = draggablePage.getInitLocationFirstText();

        draggablePage.dragAndDropInCursorStyleFirstText(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationFirstText();

        Assert.assertEquals(initialLocation.x + xOffset, endPosition.x, "Wrong initial location");
        Assert.assertEquals(initialLocation.y + yOffset, endPosition.y, "Wrong initial location");
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

        Assert.assertEquals(initialLocation.x + xOffset, endPosition.x, "Wrong initial location");
        Assert.assertEquals(initialLocation.y + yOffset, endPosition.y, "Wrong initial location");
    }

    @Test(enabled = false)
    public void MoveThirdTextCursorStyle() {
        navigateToUrl("dragabble");

        int xOffset = 250;
        int yOffset = 100;

        draggablePage.clickCursorStyleTab();

        Point initialLocation = draggablePage.getInitLocationThirdText();

        draggablePage.dragAndDropInCursorStyleThirdText(xOffset, yOffset);

        Point endPosition = draggablePage.getInitLocationThirdText();

        Assert.assertEquals(initialLocation.x + xOffset, endPosition.x, "Wrong initial location");
        Assert.assertEquals(initialLocation.y + yOffset, endPosition.y, "Wrong initial location");
    }

}
