package part3.comdemoqa.tests.interactions;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class InteractionPageTests extends BaseTest {

    @Test
    public void CheckAllNinePagesLinks() {
        navigateToUrl("interaction");

        String expectedString = "Please select an item from left to start practice.";
        String actualString = interactionsPage.getMainText();
        Assert.assertEquals(actualString, expectedString, "Wrong text");

        String expectedUrl = "https://demoqa.com/sortable";
        interactionsPage.clickSortable();
        String actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/selectable";
        interactionsPage.clickSelectable();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/resizable";
        interactionsPage.clickResizable();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/droppable";
        interactionsPage.clickDroppable();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/dragabble";
        interactionsPage.clickDragabble();
        actualUrl = widgetsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
