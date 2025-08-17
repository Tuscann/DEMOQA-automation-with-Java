package demoqa.web.tests.alerts;

import demoqa.pages.alerts.Alerts_Frames_WindowsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsFramesWindowsPageTests extends BaseTest {

    private static final String BASE_URL = "https://demoqa.com/";
    private static final String ALERTS_WINDOWS_URL = "alertsWindows";
    private static final String BROWSER_WINDOWS_URL = BASE_URL + "browser-windows";
    private static final String ALERTS_URL = BASE_URL + "alerts";
    private static final String FRAMES_URL = BASE_URL + "frames";
    private static final String NESTED_FRAMES_URL = BASE_URL + "nestedframes";
    private static final String MODAL_DIALOGS_URL = BASE_URL + "modal-dialogs";

    private static final String EXPECTED_MAIN_TEXT = "Please select an item from left to start practice.";

    private Alerts_Frames_WindowsPage alerts_frames_windowsPage;

    @BeforeMethod
    public void goToAlertsFramesWindowsPage() {
        navigateToUrl(ALERTS_WINDOWS_URL);
        alerts_frames_windowsPage = new Alerts_Frames_WindowsPage(driver);
    }

    @Test(enabled = true, testName = "Verify navigation to all 5 sub-pages in left menu")
    public void checkAllFivePagesLinksAndText() {
        // Arrange
        // Act
        alerts_frames_windowsPage.clickBrowserWindows();
        softAssert.assertEquals(alerts_frames_windowsPage.checkUrl(), BROWSER_WINDOWS_URL, "\nUrl is not " + BROWSER_WINDOWS_URL + ".\n");

        alerts_frames_windowsPage.clickAlerts();
        softAssert.assertEquals(alerts_frames_windowsPage.checkUrl(), ALERTS_URL, "\nUrl is not " + ALERTS_URL + ".\n");

        alerts_frames_windowsPage.clickFrames();
        softAssert.assertEquals(alerts_frames_windowsPage.checkUrl(), FRAMES_URL, "\nUrl is not " + FRAMES_URL + ".\n");

        alerts_frames_windowsPage.clickNestedFrames();
        softAssert.assertEquals(alerts_frames_windowsPage.checkUrl(), NESTED_FRAMES_URL, "\nUrl is not " + NESTED_FRAMES_URL + ".\n");

        alerts_frames_windowsPage.clickModalDialogs();
        softAssert.assertEquals(alerts_frames_windowsPage.checkUrl(), MODAL_DIALOGS_URL, "\nUrl is not " + MODAL_DIALOGS_URL + ".\n");

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify left side menu collapses and expands correctly.")
    public void clickLeftDropdownMenu() {
        // Arrange & Act
        String actualString = alerts_frames_windowsPage.getMainText();
        boolean textBoxIsVisible = alerts_frames_windowsPage.verifyFramesIsVisible();

        alerts_frames_windowsPage.clickAlertFramesWindows();
        boolean textBoxIsVisible2 = alerts_frames_windowsPage.verifyFramesIsNotVisible();

        // Assert
        softAssert.assertEquals(actualString, EXPECTED_MAIN_TEXT, "\nExpecting " + EXPECTED_MAIN_TEXT + " text.\n");
        softAssert.assertTrue(textBoxIsVisible, "\nFrames is not shown.\n");
        softAssert.assertFalse(textBoxIsVisible2, "\nFrames is shown.\n");
        softAssert.assertAll();
    }
}