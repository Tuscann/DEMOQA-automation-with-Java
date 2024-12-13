package part3.comdemoqa.tests.widgets;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class AutoCompletePageTests extends BaseTest {

    @Test
    public void SelectTwoColorsMultiple() {
        navigateToUrl("auto-complete");

        String expectedFirstColor = "Red";
        String expectedSecondColor = "Blue";
        autoCompletePage.multiAutoComplete(expectedFirstColor);
        autoCompletePage.multiAutoComplete(expectedSecondColor);

        String actualSelectedColors = autoCompletePage.getAllSelectedMultiColorNames();

        Assert.assertEquals(actualSelectedColors, expectedFirstColor + "\n" + expectedSecondColor, "Wrong Colors selected");
    }

    @Test
    public void SelectTwoColorsDeleteTwoAddNewMultiple() {
        navigateToUrl("auto-complete");

        String expectedFirstColor = "Red";
        String expectedSecondColor = "Blue";
        autoCompletePage.multiAutoComplete(expectedFirstColor);
        autoCompletePage.multiAutoComplete(expectedSecondColor);
        String actualSelectedColors = autoCompletePage.getAllSelectedMultiColorNames();
        Assert.assertEquals(actualSelectedColors, expectedFirstColor + "\n" + expectedSecondColor, "Wrong Colors selected");

        autoCompletePage.clickCloseButton();

        expectedFirstColor = "White";
        expectedSecondColor = "Green";
        autoCompletePage.multiAutoComplete(expectedFirstColor);
        autoCompletePage.multiAutoComplete(expectedSecondColor);
        actualSelectedColors = autoCompletePage.getAllSelectedMultiColorNames();
        Assert.assertEquals(actualSelectedColors, expectedFirstColor + "\n" + expectedSecondColor, "Wrong Colors selected");
    }

    @Test
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

    @Test
    public void SelectOneColorSingle() {
        navigateToUrl("auto-complete");

        String expectedFirstColor = "Green";
        autoCompletePage.singleAutoComplete(expectedFirstColor);
        String actualSelectedColors = autoCompletePage.getAllSingleColorNames();

        Assert.assertEquals(actualSelectedColors, expectedFirstColor, "Wrong Color selected");
    }

    @Test
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
}
