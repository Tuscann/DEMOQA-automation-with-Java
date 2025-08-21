package demoqa.web.tests.widgets;

import demoqa.pages.widgets.MenuPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MenuPageTests extends BaseTest {
    // Text Constants
    private static final String EXPECTED_PAGE_HEADER = "Menu";
    private static final String EXPECTED_MAIN_ITEM_1 = "Main Item 1";
    private static final String EXPECTED_MAIN_ITEM_2 = "Main Item 2";
    private static final String EXPECTED_MAIN_ITEM_2_SUB_ITEM_1 = "Sub Item";
    private static final String EXPECTED_MAIN_ITEM_2_SUB_ITEM_2 = "Sub Item";
    private static final String EXPECTED_MAIN_ITEM_2_SUB_SUB_LIST = "SUB SUB LIST »";
    private static final String EXPECTED_MAIN_ITEM_2_SUB_SUB_LIST_SUB_ITEM_1 = "Sub Sub Item 1";
    private static final String EXPECTED_MAIN_ITEM_2_SUB_SUB_LIST_SUB_ITEM_2 = "Sub Sub Item 2";
    private static final String EXPECTED_MAIN_ITEM_3 = "Main Item 3";

    // Color Constants
    private static final String EXPECTED_COLOR_BEFORE_SELECTION = "rgba(36, 175, 21, 1)";
    private static final String EXPECTED_COLOR_AFTER_SELECTION = "rgba(0, 63, 32, 1)";

    // Error Message Constants
    private static final String PAGE_HEADER_ERROR = "Page header not correct";
    private static final String MAIN_ITEM_1_ERROR = "Main Item 1 not correct";
    private static final String MAIN_ITEM_2_ERROR = "Main Item 2 not correct";
    private static final String MAIN_ITEM_2_SUB_ITEM_1_ERROR = "Main Item 2 sub item 1 not correct";
    private static final String MAIN_ITEM_2_SUB_ITEM_2_ERROR = "Main Item 2 sub item 2 not correct";
    private static final String MAIN_ITEM_2_SUB_SUB_LIST_ERROR = "Main Item 2 SubList not correct";
    private static final String MAIN_ITEM_2_SUB_SUB_LIST_SUB_ITEM_1_ERROR = "SubSubListSubItem1 not correct";
    private static final String MAIN_ITEM_2_SUB_SUB_LIST_SUB_ITEM_2_ERROR = "SubSubListSubItem2 not correct";
    private static final String MAIN_ITEM_3_ERROR = "Main Item 3 not correct";
    private static final String COLOR_BEFORE_SELECTION_ERROR = "Not normal green color";
    private static final String COLOR_AFTER_SELECTION_ERROR = "Not dark green color";

    private MenuPage menuPage;
    private static final String MENU_URL = "menu#";

    @BeforeMethod
    public void goToMenuPage() {
        navigateToUrl(MENU_URL);
        menuPage = new MenuPage(driver);
    }

    // Data Provider for Menu Item Text Testing
    @DataProvider(name = "menuItemTextData")
    public Object[][] menuItemTextDataProvider() {
        return new Object[][]{
                {"Main Item 1", EXPECTED_MAIN_ITEM_1, "Main Item 1 text verification"},
                {"Main Item 2", EXPECTED_MAIN_ITEM_2, "Main Item 2 text verification"},
                {"Main Item 3", EXPECTED_MAIN_ITEM_3, "Main Item 3 text verification"}
        };
    }

    // Data Provider for Sub Item Text Testing
    @DataProvider(name = "subItemTextData")
    public Object[][] subItemTextDataProvider() {
        return new Object[][]{
                {"Sub Item 1", EXPECTED_MAIN_ITEM_2_SUB_ITEM_1, "Sub Item 1 text verification"},
                {"Sub Item 2", EXPECTED_MAIN_ITEM_2_SUB_ITEM_2, "Sub Item 2 text verification"},
                {"Sub Sub List", EXPECTED_MAIN_ITEM_2_SUB_SUB_LIST, "Sub Sub List text verification"},
                {"Sub Sub Item 1", EXPECTED_MAIN_ITEM_2_SUB_SUB_LIST_SUB_ITEM_1, "Sub Sub Item 1 text verification"},
                {"Sub Sub Item 2", EXPECTED_MAIN_ITEM_2_SUB_SUB_LIST_SUB_ITEM_2, "Sub Sub Item 2 text verification"}
        };
    }

    // Data Provider for Menu Item Hover Color Testing
    @DataProvider(name = "menuItemHoverColorData")
    public Object[][] menuItemHoverColorDataProvider() {
        return new Object[][]{
                {"Main Item 1", "Main Item 1 hover color verification"},
                {"Main Item 2", "Main Item 2 hover color verification"},
                {"Main Item 3", "Main Item 3 hover color verification"}
        };
    }

    // Data Provider for Sub Item Hover Color Testing
    @DataProvider(name = "subItemHoverColorData")
    public Object[][] subItemHoverColorDataProvider() {
        return new Object[][]{
                {"Sub Item 1", "Sub Item 1 hover color verification"},
                {"Sub Item 2", "Sub Item 2 hover color verification"},
                {"Sub Sub List", "Sub Sub List hover color verification"},
                {"Sub Sub Item 1", "Sub Sub Item 1 hover color verification"},
                {"Sub Sub Item 2", "Sub Sub Item 2 hover color verification"}
        };
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void checkAllTextOnPage() {
        // Arrange
        menuPage.selectMainItem2();
        menuPage.selectMainItem2SubSubList();

        // Act
        String actualPageHeader = menuPage.getHeaderText();
        String actualMainItem1 = menuPage.getMainItem1();
        String actualMainItem2 = menuPage.getMainItem2();
        String actualMainItem2SubItem1 = menuPage.getMainItem2SubItem1();
        String actualMainItem2SubItem2 = menuPage.getMainItem2SubItem2();
        String actualMainItem2SubSubList = menuPage.getMainItem2SubSubList();
        String actualMainItem2SubSubListSubItem1 = menuPage.getMainItem2SubSubListSubItem1();
        String actualMainItem2SubSubListSubItem2 = menuPage.getMainItem2SubSubListSubItem2();
        String actualMainItem3 = menuPage.getMainItem3();

        // Assert
        softAssert.assertEquals(actualPageHeader, EXPECTED_PAGE_HEADER, PAGE_HEADER_ERROR);
        softAssert.assertEquals(actualMainItem1, EXPECTED_MAIN_ITEM_1, MAIN_ITEM_1_ERROR);
        softAssert.assertEquals(actualMainItem2, EXPECTED_MAIN_ITEM_2, MAIN_ITEM_2_ERROR);
        softAssert.assertEquals(actualMainItem2SubItem1, EXPECTED_MAIN_ITEM_2_SUB_ITEM_1, MAIN_ITEM_2_SUB_ITEM_1_ERROR);
        softAssert.assertEquals(actualMainItem2SubItem2, EXPECTED_MAIN_ITEM_2_SUB_ITEM_2, MAIN_ITEM_2_SUB_ITEM_2_ERROR);
        softAssert.assertEquals(actualMainItem2SubSubList, EXPECTED_MAIN_ITEM_2_SUB_SUB_LIST, MAIN_ITEM_2_SUB_SUB_LIST_ERROR);
        softAssert.assertEquals(actualMainItem2SubSubListSubItem1, EXPECTED_MAIN_ITEM_2_SUB_SUB_LIST_SUB_ITEM_1, MAIN_ITEM_2_SUB_SUB_LIST_SUB_ITEM_1_ERROR);
        softAssert.assertEquals(actualMainItem2SubSubListSubItem2, EXPECTED_MAIN_ITEM_2_SUB_SUB_LIST_SUB_ITEM_2, MAIN_ITEM_2_SUB_SUB_LIST_SUB_ITEM_2_ERROR);
        softAssert.assertEquals(actualMainItem3, EXPECTED_MAIN_ITEM_3, MAIN_ITEM_3_ERROR);

        softAssert.assertAll();
    }

    // New Data-Driven Test for Menu Item Text
    @Test(dataProvider = "menuItemTextData", enabled = true, description = "Test menu item text with data provider")
    public void testMenuItemTextWithDataProvider(String itemName, String expectedText, String testDescription) {
        // Act - Get the appropriate menu item text based on itemName
        String actualText = switch (itemName) {
            case "Main Item 1" -> menuPage.getMainItem1();
            case "Main Item 2" -> menuPage.getMainItem2();
            case "Main Item 3" -> menuPage.getMainItem3();
            default -> "";
        };

        // Assert
        softAssert.assertEquals(actualText, expectedText,
                String.format("Text mismatch for %s", itemName));
        softAssert.assertAll();
    }

    // New Data-Driven Test for Sub Item Text
    @Test(dataProvider = "subItemTextData", enabled = true, description = "Test sub item text with data provider")
    public void testSubItemTextWithDataProvider(String itemName, String expectedText, String testDescription) {
        // Arrange - Ensure sub items are visible
        menuPage.selectMainItem2();
        if (itemName.startsWith("Sub Sub")) {
            menuPage.selectMainItem2SubSubList();
        }

        // Act - Get the appropriate sub item text based on itemName
        String actualText = switch (itemName) {
            case "Sub Item 1" -> menuPage.getMainItem2SubItem1();
            case "Sub Item 2" -> menuPage.getMainItem2SubItem2();
            case "Sub Sub List" -> menuPage.getMainItem2SubSubList();
            case "Sub Sub Item 1" -> menuPage.getMainItem2SubSubListSubItem1();
            case "Sub Sub Item 2" -> menuPage.getMainItem2SubSubListSubItem2();
            default -> "";
        };

        // Assert
        softAssert.assertEquals(actualText, expectedText,
                String.format("Text mismatch for %s", itemName));
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Hover over every item in menu and check hover color")
    public void hoverOverEveryItemInMenuAndCheckHoverColor() {
        // Act - Main Item 1
        String actualColorSelected = menuPage.takeBackgroundColorMainItem1();
        softAssert.assertEquals(actualColorSelected, EXPECTED_COLOR_BEFORE_SELECTION, COLOR_BEFORE_SELECTION_ERROR);
        menuPage.selectMainItem1();
        actualColorSelected = menuPage.takeBackgroundColorMainItem1();
        softAssert.assertEquals(actualColorSelected, EXPECTED_COLOR_AFTER_SELECTION, COLOR_AFTER_SELECTION_ERROR);

        // Main Item 2
        actualColorSelected = menuPage.takeBackgroundColorMainItem2();
        softAssert.assertEquals(actualColorSelected, EXPECTED_COLOR_BEFORE_SELECTION, COLOR_BEFORE_SELECTION_ERROR);
        menuPage.selectMainItem2();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2();
        softAssert.assertEquals(actualColorSelected, EXPECTED_COLOR_AFTER_SELECTION, COLOR_AFTER_SELECTION_ERROR);

        // Sub Item 1
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubItem1();
        softAssert.assertEquals(actualColorSelected, EXPECTED_COLOR_BEFORE_SELECTION, COLOR_BEFORE_SELECTION_ERROR);
        menuPage.selectMainItem2SubItem1();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubItem1();
        softAssert.assertEquals(actualColorSelected, EXPECTED_COLOR_AFTER_SELECTION, COLOR_AFTER_SELECTION_ERROR);

        // Sub Item 2
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubItem2();
        softAssert.assertEquals(actualColorSelected, EXPECTED_COLOR_BEFORE_SELECTION, COLOR_BEFORE_SELECTION_ERROR);
        menuPage.selectMainItem2SubItem2();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubItem2();
        softAssert.assertEquals(actualColorSelected, EXPECTED_COLOR_AFTER_SELECTION, COLOR_AFTER_SELECTION_ERROR);

        // Sub Sub List
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIst();
        softAssert.assertEquals(actualColorSelected, EXPECTED_COLOR_BEFORE_SELECTION, COLOR_BEFORE_SELECTION_ERROR);
        menuPage.selectMainItem2SubSubList();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIst();
        softAssert.assertEquals(actualColorSelected, EXPECTED_COLOR_AFTER_SELECTION, COLOR_AFTER_SELECTION_ERROR);

        // Sub Sub Item 1
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIstSubSubItem1();
        softAssert.assertEquals(actualColorSelected, EXPECTED_COLOR_BEFORE_SELECTION, COLOR_BEFORE_SELECTION_ERROR);
        menuPage.selectMainItem2SubSubsLIstSubSubItem1();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIstSubSubItem1();
        softAssert.assertEquals(actualColorSelected, EXPECTED_COLOR_AFTER_SELECTION, COLOR_AFTER_SELECTION_ERROR);

        // Sub Sub Item 2
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIstSubSubItem2();
        softAssert.assertEquals(actualColorSelected, EXPECTED_COLOR_BEFORE_SELECTION, COLOR_BEFORE_SELECTION_ERROR);
        menuPage.selectMainItem2SubSubsLIstSubSubItem2();
        actualColorSelected = menuPage.takeBackgroundColorMainItem2SubSubsLIstSubSubItem2();
        softAssert.assertEquals(actualColorSelected, EXPECTED_COLOR_AFTER_SELECTION, COLOR_AFTER_SELECTION_ERROR);

        // Main Item 3
        actualColorSelected = menuPage.takeBackgroundColorMainItem3();
        softAssert.assertEquals(actualColorSelected, EXPECTED_COLOR_BEFORE_SELECTION, COLOR_BEFORE_SELECTION_ERROR);
        menuPage.selectMainItem3();
        actualColorSelected = menuPage.takeBackgroundColorMainItem3();
        softAssert.assertEquals(actualColorSelected, EXPECTED_COLOR_AFTER_SELECTION, COLOR_AFTER_SELECTION_ERROR);

        softAssert.assertAll();
    }

    // New Data-Driven Test for Menu Item Hover Colors
    @Test(dataProvider = "menuItemHoverColorData", enabled = true, description = "Test menu item hover colors with data provider")
    public void testMenuItemHoverColorsWithDataProvider(String itemName, String testDescription) {
        // Act - Test hover color for the specified menu item
        String actualColorBefore = "";
        String actualColorAfter = "";

        switch (itemName) {
            case "Main Item 1":
                actualColorBefore = menuPage.takeBackgroundColorMainItem1();
                menuPage.selectMainItem1();
                actualColorAfter = menuPage.takeBackgroundColorMainItem1();
                break;
            case "Main Item 2":
                actualColorBefore = menuPage.takeBackgroundColorMainItem2();
                menuPage.selectMainItem2();
                actualColorAfter = menuPage.takeBackgroundColorMainItem2();
                break;
            case "Main Item 3":
                actualColorBefore = menuPage.takeBackgroundColorMainItem3();
                menuPage.selectMainItem3();
                actualColorAfter = menuPage.takeBackgroundColorMainItem3();
                break;
        }

        // Assert
        softAssert.assertEquals(actualColorBefore, EXPECTED_COLOR_BEFORE_SELECTION,
                String.format("Before selection color mismatch for %s", itemName));
        softAssert.assertEquals(actualColorAfter, EXPECTED_COLOR_AFTER_SELECTION,
                String.format("After selection color mismatch for %s", itemName));
        softAssert.assertAll();
    }
}
