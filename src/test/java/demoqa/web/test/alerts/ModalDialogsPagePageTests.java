package demoqa.web.test.alerts;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModalDialogsPagePageTests extends BaseTest {

    @Test
    public void VerifyAllTextOnPage() {
        navigateToUrl("modal-dialogs");

        String modalDialogsText = "Modal Dialogs";
        String clickText = "Click on button to see modal";
        String smallText = "Small modal";
        String largeText = "Large modal";

        String actualModalDialogsText = modalDialogsPage.getModalDialogsText();
        String actualClickText = modalDialogsPage.getClickText();
        String actualSmallText = modalDialogsPage.getSmallText();
        String actualLargeText = modalDialogsPage.getLargeText();

        Assert.assertEquals(actualModalDialogsText, modalDialogsText, "Missing modal dialogs text");
        Assert.assertEquals(actualClickText, clickText, "Missing click text");
        Assert.assertEquals(actualSmallText, smallText, "Missing small text");
        Assert.assertEquals(actualLargeText, largeText, "Missing large text");
    }

    @Test
    public void VerifySmallModalDialogText() {
        navigateToUrl("modal-dialogs");

        modalDialogsPage.clickSmallModalButton();
        String expectedSmallModalText = "Small Modal";
        String expectedSmallBodyText = "This is a small modal. It has very less content";
        String expectedClosButtonText = "Close";

        String actualSmallModalHeader = modalDialogsPage.getSmallModalHeaderText();
        String actualSmallBodyText = modalDialogsPage.getSmallModalText();
        String actualCloseButtonText = modalDialogsPage.getSmallCloseButtonText();

        Assert.assertEquals(actualSmallModalHeader, expectedSmallModalText, "Wrong modal header text");
        Assert.assertEquals(actualSmallBodyText, expectedSmallBodyText, "Wrong modal header text");
        Assert.assertEquals(actualCloseButtonText, expectedClosButtonText, "Wrong close button text");
    }

    @Test
    public void VerifyLargeModalDialogText() {
        navigateToUrl("modal-dialogs");

        modalDialogsPage.clickLargeModalButton();
        String expectedLargeModalText = "Large Modal";
        String expectedLargeBodyText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String expectedClosButtonText = "Close";

        String actualLargeModalHeader = modalDialogsPage.getLargeModalHeaderText();
        String actualBodyText = modalDialogsPage.getLargeModalText();
        String actualCloseButtonText = modalDialogsPage.getLargeCloseButtonText();

        Assert.assertEquals(actualLargeModalHeader, expectedLargeModalText, "Wrong modal header text");
        Assert.assertEquals(actualBodyText, expectedLargeBodyText, "Wrong modal header text");
        Assert.assertEquals(actualCloseButtonText, expectedClosButtonText, "Wrong close button text");
    }
}
