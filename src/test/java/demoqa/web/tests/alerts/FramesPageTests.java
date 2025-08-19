package demoqa.web.tests.alerts;

import demoqa.pages.alerts.FramesPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesPageTests extends BaseTest {
    private static final String FRAMES_URL = "frames";
    private FramesPage framesPage;

    // Text Constants
    private static final String PAGE_HEADING = "Frames";
    private static final String PAGE_DESCRIPTION = "Sample Iframe page There are 2 Iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame, which is this window, and the two frames below";
    private static final String FIRST_IFRAME_HEADING = "This is a sample page";
    private static final String SECOND_IFRAME_HEADING = "This is a sample page";

    // Error Message Constants
    private static final String PAGE_HEADING_ERROR = "Page heading mismatch";
    private static final String PAGE_DESCRIPTION_ERROR = "Page description text mismatch";
    private static final String FIRST_IFRAME_HEADING_ERROR = "First iframe heading mismatch";
    private static final String SECOND_IFRAME_HEADING_ERROR = "Second iframe heading mismatch";

    @BeforeMethod
    public void goToFramesPage() {
        navigateToUrl(FRAMES_URL);
        framesPage = new FramesPage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange & Act
        String actualHeadingText = framesPage.getFramesHeadingText();
        String actualText = framesPage.getText();

        // Assert
        softAssert.assertEquals(actualHeadingText, PAGE_HEADING, PAGE_HEADING_ERROR);
        softAssert.assertEquals(actualText, PAGE_DESCRIPTION, PAGE_DESCRIPTION_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify heading in first Iframe")
    public void verifyHeadingTextInFirstIframe() {
        // Arrange & Act
        String actualFirstIFrameHeadingText = framesPage.getHeadingTextInFirstIframe();

        // Assert
        softAssert.assertEquals(actualFirstIFrameHeadingText, FIRST_IFRAME_HEADING, FIRST_IFRAME_HEADING_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify heading in second Iframe")
    public void verifyHeadingTextInSecondIframe() {
        // Arrange & Act
        String actualSecondIFrameHeadingText = framesPage.getHeadingTextInSecondIframe();

        // Assert
        softAssert.assertEquals(actualSecondIFrameHeadingText, SECOND_IFRAME_HEADING, SECOND_IFRAME_HEADING_ERROR);
        softAssert.assertAll();
    }
}
