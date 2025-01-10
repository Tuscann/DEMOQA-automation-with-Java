package demoqa.web.test.widgets;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutoCompletePageTests extends BaseTest {

    @Test(enabled = true)
    public void VerifyAllTextOnPage() {
        navigateToUrl("auto-complete");

        String expectedText = "Auto Complete";
        String expectedTypeMultipleText = "Type multiple color names";
        String expectedTypeSingleText = "Type single color name";

        String actualText = autoCompletePage.getText();
        String actualTypeMultipleText = autoCompletePage.getMultipleContainerText();
        String actualTypeSingleText = autoCompletePage.getAutoCompleteSingleText();

        Assert.assertEquals(actualText, expectedText, "Wrong Auto Complete");
        Assert.assertEquals(actualTypeMultipleText, expectedTypeMultipleText, "Wrong Type multiple color names");
        Assert.assertEquals(actualTypeSingleText, expectedTypeSingleText, "Wrong Type single color name");
    }

    @Test(enabled = true)
    public void SelectTwoColorsMultiple() {
        navigateToUrl("auto-complete");

        String expectedFirstColor = "Red";
        String expectedSecondColor = "Blue";
        autoCompletePage.multiAutoCompleteSelectColor(expectedFirstColor);
        autoCompletePage.multiAutoCompleteSelectColor(expectedSecondColor);

        String actualSelectedColors = autoCompletePage.getAllSelectedMultiColorNames();

        Assert.assertEquals(actualSelectedColors, expectedFirstColor + "\n" + expectedSecondColor, "Wrong Colors selected");
    }

    @Test(enabled = true)
    public void SelectTwoColorsAndDeleteTwoMultiple() {
        navigateToUrl("auto-complete");

        String expectedFirstColor = "Red";
        String expectedSecondColor = "Blue";
        autoCompletePage.multiAutoCompleteSelectColor(expectedFirstColor);
        autoCompletePage.multiAutoCompleteSelectColor(expectedSecondColor);
        String actualSelectedColors = autoCompletePage.getAllSelectedMultiColorNames();
        Assert.assertEquals(actualSelectedColors, expectedFirstColor + "\n" + expectedSecondColor, "Wrong Colors selected");

        autoCompletePage.clickCloseButton();

        expectedFirstColor = "White";
        expectedSecondColor = "Green";
        autoCompletePage.multiAutoCompleteSelectColor(expectedFirstColor);
        autoCompletePage.multiAutoCompleteSelectColor(expectedSecondColor);
        actualSelectedColors = autoCompletePage.getAllSelectedMultiColorNames();
        Assert.assertEquals(actualSelectedColors, expectedFirstColor + "\n" + expectedSecondColor, "Wrong Colors selected");
    }

    @Test(enabled = true)
    public void SelectOneColorClearAddNewColorSingle() {
        navigateToUrl("auto-complete");

        String expectedFirstColor = "Green";
        autoCompletePage.singleAutoComplete(expectedFirstColor);
        String actualSelectedColors = autoCompletePage.getAllSingleColorNames();

        Assert.assertEquals(actualSelectedColors, expectedFirstColor, "Wrong " + expectedFirstColor + " Color selected");

        expectedFirstColor = "Blue";
        autoCompletePage.clickSingleAutoComplete();
        autoCompletePage.singleAutoComplete(expectedFirstColor);
        actualSelectedColors = autoCompletePage.getAllSingleColorNames();

        Assert.assertEquals(actualSelectedColors, expectedFirstColor, "Wrong " + expectedFirstColor + "Color selected");
    }

    @Test(enabled = true)
    public void SelectOneColorSingle() {
        navigateToUrl("auto-complete");

        String expectedFirstColor = "Green";
        autoCompletePage.singleAutoComplete(expectedFirstColor);
        String actualSelectedColors = autoCompletePage.getAllSingleColorNames();

        Assert.assertEquals(actualSelectedColors, expectedFirstColor, "\nWrong green color selected.\n");
    }
}
