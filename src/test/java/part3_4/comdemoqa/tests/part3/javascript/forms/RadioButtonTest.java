package part3_4.comdemoqa.tests.part3.javascript.forms;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class RadioButtonTest extends BaseTest {

    @Test
    public void SelectFemaleRadioButton() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickFemaleRadioButton();

        boolean isFemaleRadioButtonSelected = formsPage.isFemaleRadioButtonSelected();
        Assert.assertTrue(isFemaleRadioButtonSelected, "\n Female radio button is not selected \n");
    }
}