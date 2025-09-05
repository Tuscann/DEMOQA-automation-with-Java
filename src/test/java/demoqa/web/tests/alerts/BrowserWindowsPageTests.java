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
    private static final String NEW_TAB_H1_TEXT = "This is a sample page";

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
    private static final String SECOND_TAB_H1_ERROR = "Wrong second tab h1 text";
    private static final String WRONG_COLOR_NEW_TAB_ERROR = "Wrong new tab Color";
    private static final String WRONG_COLOR_NEW_WINDOW_ERROR = "Wrong new window Color";
    private static final String WRONG_COLOR_NEW_WINDOW_MESSAGE_ERROR = "Wrong new window message Color";

    private static final String FRAMES_URL = "browser-windows";
    private static final String EXPECTED_BLUE_COLOR = "rgba(0, 123, 255, 1)";
    private static final String EXPECTED_GREY_COLOR = "rgba(169, 169, 169, 1)";
    private BrowserWindowsPage browserWindowsPage;

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

        String actualNewTabBackgroundColor = browserWindowsPage.getNewTabBackgroundColor();
        String actualNewWindowBackgroundColor = browserWindowsPage.getNewWindowBackgroundColor();
        String actualNewWindowMessageBackgroundColor = browserWindowsPage.getNewWindowMessageBackgroundColor();

        // Assert
        softAssert.assertEquals(actualBrowserWindowsText, BROWSER_WINDOWS_TEXT, BROWSER_WINDOWS_TEXT_ERROR);
        softAssert.assertEquals(actualNewTabText, NEW_TAB_TEXT, NEW_TAB_TEXT_ERROR);
        softAssert.assertEquals(actualNewTabBackgroundColor, EXPECTED_BLUE_COLOR, WRONG_COLOR_NEW_TAB_ERROR);
        softAssert.assertEquals(actualNewWindowText, NEW_WINDOW_TEXT, NEW_WINDOW_TEXT_ERROR);
        softAssert.assertEquals(actualNewWindowBackgroundColor, EXPECTED_BLUE_COLOR, WRONG_COLOR_NEW_WINDOW_ERROR);
        softAssert.assertEquals(actualNewWindowMessageText, NEW_WINDOW_MESSAGE_TEXT, NEW_WINDOW_MESSAGE_TEXT_ERROR);
        softAssert.assertEquals(actualNewWindowMessageBackgroundColor, EXPECTED_BLUE_COLOR, WRONG_COLOR_NEW_WINDOW_MESSAGE_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click on new tab button")
    public void clickNewTabButton() {
        // Arrange & Act
        browserWindowsPage.clickNewTabButton();
        String h1Text = browserWindowsPage.getSecondTabH1Text();
        String secondTabBackgroundColor = browserWindowsPage.getSecondTabBackgroundColor();

        // Assert
        softAssert.assertEquals(h1Text, NEW_TAB_H1_TEXT, SECOND_TAB_H1_ERROR);
        softAssert.assertEquals(secondTabBackgroundColor, EXPECTED_GREY_COLOR, WRONG_COLOR_NEW_WINDOW_MESSAGE_ERROR);
        softAssert.assertEquals(browserWindowsPage.getNewTabUrl(), EXPECTED_SAMPLE_URL, NEW_TAB_URL_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click on new window button")
    public void clickNewWindowButton() {
        // Arrange & Act
        browserWindowsPage.clickNewWindowButton();
        String actualNewTabUrl = browserWindowsPage.getNewWindowUrl();
        String h1Text = browserWindowsPage.getSecondTabH1Text();
        String secondTabBackgroundColor = browserWindowsPage.getSecondTabBackgroundColor();

        // Assert
        softAssert.assertEquals(h1Text, NEW_TAB_H1_TEXT, SECOND_TAB_H1_ERROR);
        softAssert.assertEquals(secondTabBackgroundColor, EXPECTED_GREY_COLOR, WRONG_COLOR_NEW_WINDOW_MESSAGE_ERROR);
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
