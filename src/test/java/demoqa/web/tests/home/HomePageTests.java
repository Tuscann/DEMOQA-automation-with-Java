package demoqa.web.tests.home;

import demoqa.pages.home.HomePage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {
    private static final String ELEMENTS_URL = DEMO_QA_URL + "elements";
    private static final String FORMS_URL = DEMO_QA_URL + "forms";
    private static final String ALERTS_WINDOWS_URL = DEMO_QA_URL + "alertsWindows";
    private static final String WIDGETS_URL = DEMO_QA_URL + "widgets";
    private static final String INTERACTION_URL = DEMO_QA_URL + "interaction";
    private static final String BOOKS_URL = DEMO_QA_URL + "books";
    private static final String SELENIUM_TRAINING_URL = "https://www.toolsqa.com/selenium-training/";

    private static final String ELEMENTS_TEXT = "Elements";
    private static final String FORMS_TEXT = "Forms";
    private static final String ALERTS_TEXT = "Alerts, Frame & Windows";
    private static final String WIDGETS_TEXT = "Widgets";
    private static final String INTERACTIONS_TEXT = "Interactions";
    private static final String BOOKS_TEXT = "Book Store Application";
    private static final String FOOTER_TEXT = "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.";

    // Error Message Constants
    private static final String CARD_NAVIGATION_ERROR = "Failed for card: %s";
    private static final String ELEMENTS_TEXT_ERROR = "Elements card text mismatch";
    private static final String FORMS_TEXT_ERROR = "Forms card text mismatch";
    private static final String ALERTS_TEXT_ERROR = "Alerts card text mismatch";
    private static final String WIDGETS_TEXT_ERROR = "Widgets card text mismatch";
    private static final String INTERACTIONS_TEXT_ERROR = "Interactions card text mismatch";
    private static final String BOOKS_TEXT_ERROR = "Books card text mismatch";
    private static final String FOOTER_TEXT_ERROR = "Footer text mismatch";
    private static final String SELENIUM_TRAINING_URL_ERROR = "Selenium training URL mismatch";

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
                {"Alerts Frame Windows", ALERTS_WINDOWS_URL, (Runnable) () -> homePage.goToAlertsFramesWindowsCard()},
                {"Widgets", WIDGETS_URL, (Runnable) () -> homePage.goToWidgets()},
                {"Interactions", INTERACTION_URL, (Runnable) () -> homePage.goToInteractions()},
                {"Book Store", BOOKS_URL, (Runnable) () -> homePage.goToBooks()}
        };
    }

    @Test(dataProvider = "homePageCards", description = "Click and verify card: {0} ")
    public void clickAndVerifyCardNavigation(String cardName, String expectedUrl, Runnable clickAction) {
        // Arrange & Act
        clickAction.run();
        String actualUrl = homePage.checkCurrentUrl();
        // Assert
        softAssert.assertEquals(actualUrl, expectedUrl, String.format(CARD_NAVIGATION_ERROR, cardName));
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify all text on page")
    public void verifyAllHomePageTexts() {
        // Arrange & Act & Assert
        softAssert.assertEquals(homePage.getElementsText(), ELEMENTS_TEXT, ELEMENTS_TEXT_ERROR);
        softAssert.assertEquals(homePage.getFormsText(), FORMS_TEXT, FORMS_TEXT_ERROR);
        softAssert.assertEquals(homePage.getAlertsFramesWindowsText(), ALERTS_TEXT, ALERTS_TEXT_ERROR);
        softAssert.assertEquals(homePage.getWidgetsText(), WIDGETS_TEXT, WIDGETS_TEXT_ERROR);
        softAssert.assertEquals(homePage.getInteractionsText(), INTERACTIONS_TEXT, INTERACTIONS_TEXT_ERROR);
        softAssert.assertEquals(homePage.getBookStoreApplicationText(), BOOKS_TEXT, BOOKS_TEXT_ERROR);
        softAssert.assertEquals(homePage.getFooterText(), FOOTER_TEXT, FOOTER_TEXT_ERROR);

        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Verify Join Now button navigates correctly.")
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
        softAssert.assertEquals(actualUrl, SELENIUM_TRAINING_URL, SELENIUM_TRAINING_URL_ERROR);
        softAssert.assertAll();
    }
}