package demoqa.web.tests.elements;

import demoqa.pages.elements.CheckBoxPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxPageTests extends BaseTest {
    // Text Constants
    private static final String EXPECTED_HEADER_TEXT = "Check Box";

    // Expected Result Constants
    private static final String EXPECTED_NOTES_RESULT = "You have selected :\nnotes";
    private static final String EXPECTED_DESKTOP_HOME_COMMANDS_RESULT = """
            You have selected :
            desktop
            notes
            commands""";
    private static final String EXPECTED_NOTES_AND_OFFICE_PUBLIC_RESULT = """
            You have selected :
            notes
            public""";
    private static final String EXPECTED_COLLAPSED_SELECTED_RESULT = """
            You have selected :
            documents
            workspace
            react
            angular
            veu
            office
            public
            private
            classified
            general""";
    private static final String EXPECTED_HOME_SELECTION_RESULT = """
            You have selected :
            home
            desktop
            notes
            commands
            documents
            workspace
            react
            angular
            veu
            office
            public
            private
            classified
            general
            downloads
            wordFile
            excelFile""";

    // Error Message Constants
    private static final String HEADER_TEXT_MISMATCH = "Header text mismatch";
    private static final String NOTES_SELECTION_ERROR = "Notes checkbox not selected properly";
    private static final String DESKTOP_HOME_COMMANDS_SELECTION_ERROR = "Desktop, home, and commands checkboxes not selected properly";
    private static final String NOTES_DESELECTION_ERROR = "Notes checkbox not deselected properly";
    private static final String RESULT_MESSAGE_SHOWN_ERROR = "Result message shown incorrectly";
    private static final String COMMANDS_SELECTION_ERROR = "Commands checkbox not selected properly";
    private static final String NOTES_OFFICE_PUBLIC_SELECTION_ERROR = "Notes and office public checkboxes not selected properly";
    private static final String COLLAPSED_SELECTION_ERROR = "Collapsed selection not working properly";
    private static final String HOME_SELECTION_ERROR = "Home checkbox selection not working properly";
    private static final String DESKTOP_DOCUMENTS_DOWNLOADS_SELECTION_ERROR = "Desktop, documents, and downloads checkboxes not selected properly";
    private static final String ALL_CHECKBOXES_SELECTION_ERROR = "All checkboxes not selected properly";
    private static final String ALL_CHECKBOXES_DESELECTION_ERROR = "All checkboxes not deselected properly";

    private CheckBoxPage checkBoxPage;
    private static final String CHECK_BOX_URL = "checkbox";

    private static final String EXPECTED_SUBMIT_BUTTON_COLOR = "rgba(40, 167, 69, 1)";

    @BeforeMethod
    public void goToCheckBoxPage() {
        navigateToUrl(CHECK_BOX_URL);
        checkBoxPage = new CheckBoxPage(driver);
    }

    @Test(enabled = true, description = "Select notes checkbox and verify selection result")
    public void selectNotesCheckBox() {
        // Arrange & Act
        checkBoxPage.clickExpandAllCheckBoxes();
        checkBoxPage.clickNotes();

        // Assert
        softAssert.assertEquals(checkBoxPage.getResultMessage(), EXPECTED_NOTES_RESULT, NOTES_SELECTION_ERROR);
        softAssert.assertEquals(checkBoxPage.getHeader(), EXPECTED_HEADER_TEXT, HEADER_TEXT_MISMATCH);
        softAssert.assertEquals(checkBoxPage.getResultMessageColor(), EXPECTED_SUBMIT_BUTTON_COLOR, HEADER_TEXT_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select home, and commands checkboxes and verify selection")
    public void selectHomeAndCommandsNotes() {
        // Arrange & Act
        checkBoxPage.clickExpandAllCheckBoxes();
        checkBoxPage.clickNotes();
        checkBoxPage.clickCommands();

        // Assert
        softAssert.assertEquals(checkBoxPage.getResultMessage(), EXPECTED_DESKTOP_HOME_COMMANDS_RESULT, DESKTOP_HOME_COMMANDS_SELECTION_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Deselect notes checkbox and verify deselection result")
    public void deSelectNotesCheckBox() {
        // Arrange & Act
        checkBoxPage.clickExpandAllCheckBoxes();
        checkBoxPage.clickNotes();

        String actualResultMessage = checkBoxPage.getResultMessage();
        checkBoxPage.clickNotes();

        // Assert
        softAssert.assertEquals(actualResultMessage, EXPECTED_NOTES_RESULT, NOTES_DESELECTION_ERROR);
        softAssert.assertTrue(checkBoxPage.isResultMessageEmpty(), RESULT_MESSAGE_SHOWN_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify result message is empty without any checkbox selections")
    public void verifyResultMessageWithExpandOnlyNoCheckboxes() {
        // Arrange & Act
        checkBoxPage.clickExpandAllCheckBoxes();

        // Assert
        softAssert.assertTrue(checkBoxPage.isResultMessageEmpty(), RESULT_MESSAGE_SHOWN_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select notes and office public checkboxes and verify selection")
    public void selectNotesAndOfficePublicCheckBox() {
        // Arrange & Act
        checkBoxPage.clickExpandAllCheckBoxes();
        checkBoxPage.clickNotes();
        checkBoxPage.clickOfficePublic();

        // Assert
        softAssert.assertEquals(checkBoxPage.getResultMessage(), EXPECTED_NOTES_AND_OFFICE_PUBLIC_RESULT, NOTES_OFFICE_PUBLIC_SELECTION_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Test collapsed state with selected categories")
    public void collapsedWithSelectedCategories() {
        // Arrange & Act
        checkBoxPage.clickExpandAllCheckBoxes();
        checkBoxPage.clickWorkSpace();
        checkBoxPage.clickOffice();
        checkBoxPage.clickCollapseAll();

        // Assert
        softAssert.assertEquals(checkBoxPage.getResultMessage(), EXPECTED_COLLAPSED_SELECTED_RESULT, COLLAPSED_SELECTION_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select home checkbox and verify all child checkboxes are selected")
    public void selectHomeCheckBox() {
        // Arrange & Act
        checkBoxPage.clickHome();

        // Assert
        softAssert.assertEquals(checkBoxPage.getResultMessage(), EXPECTED_HOME_SELECTION_RESULT, HOME_SELECTION_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select desktop, documents, and downloads checkboxes and verify selection")
    public void selectDesktopAndDocumentsAndDownloadsCheckBoxes() {
        // Arrange & Act
        checkBoxPage.clickExpandAllCheckBoxes();
        checkBoxPage.clickDesktop();
        checkBoxPage.clickDocuments();
        checkBoxPage.clickDownloads();

        // Assert
        softAssert.assertEquals(checkBoxPage.getResultMessage(), EXPECTED_HOME_SELECTION_RESULT, DESKTOP_DOCUMENTS_DOWNLOADS_SELECTION_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select all checkboxes one by one and verify complete selection")
    public void selectAllCheckBoxesOneByOne() {
        // Arrange & Act
        checkBoxPage.clickExpandAllCheckBoxes();
        checkBoxPage.clickNotes();
        checkBoxPage.clickCommands();
        checkBoxPage.clickWorkSpaceReact();
        checkBoxPage.clickWorkSpaceAngular();
        checkBoxPage.clickWorkSpaceVeu();
        checkBoxPage.clickOfficePublic();
        checkBoxPage.clickOfficePrivate();
        checkBoxPage.clickOfficeClassified();
        checkBoxPage.clickOfficeGeneral();
        checkBoxPage.clickWordFileDoc();
        checkBoxPage.clickExcelFileDoc();

        // Assert
        softAssert.assertEquals(checkBoxPage.getResultMessage(), EXPECTED_HOME_SELECTION_RESULT, ALL_CHECKBOXES_SELECTION_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select all checkboxes one by one and then deselect all to verify complete deselection")
    public void selectAllCheckBoxesOneByOneAndDeselectAll() {
        // Arrange
        checkBoxPage.clickExpandAllCheckBoxes();
        checkBoxPage.clickNotes();
        checkBoxPage.clickCommands();
        checkBoxPage.clickWorkSpaceReact();
        checkBoxPage.clickWorkSpaceAngular();
        checkBoxPage.clickWorkSpaceVeu();
        checkBoxPage.clickOfficePublic();
        checkBoxPage.clickOfficePrivate();
        checkBoxPage.clickOfficeClassified();
        checkBoxPage.clickOfficeGeneral();
        checkBoxPage.clickWordFileDoc();
        checkBoxPage.clickExcelFileDoc();

        String actualResultMessage = checkBoxPage.getResultMessage();

        // Act
        checkBoxPage.clickNotes();
        checkBoxPage.clickCommands();
        checkBoxPage.clickWorkSpaceReact();
        checkBoxPage.clickWorkSpaceAngular();
        checkBoxPage.clickWorkSpaceVeu();
        checkBoxPage.clickOfficePublic();
        checkBoxPage.clickOfficePrivate();
        checkBoxPage.clickOfficeClassified();
        checkBoxPage.clickOfficeGeneral();
        checkBoxPage.clickWordFileDoc();
        checkBoxPage.clickExcelFileDoc();

        // Assert
        softAssert.assertEquals(actualResultMessage, EXPECTED_HOME_SELECTION_RESULT, ALL_CHECKBOXES_SELECTION_ERROR);
        softAssert.assertTrue(checkBoxPage.verifyResultMessageIsMissing(), ALL_CHECKBOXES_DESELECTION_ERROR);
        softAssert.assertAll();
    }
}
