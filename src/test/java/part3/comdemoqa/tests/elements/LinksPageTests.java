package part3.comdemoqa.tests.elements;

import com.pages.demo.pages.elements.LinksPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class LinksPageTests extends BaseTest {
    @Test
    public void ClickLinkBadRequest() {
        LinksPage webTablePage = homePage.goToElements().clickLinks();
        webTablePage.clickBadRequestLink();
        String actualResponse = webTablePage.getResponse();

        Assert.assertTrue(actualResponse.contains("400")
                        && actualResponse.contains("Bad Request"),
                "\n Actual Response (" + actualResponse +
                        ")\n Does Not Contain '400' and 'Bad Request' \n");
    }

    @Test
    public void ClickLinkCreatedRequest() {
        var webTablePage = homePage.goToElements().clickLinks();
        webTablePage.clickCreatedRequestLink();
        String actualResponse = webTablePage.getResponse();

        Assert.assertTrue(actualResponse.contains("201")
                        && actualResponse.contains("Created"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void ClickLinkMovedRequest() {
        var webTablePage = homePage.goToElements().clickLinks();
        webTablePage.clickMovedRequestLink();
        String actualResponse = webTablePage.getResponse();

        Assert.assertTrue(actualResponse.contains("301")
                        && actualResponse.contains("Moved Permanently"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void ClickLinkNoContentRequest() {
        var webTablePage = homePage.goToElements().clickLinks();
        webTablePage.clickNoContentRequestLink();
        String actualResponse = webTablePage.getResponse();

        Assert.assertTrue(actualResponse.contains("204")
                        && actualResponse.contains("No Content"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void ClickLinkAuthorizedRequest() {
        var webTablePage = homePage.goToElements().clickLinks();
        webTablePage.clickUnauthorizedRequestLink();
        String actualResponse = webTablePage.getResponse();

        Assert.assertTrue(actualResponse.contains("401")
                        && actualResponse.contains("Unauthorized"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void ClickLinkForbiddenRequest() {
        var webTablePage = homePage.goToElements().clickLinks();
        webTablePage.clickForbiddenRequestLink();
        String actualResponse = webTablePage.getResponse();

        Assert.assertTrue(actualResponse.contains("403")
                        && actualResponse.contains("Forbidden"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void ClickLinkNotFoundRequest() {
        LinksPage webTablePage = homePage.goToElements().clickLinks();
        webTablePage.clickNotFoundRequestLink();
        String actualResponse = webTablePage.getResponse();

        Assert.assertTrue(actualResponse.contains("404")
                        && actualResponse.contains("Not Found"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }

    @Test
    public void ClickOpenNewTabSameWindow() {
        LinksPage webTablePage = homePage.goToElements().clickLinks();
        webTablePage.clickNewHomeTab();

        String urlNewTab = webTablePage.getUrl();
        String expectedUrlNewTab = "https://demoqa.com/";

        Assert.assertEquals(urlNewTab, expectedUrlNewTab,
                "\n Actual & Expected New Tab Url Do Not Match \n");
    }
}
