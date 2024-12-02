package part3_4.comdemoqa.tests.part3.javascript.forms;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class CheckboxTest extends BaseTest {

    @Test
    public void testCheckboxes() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickSportHobbyCheckbox();
        formsPage.clickMusicHobbyCheckbox();
        formsPage.clickReadingHobbyCheckbox();
        formsPage.unClickReadingHobbyCheckbox();

        boolean isReadingButtonSelected = formsPage.isReadingSelected();
        Assert.assertFalse(isReadingButtonSelected, "\n Reading checkbox not selected \n");
    }
}
