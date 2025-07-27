package demoqa.web.tests.widgets;

import demoqa.pages.widgets.AutoCompletePage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.Test;

public class AutoCompletePageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        // Arrange
        navigateToUrl("auto-complete");
        AutoCompletePage autoCompletePage = new AutoCompletePage(driver);

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
    public void SelectTwoColorsMultiple() {
        // Arrange
        navigateToUrl("auto-complete");
        AutoCompletePage autoCompletePage = new AutoCompletePage(driver);

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
    public void SelectTwoColorsAndDeleteTwoMultiple() {
        // Arrange
        navigateToUrl("auto-complete");
        AutoCompletePage autoCompletePage = new AutoCompletePage(driver);

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
    public void SelectOneColorClearAddNewColorSingle() {
        // Arrange
        navigateToUrl("auto-complete");
        AutoCompletePage autoCompletePage = new AutoCompletePage(driver);
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
    public void SelectOneColorSingle() {
        // Arrange
        navigateToUrl("auto-complete");
        AutoCompletePage autoCompletePage = new AutoCompletePage(driver);
        String expectedFirstColor = "Green";

        // Act
        autoCompletePage.singleAutoComplete(expectedFirstColor);
        String actualSelectedColors = autoCompletePage.getAllSingleColorNames();

        softAssert.assertEquals(actualSelectedColors, expectedFirstColor, "\nWrong green color selected.\n");
        softAssert.assertAll();
    }
}
