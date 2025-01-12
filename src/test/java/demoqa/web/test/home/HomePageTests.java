package demoqa.web.test.home;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test(enabled = true)
    public void ClickAndVerifyAllLinks() {
        String expectedUrl = "https://demoqa.com/elements";
        homePage.goToElements();
        String actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected elements page.\n");

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/forms";
        homePage.goToForms();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected forms page.\n");

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/alertsWindows";
        homePage.goToAlertsFramesWindowsCard();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected alerts page.\n");

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/widgets";
        homePage.goToWidgets();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected widgets page.\n");

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/interaction";
        homePage.goToInteractions();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected Interaction page.\n");

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/books";
        homePage.goToBooks();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nExpected books page.\n");
    }

    @Test(enabled = true)
    public void VerifyAllTextOnPage() {
        String expectedElementsText = "Elements";
        String expectedFormsText = "Forms";
        String expectedAlertsText = "Alerts, Frame & Windows";
        String expectedWidgetsText = "Widgets";
        String expectedInteractionText = "Interactions";
        String expectedBooksText = "Book Store Application";
        String expectedFooterText = "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.";

        String actualFooterText = homePage.getFooterText();
        String actualElementsText = homePage.getElementsText();
        String actualFormsText = homePage.getFormsText();
        String actualAlertsText = homePage.getAlertsText();
        String actualWidgetsText = homePage.getWidgetsText();
        String actualInteractionText = homePage.getInteractionsText();
        String actualBooksText = homePage.getBookStoreApplicationText();

        Assert.assertEquals(actualElementsText, expectedElementsText, "\nExpected elements.\n");
        Assert.assertEquals(actualFormsText, expectedFormsText, "\nExpected forms.\n");
        Assert.assertEquals(actualAlertsText, expectedAlertsText, "\nExpected Alerts.\n");
        Assert.assertEquals(actualWidgetsText, expectedWidgetsText, "\nExpected widgets.\n");
        Assert.assertEquals(actualInteractionText, expectedInteractionText, "\nExpected interaction.\n");
        Assert.assertEquals(actualBooksText, expectedBooksText, "\nExpected books.\n");
        Assert.assertEquals(actualFooterText, expectedFooterText, "\nExpected footer.\n");
    }
}