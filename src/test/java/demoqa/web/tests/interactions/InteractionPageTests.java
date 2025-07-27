package demoqa.web.tests.interactions;

import demoqa.pages.interactions.InteractionsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.Test;

public class InteractionPageTests extends BaseTest {

    @Test(enabled = true, testName = "Click left dropdown menu")
    public void ClickLeftDropdownMenu() {
        // Arrange
        navigateToUrl("interaction");
        InteractionsPage interactionsPage = new InteractionsPage(driver);

        String expectedString = "Please select an item from left to start practice.";
        String actualString = interactionsPage.getMainText();
        softAssert.assertEquals(actualString, expectedString, "\nWrong text.\n");

        boolean TextBoxIsVisible = interactionsPage.verifySortableIsVisible();
        softAssert.assertTrue(TextBoxIsVisible, "\nFrames is not shown.\n");

        interactionsPage.clickInteractions();

        TextBoxIsVisible = interactionsPage.verifyFramesIsNotVisible();
        softAssert.assertFalse(TextBoxIsVisible, "\nFrames is shown.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify nine pages links")
    public void CheckAllNinePagesLinks() {
        // Arrange
        navigateToUrl("interaction");
        InteractionsPage interactionsPage = new InteractionsPage(driver);

        String expectedUrl = "https://demoqa.com/sortable";
        interactionsPage.clickSortable();
        String actualUrl = interactionsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url for sortable page.\n");

        expectedUrl = "https://demoqa.com/selectable";
        interactionsPage.clickSelectable();
        actualUrl = interactionsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url for selectable page.\n");

        expectedUrl = "https://demoqa.com/resizable";
        interactionsPage.clickResizable();
        actualUrl = interactionsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url for resizable page.\n");

        expectedUrl = "https://demoqa.com/droppable";
        interactionsPage.clickDroppable();
        actualUrl = interactionsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url for droppable page.\n");

        expectedUrl = "https://demoqa.com/dragabble";
        interactionsPage.clickDraggable();
        actualUrl = interactionsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url for draggable page.\n");

        softAssert.assertAll();
    }
}
