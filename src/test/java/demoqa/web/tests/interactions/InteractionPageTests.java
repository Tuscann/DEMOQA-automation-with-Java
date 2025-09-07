package demoqa.web.tests.interactions;

import demoqa.pages.interactions.InteractionsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InteractionPageTests extends BaseTest {
    public static final String INTERACTION_URL = "interaction";
    // Text Constants
    private static final String MAIN_TEXT = "Please select an item from left to start practice.";
    // URL Constants
    private static final String SORTABLE_URL = DEMO_QA_URL + "sortable";
    private static final String SELECTABLE_URL = DEMO_QA_URL + "selectable";
    private static final String RESIZABLE_URL = DEMO_QA_URL + "resizable";
    private static final String DROPPABLE_URL = DEMO_QA_URL + "droppable";
    private static final String DRAGGABLE_URL = DEMO_QA_URL + "dragabble";
    // Error Message Constants
    private static final String MAIN_TEXT_ERROR = "Main text mismatch";
    private static final String SORTABLE_VISIBILITY_ERROR = "Sortable should be visible";
    private static final String FRAMES_VISIBILITY_ERROR = "Frames should not be visible";
    private static final String HOME_ADDRESS_ERROR = "Wrong home address";
    private static final String CARD_NAVIGATION_ERROR = "Failed for card: %s";
    private InteractionsPage interactionsPage;

    @BeforeMethod
    public void goToInteractionsPage() {
        navigateToUrl(INTERACTION_URL);
        interactionsPage = new InteractionsPage(driver);
    }

    @DataProvider(name = "homePageCards")
    public Object[][] homePageCards() {
        return new Object[][]{
                {"Sortable", SORTABLE_URL, (Runnable) () -> interactionsPage.clickSortable()},
                {"Selectable", SELECTABLE_URL, (Runnable) () -> interactionsPage.clickSelectable()},
                {"Resizable", RESIZABLE_URL, (Runnable) () -> interactionsPage.clickResizable()},
                {"Droppable", DROPPABLE_URL, (Runnable) () -> interactionsPage.clickDroppable()},
                {"Dragabble", DRAGGABLE_URL, (Runnable) () -> interactionsPage.clickDraggable()}
        };
    }

    @Test(dataProvider = "homePageCards", description = "Click and verify card: {0} ")
    public void checkAllFivePagesLinks(String cardName, String expectedUrl, Runnable clickAction) {
        // Arrange & Act
        clickAction.run();
        String actualUrl = interactionsPage.getCurrentUrl();
        interactionsPage.clickTopImage();
        String url = interactionsPage.getCurrentUrl();

        // Assert
        softAssert.assertEquals(actualUrl, expectedUrl, String.format(CARD_NAVIGATION_ERROR, cardName));
        softAssert.assertEquals(url, DEMO_QA_URL, HOME_ADDRESS_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click left dropdown menu")
    public void clickLeftDropdownMenu() {
        // Arrange & Act
        softAssert.assertEquals(interactionsPage.getMainText(), MAIN_TEXT, MAIN_TEXT_ERROR);

        softAssert.assertTrue(interactionsPage.verifySortableIsVisible(), SORTABLE_VISIBILITY_ERROR);
        interactionsPage.clickInteractions();
        softAssert.assertFalse(interactionsPage.verifyFramesIsNotVisible(), FRAMES_VISIBILITY_ERROR);

        // Assert
        softAssert.assertAll();
    }
}
