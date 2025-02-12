package demoqa.web.test.interactions;

import demoqa.web.BaseTest;
import org.testng.annotations.Test;

public class InteractionPageTests extends BaseTest {

    @Test(enabled = true, testName = "Click left dropdown menu")
    public void ClickLeftDropdownMenu() {
        navigateToUrl("interaction");

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
        navigateToUrl("interaction");

        String expectedUrl = "https://demoqa.com/sortable";
        interactionsPage.clickSortable();
        String actualUrl = widgetsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url for sortable page.\n");

        expectedUrl = "https://demoqa.com/selectable";
        interactionsPage.clickSelectable();
        actualUrl = widgetsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url for selectable page.\n");

        expectedUrl = "https://demoqa.com/resizable";
        interactionsPage.clickResizable();
        actualUrl = widgetsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url for resizable page.\n");

        expectedUrl = "https://demoqa.com/droppable";
        interactionsPage.clickDroppable();
        actualUrl = widgetsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url for droppable page.\n");

        expectedUrl = "https://demoqa.com/dragabble";
        interactionsPage.clickDraggable();
        actualUrl = widgetsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url for draggable page.\n");

        softAssert.assertAll();
    }
}
