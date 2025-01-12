package demoqa.web.test.alerts;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserWindowsPageTests extends BaseTest {

    @Test(enabled = true)
    public void VerifyAllTextOnPage() {
        navigateToUrl("browser-windows");

        String browserWindowsText = "Browser Windows";
        String newTabText = "New Tab";
        String newWindow = "New Window";
        String newWindowMessage = "New Window Message";

        String actualBrowserWindowsText = browserWindowsPage.getBrowserWindowsText();
        String actualNewTabText = browserWindowsPage.getNewTabText();
        String actualNewWindowText = browserWindowsPage.getNewWindowText();
        String actualNewWindowMessageText = browserWindowsPage.getNewWindowMessageText();

        Assert.assertEquals(actualBrowserWindowsText, browserWindowsText, "\nMissing Browser Windows.\n");
        Assert.assertEquals(actualNewTabText, newTabText, "\nMissing New Tab.\n");
        Assert.assertEquals(actualNewWindowText, newWindow, "\nMissing New Window.\n");
        Assert.assertEquals(actualNewWindowMessageText, newWindowMessage, "\nMissing New Window Message.\n");
    }

    @Test(enabled = true)
    public void ClickNewTabButton() {
        navigateToUrl("browser-windows");
        browserWindowsPage.clickNewTabButton();

        String expectedNewTabUrl = "https://demoqa.com/sample";
        String actualNewTabUrl = browserWindowsPage.getNewTabUrl();

        Assert.assertEquals(actualNewTabUrl, expectedNewTabUrl, "\n Actual & Expected URL Do Not Match.\n");
    }

    @Test(enabled = true)
    public void ClickNewWindowButton() {
        navigateToUrl("browser-windows");
        browserWindowsPage.clickNewWindowButton();

        String expectedNewTabUrl = "https://demoqa.com/sample";
        String actualNewTabUrl = browserWindowsPage.getNewWindowUrl();

        Assert.assertEquals(actualNewTabUrl, expectedNewTabUrl, "\n Actual & Expected URL Do Not Match. \n");
    }

    @Test(enabled = false)
    public void ClickNewWindowMessage() {
        navigateToUrl("browser-windows");
        browserWindowsPage.clickNewWindowMessageButton();

        String expectedBrowserMessage = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
        String actualBrowserMessage = browserWindowsPage.getBrowserMessage();

        Assert.assertEquals(actualBrowserMessage, expectedBrowserMessage, "\nWrong message.\n");
    }
}
