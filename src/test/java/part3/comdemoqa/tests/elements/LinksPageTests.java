package part3.comdemoqa.tests.elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class LinksPageTests extends BaseTest {
    @Test
    public void ClickLinkBadRequest() {
        navigateToUrl("links");
        linksPage.clickBadRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("400")
                        && actualResponse.contains("Bad Request"),
                "\n Actual Response (" + actualResponse +
                        ")\n Does Not Contain '400' and 'Bad Request' \n");
    }

    @Test
    public void ClickLinkCreatedRequest() {
        navigateToUrl("links");
        linksPage.clickCreatedRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("201")
                        && actualResponse.contains("Created"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void ClickLinkMovedRequest() {
        navigateToUrl("links");
        linksPage.clickMovedRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("301")
                        && actualResponse.contains("Moved Permanently"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void ClickLinkNoContentRequest() {
        navigateToUrl("links");
        linksPage.clickNoContentRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("204")
                        && actualResponse.contains("No Content"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void ClickLinkAuthorizedRequest() {
        navigateToUrl("links");
        linksPage.clickUnauthorizedRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("401")
                        && actualResponse.contains("Unauthorized"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void ClickLinkForbiddenRequest() {
        navigateToUrl("links");
        linksPage.clickForbiddenRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("403")
                        && actualResponse.contains("Forbidden"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void ClickLinkNotFoundRequest() {
        navigateToUrl("links");
        linksPage.clickNotFoundRequestLink();
        String actualResponse = linksPage.getResponse();

        Assert.assertTrue(actualResponse.contains("404")
                        && actualResponse.contains("Not Found"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void ClickOpenNewTabSameWindow() {
        navigateToUrl("links");
        linksPage.clickNewHomeTab();

        String urlNewTab = linksPage.getUrl();
        String expectedUrlNewTab = "https://demoqa.com/";

        Assert.assertEquals(urlNewTab, expectedUrlNewTab,
                "\n Actual & Expected New Tab Url Do Not Match \n");
    }
}
