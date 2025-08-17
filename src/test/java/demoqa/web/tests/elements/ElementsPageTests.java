package demoqa.web.tests.elements;

import demoqa.pages.elements.ElementsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsPageTests extends BaseTest {
    private static final String TEXT_BOX_URL = "https://demoqa.com/text-box";
    private static final String CHECK_BOX_URL = "https://demoqa.com/checkbox";
    private static final String RADIO_BUTTON_URL = "https://demoqa.com/radio-button";
    private static final String WEB_TABLES_URL = "https://demoqa.com/webtables";
    private static final String BUTTONS_URL = "https://demoqa.com/buttons";
    private static final String LINKS_URL = "https://demoqa.com/links";
    private static final String BROKEN_URL = "https://demoqa.com/broken";
    private static final String UPLOAD_DOWNLOAD_URL = "https://demoqa.com/upload-download";
    private static final String DYNAMIC_PROPERTIES_URL = "https://demoqa.com/dynamic-properties";
    private static final String LEFT_PANEL_INFO_TEXT = "Please select an item from left to start practice.";

    private static final String ELEMENTS_URL = "elements";
    private ElementsPage elementsPage;

    @BeforeMethod
    public void goToProfilePage() {
        navigateToUrl(ELEMENTS_URL);
        elementsPage = new ElementsPage(driver);
    }

    @Test(enabled = true, testName = "Check nine pages links")
    public void CheckAllNinePagesLinks() {
        // Arrange
        // Act
        elementsPage.clickTextBox();
        String actualTextBoxUrl = elementsPage.checkUrl();

        elementsPage.clickCheckBox();
        String actualCheckBoxUrl = elementsPage.checkUrl();

        elementsPage.clickRadioButton();
        String actualRadioButtonUrl = elementsPage.checkUrl();

        elementsPage.clickWebTables();
        String actualWebTablesUrl = elementsPage.checkUrl();

        elementsPage.clickButtons();
        String actualButtonsUrl = elementsPage.checkUrl();

        elementsPage.clickLinks();
        String actualLinksUrl = elementsPage.checkUrl();

        elementsPage.clickBrokenLinksImages();
        String actualBrokenUrl = elementsPage.checkUrl();

        elementsPage.clickUploadAndDownload();
        String actualUploadDownloadUrl = elementsPage.checkUrl();

        elementsPage.clickDynamicProperties();
        String actualDynamicPropertiesUrl = elementsPage.checkUrl();

        // Assert
        softAssert.assertEquals(actualTextBoxUrl, TEXT_BOX_URL, "\nWrong text-box url is shown.\n");
        softAssert.assertEquals(actualCheckBoxUrl, CHECK_BOX_URL, "\nWrong checkbox url is shown.\n");
        softAssert.assertEquals(actualRadioButtonUrl, RADIO_BUTTON_URL, "\nWrong radio-button url is shown.\n");
        softAssert.assertEquals(actualWebTablesUrl, WEB_TABLES_URL, "\nWrong webtables url is shown.\n");
        softAssert.assertEquals(actualButtonsUrl, BUTTONS_URL, "\nWrong buttons url is shown.\n");
        softAssert.assertEquals(actualLinksUrl, LINKS_URL, "\nWrong links url is shown.\n");
        softAssert.assertEquals(actualBrokenUrl, BROKEN_URL, "\nWrong broken url is shown.\n");
        softAssert.assertEquals(actualUploadDownloadUrl, UPLOAD_DOWNLOAD_URL, "\nWrong upload-download url is shown.\n");
        softAssert.assertEquals(actualDynamicPropertiesUrl, DYNAMIC_PROPERTIES_URL, "\nWrong dynamic-properties url is shown.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click left dropdown menu")
    public void ClickLeftDropdownMenu() {
        // Arrange
        // Act
        String expectedString = elementsPage.getText();
        boolean TextBoxIsVisible = elementsPage.verifyTextBoxIsVisible();
        elementsPage.clickElements();
        boolean TextBoxIsVisible2 = elementsPage.verifyTextBoxIsNotVisible();

        // Assert
        softAssert.assertEquals(expectedString, LEFT_PANEL_INFO_TEXT, "\nWrong text is shown.\n");
        softAssert.assertTrue(TextBoxIsVisible, "\nDropDown in not shown.\n");
        softAssert.assertFalse(TextBoxIsVisible2, "\nDropDown in shown.\n");
        softAssert.assertAll();
    }
}
