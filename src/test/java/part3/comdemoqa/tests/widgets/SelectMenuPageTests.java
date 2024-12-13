package part3.comdemoqa.tests.widgets;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

import java.util.List;

public class SelectMenuPageTests extends BaseTest {

    @Test
    public void SelectFromMultiSelectDropDown() {
        navigateToUrl("select-menu");
        selectMenuPage.selectStandardMultiByText("Volvo");
        selectMenuPage.selectStandardMultiByIndex(1);
        selectMenuPage.selectStandardMultiByText("Audi");
        selectMenuPage.selectStandardMultiByIndex(2);

        selectMenuPage.deselectStandardMulti("saab");
        List<String> actualSelectedOptions = selectMenuPage.getAllSelectedStandardMultiOptions();
        Assert.assertTrue(actualSelectedOptions.contains("Volvo"));
        Assert.assertTrue(actualSelectedOptions.contains("Opel"));
        Assert.assertTrue(actualSelectedOptions.contains("Audi"));
        Assert.assertFalse(actualSelectedOptions.contains("Saab"),
                "\n Saab Is Selected As An Option \n");
    }

    @Test
    public void SelectOldStyleSelectMenu() {
        navigateToUrl("select-menu");
        selectMenuPage.selectStandardMultiByText("Volvo");
        selectMenuPage.selectStandardMultiByIndex(1);
        selectMenuPage.selectStandardMultiByText("Audi");
        selectMenuPage.selectStandardMultiByIndex(2);

        selectMenuPage.deselectStandardMulti("saab");
        List<String> actualSelectedOptions = selectMenuPage.getAllSelectedStandardMultiOptions();
        Assert.assertTrue(actualSelectedOptions.contains("Volvo"));
        Assert.assertTrue(actualSelectedOptions.contains("Opel"));
        Assert.assertTrue(actualSelectedOptions.contains("Audi"));
        Assert.assertFalse(actualSelectedOptions.contains("Saab"),
                "\n Saab Is Selected As An Option \n");
    }

    //  @Test
    public void selectOldStyleSelectMenu2() {
        navigateToUrl("select-menu");
        selectMenuPage.selectStandardMultiByText("Volvo");
        //  selectMenuPage.selectValue("Group 2, option 2");
    }
}
