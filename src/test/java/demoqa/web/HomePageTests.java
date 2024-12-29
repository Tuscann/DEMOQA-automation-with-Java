package demoqa.web;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void ClickAndVerifyAllLinks() {
        String expectedUrl = "https://demoqa.com/elements";
        homePage.goToElements();
        String actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/forms";
        homePage.goToForms();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/alertsWindows";
        homePage.goToAlertsFramesWindowsCard();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/widgets";
        homePage.goToWidgets();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/interaction";
        homePage.goToInteractions();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/books";
        homePage.goToBooks();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void VerifyAllTextOnPage() {
        String expectedFooterText = "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.";
        String expectedElementsText = "Elements";
        String expectedFormsText = "Forms";
        String expectedAlertsText = "Alerts, Frame & Windows";
        String expectedWidgetsText = "Widgets";
        String expectedInteractionText = "Interactions";
        String expectedBooksText = "Book Store Application";

        String actualFooterText = homePage.getFooterText();
        String actualElementsText = homePage.getElementsText();
        String actualFormsText = homePage.getFormsText();
        String actualAlertsText = homePage.getAlertsText();
        String actualWidgetsText = homePage.getWidgetsText();
        String actualInteractionText = homePage.getInteractionsText();
        String actualBooksText = homePage.getBookStoreApplicationText();

        Assert.assertEquals(actualFooterText, expectedFooterText);
        Assert.assertEquals(actualElementsText, expectedElementsText);
        Assert.assertEquals(actualFormsText, expectedFormsText);
        Assert.assertEquals(actualAlertsText, expectedAlertsText);
        Assert.assertEquals(actualWidgetsText, expectedWidgetsText);
        Assert.assertEquals(actualInteractionText, expectedInteractionText);
        Assert.assertEquals(actualBooksText, expectedBooksText);
    }
}
