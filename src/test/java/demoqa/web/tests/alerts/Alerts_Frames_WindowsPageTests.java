package demoqa.web.tests.alerts;

import demoqa.pages.alerts.Alerts_Frames_WindowsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.Test;

public class Alerts_Frames_WindowsPageTests extends BaseTest {

    @Test(enabled = true, testName = "Click on 5 links on left side menu")
    public void CheckAllFivePagesLinksAndText() {
        // Arrange
        navigateToUrl("alertsWindows");
        Alerts_Frames_WindowsPage alerts_frames_windowsPage = new Alerts_Frames_WindowsPage(driver);

        String expectedBrowserWindowsUrl = "https://demoqa.com/browser-windows";
        String expectedAlertsUrl = "https://demoqa.com/alerts";
        String expectedFramesUrl = "https://demoqa.com/frames";
        String expectedNestedFramesUrl = "https://demoqa.com/nestedframes";
        String expectedModalDialogsUrl = "https://demoqa.com/modal-dialogs";

        // Act
        alerts_frames_windowsPage.clickBrowserWindows();
        String actualBrowserWindowsUrl = alerts_frames_windowsPage.checkUrl();

        alerts_frames_windowsPage.clickAlerts();
        String actualAlertsUrl = alerts_frames_windowsPage.checkUrl();

        alerts_frames_windowsPage.clickFrames();
        String actualFramesUrl = alerts_frames_windowsPage.checkUrl();

        alerts_frames_windowsPage.clickNestedFrames();
        String actualNestedFramesUrl = alerts_frames_windowsPage.checkUrl();

        alerts_frames_windowsPage.clickModalDialogs();
        String actualModalDialogsUrl = alerts_frames_windowsPage.checkUrl();

        // Assert
        softAssert.assertEquals(actualBrowserWindowsUrl, expectedBrowserWindowsUrl, "\nUrl is not " + expectedBrowserWindowsUrl + ".\n");
        softAssert.assertEquals(actualAlertsUrl, expectedAlertsUrl, "\nUrl is not " + expectedAlertsUrl + ".\n");
        softAssert.assertEquals(actualFramesUrl, expectedFramesUrl, "\nUrl is not " + expectedFramesUrl + ".\n");
        softAssert.assertEquals(actualNestedFramesUrl, expectedNestedFramesUrl, "\nUrl is not " + expectedNestedFramesUrl + ".\n");
        softAssert.assertEquals(actualModalDialogsUrl, expectedModalDialogsUrl, "\nUrl is not " + expectedModalDialogsUrl + ".\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify show/hide left dropdown menu.")
    public void ClickLeftDropdownMenu() {
        // Arrange
        navigateToUrl("alertsWindows");
        Alerts_Frames_WindowsPage alerts_frames_windowsPage = new Alerts_Frames_WindowsPage(driver);
        String expectedString = "Please select an item from left to start practice.";

        // Act
        String actualString = alerts_frames_windowsPage.getMainText();
        boolean TextBoxIsVisible = alerts_frames_windowsPage.verifyFramesIsVisible();

        alerts_frames_windowsPage.clickAlertFramesWindows();

        boolean TextBoxIsVisible2 = alerts_frames_windowsPage.verifyFramesIsNotVisible();

        // Assert
        softAssert.assertEquals(actualString, expectedString, "\nWrong text.\n");
        softAssert.assertTrue(TextBoxIsVisible, "\nFrames is not shown.\n");
        softAssert.assertFalse(TextBoxIsVisible2, "\nFrames is shown.\n");
        softAssert.assertAll();
    }
}