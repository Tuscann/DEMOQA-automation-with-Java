package demoqa.web.tests.elements;

import demoqa.pages.elements.ElementsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
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
    private static final String LEFT_PANEL_INFO_TEXT = "Please select an item from left to start practice.";

    // Error Message Constants
    private static final String TEXT_BOX_URL_MISMATCH = "Text box URL mismatch";
    private static final String CHECK_BOX_URL_MISMATCH = "Checkbox URL mismatch";
    private static final String RADIO_BUTTON_URL_MISMATCH = "Radio button URL mismatch";
    private static final String WEB_TABLES_URL_MISMATCH = "Web tables URL mismatch";
    private static final String BUTTONS_URL_MISMATCH = "Buttons URL mismatch";
    private static final String LINKS_URL_MISMATCH = "Links URL mismatch";
    private static final String BROKEN_LINKS_IMAGES_URL_MISMATCH = "Broken links URL mismatch";
    private static final String UPLOAD_DOWNLOAD_URL_MISMATCH = "Upload and download URL mismatch";
    private static final String DYNAMIC_PROPERTIES_URL_MISMATCH = "Dynamic properties URL mismatch";
    private static final String LEFT_PANEL_TEXT_MISMATCH = "Left panel text mismatch";
    private static final String DROPDOWN_NOT_VISIBLE_ERROR = "Dropdown menu is not visible";
    private static final String DROPDOWN_STILL_VISIBLE_ERROR = "Dropdown menu is still visible after clicking";

    private ElementsPage elementsPage;
    private static final String ELEMENTS_URL = "elements";

    @BeforeMethod
    public void goToProfilePage() {
        navigateToUrl(ELEMENTS_URL);
        elementsPage = new ElementsPage(driver);
    }

    @Test(enabled = true, description = "Verify navigation to all nine element pages and validate URLs")
    public void verifyAllNinePagesLinks() {
        // Arrange & Act
        elementsPage.clickLeftTabTextBox();
        String actualTextBoxUrl = elementsPage.checkCurrentUrl();

        elementsPage.clickCheckBox();
        String actualCheckBoxUrl = elementsPage.checkCurrentUrl();

        elementsPage.clickRadioButton();
        String actualRadioButtonUrl = elementsPage.checkCurrentUrl();

        elementsPage.clickWebTables();
        String actualWebTablesUrl = elementsPage.checkCurrentUrl();

        elementsPage.clickButtons();
        String actualButtonsUrl = elementsPage.checkCurrentUrl();

        elementsPage.clickLinks();
        String actualLinksUrl = elementsPage.checkCurrentUrl();

        elementsPage.clickBrokenLinksImages();
        String actualBrokenUrl = elementsPage.checkCurrentUrl();

        elementsPage.clickUploadAndDownload();
        String actualUploadDownloadUrl = elementsPage.checkCurrentUrl();

        elementsPage.clickDynamicProperties();
        String actualDynamicPropertiesUrl = elementsPage.checkCurrentUrl();

        // Assert
        softAssert.assertEquals(actualTextBoxUrl, TEXT_BOX_URL, TEXT_BOX_URL_MISMATCH);
        softAssert.assertEquals(actualCheckBoxUrl, CHECK_BOX_URL, CHECK_BOX_URL_MISMATCH);
        softAssert.assertEquals(actualRadioButtonUrl, RADIO_BUTTON_URL, RADIO_BUTTON_URL_MISMATCH);
        softAssert.assertEquals(actualWebTablesUrl, WEB_TABLES_URL, WEB_TABLES_URL_MISMATCH);
        softAssert.assertEquals(actualButtonsUrl, BUTTONS_URL, BUTTONS_URL_MISMATCH);
        softAssert.assertEquals(actualLinksUrl, LINKS_URL, LINKS_URL_MISMATCH);
        softAssert.assertEquals(actualBrokenUrl, BROKEN_LINKS_IMAGES_URL, BROKEN_LINKS_IMAGES_URL_MISMATCH);
        softAssert.assertEquals(actualUploadDownloadUrl, UPLOAD_DOWNLOAD_URL, UPLOAD_DOWNLOAD_URL_MISMATCH);
        softAssert.assertEquals(actualDynamicPropertiesUrl, DYNAMIC_PROPERTIES_URL, DYNAMIC_PROPERTIES_URL_MISMATCH);
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
        softAssert.assertEquals(expectedString, LEFT_PANEL_INFO_TEXT, LEFT_PANEL_TEXT_MISMATCH);
        softAssert.assertTrue(textBoxTabIsVisible, DROPDOWN_NOT_VISIBLE_ERROR);
        softAssert.assertFalse(textBoxIsVisible2, DROPDOWN_STILL_VISIBLE_ERROR);
        softAssert.assertAll();
    }
}
