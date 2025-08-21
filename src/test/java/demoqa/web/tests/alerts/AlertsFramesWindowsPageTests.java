package demoqa.web.tests.alerts;

import demoqa.pages.alerts.Alerts_Frames_WindowsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsFramesWindowsPageTests extends BaseTest {

    private static final String ALERTS_WINDOWS_URL = "alertsWindows";
    private static final String BROWSER_WINDOWS_URL = DEMO_QA_URL + "browser-windows";
    private static final String ALERTS_URL = DEMO_QA_URL + "alerts";
    private static final String FRAMES_URL = DEMO_QA_URL + "frames";
    private static final String NESTED_FRAMES_URL = DEMO_QA_URL + "nestedframes";
    private static final String MODAL_DIALOGS_URL = DEMO_QA_URL + "modal-dialogs";

    private static final String EXPECTED_MAIN_TEXT = "Please select an item from left to start practice.";

    // Error Message Constants
    private static final String BROWSER_WINDOWS_URL_ERROR = "Browser windows URL mismatch";
    private static final String ALERTS_URL_ERROR = "Alerts URL mismatch";
    private static final String FRAMES_URL_ERROR = "Frames URL mismatch";
    private static final String NESTED_FRAMES_URL_ERROR = "Nested frames URL mismatch";
    private static final String MODAL_DIALOGS_URL_ERROR = "Modal dialogs URL mismatch";
    private static final String MAIN_TEXT_ERROR = "Main text mismatch";
    private static final String FRAMES_VISIBLE_ERROR = "Frames should be visible";
    private static final String FRAMES_NOT_VISIBLE_ERROR = "Frames should not be visible";

    private Alerts_Frames_WindowsPage alerts_frames_windowsPage;

    @BeforeMethod
    public void goToAlertsFramesWindowsPage() {
        navigateToUrl(ALERTS_WINDOWS_URL);
        alerts_frames_windowsPage = new Alerts_Frames_WindowsPage(driver);
    }

    @Test(enabled = true, description = "Verify navigation to all 5 sub-pages in left menu")
    public void checkAllFivePagesLinksAndText() {
        // Arrange & Act
        alerts_frames_windowsPage.clickBrowserWindowsTab();
        softAssert.assertEquals(alerts_frames_windowsPage.checkUrl(), BROWSER_WINDOWS_URL, BROWSER_WINDOWS_URL_ERROR);

        alerts_frames_windowsPage.clickAlertsTab();
        softAssert.assertEquals(alerts_frames_windowsPage.checkUrl(), ALERTS_URL, ALERTS_URL_ERROR);

        alerts_frames_windowsPage.clickFramesTab();
        softAssert.assertEquals(alerts_frames_windowsPage.checkUrl(), FRAMES_URL, FRAMES_URL_ERROR);

        alerts_frames_windowsPage.clickNestedFramesTab();
        softAssert.assertEquals(alerts_frames_windowsPage.checkUrl(), NESTED_FRAMES_URL, NESTED_FRAMES_URL_ERROR);

        alerts_frames_windowsPage.clickModalDialogsTab();
        softAssert.assertEquals(alerts_frames_windowsPage.checkUrl(), MODAL_DIALOGS_URL, MODAL_DIALOGS_URL_ERROR);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify left side menu collapses and expands correctly.")
    public void clickLeftDropdownMenu() {
        // Arrange & Act
        String actualString = alerts_frames_windowsPage.getMainText();
        boolean textBoxIsVisible = alerts_frames_windowsPage.verifyFramesIsVisible();

        alerts_frames_windowsPage.clickAlertFramesWindowsTab();
        boolean textBoxIsVisible2 = alerts_frames_windowsPage.verifyFramesIsNotVisible();

        // Assert
        softAssert.assertEquals(actualString, EXPECTED_MAIN_TEXT, MAIN_TEXT_ERROR);
        softAssert.assertTrue(textBoxIsVisible, FRAMES_VISIBLE_ERROR);
        softAssert.assertFalse(textBoxIsVisible2, FRAMES_NOT_VISIBLE_ERROR);
        softAssert.assertAll();
    }
}