package demoqa.web.tests.widgets;

import demoqa.pages.widgets.TabsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TabsPageTests extends BaseTest {
    // Text Constants
    private static final String EXPECTED_HEADER_TEXT = "Tabs";
    private static final String EXPECTED_SUBTITLE_TEXT = "Details about Lorem Ipsum";
    private static final String EXPECTED_WHAT_TAB_TEXT = "What";
    private static final String EXPECTED_ORIGIN_TAB_TEXT = "Origin";
    private static final String EXPECTED_USE_TAB_TEXT = "Use";
    private static final String EXPECTED_MORE_TAB_TEXT = "More";

    // Long Text Constants (Lorem Ipsum Content)
    private static final String EXPECTED_WHAT_TAB_CONTENT = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

    private static final String EXPECTED_ORIGIN_TAB_CONTENT = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
            "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.";

    private static final String EXPECTED_USE_TAB_CONTENT = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).";

    // Error Message Constants
    private static final String HEADER_TEXT_ERROR = "Wrong Tabs header text";
    private static final String SUBTITLE_TEXT_ERROR = "Wrong Details about Lorem Ipsum text";
    private static final String WHAT_TAB_TEXT_ERROR = "Wrong what tab text";
    private static final String ORIGIN_TAB_TEXT_ERROR = "Wrong origin tab text";
    private static final String USE_TAB_TEXT_ERROR = "Wrong use tab text";
    private static final String MORE_TAB_TEXT_ERROR = "Wrong more tab text";
    private static final String WHAT_TAB_CONTENT_ERROR = "Wrong what tab content";
    private static final String ORIGIN_TAB_CONTENT_ERROR = "Wrong origin tab content";
    private static final String USE_TAB_CONTENT_ERROR = "Wrong use tab content";

    private TabsPage tabsPage;
    private static final String TABS_URL = "tabs";

    @BeforeMethod
    public void goToTabsPage() {
        navigateToUrl(TABS_URL);
        tabsPage = new TabsPage(driver);
    }

    @DataProvider(name = "tabNavigationData")
    public Object[] tabNavigationDataProvider() {
        return new Object[]{
                "What",
                "Origin",
                "Use"
        };
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void checkAllTextOnPage() {
        // Arrange & Act & Assert
        softAssert.assertEquals(tabsPage.getTabsText(), EXPECTED_HEADER_TEXT, HEADER_TEXT_ERROR);
        softAssert.assertEquals(tabsPage.getUnderTitleText(), EXPECTED_SUBTITLE_TEXT, SUBTITLE_TEXT_ERROR);
        softAssert.assertEquals(tabsPage.getWhatTabText(), EXPECTED_WHAT_TAB_TEXT, WHAT_TAB_TEXT_ERROR);
        softAssert.assertEquals(tabsPage.getOriginTabText(), EXPECTED_ORIGIN_TAB_TEXT, ORIGIN_TAB_TEXT_ERROR);
        softAssert.assertEquals(tabsPage.getUseTabText(), EXPECTED_USE_TAB_TEXT, USE_TAB_TEXT_ERROR);
        softAssert.assertEquals(tabsPage.getMoreTabText(), EXPECTED_MORE_TAB_TEXT, MORE_TAB_TEXT_ERROR);
        softAssert.assertAll();
    }

    @Test(dataProvider = "tabNavigationData", enabled = true, description = "Test tab navigation with data provider")
    public void testTabNavigationWithDataProvider(String tabName) {
        switch (tabName) {
            case "What":
                tabsPage.clickWhatTab();
                String actualWhatText = tabsPage.getWhatTabInternalText();
                softAssert.assertEquals(actualWhatText, EXPECTED_WHAT_TAB_CONTENT, WHAT_TAB_CONTENT_ERROR);
                break;
            case "Origin":
                tabsPage.clickOriginTab();
                String actualOriginText = tabsPage.getOriginTabInternalText();
                softAssert.assertEquals(actualOriginText, EXPECTED_ORIGIN_TAB_CONTENT, ORIGIN_TAB_CONTENT_ERROR);
                break;
            case "Use":
                tabsPage.clickUseTab();
                String actualUseText = tabsPage.getUseTabInternalText();
                softAssert.assertEquals(actualUseText, EXPECTED_USE_TAB_CONTENT, USE_TAB_CONTENT_ERROR);
                break;
        }
        softAssert.assertAll();
    }
}
