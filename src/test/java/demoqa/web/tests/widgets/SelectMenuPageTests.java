package demoqa.web.tests.widgets;

import demoqa.pages.widgets.SelectMenuPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectMenuPageTests extends BaseTest {

    public static final String SELECT_MENU_URL = "select-menu";
    // Text Constants
    private static final String EXPECTED_SELECT_MENU_TEXT = "Select Menu";
    private static final String EXPECTED_SELECTED_VALUE_LABEL = "Select Value";
    private static final String EXPECTED_SELECTED_VALUE_PLACEHOLDER = "Select Option";
    private static final String EXPECTED_SELECT_TITLE_LABEL = "Select One";
    private static final String EXPECTED_SELECT_TITLE_PLACEHOLDER = "Select Title";
    private static final String EXPECTED_OLD_STYLE_SELECT_MENU_LABEL = "Old Style Select Menu";
    private static final String EXPECTED_OLD_STYLE_SELECT_MENU_PLACEHOLDER = "Red";
    private static final String EXPECTED_MULTISELECT_DROPDOWN_LABEL = "Multiselect drop down";
    private static final String EXPECTED_MULTISELECT_DROPDOWN_PLACEHOLDER = "Select...";
    private static final String EXPECTED_STANDARD_MULTI_SELECT_LABEL = "Standard multi select";
    private static final String EXPECTED_STANDARD_MULTI_SELECT = """
            Volvo
            Saab
            Opel
            Audi""";
    // Error Message Constants
    private static final String WRONG_SELECT_MENU_TEXT = "Wrong selected menu text";
    private static final String WRONG_SELECTED_VALUE_LABEL = "Wrong selected value label";
    private static final String WRONG_SELECTED_VALUE_PLACEHOLDER = "Wrong selected value placeholder";
    private static final String WRONG_SELECT_TITLE_LABEL = "Wrong selected title label";
    private static final String WRONG_SELECT_TITLE_PLACEHOLDER = "Wrong selected title placeholder";
    private static final String WRONG_OLD_STYLE_SELECT_MENU_LABEL = "Wrong selected menu label";
    private static final String WRONG_OLD_STYLE_SELECT_MENU_PLACEHOLDER = "Wrong selected menu placeholder";
    private static final String WRONG_MULTISELECT_DROPDOWN_LABEL = "Wrong selected menu label";
    private static final String WRONG_MULTISELECT_DROPDOWN_PLACEHOLDER = "Wrong selected menu placeholder";
    private static final String WRONG_STANDARD_MULTI_SELECT_LABEL = "Wrong selected menu label";
    private static final String WRONG_STANDARD_MULTI_SELECT = "Wrong selected menu placeholder";
    private SelectMenuPage selectMenuPage;

    @BeforeMethod
    public void goToSelectMenuPage() {
        navigateToUrl(SELECT_MENU_URL);
        selectMenuPage = new SelectMenuPage(driver);
    }

    @Test(enabled = true, description = "Verify main page header and labels")
    public void verifyAllElementsOnPage() {
        // Arrange & Act
        String actualSelectMenuText = selectMenuPage.getSelectMenuText();
        String actualSelectedValueLabel = selectMenuPage.getSelectedValueLabelText();
        String actualSelectTitleLabel = selectMenuPage.getSelectTitleLabel();
        String actualOldStyleSelectMenuLabel = selectMenuPage.getOldStyleSelectMenuLabel();
        String actualMultiselectDropdownLabel = selectMenuPage.getMultiselectDropdownLabel();
        String actualStandardMultiSelectLabel = selectMenuPage.getStandardMultiSelectLabel();
        String actualSelectedValuePlaceholder = selectMenuPage.getSelectedValuePlaceholder();
        String actualSelectOnePlaceholder = selectMenuPage.getSelectTitlePlaceholder();
        String actualOldStyleSelectMenuPlaceholder = selectMenuPage.getOldStyleSelectMenuPlaceholder();
        String actualMultiselectDropdownPlaceholder = selectMenuPage.getMultiselectDropdownPlaceholder();

        // Assert
        softAssert.assertEquals(actualSelectMenuText, EXPECTED_SELECT_MENU_TEXT, WRONG_SELECT_MENU_TEXT);
        softAssert.assertEquals(actualSelectedValueLabel, EXPECTED_SELECTED_VALUE_LABEL, WRONG_SELECTED_VALUE_LABEL);
        softAssert.assertEquals(actualSelectTitleLabel, EXPECTED_SELECT_TITLE_LABEL, WRONG_SELECT_TITLE_LABEL);
        softAssert.assertEquals(actualOldStyleSelectMenuLabel, EXPECTED_OLD_STYLE_SELECT_MENU_LABEL, WRONG_OLD_STYLE_SELECT_MENU_LABEL);
        softAssert.assertEquals(actualMultiselectDropdownLabel, EXPECTED_MULTISELECT_DROPDOWN_LABEL, WRONG_MULTISELECT_DROPDOWN_LABEL);
        softAssert.assertEquals(actualStandardMultiSelectLabel, EXPECTED_STANDARD_MULTI_SELECT_LABEL, WRONG_STANDARD_MULTI_SELECT_LABEL);
        softAssert.assertEquals(actualSelectedValuePlaceholder, EXPECTED_SELECTED_VALUE_PLACEHOLDER, WRONG_SELECTED_VALUE_PLACEHOLDER);
        softAssert.assertEquals(actualSelectOnePlaceholder, EXPECTED_SELECT_TITLE_PLACEHOLDER, WRONG_SELECT_TITLE_PLACEHOLDER);
        softAssert.assertEquals(actualOldStyleSelectMenuPlaceholder, EXPECTED_OLD_STYLE_SELECT_MENU_PLACEHOLDER, WRONG_OLD_STYLE_SELECT_MENU_PLACEHOLDER);
        softAssert.assertEquals(actualMultiselectDropdownPlaceholder, EXPECTED_MULTISELECT_DROPDOWN_PLACEHOLDER, WRONG_MULTISELECT_DROPDOWN_PLACEHOLDER);
        softAssert.assertEquals(selectMenuPage.getStandardMultiSelect(), EXPECTED_STANDARD_MULTI_SELECT, WRONG_STANDARD_MULTI_SELECT);
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
                default -> "Other";
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

    @Test(enabled = true, description = "Select all values from multi select dropdown menu")
    public void selectAllValuesFromMultiSelectDropdown() {
        // Arrange
        String[] expectedColors = {"Green", "Blue", "Black", "Red"};

        for (String expectedColor : expectedColors) {
            selectMenuPage.multiSelectOne(expectedColor);
        }

        String expectedValue = "Green\nBlue\nBlack\nRed";
        softAssert.assertEquals(selectMenuPage.getMultiSelectDropdownValue(), expectedValue, "Wrong selected colors");
        softAssert.assertAll();
    }

    @Test(enabled = false, description = "Select all values from multi select dropdown menu and close all same time")
    public void closeAllSelectValuesFromMultiSelectDropdown() {
        // Arrange
        String[] expectedColors = {"Green", "Blue", "Black", "Red"};

        for (String expectedColor : expectedColors) {
            selectMenuPage.multiSelectOne(expectedColor);
        }
        selectMenuPage.closeAllMultiSelectDropdown();
        softAssert.assertEquals(selectMenuPage.getMultiSelectDropdownValue(), EXPECTED_MULTISELECT_DROPDOWN_PLACEHOLDER, "Empty values");
        softAssert.assertAll();
    }

    @Test(enabled = false, description = "Select all values from multi select dropdown menu and close all one by one")
    public void closeOneByOneAllSelectValuesFromMultiSelectDropdown() {
        // Arrange
        String[] expectedColors = {"Green", "Blue", "Black", "Red"};

        for (String expectedColor : expectedColors) {
            selectMenuPage.multiSelectOne(expectedColor);
        }

        for (int i = 0; i < 4; i++) {
            selectMenuPage.closeMultiSelectOne();
        }

        softAssert.assertEquals(selectMenuPage.getMultiSelectDropdownValue(), EXPECTED_MULTISELECT_DROPDOWN_PLACEHOLDER, "Expected Select..");
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