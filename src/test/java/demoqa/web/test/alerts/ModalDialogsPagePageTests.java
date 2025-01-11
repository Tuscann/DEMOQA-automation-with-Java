package demoqa.web.test.alerts;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModalDialogsPagePageTests extends BaseTest {

    @Test(enabled = true)
    public void VerifyAllTextOnPage() {
        navigateToUrl("modal-dialogs");

        String modalDialogsText = "Modal Dialogs";
        String clickText = "Click on button to see modal";
        String smallButtonText = "Small modal";
        String largeButtonText = "Large modal";

        String actualModalDialogsText = modalDialogsPage.getModalDialogsText();
        String actualClickText = modalDialogsPage.getClickText();
        String actualSmallText = modalDialogsPage.getSmallText();
        String actualLargeText = modalDialogsPage.getLargeText();

        Assert.assertEquals(actualModalDialogsText, modalDialogsText, "\nMissing modal dialogs text.\n");
        Assert.assertEquals(actualClickText, clickText, "\nMissing click text.\n");
        Assert.assertEquals(actualSmallText, smallButtonText, "\nMissing small text.\n");
        Assert.assertEquals(actualLargeText, largeButtonText, "\nMissing large text.\n");
    }

    @Test(enabled = true)
    public void VerifySmallModalDialogText() {
        navigateToUrl("modal-dialogs");

        modalDialogsPage.clickSmallModalButton();
        String expectedSmallModalText = "Small Modal";
        String expectedSmallBodyText = "This is a small modal. It has very less content";
        String expectedClosButtonText = "Close";

        String actualSmallModalHeader = modalDialogsPage.getSmallModalHeaderText();
        String actualSmallBodyText = modalDialogsPage.getSmallModalText();
        String actualCloseButtonText = modalDialogsPage.getSmallCloseButtonText();

        Assert.assertEquals(actualSmallModalHeader, expectedSmallModalText, "\nWrong modal header text.\n");
        Assert.assertEquals(actualSmallBodyText, expectedSmallBodyText, "\nWrong modal header text.\n");
        Assert.assertEquals(actualCloseButtonText, expectedClosButtonText, "\nWrong close button text.\n");
    }

    @Test(enabled = true)
    public void VerifyLargeModalDialogText() {
        navigateToUrl("modal-dialogs");

        modalDialogsPage.clickLargeModalButton();
        String expectedLargeModalText = "Large Modal";
        String expectedLargeBodyText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String expectedClosButtonText = "Close";

        String actualLargeModalHeader = modalDialogsPage.getLargeModalHeaderText();
        String actualBodyText = modalDialogsPage.getLargeModalText();
        String actualCloseButtonText = modalDialogsPage.getLargeCloseButtonText();

        Assert.assertEquals(actualLargeModalHeader, expectedLargeModalText, "\nWrong modal header text.\n");
        Assert.assertEquals(actualBodyText, expectedLargeBodyText, "\nWrong modal header text.\n");
        Assert.assertEquals(actualCloseButtonText, expectedClosButtonText, "\nWrong close button text.\n");
    }
}
