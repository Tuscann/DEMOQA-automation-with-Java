package demoqa.web.tests.alerts;

import demoqa.pages.alerts.BrowserWindowsPage;
import demoqa.web.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserWindowsPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        // Arrange
        navigateToUrl("browser-windows");
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);

        String browserWindowsText = "Browser Windows";
        String newTabText = "New Tab";
        String newWindow = "New Window";
        String newWindowMessage = "New Window Message";

        // Act
        String actualBrowserWindowsText = browserWindowsPage.getBrowserWindowsText();
        String actualNewTabText = browserWindowsPage.getNewTabText();
        String actualNewWindowText = browserWindowsPage.getNewWindowText();
        String actualNewWindowMessageText = browserWindowsPage.getNewWindowMessageText();

        // Assert
        softAssert.assertEquals(actualBrowserWindowsText, browserWindowsText, "\nMissing Browser Windows.\n");
        softAssert.assertEquals(actualNewTabText, newTabText, "\nMissing New Tab.\n");
        softAssert.assertEquals(actualNewWindowText, newWindow, "\nMissing New Window.\n");
        softAssert.assertEquals(actualNewWindowMessageText, newWindowMessage, "\nMissing New Window Message.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on new tab button")
    public void ClickNewTabButton() {
        // Arrange
        navigateToUrl("browser-windows");
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
        String expectedNewTabUrl = "https://demoqa.com/sample";

        // Act
        browserWindowsPage.clickNewTabButton();
        String actualNewTabUrl = browserWindowsPage.getNewTabUrl();

        // Assert
        softAssert.assertEquals(actualNewTabUrl, expectedNewTabUrl, "\n Actual & Expected URL Do Not Match.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on new window button")
    public void ClickNewWindowButton() {
        // Arrange
        navigateToUrl("browser-windows");
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
        String expectedNewTabUrl = "https://demoqa.com/sample";

        // Act
        browserWindowsPage.clickNewWindowButton();
        String actualNewTabUrl = browserWindowsPage.getNewWindowUrl();

        // Assert
        softAssert.assertEquals(actualNewTabUrl, expectedNewTabUrl, "\n Actual & Expected URL Do Not Match. \n");
        softAssert.assertAll();
    }

    @Test(enabled = false, testName = "Click on new window message button")
    public void ClickNewWindowMessage() {
        // Arrange
        navigateToUrl("browser-windows");
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
        String expectedBrowserMessage = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";

        // Act
        browserWindowsPage.clickNewWindowMessageButton();
        String actualBrowserMessage = browserWindowsPage.getBrowserMessage();

        // Assert
        softAssert.assertEquals(actualBrowserMessage, expectedBrowserMessage, "\nWrong message.\n");
        softAssert.assertAll();
    }
}
