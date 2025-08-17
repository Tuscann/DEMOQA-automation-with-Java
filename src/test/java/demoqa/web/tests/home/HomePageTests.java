package demoqa.web.tests.home;

import demoqa.pages.home.HomePage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    private static final String ELEMENTS_URL = "https://demoqa.com/elements";
    private static final String FORMS_URL = "https://demoqa.com/forms";
    private static final String ALERTS_WINDOWS_URL = "https://demoqa.com/alertsWindows";
    private static final String WIDGETS_URL = "https://demoqa.com/widgets";
    private static final String INTERACTION_URL = "https://demoqa.com/interaction";
    private static final String BOOKS_URL = "https://demoqa.com/books";
    private static final String SELENIUM_TRAINING_URL = "https://www.toolsqa.com/selenium-training/";

    private static final String ELEMENTS_TEXT = "Elements";
    private static final String FORMS_TEXT = "Forms";
    private static final String ALERTS_TEXT = "Alerts, Frame & Windows";
    private static final String WIDGETS_TEXT = "Widgets";
    private static final String INTERACTIONS_TEXT = "Interactions";
    private static final String BOOKS_TEXT = "Book Store Application";
    private static final String FOOTER_TEXT = "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.";

    @Test(enabled = true, testName = "Click and verify all links")
    public void ClickAndVerifyAllLinks() {

        HomePage homePage = new HomePage(driver);

        homePage.goToElements();
        String actualUrl = homePage.checkUrl();
        softAssert.assertEquals(actualUrl, ELEMENTS_URL, "\nExpected elements page.\n");

        homePage.navigateBack();

        homePage.goToForms();
        actualUrl = homePage.checkUrl();
        softAssert.assertEquals(actualUrl, FORMS_URL, "\nExpected forms page.\n");

        homePage.navigateBack();

        homePage.goToAlertsFramesWindowsCard();
        actualUrl = homePage.checkUrl();
        softAssert.assertEquals(actualUrl, ALERTS_WINDOWS_URL, "\nExpected alerts page.\n");

        homePage.navigateBack();

        homePage.goToWidgets();
        actualUrl = homePage.checkUrl();
        softAssert.assertEquals(actualUrl, WIDGETS_URL, "\nExpected widgets page.\n");

        homePage.navigateBack();

        homePage.goToInteractions();
        actualUrl = homePage.checkUrl();
        softAssert.assertEquals(actualUrl, INTERACTION_URL, "\nExpected Interaction page.\n");

        homePage.navigateBack();

        homePage.goToBooks();
        actualUrl = homePage.checkUrl();
        softAssert.assertEquals(actualUrl, BOOKS_URL, "\nExpected books page.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        // Arrange
        HomePage homePage = new HomePage(driver);

        // Act
        String actualFooterText = homePage.getFooterText();
        String actualElementsText = homePage.getElementsText();
        String actualFormsText = homePage.getFormsText();
        String actualAlertsText = homePage.getAlertsText();
        String actualWidgetsText = homePage.getWidgetsText();
        String actualInteractionText = homePage.getInteractionsText();
        String actualBooksText = homePage.getBookStoreApplicationText();

        // Assert
        softAssert.assertEquals(actualElementsText, ELEMENTS_TEXT, "\nExpected elements text.\n");
        softAssert.assertEquals(actualFormsText, FORMS_TEXT, "\nExpected forms text.\n");
        softAssert.assertEquals(actualAlertsText, ALERTS_TEXT, "\nExpected alerts text.\n");
        softAssert.assertEquals(actualWidgetsText, WIDGETS_TEXT, "\nExpected widgets text.\n");
        softAssert.assertEquals(actualInteractionText, INTERACTIONS_TEXT, "\nExpected interaction text.\n");
        softAssert.assertEquals(actualBooksText, BOOKS_TEXT, "\nExpected books text.\n");
        softAssert.assertEquals(actualFooterText, FOOTER_TEXT, "\nExpected footer text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify Join Now button navigates correctly.")
    public void VerifyJoinNowButton() {
        // Arrange
        HomePage homePage = new HomePage(driver);

        // Act
        String originalWindow = driver.getWindowHandle();
        homePage.clickJoinNowButton();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        
        String currentUrl = driver.getCurrentUrl();

        // Assert
        softAssert.assertEquals(SELENIUM_TRAINING_URL,currentUrl);
        softAssert.assertAll();
    }
}