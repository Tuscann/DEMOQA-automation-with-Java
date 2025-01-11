package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinksPageTests extends BaseTest {

    @Test(enabled = true)
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

        Assert.assertEquals(actualLinksHeader, expectedLinksHeader, "\nDifferent Header text.\n");
        Assert.assertEquals(actualFollowingLinksWillOpenNewTab, expectedFollowingLinksWillOpenNewTab, "\nDifferent new tab text.\n");
        Assert.assertEquals(actualHomeText, expectedHomeText, "\nDifferent home text.\n");
        Assert.assertEquals(actualFollowingLinksWillSendAnApiCall, expectedFollowingLinksWillSendAnApiCall, "\nDifferent api call text.\n");
        Assert.assertEquals(actualCreatedText, expectedCreatedText, "\nDifferent created text.\n");
        Assert.assertEquals(actualNoContentText, expectedNoContentText, "\nDifferent no content text.\n");
        Assert.assertEquals(actualMovedText, expectedMovedText, "\nDifferent moved text\n");
        Assert.assertEquals(actualBadRequestText, expectedBadRequestText, "\nDifferent bad request text.\n");
        Assert.assertEquals(actualUnauthorizedText, expectedUnauthorizedText, "\nDifferent Unauthorized text.\n");
        Assert.assertEquals(actualForbiddenText, expectedForbiddenText, "\nDifferent Forbidden text.\n");
        Assert.assertEquals(actualNotFoundText, expectedNotFoundText, "\nDifferent NotFound text.\n");
    }

    @Test(enabled = true)
    public void OpenNewTabFromSimpleLink() {
        navigateToUrl("links");
        linksPage.clickSimpleTab();

        String urlNewTab = linksPage.getUrl();
        String expectedUrlNewTab = "https://demoqa.com/";

        Assert.assertEquals(urlNewTab, expectedUrlNewTab, "\n Actual & Expected New Tab Url Do Not Match.\n");
    }

    @Test(enabled = true)
    public void OpenNewTabFromDynamicLink() {
        navigateToUrl("links");
        linksPage.clickDynamicLink();

        String urlNewTab = linksPage.getUrl();
        String expectedUrlNewTab = "https://demoqa.com/";

        Assert.assertEquals(urlNewTab, expectedUrlNewTab,
                "\n Actual & Expected New Tab Url Do Not Match.\n");
    }

    @Test(enabled = true)
    public void ClickOnkCreatedLink() {
        navigateToUrl("links");
        linksPage.clickCreatedRequestLink();
        String actualResponseText = linksPage.getResponse();

        Assert.assertTrue(actualResponseText.contains("201")
                        && actualResponseText.contains("Created"),
                "\n Link has responded with staus" + actualResponseText +
                        ")\n and status text Created \n");
    }

    @Test(enabled = true)
    public void ClickOnNoContentLink() {
        navigateToUrl("links");
        linksPage.clickNoContentRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("204")
                        && actualResponse.contains("No Content"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test(enabled = true)
    public void ClickOnMovedLink() {
        navigateToUrl("links");
        linksPage.clickMovedRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("301")
                        && actualResponse.contains("Moved Permanently"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test(enabled = true)
    public void ClickOnBadRequestLink() {
        navigateToUrl("links");
        linksPage.clickBadRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("400")
                        && actualResponse.contains("Bad Request"),
                "\n Actual Response (" + actualResponse +
                        ")\n Does Not Contain '400' and 'Bad Request' \n");
    }

    @Test(enabled = true)
    public void ClickOnUnAuthorizedLink() {
        navigateToUrl("links");
        linksPage.clickUnauthorizedRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("401")
                        && actualResponse.contains("Unauthorized"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test(enabled = true)
    public void ClickOnForbiddenLink() {
        navigateToUrl("links");
        linksPage.clickForbiddenRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("403")
                        && actualResponse.contains("Forbidden"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test(enabled = true)
    public void ClickOnNotFoundLink() {
        navigateToUrl("links");
        linksPage.clickNotFoundRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("404")
                        && actualResponse.contains("Not Found"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }
}
