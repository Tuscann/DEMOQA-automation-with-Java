package demoqa.web.tests.alerts;

import demoqa.pages.alerts.FramesPage;
import demoqa.web.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        navigateToUrl("frames");
        FramesPage framesPage = new FramesPage(driver);

        String expectedHeadingText = "Frames";
        String expectedText = "Sample Iframe page There are 2 Iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame, which is this window, and the two frames below";

        String actualHeadingText = framesPage.getFramesHeadingText();
        String actualText = framesPage.getText();

        softAssert.assertEquals(actualHeadingText, expectedHeadingText, "\nWrong heading.\n");
        softAssert.assertEquals(actualText, expectedText, "\nWrong text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify heading in first Iframe")
    public void VerifyHeadingTextInFirstIframe() {
        navigateToUrl("frames");
        FramesPage framesPage = new FramesPage(driver);
        String actualFirstIFrameHeadingText = framesPage.getHeadingTextInFirstIframe();

        String expectedFirstIFrameHeadingText = "This is a sample page";

        Assert.assertEquals(actualFirstIFrameHeadingText, expectedFirstIFrameHeadingText, "\nWrong heading in first Iframe.\n");
    }

    @Test(enabled = true, testName = "Verify heading in second Iframe")
    public void VerifyHeadingTextInSecondIframe() {
        navigateToUrl("frames");
        FramesPage framesPage = new FramesPage(driver);
        String actualSecondIFrameHeadingText = framesPage.getHeadingTextInSecondIframe();

        String expectedSecondIFrameHeadingText = "This is a sample page";

        Assert.assertEquals(actualSecondIFrameHeadingText, expectedSecondIFrameHeadingText, "\nWrong heading in second Iframe.\n");
    }
}
