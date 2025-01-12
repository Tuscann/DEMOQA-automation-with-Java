package demoqa.web.test.alerts;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFramesPageTests extends BaseTest {

    @Test(enabled = true)
    public void VerifyAllTextOnPage() {
        navigateToUrl("nestedframes");

        String expectedMainText = "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.";
        String expectedHeadingText = "Nested Frames";

        String actualMainText = nestedFramesPage.getMainText();
        String actualHeadingText = nestedFramesPage.getHeadingText();

        Assert.assertEquals(actualHeadingText, expectedHeadingText, "\nMissing Heading text.\n");
        Assert.assertEquals(actualMainText, expectedMainText, "\nWrong main text.\n");
    }

    @Test(enabled = true)
    public void VerifyHeadingTextInParentIframe() {
        navigateToUrl("nestedframes");

        String expectedParentText = "Parent frame";

        nestedFramesPage.selectParentIframe();
        String actualParentText = nestedFramesPage.getParentIframeText();

        Assert.assertEquals(actualParentText, expectedParentText, "\nMissing Parent frame text.\n");
    }

    @Test(enabled = true)
    public void VerifyHeadingTextInChildIframe() {
        navigateToUrl("nestedframes");

        nestedFramesPage.selectChildIframe();
        String expectedChildIframe = "Child Iframe";
        String actualChildIframe = nestedFramesPage.getChildIframeText();

        Assert.assertEquals(actualChildIframe, expectedChildIframe, "\nWrong Child text.\n");
    }
}
