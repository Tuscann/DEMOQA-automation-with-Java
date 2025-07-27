package demoqa.web.tests.home;

import demoqa.pages.home.HomePage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class HomePageTests extends BaseTest {

    @Test(enabled = true, testName = "Click and verify all links")
    public void ClickAndVerifyAllLinks() {

        HomePage homePage = new HomePage(driver);

        String expectedUrl = "https://demoqa.com/elements";
        homePage.goToElements();
        String actualUrl = homePage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nExpected elements page.\n");

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/forms";
        homePage.goToForms();
        actualUrl = homePage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nExpected forms page.\n");

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/alertsWindows";
        homePage.goToAlertsFramesWindowsCard();
        actualUrl = homePage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nExpected alerts page.\n");

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/widgets";
        homePage.goToWidgets();
        actualUrl = homePage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nExpected widgets page.\n");

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/interaction";
        homePage.goToInteractions();
        actualUrl = homePage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nExpected Interaction page.\n");

        homePage.navigateBack();

        expectedUrl = "https://demoqa.com/books";
        homePage.goToBooks();
        actualUrl = homePage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nExpected books page.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        HomePage homePage = new HomePage(driver);

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

        softAssert.assertEquals(actualElementsText, expectedElementsText, "\nExpected elements.\n");
        softAssert.assertEquals(actualFormsText, expectedFormsText, "\nExpected forms.\n");
        softAssert.assertEquals(actualAlertsText, expectedAlertsText, "\nExpected Alerts.\n");
        softAssert.assertEquals(actualWidgetsText, expectedWidgetsText, "\nExpected widgets.\n");
        softAssert.assertEquals(actualInteractionText, expectedInteractionText, "\nExpected interaction.\n");
        softAssert.assertEquals(actualBooksText, expectedBooksText, "\nExpected books.\n");
        softAssert.assertEquals(actualFooterText, expectedFooterText, "\nExpected footer.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyJoinNowButton() {
        HomePage homePage = new HomePage(driver);

        homePage.clickJoinNow();

        String expectedUrl = "https://www.toolsqa.com/selenium-training/";
        String currentUrl = driver.getCurrentUrl();

        softAssert.assertEquals(expectedUrl,currentUrl);
    }
}