package demoqa.web.tests.home;

import demoqa.pages.home.HomePage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    private HomePage homePage;

    @BeforeMethod
    public void goToDraggablePage() {
        homePage = new HomePage(driver);
    }

    @DataProvider(name = "homePageCards")
    public Object[][] homePageCards() {
        return new Object[][]{
                {"Elements", ELEMENTS_URL, (Runnable) () -> homePage.goToElements()},
                {"Forms", FORMS_URL, (Runnable) () -> homePage.goToForms()},
                {"Alerts", ALERTS_WINDOWS_URL, (Runnable) () -> homePage.goToAlertsFramesWindowsCard()},
                {"Widgets", WIDGETS_URL, (Runnable) () -> homePage.goToWidgets()},
                {"Interactions", INTERACTION_URL, (Runnable) () -> homePage.goToInteractions()},
                {"Book Store", BOOKS_URL, (Runnable) () -> homePage.goToBooks()}
        };
    }

    @Test(dataProvider = "homePageCards", testName = "Click and verify card: {0} ")
    public void clickAndVerifyCardNavigation(String cardName, String expectedUrl, Runnable clickAction) {
        clickAction.run();
        String actualUrl = homePage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nFailed for card: " + cardName);
        softAssert.assertAll();
        homePage.navigateBack();
    }

    @Test(enabled = true, testName = "Verify all text on page")
    public void verifyAllHomePageTexts() {
        // Arrange
        // Act
        // Assert
        softAssert.assertEquals(homePage.getElementsText(), ELEMENTS_TEXT, "\nExpected elements text.\n");
        softAssert.assertEquals(homePage.getFormsText(), FORMS_TEXT, "\nExpected forms text.\n");
        softAssert.assertEquals(homePage.getAlertsText(), ALERTS_TEXT, "\nExpected alerts text.\n");
        softAssert.assertEquals(homePage.getWidgetsText(), WIDGETS_TEXT, "\nExpected widgets text.\n");
        softAssert.assertEquals(homePage.getInteractionsText(), INTERACTIONS_TEXT, "\nExpected interaction text.\n");
        softAssert.assertEquals(homePage.getBookStoreApplicationText(), BOOKS_TEXT, "\nExpected books text.\n");
        softAssert.assertEquals(homePage.getFooterText(), FOOTER_TEXT, "\nExpected footer text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Verify Join Now button navigates correctly.")
    public void verifyJoinNowButton() {
        // Arrange & Act
        String originalWindow = driver.getWindowHandle();
        homePage.clickJoinNowButton();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String actualUrl = driver.getCurrentUrl();

        // Assert
        softAssert.assertEquals(actualUrl, SELENIUM_TRAINING_URL);
        softAssert.assertAll();
    }
}