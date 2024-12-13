package part3.comdemoqa.tests.alerts;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class Alerts_Frames_WindowsPageTests extends BaseTest {

    @Test(enabled = true)
    public void CheckAllFivePagesLinks() {
        navigateToUrl("alertsWindows");

        String expectedUrl = "https://demoqa.com/browser-windows";
        alerts_frames_windowsPage.clickBrowserWindows();
        String actualUrl = alerts_frames_windowsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/alerts";
        alerts_frames_windowsPage.clickAlerts();
        actualUrl = alerts_frames_windowsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/frames";
        alerts_frames_windowsPage.clickFrames();
        actualUrl = alerts_frames_windowsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/nestedframes";
        alerts_frames_windowsPage.clickNestedFrames();
        actualUrl = booksPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/modal-dialogs";
        alerts_frames_windowsPage.clickModalDialogs();
        actualUrl = booksPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
