package demoqa.web.tests.elements;

import demoqa.pages.elements.ElementsPage;
import demoqa.web.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementsPageTests extends BaseTest {

    @Test(enabled = true, testName = "Check nine pages links")
    public void CheckAllNinePagesLinks() {
        navigateToUrl("elements");

        ElementsPage elementsPage = new ElementsPage(driver);

        String expectedUrl = "https://demoqa.com/text-box";
        elementsPage.clickTextBox();
        String actualUrl = elementsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url is shown.\n");

        expectedUrl = "https://demoqa.com/checkbox";
        elementsPage.clickCheckBox();
        actualUrl = elementsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url is shown.\n");

        expectedUrl = "https://demoqa.com/radio-button";
        elementsPage.clickRadioButton();
        actualUrl = elementsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url is shown.\n");

        expectedUrl = "https://demoqa.com/webtables";
        elementsPage.clickWebTables();
        actualUrl = elementsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url is shown.\n");

        expectedUrl = "https://demoqa.com/buttons";
        elementsPage.clickButtons();
        actualUrl = elementsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url is shown.\n");

        expectedUrl = "https://demoqa.com/links";
        elementsPage.clickLinks();
        actualUrl = elementsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url is shown.\n");

        expectedUrl = "https://demoqa.com/broken";
        elementsPage.clickBrokenLinksImages();
        actualUrl = elementsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url is shown.\n");

        expectedUrl = "https://demoqa.com/upload-download";
        elementsPage.clickUploadAndDownload();
        actualUrl = elementsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url is shown.\n");

        expectedUrl = "https://demoqa.com/dynamic-properties";
        elementsPage.clickDynamicProperties();
        actualUrl = elementsPage.checkUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "\nWrong url is shown.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click left dropdown menu")
    public void ClickLeftDropdownMenu() {
        navigateToUrl("elements");
        ElementsPage elementsPage = new ElementsPage(driver);

        String actualString = "Please select an item from left to start practice.";
        String expectedString = elementsPage.getText();
        softAssert.assertEquals(expectedString, actualString, "\nWrong text is shown.\n");

        boolean TextBoxIsVisible = elementsPage.verifyTextBoxIsVisible();
        softAssert.assertTrue(TextBoxIsVisible, "\nDropDown in not shown.\n");

        elementsPage.clickElements();

        TextBoxIsVisible = elementsPage.verifyTextBoxIsNotVisible();
        softAssert.assertFalse(TextBoxIsVisible, "\nDropDown in shown.\n");

        softAssert.assertAll();
    }
}
