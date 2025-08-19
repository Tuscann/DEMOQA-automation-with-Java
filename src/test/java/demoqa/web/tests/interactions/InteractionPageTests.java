package demoqa.web.tests.interactions;

import demoqa.pages.interactions.InteractionsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InteractionPageTests extends BaseTest {
    public static final String INTERACTION_URL = "interaction";
    private InteractionsPage interactionsPage;
    
    // Text Constants
    private static final String MAIN_TEXT = "Please select an item from left to start practice.";
    
    // URL Constants
    private static final String SORTABLE_URL = "https://demoqa.com/sortable";
    private static final String SELECTABLE_URL = "https://demoqa.com/selectable";
    private static final String RESIZABLE_URL = "https://demoqa.com/resizable";
    private static final String DROPPABLE_URL = "https://demoqa.com/droppable";
    private static final String DRAGGABLE_URL = "https://demoqa.com/dragabble";
    
    // Error Message Constants
    private static final String MAIN_TEXT_ERROR = "Main text mismatch";
    private static final String SORTABLE_VISIBILITY_ERROR = "Sortable should be visible";
    private static final String FRAMES_VISIBILITY_ERROR = "Frames should not be visible";
    private static final String SORTABLE_URL_ERROR = "Sortable URL mismatch";
    private static final String SELECTABLE_URL_ERROR = "Selectable URL mismatch";
    private static final String RESIZABLE_URL_ERROR = "Resizable URL mismatch";
    private static final String DROPPABLE_URL_ERROR = "Droppable URL mismatch";
    private static final String DRAGGABLE_URL_ERROR = "Draggable URL mismatch";

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
        String actualSortableUrl = interactionsPage.checkUrl();

        interactionsPage.clickSelectable();
        String actualSelectableUrl = interactionsPage.checkUrl();

        interactionsPage.clickResizable();
        String actualResizableUrl = interactionsPage.checkUrl();

        interactionsPage.clickDroppable();
        String actualDroppableUrl = interactionsPage.checkUrl();

        interactionsPage.clickDraggable();
        String actualDragabbleUrl = interactionsPage.checkUrl();

        // Assert
        softAssert.assertEquals(actualSortableUrl, SORTABLE_URL, SORTABLE_URL_ERROR);
        softAssert.assertEquals(actualSelectableUrl, SELECTABLE_URL, SELECTABLE_URL_ERROR);
        softAssert.assertEquals(actualResizableUrl, RESIZABLE_URL, RESIZABLE_URL_ERROR);
        softAssert.assertEquals(actualDroppableUrl, DROPPABLE_URL, DROPPABLE_URL_ERROR);
        softAssert.assertEquals(actualDragabbleUrl, DRAGGABLE_URL, DRAGGABLE_URL_ERROR);
        softAssert.assertAll();
    }
}
