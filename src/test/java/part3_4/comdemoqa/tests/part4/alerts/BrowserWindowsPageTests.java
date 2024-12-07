package part3_4.comdemoqa.tests.part4.alerts;

import com.pages.demo.pages.alerts_frames_windows.BrowserWindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class BrowserWindowsPageTests extends BaseTest {

    @Test
    public void clickNewTabButton() {

        BrowserWindowsPage browserWindowsPage = homePage.goToAlertsFramesWindowsCard().clickBrowserWindows();
        browserWindowsPage.clickNewTabButton();

        String expectedNewTabUrl = "https://demoqa.com/sample";
        String actualNewTabUrl = browserWindowsPage.getNewTabUrl();

        Assert.assertEquals(actualNewTabUrl, expectedNewTabUrl, "\n Actual & Expected URL Do Not Match \n");
    }

    @Test
    public void clickNewWindowButton() {

        BrowserWindowsPage browserWindowsPage = homePage.goToAlertsFramesWindowsCard().clickBrowserWindows();
        browserWindowsPage.clickNewWindowButton();

        String expectedNewTabUrl = "https://www.moreto.net/";
        String actualNewTabUrl = browserWindowsPage.getNewWindowUrl(expectedNewTabUrl);

        Assert.assertEquals(actualNewTabUrl, expectedNewTabUrl, "\n Actual & Expected URL Do Not Match \n");
    }

    // @Test
    public void clickNewBrowserMessage() {

        BrowserWindowsPage browserWindowsPage = homePage.goToAlertsFramesWindowsCard().clickBrowserWindows();
        browserWindowsPage.clickNewWindowMessageButton();

        String expectedBrowserMessage = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
        String actualBrowserMessage = browserWindowsPage.getBrowserMessage();  //TODO How to take text in new

        Assert.assertEquals(actualBrowserMessage, expectedBrowserMessage, "\n Actual & Expected URL Do Not Match \n");
    }
}
