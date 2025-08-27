package demoqa.web.tests.interactions;

import demoqa.pages.interactions.InteractionsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InteractionPageTests extends BaseTest {
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
    private static final String SORTABLE_URL_ERROR = "Sortable URL mismatch";
    private static final String SELECTABLE_URL_ERROR = "Selectable URL mismatch";
    private static final String RESIZABLE_URL_ERROR = "Resizable URL mismatch";
    private static final String DROPPABLE_URL_ERROR = "Droppable URL mismatch";
    private static final String DRAGGABLE_URL_ERROR = "Draggable URL mismatch";

    public static final String INTERACTION_URL = "interaction";
    private InteractionsPage interactionsPage;

    @BeforeMethod
    public void goToInteractionsPage() {
        navigateToUrl(INTERACTION_URL);
        interactionsPage = new InteractionsPage(driver);
    }

    @Test(enabled = true, description = "Click left dropdown menu")
    public void clickLeftDropdownMenu() {
        // Arrange & Act        
        String actualString = interactionsPage.getMainText();
        softAssert.assertEquals(actualString, MAIN_TEXT, MAIN_TEXT_ERROR);

        boolean TextBoxIsVisible = interactionsPage.verifySortableIsVisible();
        softAssert.assertTrue(TextBoxIsVisible, SORTABLE_VISIBILITY_ERROR);

        interactionsPage.clickInteractions();

        TextBoxIsVisible = interactionsPage.verifyFramesIsNotVisible();
        softAssert.assertFalse(TextBoxIsVisible, FRAMES_VISIBILITY_ERROR);

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify nine pages links")
    public void checkAllNinePagesLinks() {
        // Arrange & Act
        interactionsPage.clickSortable();
        String actualSortableUrl = interactionsPage.checkCurrentUrl();

        interactionsPage.clickSelectable();
        String actualSelectableUrl = interactionsPage.checkCurrentUrl();

        interactionsPage.clickResizable();
        String actualResizableUrl = interactionsPage.checkCurrentUrl();

        interactionsPage.clickDroppable();
        String actualDroppableUrl = interactionsPage.checkCurrentUrl();

        interactionsPage.clickDraggable();
        String actualDragabbleUrl = interactionsPage.checkCurrentUrl();

        // Assert
        softAssert.assertEquals(actualSortableUrl, SORTABLE_URL, SORTABLE_URL_ERROR);
        softAssert.assertEquals(actualSelectableUrl, SELECTABLE_URL, SELECTABLE_URL_ERROR);
        softAssert.assertEquals(actualResizableUrl, RESIZABLE_URL, RESIZABLE_URL_ERROR);
        softAssert.assertEquals(actualDroppableUrl, DROPPABLE_URL, DROPPABLE_URL_ERROR);
        softAssert.assertEquals(actualDragabbleUrl, DRAGGABLE_URL, DRAGGABLE_URL_ERROR);
        softAssert.assertAll();
    }
}
