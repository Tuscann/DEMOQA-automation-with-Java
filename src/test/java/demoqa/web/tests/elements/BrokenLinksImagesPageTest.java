package demoqa.web.tests.elements;

import demoqa.pages.elements.BrokenLinksImagesPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.Test;

public class BrokenLinksImagesPageTest extends BaseTest {
    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        // Arrange
        navigateToUrl("broken");
        BrokenLinksImagesPage brokenLinksImagesPage = new BrokenLinksImagesPage(driver);

        String expectedHeader = "Broken Links - Images";
        String expectedValidImageText = "Valid image";
        String expectedBrokenImageText = "Broken image";
        String expectedValidLinkText = "Valid Link";
        String expectedClickHereValidLinkText = "Click Here for Valid Link";
        String expectedBrokenLinkText = "Broken Link";
        String expectedClickHereBrokenLinkText = "Click Here for Broken Link";

        // Act
        String actualHeaderText = brokenLinksImagesPage.getHeaderText();
        String actualClickHereValidLinkText = brokenLinksImagesPage.getClickHereValidLinkText();
        String actualBrokenImageText = brokenLinksImagesPage.getBrokenImageText();
        String actualValidLinkText = brokenLinksImagesPage.getValidLinkText();
        String actualValidImageText = brokenLinksImagesPage.getValidImageText();
        String actualBrokenLinkText = brokenLinksImagesPage.getBrokenLinkText();
        String actualClickHereBrokenLinkText = brokenLinksImagesPage.getClickHereBrokenLinkText();

        // Assert
        softAssert.assertEquals(actualHeaderText, expectedHeader, "\nWrong header text.\n");
        softAssert.assertEquals(actualClickHereValidLinkText, expectedClickHereValidLinkText, "\nWrong click link text.\n");
        softAssert.assertEquals(actualBrokenImageText, expectedBrokenImageText, "\nWrong image text.\n");
        softAssert.assertEquals(actualValidLinkText, expectedValidLinkText, "\nWrong link text.\n");
        softAssert.assertEquals(actualValidImageText, expectedValidImageText, "\nWrong valid image text.\n");
        softAssert.assertEquals(actualBrokenLinkText, expectedBrokenLinkText, "\nWrong broken link text.\n");
        softAssert.assertEquals(actualClickHereBrokenLinkText, expectedClickHereBrokenLinkText, "\nWrong click link text.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on click here for valid link")
    public void ClickOnClickHereForValidLink() {
        // Arrange
        navigateToUrl("broken");
        BrokenLinksImagesPage brokenLinksImagesPage = new BrokenLinksImagesPage(driver);
        String expectedUrl = "https://demoqa.com/";

        // Act
        brokenLinksImagesPage.ClickOnClickHereValidLink();
        String currentUrl = brokenLinksImagesPage.getCurrentUrl();

        // Assert
        softAssert.assertEquals(currentUrl, expectedUrl, "\nWrong url is shown.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on click here for broken link")
    public void ClickOnClickHereForBrokenLink() {
        // Arrange
        navigateToUrl("broken");
        BrokenLinksImagesPage brokenLinksImagesPage = new BrokenLinksImagesPage(driver);
        String expectedUrl = "https://the-internet.herokuapp.com/status_codes/500";

        // Act
        brokenLinksImagesPage.clickOnClickHereBrokenLink();
        String currentUrl = brokenLinksImagesPage.getCurrentUrl();

        // Assert
        softAssert.assertEquals(currentUrl, expectedUrl, "\nWrong url is shown.\n");
        softAssert.assertAll();
    }
}
