package part3_4.comdemoqa.tests.part3.javascript.forms;

import com.pages.demo.pages.forms.PracticeFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class RadioButtonTest extends BaseTest {

    @Test
    public void SelectFemaleRadioButton() {
        PracticeFormPage formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickFemaleRadioButton();

        boolean isFemaleRadioButtonSelected = formsPage.isFemaleRadioButtonSelected();
        Assert.assertTrue(isFemaleRadioButtonSelected, "\n Female radio button is not selected \n");
    }

    @Test
    public void SelectMaleRadioButton() {
        PracticeFormPage formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickMaleRadioButton();

        boolean isMaleRadioButtonSelected = formsPage.isМaleRadioButtonSelected();
        Assert.assertTrue(isMaleRadioButtonSelected, "\n Male radio button is not selected \n");
    }

    @Test
    public void SelectOtherRadioButton() {
        PracticeFormPage formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickOtherRadioButton();

        boolean isOtherRadioButtonSelected = formsPage.isOtherRadioButtonSelected();
        Assert.assertTrue(isOtherRadioButtonSelected, "\n Other radio button is not selected \n");
    }
}