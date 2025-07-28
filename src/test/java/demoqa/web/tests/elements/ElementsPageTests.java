package demoqa.web.tests.elements;

import demoqa.pages.elements.ElementsPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.Test;

public class ElementsPageTests extends BaseTest {

    @Test(enabled = true, testName = "Check nine pages links")
    public void CheckAllNinePagesLinks() {
        // Arrange
        navigateToUrl("elements");
        ElementsPage elementsPage = new ElementsPage(driver);

        String expectedTextBoxUrl = "https://demoqa.com/text-box";
        String expectedCheckBoxUrl = "https://demoqa.com/checkbox";
        String expectedRadioButtonUrl = "https://demoqa.com/radio-button";
        String expectedWebtablesUrl = "https://demoqa.com/webtables";
        String expectedButtonsUrl = "https://demoqa.com/buttons";
        String expectedLinksUrl = "https://demoqa.com/links";
        String expectedBrokenUrl = "https://demoqa.com/broken";
        String expectedUploadDownloadUrl = "https://demoqa.com/upload-download";
        String expectedDynamicPropertiesUrl = "https://demoqa.com/dynamic-properties";

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
        softAssert.assertEquals(actualTextBoxUrl, expectedTextBoxUrl, "\nWrong text-box url is shown.\n");
        softAssert.assertEquals(actualCheckBoxUrl, expectedCheckBoxUrl, "\nWrong checkbox url is shown.\n");
        softAssert.assertEquals(actualRadioButtonUrl, expectedRadioButtonUrl, "\nWrong radio-button url is shown.\n");
        softAssert.assertEquals(actualWebTablesUrl, expectedWebtablesUrl, "\nWrong webtables url is shown.\n");
        softAssert.assertEquals(actualButtonsUrl, expectedButtonsUrl, "\nWrong buttons url is shown.\n");
        softAssert.assertEquals(actualLinksUrl, expectedLinksUrl, "\nWrong links url is shown.\n");
        softAssert.assertEquals(actualBrokenUrl, expectedBrokenUrl, "\nWrong broken url is shown.\n");
        softAssert.assertEquals(actualUploadDownloadUrl, expectedUploadDownloadUrl, "\nWrong upload-download url is shown.\n");
        softAssert.assertEquals(actualDynamicPropertiesUrl, expectedDynamicPropertiesUrl, "\nWrong dynamic-properties url is shown.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click left dropdown menu")
    public void ClickLeftDropdownMenu() {
        // Arrange
        navigateToUrl("elements");
        ElementsPage elementsPage = new ElementsPage(driver);
        String actualString = "Please select an item from left to start practice.";

        // Act
        String expectedString = elementsPage.getText();
        boolean TextBoxIsVisible = elementsPage.verifyTextBoxIsVisible();
        elementsPage.clickElements();
        boolean TextBoxIsVisible2 = elementsPage.verifyTextBoxIsNotVisible();

        // Assert
        softAssert.assertEquals(expectedString, actualString, "\nWrong text is shown.\n");
        softAssert.assertTrue(TextBoxIsVisible, "\nDropDown in not shown.\n");
        softAssert.assertFalse(TextBoxIsVisible2, "\nDropDown in shown.\n");
        softAssert.assertAll();
    }
}
