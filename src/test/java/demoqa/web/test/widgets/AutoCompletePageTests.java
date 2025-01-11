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

        Assert.assertEquals(actualText, expectedText, "\nWrong Auto Complete.\n");
        Assert.assertEquals(actualTypeMultipleText, expectedTypeMultipleText, "\nWrong Type multiple color names.\n");
        Assert.assertEquals(actualTypeSingleText, expectedTypeSingleText, "\nWrong Type single color name.\n");
    }

    @Test(enabled = true)
    public void SelectTwoColorsMultiple() {
        navigateToUrl("auto-complete");

        String expectedFirstColor = "Red";
        String expectedSecondColor = "Blue";
        autoCompletePage.multiAutoCompleteSelectColor(expectedFirstColor);
        autoCompletePage.multiAutoCompleteSelectColor(expectedSecondColor);

        String actualSelectedColors = autoCompletePage.getAllSelectedMultiColorNames();

        Assert.assertEquals(actualSelectedColors, expectedFirstColor + "\n" + expectedSecondColor, "\nWrong Colors selected.\n");
    }

    @Test(enabled = true)
    public void SelectTwoColorsAndDeleteTwoMultiple() {
        navigateToUrl("auto-complete");

        String expectedFirstColor = "Red";
        String expectedSecondColor = "Blue";
        autoCompletePage.multiAutoCompleteSelectColor(expectedFirstColor);
        autoCompletePage.multiAutoCompleteSelectColor(expectedSecondColor);
        String actualSelectedColors = autoCompletePage.getAllSelectedMultiColorNames();
        Assert.assertEquals(actualSelectedColors, expectedFirstColor + "\n" + expectedSecondColor, "\nWrong Colors selected.\n");

        autoCompletePage.clickCloseButton();

        expectedFirstColor = "White";
        expectedSecondColor = "Green";
        autoCompletePage.multiAutoCompleteSelectColor(expectedFirstColor);
        autoCompletePage.multiAutoCompleteSelectColor(expectedSecondColor);
        actualSelectedColors = autoCompletePage.getAllSelectedMultiColorNames();
        Assert.assertEquals(actualSelectedColors, expectedFirstColor + "\n" + expectedSecondColor, "\nWrong Colors selected.\n");
    }

    @Test(enabled = true)
    public void SelectOneColorClearAddNewColorSingle() {
        navigateToUrl("auto-complete");

        String expectedFirstColor = "Green";
        autoCompletePage.singleAutoComplete(expectedFirstColor);
        String actualSelectedColors = autoCompletePage.getAllSingleColorNames();

        Assert.assertEquals(actualSelectedColors, expectedFirstColor, "\nWrong " + expectedFirstColor + " Color selected\n");

        expectedFirstColor = "Blue";
        autoCompletePage.clickSingleAutoComplete();
        autoCompletePage.singleAutoComplete(expectedFirstColor);
        actualSelectedColors = autoCompletePage.getAllSingleColorNames();

        Assert.assertEquals(actualSelectedColors, expectedFirstColor, "\nWrong " + expectedFirstColor + "Color selected\n");
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
