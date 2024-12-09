package part3.comdemoqa.tests.widgets;

import com.pages.demo.pages.widgets.ToolTipsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class ToolTipsPageTests extends BaseTest {

    @Test
    public void checkDefaultValueSlider() {
        ToolTipsPage toolTipsPage = homePage.goToWidgets().clickToolTips();
        toolTipsPage.hoverMeToSeeButton();

        String expectedText = toolTipsPage.assertionHoverButtonText();

        Assert.assertEquals(expectedText, "Hover me to see", "Hover me to see missing");
        var x = 12;

        //  Assert.assertEquals(actualValue, expectedValue, "Actual value is not default 25");
    }

}
