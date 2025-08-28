package demoqa.web.tests.widgets;

import demoqa.pages.widgets.WidgetsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class WidgetsPageTests extends BaseTest {
    // Expected URL Constants
    private static final String ACCORDION_URL = DEMO_QA_URL + "accordian";
    private static final String AUTO_COMPLETE_URL = DEMO_QA_URL + "auto-complete";
    private static final String DATE_PICKER_URL = DEMO_QA_URL + "date-picker";
    private static final String SLIDER_URL = DEMO_QA_URL + "slider";
    private static final String PROGRESS_BAR_URL = DEMO_QA_URL + "progress-bar";
    private static final String TABS_URL = DEMO_QA_URL + "tabs";
    private static final String TOOL_TIPS_URL = DEMO_QA_URL + "tool-tips";
    private static final String MENU_URL = DEMO_QA_URL + "menu";
    private static final String SELECT_MENU_URL = DEMO_QA_URL + "select-menu";

    // Text Constants
    private static final String EXPECTED_MAIN_TEXT = "Please select an item from left to start practice.";

    // Error Message Constants
    private static final String URL_MISMATCH_ERROR = "Expected URL mismatch";
    private static final String MAIN_TEXT_ERROR = "Wrong main text";
    private static final String ACCORDION_VISIBILITY_ERROR = "Accordion is not shown";
    private static final String ACCORDION_HIDDEN_ERROR = "Accordion is shown when it should be hidden";

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
                ACCORDION_URL, widgetsPage::clickAccordion,
                AUTO_COMPLETE_URL, widgetsPage::clickAutoComplete,
                DATE_PICKER_URL, widgetsPage::clickDatePicker,
                SLIDER_URL, widgetsPage::clickSlider,
                PROGRESS_BAR_URL, widgetsPage::clickProgressBar,
                TABS_URL, widgetsPage::clickTabs,
                TOOL_TIPS_URL, widgetsPage::clickToolTips,
                MENU_URL, widgetsPage::clickMenu,
                SELECT_MENU_URL, widgetsPage::clickSelectMenu
        );

        // Act
        widgetActions.forEach((expectedUrl, action) -> {
            action.run();
            String actualUrl = widgetsPage.checkCurrentUrl();
            softAssert.assertEquals(actualUrl, expectedUrl, URL_MISMATCH_ERROR + ": " + expectedUrl);
        });
        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify show/hide left dropdown menu")
    public void clickLeftDropdownMenu() {
        // Arrange and Act       
        softAssert.assertEquals(widgetsPage.getMainText(), EXPECTED_MAIN_TEXT, MAIN_TEXT_ERROR);
        softAssert.assertTrue(widgetsPage.verifyAccordionIsVisible(), ACCORDION_VISIBILITY_ERROR);
        widgetsPage.clickWidgetsWindows();
        softAssert.assertFalse(widgetsPage.verifyAccordionIsNotVisible(), ACCORDION_HIDDEN_ERROR);

        // Assert
        softAssert.assertAll();
    }
}
