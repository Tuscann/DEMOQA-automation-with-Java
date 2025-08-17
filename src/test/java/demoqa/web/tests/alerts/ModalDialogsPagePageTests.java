package demoqa.web.tests.alerts;

import demoqa.pages.alerts.ModalDialogsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModalDialogsPagePageTests extends BaseTest {

    private static final String MODAL_DIALOGS_URL = "modal-dialogs";
    private ModalDialogsPage modalDialogsPage;

    @BeforeMethod
    public void goModalDialogsPage() {
        navigateToUrl(MODAL_DIALOGS_URL);
        modalDialogsPage = new ModalDialogsPage(driver);
    }

    @Test(enabled = true, testName = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange
        String modalDialogsText = "Modal Dialogs";
        String clickText = "Click on button to see modal";
        String smallButtonText = "Small modal";
        String largeButtonText = "Large modal";

        // Act
        String actualModalDialogsText = modalDialogsPage.getModalDialogsText();
        String actualClickText = modalDialogsPage.getClickText();
        String actualSmallText = modalDialogsPage.getSmallText();
        String actualLargeText = modalDialogsPage.getLargeText();

        // Assert
        softAssert.assertEquals(actualModalDialogsText, modalDialogsText, "\nMissing modal dialogs text.\n");
        softAssert.assertEquals(actualClickText, clickText, "\nMissing click text.\n");
        softAssert.assertEquals(actualSmallText, smallButtonText, "\nMissing small text.\n");
        softAssert.assertEquals(actualLargeText, largeButtonText, "\nMissing large text.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify small modal dialog text")
    public void verifySmallModalDialogText() {
        // Arrange
        modalDialogsPage.clickSmallModalButton();
        String expectedSmallModalText = "Small Modal";
        String expectedSmallBodyText = "This is a small modal. It has very less content";
        String expectedClosButtonText = "Close";

        // Act
        String actualSmallModalHeader = modalDialogsPage.getSmallModalHeaderText();
        String actualSmallBodyText = modalDialogsPage.getSmallModalText();
        String actualCloseButtonText = modalDialogsPage.getSmallCloseButtonText();

        // Assert
        softAssert.assertEquals(actualSmallModalHeader, expectedSmallModalText, "\nWrong modal header text.\n");
        softAssert.assertEquals(actualSmallBodyText, expectedSmallBodyText, "\nWrong modal header text.\n");
        softAssert.assertEquals(actualCloseButtonText, expectedClosButtonText, "\nWrong close button text.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify large modal dialog text")
    public void verifyLargeModalDialogText() {
        // Arrange
        modalDialogsPage.clickLargeModalButton();
        String expectedLargeModalText = "Large Modal";
        String expectedLargeBodyText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String expectedClosButtonText = "Close";

        // Act
        String actualLargeModalHeader = modalDialogsPage.getLargeModalHeaderText();
        String actualBodyText = modalDialogsPage.getLargeModalText();
        String actualCloseButtonText = modalDialogsPage.getLargeCloseButtonText();

        // Assert
        softAssert.assertEquals(actualLargeModalHeader, expectedLargeModalText, "\nWrong modal header text.\n");
        softAssert.assertEquals(actualBodyText, expectedLargeBodyText, "\nWrong modal header text.\n");
        softAssert.assertEquals(actualCloseButtonText, expectedClosButtonText, "\nWrong close button text.\n");
        softAssert.assertAll();
    }
}
