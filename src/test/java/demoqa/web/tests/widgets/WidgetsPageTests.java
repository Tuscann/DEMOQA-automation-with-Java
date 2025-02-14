package demoqa.web.tests.widgets;

import demoqa.pages.widgets.WidgetsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.Test;

public class WidgetsPageTests extends BaseTest {

    @Test(enabled = true, testName = "Check 9 pages links")
    public void CheckAllNinePagesLinks() {
        navigateToUrl("widgets");
        WidgetsPage widgetsPage = new WidgetsPage(driver);

        String expectedUrl = "https://demoqa.com/accordian";
        widgetsPage.clickAccordion();
        String actualUrl = widgetsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nExpected accordian url.\n");

        expectedUrl = "https://demoqa.com/auto-complete";
        widgetsPage.clickAutoComplete();
        actualUrl = widgetsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nExpected auto-complete url.\n");

        expectedUrl = "https://demoqa.com/date-picker";
        widgetsPage.clickDatePicker();
        actualUrl = widgetsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nExpected date picker url.\n");

        expectedUrl = "https://demoqa.com/slider";
        widgetsPage.clickSlider();
        actualUrl = widgetsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nExpected slider url.\n");

        expectedUrl = "https://demoqa.com/progress-bar";
        widgetsPage.clickProgressBar();
        actualUrl = widgetsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nExpected progress bar url.\n");

        expectedUrl = "https://demoqa.com/tabs";
        widgetsPage.clickTabs();
        actualUrl = widgetsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nExpected tabs url.\n");

        expectedUrl = "https://demoqa.com/tool-tips";
        widgetsPage.clickToolTips();
        actualUrl = widgetsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nExpected tooltips url.\n");

        expectedUrl = "https://demoqa.com/menu";
        widgetsPage.clickMenu();
        actualUrl = widgetsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nExpected menu url.\n");

        expectedUrl = "https://demoqa.com/select-menu";
        widgetsPage.clickSelectMenu();
        actualUrl = widgetsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nExpected select menu url.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify show/hide left dropdown menu")
    public void ClickLeftDropdownMenu() {
        navigateToUrl("widgets");
        WidgetsPage widgetsPage = new WidgetsPage(driver);

        String expectedString = "Please select an item from left to start practice.";
        String actualString = widgetsPage.getMainText();
        softAssert.assertEquals(actualString, expectedString, "\nWrong text.\n");

        boolean TextBoxIsVisible = widgetsPage.verifyAccordionIsVisible();
        softAssert.assertTrue(TextBoxIsVisible, "\nFrames is not shown.\n");

        widgetsPage.clickWidgetsWindows();

        TextBoxIsVisible = widgetsPage.verifyAccordionIsNotVisible();
        softAssert.assertFalse(TextBoxIsVisible, "\nFrames is shown.\n");

        softAssert.assertAll();
    }
}
