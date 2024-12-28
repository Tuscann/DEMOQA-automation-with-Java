package part3.comdemoqa.tests.interactions;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

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
        draggablePage.clickRestrictedTab();
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

}
