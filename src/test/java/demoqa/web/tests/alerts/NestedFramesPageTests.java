package demoqa.web.tests.alerts;

import demoqa.pages.alerts.NestedFramesPage;
import demoqa.web.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFramesPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        navigateToUrl("nestedframes");
        NestedFramesPage nestedFramesPage = new NestedFramesPage(driver);

        String expectedMainText = "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.";
        String expectedHeadingText = "Nested Frames";

        String actualMainText = nestedFramesPage.getMainText();
        String actualHeadingText = nestedFramesPage.getHeadingText();

        softAssert.assertEquals(actualHeadingText, expectedHeadingText, "\nMissing Heading text.\n");
        softAssert.assertEquals(actualMainText, expectedMainText, "\nWrong main text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify heading text in parent Iframe")
    public void VerifyHeadingTextInParentIframe() {
        navigateToUrl("nestedframes");
        NestedFramesPage nestedFramesPage = new NestedFramesPage(driver);

        String expectedParentText = "Parent frame";

        nestedFramesPage.selectParentIframe();
        String actualParentText = nestedFramesPage.getParentIframeText();

        Assert.assertEquals(actualParentText, expectedParentText, "\nMissing Parent frame text.\n");
    }

    @Test(enabled = true, testName = "Verify heading text in child Iframe")
    public void VerifyHeadingTextInChildIframe() {
        navigateToUrl("nestedframes");
        NestedFramesPage nestedFramesPage = new NestedFramesPage(driver);

        nestedFramesPage.selectChildIframe();
        String expectedChildIframe = "Child Iframe";
        String actualChildIframe = nestedFramesPage.getChildIframeText();

        Assert.assertEquals(actualChildIframe, expectedChildIframe, "\nWrong Child text.\n");
    }
}
