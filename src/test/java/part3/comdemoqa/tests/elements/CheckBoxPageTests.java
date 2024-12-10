package part3.comdemoqa.tests.elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class CheckBoxPageTests extends BaseTest {

    @Test
    public void SelectOnlyCheckBoxNotes() {
        navigateToUrl("checkbox");
        checkBoxPage.clickExpandAll();
        checkBoxPage.clickNotes();

        String actualResult = checkBoxPage.getResultMessage();
        String expectedResult = "You have selected :\nnotes";

        Assert.assertEquals(actualResult, expectedResult, "Not selected Notes");
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

        Assert.assertEquals(actualResult, expectedResult, "Not selected Notes");
    }

    @Test
    public void DeSelectOnlyCheckBoxNotes() {
        navigateToUrl("checkbox");

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickNotes();

        String actualResult = checkBoxPage.getResultMessage();
        String expectedResult = """
                You have selected :
                notes""";
        Assert.assertEquals(actualResult, expectedResult, "Not selected Notes");

        checkBoxPage.clickNotes();

        Assert.assertTrue(checkBoxPage.isResultMessageShown(), "Shown some category");
    }

    @Test
    public void CheckAllCheckBoxesAreDeselected() {
        navigateToUrl("checkbox");
        checkBoxPage.clickExpandAll();

        Assert.assertTrue(checkBoxPage.isResultMessageShown(), "Shown some category");
    }

    @Test
    public void SelectOnlyCheckBoxCommands() {
        navigateToUrl("checkbox");

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickCommands();

        String actualResult = checkBoxPage.getResultMessage();
        String expectedResult = "You have selected :\ncommands";

        Assert.assertEquals(actualResult, expectedResult, "Not selected Commands");
    }

    @Test
    public void SelectCheckBoxesNotesAndCommands() {
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

        Assert.assertEquals(actualResult, expectedResult, "Not selected 3 checkbox Notes/Commands");
    }

    @Test
    public void SelectOnlyCheckBoxHome() {
        navigateToUrl("checkbox");

        checkBoxPage.clickExpandAll();
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

        Assert.assertEquals(actualResult, expectedResult, "Not selected all CheckBoxes");
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

        Assert.assertEquals(actualResult, expectedResult, "Not selected all CheckBoxes");
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
        checkBoxPage.clickPublicOffice();
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

        Assert.assertEquals(actualResult, expectedResult, "Not selected all CheckBoxes");
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
        checkBoxPage.clickPublicOffice();
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

        Assert.assertEquals(actualResult, expectedResult, "Not selected all CheckBoxes");

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickNotes();
        checkBoxPage.clickCommands();
        checkBoxPage.clickReact();
        checkBoxPage.clickAngular();
        checkBoxPage.clickVeu();
        checkBoxPage.clickPublicOffice();
        checkBoxPage.clickPrivateOffice();
        checkBoxPage.clickClassified();
        checkBoxPage.clickGeneral();
        checkBoxPage.clickWordFileDoc();
        checkBoxPage.clickExcelFileDoc();
    }
}
