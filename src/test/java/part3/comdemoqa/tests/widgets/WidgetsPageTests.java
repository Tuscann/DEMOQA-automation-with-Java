package part3.comdemoqa.tests.widgets;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class WidgetsPageTests extends BaseTest {

    @Test(enabled = true)
    public void CheckAllNinePagesLinks() {
        navigateToUrl("widgets");

        String expectedUrl = "https://demoqa.com/accordian";
        widgetsPage.clickAccordian();
        String actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/auto-complete";
        widgetsPage.clickAutoComplete();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/date-picker";
        widgetsPage.clickDatePicker();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/slider";
        widgetsPage.clickSlider();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/progress-bar";
        widgetsPage.clickProgressBar();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/tabs";
        widgetsPage.clickTabs();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/tool-tips";
        widgetsPage.clickToolTips();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/menu";
        widgetsPage.clickMenu();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/select-menu";
        widgetsPage.clickSelectMenu();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
