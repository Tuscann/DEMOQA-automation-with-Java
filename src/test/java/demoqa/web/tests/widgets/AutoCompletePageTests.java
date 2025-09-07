package demoqa.web.tests.widgets;

import demoqa.pages.widgets.AutoCompletePage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompletePageTests extends BaseTest {
    public static final String AUTO_COMPLETE_URL = "auto-complete";
    // Text Constants
    private static final String AUTO_COMPLETE_HEADING = "Auto Complete";
    private static final String TYPE_MULTIPLE_TEXT = "Type multiple color names";
    private static final String TYPE_SINGLE_TEXT = "Type single color name";
    // Color Constants
    private static final String COLOR_RED = "Red";
    private static final String COLOR_BLUE = "Blue";
    private static final String COLOR_WHITE = "White";
    private static final String COLOR_GREEN = "Green";
    private static final String COLOR_YELLOW = "Yellow";
    private static final String COLOR_PURPLE = "Purple";
    private static final String COLOR_VIOLET = "Voilet";
    private static final String COLOR_MAGENTA = "Magenta";
    private static final String COLOR_BLACK = "Black";
    private static final String COLOR_AQUA = "Aqua";
    private static final String COLOR_INDIGO = "Indigo";
    // Error Message Constants
    private static final String PAGE_HEADING_ERROR = "Page heading mismatch";
    private static final String TYPE_MULTIPLE_TEXT_ERROR = "Type multiple color names text mismatch";
    private static final String TYPE_SINGLE_TEXT_ERROR = "Type single color name text mismatch";
    private static final String COLORS_SELECTED_ERROR = "Wrong colors selected";
    private static final String COLORS_SELECTED_FIRST_ERROR = "Wrong colors selected first";
    private static final String COLORS_SELECTED_SECOND_ERROR = "Wrong colors selected second";
    private static final String FIRST_COLOR_SELECTED_ERROR = "Wrong first color selected";
    private static final String SECOND_COLOR_SELECTED_ERROR = "Wrong second color selected";
    private static final String GREEN_COLOR_SELECTED_ERROR = "Wrong green color selected";
    private AutoCompletePage autoCompletePage;

    @BeforeMethod
    public void goToDatePickerPage() {
        navigateToUrl(AUTO_COMPLETE_URL);
        autoCompletePage = new AutoCompletePage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange & Act & Assert
        softAssert.assertEquals(autoCompletePage.getHeadingText(), AUTO_COMPLETE_HEADING, PAGE_HEADING_ERROR);
        softAssert.assertEquals(autoCompletePage.getMultipleContainerText(), TYPE_MULTIPLE_TEXT, TYPE_MULTIPLE_TEXT_ERROR);
        softAssert.assertEquals(autoCompletePage.getAutoCompleteSingleText(), TYPE_SINGLE_TEXT, TYPE_SINGLE_TEXT_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select two multiple colors")
    public void selectTwoMultipleColors() {
        // Arrange & Act
        autoCompletePage.waitForPageToBeLoaded();

        autoCompletePage.multiAutoCompleteSelectColor(COLOR_RED);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_BLUE);

        // Assert
        softAssert.assertEquals(autoCompletePage.getAllSelectedMultiColorNames(), COLOR_RED + "\n" + COLOR_BLUE, COLORS_SELECTED_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select two multiple colors")
    public void selectTwoMultipleColorsAndCloseFirst() {
        // Arrange & Act
        autoCompletePage.waitForPageToBeLoaded();
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_INDIGO);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_GREEN);

        autoCompletePage.closeFirstSelectedColor();

        // Assert
        softAssert.assertEquals(autoCompletePage.getAllSelectedMultiColorNames(), COLOR_GREEN, COLORS_SELECTED_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select two multiple colors and close all one by one")
    public void selectAllMultipleColorsAndCloseAllOneByOne() {
        // Arrange & Act
        autoCompletePage.waitForPageToBeLoaded();

        autoCompletePage.multiAutoCompleteSelectColor(COLOR_RED);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_BLUE);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_WHITE);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_GREEN);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_YELLOW);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_PURPLE);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_VIOLET);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_MAGENTA);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_BLACK);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_AQUA);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_INDIGO);

        for (int i = 0; i < 11; i++) {
            autoCompletePage.closeFirstSelectedColor();
        }

        // Assert
        softAssert.assertEquals(autoCompletePage.getAllSelectedMultiColorNames(), "", COLORS_SELECTED_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select two multiple colors")
    public void selectTwoMultipleColorsAndCloseAll() {
        // Arrange & Act
        autoCompletePage.waitForPageToBeLoaded();

        autoCompletePage.multiAutoCompleteSelectColor(COLOR_RED);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_BLUE);

        autoCompletePage.clickCloseAllColorsButton();

        // Assert
        softAssert.assertEquals(autoCompletePage.getAllSelectedMultiColorNames(), "", COLORS_SELECTED_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select four multiple colors delete and two new")
    public void selectFourMultipleColorsCloseAlAddNewTwoColors() {
        // Arrange & Act & Assert
        autoCompletePage.waitForPageToBeLoaded();

        autoCompletePage.multiAutoCompleteSelectColor(COLOR_RED);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_BLUE);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_WHITE);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_GREEN);

        softAssert.assertEquals(autoCompletePage.getAllSelectedMultiColorNames(), COLOR_RED + "\n" + COLOR_BLUE + "\n" + COLOR_WHITE + "\n" + COLOR_GREEN, COLORS_SELECTED_FIRST_ERROR);

        autoCompletePage.clickCloseAllColorsButton();

        autoCompletePage.multiAutoCompleteSelectColor(COLOR_WHITE);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_GREEN);

        softAssert.assertEquals(autoCompletePage.getAllSelectedMultiColorNames(), COLOR_WHITE + "\n" + COLOR_GREEN, COLORS_SELECTED_SECOND_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select one single color.")
    public void selectOneSingleColor() {
        // Arrange & Act
        autoCompletePage.singleAutoComplete(COLOR_GREEN);

        // Assert
        softAssert.assertEquals(autoCompletePage.getAllSingleColorNames(), COLOR_GREEN, GREEN_COLOR_SELECTED_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select one color and select other color ")
    public void selectOneSingleColorAndChangeColor() {
        // Arrange & Act
        autoCompletePage.singleAutoComplete(COLOR_GREEN);
        softAssert.assertEquals(autoCompletePage.getAllSingleColorNames(), COLOR_GREEN, FIRST_COLOR_SELECTED_ERROR);

        autoCompletePage.clickSingleAutoComplete();
        autoCompletePage.singleAutoComplete(COLOR_BLUE);

        softAssert.assertEquals(autoCompletePage.getAllSingleColorNames(), COLOR_BLUE, SECOND_COLOR_SELECTED_ERROR);
        softAssert.assertAll();
    }
}
