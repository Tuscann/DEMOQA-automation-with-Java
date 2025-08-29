package demoqa.web.tests.alerts;

import demoqa.pages.alerts.BrowserWindowsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserWindowsPageTests extends BaseTest {
    // Text Constants
    private static final String BROWSER_WINDOWS_TEXT = "Browser Windows";
    private static final String NEW_TAB_TEXT = "New Tab";
    private static final String NEW_WINDOW_TEXT = "New Window";
    private static final String NEW_WINDOW_MESSAGE_TEXT = "New Window Message";

    // URL Constants
    private static final String EXPECTED_SAMPLE_URL = DEMO_QA_URL + "sample";

    // Message Constants
    private static final String EXPECTED_BROWSER_MESSAGE = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";

    // Error Message Constants
    private static final String BROWSER_WINDOWS_TEXT_ERROR = "Browser Windows text mismatch";
    private static final String NEW_TAB_TEXT_ERROR = "New Tab text mismatch";
    private static final String NEW_WINDOW_TEXT_ERROR = "New Window text mismatch";
    private static final String NEW_WINDOW_MESSAGE_TEXT_ERROR = "New Window Message text mismatch";
    private static final String NEW_TAB_URL_ERROR = "New Tab URL mismatch";
    private static final String NEW_WINDOW_URL_ERROR = "New Window URL mismatch";
    private static final String BROWSER_MESSAGE_ERROR = "Browser message mismatch";

    private static final String FRAMES_URL = "browser-windows";
    private BrowserWindowsPage browserWindowsPage;
    private static final String EXPECTED_BLUE_COLOR = "rgba(0, 123, 255, 1)";

    @BeforeMethod
    public void goToBrowserWindowsPage() {
        navigateToUrl(FRAMES_URL);
        browserWindowsPage = new BrowserWindowsPage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange & Act
        String actualBrowserWindowsText = browserWindowsPage.getBrowserWindowsText();
        String actualNewTabText = browserWindowsPage.getNewTabText();
        String actualNewWindowText = browserWindowsPage.getNewWindowText();
        String actualNewWindowMessageText = browserWindowsPage.getNewWindowMessageText();
        String actualBrowserWindowsColor = browserWindowsPage.getBrowserWindowsColor();
        String actualNewWindowColor = browserWindowsPage.getNewWindowColor();
        String actualNewWindowMessageColor = browserWindowsPage.getNewWindowMessageColor();

        // Assert
        softAssert.assertEquals(actualBrowserWindowsText, BROWSER_WINDOWS_TEXT, BROWSER_WINDOWS_TEXT_ERROR);
        softAssert.assertEquals(actualNewTabText, NEW_TAB_TEXT, NEW_TAB_TEXT_ERROR);
        softAssert.assertEquals(actualBrowserWindowsColor, EXPECTED_BLUE_COLOR, "Wrong blue color for NewTab");
        softAssert.assertEquals(actualNewWindowText, NEW_WINDOW_TEXT, NEW_WINDOW_TEXT_ERROR);
        softAssert.assertEquals(actualNewWindowColor, EXPECTED_BLUE_COLOR, "Wrong blue color for New Window");
        softAssert.assertEquals(actualNewWindowMessageText, NEW_WINDOW_MESSAGE_TEXT, NEW_WINDOW_MESSAGE_TEXT_ERROR);
        softAssert.assertEquals(actualNewWindowMessageColor, EXPECTED_BLUE_COLOR, "Wrong blue color for New Window Message");

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click on new tab button")
    public void clickNewTabButton() {
        // Arrange & Act
        browserWindowsPage.clickNewTabButton();

        // Assert
        softAssert.assertEquals(browserWindowsPage.getNewTabUrl(), EXPECTED_SAMPLE_URL, NEW_TAB_URL_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click on new window button")
    public void clickNewWindowButton() {
        // Arrange & Act
        browserWindowsPage.clickNewWindowButton();
        String actualNewTabUrl = browserWindowsPage.getNewWindowUrl();

        // Assert
        softAssert.assertEquals(actualNewTabUrl, EXPECTED_SAMPLE_URL, NEW_WINDOW_URL_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = false, description = "Click on new window message button")
    public void clickNewWindowMessage() {
        // Arrange & Act
        browserWindowsPage.clickNewWindowMessageButton();
        String actualBrowserMessage = browserWindowsPage.getBrowserMessage();

        // Assert
        softAssert.assertEquals(actualBrowserMessage, EXPECTED_BROWSER_MESSAGE, BROWSER_MESSAGE_ERROR);
        softAssert.assertAll();
    }
}
