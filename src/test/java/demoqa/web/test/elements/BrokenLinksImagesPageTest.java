package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrokenLinksImagesPageTest extends BaseTest {
    @Test(enabled = true)
    public void VerifyAllTextOnPage() {
        navigateToUrl("broken");

        String expectedHeader = "Broken Links - Images";
        String expectedValidImageText = "Valid image";
        String expectedBrokenImageText = "Broken image";
        String expectedValidLinkText = "Valid Link";
        String expectedClickHereValidLinkText = "Click Here for Valid Link";
        String expectedBrokenLinkText = "Broken Link";
        String expectedClickHereBrokenLinkText = "Click Here for Broken Link";

        String actualHeaderText = brokenLinksImagesPage.getHeaderText();
        String actualClickHereValidLinkText = brokenLinksImagesPage.getClickHereValidLinkText();
        String actualBrokenImageText = brokenLinksImagesPage.getBrokenImageText();
        String actualValidLinkText = brokenLinksImagesPage.getValidLinkText();
        String actualValidImageText = brokenLinksImagesPage.getValidImageText();
        String actualBrokenLinkText = brokenLinksImagesPage.getBrokenLinkText();
        String actualClickHereBrokenLinkText = brokenLinksImagesPage.getClickHereBrokenLinkText();

        Assert.assertEquals(actualHeaderText, expectedHeader, "Wrong header text");
        Assert.assertEquals(actualClickHereValidLinkText, expectedClickHereValidLinkText, "Wrong click link text");
        Assert.assertEquals(actualBrokenImageText, expectedBrokenImageText, "Wrong image text");
        Assert.assertEquals(actualValidLinkText, expectedValidLinkText, "Wrong link text");
        Assert.assertEquals(actualValidImageText, expectedValidImageText, "Wrong valid image text");
        Assert.assertEquals(actualBrokenLinkText, expectedBrokenLinkText, "Wrong broken link text");
        Assert.assertEquals(actualClickHereBrokenLinkText, expectedClickHereBrokenLinkText, "Wrong click link text");
    }

    @Test(enabled = true)
    public void ClickOnClickHereForValidLink() {
        navigateToUrl("broken");

        brokenLinksImagesPage.ClickOnClickHereValidLink();

        String expectedUrl = "https://demoqa.com/";
        String currentUrl = brokenLinksImagesPage.getCurrentUrl();

        Assert.assertEquals(currentUrl, expectedUrl, "\nWrong url is shown.\n");
    }

    @Test(enabled = true)
    public void ClickOnClickHereForBrokenLink() {
        navigateToUrl("broken");

        brokenLinksImagesPage.ClickOnClickHereBrokenLink();

        String expectedUrl = "https://the-internet.herokuapp.com/status_codes/500";
        String currentUrl = brokenLinksImagesPage.getCurrentUrl();

        Assert.assertEquals(currentUrl, expectedUrl, "\nWrong url is shown.\n");
    }
}
