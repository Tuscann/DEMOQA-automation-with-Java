package demoqa.web.tests.alerts;

import demoqa.pages.alerts.NestedFramesPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFramesPageTests extends BaseTest {

    private static final String NESTED_FRAMES_URL = "nestedframes";
    private NestedFramesPage nestedFramesPage;
    
    // Page Text Constants
    private static final String PAGE_HEADING_TEXT = "Nested Frames";
    private static final String MAIN_DESCRIPTION_TEXT = "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.";
    
    // Frame Text Constants
    private static final String PARENT_FRAME_TEXT = "Parent frame";
    private static final String CHILD_FRAME_TEXT = "Child Iframe";
    
    // Error Messages Constants
    private static final String HEADING_MISMATCH_ERROR = "Page heading text mismatch";
    private static final String MAIN_TEXT_MISMATCH_ERROR = "Main description text mismatch";
    private static final String PARENT_FRAME_TEXT_ERROR = "Parent frame text mismatch";
    private static final String CHILD_FRAME_TEXT_ERROR = "Child frame text mismatch";

    @BeforeMethod
    public void goToNestedFramesPage() {
        navigateToUrl(NESTED_FRAMES_URL);
        nestedFramesPage = new NestedFramesPage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Act
        String actualMainText = nestedFramesPage.getMainText();
        String actualHeadingText = nestedFramesPage.getHeadingText();

        // Assert
        softAssert.assertEquals(actualHeadingText, PAGE_HEADING_TEXT, HEADING_MISMATCH_ERROR);
        softAssert.assertEquals(actualMainText, MAIN_DESCRIPTION_TEXT, MAIN_TEXT_MISMATCH_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify heading text in parent Iframe")
    public void verifyHeadingTextInParentIframe() {
        // Act
        nestedFramesPage.selectParentIframe();
        String actualParentText = nestedFramesPage.getParentIframeText();

        // Assert
        softAssert.assertEquals(actualParentText, PARENT_FRAME_TEXT, PARENT_FRAME_TEXT_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify heading text in child Iframe")
    public void verifyHeadingTextInChildIframe() {
        // Act
        nestedFramesPage.selectChildIframe();
        String actualChildIframe = nestedFramesPage.getChildIframeText();

        // Assert
        softAssert.assertEquals(actualChildIframe, CHILD_FRAME_TEXT, CHILD_FRAME_TEXT_ERROR);
        softAssert.assertAll();
    }
}