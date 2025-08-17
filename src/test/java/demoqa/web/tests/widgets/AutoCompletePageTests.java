package demoqa.web.tests.widgets;

import demoqa.pages.widgets.AutoCompletePage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompletePageTests extends BaseTest {

    public static final String AUTO_COMPLETE_URL = "auto-complete";
    private AutoCompletePage autoCompletePage;

    @BeforeMethod
    public void goToDatePickerPage() {
        navigateToUrl(AUTO_COMPLETE_URL);
        autoCompletePage = new AutoCompletePage(driver);
    }

    @Test(enabled = true, testName = "Verify all text on page")
    public void verifyAllTextOnPage() {
        // Arrange
        String expectedText = "Auto Complete";
        String expectedTypeMultipleText = "Type multiple color names";
        String expectedTypeSingleText = "Type single color name";

        // Act
        String actualText = autoCompletePage.getText();
        String actualTypeMultipleText = autoCompletePage.getMultipleContainerText();
        String actualTypeSingleText = autoCompletePage.getAutoCompleteSingleText();

        softAssert.assertEquals(actualText, expectedText, "\nWrong Auto Complete.\n");
        softAssert.assertEquals(actualTypeMultipleText, expectedTypeMultipleText, "\nWrong Type multiple color names.\n");
        softAssert.assertEquals(actualTypeSingleText, expectedTypeSingleText, "\nWrong Type single color name.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Select two colors multiple")
    public void selectTwoColorsMultiple() {
        // Arrange
        String expectedFirstColor = "Red";
        String expectedSecondColor = "Blue";

        // Act
        autoCompletePage.multiAutoCompleteSelectColor(expectedFirstColor);
        autoCompletePage.multiAutoCompleteSelectColor(expectedSecondColor);

        String actualSelectedColors = autoCompletePage.getAllSelectedMultiColorNames();

        softAssert.assertEquals(actualSelectedColors, expectedFirstColor + "\n" + expectedSecondColor, "\nWrong Colors selected.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Select two colors and delete two multiple")
    public void selectTwoColorsAndDeleteTwoMultiple() {
        // Arrange
        String expectedFirstColor = "Red";
        String expectedSecondColor = "Blue";

        // Act
        autoCompletePage.multiAutoCompleteSelectColor(expectedFirstColor);
        autoCompletePage.multiAutoCompleteSelectColor(expectedSecondColor);
        String actualSelectedColors = autoCompletePage.getAllSelectedMultiColorNames();
        softAssert.assertEquals(actualSelectedColors, expectedFirstColor + "\n" + expectedSecondColor, "\nWrong Colors selected first.\n");

        autoCompletePage.clickCloseButton();

        expectedFirstColor = "White";
        expectedSecondColor = "Green";
        autoCompletePage.multiAutoCompleteSelectColor(expectedFirstColor);
        autoCompletePage.multiAutoCompleteSelectColor(expectedSecondColor);
        actualSelectedColors = autoCompletePage.getAllSelectedMultiColorNames();
        softAssert.assertEquals(actualSelectedColors, expectedFirstColor + "\n" + expectedSecondColor, "\nWrong Colors selected second.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Select one color clear add new color single")
    public void selectOneColorClearAddNewColorSingle() {
        // Arrange
        String expectedFirstColor = "Green";

        // Act
        autoCompletePage.singleAutoComplete(expectedFirstColor);
        String actualSelectedColors = autoCompletePage.getAllSingleColorNames();

        softAssert.assertEquals(actualSelectedColors, expectedFirstColor, "\nWrong " + expectedFirstColor + " first color selected.\n");

        expectedFirstColor = "Blue";
        autoCompletePage.clickSingleAutoComplete();
        autoCompletePage.singleAutoComplete(expectedFirstColor);
        actualSelectedColors = autoCompletePage.getAllSingleColorNames();

        softAssert.assertEquals(actualSelectedColors, expectedFirstColor, "\nWrong " + expectedFirstColor + " second color selected.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Select one color single")
    public void selectOneColorSingle() {
        // Arrange
        String expectedFirstColor = "Green";

        // Act
        autoCompletePage.singleAutoComplete(expectedFirstColor);
        String actualSelectedColors = autoCompletePage.getAllSingleColorNames();

        softAssert.assertEquals(actualSelectedColors, expectedFirstColor, "\nWrong green color selected.\n");
        softAssert.assertAll();
    }
}
