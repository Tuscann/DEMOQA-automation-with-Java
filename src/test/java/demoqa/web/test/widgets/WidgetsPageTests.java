package demoqa.web.test.widgets;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WidgetsPageTests extends BaseTest {

    @Test(enabled = true)
    public void CheckAllNinePagesLinks() {
        navigateToUrl("widgets");

        String expectedUrl = "https://demoqa.com/accordian";
        widgetsPage.clickAccordion();
        String actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected accordian url.\n");

        expectedUrl = "https://demoqa.com/auto-complete";
        widgetsPage.clickAutoComplete();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected auto-complete url.\n");

        expectedUrl = "https://demoqa.com/date-picker";
        widgetsPage.clickDatePicker();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected date picker url.\n");

        expectedUrl = "https://demoqa.com/slider";
        widgetsPage.clickSlider();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected slider url.\n");

        expectedUrl = "https://demoqa.com/progress-bar";
        widgetsPage.clickProgressBar();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected progress bar url.\n");

        expectedUrl = "https://demoqa.com/tabs";
        widgetsPage.clickTabs();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected tabs url.\n");

        expectedUrl = "https://demoqa.com/tool-tips";
        widgetsPage.clickToolTips();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected tooltips url.\n");

        expectedUrl = "https://demoqa.com/menu";
        widgetsPage.clickMenu();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected menu url.\n");

        expectedUrl = "https://demoqa.com/select-menu";
        widgetsPage.clickSelectMenu();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected select menu url.\n");
    }
}
