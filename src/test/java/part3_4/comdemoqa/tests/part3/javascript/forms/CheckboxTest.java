package part3_4.comdemoqa.tests.part3.javascript.forms;

import com.pages.demo.pages.forms.PracticeFormPage;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class CheckboxTest extends BaseTest {

    @Test
    public void SelectCheckBoxes() {
        PracticeFormPage formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickSportHobbyCheckbox();
        formsPage.clickMusicHobbyCheckbox();
        formsPage.clickReadingHobbyCheckbox();
        formsPage.unClickReadingHobbyCheckbox();

        //TODO
        // boolean isReadingButtonSelected = formsPage.isReadingSelected();
        //  Assert.assertFalse(isReadingButtonSelected, "\n Reading checkbox not selected \n");
    }
}
