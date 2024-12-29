package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinksPageTests extends BaseTest {

    @Test
    public void VerifyAllTextOnPage() {
        navigateToUrl("links");

        String expectedLinksHeader = "Links";
        String expectedFollowingLinksWillOpenNewTab = "Following links will open new tab";
        String expectedHomeText = "Home";
        // Dynamic name can not be checked
        String expectedFollowingLinksWillSendAnApiCall = "Following links will send an api call";
        String expectedCreatedText = "Created";
        String expectedNoContentText = "No Content";
        String expectedMovedText = "Moved";
        String expectedBadRequestText = "Bad Request";
        String expectedUnauthorizedText = "Unauthorized";
        String expectedForbiddenText = "Forbidden";
        String expectedNotFoundText = "Not Found";

        String actualLinksHeader = linksPage.getLinksText();
        String actualFollowingLinksWillOpenNewTab = linksPage.getNewTabText();
        String actualHomeText = linksPage.getSimpleLinkText();
        String actualFollowingLinksWillSendAnApiCall = linksPage.getApiCallText();
        String actualCreatedText = linksPage.getCreatedRequestLinkText();
        String actualNoContentText = linksPage.getNoContentRequestLinkText();
        String actualMovedText = linksPage.getMovedRequestLinkText();
        String actualBadRequestText = linksPage.getBadRequestLinkText();
        String actualUnauthorizedText = linksPage.getUnauthorizedRequestLinkText();
        String actualForbiddenText = linksPage.getForbiddenRequestLinkText();
        String actualNotFoundText = linksPage.getNotFoundRequestLinkText();

        Assert.assertEquals(actualLinksHeader, expectedLinksHeader, "Different Header text");
        Assert.assertEquals(actualFollowingLinksWillOpenNewTab, expectedFollowingLinksWillOpenNewTab, "Different new tab text");
        Assert.assertEquals(actualHomeText, expectedHomeText, "Different home text");
        Assert.assertEquals(actualFollowingLinksWillSendAnApiCall, expectedFollowingLinksWillSendAnApiCall, "Different api call text");
        Assert.assertEquals(actualCreatedText, expectedCreatedText, "Different created text");
        Assert.assertEquals(actualNoContentText, expectedNoContentText, "Different no content text");
        Assert.assertEquals(actualMovedText, expectedMovedText, "Different moved text");
        Assert.assertEquals(actualBadRequestText, expectedBadRequestText, "Different bad request text");
        Assert.assertEquals(actualUnauthorizedText, expectedUnauthorizedText, "Different Unauthorized text");
        Assert.assertEquals(actualForbiddenText, expectedForbiddenText, "Different Forbidden text");
        Assert.assertEquals(actualNotFoundText, expectedNotFoundText, "Different NotFound text");
    }

    @Test
    public void ClickOnLinkCreatedRequest() {
        navigateToUrl("links");
        linksPage.clickCreatedRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("201")
                        && actualResponse.contains("Created"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void ClickOnLinkNoContentRequest() {
        navigateToUrl("links");
        linksPage.clickNoContentRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("204")
                        && actualResponse.contains("No Content"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void ClickOnLinkMovedRequest() {
        navigateToUrl("links");
        linksPage.clickMovedRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("301")
                        && actualResponse.contains("Moved Permanently"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void ClickOnLinkBadRequest() {
        navigateToUrl("links");
        linksPage.clickBadRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("400")
                        && actualResponse.contains("Bad Request"),
                "\n Actual Response (" + actualResponse +
                        ")\n Does Not Contain '400' and 'Bad Request' \n");
    }

    @Test
    public void ClickOnLinkUnAuthorizedRequest() {
        navigateToUrl("links");
        linksPage.clickUnauthorizedRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("401")
                        && actualResponse.contains("Unauthorized"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void ClickOnLinkForbiddenRequest() {
        navigateToUrl("links");
        linksPage.clickForbiddenRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("403")
                        && actualResponse.contains("Forbidden"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void ClickOnLinkNotFoundRequest() {
        navigateToUrl("links");
        linksPage.clickNotFoundRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("404")
                        && actualResponse.contains("Not Found"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void OpenNewTabFromSimpleLink() {
        navigateToUrl("links");
        linksPage.clickSimpleTab();

        String urlNewTab = linksPage.getUrl();
        String expectedUrlNewTab = "https://demoqa.com/";

        Assert.assertEquals(urlNewTab, expectedUrlNewTab,
                "\n Actual & Expected New Tab Url Do Not Match \n");
    }

    @Test
    public void OpenNewTabDynamicLink() {
        navigateToUrl("links");
        linksPage.clickDynamicLink();

        String urlNewTab = linksPage.getUrl();
        String expectedUrlNewTab = "https://demoqa.com/";

        Assert.assertEquals(urlNewTab, expectedUrlNewTab,
                "\n Actual & Expected New Tab Url Do Not Match \n");
    }
}
