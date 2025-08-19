package demoqa.web.tests.widgets;

import demoqa.pages.widgets.WidgetsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class WidgetsPageTests extends BaseTest {

    private WidgetsPage widgetsPage;
    private static final String WIDGETS_URL = "widgets";

    @BeforeMethod
    public void goToWidgetsPage() {
        navigateToUrl(WIDGETS_URL);
        widgetsPage = new WidgetsPage(driver);
    }

    @Test(enabled = true, description = "Verify all widget subpage links work correctly.")
    public void checkAllNinePagesLinks() {
        // Arrange
        Map<String, Runnable> widgetActions = Map.of(
                "https://demoqa.com/accordian", widgetsPage::clickAccordion,
                "https://demoqa.com/auto-complete", widgetsPage::clickAutoComplete,
                "https://demoqa.com/date-picker", widgetsPage::clickDatePicker,
                "https://demoqa.com/slider", widgetsPage::clickSlider,
                "https://demoqa.com/progress-bar", widgetsPage::clickProgressBar,
                "https://demoqa.com/tabs", widgetsPage::clickTabs,
                "https://demoqa.com/tool-tips", widgetsPage::clickToolTips,
                "https://demoqa.com/menu", widgetsPage::clickMenu,
                "https://demoqa.com/select-menu", widgetsPage::clickSelectMenu
        );

        // Act
        widgetActions.forEach((expectedUrl, action) -> {
            action.run();
            String actualUrl = widgetsPage.checkUrl();
            softAssert.assertEquals(actualUrl, expectedUrl, "\nExpected URL: " + expectedUrl + "\n");
        });
        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify show/hide left dropdown menu")
    public void clickLeftDropdownMenu() {
        // Arrange
        String expectedString = "Please select an item from left to start practice.";

        // Act
        softAssert.assertEquals(widgetsPage.getMainText(), expectedString, "\nWrong text.\n");
        softAssert.assertTrue(widgetsPage.verifyAccordionIsVisible(), "\nFrames is not shown.\n");
        widgetsPage.clickWidgetsWindows();
        softAssert.assertFalse(widgetsPage.verifyAccordionIsNotVisible(), "\nFrames is shown.\n");

        // Assert
        softAssert.assertAll();
    }
}
