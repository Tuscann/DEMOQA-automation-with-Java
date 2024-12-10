package part3.comdemoqa.tests.elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class BrokenLinksImagesPageTest extends BaseTest {
    @Test
    public void CheckAllTextOnPage() {
        navigateToUrl("broken");

        String expectedValidImageText = "Valid image";
        String expectedBrokenImageText = "Broken image";
        String expectedValidLinkText = "Valid Link";
        String expectedClickHereValidLinkText = "Click Here for Valid Link";
        String expectedBrokenLinkText = "Broken Link";
        String expectedClickHereBrokenLinkText = "Click Here for Broken Link";

        String actualClickHereValidLinkText = brokenLinksImagesPage.getClickHereValidLinkText();
        String actualBrokenImageText = brokenLinksImagesPage.getBrokenImageText();
        String actualValidLinkText = brokenLinksImagesPage.getValidLinkText();
        String actualValidImageText = brokenLinksImagesPage.getValidImageText();
        String actualBrokenLinkText = brokenLinksImagesPage.getBrokenLinkText();
        String actualClickHereBrokenLinkText = brokenLinksImagesPage.getClickHereBrokenLinkText();

        Assert.assertEquals(actualClickHereValidLinkText, expectedClickHereValidLinkText);
        Assert.assertEquals(actualBrokenImageText, expectedBrokenImageText);
        Assert.assertEquals(actualValidLinkText, expectedValidLinkText);
        Assert.assertEquals(actualValidImageText, expectedValidImageText);
        Assert.assertEquals(actualBrokenLinkText, expectedBrokenLinkText);
        Assert.assertEquals(actualClickHereBrokenLinkText, expectedClickHereBrokenLinkText);
    }

    @Test
    public void ClickOnClickHereForValidLink() {
        navigateToUrl("broken");

        brokenLinksImagesPage.ClickOnClickHereValidLink();

        String expectedUrl = "https://demoqa.com/";
        String currentUrl = brokenLinksImagesPage.getCurrentUrl();

        Assert.assertEquals(currentUrl, expectedUrl);
    }

    @Test
    public void ClickOnClickHereForBrokenLink() {
        navigateToUrl("broken");

        brokenLinksImagesPage.ClickOnClickHereBrokenLink();

        String expectedUrl = "https://the-internet.herokuapp.com/status_codes/500";
        String currentUrl = brokenLinksImagesPage.getCurrentUrl();

        Assert.assertEquals(currentUrl, expectedUrl);
    }
}
