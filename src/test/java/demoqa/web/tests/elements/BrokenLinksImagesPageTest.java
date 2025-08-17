package demoqa.web.tests.elements;

import demoqa.pages.elements.BrokenLinksImagesPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksImagesPageTest extends BaseTest {

    private static final String EXPECTED_HEADER = "Broken Links - Images";
    private static final String EXPECTED_VALID_IMAGE_TEXT = "Valid image";
    private static final String EXPECTED_BROKEN_IMAGE_TEXT = "Broken image";
    private static final String EXPECTED_VALID_LINK_TEXT = "Valid Link";
    private static final String EXPECTED_CLICK_HERE_VALID_LINK_TEXT = "Click Here for Valid Link";
    private static final String EXPECTED_BROKEN_LINK_TEXT = "Broken Link";
    private static final String EXPECTED_CLICK_HERE_BROKEN_LINK_TEXT = "Click Here for Broken Link";
    private static final String EXPECTED_VALID_LINK_URL = "https://demoqa.com/";
    private static final String EXPECTED_BROKEN_LINK_URL = "https://the-internet.herokuapp.com/status_codes/500";

    private static final String BROKEN_URL = "broken";
    private BrokenLinksImagesPage brokenLinksImagesPage;

    @BeforeMethod
    public void goToBrokenLInksImagesPage() {
        navigateToUrl(BROKEN_URL);
        brokenLinksImagesPage = new BrokenLinksImagesPage(driver);
    }

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        // Arrange
        // Act
        String actualHeaderText = brokenLinksImagesPage.getHeaderText();
        String actualClickHereValidLinkText = brokenLinksImagesPage.getClickHereValidLinkText();
        String actualBrokenImageText = brokenLinksImagesPage.getBrokenImageText();
        String actualValidLinkText = brokenLinksImagesPage.getValidLinkText();
        String actualValidImageText = brokenLinksImagesPage.getValidImageText();
        String actualBrokenLinkText = brokenLinksImagesPage.getBrokenLinkText();
        String actualClickHereBrokenLinkText = brokenLinksImagesPage.getClickHereBrokenLinkText();

        // Assert
        softAssert.assertEquals(actualHeaderText, EXPECTED_HEADER, "\nWrong header text.\n");
        softAssert.assertEquals(actualClickHereValidLinkText, EXPECTED_CLICK_HERE_VALID_LINK_TEXT, "\nWrong click link text.\n");
        softAssert.assertEquals(actualBrokenImageText, EXPECTED_BROKEN_IMAGE_TEXT, "\nWrong image text.\n");
        softAssert.assertEquals(actualValidLinkText, EXPECTED_VALID_LINK_TEXT, "\nWrong link text.\n");
        softAssert.assertEquals(actualValidImageText, EXPECTED_VALID_IMAGE_TEXT, "\nWrong valid image text.\n");
        softAssert.assertEquals(actualBrokenLinkText, EXPECTED_BROKEN_LINK_TEXT, "\nWrong broken link text.\n");
        softAssert.assertEquals(actualClickHereBrokenLinkText, EXPECTED_CLICK_HERE_BROKEN_LINK_TEXT, "\nWrong click link text.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on click here for valid link")
    public void ClickOnClickHereForValidLink() {
        // Arrange
        // Act
        brokenLinksImagesPage.ClickOnClickHereValidLink();
        String currentUrl = brokenLinksImagesPage.getCurrentUrl();

        // Assert
        softAssert.assertEquals(currentUrl, EXPECTED_VALID_LINK_URL, "\nWrong url is shown.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on click here for broken link")
    public void ClickOnClickHereForBrokenLink() {
        // Arrange
        // Act
        brokenLinksImagesPage.clickOnClickHereBrokenLink();
        String currentUrl = brokenLinksImagesPage.getCurrentUrl();

        // Assert
        softAssert.assertEquals(currentUrl, EXPECTED_BROKEN_LINK_URL, "\nWrong url is shown.\n");
        softAssert.assertAll();
    }
}
