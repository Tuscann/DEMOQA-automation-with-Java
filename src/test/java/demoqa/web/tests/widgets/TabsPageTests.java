package demoqa.web.tests.widgets;

import demoqa.pages.widgets.TabsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TabsPageTests extends BaseTest {

    // Expected text constants
    private static final String EXPECTED_HEAD = "Tabs";
    private static final String EXPECTED_STRING = "Details about Lorem Ipsum";
    private static final String EXPECTED_WHAT_TEXT = "What";
    private static final String EXPECTED_ORIGIN_TEXT = "Origin";
    private static final String EXPECTED_USE_TEXT = "Use";
    private static final String EXPECTED_MORE_TEXT = "More";

    public static final String TABS_URL = "tabs";
    private TabsPage tabsPage;

    @BeforeMethod
    public void goToTabsPage() {
        navigateToUrl(TABS_URL);
        tabsPage = new TabsPage(driver);
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void checkAllTextOnPage() {
        // Arrange
        // Act
        String actualHead = tabsPage.getTabsText();
        String actualString = tabsPage.getUnderTitleText();
        String actualWhatText = tabsPage.getWhatTabText();
        String actualOriginText = tabsPage.getOriginTabText();
        String actualUseText = tabsPage.getUseTabText();
        String actualMoreText = tabsPage.getMoreTabText();

        // Assert
        softAssert.assertEquals(actualHead, EXPECTED_HEAD, "\nWrong Tabs text.\n");
        softAssert.assertEquals(actualString, EXPECTED_STRING, "\nWrong Details about Lorem Ipsum text.\n");
        softAssert.assertEquals(actualWhatText, EXPECTED_WHAT_TEXT, "\nWrong what text.\n");
        softAssert.assertEquals(actualOriginText, EXPECTED_ORIGIN_TEXT, "\nWrong origin text.\n");
        softAssert.assertEquals(actualUseText, EXPECTED_USE_TEXT, "\nWrong use text.\n");
        softAssert.assertEquals(actualMoreText, EXPECTED_MORE_TEXT, "\nWrong more text.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select what tab and check text")
    public void selectWhatTabAndCheckText() {
        // Arrange
        String expectedWhatInternalText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        // Act
        tabsPage.clickWhatTab();
        String actualText = tabsPage.getWhatTabInternalText();

        // Assert
        softAssert.assertEquals(actualText, expectedWhatInternalText, "\nWrong what text.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select origin tab and check text")
    public void selectOriginTabAndCheckText() {
        // Arrange
        String expectedWhatInternalText = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.";

        // Act
        tabsPage.clickOriginTab();
        String actualText = tabsPage.getOriginTabInternalText();

        // Assert
        softAssert.assertEquals(actualText, expectedWhatInternalText, "\nWrong origin text.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Select use tab and check text")
    public void selectUseTabAndCheckText() {
        // Arrange
        String expectedWhatInternalText = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).";

        // Act
        tabsPage.clickUseTab();
        String actualText = tabsPage.getUseTabInternalText();

        // Assert
        softAssert.assertEquals(actualText, expectedWhatInternalText, "\nWrong use text.\n");
        softAssert.assertAll();
    }
}
