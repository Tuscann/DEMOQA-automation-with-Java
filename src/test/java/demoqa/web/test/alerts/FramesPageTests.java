package demoqa.web.test.alerts;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesPageTests extends BaseTest {

    @Test(enabled = true)
    public void VerifyAllTextOnPage() {
        navigateToUrl("frames");

        String expectedHeading = "Frames";
        String expectedText = "Sample Iframe page There are 2 Iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame, which is this window, and the two frames below";

        String actualHeading = framesPage.getFramesHeadingText();
        String actualText = framesPage.getText();

        Assert.assertEquals(actualHeading, expectedHeading, "\nWrong heading.\n");
        Assert.assertEquals(actualText, expectedText, "\nWrong text.\n");
    }

    @Test(enabled = true)
    public void VerifyHeadingTextInFirstIframe() {
        navigateToUrl("frames");
        String actualText = framesPage.getHeadingTextInFirstIframe();

        String expectedHeading = "This is a sample page";

        Assert.assertEquals(actualText, expectedHeading, "\nWrong heading in first Iframe.\n");
    }

    @Test(enabled = true)
    public void VerifyHeadingTextInSecondIframe() {
        navigateToUrl("frames");
        String actualText = framesPage.getHeadingTextInSecondIframe();

        String expectedHeading = "This is a sample page";

        Assert.assertEquals(actualText, expectedHeading, "\nWrong heading in second Iframe.\n");
    }
}
