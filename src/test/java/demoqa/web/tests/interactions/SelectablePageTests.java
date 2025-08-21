package demoqa.web.tests.interactions;

import demoqa.pages.interactions.SelectablePage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectablePageTests extends BaseTest {
    // Text Constants
    private static final String PAGE_TITLE = "Selectable";
    private static final String LIST_TAB = "List";
    private static final String LIST_FIRST_TEXT = "Cras justo odio";
    private static final String LIST_SECOND_TEXT = "Dapibus ac facilisis in";
    private static final String LIST_THIRD_TEXT = "Morbi leo risus";
    private static final String LIST_FOUR_TEXT = "Porta ac consectetur ac";
    private static final String GRID_TAB = "Grid";
    private static final String GRID_ONE = "One";
    private static final String GRID_TWO = "Two";
    private static final String GRID_THREE = "Three";
    private static final String GRID_FOUR = "Four";
    private static final String GRID_FIVE = "Five";
    private static final String GRID_SIX = "Six";
    private static final String GRID_SEVEN = "Seven";
    private static final String GRID_EIGHT = "Eight";
    private static final String GRID_NINE = "Nine";
    private static final String ERROR_TEXT = "Error";

    // Error Message Constants
    private static final String PAGE_TITLE_ERROR = "Page title mismatch";
    private static final String LIST_TAB_ERROR = "List tab name mismatch";
    private static final String LIST_FIRST_TEXT_ERROR = "List first text mismatch";
    private static final String LIST_SECOND_TEXT_ERROR = "List second text mismatch";
    private static final String LIST_THIRD_TEXT_ERROR = "List third text mismatch";
    private static final String LIST_FOUR_TEXT_ERROR = "List four text mismatch";
    private static final String GRID_TAB_ERROR = "Grid tab name mismatch";
    private static final String GRID_ONE_ERROR = "Grid one text mismatch";
    private static final String GRID_TWO_ERROR = "Grid two text mismatch";
    private static final String GRID_THREE_ERROR = "Grid three text mismatch";
    private static final String GRID_FOUR_ERROR = "Grid four text mismatch";
    private static final String GRID_FIVE_ERROR = "Grid five text mismatch";
    private static final String GRID_SIX_ERROR = "Grid six text mismatch";
    private static final String GRID_SEVEN_ERROR = "Grid seven text mismatch";
    private static final String GRID_EIGHT_ERROR = "Grid eight text mismatch";
    private static final String GRID_NINE_ERROR = "Grid nine text mismatch";
    private static final String FIRST_ROW_SELECTED_ERROR = "First row should not be selected initially";
    private static final String FIRST_ROW_NOT_SELECTED_ERROR = "First row should be selected after click";
    private static final String SECOND_ROW_SELECTED_ERROR = "Second row should not be selected initially";
    private static final String SECOND_ROW_NOT_SELECTED_ERROR = "Second row should be selected after click";
    private static final String THIRD_ROW_SELECTED_ERROR = "Third row should not be selected initially";
    private static final String THIRD_ROW_NOT_SELECTED_ERROR = "Third row should be selected after click";
    private static final String FOURTH_ROW_SELECTED_ERROR = "Fourth row should not be selected initially";
    private static final String FOURTH_ROW_NOT_SELECTED_ERROR = "Fourth row should be selected after click";
    private static final String GRID_POSITION_NOT_SELECTED_ERROR = "Grid position is not selected";

    public static final String SELECTABLE_URL = "selectable";
    private SelectablePage selectablePage;

    @BeforeMethod
    public void goToSelectablePage() {
        navigateToUrl(SELECTABLE_URL);
        selectablePage = new SelectablePage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange & Act
        String actualPageTitle = selectablePage.getPageTitleText();
        String actualListTab = selectablePage.getListTabText();
        String actualListFirstText = selectablePage.getListFirstText();
        String actualListSecondText = selectablePage.getListSecondText();
        String actualListThirdText = selectablePage.getListThirdText();
        String actualListFourText = selectablePage.getListFourText();
        selectablePage.clickGridTab();
        String actualGridTab = selectablePage.getGridText();
        String actualGridOne = selectablePage.getGridOneText();
        String actualGridTwo = selectablePage.getGridTwoText();
        String actualGridThree = selectablePage.getGridThreeText();
        String actualGridFour = selectablePage.getGridFourText();
        String actualGridFive = selectablePage.getGridFive();
        String actualGridSix = selectablePage.getGridSix();
        String actualGridSeven = selectablePage.getGridSeven();
        String actualGridEight = selectablePage.getGridEight();
        String actualGridNine = selectablePage.getGridNine();

        softAssert.assertEquals(actualPageTitle, PAGE_TITLE, PAGE_TITLE_ERROR);
        softAssert.assertEquals(actualListTab, LIST_TAB, LIST_TAB_ERROR);
        softAssert.assertEquals(actualListFirstText, LIST_FIRST_TEXT, LIST_FIRST_TEXT_ERROR);
        softAssert.assertEquals(actualListSecondText, LIST_SECOND_TEXT, LIST_SECOND_TEXT_ERROR);
        softAssert.assertEquals(actualListThirdText, LIST_THIRD_TEXT, LIST_THIRD_TEXT_ERROR);
        softAssert.assertEquals(actualListFourText, LIST_FOUR_TEXT, LIST_FOUR_TEXT_ERROR);
        softAssert.assertEquals(actualGridTab, GRID_TAB, GRID_TAB_ERROR);
        softAssert.assertEquals(actualGridOne, GRID_ONE, GRID_ONE_ERROR);
        softAssert.assertEquals(actualGridTwo, GRID_TWO, GRID_TWO_ERROR);
        softAssert.assertEquals(actualGridThree, GRID_THREE, GRID_THREE_ERROR);
        softAssert.assertEquals(actualGridFour, GRID_FOUR, GRID_FOUR_ERROR);
        softAssert.assertEquals(actualGridFive, GRID_FIVE, GRID_FIVE_ERROR);
        softAssert.assertEquals(actualGridSix, GRID_SIX, GRID_SIX_ERROR);
        softAssert.assertEquals(actualGridSeven, GRID_SEVEN, GRID_SEVEN_ERROR);
        softAssert.assertEquals(actualGridEight, GRID_EIGHT, GRID_EIGHT_ERROR);
        softAssert.assertEquals(actualGridNine, GRID_NINE, GRID_NINE_ERROR);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select one by one all from list")
    public void selectOneByOneAllFromList() {
        // Arrange      
        int position = 0;

        // Act
        boolean isRowSelected = selectablePage.RowSelected(LIST_FIRST_TEXT);
        softAssert.assertFalse(isRowSelected, FIRST_ROW_SELECTED_ERROR);

        selectablePage.clickElement(position);
        isRowSelected = selectablePage.RowSelected(LIST_FIRST_TEXT);
        softAssert.assertTrue(isRowSelected, FIRST_ROW_NOT_SELECTED_ERROR);

        isRowSelected = selectablePage.RowSelected(LIST_SECOND_TEXT);
        softAssert.assertFalse(isRowSelected, SECOND_ROW_SELECTED_ERROR);
        position = 1;
        selectablePage.clickElement(position);
        isRowSelected = selectablePage.RowSelected(LIST_SECOND_TEXT);
        softAssert.assertTrue(isRowSelected, SECOND_ROW_NOT_SELECTED_ERROR);

        isRowSelected = selectablePage.RowSelected(LIST_THIRD_TEXT);
        softAssert.assertFalse(isRowSelected, THIRD_ROW_SELECTED_ERROR);
        position = 2;
        selectablePage.clickElement(position);
        isRowSelected = selectablePage.RowSelected(LIST_THIRD_TEXT);
        softAssert.assertTrue(isRowSelected, THIRD_ROW_NOT_SELECTED_ERROR);

        isRowSelected = selectablePage.RowSelected(LIST_FOUR_TEXT);
        softAssert.assertFalse(isRowSelected, FOURTH_ROW_SELECTED_ERROR);
        position = 3;
        selectablePage.clickElement(position);
        isRowSelected = selectablePage.RowSelected(LIST_FOUR_TEXT);
        softAssert.assertTrue(isRowSelected, FOURTH_ROW_NOT_SELECTED_ERROR);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select one by one all from grid")
    public void selectOneByOneAllFromGrid() {
        // Arrange
        selectablePage.clickGridTab();

        String searched1Selection;
        boolean isSelected;
        for (int i = 0; i < 9; i++) {
            searched1Selection = switch (i) {
                case 0 -> GRID_ONE;
                case 1 -> GRID_TWO;
                case 2 -> GRID_THREE;
                case 3 -> GRID_FOUR;
                case 4 -> GRID_FIVE;
                case 5 -> GRID_SIX;
                case 6 -> GRID_SEVEN;
                case 7 -> GRID_EIGHT;
                case 8 -> GRID_NINE;
                default -> ERROR_TEXT;
            };
            // Act
            selectablePage.selectPositionFromGrid(searched1Selection);
            isSelected = selectablePage.isPositionFromGridSelected(searched1Selection);
            softAssert.assertTrue(isSelected, GRID_POSITION_NOT_SELECTED_ERROR);
        }
        // Assert
        softAssert.assertAll();
    }
}
