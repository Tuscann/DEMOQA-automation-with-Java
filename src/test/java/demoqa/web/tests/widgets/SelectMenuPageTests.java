package demoqa.web.tests.widgets;

import demoqa.pages.widgets.SelectMenuPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectMenuPageTests extends BaseTest {

    public static final String SELECT_MENU_URL = "select-menu";
    private SelectMenuPage selectMenuPage;

    @BeforeMethod
    public void goToSelectMenuPage() {
        navigateToUrl(SELECT_MENU_URL);
        selectMenuPage = new SelectMenuPage(driver);
    }

    @Test(enabled = true, description = "Verify all text on the page")
    public void verifyAllTextOnPage() {
        // Arrange
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

        softAssert.assertEquals(actualSelectMenuText, expectedSelectMenuText, "Wrong selected menu text");
        softAssert.assertEquals(actualSelectedValueLabel, expectedSelectedValueLabel, "Wrong selected value label");
        softAssert.assertEquals(actualSelectedValuePlaceholder, expectedSelectedValuePlaceholder, "Wrong selected value placeholder");
        softAssert.assertEquals(actualSelectTitleLabel, expectedSelectTitleLabel, "Wrong selected title label");
        softAssert.assertEquals(actualSelectTitlePlaceholder, expectedSelectTitlePlaceholder, "Wrong selected title placeholder");
        softAssert.assertEquals(actualOldStyleSelectMenuLabel, expectedOldStyleSelectMenuLabel, "Wrong selected menu label");
        softAssert.assertEquals(actualOldStyleSelectMenuPlaceholder, expectedOldStyleSelectMenuPlaceholder, "Wrong selected menu placeholder");
        softAssert.assertEquals(actualMultiselectDropdownLabel, expectedMultiselectDropdownLabel, "\nWrong selected menu label");
        softAssert.assertEquals(actualMultiselectDropdownPlaceholder, expectedMultiselectDropdownPlaceholder, "Wrong selected menu placeholder");
        softAssert.assertEquals(actualStandardMultiSelectLabel, expectedStandardMultiSelectLabel, "\nWrong selected menu label");
        softAssert.assertEquals(actualStandardMultiSelect, expectedStandardMultiSelect, "\nWrong selected menu placeholder");
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select all values from select value menu")
    public void selectAllValuesFromSelectValue() {
        // Arrange
        for (int i = 0; i < 6; i++) {
            String expectedSelectedValue = switch (i) {
                case 0 -> "Group 1, option 1";
                case 1 -> "Group 1, option 2";
                case 2 -> "Group 2, option 1";
                case 3 -> "Group 2, option 2";
                case 4 -> "A root option";
                default -> "Another root option";
            };

            selectMenuPage.selectSelectValue(expectedSelectedValue);

            String actualSelectValue = selectMenuPage.getSelectedValue();

            softAssert.assertEquals(actualSelectValue, expectedSelectedValue, "\nWrong select value +\n" + expectedSelectedValue);
        }
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select all values from select one menu")
    public void selectAllValuesFromSelectOne() {
        // Arrange
        for (int i = 0; i < 6; i++) {
            String expectedSelectOne = switch (i) {
                case 0 -> "Dr.";
                case 1 -> "Mr.";
                case 2 -> "Mrs.";
                case 3 -> "Ms.";
                case 4 -> "Prof.";
                case 5 -> "Other";
                default -> "Error";
            };

            selectMenuPage.selectSelectOne(expectedSelectOne);

            String actualSelectOne = selectMenuPage.getSelectedSelectOne();

            softAssert.assertEquals(actualSelectOne, expectedSelectOne, "\nWrong selected " + expectedSelectOne + "\n");
        }
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select all values from old style select menu")
    public void selectAllValuesFromOldStyleSelectMenu() {
        // Arrange
        for (int i = 0; i < 11; i++) {
            String expectedColor = switch (i) {
                case 0 -> "Red";
                case 1 -> "Blue";
                case 2 -> "Green";
                case 3 -> "Yellow";
                case 4 -> "Purple";
                case 5 -> "Black";
                case 6 -> "White";
                case 7 -> "Voilet";
                case 8 -> "Indigo";
                case 9 -> "Magenta";
                case 10 -> "Aqua";
                default -> "Error";
            };

            selectMenuPage.selectOldStyleSelectMenuByText(expectedColor);
            String actualColor = selectMenuPage.getOldStyleSelectMenuSelectedValue();

            softAssert.assertEquals(actualColor, expectedColor, "\nWrong color selected" + expectedColor + ".\n");
        }
        softAssert.assertAll();
    }

    @Test(enabled = false, description = "Select all values from multi select dropdown menu")
    public void selectMultiSelectDropDown() {
        // Arrange
        for (int i = 0; i < 4; i++) {
            String expectedColor = switch (i) {
                case 0 -> "Green";
                case 1 -> "Blue";
                case 2 -> "Black";
                case 3 -> "Red";
                default -> "Error";
            };
            selectMenuPage.multiSelectOne(expectedColor);
            String actualSelectValue = selectMenuPage.getSelectedValue();

            softAssert.assertEquals(actualSelectValue, expectedColor, "\nWrong group" + expectedColor + ".\n");
        }
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select all values from standard multi select menu")
    public void selectAllValuesFromStandardMultiSelect() {
        // Arrange
        selectMenuPage.selectStandardMultiByText("Volvo");
        selectMenuPage.selectStandardMultiByIndex(1);
        selectMenuPage.selectStandardMultiByText("Audi");
        selectMenuPage.selectStandardMultiByIndex(2);

        selectMenuPage.deselectStandardMulti("saab");
        List<String> actualSelectedOptions = selectMenuPage.getAllSelectedStandardMultiOptions();
        softAssert.assertTrue(actualSelectedOptions.contains("Volvo"));
        softAssert.assertTrue(actualSelectedOptions.contains("Opel"));
        softAssert.assertTrue(actualSelectedOptions.contains("Audi"));
        softAssert.assertFalse(actualSelectedOptions.contains("Saab"), "\n Saab Is Selected As An Option \n");

        softAssert.assertAll();
    }
}