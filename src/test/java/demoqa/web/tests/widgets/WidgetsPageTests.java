package demoqa.web.tests.widgets;

import demoqa.pages.widgets.WidgetsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.Test;

public class WidgetsPageTests extends BaseTest {

    @Test(enabled = true, testName = "Check 9 pages links")
    public void CheckAllNinePagesLinks() {
        // Arrange
        navigateToUrl("widgets");
        WidgetsPage widgetsPage = new WidgetsPage(driver);

        String expectedAccordianUrl = "https://demoqa.com/accordian";
        String expectedAutoCompleteUrl = "https://demoqa.com/auto-complete";
        String expectedDatePickerUrl = "https://demoqa.com/date-picker";
        String expectedSliderUrl = "https://demoqa.com/slider";
        String expectedProgressBarUrl = "https://demoqa.com/progress-bar";
        String expectedTabsUrl = "https://demoqa.com/tabs";
        String expectedToolsTipsUrl = "https://demoqa.com/tool-tips";
        String expectedMenuUrl = "https://demoqa.com/menu";
        String expectedSelectMenuUrl =  "https://demoqa.com/select-menu";

        // Act
        widgetsPage.clickAccordion();
        String actualAccordianUrl = widgetsPage.checkUrl();

        widgetsPage.clickAutoComplete();
        String  actualUrl = widgetsPage.checkUrl();

        widgetsPage.clickDatePicker();
        String  actualDatePickerUrl = widgetsPage.checkUrl();

        widgetsPage.clickSlider();
        String  actualSliderUrl = widgetsPage.checkUrl();

        widgetsPage.clickProgressBar();
        String  actualProgressBarUrl = widgetsPage.checkUrl();

        widgetsPage.clickTabs();
        String  actualTabsUrl = widgetsPage.checkUrl();

        widgetsPage.clickToolTips();
        String  actualToolsTipsUr = widgetsPage.checkUrl();

        widgetsPage.clickMenu();
        String  actualMenuUrl = widgetsPage.checkUrl();

        widgetsPage.clickSelectMenu();
        String  actualSelectMenuUrl = widgetsPage.checkUrl();

        // Assert
        softAssert.assertEquals(actualAccordianUrl, expectedAccordianUrl, "\nExpected accordian url.\n");
        softAssert.assertEquals(actualUrl, expectedAutoCompleteUrl, "\nExpected auto-complete url.\n");
        softAssert.assertEquals(actualDatePickerUrl, expectedDatePickerUrl, "\nExpected date picker url.\n");
        softAssert.assertEquals(actualSliderUrl, expectedSliderUrl, "\nExpected slider url.\n");
        softAssert.assertEquals(actualProgressBarUrl, expectedProgressBarUrl, "\nExpected progress bar url.\n");
        softAssert.assertEquals(actualTabsUrl, expectedTabsUrl, "\nExpected tabs url.\n");
        softAssert.assertEquals(actualToolsTipsUr, expectedToolsTipsUrl, "\nExpected tooltips url.\n");
        softAssert.assertEquals(actualMenuUrl, expectedMenuUrl, "\nExpected menu url.\n");
        softAssert.assertEquals(actualSelectMenuUrl, expectedSelectMenuUrl, "\nExpected select menu url.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify show/hide left dropdown menu")
    public void ClickLeftDropdownMenu() {
        // Arrange
        navigateToUrl("widgets");
        WidgetsPage widgetsPage = new WidgetsPage(driver);
        String expectedString = "Please select an item from left to start practice.";

        // Act
        String actualString = widgetsPage.getMainText();
        softAssert.assertEquals(actualString, expectedString, "\nWrong text.\n");

        boolean TextBoxIsVisible = widgetsPage.verifyAccordionIsVisible();
        softAssert.assertTrue(TextBoxIsVisible, "\nFrames is not shown.\n");

        widgetsPage.clickWidgetsWindows();

        TextBoxIsVisible = widgetsPage.verifyAccordionIsNotVisible();

        // Assert
        softAssert.assertFalse(TextBoxIsVisible, "\nFrames is shown.\n");
        softAssert.assertAll();
    }
}
