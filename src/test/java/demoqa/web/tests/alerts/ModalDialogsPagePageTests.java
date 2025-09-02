package demoqa.web.tests.alerts;

import demoqa.pages.alerts.ModalDialogsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModalDialogsPagePageTests extends BaseTest {
    // Text Constants
    private static final String MODAL_DIALOGS_TEXT = "Modal Dialogs";
    private static final String CLICK_TEXT = "Click on button to see modal";
    private static final String SMALL_BUTTON_TEXT = "Small modal";
    private static final String LARGE_BUTTON_TEXT = "Large modal";

    // Modal Dialog Constants
    private static final String SMALL_MODAL_HEADER = "Small Modal";
    private static final String SMALL_MODAL_BODY = "This is a small modal. It has very less content";
    private static final String LARGE_MODAL_HEADER = "Large Modal";
    private static final String LARGE_MODAL_BODY = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
    private static final String CLOSE_BUTTON_TEXT = "Close";

    // Color Constants
    private static final String EXPECTED_BLUE_COLOR = "rgba(0, 123, 255, 1)";

    // Error Message Constants
    private static final String MODAL_DIALOGS_TEXT_ERROR = "Modal dialogs text mismatch";
    private static final String CLICK_TEXT_ERROR = "Click text mismatch";
    private static final String SMALL_BUTTON_TEXT_ERROR = "Small button text mismatch";
    private static final String LARGE_BUTTON_TEXT_ERROR = "Large button text mismatch";
    private static final String SMALL_MODAL_HEADER_ERROR = "Small modal header text mismatch";
    private static final String SMALL_MODAL_BODY_ERROR = "Small modal body text mismatch";
    private static final String LARGE_MODAL_HEADER_ERROR = "Large modal header text mismatch";
    private static final String LARGE_MODAL_BODY_ERROR = "Large modal body text mismatch";
    private static final String CLOSE_BUTTON_TEXT_ERROR = "Close button text mismatch";
    private static final String WRONG_BLUE_COLOR = "Wrong blue color";

    private static final String MODAL_DIALOGS_URL = "modal-dialogs";
    private ModalDialogsPage modalDialogsPage;

    @BeforeMethod
    public void goModalDialogsPage() {
        navigateToUrl(MODAL_DIALOGS_URL);
        modalDialogsPage = new ModalDialogsPage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange & Act
        String actualModalDialogsText = modalDialogsPage.getModalDialogsText();
        String actualClickText = modalDialogsPage.getClickText();
        String actualSmallModalButtonText = modalDialogsPage.getSmallModalButtonText();
        String actualLargeModalButtonText = modalDialogsPage.getLargeModalButtonText();
        String actualSmallModalButtonBackgroundColor = modalDialogsPage.getSmallModalDialogsBackgroundColor();
        String actualLargeModalButtonBackgroundColor = modalDialogsPage.getLargeModalDialogsBackgroundColor();

        // Assert
        softAssert.assertEquals(actualModalDialogsText, MODAL_DIALOGS_TEXT, MODAL_DIALOGS_TEXT_ERROR);
        softAssert.assertEquals(actualClickText, CLICK_TEXT, CLICK_TEXT_ERROR);
        softAssert.assertEquals(actualSmallModalButtonText, SMALL_BUTTON_TEXT, SMALL_BUTTON_TEXT_ERROR);
        softAssert.assertEquals(actualLargeModalButtonText, LARGE_BUTTON_TEXT, LARGE_BUTTON_TEXT_ERROR);
        softAssert.assertEquals(actualSmallModalButtonBackgroundColor, EXPECTED_BLUE_COLOR, WRONG_BLUE_COLOR);
        softAssert.assertEquals(actualLargeModalButtonBackgroundColor, EXPECTED_BLUE_COLOR, WRONG_BLUE_COLOR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify small modal dialog text")
    public void verifySmallModalDialogTextAndClickCloseButton() {
        // Arrange
        modalDialogsPage.clickSmallModalButton();
        modalDialogsPage.clickSmallCloseButton();
        modalDialogsPage.clickSmallModalButton();

        // Act
        String actualSmallModalHeader = modalDialogsPage.getSmallModalHeaderText();
        String actualSmallBodyText = modalDialogsPage.getSmallModalText();
        String actualCloseButtonText = modalDialogsPage.getSmallCloseButtonText();
        String actualCloseButtonBackgroundColor = modalDialogsPage.getSmallModalDialogCloseButtonBackgroundColor();
        modalDialogsPage.clickXSmallCloseButton();

        // Assert
        softAssert.assertEquals(actualSmallModalHeader, SMALL_MODAL_HEADER, SMALL_MODAL_HEADER_ERROR);
        softAssert.assertEquals(actualSmallBodyText, SMALL_MODAL_BODY, SMALL_MODAL_BODY_ERROR);
        softAssert.assertEquals(actualCloseButtonText, CLOSE_BUTTON_TEXT, CLOSE_BUTTON_TEXT_ERROR);
        softAssert.assertEquals(actualCloseButtonBackgroundColor, EXPECTED_BLUE_COLOR, SMALL_MODAL_HEADER_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify large modal dialog text")
    public void verifyLargeModalDialogText() {
        // Arrange
        modalDialogsPage.clickLargeModalButton();
        modalDialogsPage.clickLargeCloseButton();
        modalDialogsPage.clickLargeModalButton();

        // Act
        String actualLargeModalHeader = modalDialogsPage.getLargeModalHeaderText();
        String actualBodyText = modalDialogsPage.getLargeModalText();
        String actualCloseButtonText = modalDialogsPage.getLargeCloseButtonText();
        String actualLargeModalBackgroundColor = modalDialogsPage.getLargeModalDialogCloseButtonBackgroundColor();
        modalDialogsPage.clickXSmallCloseButton();

        // Assert
        softAssert.assertEquals(actualLargeModalHeader, LARGE_MODAL_HEADER, LARGE_MODAL_HEADER_ERROR);
        softAssert.assertEquals(actualBodyText, LARGE_MODAL_BODY, LARGE_MODAL_BODY_ERROR);
        softAssert.assertEquals(actualCloseButtonText, CLOSE_BUTTON_TEXT, CLOSE_BUTTON_TEXT_ERROR);
        softAssert.assertEquals(actualLargeModalBackgroundColor, EXPECTED_BLUE_COLOR, LARGE_MODAL_HEADER_ERROR);
        softAssert.assertAll();
    }
}
