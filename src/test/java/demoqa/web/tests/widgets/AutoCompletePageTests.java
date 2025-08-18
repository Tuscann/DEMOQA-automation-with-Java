package demoqa.web.tests.widgets;

import demoqa.pages.widgets.AutoCompletePage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompletePageTests extends BaseTest {

    public static final String AUTO_COMPLETE_URL = "auto-complete";
    private AutoCompletePage autoCompletePage;
    
    // Text Constants
    private static final String PAGE_HEADING = "Auto Complete";
    private static final String TYPE_MULTIPLE_TEXT = "Type multiple color names";
    private static final String TYPE_SINGLE_TEXT = "Type single color name";
    
    // Color Constants
    private static final String COLOR_RED = "Red";
    private static final String COLOR_BLUE = "Blue";
    private static final String COLOR_WHITE = "White";
    private static final String COLOR_GREEN = "Green";
    
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

    @BeforeMethod
    public void goToDatePickerPage() {
        navigateToUrl(AUTO_COMPLETE_URL);
        autoCompletePage = new AutoCompletePage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange
        // Act
        String actualText = autoCompletePage.getText();
        String actualTypeMultipleText = autoCompletePage.getMultipleContainerText();
        String actualTypeSingleText = autoCompletePage.getAutoCompleteSingleText();

        softAssert.assertEquals(actualText, PAGE_HEADING, PAGE_HEADING_ERROR);
        softAssert.assertEquals(actualTypeMultipleText, TYPE_MULTIPLE_TEXT, TYPE_MULTIPLE_TEXT_ERROR);
        softAssert.assertEquals(actualTypeSingleText, TYPE_SINGLE_TEXT, TYPE_SINGLE_TEXT_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select two colors multiple")
    public void selectTwoColorsMultiple() {
        // Arrange

        // Act
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_RED);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_BLUE);

        String actualSelectedColors = autoCompletePage.getAllSelectedMultiColorNames();

        softAssert.assertEquals(actualSelectedColors, COLOR_RED + "\n" + COLOR_BLUE, COLORS_SELECTED_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select two colors and delete two multiple")
    public void selectTwoColorsAndDeleteTwoMultiple() {
        // Arrange

        // Act
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_RED);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_BLUE);
        String actualSelectedColors = autoCompletePage.getAllSelectedMultiColorNames();
        softAssert.assertEquals(actualSelectedColors, COLOR_RED + "\n" + COLOR_BLUE, COLORS_SELECTED_FIRST_ERROR);

        autoCompletePage.clickCloseButton();

        autoCompletePage.multiAutoCompleteSelectColor(COLOR_WHITE);
        autoCompletePage.multiAutoCompleteSelectColor(COLOR_GREEN);
        actualSelectedColors = autoCompletePage.getAllSelectedMultiColorNames();
        softAssert.assertEquals(actualSelectedColors, COLOR_WHITE + "\n" + COLOR_GREEN, COLORS_SELECTED_SECOND_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select one color clear add new color single")
    public void selectOneColorClearAddNewColorSingle() {
        // Arrange
        // Act
        autoCompletePage.singleAutoComplete(COLOR_GREEN);
        String actualSelectedColors = autoCompletePage.getAllSingleColorNames();

        softAssert.assertEquals(actualSelectedColors, COLOR_GREEN, FIRST_COLOR_SELECTED_ERROR);

        autoCompletePage.clickSingleAutoComplete();
        autoCompletePage.singleAutoComplete(COLOR_BLUE);
        actualSelectedColors = autoCompletePage.getAllSingleColorNames();

        softAssert.assertEquals(actualSelectedColors, COLOR_BLUE, SECOND_COLOR_SELECTED_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select one color single")
    public void selectOneColorSingle() {
        // Arrange      
        // Act
        autoCompletePage.singleAutoComplete(COLOR_GREEN);
        String actualSelectedColors = autoCompletePage.getAllSingleColorNames();

        softAssert.assertEquals(actualSelectedColors, COLOR_GREEN, GREEN_COLOR_SELECTED_ERROR);
        softAssert.assertAll();
    }
}
