package part3.comdemoqa.tests.alerts;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class NestedFramesPageTests extends BaseTest {

    @Test(enabled = false)
    public void VerifyHeadingTextInFirstIframe() {
        navigateToUrl("nestedframes");
        nestedFramesPage.selectParentIframe();
        String actualText = nestedFramesPage.getText();
        String expectedText = "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.";

        Assert.assertEquals(actualText, expectedText, "Wrong heading");

        String expectedHeading = "This is a sample page";

        Assert.assertEquals("actualText", expectedHeading, "Wrong text");
    }
}
