package part3_4.comdemoqa.tests.part4.modals;

import com.pages.demo.pages.alerts_frames_windows.Alerts_Frames_WindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class ModalTest extends BaseTest {
    @Test
    public void testSmallModalDialog() {
        Alerts_Frames_WindowsPage afwPage = homePage.goToAlertsFramesWindowsCard();
        var modalDialogsPage = afwPage.clickModalDialogs();
        modalDialogsPage.clickSmallModalButton();
        String actualText = modalDialogsPage.getSmallModalText();
        Assert.assertTrue(actualText.contains
                ("This is a small modal. It has very less"), "\n The message does not contains 'small modal'\n");
    }

    @Test
    public void testLargeModalDialog() {
        var afwPage = homePage.goToAlertsFramesWindowsCard();
        var modalDialogsPage = afwPage.clickModalDialogs();
        modalDialogsPage.clickLargeModalButton();
        String actualText = modalDialogsPage.getLargeModalText();
        Assert.assertTrue(actualText.contains
                ("Large modal"), "\n The message does not contains 'large modal'\n");
    }
}
