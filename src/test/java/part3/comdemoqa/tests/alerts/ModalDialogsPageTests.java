package part3.comdemoqa.tests.alerts;

import com.pages.demo.pages.alerts_frames_windows.Alerts_Frames_WindowsPage;
import com.pages.demo.pages.alerts_frames_windows.ModalDialogsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class ModalDialogsPageTests extends BaseTest {
    @Test
    public void testSmallModalDialog() {
        Alerts_Frames_WindowsPage afwPage = homePage.goToAlertsFramesWindowsCard();
        ModalDialogsPage modalDialogsPage = afwPage.clickModalDialogs();
        modalDialogsPage.clickSmallModalButton();
        String actualText = modalDialogsPage.getSmallModalText();
        Assert.assertTrue(actualText.contains
                ("This is a small modal. It has very less"), "\n The message does not contains 'small modal'\n");
    }

    @Test
    public void testLargeModalDialog() {
        Alerts_Frames_WindowsPage afwPage = homePage.goToAlertsFramesWindowsCard();
        ModalDialogsPage modalDialogsPage = afwPage.clickModalDialogs();
        modalDialogsPage.clickLargeModalButton();
        String actualText = modalDialogsPage.getLargeModalText();
        Assert.assertTrue(actualText.contains
                ("Large modal"), "\n The message does not contains 'large modal'\n");
    }

    @Test
    public void checkAllText() {
        ModalDialogsPage modalDialogsPage = homePage.goToAlertsFramesWindowsCard().clickModalDialogs();

        String modalDialogsText = "Modal Dialogs";
        String clickText = "Click on button to see modal";
        String smallText = "Small modal";
        String largeText = "Large modal";

        String actualModalDialogsText = modalDialogsPage.getModalDialogsText();
        String actualClickText = modalDialogsPage.getClickText();
        String actualSmallText = modalDialogsPage.getSmallText();
        String actualLargeText = modalDialogsPage.getLargeText();

        Assert.assertEquals(actualModalDialogsText, modalDialogsText);
        Assert.assertEquals(actualClickText, clickText);
        Assert.assertEquals(actualSmallText, smallText);
        Assert.assertEquals(actualLargeText, largeText);
    }
}
