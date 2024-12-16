package part3.comdemoqa.tests.alerts;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class FramesPageTests extends BaseTest {

    @Test
    public void VerifyHeadingTextInFirstIframe() {
        navigateToUrl("frames");
        String actualText = framesPage.getHeadingTextInFirstIframe();

        String expectedHeading = "This is a sample page";

        Assert.assertEquals(actualText, expectedHeading, "Wrong heading");
    }

    @Test
    public void VerifyHeadingTextInSecondIframe() {
        navigateToUrl("frames");
        String actualText = framesPage.getHeadingTextInSecondIframe();

        String expectedHeading = "This is a sample page";

        Assert.assertEquals(actualText, expectedHeading, "Wrong heading");
    }

    @Test
    public void VerifyTextOnPage() {
        navigateToUrl("frames");

        String expectedHeading = "Frames";
        String actualHeading = framesPage.getFramesHeadingText();

        String expectedText = "Sample Iframe page There are 2 Iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame, which is this window, and the two frames below";
        String actualText = framesPage.getText();


        Assert.assertEquals(actualHeading, expectedHeading, "Wrong heading");
        Assert.assertEquals(actualText, expectedText, "Wrong text");
    }


}
