package demoqa.web.tests.alerts;

import demoqa.pages.alerts.FramesPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesPageTests extends BaseTest {
    private static final String FRAMES_URL = "frames";
    private FramesPage framesPage;

    @BeforeMethod
    public void goToFramesPage() {
        navigateToUrl(FRAMES_URL);
        framesPage = new FramesPage(driver);
    }

    @Test(enabled = true, testName = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange
        String expectedHeadingText = "Frames";
        String expectedText = "Sample Iframe page There are 2 Iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame, which is this window, and the two frames below";

        // Act
        String actualHeadingText = framesPage.getFramesHeadingText();
        String actualText = framesPage.getText();

        // Assert
        softAssert.assertEquals(actualHeadingText, expectedHeadingText, "\nWrong heading.\n");
        softAssert.assertEquals(actualText, expectedText, "\nWrong text.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify heading in first Iframe")
    public void verifyHeadingTextInFirstIframe() {
        // Arrange
        String expectedFirstIFrameHeadingText = "This is a sample page";

        // Act
        String actualFirstIFrameHeadingText = framesPage.getHeadingTextInFirstIframe();

        // Assert
        softAssert.assertEquals(actualFirstIFrameHeadingText, expectedFirstIFrameHeadingText, "\nWrong heading in first Iframe.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify heading in second Iframe")
    public void verifyHeadingTextInSecondIframe() {
        // Arrange
        String expectedSecondIFrameHeadingText = "This is a sample page";

        // Act
        String actualSecondIFrameHeadingText = framesPage.getHeadingTextInSecondIframe();

        // Assert
        softAssert.assertEquals(actualSecondIFrameHeadingText, expectedSecondIFrameHeadingText, "\nWrong heading in second Iframe.\n");
        softAssert.assertAll();
    }
}
