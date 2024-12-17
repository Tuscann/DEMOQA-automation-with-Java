package part3.comdemoqa.tests.alerts;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class BrowserWindowsPageTests extends BaseTest {

    @Test
    public void ClickNewTabButton() {
        navigateToUrl("browser-windows");
        browserWindowsPage.clickNewTabButton();

        String expectedNewTabUrl = "https://demoqa.com/sample";
        String actualNewTabUrl = browserWindowsPage.getNewTabUrl();

        Assert.assertEquals(actualNewTabUrl, expectedNewTabUrl, "\n Actual & Expected URL Do Not Match \n");
    }

    @Test
    public void ClickNewWindowButton() {
        navigateToUrl("browser-windows");
        browserWindowsPage.clickNewWindowButton();

        String expectedNewTabUrl = "https://www.moreto.net/";
        String actualNewTabUrl = browserWindowsPage.getNewWindowUrl(expectedNewTabUrl);

        Assert.assertEquals(actualNewTabUrl, expectedNewTabUrl, "\n Actual & Expected URL Do Not Match \n");
    }

    @Test(enabled = false)
    public void ClickNewWindowMessage() {
        navigateToUrl("browser-windows");
        browserWindowsPage.clickNewWindowMessageButton();

        String expectedBrowserMessage = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
        String actualBrowserMessage = browserWindowsPage.getBrowserMessage();
        //TODO How to take text in new Browser message


        Assert.assertEquals(actualBrowserMessage, expectedBrowserMessage, "\n Actual & Expected URL Do Not Match \n");
    }
}
