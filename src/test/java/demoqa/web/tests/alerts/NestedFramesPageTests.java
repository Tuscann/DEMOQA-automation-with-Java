package demoqa.web.tests.alerts;

import demoqa.pages.alerts.NestedFramesPage;
import demoqa.web.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFramesPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        // Arrange
        navigateToUrl("nestedframes");
        NestedFramesPage nestedFramesPage = new NestedFramesPage(driver);
        String expectedMainText = "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.";
        String expectedHeadingText = "Nested Frames";

        // Act
        String actualMainText = nestedFramesPage.getMainText();
        String actualHeadingText = nestedFramesPage.getHeadingText();

        // Assert
        softAssert.assertEquals(actualHeadingText, expectedHeadingText, "\nMissing Heading text.\n");
        softAssert.assertEquals(actualMainText, expectedMainText, "\nWrong main text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify heading text in parent Iframe")
    public void VerifyHeadingTextInParentIframe() {
        // Arrange
        navigateToUrl("nestedframes");
        NestedFramesPage nestedFramesPage = new NestedFramesPage(driver);
        String expectedParentText = "Parent frame";

        // Act
        nestedFramesPage.selectParentIframe();
        String actualParentText = nestedFramesPage.getParentIframeText();

        // Assert
        softAssert.assertEquals(actualParentText, expectedParentText, "\nMissing Parent frame text.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify heading text in child Iframe")
    public void VerifyHeadingTextInChildIframe() {
        // Arrange
        navigateToUrl("nestedframes");
        NestedFramesPage nestedFramesPage = new NestedFramesPage(driver);
        String expectedChildIframe = "Child Iframe";

        // Act
        nestedFramesPage.selectChildIframe();
        String actualChildIframe = nestedFramesPage.getChildIframeText();

        // Assert
        softAssert.assertEquals(actualChildIframe, expectedChildIframe, "\nWrong Child text.\n");
        softAssert.assertAll();
    }
}
