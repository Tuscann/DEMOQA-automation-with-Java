package demoqa.web.tests.elements;

import demoqa.web.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxPageTests extends BaseTest {

    @Test(enabled = true, testName = "Select notes checkbox")
    public void SelectNotesCheckBox() {
        navigateToUrl("checkbox");
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
        navigateToUrl("checkbox");

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickNotes();
        checkBoxPage.clickCommands();

        String actualResult = checkBoxPage.getResultMessage();
        String expectedResult = """
                You have selected :
                desktop
                notes
                commands""";

        Assert.assertEquals(actualResult, expectedResult, "\nNot selected Notes.\n");
    }

    @Test(enabled = true, testName = "Deselect notes checkbox")
    public void DeSelectNotesCheckBox() {
        navigateToUrl("checkbox");

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
        navigateToUrl("checkbox");
        checkBoxPage.clickExpandAll();

        Assert.assertTrue(checkBoxPage.isResultMessageShown(), "\nShown some category\n");
    }

    @Test(enabled = true, testName = "Select commands checkbox")
    public void SelectCommandsCheckBox() {
        navigateToUrl("checkbox");

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickCommands();

        String actualResult = checkBoxPage.getResultMessage();
        String expectedResult = "You have selected :\ncommands";

        Assert.assertEquals(actualResult, expectedResult, "\nNot selected Commands.\n");
    }

    @Test(enabled = true, testName = "Select notes and office public checkbox")
    public void SelectNotesAndOfficePublicCheckBox() {
        navigateToUrl("checkbox");

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickNotes();
        checkBoxPage.clickOfficePublic();

        String actualResult = checkBoxPage.getResultMessage();
        String expectedResult = """
                You have selected :
                notes
                public""";

        Assert.assertEquals(actualResult, expectedResult, "Not selected 3 checkbox Notes/Commands");
    }

    @Test(enabled = true, testName = "Collapsed with selected categories")
    public void CollapsedWithSelectedCategories() {
        navigateToUrl("checkbox");

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

        Assert.assertEquals(actualResult, expectedResult, "\nNot selected 3 checkbox Notes/Commands.\n");
    }

    @Test(enabled = true, testName = "Select home checkbox")
    public void SelectHomeCheckBox() {
        navigateToUrl("checkbox");

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

        Assert.assertEquals(actualResult, expectedResult, "\nNot selected all CheckBoxes.\n");
    }

    @Test(enabled = true, testName = "Select desktop documents and downloads checkboxes")
    public void SelectDesktopAndDocumentsAndDownloadsCheckBoxes() {
        navigateToUrl("checkbox");

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickDesktop();
        checkBoxPage.clickDocuments();
        checkBoxPage.clickDownloads();

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

        Assert.assertEquals(actualResult, expectedResult, "\nNot selected all CheckBoxes\n");
    }

    @Test(enabled = true, testName = "Select all checkboxes one by one")
    public void SelectAllCheckBoxesOneByOne() {
        navigateToUrl("checkbox");

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
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Select all checkboxes one by one and deselect all")
    public void SelectAllCheckBoxesOneByOneAndDeselectAll() {
        navigateToUrl("checkbox");

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
