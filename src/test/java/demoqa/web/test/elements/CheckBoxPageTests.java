package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxPageTests extends BaseTest {

    @Test
    public void SelectNotesCheckBox() {
        navigateToUrl("checkbox");
        checkBoxPage.clickExpandAll();
        checkBoxPage.clickNotes();

        String actualResultMessage = checkBoxPage.getResultMessage();
        String expectedResultMessage = "You have selected :\nnotes";
        Assert.assertEquals(actualResultMessage, expectedResultMessage, "\nNot selected Notes\n");

        String header = "Check Box";
        String actualHeader = checkBoxPage.getHeader();
        Assert.assertEquals(actualHeader, header, "Wrong Header Message");
    }

    @Test
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

        Assert.assertEquals(actualResult, expectedResult, "\nNot selected Notes\n");
    }

    @Test
    public void DeSelectCheckBoxNotes() {
        navigateToUrl("checkbox");

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickNotes();

        String actualResult = checkBoxPage.getResultMessage();
        String expectedResult = """
                You have selected :
                notes""";
        Assert.assertEquals(actualResult, expectedResult, "\nNot selected Notes\n");

        checkBoxPage.clickNotes();

        Assert.assertTrue(checkBoxPage.isResultMessageShown(), "\n Shown wrong category\n");
    }

    @Test
    public void VerifyResultMessageIsEmptyWithoutSelections() {
        navigateToUrl("checkbox");
        checkBoxPage.clickExpandAll();

        Assert.assertTrue(checkBoxPage.isResultMessageShown(), "\nShown some category\n");
    }

    @Test
    public void SelectCommandsCheckBox() {
        navigateToUrl("checkbox");

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickCommands();

        String actualResult = checkBoxPage.getResultMessage();
        String expectedResult = "You have selected :\ncommands";

        Assert.assertEquals(actualResult, expectedResult, "\nNot selected Commands\n");
    }

    @Test
    public void SelectNotesAndOfficePublic() {
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

    @Test
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

        Assert.assertEquals(actualResult, expectedResult, "Not selected 3 checkbox Notes/Commands");
    }

    @Test
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

        Assert.assertEquals(actualResult, expectedResult, "\nNot selected all CheckBoxes\n");
    }

    @Test
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

    @Test
    public void SelectAllCheckBoxesOneByOne() {
        navigateToUrl("checkbox");

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickNotes();
        checkBoxPage.clickCommands();
        checkBoxPage.clickReact();
        checkBoxPage.clickAngular();
        checkBoxPage.clickVeu();
        checkBoxPage.clickOfficePublic();
        checkBoxPage.clickPrivateOffice();
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

        Assert.assertEquals(actualResult, expectedResult, "\nNot selected all CheckBoxes\n");
    }

    @Test
    public void SelectAllCheckBoxesOneByOneAndDeselectAll() {
        navigateToUrl("checkbox");

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickNotes();
        checkBoxPage.clickCommands();
        checkBoxPage.clickReact();
        checkBoxPage.clickAngular();
        checkBoxPage.clickVeu();
        checkBoxPage.clickOfficePublic();
        checkBoxPage.clickPrivateOffice();
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

        Assert.assertEquals(actualResult, expectedResult, "\nNot selected all CheckBoxes\n");

        checkBoxPage.clickNotes();
        checkBoxPage.clickCommands();
        checkBoxPage.clickReact();
        checkBoxPage.clickAngular();
        checkBoxPage.clickVeu();
        checkBoxPage.clickOfficePublic();
        checkBoxPage.clickPrivateOffice();
        checkBoxPage.clickClassified();
        checkBoxPage.clickGeneral();
        checkBoxPage.clickWordFileDoc();
        checkBoxPage.clickExcelFileDoc();

        boolean isResultMessageShown = checkBoxPage.verifyResultMessageIsMissing();

        Assert.assertTrue(isResultMessageShown, "\nFound some selected CheckBoxes\n");
    }
}
