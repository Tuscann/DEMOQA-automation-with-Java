package demoqa.web.tests.widgets;

import demoqa.pages.widgets.WidgetsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
    private static final String CARD_NAVIGATION_ERROR = "Failed for card: %s";

    // Text Constants
    private static final String EXPECTED_MAIN_TEXT = "Please select an item from left to start practice.";

    // Error Message Constants
    private static final String MAIN_TEXT_ERROR = "Wrong main text";
    private static final String ACCORDION_VISIBILITY_ERROR = "Accordion is not shown";
    private static final String ACCORDION_HIDDEN_ERROR = "Accordion is shown when it should be hidden";
    private static final String HOME_ADDRESS_ERROR = "Wrong home address";
    private static final String WIDGETS_URL = "widgets";
    private WidgetsPage widgetsPage;

    @BeforeMethod
    public void goToWidgetsPage() {
        navigateToUrl(WIDGETS_URL);
        widgetsPage = new WidgetsPage(driver);
    }


    @DataProvider(name = "homePageCards")
    public Object[][] homePageCards() {
        return new Object[][]{
                {"Accordian", ACCORDION_URL, (Runnable) () -> widgetsPage.clickAccordion()},
                {"Auto Complete", AUTO_COMPLETE_URL, (Runnable) () -> widgetsPage.clickAutoComplete()},
                {"Date Picker", DATE_PICKER_URL, (Runnable) () -> widgetsPage.clickDatePicker()},
                {"Slider", SLIDER_URL, (Runnable) () -> widgetsPage.clickSlider()},
                {"Progress bar", PROGRESS_BAR_URL, (Runnable) () -> widgetsPage.clickProgressBar()},
                {"Tabs", TABS_URL, (Runnable) () -> widgetsPage.clickTabs()},
                {"Slider", TOOL_TIPS_URL, (Runnable) () -> widgetsPage.clickToolTips()},
                {"Menu", MENU_URL, (Runnable) () -> widgetsPage.clickMenu()},
                {"Select Menu", SELECT_MENU_URL, (Runnable) () -> widgetsPage.clickSelectMenu()}
        };
    }

    @Test(dataProvider = "homePageCards", description = "Click and verify card: {0} ")
    public void checkAllFivePagesLinks(String cardName, String expectedUrl, Runnable clickAction) {
        // Arrange & Act
        clickAction.run();
        String actualUrl = widgetsPage.checkCurrentUrl();
        widgetsPage.clickTopImage();
        String url = widgetsPage.checkCurrentUrl();

        // Assert
        softAssert.assertEquals(actualUrl, expectedUrl, String.format(CARD_NAVIGATION_ERROR, cardName));
        softAssert.assertEquals(url, DEMO_QA_URL, HOME_ADDRESS_ERROR);
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
