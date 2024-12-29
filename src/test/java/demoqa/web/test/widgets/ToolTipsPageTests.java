package demoqa.web.test.widgets;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToolTipsPageTests extends BaseTest {

    @Test(enabled = false)
    public void HoverOnHoverMeToSee() {
        navigateToUrl("tool-tips");

        String actualHoverMeToSeeText = toolTipsPage.getHoverButtonText();

        String expectedHoverMeToSeeText = "You hovered over the Button";

        Assert.assertEquals(actualHoverMeToSeeText, expectedHoverMeToSeeText, "Hover me to see missing");
    }
}
