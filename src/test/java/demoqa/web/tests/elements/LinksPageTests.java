package demoqa.web.tests.elements;

import demoqa.pages.elements.LinksPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.Test;

public class LinksPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        // Arrange
        navigateToUrl("links");

        LinksPage linksPage = new LinksPage(driver);

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

        softAssert.assertEquals(actualLinksHeader, expectedLinksHeader, "\nDifferent Header text.\n");
        softAssert.assertEquals(actualFollowingLinksWillOpenNewTab, expectedFollowingLinksWillOpenNewTab, "\nDifferent new tab text.\n");
        softAssert.assertEquals(actualHomeText, expectedHomeText, "\nDifferent home text.\n");
        softAssert.assertEquals(actualFollowingLinksWillSendAnApiCall, expectedFollowingLinksWillSendAnApiCall, "\nDifferent api call text.\n");
        softAssert.assertEquals(actualCreatedText, expectedCreatedText, "\nDifferent created text.\n");
        softAssert.assertEquals(actualNoContentText, expectedNoContentText, "\nDifferent no content text.\n");
        softAssert.assertEquals(actualMovedText, expectedMovedText, "\nDifferent moved text\n");
        softAssert.assertEquals(actualBadRequestText, expectedBadRequestText, "\nDifferent bad request text.\n");
        softAssert.assertEquals(actualUnauthorizedText, expectedUnauthorizedText, "\nDifferent Unauthorized text.\n");
        softAssert.assertEquals(actualForbiddenText, expectedForbiddenText, "\nDifferent Forbidden text.\n");
        softAssert.assertEquals(actualNotFoundText, expectedNotFoundText, "\nDifferent NotFound text.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Open new tab from simple link")
    public void OpenNewTabFromSimpleLink() {
        // Arrange
        navigateToUrl("links");
        LinksPage linksPage = new LinksPage(driver);

        linksPage.clickSimpleTab();

        String urlNewTab = linksPage.getUrl();
        String expectedUrlNewTab = "https://demoqa.com/";

        softAssert.assertEquals(urlNewTab, expectedUrlNewTab, "\n Actual & Expected New Tab Url Do Not Match.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Open new tab from dynamic link")
    public void OpenNewTabFromDynamicLink() {
        // Arrange
        navigateToUrl("links");
        LinksPage linksPage = new LinksPage(driver);

        linksPage.clickDynamicTab();

        String urlNewTab = linksPage.getUrl();
        String expectedUrlNewTab = "https://demoqa.com/";

        softAssert.assertEquals(urlNewTab, expectedUrlNewTab,
                "\n Actual & Expected New Tab Url Do Not Match.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on created link")
    public void ClickOnkCreatedLink() {
        // Arrange
        navigateToUrl("links");
        LinksPage linksPage = new LinksPage(driver);

        linksPage.clickCreatedLink();
        String actualResponseText = linksPage.getResponse();

        softAssert.assertTrue(actualResponseText.contains("201")
                        && actualResponseText.contains("Created"),
                "\n Link has responded with staus" + actualResponseText +
                        ")\n and status text Created \n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on no content link")
    public void ClickOnNoContentLink() {
        // Arrange
        navigateToUrl("links");
        LinksPage linksPage = new LinksPage(driver);

        linksPage.clickNoContentRequestLink();
        String actualResponse = linksPage.getResponse();

        softAssert.assertTrue(actualResponse.contains("204")
                        && actualResponse.contains("No Content"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on moved link")
    public void ClickOnMovedLink() {
        // Arrange
        navigateToUrl("links");
        LinksPage linksPage = new LinksPage(driver);

        linksPage.clickMovedLink();
        String actualResponse = linksPage.getResponse();

        softAssert.assertTrue(actualResponse.contains("301")
                        && actualResponse.contains("Moved Permanently"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on bad request link")
    public void ClickOnBadRequestLink() {
        // Arrange
        navigateToUrl("links");
        LinksPage linksPage = new LinksPage(driver);

        linksPage.clickBadRequestLink();
        String actualResponse = linksPage.getResponse();

        softAssert.assertTrue(actualResponse.contains("400")
                        && actualResponse.contains("Bad Request"),
                "\n Actual Response (" + actualResponse +
                        ")\n Does Not Contain '400' and 'Bad Request' \n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on unauthorized link")
    public void ClickOnUnAuthorizedLink() {
        // Arrange
        navigateToUrl("links");
        LinksPage linksPage = new LinksPage(driver);

        linksPage.clickUnauthorizedLink();
        String actualResponse = linksPage.getResponse();

        softAssert.assertTrue(actualResponse.contains("401")
                        && actualResponse.contains("Unauthorized"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on forbidden link")
    public void ClickOnForbiddenLink() {
        // Arrange
        navigateToUrl("links");
        LinksPage linksPage = new LinksPage(driver);

        linksPage.clickForbiddenLink();
        String actualResponse = linksPage.getResponse();

        softAssert.assertTrue(actualResponse.contains("403")
                        && actualResponse.contains("Forbidden"),
                "\n Link has responded with status" + actualResponse +
                        ")\n and status text Created \n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Click on not found link")
    public void ClickOnNotFoundLink() {
        // Arrange
        navigateToUrl("links");
        LinksPage linksPage = new LinksPage(driver);

        linksPage.clickNotFoundLink();
        String actualResponse = linksPage.getResponse();

        softAssert.assertTrue(actualResponse.contains("404")
                        && actualResponse.contains("Not Found"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
        softAssert.assertAll();
    }
}
