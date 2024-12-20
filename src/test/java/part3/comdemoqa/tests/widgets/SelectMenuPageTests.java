package part3.comdemoqa.tests.widgets;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

import java.util.List;

public class SelectMenuPageTests extends BaseTest {

    @Test()
    public void SelectSelectValue() {
        navigateToUrl("select-menu");
        String expectedSelectedValue = "Group 2, option 2";

        selectMenuPage.selectSelectValue(expectedSelectedValue);

        String actualSelectValue = selectMenuPage.getSelectedValue();

        Assert.assertEquals(actualSelectValue, expectedSelectedValue, "Wrong group");
    }

    @Test
    public void SelectSelectOne() {
        navigateToUrl("select-menu");
        String expectedSelectedOne = "Prof.";

        selectMenuPage.selectSelectOne(expectedSelectedOne);

        String actualSelectOne = selectMenuPage.getSelectedSelectOne();

        Assert.assertEquals(actualSelectOne, expectedSelectedOne, "Wrong selected one");
    }

    @Test(enabled = false)
    public void SelectOldStyleSelectMenu2() {
        navigateToUrl("select-menu");
        String expectedColor = "Blue";

        selectMenuPage.selectOldStyleSelectMenuByText(expectedColor);

        String actualColor = selectMenuPage.getOldStyleSelectMenuSelectedValue();

        Assert.assertEquals(actualColor, expectedColor, "Wrong color selected");
    }

    @Test(enabled = false)
    public void SelectMultiSelectDropDown() {
        navigateToUrl("select-menu");
        String expectedSelectedValue = "Blue";

        selectMenuPage.MultiSelectOne(expectedSelectedValue);

        String actualSelectValue = selectMenuPage.getSelectedValue();

        Assert.assertEquals(actualSelectValue, expectedSelectedValue, "Wrong group");
    }

    @Test
    public void SelectStandardMultiSelect() {
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
    public void VerifyAllTextOnPage() {
        navigateToUrl("select-menu");

        String expectedSelectMenuText = "Select Menu";
        String expectedSelectedValueLabel = "Select Value";
        String expectedSelectedValuePlaceholder = "Select Option";
        String expectedSelectTitleLabel = "Select One";
        String expectedSelectTitlePlaceholder = "Select Title";
        String expectedOldStyleSelectMenuLabel = "Old Style Select Menu";
        String expectedOldStyleSelectMenuPlaceholder = "Red";
        String expectedMultiselectDropdownLabel = "Multiselect drop down";
        String expectedMultiselectDropdownPlaceholder = "Select...";
        String expectedStandardMultiSelectLabel = "Standard multi select";
        String expectedStandardMultiSelect = """
                Volvo
                Saab
                Opel
                Audi""";

        String actualSelectMenuText = selectMenuPage.getSelectMenuText();
        String actualSelectedValueLabel = selectMenuPage.getSelectedValueLabelText();
        String actualSelectedValuePlaceholder = selectMenuPage.getSelectedValuePlaceholder();
        String actualSelectTitleLabel = selectMenuPage.getSelectTitleLabel();
        String actualSelectTitlePlaceholder = selectMenuPage.getSelectTitlePlaceholder();
        String actualOldStyleSelectMenuLabel = selectMenuPage.getOldStyleSelectMenuLabel();
        String actualOldStyleSelectMenuPlaceholder = selectMenuPage.getOldStyleSelectMenuPlaceholder();
        String actualMultiselectDropdownLabel = selectMenuPage.getMultiselectDropdownLabel();
        String actualMultiselectDropdownPlaceholder = selectMenuPage.getMultiselectDropdownPlaceholder();
        String actualStandardMultiSelectLabel = selectMenuPage.getStandardMultiSelectLabel();
        String actualStandardMultiSelect = selectMenuPage.getStandardMultiSelect();

        Assert.assertEquals(actualSelectMenuText, expectedSelectMenuText, "Wrong selected menu text");
        Assert.assertEquals(actualSelectedValueLabel, expectedSelectedValueLabel, "Wrong selected value label");
        Assert.assertEquals(actualSelectedValuePlaceholder, expectedSelectedValuePlaceholder, "Wrong selected value placeholder");
        Assert.assertEquals(actualSelectTitleLabel, expectedSelectTitleLabel, "Wrong selected title label");
        Assert.assertEquals(actualSelectTitlePlaceholder, expectedSelectTitlePlaceholder, "Wrong selected title placeholder");
        Assert.assertEquals(actualOldStyleSelectMenuLabel, expectedOldStyleSelectMenuLabel, "Wrong selected menu label");
        Assert.assertEquals(actualOldStyleSelectMenuPlaceholder, expectedOldStyleSelectMenuPlaceholder, "Wrong selected menu placeholder");
        Assert.assertEquals(actualMultiselectDropdownLabel, expectedMultiselectDropdownLabel, "Wrong selected menu label");
        Assert.assertEquals(actualMultiselectDropdownPlaceholder, expectedMultiselectDropdownPlaceholder, "Wrong selected menu placeholder");
        Assert.assertEquals(actualStandardMultiSelectLabel, expectedStandardMultiSelectLabel, "Wrong selected menu label");
        Assert.assertEquals(actualStandardMultiSelect, expectedStandardMultiSelect, "Wrong selected menu placeholder");
    }
}
