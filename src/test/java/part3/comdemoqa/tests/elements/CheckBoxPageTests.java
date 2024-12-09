package part3.comdemoqa.tests.elements;

import com.pages.demo.pages.elements.CheckBoxPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class CheckBoxPageTests extends BaseTest {

    @Test
    public void SelectOnlyCheckBoxNotes() {
        var checkBoxPage = homePage.goToElements().clickCheckBox();

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickNotes();

        String actualResult = checkBoxPage.getResultMessage();
        String expectedResult = "You have selected :\nnotes";

        Assert.assertEquals(actualResult, expectedResult, "Not selected Notes");
    }

    @Test
    public void SelectDesktopWithHomeAndCommandsNotes() {
        var checkBoxPage = homePage.goToElements().clickCheckBox();

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
        var checkBoxPage = homePage.goToElements().clickCheckBox();

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
        var checkBoxPage = homePage.goToElements().clickCheckBox();
        checkBoxPage.clickExpandAll();

        Assert.assertTrue(checkBoxPage.isResultMessageShown(), "Shown some category");
    }

    @Test
    public void SelectOnlyCheckBoxCommands() {
        var checkBoxPage = homePage.goToElements().clickCheckBox();

        checkBoxPage.clickExpandAll();
        checkBoxPage.clickCommands();

        String actualResult = checkBoxPage.getResultMessage();
        String expectedResult = "You have selected :\ncommands";

        Assert.assertEquals(actualResult, expectedResult, "Not selected Commands");
    }

    @Test
    public void SelectCheckBoxesNotesAndCommands() {
        var checkBoxPage = homePage.goToElements().clickCheckBox();

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
        var checkBoxPage = homePage.goToElements().clickCheckBox();

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
        var checkBoxPage = homePage.goToElements().clickCheckBox();

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
        var checkBoxPage = homePage.goToElements().clickCheckBox();

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
        CheckBoxPage checkBoxPage = homePage.goToElements().clickCheckBox();

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
