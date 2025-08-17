package demoqa.web.tests.interactions;

import demoqa.pages.interactions.InteractionsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InteractionPageTests extends BaseTest {
    public static final String INTERACTION_URL = "interaction";
    private InteractionsPage interactionsPage;

    @BeforeMethod
    public void goToInteractionsPage() {
        navigateToUrl(INTERACTION_URL);
        interactionsPage = new InteractionsPage(driver);
    }

    @Test(enabled = true, testName = "Click left dropdown menu")
    public void clickLeftDropdownMenu() {
        // Arrange
        String expectedString = "Please select an item from left to start practice.";

        // Act
        String actualString = interactionsPage.getMainText();
        softAssert.assertEquals(actualString, expectedString, "\nWrong text.\n");

        boolean TextBoxIsVisible = interactionsPage.verifySortableIsVisible();
        softAssert.assertTrue(TextBoxIsVisible, "\nFrames is not shown.\n");

        interactionsPage.clickInteractions();

        TextBoxIsVisible = interactionsPage.verifyFramesIsNotVisible();
        softAssert.assertFalse(TextBoxIsVisible, "\nFrames is shown.\n");

        // Assert
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify nine pages links")
    public void checkAllNinePagesLinks() {
        // Arrange
        String expectedSortableUrl = "https://demoqa.com/sortable";
        String expectedSelectableUrl = "https://demoqa.com/selectable";
        String expectedResizableUrl = "https://demoqa.com/resizable";
        String expectedDroppableUrl = "https://demoqa.com/droppable";
        String expectedDragabbleUrl = "https://demoqa.com/dragabble";

        // Act
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
        softAssert.assertEquals(actualSortableUrl, expectedSortableUrl, "\nWrong url for sortable page.\n");
        softAssert.assertEquals(actualSelectableUrl, expectedSelectableUrl, "\nWrong url for selectable page.\n");
        softAssert.assertEquals(actualResizableUrl, expectedResizableUrl, "\nWrong url for resizable page.\n");
        softAssert.assertEquals(actualDroppableUrl, expectedDroppableUrl, "\nWrong url for droppable page.\n");
        softAssert.assertEquals(actualDragabbleUrl, expectedDragabbleUrl, "\nWrong url for draggable page.\n");
        softAssert.assertAll();
    }
}
