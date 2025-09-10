package demoqa.web.tests.alerts;

import demoqa.pages.alerts.Alerts_Frames_WindowsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
    private static final String MAIN_TEXT_ERROR = "Main text mismatch";
    private static final String FRAMES_VISIBLE_ERROR = "Frames should be visible";
    private static final String FRAMES_NOT_VISIBLE_ERROR = "Frames should not be visible";
    private static final String HOME_ADDRESS_ERROR = "Wrong home address";
    private static final String CARD_NAVIGATION_ERROR = "Failed for card: %s";

    private Alerts_Frames_WindowsPage alerts_frames_windowsPage;

    @BeforeMethod
    public void goToAlertsFramesWindowsPage() {
        navigateToUrl(ALERTS_WINDOWS_URL);
        alerts_frames_windowsPage = new Alerts_Frames_WindowsPage(driver);
    }

    @DataProvider(name = "homePageCards")
    public Object[][] homePageCards() {
        return new Object[][]{
                {"Browser Windows", BROWSER_WINDOWS_URL, (Runnable) () -> alerts_frames_windowsPage.clickBrowserWindowsTab()},
                {"Alerts", ALERTS_URL, (Runnable) () -> alerts_frames_windowsPage.clickAlertsTab()},
                {"Frames", FRAMES_URL, (Runnable) () -> alerts_frames_windowsPage.clickFramesTab()},
                {"Nested Frames", NESTED_FRAMES_URL, (Runnable) () -> alerts_frames_windowsPage.clickNestedFramesTab()},
                {"Modal Dialogs", MODAL_DIALOGS_URL, (Runnable) () -> alerts_frames_windowsPage.clickModalDialogsTab()}
        };
    }

    @Test(dataProvider = "homePageCards", description = "Click and verify card: {0} ")
    public void checkAllFivePagesLinks(String cardName, String expectedUrl, Runnable clickAction) {
        // Arrange & Act
        clickAction.run();
        String actualUrl = alerts_frames_windowsPage.getCurrentUrl();
        alerts_frames_windowsPage.clickTopImage();
        String url = alerts_frames_windowsPage.getCurrentUrl();

        // Assert
        softAssert.assertEquals(actualUrl, expectedUrl, String.format(CARD_NAVIGATION_ERROR, cardName));
        softAssert.assertEquals(url, DEMO_QA_URL, HOME_ADDRESS_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify left side menu collapses and expands correctly.")
    public void verifyLeftSideMenuCollapses() {
        // Arrange & Act
        String actualMainText = alerts_frames_windowsPage.getMainText();
        boolean textBoxIsVisible = alerts_frames_windowsPage.verifyFramesIsVisible();

        alerts_frames_windowsPage.clickAlertFramesWindowsTab();
        boolean textBoxIsVisible2 = alerts_frames_windowsPage.verifyFramesIsNotVisible();

        // Assert
        softAssert.assertEquals(actualMainText, EXPECTED_MAIN_TEXT, MAIN_TEXT_ERROR);
        softAssert.assertTrue(textBoxIsVisible, FRAMES_VISIBLE_ERROR);
        softAssert.assertFalse(textBoxIsVisible2, FRAMES_NOT_VISIBLE_ERROR);
        softAssert.assertAll();
    }
}