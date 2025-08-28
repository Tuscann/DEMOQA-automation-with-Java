package demoqa.web.tests.widgets;

import demoqa.pages.widgets.MenuPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MenuPageTests extends BaseTest {
    // Text Constants
    private static final String EXPECTED_PAGE_HEADER_TEXT = "Menu";
    private static final String EXPECTED_MAIN_ITEM_1 = "Main Item 1";
    private static final String EXPECTED_MAIN_ITEM_2 = "Main Item 2";
    private static final String EXPECTED_MAIN_ITEM_3 = "Main Item 3";
    private static final String EXPECTED_MAIN_ITEM_2_SUB_ITEM_1 = "Sub Item";
    private static final String EXPECTED_MAIN_ITEM_2_SUB_ITEM_2 = "Sub Item";
    private static final String EXPECTED_MAIN_ITEM_2_SUB_SUB_LIST = "SUB SUB LIST »";
    private static final String EXPECTED_MAIN_ITEM_2_SUB_SUB_LIST_SUB_ITEM_1 = "Sub Sub Item 1";
    private static final String EXPECTED_MAIN_ITEM_2_SUB_SUB_LIST_SUB_ITEM_2 = "Sub Sub Item 2";

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

    // Data Provider for Menu Item Hover Color Testing
    @DataProvider(name = "menuItemHoverColorData")
    public Object[][] menuItemHoverColorDataProvider() {
        return new Object[][]{
                {"Main Item 1", "Main Item 1 hover color verification"},
                {"Main Item 2", "Main Item 2 hover color verification"},
                {"Main Item 3", "Main Item 3 hover color verification"}
        };
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void checkAllTextOnPage() {
        // Arrange
        menuPage.selectMainItem2();
        menuPage.selectMainItem2SubSubList();

        // Act & Assert
        softAssert.assertEquals(menuPage.getHeaderText(), EXPECTED_PAGE_HEADER_TEXT, PAGE_HEADER_ERROR);
        softAssert.assertEquals(menuPage.getMainItem1(), EXPECTED_MAIN_ITEM_1, MAIN_ITEM_1_ERROR);
        softAssert.assertEquals(menuPage.getMainItem2(), EXPECTED_MAIN_ITEM_2, MAIN_ITEM_2_ERROR);
        softAssert.assertEquals(menuPage.getMainItem3(), EXPECTED_MAIN_ITEM_3, MAIN_ITEM_3_ERROR);
        softAssert.assertEquals(menuPage.getMainItem2SubItem1(), EXPECTED_MAIN_ITEM_2_SUB_ITEM_1, MAIN_ITEM_2_SUB_ITEM_1_ERROR);
        softAssert.assertEquals(menuPage.getMainItem2SubItem2(), EXPECTED_MAIN_ITEM_2_SUB_ITEM_2, MAIN_ITEM_2_SUB_ITEM_2_ERROR);
        softAssert.assertEquals(menuPage.getMainItem2SubSubList(), EXPECTED_MAIN_ITEM_2_SUB_SUB_LIST, MAIN_ITEM_2_SUB_SUB_LIST_ERROR);
        softAssert.assertEquals(menuPage.getMainItem2SubSubListSubItem1(), EXPECTED_MAIN_ITEM_2_SUB_SUB_LIST_SUB_ITEM_1, MAIN_ITEM_2_SUB_SUB_LIST_SUB_ITEM_1_ERROR);
        softAssert.assertEquals(menuPage.getMainItem2SubSubListSubItem2(), EXPECTED_MAIN_ITEM_2_SUB_SUB_LIST_SUB_ITEM_2, MAIN_ITEM_2_SUB_SUB_LIST_SUB_ITEM_2_ERROR);

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
}
