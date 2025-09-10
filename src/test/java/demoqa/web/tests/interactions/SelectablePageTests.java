package demoqa.web.tests.interactions;

import demoqa.pages.interactions.SelectablePage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectablePageTests extends BaseTest {
    public static final String SELECTABLE_URL = "selectable";
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
    private static final String FOURTH_ROW_NOT_SELECTED_ERROR = "Fourth row should be selected after click";

    // Color Constants
    private static final String EXPECTED_WHITE_COLOR = "rgba(255, 255, 255, 1)";
    private static final String EXPECTED_BLUE_COLOR = "rgba(0, 123, 255, 1)";
    private static final String EXPECTED_GREY_COLOR = "rgba(248, 249, 250, 1)";
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
        String actualListTabText = selectablePage.getListTabText();
        String actualListFirstText = selectablePage.getListFirstText();
        String actualListSecondText = selectablePage.getListSecondText();
        String actualListThirdText = selectablePage.getListThirdText();
        String actualListFourText = selectablePage.getListFourText();
        selectablePage.clickGridTab();
        String actualGridTabText = selectablePage.getGridText();
        String actualGridOneText = selectablePage.getGridOneText();
        String actualGridTwoText = selectablePage.getGridTwoText();
        String actualGridThreeText = selectablePage.getGridThreeText();
        String actualGridFourText = selectablePage.getGridFourText();
        String actualGridFiveText = selectablePage.getGridFive();
        String actualGridSixText = selectablePage.getGridSix();
        String actualGridSevenText = selectablePage.getGridSeven();
        String actualGridEightText = selectablePage.getGridEight();
        String actualGridNineText = selectablePage.getGridNine();

        softAssert.assertEquals(actualPageTitle, PAGE_TITLE, PAGE_TITLE_ERROR);
        softAssert.assertEquals(actualListTabText, LIST_TAB, LIST_TAB_ERROR);
        softAssert.assertEquals(actualListFirstText, LIST_FIRST_TEXT, LIST_FIRST_TEXT_ERROR);
        softAssert.assertEquals(actualListSecondText, LIST_SECOND_TEXT, LIST_SECOND_TEXT_ERROR);
        softAssert.assertEquals(actualListThirdText, LIST_THIRD_TEXT, LIST_THIRD_TEXT_ERROR);
        softAssert.assertEquals(actualListFourText, LIST_FOUR_TEXT, LIST_FOUR_TEXT_ERROR);
        softAssert.assertEquals(actualGridTabText, GRID_TAB, GRID_TAB_ERROR);
        softAssert.assertEquals(actualGridOneText, GRID_ONE, GRID_ONE_ERROR);
        softAssert.assertEquals(actualGridTwoText, GRID_TWO, GRID_TWO_ERROR);
        softAssert.assertEquals(actualGridThreeText, GRID_THREE, GRID_THREE_ERROR);
        softAssert.assertEquals(actualGridFourText, GRID_FOUR, GRID_FOUR_ERROR);
        softAssert.assertEquals(actualGridFiveText, GRID_FIVE, GRID_FIVE_ERROR);
        softAssert.assertEquals(actualGridSixText, GRID_SIX, GRID_SIX_ERROR);
        softAssert.assertEquals(actualGridSevenText, GRID_SEVEN, GRID_SEVEN_ERROR);
        softAssert.assertEquals(actualGridEightText, GRID_EIGHT, GRID_EIGHT_ERROR);
        softAssert.assertEquals(actualGridNineText, GRID_NINE, GRID_NINE_ERROR);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select one by one all from list")
    public void selectOneByOneAllFromList() {
        // Arrange & Act
        String searchedRowText;
        for (int position = 0; position < 4; position++) {
            searchedRowText = switch (position) {
                case 0 -> LIST_FIRST_TEXT;
                case 1 -> LIST_SECOND_TEXT;
                case 2 -> LIST_THIRD_TEXT;
                case 3 -> LIST_FOUR_TEXT;
                default -> ERROR_TEXT;
            };

            String firstRowBackgroundColorBefore = selectablePage.getRowBackgroundColor(searchedRowText);
            softAssert.assertEquals(firstRowBackgroundColorBefore, EXPECTED_WHITE_COLOR, FIRST_ROW_SELECTED_ERROR);
            selectablePage.selectRowOnPosition(position);
            String firstRowBackgroundColorAfter = selectablePage.getRowBackgroundColor(searchedRowText);
            softAssert.assertEquals(firstRowBackgroundColorAfter, EXPECTED_BLUE_COLOR, FIRST_ROW_NOT_SELECTED_ERROR);
        }

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select one by one all from list and deselect all")
    public void selectOneByOneAllFromListAndDeselect() {
        // Arrange & Act
        String searchedRowText;
        for (int position = 0; position < 4; position++) {
            selectablePage.selectRowOnPosition(position);
        }

        for (int position = 0; position < 4; position++) {
            searchedRowText = switch (position) {
                case 0 -> LIST_FIRST_TEXT;
                case 1 -> LIST_SECOND_TEXT;
                case 2 -> LIST_THIRD_TEXT;
                case 3 -> LIST_FOUR_TEXT;
                default -> ERROR_TEXT;
            };

            String firstRowBackgroundColorBefore = selectablePage.getRowBackgroundColor(searchedRowText);
            softAssert.assertEquals(firstRowBackgroundColorBefore, EXPECTED_BLUE_COLOR, FIRST_ROW_SELECTED_ERROR);
            selectablePage.selectRowOnPosition(position);
            String firstRowBackgroundColorAfter = selectablePage.getRowBackgroundColor(searchedRowText);
            softAssert.assertEquals(firstRowBackgroundColorAfter, EXPECTED_GREY_COLOR, FIRST_ROW_NOT_SELECTED_ERROR);
        }


        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select one by one all from grid")
    public void selectOneByOneAllFromGrid() {
        // Arrange
        selectablePage.clickGridTab();

        String searchedGridPostion;
        for (int i = 0; i < 9; i++) {
            searchedGridPostion = switch (i) {
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
            String rowBackgroundColorBefore = selectablePage.getGridBackgroundColor(searchedGridPostion);
            selectablePage.selectPositionFromGrid(searchedGridPostion);
            String rowBackgroundColorAfter = selectablePage.getGridBackgroundColor(searchedGridPostion);

            softAssert.assertEquals(rowBackgroundColorBefore, EXPECTED_WHITE_COLOR, FOURTH_ROW_NOT_SELECTED_ERROR);
            softAssert.assertEquals(rowBackgroundColorAfter, EXPECTED_BLUE_COLOR, FOURTH_ROW_NOT_SELECTED_ERROR);
        }
        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select one by one all from grid and deselect all")
    public void selectOneByOneAllFromGridAndDeselect() {
        // Arrange
        selectablePage.clickGridTab();

        String searchedGridPostion;
        for (int i = 0; i < 9; i++) {
            searchedGridPostion = switch (i) {
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
            selectablePage.selectPositionFromGrid(searchedGridPostion);
        }

        for (int i = 0; i < 9; i++) {
            searchedGridPostion = switch (i) {
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
            String rowBackgroundColorBefore = selectablePage.getGridBackgroundColor(searchedGridPostion);
            selectablePage.selectPositionFromGridDeselected(searchedGridPostion);
            String rowBackgroundColorAfter = selectablePage.getGridBackgroundColor(searchedGridPostion);

            softAssert.assertEquals(rowBackgroundColorBefore, EXPECTED_BLUE_COLOR, FOURTH_ROW_NOT_SELECTED_ERROR);
            softAssert.assertEquals(rowBackgroundColorAfter, EXPECTED_GREY_COLOR, FOURTH_ROW_NOT_SELECTED_ERROR);
        }

        // Assert
        softAssert.assertAll();
    }
}
