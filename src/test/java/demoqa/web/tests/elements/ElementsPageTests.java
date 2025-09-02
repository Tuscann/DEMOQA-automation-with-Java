package demoqa.web.tests.elements;

import demoqa.pages.elements.ElementsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ElementsPageTests extends BaseTest {
    // URL Constants
    private static final String TEXT_BOX_URL = DEMO_QA_URL + "text-box";
    private static final String CHECK_BOX_URL = DEMO_QA_URL + "checkbox";
    private static final String RADIO_BUTTON_URL = DEMO_QA_URL + "radio-button";
    private static final String WEB_TABLES_URL = DEMO_QA_URL + "webtables";
    private static final String BUTTONS_URL = DEMO_QA_URL + "buttons";
    private static final String LINKS_URL = DEMO_QA_URL + "links";
    private static final String BROKEN_LINKS_IMAGES_URL = DEMO_QA_URL + "broken";
    private static final String UPLOAD_DOWNLOAD_URL = DEMO_QA_URL + "upload-download";
    private static final String DYNAMIC_PROPERTIES_URL = DEMO_QA_URL + "dynamic-properties";

    // Text Constants
    private static final String MAIN_TEXT = "Please select an item from left to start practice.";

    // Error Message Constants
    private static final String HOME_ADDRESS_ERROR = "Wrong home address";
    private static final String LEFT_PANEL_TEXT_MISMATCH = "Left panel text mismatch";
    private static final String DROPDOWN_NOT_VISIBLE_ERROR = "Dropdown menu is not visible";
    private static final String DROPDOWN_STILL_VISIBLE_ERROR = "Dropdown menu is still visible after clicking";
    private static final String CARD_NAVIGATION_ERROR = "Failed for card: %s";
    private static final String ELEMENTS_URL = "elements";
    private ElementsPage elementsPage;

    @BeforeMethod
    public void goToProfilePage() {
        navigateToUrl(ELEMENTS_URL);
        elementsPage = new ElementsPage(driver);
    }

    @DataProvider(name = "homePageCards")
    public Object[][] homePageCards() {
        return new Object[][]{
                {"Text Box", TEXT_BOX_URL, (Runnable) () -> elementsPage.clickLeftTabTextBox()},
                {"Check Box", CHECK_BOX_URL, (Runnable) () -> elementsPage.clickCheckBox()},
                {"Radio Button", RADIO_BUTTON_URL, (Runnable) () -> elementsPage.clickRadioButton()},
                {"Web Tables", WEB_TABLES_URL, (Runnable) () -> elementsPage.clickWebTables()},
                {"Buttons", BUTTONS_URL, (Runnable) () -> elementsPage.clickButtons()},
                {"Links", LINKS_URL, (Runnable) () -> elementsPage.clickLinks()},
                {"Broken Links - Images", BROKEN_LINKS_IMAGES_URL, (Runnable) () -> elementsPage.clickBrokenLinksImages()},
                {"Upload and Download", UPLOAD_DOWNLOAD_URL, (Runnable) () -> elementsPage.clickUploadAndDownload()},
                {"Dynamic Properties", DYNAMIC_PROPERTIES_URL, (Runnable) () -> elementsPage.clickDynamicProperties()},
        };
    }

    @Test(dataProvider = "homePageCards", description = "Click and verify card: {0} ")
    public void checkAllFivePagesLinks(String cardName, String expectedUrl, Runnable clickAction) {
        // Arrange & Act
        clickAction.run();
        String actualUrl = elementsPage.checkCurrentUrl();
        elementsPage.clickTopImage();
        String url = elementsPage.checkCurrentUrl();

        // Assert
        softAssert.assertEquals(actualUrl, expectedUrl, String.format(CARD_NAVIGATION_ERROR, cardName));
        softAssert.assertEquals(url, DEMO_QA_URL, HOME_ADDRESS_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Test left dropdown menu functionality and visibility states")
    public void clickLeftDropdownMenu() {
        // Arrange & Act
        String expectedString = elementsPage.getText();
        boolean textBoxTabIsVisible = elementsPage.verifyTextBoxTabIsVisible();
        elementsPage.clickElements();
        boolean textBoxIsVisible2 = elementsPage.verifyTextBoxIsNotVisible();

        // Assert
        softAssert.assertEquals(expectedString, MAIN_TEXT, LEFT_PANEL_TEXT_MISMATCH);
        softAssert.assertTrue(textBoxTabIsVisible, DROPDOWN_NOT_VISIBLE_ERROR);
        softAssert.assertFalse(textBoxIsVisible2, DROPDOWN_STILL_VISIBLE_ERROR);
        softAssert.assertAll();
    }
}
