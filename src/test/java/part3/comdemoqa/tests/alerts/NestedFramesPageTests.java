package part3.comdemoqa.tests.alerts;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class NestedFramesPageTests extends BaseTest {

    @Test(enabled = true)
    public void VerifyHeadingTextInParentIframe() {
        navigateToUrl("nestedframes");

        String expectedMainText = "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.";
        String actualMainText = nestedFramesPage.getMainText();

        nestedFramesPage.selectParentIframe();
        String actualParentText = nestedFramesPage.getParentText();
        String expectedParentText = "Parent frame";

        Assert.assertEquals(actualParentText, expectedParentText, "Missing Parent frame text");
        Assert.assertEquals(actualMainText, expectedMainText, "Wrong main text");
    }

    @Test(enabled = false)
    public void VerifyHeadingTextInFirstIframe() {
        navigateToUrl("nestedframes");

        String expectedMainText = "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.";
        String actualMainText = nestedFramesPage.getMainText();
        Assert.assertEquals(actualMainText, expectedMainText, "Wrong main text");

        nestedFramesPage.selectParentIframe();
        String actualParentText = nestedFramesPage.getParentText();
        String expectedParentText = "Parent frame";

        Assert.assertEquals(actualParentText, expectedParentText, "Missing Parent frame text");

        nestedFramesPage.selectChildIframe();
        String expectedChildIframe = "Child frame";
        String actualChildIframe = nestedFramesPage.getChildText();

        Assert.assertEquals(actualChildIframe, expectedChildIframe, "Wrong Child text");
    }

}
