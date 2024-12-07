package part3_4.comdemoqa.tests.part3.javascript.elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

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
        String expectedResult = "You have selected :\ndesktop\n" +
                "notes\n" +
                "commands";

        Assert.assertEquals(actualResult, expectedResult, "Not selected 3 checkbox Notes/Commands");
    }
}
