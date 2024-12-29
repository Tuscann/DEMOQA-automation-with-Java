package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementsPageTests extends BaseTest {
    @Test
    public void CheckAllNinePagesLinks() {
        navigateToUrl("elements");

        String actualString = "Please select an item from left to start practice.";
        String expectedString = elementsPage.getText();
        Assert.assertEquals(expectedString, actualString);

        String expectedUrl = "https://demoqa.com/text-box";
        elementsPage.clickTextBox();
        String actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/checkbox";
        elementsPage.clickCheckBox();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/radio-button";
        elementsPage.clickRadioButton();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/webtables";
        elementsPage.clickWebTables();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/buttons";
        elementsPage.clickButtons();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/links";
        elementsPage.clickLinks();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/broken";
        elementsPage.clickBrokenLinksImages();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/upload-download";
        elementsPage.clickUploadAndDownload();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        expectedUrl = "https://demoqa.com/dynamic-properties";
        elementsPage.clickDynamicProperties();
        actualUrl = elementsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
