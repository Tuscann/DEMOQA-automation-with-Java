package demoqa.web.test.interactions;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InteractionPageTests extends BaseTest {

    @Test(enabled = true)
    public void CheckAllNinePagesLinks() {
        navigateToUrl("interaction");

        String expectedString = "Please select an item from left to start practice.";
        String actualString = interactionsPage.getMainText();
        Assert.assertEquals(actualString, expectedString, "Wrong text");

        String expectedUrl = "https://demoqa.com/sortable";
        interactionsPage.clickSortable();
        String actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nWrong url for sortable page.\n");

        expectedUrl = "https://demoqa.com/selectable";
        interactionsPage.clickSelectable();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nWrong url for selectable page.\n");

        expectedUrl = "https://demoqa.com/resizable";
        interactionsPage.clickResizable();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nWrong url for resizable page.\n");

        expectedUrl = "https://demoqa.com/droppable";
        interactionsPage.clickDroppable();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nWrong url for droppable page.\n");

        expectedUrl = "https://demoqa.com/dragabble";
        interactionsPage.clickDraggable();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nWrong url for draggable page.\n");
    }
}
