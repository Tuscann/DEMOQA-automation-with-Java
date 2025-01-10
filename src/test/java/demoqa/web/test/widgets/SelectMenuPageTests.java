package demoqa.web.test.widgets;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectMenuPageTests extends BaseTest {

    @Test(enabled = true)
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
        Assert.assertEquals(actualMultiselectDropdownLabel, expectedMultiselectDropdownLabel, "\nWrong selected menu label");
        Assert.assertEquals(actualMultiselectDropdownPlaceholder, expectedMultiselectDropdownPlaceholder, "Wrong selected menu placeholder");
        Assert.assertEquals(actualStandardMultiSelectLabel, expectedStandardMultiSelectLabel, "\nWrong selected menu label");
        Assert.assertEquals(actualStandardMultiSelect, expectedStandardMultiSelect, "\nWrong selected menu placeholder");
    }

    @Test(enabled = true)
    public void SelectAllValuesFromSelectValue() {
        navigateToUrl("select-menu");
        for (int i = 0; i < 6; i++) {
            String expectedSelectedValue = "";
            if (i == 0) {
                expectedSelectedValue = "Group 1, option 1";
            } else if (i == 1) {
                expectedSelectedValue = "Group 1, option 2";
            } else if (i == 2) {
                expectedSelectedValue = "Group 2, option 1";
            } else if (i == 3) {
                expectedSelectedValue = "Group 2, option 2";
            } else if (i == 4) {
                expectedSelectedValue = "A root option";
            } else {
                expectedSelectedValue = "Another root option";
            }

            selectMenuPage.selectSelectValue(expectedSelectedValue);

            String actualSelectValue = selectMenuPage.getSelectedValue();

            Assert.assertEquals(actualSelectValue, expectedSelectedValue, "\nWrong select value +\n" + expectedSelectedValue);
        }
    }

    @Test(enabled = true)
    public void SelectAllValuesFromSelectOne() {
        navigateToUrl("select-menu");

        for (int i = 0; i < 6; i++) {
            String expectedSelectOne = "";
            if (i == 0) {
                expectedSelectOne = "Dr.";
            } else if (i == 1) {
                expectedSelectOne = "Mr.";
            } else if (i == 2) {
                expectedSelectOne = "Mrs.";
            } else if (i == 3) {
                expectedSelectOne = "Ms.";
            } else if (i == 4) {
                expectedSelectOne = "Prof.";
            } else {
                expectedSelectOne = "Other";
            }

            selectMenuPage.selectSelectOne(expectedSelectOne);

            String actualSelectOne = selectMenuPage.getSelectedSelectOne();

            Assert.assertEquals(actualSelectOne, expectedSelectOne, "\nWrong selected " + expectedSelectOne + "\n");
        }
    }

    @Test(enabled = true)
    public void SelectOldStyleSelectMenu() {
        navigateToUrl("select-menu");

        for (int i = 0; i < 11; i++) {
            String expectedColor = "";
            if (i == 0) {
                expectedColor = "Red";
            } else if (i == 1) {
                expectedColor = "Blue";
            } else if (i == 2) {
                expectedColor = "Green";
            } else if (i == 3) {
                expectedColor = "Yellow";
            } else if (i == 4) {
                expectedColor = "Purple";
            } else if (i == 5) {
                expectedColor = "Black";
            } else if (i == 6) {
                expectedColor = "White";
            } else if (i == 7) {
                expectedColor = "Voilet";
            } else if (i == 8) {
                expectedColor = "Indigo";
            } else if (i == 9) {
                expectedColor = "Magenta";
            } else {
                expectedColor = "Aqua";
            }

            selectMenuPage.selectOldStyleSelectMenuByText(expectedColor);
            String actualColor = selectMenuPage.getOldStyleSelectMenuSelectedValue();

            Assert.assertEquals(actualColor, expectedColor, "\nWrong color selected" + expectedColor + "\n");
        }
    }

    @Test(enabled = false)
    public void SelectMultiSelectDropDown() {
        navigateToUrl("select-menu");

        for (int i = 0; i < 4; i++) {
            String expectedColor = "";
            if (i == 0) {
                expectedColor = "Green";
            } else if (i == 1) {
                expectedColor = "Blue";
            } else if (i == 2) {
                expectedColor = "Black";
            } else {
                expectedColor = "Red";
            }

            selectMenuPage.multiSelectOne(expectedColor);

            String actualSelectValue = selectMenuPage.getSelectedValue();

            Assert.assertEquals(actualSelectValue, expectedColor, "Wrong group");
        }
    }

    @Test(enabled = true)
    public void SelectAllValuesFromStandardMultiSelect() {
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
        Assert.assertFalse(actualSelectedOptions.contains("Saab"), "\n Saab Is Selected As An Option \n");
    }
}
