package demoqa.web.tests.elements;

import demoqa.pages.elements.CheckBoxPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.Test;

public class CheckBoxPageTests extends BaseTest {

    @Test(enabled = true, testName = "Select notes checkbox")
    public void SelectNotesCheckBox() {
        navigateToUrl("checkbox");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickNotes();

        String actualResultMessage = checkBoxPage.getResultMessage();
        String expectedResultMessage = "You have selected :\nnotes";
        softAssert.assertEquals(actualResultMessage, expectedResultMessage, "\nNot selected Notes\n");

        String header = "Check Box";
        String actualHeader = checkBoxPage.getHeader();
        softAssert.assertEquals(actualHeader, header, "\nWrong Header Message.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Select desktop home commands checkboxes")
    public void SelectDesktopWithHomeAndCommandsNotes() {
        // Arrange
        navigateToUrl("checkbox");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickNotes();
        checkBoxPage.clickCommands();

        String actualResult = checkBoxPage.getResultMessage();
        String expectedResult = """
                You have selected :
                desktop
                notes
                commands""";

        softAssert.assertEquals(actualResult, expectedResult, "\nNot selected Notes.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Deselect notes checkbox")
    public void DeSelectNotesCheckBox() {
        // Arrange
        navigateToUrl("checkbox");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickNotes();

        String actualResult = checkBoxPage.getResultMessage();
        String expectedResult = """
                You have selected :
                notes""";
        softAssert.assertEquals(actualResult, expectedResult, "\nNot selected Notes.\n");

        checkBoxPage.clickNotes();

        softAssert.assertTrue(checkBoxPage.isResultMessageShown(), "\nShown wrong category.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify result message is empty without selections")
    public void VerifyResultMessageIsEmptyWithoutSelections() {
        // Arrange
        navigateToUrl("checkbox");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        checkBoxPage.clickExpandAll();

        softAssert.assertTrue(checkBoxPage.isResultMessageShown(), "\nShown some category\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Select commands checkbox")
    public void SelectCommandsCheckBox() {
        // Arrange
        navigateToUrl("checkbox");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickCommands();

        String actualResult = checkBoxPage.getResultMessage();
        String expectedResult = "You have selected :\ncommands";

        softAssert.assertEquals(actualResult, expectedResult, "\nNot selected Commands.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Select notes and office public checkbox")
    public void SelectNotesAndOfficePublicCheckBox() {
        // Arrange
        navigateToUrl("checkbox");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickNotes();
        checkBoxPage.clickOfficePublic();

        String actualResult = checkBoxPage.getResultMessage();
        String expectedResult = """
                You have selected :
                notes
                public""";

        softAssert.assertEquals(actualResult, expectedResult, "Not selected 3 checkbox Notes/Commands");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Collapsed with selected categories")
    public void CollapsedWithSelectedCategories() {
        // Arrange
        navigateToUrl("checkbox");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickOffice();
        checkBoxPage.clickWorkSpace();
        checkBoxPage.clickCollapseAll();

        String actualResult = checkBoxPage.getResultMessage();
        String expectedResult = """
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

        softAssert.assertEquals(actualResult, expectedResult, "\nNot selected 3 checkbox Notes/Commands.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Select home checkbox")
    public void SelectHomeCheckBox() {
        // Arrange
        navigateToUrl("checkbox");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        checkBoxPage.clickHome();

        String actualResult = checkBoxPage.getResultMessage();
        String expectedResult = """
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

        softAssert.assertEquals(actualResult, expectedResult, "\nNot selected all CheckBoxes.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Select desktop documents and downloads checkboxes")
    public void SelectDesktopAndDocumentsAndDownloadsCheckBoxes() {
        // Arrange
        navigateToUrl("checkbox");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        String expectedResult = """
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

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickDesktop();
        checkBoxPage.clickDocuments();
        checkBoxPage.clickDownloads();

        String actualResult = checkBoxPage.getResultMessage();

        softAssert.assertEquals(actualResult, expectedResult, "\nNot selected all CheckBoxes\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Select all checkboxes one by one")
    public void SelectAllCheckBoxesOneByOne() {
        // Arrange
        navigateToUrl("checkbox");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        String expectedResult = """
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

        // Act
        checkBoxPage.clickExpandAll();
        checkBoxPage.clickNotes();
        checkBoxPage.clickCommands();
        checkBoxPage.clickReact();
        checkBoxPage.clickAngular();
        checkBoxPage.clickVeu();
        checkBoxPage.clickOfficePublic();
        checkBoxPage.clickOfficePrivate();
        checkBoxPage.clickClassified();
        checkBoxPage.clickGeneral();
        checkBoxPage.clickWordFileDoc();
        checkBoxPage.clickExcelFileDoc();
        String actualResult = checkBoxPage.getResultMessage();

        // Assert
        softAssert.assertEquals(actualResult, expectedResult, "\nNot selected all CheckBoxes.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Select all checkboxes one by one and deselect all")
    public void SelectAllCheckBoxesOneByOneAndDeselectAll() {
        navigateToUrl("checkbox");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickNotes();
        checkBoxPage.clickCommands();
        checkBoxPage.clickReact();
        checkBoxPage.clickAngular();
        checkBoxPage.clickVeu();
        checkBoxPage.clickOfficePublic();
        checkBoxPage.clickOfficePrivate();
        checkBoxPage.clickClassified();
        checkBoxPage.clickGeneral();
        checkBoxPage.clickWordFileDoc();
        checkBoxPage.clickExcelFileDoc();

        String actualResult = checkBoxPage.getResultMessage();
        String expectedResult = """
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

        softAssert.assertEquals(actualResult, expectedResult, "\nNot selected all CheckBoxes.\n");

        checkBoxPage.clickNotes();
        checkBoxPage.clickCommands();
        checkBoxPage.clickReact();
        checkBoxPage.clickAngular();
        checkBoxPage.clickVeu();
        checkBoxPage.clickOfficePublic();
        checkBoxPage.clickOfficePrivate();
        checkBoxPage.clickClassified();
        checkBoxPage.clickGeneral();
        checkBoxPage.clickWordFileDoc();
        checkBoxPage.clickExcelFileDoc();

        boolean isResultMessageShown = checkBoxPage.verifyResultMessageIsMissing();

        softAssert.assertTrue(isResultMessageShown, "\nFound some selected CheckBoxes.\n");
        softAssert.assertAll();
    }
}
