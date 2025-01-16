package demoqa.web.test.alerts;

import demoqa.web.BaseTest;
import org.testng.annotations.Test;


public class Alerts_Frames_WindowsPageTests extends BaseTest {

    @Test(enabled = true, testName = "Click on 5 links on left side menu")
    public void CheckAllFivePagesLinksAndText() {
        navigateToUrl("alertsWindows");

        String expectedUrl = "https://demoqa.com/browser-windows";
        alerts_frames_windowsPage.clickBrowserWindows();
        String actualUrl = alerts_frames_windowsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nUrl is not " + expectedUrl + ".\n");

        expectedUrl = "https://demoqa.com/alerts";
        alerts_frames_windowsPage.clickAlerts();
        actualUrl = alerts_frames_windowsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nUrl is not " + expectedUrl + ".\n");

        expectedUrl = "https://demoqa.com/frames";
        alerts_frames_windowsPage.clickFrames();
        actualUrl = alerts_frames_windowsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nUrl is not " + expectedUrl + ".\n");

        expectedUrl = "https://demoqa.com/nestedframes";
        alerts_frames_windowsPage.clickNestedFrames();
        actualUrl = booksPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nUrl is not " + expectedUrl + ".\n");

        expectedUrl = "https://demoqa.com/modal-dialogs";
        alerts_frames_windowsPage.clickModalDialogs();
        actualUrl = booksPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nUrl is not " + expectedUrl + ".\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify show/hide left dropdown menu.")
    public void ClickLeftDropdownMenu() {
        navigateToUrl("alertsWindows");

        String expectedString = "Please select an item from left to start practice.";
        String actualString = alerts_frames_windowsPage.getMainText();
        softAssert.assertEquals(actualString, expectedString, "\nWrong text.\n");

        boolean TextBoxIsVisible = alerts_frames_windowsPage.verifyFramesIsVisible();
        softAssert.assertTrue(TextBoxIsVisible, "\nFrames is not shown.\n");

        alerts_frames_windowsPage.clickAlertFramesWindows();

        TextBoxIsVisible = alerts_frames_windowsPage.verifyFramesIsNotVisible();
        softAssert.assertFalse(TextBoxIsVisible, "\nFrames is shown.\n");

        softAssert.assertAll();
    }
}