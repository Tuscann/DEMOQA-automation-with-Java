package demoqa.web.tests.elements;

import demoqa.pages.elements.BrokenLinksImagesPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksImagesPageTest extends BaseTest {

    // URL Constants
    private static final String BROKEN_URL = "broken";
    private static final String EXPECTED_VALID_LINK_URL = "https://demoqa.com/";
    private static final String EXPECTED_BROKEN_LINK_URL = "https://the-internet.herokuapp.com/status_codes/500";
    
    // Text Constants
    private static final String EXPECTED_HEADER = "Broken Links - Images";
    private static final String EXPECTED_VALID_IMAGE_TEXT = "Valid image";
    private static final String EXPECTED_BROKEN_IMAGE_TEXT = "Broken image";
    private static final String EXPECTED_VALID_LINK_TEXT = "Valid Link";
    private static final String EXPECTED_CLICK_HERE_VALID_LINK_TEXT = "Click Here for Valid Link";
    private static final String EXPECTED_BROKEN_LINK_TEXT = "Broken Link";
    private static final String EXPECTED_CLICK_HERE_BROKEN_LINK_TEXT = "Click Here for Broken Link";
    
    // Error Message Constants
    private static final String HEADER_TEXT_MISMATCH = "Header text mismatch";
    private static final String CLICK_HERE_VALID_LINK_TEXT_MISMATCH = "Click here valid link text mismatch";
    private static final String BROKEN_IMAGE_TEXT_MISMATCH = "Broken image text mismatch";
    private static final String VALID_LINK_TEXT_MISMATCH = "Valid link text mismatch";
    private static final String VALID_IMAGE_TEXT_MISMATCH = "Valid image text mismatch";
    private static final String BROKEN_LINK_TEXT_MISMATCH = "Broken link text mismatch";
    private static final String CLICK_HERE_BROKEN_LINK_TEXT_MISMATCH = "Click here broken link text mismatch";
    private static final String VALID_LINK_URL_MISMATCH = "Valid link URL mismatch after navigation";
    private static final String BROKEN_LINK_URL_MISMATCH = "Broken link URL mismatch after navigation";
    
    private BrokenLinksImagesPage brokenLinksImagesPage;

    @BeforeMethod
    public void goToBrokenLInksImagesPage() {
        navigateToUrl(BROKEN_URL);
        brokenLinksImagesPage = new BrokenLinksImagesPage(driver);
    }

    @Test(enabled = true, description = "Verify all static text elements on the broken links and images page")
    public void verifyAllTextOnPage() {
        // Arrange & Act        
        String actualHeaderText = brokenLinksImagesPage.getHeaderText();
        String actualClickHereValidLinkText = brokenLinksImagesPage.getClickHereValidLinkText();
        String actualBrokenImageText = brokenLinksImagesPage.getBrokenImageText();
        String actualValidLinkText = brokenLinksImagesPage.getValidLinkText();
        String actualValidImageText = brokenLinksImagesPage.getValidImageText();
        String actualBrokenLinkText = brokenLinksImagesPage.getBrokenLinkText();
        String actualClickHereBrokenLinkText = brokenLinksImagesPage.getClickHereBrokenLinkText();

        // Assert
        softAssert.assertEquals(actualHeaderText, EXPECTED_HEADER, HEADER_TEXT_MISMATCH);
        softAssert.assertEquals(actualClickHereValidLinkText, EXPECTED_CLICK_HERE_VALID_LINK_TEXT, CLICK_HERE_VALID_LINK_TEXT_MISMATCH);
        softAssert.assertEquals(actualBrokenImageText, EXPECTED_BROKEN_IMAGE_TEXT, BROKEN_IMAGE_TEXT_MISMATCH);
        softAssert.assertEquals(actualValidLinkText, EXPECTED_VALID_LINK_TEXT, VALID_LINK_TEXT_MISMATCH);
        softAssert.assertEquals(actualValidImageText, EXPECTED_VALID_IMAGE_TEXT, VALID_IMAGE_TEXT_MISMATCH);
        softAssert.assertEquals(actualBrokenLinkText, EXPECTED_BROKEN_LINK_TEXT, BROKEN_LINK_TEXT_MISMATCH);
        softAssert.assertEquals(actualClickHereBrokenLinkText, EXPECTED_CLICK_HERE_BROKEN_LINK_TEXT, CLICK_HERE_BROKEN_LINK_TEXT_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click on valid link and verify navigation to correct URL")
    public void clickOnClickHereForValidLink() {
        // Arrange & Act
        brokenLinksImagesPage.ClickOnClickHereValidLink();
        String currentUrl = brokenLinksImagesPage.getCurrentUrl();

        // Assert
        softAssert.assertEquals(currentUrl, EXPECTED_VALID_LINK_URL, VALID_LINK_URL_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click on broken link and verify navigation to error page URL")
    public void clickOnClickHereForBrokenLink() {
        // Arrange & Act
        brokenLinksImagesPage.clickOnClickHereBrokenLink();
        String currentUrl = brokenLinksImagesPage.getCurrentUrl();

        // Assert
        softAssert.assertEquals(currentUrl, EXPECTED_BROKEN_LINK_URL, BROKEN_LINK_URL_MISMATCH);
        softAssert.assertAll();
    }
}
