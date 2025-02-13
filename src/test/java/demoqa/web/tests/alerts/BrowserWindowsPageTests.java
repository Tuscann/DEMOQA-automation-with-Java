package demoqa.web.tests.alerts;

import demoqa.web.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserWindowsPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on page")
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

        softAssert.assertEquals(actualBrowserWindowsText, browserWindowsText, "\nMissing Browser Windows.\n");
        softAssert.assertEquals(actualNewTabText, newTabText, "\nMissing New Tab.\n");
        softAssert.assertEquals(actualNewWindowText, newWindow, "\nMissing New Window.\n");
        softAssert.assertEquals(actualNewWindowMessageText, newWindowMessage, "\nMissing New Window Message.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on new tab button")
    public void ClickNewTabButton() {
        navigateToUrl("browser-windows");
        browserWindowsPage.clickNewTabButton();

        String expectedNewTabUrl = "https://demoqa.com/sample";
        String actualNewTabUrl = browserWindowsPage.getNewTabUrl();

        Assert.assertEquals(actualNewTabUrl, expectedNewTabUrl, "\n Actual & Expected URL Do Not Match.\n");
    }

    @Test(enabled = true, testName = "Click on new window button")
    public void ClickNewWindowButton() {
        navigateToUrl("browser-windows");
        browserWindowsPage.clickNewWindowButton();

        String expectedNewTabUrl = "https://demoqa.com/sample";
        String actualNewTabUrl = browserWindowsPage.getNewWindowUrl();

        Assert.assertEquals(actualNewTabUrl, expectedNewTabUrl, "\n Actual & Expected URL Do Not Match. \n");
    }

    @Test(enabled = false, testName = "Click on new window message button")
    public void ClickNewWindowMessage() {
        navigateToUrl("browser-windows");
        browserWindowsPage.clickNewWindowMessageButton();

        String expectedBrowserMessage = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
        String actualBrowserMessage = browserWindowsPage.getBrowserMessage();

        Assert.assertEquals(actualBrowserMessage, expectedBrowserMessage, "\nWrong message.\n");
    }
}
